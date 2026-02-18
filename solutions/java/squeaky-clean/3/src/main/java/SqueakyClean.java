class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder result = new StringBuilder();
        boolean toUpper = false;
        for (char c : identifier.toCharArray()) {
            if (toUpper) {
                result.append(Character.toUpperCase(c));
                toUpper = false;
                continue;
            }
            String characterMappedToString = switch (c) {
                case ' ' -> "_";
                case '-' -> { toUpper = true; yield ""; }
                case '0' -> "o";
                case '1' -> "l";
                case '3' -> "e";
                case '4' -> "a";
                case '7' -> "t";
                default -> Character.isAlphabetic(c) ? String.valueOf(c) : "";
            };
            result.append(characterMappedToString);
        }
        return result.toString();
    }
}
