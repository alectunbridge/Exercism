import java.util.*;

class RelativeDistance {

    private final Map<String, Set<String>> relationMap = new HashMap<>();

    RelativeDistance(Map<String, List<String>> familyTree) {

        familyTree.forEach((parent, children) -> relationMap.put(parent, new HashSet<>(children)));

        familyTree.forEach((parent, children) -> {
            for (String child : children) {
                relationMap.computeIfAbsent(child, _ -> new HashSet<>()).add(parent);
                relationMap.get(child).addAll(children);
            }
        });


    }

    int degreeOfSeparation(String personA, String personB) {
        Set<String> visitedPeople = new HashSet<>();
        List<String> peopleToVisit = new ArrayList<>();
        Map<String, Integer> distances = new HashMap<>();
        for (String person : relationMap.keySet()) {
            distances.put(person, 0);
        }

        peopleToVisit.add(personA);

        while (!peopleToVisit.isEmpty()) {
            String currentPerson = peopleToVisit.removeFirst();

            for (String relation : relationMap.get(currentPerson)) {
                if (!visitedPeople.contains(relation)) {
                    visitedPeople.add(relation);
                    distances.put(relation, distances.get(currentPerson) + 1);
                    if (relation.equals(personB)) {
                        return distances.get(personB);
                    }
                    peopleToVisit.add(relation);
                }
            }
        }


        return -1;
    }
}
