import java.util.List;
import java.util.Map;

class RelativeDistance {

    private final Map<String, List<String>> familyTree;

    RelativeDistance(Map<String, List<String>> familyTree) {
        this.familyTree = familyTree;
    }

    int degreeOfSeparation(String personA, String personB) {
        int degreesOfSeparation = 0;

        for (Map.Entry<String, List<String>> entry : familyTree.entrySet()) {
            List<String> v = entry.getValue();
            if (v.containsAll(List.of(personA, personB))) {
                return 1;
            }
        }


        List<String> relations = familyTree.get(personA);
        if (relations != null) {
            if (relations.contains(personB)) {
                return 1;
            }
            for (int i = 0; i < relations.size(); i++) {
                String nextOffSpring = relations.get(i);
                int nextLevel = degreeOfSeparation(nextOffSpring, personB);
                if (nextLevel == -1) {
                    //do nowt
                } else {
                    return 1 + nextLevel;
                }
            }
        }


        return -1;
    }
}
