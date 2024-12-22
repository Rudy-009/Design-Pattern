import java.io.*;

public class Main {
    public static void main(String[] args) {
		try {
				FileReader fr = new FileReader("ReadMe.txt");
				BufferedReader br = new BufferedReader(fr);
				String line;
				
				while((line = br.readLine()) != null) {
					System.out.println(line);
				}
					
				fr.close();
				br.close();
		} catch(Exception e) {
				e.printStackTrace();
		}
	}
}