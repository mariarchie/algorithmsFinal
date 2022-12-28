public class TreePrint {

    public static void Print(Node node) {
        if (node != null) {
            System.out.println(node.value + " " + node.colour);
            Print(node.left);
            Print(node.right);
        }
    }
}
