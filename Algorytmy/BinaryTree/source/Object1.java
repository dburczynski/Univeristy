
public class Object1 {

    private int number;
    private Object1 left;
    private Object1 right;
    private Object1 parent;
    private int amount;
    
    public Object1(int number) {
        
        this.number = number;
        this.amount = 0;
    }

    public int getNumber() {
        return this.number;
    }
    public Object1 getParent() {
        return this.parent;
    }
    public Object1 getLeft() {
        return this.left;
    }
    public Object1 getRight() {
        return this.right;
    }
    public int getAmount() {
        return this.amount;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setParent(Object1 parent) {
        this.parent = parent;
    }
    public void setLeft(Object1 left) {
        this.left = left;
    }
    public void setRight(Object1 right) {
        this.right = right;
    }
    public void increaseAmount() {
        this.amount++;
    }
    public void decreaseAmount() {
        this.amount--;
    }
    

}
