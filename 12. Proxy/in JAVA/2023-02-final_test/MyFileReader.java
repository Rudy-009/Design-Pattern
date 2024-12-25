import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {
    private String filename;

    public MyFileReader(String filename) {
        this.filename = filename;
    }

    List<String> readLines() {
        try {
            List<String> lst = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                lst.add(line);
                line = reader.readLine();
            }
            return lst;
        }
        catch (FileNotFoundException e) {
            System.out.printf("%s is not available.\n", filename);
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
