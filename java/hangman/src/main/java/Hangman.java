import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class Hangman {

    Observable<Output> play(Observable<String> words, Observable<String> letters) {
        return Observable.merge(
                words.map(GameEvent::word),
                letters.map(GameEvent::letter))
            .scan(Output.empty(), Hangman::apply)
            .distinctUntilChanged()
            .skip(1)
            .filter(output -> output.secret != null);
    }

    private static Output apply(Output output, GameEvent event) {
        if (event.isWord()) {
            return start(event.word);
        }
        if (output.secret == null || output.status != Status.PLAYING) {
            return output;
        }

        String letter = event.letter;
        if (output.guess.contains(letter) || output.misses.contains(letter)) {
            throw new IllegalArgumentException("Letter " + letter + " was already played");
        }

        if (contains(output.secret, letter)) {
            return reveal(output, letter);
        }
        return miss(output, letter);
    }

    private static Output start(String word) {
        List<String> discovered = new ArrayList<>(word.length());
        for (int index = 0; index < word.length(); index++) {
            discovered.add("_");
        }
        return new Output(word, String.join("", discovered), Set.of(), Set.of(), List.of(), Status.PLAYING);
    }

    private static Output reveal(Output output, String letter) {
        List<String> discovered = new ArrayList<>(Arrays.asList(output.discovered.split("")));
        Set<String> guess = new LinkedHashSet<>(output.guess);
        guess.add(letter);

        String[] secretLetters = output.secret.split("");
        for (int index = 0; index < secretLetters.length; index++) {
            if (secretLetters[index].equals(letter)) {
                discovered.set(index, letter);
            }
        }

        Status nextStatus = discovered.stream().noneMatch("_"::equals) ? Status.WIN : Status.PLAYING;
        return new Output(output.secret, String.join("", discovered), guess, output.misses, output.parts, nextStatus);
    }

    private static Output miss(Output output, String letter) {
        Set<String> misses = new LinkedHashSet<>(output.misses);
        misses.add(letter);
        List<Part> parts = new ArrayList<>(output.parts);
        parts.add(Part.values()[parts.size()]);
        Status nextStatus = parts.size() == Part.values().length ? Status.LOSS : Status.PLAYING;
        return new Output(output.secret, output.discovered, output.guess, misses, parts, nextStatus);
    }

    private static boolean contains(String word, String letter) {
        return Arrays.stream(word.split(""))
            .anyMatch(letter::equals);
    }

    private static final class GameEvent {
        private final String word;
        private final String letter;

        private GameEvent(String word, String letter) {
            this.word = word;
            this.letter = letter;
        }

        private static GameEvent word(String word) {
            return new GameEvent(word, null);
        }

        private static GameEvent letter(String letter) {
            return new GameEvent(null, letter);
        }

        private boolean isWord() {
            return word != null;
        }
    }

}