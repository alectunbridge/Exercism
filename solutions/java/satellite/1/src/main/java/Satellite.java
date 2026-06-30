import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Satellite {
    public Tree treeFromTraversals(List<Character> preorderInput, List<Character> inorderInput) {
        if (preorderInput.size() != inorderInput.size()) {
            throw new IllegalArgumentException("traversals must have the same length");
        }

        if (!preorderInput.containsAll(inorderInput)) {
            throw new IllegalArgumentException("traversals must have the same elements");
        }

        if (new HashSet<>(preorderInput).size() != preorderInput.size()) {
            throw new IllegalArgumentException("traversals must contain unique items");
        }


        return new Tree(buildNodes(preorderInput, inorderInput));
    }

    private Node buildNodes(List<Character> preorderInput, List<Character> inorderInput) {
        if (preorderInput.isEmpty()) {
            return null;
        }
        Node currentNode = new Node(preorderInput.getFirst());
        int currentNodeIndex = inorderInput.indexOf(currentNode.value);

        List<Character> leftNodes = inorderInput.subList(0, currentNodeIndex);
        List<Character> rightNodes = inorderInput.subList(currentNodeIndex + 1, inorderInput.size());

        currentNode.left = buildNodes(preorderInput.subList(1, leftNodes.size() + 1), leftNodes);
        currentNode.right = buildNodes(preorderInput.subList(leftNodes.size() + 1, preorderInput.size()), rightNodes);

        return currentNode;
    }
}
