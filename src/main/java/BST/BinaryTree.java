package BST;

public class BinaryTree<T extends Comparable<T>> {


    Node<T> root;

    private Node<T> addRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<T>(value);
        }

        if (value.compareTo(current.data) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.data) > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public void add(T value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node<T> current, T value) {
        if (current == null) {
            return false;
        }
        if (value == current.data) {
            return true;
        }
        return value.compareTo(current.data) < 0
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(T value) {
        return containsNodeRecursive(root, value);
    }

    private Node<T> deleteRecursive(Node<T> current, T value) {
        if (current == null) {
            return null;
        }

        if (value == current.data) {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            T smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;

        }

        if (value.compareTo(current.data) < 0) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private T findSmallestValue(Node<T> root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    public void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(Node<T> node) {
        if (node != null) {
            printTree(node.left);
            for (int i = 0; i < countDepth(node); i++) {
                System.out.print(".");
            }

            System.out.println(" " + node.data);
            printTree(node.right);
        }
    }

    public int countDepth() {
        return countDepth(root);
    }

    private int countDepth(Node node) {
        if (node != null) {
            int right_depth = countDepth(node.right);
            int left_depth = countDepth(node.left);
            return left_depth > right_depth ? left_depth + 1 : right_depth + 1;
        }
        return 0;
    }

    private static class Node<T extends Comparable<T>> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.data = value;
            right = null;
            left = null;
        }
    }
}
