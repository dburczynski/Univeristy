
public class Node {

    private int keys[];
    private int nKeys;
    private Node[] children;
    private boolean leaf;

    public Node (int degree, boolean leaf) {

        this.leaf = leaf;
        this.keys = new int[2*degree-1];
        this.children = new Node[2*degree];
        this.nKeys = 0;

    }

    public Node search(int k) {
        int i = 0;

        while(i < this.getNKeys()-1 && k > this.getKey(i))
            i++;

        if(this.getKey(i) == k)
            return this;

        if(this.isLeaf() == true)
            return null;

        return this.getChild(i).search(k);
    }

    public void traverse() {
        for(int i = 0; i <= this.getNKeys(); i++) {
            if(this.isLeaf() == false)
                this.getChild(i).traverse();
        }
        for(int i = 0; i < this.getNKeys(); i++) {
            System.out.print(" "+this.getKey(i));
        }
        System.out.println("\t");
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
    public boolean isLeaf() {
        return this.leaf;
    }

    public void setNKeys(int n) {
        this.nKeys = n;
    }

    public int getNKeys() {
        return this.nKeys;
    }

    public Node getChild(int i) {
        return this.children[i];
    }

    public void setChild(Node n ,int i) {
        this.children[i] = n;
    }

    public void setKey(int i, int x){
        this.keys[i] = x;
    }

    public int getKey(int i) {
        return this.keys[i];
    }

    public int findKey(int k) {
        int idx = 0;
        while(idx < this.getNKeys() && this.getKey(idx) < k)
            ++idx;

        return idx;
    }

    public void remove(int k,int degree) {
        int idx = this.findKey(k);

        if(idx < this.getNKeys() && this.getKey(idx) == k){
            if(this.isLeaf())
                remLeaf(idx);
            else
                remNonLeaf(idx,degree);
        }
        else{
            if(this.isLeaf()) {
                System.out.println("The key doesnt exist");

                return;
            }

            boolean flag;

            if(idx==this.getNKeys())
                flag = true;
            else
                flag = false;

            if(this.getChild(idx).getNKeys() < degree)
                fill(idx,degree);

            if(flag && idx > this.getNKeys())
                this.getChild(idx-1).remove(k,degree);
            else
                this.getChild(idx).remove(k,degree);
        }
        return;
    }

    public void remLeaf(int idx) {
        for(int i = idx+1; i < this.getNKeys();++i)
            this.setKey(i-1,this.getKey(i));
        this.setNKeys(this.getNKeys()-1);
        return;
    }

    public void remNonLeaf(int idx,int degree) {
        int k = this.getKey(idx);

        if(this.getChild(idx).getNKeys() >= degree){
            int pred = getPred(idx);
            this.setKey(idx,pred);
            this.getChild(idx).remove(pred,degree);
        }
        else {
            if(this.getChild(idx+1).getNKeys() >= degree) {
                int succ = getSucc(idx);
                this.setKey(idx,succ);
                this.getChild(idx+1).remove(succ,degree);
            }

            else {
                this.merge(idx,degree);
                this.getChild(idx).remove(k,degree);
            }
        }
    }

    public int getPred(int idx) {
        Node curr = this.getChild(idx);
        while(!curr.isLeaf())
            curr = curr.getChild(curr.getNKeys());

        return curr.getKey(curr.getNKeys()-1);
    }

    public int getSucc(int idx) {
        Node curr = this.getChild(idx+1);
        while(!curr.isLeaf())
            curr = curr.getChild(0);

        return curr.getKey(0);
    }

    public void fill(int idx, int degree) {

        if(idx!=0 && this.getChild(idx-1).getNKeys()>= degree)
            this.borrowPrev(idx);

        else {
            if(idx != this.getNKeys() && this.getChild(idx+1).getNKeys() >= degree)
                borrowNext(idx);
            else {
                if(idx != this.getNKeys())
                    merge(idx,degree);
                else
                    merge(idx-1,degree);
            }
        }
        return;
    }

    public void borrowPrev(int idx) {
        Node child = this.getChild(idx);
        Node brother = this.getChild(idx-1);

        for(int i = child.getNKeys()-1; i>=0; --i)
            child.setKey(i+1,child.getKey(i));

        if(!child.isLeaf()){
            for(int i = child.getNKeys(); i >= 0; --i)
                child.setChild(child.getChild(i),i+1);
        }

        child.setKey(0,this.getKey(idx-1));

        if(!child.isLeaf())
            child.setChild(brother.getChild(brother.getNKeys()),0);

        this.setKey(idx-1,brother.getKey(brother.getNKeys()-1));

        child.setNKeys(child.getNKeys()+1);
        brother.setNKeys(brother.getNKeys()-1);

        return;
    }

    public void borrowNext(int idx) {
        Node child = this.getChild(idx);
        Node brother = this.getChild(idx+1);

        child.setChild(brother.getChild(0),child.getNKeys()+1);

        if(!child.isLeaf())
            child.setChild(brother.getChild(0),child.getNKeys()+1);

        this.setKey(idx,brother.getKey(0));

        for(int i = 1; i < brother.getNKeys(); ++i)
            brother.setKey(i-1,brother.getKey(i));

        if(!brother.isLeaf()) {
            for(int i = 1; i <= brother.getNKeys(); ++i)
                brother.setChild(brother.getChild(i),i-1);
        }

        child.setNKeys(child.getNKeys()+1);
        brother.setNKeys(brother.getNKeys()-1);

        return;
    }

    public void merge(int idx, int degree) {
        Node child = this.getChild(idx);
        Node brother = this.getChild(idx+1);

        child.setKey(degree-1,this.getKey(idx));

        for(int i = 0; i < brother.getNKeys(); ++i)
            child.setKey(i+degree,brother.getKey(i));

        if(!child.isLeaf()) {
            for(int i = 0; i <= brother.getNKeys(); ++i)
                child.setChild(brother.getChild(i),i+degree);
        }

        for (int i = idx+1; i < this.getNKeys(); ++i)
            this.setKey(i-1,this.getKey(i));

        for(int i = idx+2; i <= this.getNKeys(); ++i)
            this.setChild(this.getChild(i),i-1);

        child.setNKeys(child.getNKeys()+brother.getNKeys()+1);
        this.setNKeys(this.getNKeys()-1);
        return;
    }

}