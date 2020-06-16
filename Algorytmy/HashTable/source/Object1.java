public class Object1 {
    private int key;
    private String word;
    private Object1 next;

    public Object1(String word, int m, int j) {
        this.word = word;
        this.key = this.getHash(m, j);
        this.next = null;
    }

    public int getHash(int m,int j) {
        int hashNumber = 0;
        for(int i = 0; i < this.word.length(); i = i + 2) {
            if(i < this.word.length()-1)
                hashNumber = hashNumber ^ (256*(int)this.word.charAt(i) + (int)this.word.charAt(i+1));
            else
                hashNumber = hashNumber ^ (256*(int)this.word.charAt(i));
        }
        return ((hashNumber % m)+j*(hashNumber%(m-3)))%m;

    }
    public String toString() {
        return "Key: "+this.key+" Word: "+this.word;
    }
    public int getKey() {
        return this.key;
    }
}
