package ex;

class Spisok {

    class Element {
        int data;
        Element next;

        Element(int x) {
            data = x;
            next = null;
        }
    }


    Element first;

    void prin() {

        Element cur = first;

        while (cur != null) {
            System.out.print(cur.data + "\t");
            cur = cur.next;
        }

    }

    boolean insert(int data) {

        Element cur = first;

        if (first == null) {
            first = new Element(data);
            return true;
        }

        while (cur.next  != null) {
            cur = cur.next;
        }

        cur.next = new Element(data);
        return true;
    }

}
