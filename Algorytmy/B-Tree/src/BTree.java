public class BTree {
    Node root;
    int degree;

    public BTree(int degree) {
        this.root = new Node(3,true);
        this.degree = degree;
    }

    public void traverse() {
        if(this.root != null)
             this.root.traverse();
    }

    public Node search(int k) {
        if(this.root == null)
            return null;
        else
            return this.root.search(k);
    }

    public void bInsert(int k) {
        Node r = this.root;

        if (r.getNKeys() == 2 * this.degree - 1) {
            Node s = new Node(this.degree, false);
            this.root = s;
            s.setNKeys(0);
            s.setChild(r, 0);
            this.splitChild(s,0);
            this.insertNonFull(s, k);
        } else
            this.insertNonFull(r,k);

    }

    private void splitChild(Node x, int i) {

        Node y = x.getChild(i);

        Node z = new Node(this.degree, y.isLeaf());



        for (int j = 0; j < this.degree - 1; j++) {
//            System.out.print(j+" ");
            z.setNKeys(z.getNKeys()+1  );
            z.setKey(j, y.getKey(j + this.degree));
//            System.out.println(y.getKey(j+this.degree));
        }


        if (!y.isLeaf())
            for (int j = 0; j < this.degree; j++) {
                z.setChild(y.getChild(j + this.degree), j);
            }


        y.setNKeys(this.degree - 1);

        for (int j = x.getNKeys(); j > i; j--)
            x.setChild(x.getChild(j), j+1);
        x.setChild(z, i+1);



        for (int j = x.getNKeys() - 1; j >= i; j--) {
            x.setKey(j + 1,x.getKey(j));

        }
        x.setKey(i, y.getKey(this.degree - 1));
        x.setNKeys(x.getNKeys() + 1);



    }

    private void insertNonFull(Node x, int k) {
        int i = x.getNKeys()-1;
        if(x.isLeaf()) {
            while(i >= 0 && k < x.getKey(i)){
                x.setKey(i+1,x.getKey(i));
                i = i - 1;
            }
            x.setKey(i+1,k);
            x.setNKeys(x.getNKeys()+1);
        }
        else {
            while( i >= 0 && k < x.getKey(i)) {
                i= i - 1;
            }
            i = i + 1;
            if(x.getChild(i).getNKeys() == 2*this.degree - 1) {
                this.splitChild(x, i);
                if(k > x.getKey(i)) {
                    i = i + 1;
                }
            }
            this.insertNonFull(x.getChild(i),k);
        }
    }

    public void remove(int k) {
        if(this.root == null) {
            System.out.println("Puste!");
            return;
        }
        this.root.remove(k,degree);
        if(root.getNKeys() == 0) {
            Node tmp = root;
            if(root.isLeaf()) {
                root = null;
            }
            else
                root = root.getChild(0);
        }
        return;
    }
}
