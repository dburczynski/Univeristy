import java.util.*;

public class BinaryTree {

    private ArrayList<Object1> lista;
    private ArrayList<Integer> boolList;
    private Object1 root;
    public BinaryTree() {
        
        this.lista = new ArrayList<Object1>();
        this.boolList = new ArrayList<Integer>();    
        this.root = null;
    }

    public void treeInsert(Object1 o) {
        Object1 y = null;
        Object1 x = this.root;
        Object1 z = this.treeSearch(this.root, o.getNumber());
        if(z == null) {
    
        
        while(x != null) {
            y = x;
            if(o.getNumber() < x.getNumber()) {
                x = x.getLeft();
            }
            else {
                x = x.getRight();
            }
            o.setParent(y);
        }
        if(y == null) {
            this.root = o;
        }
        else {
            if(o.getNumber() < y.getNumber()) {
                y.setLeft(o);
            }
            else {
                y.setRight(o);
            }
        }
        
        
        }
        else {
            z.increaseAmount();
        }
    }

    public Object1 treeMinimum(Object1 o) {

        while(o.getLeft() != null) {
            o = o.getLeft();
        }
        return o;
    }

    public Object1 treeSuccessor(Object1 o) {
        Object1 y;
        if(o.getRight() != null) {
            return this.treeMinimum(o.getRight());
        }
        y = o.getParent();
        while( y != null && o == y.getRight()) {
            o = y;
            y = y.getParent();
        }
        return y;
    }

    public Object1 treeDelete(Object1 o) {
        Object1 x;
        Object1 y = null;
        Object1 z = this.treeSearch(this.root, o.getNumber());
        if(z != null ) {
            if(z.getAmount() == 0) {
                if(z.getLeft() == null || z.getRight() == null) {
                    y = z;
                }
                else {
                    y = this.treeSuccessor(z);
                }
                if(y.getLeft() != null) {
                x = y.getLeft(); 
                }
                else {
                    x = y.getRight();
                }
                if( x != null ) {
                    x.setParent(y.getParent());
                }

                if(y.getParent() == null) {
                    this.root = x;
                }
                else {
                    if(y == y.getParent().getLeft()) {
                        y.getParent().setLeft(x);
                    }
                    else {
                        y.getParent().setRight(x);
                    }
                }

                if( y != z ) {
                    o.setNumber(y.getNumber());
                }
                
                }
            else {
                z.decreaseAmount();
            }
        }
        
        return y;
    }

        public Object1 treeSearch(Object1 o, int k) {
            while(o != null && k != o.getNumber()) {
                if(k < o.getNumber()){
                    o = o.getLeft();
                }
                else {
                    o = o.getRight();
                }
            }
        
        return o;
    }

    

    public void treePrint(Object1 o) {
        if(o != null) {
            this.treePrint(o.getRight());
            System.out.print(o.getNumber()+" ");
            this.treePrint(o.getLeft());
            
        }
        
    }


    public static void main(String args[]) {
        BinaryTree z = new BinaryTree();
        
        Object1 a = new Object1(0);
        Object1 b = new Object1(1);
        Object1 c = new Object1(2);
        Object1 d = new Object1(3);
        Object1 e = new Object1(4);
        Object1 f = new Object1(5);
        Object1 g = new Object1(6);
        Object1 h = new Object1(7);
        Object1 i = new Object1(8);



        z.treeInsert(a);
        z.treeInsert(b);
        z.treeInsert(c);
        z.treeInsert(f);
        z.treeInsert(g);
        z.treeInsert(h);
        z.treeInsert(i);
        z.treeInsert(d);
        z.treeInsert(e);

        z.treePrint(a);
        System.out.println("\n");
        
        Object1 k = new Object1(8);
        z.treeInsert(k);
        z.treeInsert(k);
        z.treePrint(a);
        System.out.println("\n");
        z.treeDelete(k);
        z.treePrint(a);
        System.out.println("\n");
        z.treeDelete(k);
        z.treePrint(a);
        System.out.println("\n");
        z.treeDelete(k);
        z.treePrint(a);
        System.out.println("\n");


        
       
        // z.treeInsert(k);
        // z.treePrint(a);
        // System.out.println("\n"+i.getAmount()+"\n");
        // z.treeDelete(k);
        // z.treePrint(a);
        // System.out.println("\n"+i.getAmount()+"\n");
        // z.treeDelete(k);
        // z.treePrint(a);
        // System.out.println("\n"+i.getAmount()+"\n");

        //z.treeSearch(a,10);
        

        
    }
}