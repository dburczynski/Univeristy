
import java.util.LinkedList;

public class Huffman {
    private Node root;
    private int suma;
    public Huffman() {
        this.root = null;
        this.suma = 0;
    }

    public int getSuma() {
        return suma;
    }





    public Node getRoot() {
        return root;
    }

    public Node findMin(LinkedList<Node> list) {
        Node minNode = null;
        if(list.isEmpty()) {
            return null;
        }
        minNode = list.getFirst();
        for(Node n: list) {
            if(n.getAmount() < minNode.getAmount())
                minNode = n;
        }
        list.remove(minNode);
        return minNode;
    }

    public void Huffify(LinkedList<Node> list){
        int size = list.size();
        while(list.size() > 1){
            Node x = findMin(list);
            Node y = findMin(list);
            Node z = new Node(Character.MIN_VALUE);
            z.setLeftChild(x);
            z.setRightChild(y);
            z.setAmount(x.getAmount()+y.getAmount());
            list.add(z);
        }
        this.root = findMin(list);
    }

    public void setHuffCode(Node n,String x) {
        if(n == null)
            return;

        n.setHuffCode(x);
        setHuffCode(n.getLeftChild(),x+"0");
        setHuffCode(n.getRightChild(),x+"1");

    }

    public void printNodes(Node n) {

       if(n == null)
           return;
       if(n.getLetter() != Character.MIN_VALUE) {
           System.out.println("char : " + "\"" + n.getLetter() + "\"" + " | " + n.getAmount() + " | " + n.getHuffCode());
           this.suma += n.getHuffCode().length()*n.getAmount();
       }
       printNodes(n.getLeftChild());
       printNodes(n.getRightChild());
    }

    public void textLength() {
        System.out.println("\n\n\n Length of text = "+root.getAmount());
    }

}
