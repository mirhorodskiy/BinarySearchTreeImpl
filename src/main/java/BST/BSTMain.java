package BST;

import RBTree.Triangle;

public class BSTMain {
    public static void main(String[] args) {
//        BinaryTree<Integer> bt = new BinaryTree<>();
//        bt.add(6);
//        bt.add(4);
//        bt.add(8);
//        bt.add(3);
//        bt.add(5);
//        bt.add(7);
//        bt.add(9);
//
//        bt.printTree();
//
//        bt.delete(6);
//
//        System.out.println("-------------------------------");
//        bt.printTree();
//
//        System.out.println("=====================");

        BinaryTree<Triangle> tr = new BinaryTree<>();

        Triangle triangle1 = new Triangle(3, -3, 7, -3, 5, 5);
        Triangle triangle3 = new Triangle(2, -1, 4, -1, 3, 3);


        tr.add(triangle1);
        tr.add(triangle3);

        tr.add(new Triangle(2, -1, 4, -1, 3, 10));
        tr.add(new Triangle(2, -1, 4, -1, 3, 6));
        tr.add(new Triangle(2, -1, 4, -1, 3, 7));
        tr.add(new Triangle(2, -1, 4, -1, 3, 5));
        tr.add(new Triangle(2, -1, 4, -1, 3, 13));
        tr.add(new Triangle(2, -1, 4, -1, 3, 8));
        tr.add(new Triangle(2, -1, 4, -1, 3, 9));
        tr.add(new Triangle(2, -1, 4, -1, 3, 11));
        tr.add(new Triangle(2, -1, 4, -1, 3, 15));
        tr.add(new Triangle(2, -1, 4, -1, 3, 14));
        tr.add(new Triangle(2, -1, 4, -1, 3, 12));
        tr.add(new Triangle(3, -1, 4, -1, 3, 16));

        tr.printTree();

        tr.delete(triangle1);
        System.out.println("deleting triangle with perimeter " + triangle1.perimeter());

        tr.printTree();
    }
}
