public class Node {
    int value;
    Node left, right;
    Colour colour;

    public Node(int value) {
        this.value = value;
        this.colour = Colour.RED;
    }
}