package RBTree;

public class RedBlackNode<T extends Comparable<T>> {
    public static boolean RED = false;
    public static boolean BLACK = true;

    public boolean color;
    public RedBlackNode<T> left;
    public RedBlackNode<T> right;
    public RedBlackNode<T> parent;
    public T data;

    public RedBlackNode(T data) {
        this.data = data;
        this.color = RED;
    }

    public void removeFromParent() {
        if (parent == null)
            return;

        if (parent.left == this)
            parent.left = null;
        else if (parent.right == this)
            parent.right = null;

        this.parent = null;
    }

    public void setLeft(RedBlackNode<T> child) {

        if (left != null)
            left.parent = null;

        if (child != null) {
            child.removeFromParent();
            child.parent = this;
        }

        this.left = child;
    }

    public void setRight(RedBlackNode<T> child) {
        if (right != null) {
            right.parent = null;
        }

        if (child != null) {
            child.removeFromParent();
            child.parent = this;
        }

        this.right = child;
    }

    public static boolean isRed(RedBlackNode<?> node) {
        return getColor(node) == RED;
    }

    public static boolean isBlack(RedBlackNode<?> node) {
        return !isRed(node);
    }

    public static void setColor(RedBlackNode<?> node, boolean color) {
        if (node == null)
            return;
        node.color = color;
    }

    public static boolean getColor(RedBlackNode<?> node) {
        return node == null ? BLACK : node.color;
    }

    public static void swapColor(RedBlackNode<?> node) {
        if (node == null)
            return;

        node.color = !node.color;
    }

    public RedBlackNode<T> getGrandparent() {
        return (parent == null) ? null : parent.parent;
    }


    public RedBlackNode<T> getSibling() {
        if (parent != null) {
            if (this == parent.right)
                return parent.left;
            else
                return parent.right;
        }
        return null;
    }


    public RedBlackNode<T> getUncle() {
        if (parent != null) {
            return parent.getSibling();
        }
        return null;
    }


}

