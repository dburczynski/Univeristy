public class Node {
    private String color;
    private Key key;
    private Node parent,leftChild,rightChild;

    public Node(int key) {
        this.key = new Key(key);
        this.color = "red";
        this.parent = null;
        this.leftChild = new Node(this);
        this.rightChild = new Node(this);

    }
    public Node(Node parent) {
        this.key = null;
        this.color = "black";
        this.parent = parent;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void setKey(int key) {
        this.key.setKey(key);
    }
    public Key getKey() {
        return this.key;
    }
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    public Node getParent() {
        return this.parent;
    }
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }
    public Node getLeftChild() {
        return this.leftChild;
    }
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
    public Node getRightChild() {
        return this.rightChild;
    }
}
