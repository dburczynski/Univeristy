public class Main {
    public static void main(String[] args) {

        BTree b = new BTree(3);

        b.bInsert(10);
        b.bInsert(20);
        b.bInsert(5);
        b.bInsert(6);
        b.bInsert(12);
        b.bInsert(30);
        b.bInsert(7);
        b.bInsert(9);
        b.bInsert(9);
        b.bInsert(9);
        b.bInsert(9);
        b.bInsert(9);
        b.bInsert(9);
//
   b.traverse();
//

        b.remove(10);
    if(b.search(10) != null)
        System.out.println("FOUND!!!");

     else
          System.out.println("NOT FOUND!!!");

    // b.remove(6);
     b.traverse();

        if(b.search(6) != null)
            System.out.println("FOUND!!!");

        else
            System.out.println("NOT FOUND!!!");
    }
}
