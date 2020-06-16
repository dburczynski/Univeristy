import java.util.ArrayList;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Hashtable {
    private ArrayList<Object1> objects;
    private int wordCount = 0;
    private int amountOfInserts = 0;
    private int m;
    public Hashtable(int m) {
        this.objects = new ArrayList<Object1>(m);
        this.m = m;
    }
    public void initializeTable() {
        for(int i = 0 ; i < m; i++) {
             this.objects.add(null);
         }    
    }
    public void addObjects(double percentage){
        BufferedReader br;
        try {
            
            br = new BufferedReader(new FileReader("/home/darek/GitRepo/Algorytmy/HashTable2/source/names.txt"));
            String line = br.readLine();
            while (line != null && (double)wordCount/(double)m < percentage) {
                String s[] = line.split("\\s+");
                for(int i = 0; i < m; i++) {
                    amountOfInserts++;
                    Object1 tempObj = new Object1(s[1],m,i);
                    if(objects.get(tempObj.getKey()) == null) {
                        objects.set(tempObj.getKey(), tempObj);
                        wordCount++;
                        break;
                    }
                }   
                line = br.readLine();
            }
            br.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void printList() {
        for(int i = 0; i < m; i++) {
            if(objects.get(i) == null) {
                System.out.println("Key: "+i+" Word: null");
            }
            else {
                System.out.println(objects.get(i).toString());
            }
        }

     
        
    }
    public void testPrint() {
        System.out.println("Hashtable "+((double)wordCount/(double)m)*100+"% filled");
        System.out.println("Average amount of inserts per item: "+(double)amountOfInserts/(double)wordCount);
    }


    public static void main(String args[]) {
        System.out.println("Tablica kontrolna");
        Hashtable h = new Hashtable(20);
        h.initializeTable();
        h.addObjects(0.5);
        h.printList();
        System.out.println("\n");
        
        System.out.println("Rozmiar: 1000");
        Hashtable h2 = new Hashtable(1000);
        h2.initializeTable();
        h2.addObjects(1);
        h2.testPrint();
        System.out.println("\n");

        System.out.println("Rozmiar: 10000");
        Hashtable h3 = new Hashtable(10000);
        h3.initializeTable();
        h3.addObjects(0.75);
        h3.testPrint();
        System.out.println("\n");

        System.out.println("Rozmiar: 15000");
        Hashtable h4 = new Hashtable(15000);
        h4.initializeTable();
        h4.addObjects(0.5);
        h4.testPrint();





    }
}