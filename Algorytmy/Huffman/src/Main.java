import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {
        LinkedList<Node> list = new LinkedList<Node>();
        FileReader f =  new FileReader("C:\\Users\\derek\\GitRepo\\Algorytmy\\Huffman\\src\\Dane.txt");
        f.readFile(list);
        Huffman h = new Huffman();
        System.out.println(list.size());
        h.Huffify(list);
        h.setHuffCode(h.getRoot(),"");
        h.printNodes(h.getRoot());
        h.textLength();
        double x = h.getSuma();
        System.out.println(Math.ceil(x/8));



    }
}
