public class Node {
    int value;
    Node left, right;
    Color color;

    public Node(int value) {
        this.value = value;
        this.color = Color.RED;
    }
}