import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

public class FileReader {
    File file;
    File InputStream ;

    public FileReader(String filename) {
        this.file = new File(filename);
        if(file.exists()) {
            System.out.println("File found!");
        }
        else{
            System.out.println("File not found");
        }
    }

    public void readFile(LinkedList<Node> list) {
        try {
            FileInputStream fis = new FileInputStream(file);
            char current;
            while(fis.available() > 0) {
                boolean ifExists = false;
                current = (char) fis.read();
                for(Node s: list) {
                    if(s.getLetter() == current) {
                        s.incrementAmount();
                        ifExists = true;
                    }
                }
                if(ifExists == false) {
                    list.add(new Node(current));
                }

            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
