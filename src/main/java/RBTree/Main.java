package RBTree;

public class Main {

    public static void main(String[] args) {
        RedBlackTree<Integer> rb = new RedBlackTree<>();
//        rb.insert(10);
//        rb.insert(20);
//        rb.insert(30);
//        rb.insert(40);
//        rb.insert(50);
//        rb.insert(60);
//        rb.insert(70);
//        rb.insert(80);
//        rb.insert(90);
//        rb.insert(100);
//        rb.insert(110);
//        rb.insert(120);

//        rb.insert(35);
//        rb.insert(9);
//        rb.insert(44);
//        rb.insert(19);
//        rb.insert(28);
//        rb.insert(17);
//        rb.insert(44);
//        rb.insert(75);
//        rb.insert(92);
//        rb.insert(39);
//        rb.insert(95);
//
//        rb.printTree();
//        System.out.println(rb.getSize());
//        System.out.println(rb.countDepth());
//
//        System.out.println("========================================");
//
        RBTree.RedBlackTree<RBTree.Triangle> tr = new RBTree.RedBlackTree<>();

        RBTree.Triangle triangle1 = new RBTree.Triangle(3, -3, 7, -3, 5, 5);
        RBTree.Triangle triangle3 = new RBTree.Triangle(2, -1, 4, -1, 3, 3);


        tr.insert(triangle1);
        tr.insert(triangle3);

        tr.insert(new RBTree.Triangle(2, -1, 4, -1, 3, 5));
        tr.insert(new RBTree.Triangle(2, -1, 4, -1, 3, 6));
        tr.insert(new RBTree.Triangle(2, -1, 4, -1, 3, 7));
        tr.insert(new RBTree.Triangle(2, -1, 4, -1, 3, 8));
        tr.insert(new RBTree.Triangle(2, -1, 4, -1, 3, 9));
        tr.insert(new RBTree.Triangle(2, -1, 4, -1, 3, 10));
        tr.insert(new RBTree.Triangle(2, -1, 4, -1, 3, 11));
        tr.insert(new RBTree.Triangle(2, -1, 4, -1, 3, 12));
        tr.insert(new RBTree.Triangle(2, -1, 4, -1, 3, 13));
        tr.insert(new RBTree.Triangle(2, -1, 4, -1, 3, 14));
        tr.insert(new RBTree.Triangle(2, -1, 4, -1, 3, 15));
        tr.insert(new RBTree.Triangle(3, -1, 4, -1, 3, 16));

        tr.printTree();
        System.out.println("Depth = " + tr.countDepth());
        System.out.println("Size = " + tr.getSize());
    }
}
