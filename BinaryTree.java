public class BinaryTree {

    Node root;
    public Node Root(){
        return this.root;
    }

    public Node Find(int value) {
        Node cur = root;
        while (cur != null) {
            if (cur.value == value) {
                return cur;
            }
            if (cur.value < value) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }

    public boolean Add(int value) {
        if (root != null) {
            boolean result = AddNode(root, value);
            root = Rotate(root);
            root.colour = Colour.BLACK;
            return result;
        } else {
            root = new Node(value);
            root.colour = Colour.BLACK;
            return true;
        }
    }

    public boolean AddNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.left != null) {
                    boolean result = AddNode(node.left, value);
                    node.left = Rotate(node.left);
                    return result;
                } else {
                    node.left = new Node(value);
                    node.left.colour = Colour.RED;
                    node.left.value = value;
                    return true;
                }
            } else {
                if (node.right != null) {
                    boolean result = AddNode(node.right, value);
                    node.right = Rotate(node.right);
                    return result;
                } else {
                    node.right = new Node(value);
                    return true;
                }
            }
        }
    }

    public Node Rotate (Node node) {
        Node result = node;
        boolean rotate;
        do {
            rotate = false;
            if (result.right != null && result.right.colour == Colour.RED &&
                    (result.left == null || result.left.colour == Colour.BLACK)) {
                rotate = true;
                result = RightSwap(result);
            }
            if (result.left != null && result.left.colour == Colour.RED &&
                    result.left.left != null && result.left.left.colour == Colour.RED) {
                rotate = true;
                result = LeftSwap(result);
            }
            if (result.left != null && result.left.colour == Colour.RED &&
                    result.right != null && result.right.colour == Colour.RED) {
                rotate = true;
                ColorSwap(result);
            }
        } while (rotate);
        return result;
    }

    public Node RightSwap(Node node) {
        Node right = node.right;
        Node middle = right.left;
        right.left = node;
        node.right = middle;
        right.colour = node.colour;
        node.colour = Colour.RED;
        return right;
    }

    public Node LeftSwap(Node node) {
        Node left = node.left;
        Node middle = left.right;
        left.right = node;
        node.left = middle;
        left.colour = node.colour;
        node.colour = Colour.RED;
        return left;
    }

    public void ColorSwap(Node node) {
        node.right.colour = Colour.BLACK;
        node.left.colour = Colour.BLACK;
        node.colour = Colour.RED;
    }
}
