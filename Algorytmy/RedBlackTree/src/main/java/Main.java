public class Main{

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        long startTime = System.currentTimeMillis();
        for(int i = 1; i <= 1000000; i++) {
            rbt.insert(new Node(i));
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime);

//        rbt.printTree(rbt.getRoot());
//        System.out.println("\n\nmax depth: "+rbt.findMaxDepth(rbt.getRoot()));
//        System.out.println("min depth: "+rbt.findMinDepth(rbt.getRoot()));
//        System.out.println("amount of red nodes: "+rbt.countRedNode(rbt.getRoot()));


        //rbt.search(9);
    }
}