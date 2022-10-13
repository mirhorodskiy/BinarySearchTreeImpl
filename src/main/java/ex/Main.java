package ex;

public class Main {

    public static void main(String[] args) {
        Spisok spisok = new Spisok();

        spisok.insert(5);
        spisok.insert(8);
        spisok.insert(2);
        spisok.insert(1);

        spisok.prin();
    }
}
