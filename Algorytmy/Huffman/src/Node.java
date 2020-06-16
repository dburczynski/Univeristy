public class Node {
    private char letter;
    private int amount;
    private Node leftChild;
    private Node rightChild;
    private String huffCode;

    public Node (char letter) {
        this.letter = letter;
        this.amount = 1;
        this.leftChild = null;
        this.rightChild = null;
        this.huffCode = "";
    }

    public char getLetter() {
        return letter;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getAmount() {
       return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void incrementAmount() {
        amount++;
    }
    public String getHuffCode() {
        return huffCode;
    }

    public void setHuffCode(String x) {
        this.huffCode += x;
    }
}
