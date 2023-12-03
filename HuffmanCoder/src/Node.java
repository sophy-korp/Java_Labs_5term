import java.io.Serializable;

class Node implements Comparable<Node>, Serializable {
    int frequency;
    char character;
    Node left, right;

    public Node(int frequency, char character, Node left, Node right) {
        this.frequency = frequency;
        this.character = character;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}