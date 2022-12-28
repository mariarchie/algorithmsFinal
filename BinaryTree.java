public class BinaryTree {

    Node root;

    public Node GetRoot(){
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
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node(value);
            root.color = Color.BLACK;
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
                    node.left.color = Color.RED;
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
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)) {
                rotate = true;
                result = RightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.left.left != null && result.left.left.color == Color.RED) {
                rotate = true;
                result = LeftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED) {
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
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    public Node LeftSwap(Node node) {
        Node left = node.left;
        Node middle = left.right;
        left.right = node;
        node.left = middle;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }

    public void ColorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }
}
