public class RedBlackTree {
    private Node root;



    public RedBlackTree() {
        this.root = null;

    }

    public Node getRoot() {
        return this.root;
    }

    public void printTree(Node root) {
        if (this.root == null) {
            System.out.println("tree with nodeNode doesn't exist in tree!");
            return;
        } else {
            Node printNode = root;
            if (printNode.getKey() == null)
                return;
            System.out.print("\n" + printNode.getKey().getKey() + " color: " + printNode.getColor());
            if (printNode.getParent() != null)
                System.out.print(" parent: " + printNode.getParent().getKey().getKey());
            this.printTree(printNode.getLeftChild());
            this.printTree(printNode.getRightChild());
            return;
        }
    }

    public void search(int key) {
        int depthToSearch= 0;
        int amountofBlack= 0;
       Node tempNode = this.root;
        while (tempNode.getKey() != null && tempNode.getKey().getKey() != key) {
            depthToSearch++;
            if(tempNode.getColor().equals("black"))
                amountofBlack++;

            if(key < tempNode.getKey().getKey())
                tempNode = tempNode.getLeftChild();
            if(key >= tempNode.getKey().getKey())
                tempNode = tempNode.getRightChild();
        }
        tempNode = tempNode.getParent();
        if(tempNode.getKey().getKey() == key)
            System.out.println(tempNode.getColor()+" "+depthToSearch+" "+amountofBlack);


    }
    public int findMaxDepth(Node root) {
        if(root.getKey() == null)
            return 0;
        else {
            int leftDepth = this.findMaxDepth(root.getLeftChild());
            int rightDepth = this.findMaxDepth(root.getRightChild());

            if(leftDepth > rightDepth)
                return (leftDepth+1);
            else
                return (rightDepth+1);
        }
    }

    public int findMinDepth(Node root) {
        if(root.getKey() == null)
            return 0;

        if(root.getLeftChild().getKey() == null && root.getRightChild().getKey() == null)
            return 1;

        if(root.getLeftChild().getKey() == null)
            return this.findMinDepth(root.getRightChild())+1;
        if(root.getRightChild().getKey() == null)
            return this.findMinDepth(root.getLeftChild())+1;
        return Math.min(findMinDepth(root.getLeftChild()),findMinDepth(root.getRightChild())) +1;

    }

    public int countRedNode(Node root){
        if(root == null)
            return 0;
       if(root.getColor().equals("red")) {
           int left = this.countRedNode(root.getLeftChild());
           int right = this.countRedNode(root.getRightChild());
           return left + right + 1;
       }
       else {
           int left = this.countRedNode(root.getLeftChild());
           int right = this.countRedNode(root.getRightChild());
           return left + right;
       }


    }
    private void leftRotate(Node node) {

        Node tempNode = node.getParent();
        tempNode.setRightChild(node.getLeftChild());
        node.setLeftChild(tempNode);
        if(tempNode != this.root && tempNode == tempNode.getParent().getLeftChild())
            tempNode.getParent().setLeftChild(node);
        if(tempNode != this.root && tempNode == tempNode.getParent().getRightChild())
            tempNode.getParent().setRightChild(node);
        node.setParent(tempNode.getParent());
        tempNode.setParent(node);
    }

    private void rightRotate(Node node) {
        Node tempNode = node.getParent();
        tempNode.setLeftChild(node.getRightChild());
        node.setRightChild(tempNode);
        if(tempNode != this.root && tempNode == tempNode.getParent().getLeftChild())
            tempNode.getParent().setLeftChild(node);
        if(tempNode != this.root && tempNode == tempNode.getParent().getRightChild())
            tempNode.getParent().setRightChild(node);
        node.setParent(tempNode.getParent());
        tempNode.setParent(node);
    }

    public boolean bstInsert(Node insertedNode) {
        if (this.root == null) {
            this.root = insertedNode;
            this.root.setColor("black");
            return false;
        } else {

            Node iteratingNode = this.root;
            while (iteratingNode.getKey() != null) {
                if (insertedNode.getKey().getKey() < iteratingNode.getKey().getKey()) {
                    iteratingNode = iteratingNode.getLeftChild();
                } else {
                    iteratingNode = iteratingNode.getRightChild();
                }
            }
            insertedNode.setParent(iteratingNode.getParent());
            if (iteratingNode.getParent().getRightChild() == iteratingNode) {
                iteratingNode.getParent().setRightChild(insertedNode);
            } else {
                iteratingNode.getParent().setLeftChild(insertedNode);
            }
            return true;
        }
    }

    public void insert(Node insertedNode) {
        if(this.bstInsert(insertedNode)) {
            while(insertedNode != this.root && insertedNode.getParent().getColor().equals("red")) {
                if(insertedNode.getParent() == insertedNode.getParent().getParent().getLeftChild()) {
                    Node uncleNode = insertedNode.getParent().getParent().getRightChild();
                    if(uncleNode.getColor().equals("red")) {
                        insertedNode.getParent().setColor("black");
                        uncleNode.setColor("black");
                        insertedNode.getParent().getParent().setColor("red");
                        insertedNode = insertedNode.getParent().getParent();
                    }
                    else {
                        if(insertedNode == insertedNode.getParent().getRightChild()) {
                            this.leftRotate(insertedNode);
                            insertedNode = insertedNode.getLeftChild();
                        }
                        if(insertedNode == insertedNode.getParent().getLeftChild()) {
                            insertedNode.getParent().setColor("black");
                            insertedNode.getParent().getParent().setColor("red");
                            this.rightRotate(insertedNode.getParent());
                        }
                    }

                }
                if(insertedNode.getParent() == insertedNode.getParent().getParent().getRightChild()) {
                    Node uncleNode = insertedNode.getParent().getParent().getLeftChild();
                    if(uncleNode.getColor().equals("red")) {


                        insertedNode.getParent().setColor("black");
                        uncleNode.setColor("black");
                        insertedNode.getParent().getParent().setColor("red");
                        insertedNode = insertedNode.getParent().getParent();

                    }
                    else {
                        if(insertedNode == insertedNode.getParent().getLeftChild()) {
                            this.rightRotate(insertedNode);
                            insertedNode = insertedNode.getRightChild();
                        }
                        if(insertedNode == insertedNode.getParent().getRightChild()) {
                            insertedNode.getParent().setColor("black");
                            insertedNode.getParent().getParent().setColor("red");
                            this.leftRotate(insertedNode.getParent());
                        }
                    }

                }
                if(this.root.getParent() != null)
                    this.root = this.root.getParent();
                if(this.root.getColor().equals("red"))
                    this.root.setColor("black");
            }

      }
   }
}