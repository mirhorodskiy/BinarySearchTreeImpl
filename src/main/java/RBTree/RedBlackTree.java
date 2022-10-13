package RBTree;

public class RedBlackTree<T extends Comparable<T>> {
    private RedBlackNode<T> root;
    private int size = 0;

    public void insert(T data) {
        if (this.root == null) {
            this.root = new RedBlackNode<T>(data);
        } else {
            insert(this.root, data);
        }

        this.root.color = RedBlackNode.BLACK;
        this.size++;
    }

    private void insert(RedBlackNode<T> node, T item) {
        if (node.data.compareTo(item) >= 0) {
            if (node.left != null) {
                insert(node.left, item);
            } else {
                RedBlackNode<T> inserted = new RedBlackNode<T>(item);
                node.setLeft(inserted);
                balanceAfterInsert(inserted);
            }
        } else if (node.right != null) {
            insert(node.right, item);
        } else {
            RedBlackNode<T> inserted = new RedBlackNode<T>(item);
            node.setRight(inserted);
            balanceAfterInsert(inserted);
        }
    }

    private void balanceAfterInsert(RedBlackNode<T> node) {
        if (node == null || node == this.root || RedBlackNode.isBlack(node.parent)) {
            return;
        }
        if (RedBlackNode.isRed(node.getUncle())) {
            RedBlackNode.swapColor(node.parent);
            RedBlackNode.swapColor(node.getUncle());
            RedBlackNode.swapColor(node.getGrandparent());

            balanceAfterInsert(node.getGrandparent());
        } else if (node.getGrandparent().left == node.parent) {
            if (node.parent.right == node) {
                node = node.parent;
                rotateLeft(node);
            }
            RedBlackNode.setColor(node.parent, RedBlackNode.BLACK);
            RedBlackNode.setColor(node.getGrandparent(), RedBlackNode.RED);
            rotateRight(node.getGrandparent());
        } else if (node.getGrandparent().right == node.parent) {

            if (node.parent.left == node) {
                node = node.parent;
                rotateRight(node);
            }
            RedBlackNode.setColor(node.parent, RedBlackNode.BLACK);
            RedBlackNode.setColor(node.getGrandparent(), RedBlackNode.RED);
            rotateLeft(node.getGrandparent());
        }
    }

    private void rotateRight(RedBlackNode<T> node) {
        if (node.left == null) {
            return;
        }
        RedBlackNode<T> leftTree = node.left;
        node.setLeft(leftTree.right);
        if (node.parent == null) {
            this.root = leftTree;
        } else if (node.parent.left == node) {
            node.parent.setLeft(leftTree);
        } else {
            node.parent.setRight(leftTree);
        }
        leftTree.setRight(node);
    }

    private void rotateLeft(RedBlackNode<T> node) {
        if (node.right == null) {
            return;
        }
        RedBlackNode<T> rightTree = node.right;
        node.setRight(rightTree.left);
        if (node.parent == null) {
            this.root = rightTree;
        } else if (node.parent.left == node) {
            node.parent.setLeft(rightTree);
        } else {
            node.parent.setRight(rightTree);
        }
        rightTree.setLeft(node);
    }


    public void printTree() {
        printTree(this.root);
    }

    private void printTree(RedBlackNode<T> node) {
        if (node != null) {
            printTree(node.left);
            for (int i = 0; i < countDepth(node); i++) {
                System.out.print(".");
            }

            System.out.println(" " + node.data + " (" + node.color + ")");
            printTree(node.right);
        }
    }

    public RedBlackNode<T> find(T data) {
        return find(this.root, data);
    }

    private RedBlackNode<T> find(RedBlackNode<T> root, T data) {
        if (root == null) {
            return null;
        }
        if (root.data.compareTo(data) > 0) {
            return this.find(root.left, data);
        }
        if (root.data.compareTo(data) < 0) {
            return this.find(root.right, data);
        }
        return root;
    }

    public int countDepth() {
        return this.countDepth(root);
    }

    private int countDepth(RedBlackNode<T> node) {
        if (node != null) {
            int right_depth = countDepth(node.right);
            int left_depth = countDepth(node.left);
            return left_depth > right_depth ? left_depth + 1 : right_depth + 1;
        }
        return 0;
    }

    public int getSize() {
        return size;
    }

}