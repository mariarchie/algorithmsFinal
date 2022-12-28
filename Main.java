public class Main {

    public static void main(String[] args) {
        
        BinaryTree tree = new BinaryTree();

        tree.Add(27);
        TreePrint.Print(tree.GetRoot());

        tree.Add(13);
        System.out.println("------");
        TreePrint.Print(tree.GetRoot());

        tree.Add(114);
        System.out.println("------");
        TreePrint.Print(tree.GetRoot());

        tree.Add(205);
        System.out.println("------");
        TreePrint.Print(tree.GetRoot());

        tree.Add(16);
        System.out.println("------");
        TreePrint.Print(tree.GetRoot());
    }
}
