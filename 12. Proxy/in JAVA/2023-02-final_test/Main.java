//import java.util.ArrayList;
import java.util.List;

public class Main {
    private IWordsList[] wordsArray;
    private String filename;

    public Main(String filename) {
        this.filename = filename;
        wordsArray = new IWordsList['z' - 'a'];
    }

    public void createArray() {
        MyFileReader readFile = new MyFileReader(filename);
        List<String> lines = readFile.readLines();
        if (lines != null) {
            for (String line : lines) {
                String[] arr = line.split("[ \t\n\";,.?!]");
                for (String w : arr) {
                    if (!w.equals("")) {
                        w = w.toLowerCase();
                        char ch = w.charAt(0);
                        int idx = ch - 'a';
                        if (wordsArray[idx] == null) {
                            wordsArray[idx] = new ProxyWordsList(w);
                        }
                        else {
                            wordsArray[idx].add(w);
                        }
                    }
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i] != null) {
                System.out.printf("%c: ", 'a' + i);
                wordsArray[i].print();
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main("huckle.txt");
        m.createArray();
        m.print();
    }
}