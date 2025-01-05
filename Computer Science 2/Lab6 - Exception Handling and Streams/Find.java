import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Find {
    
    public static String[] getLinesWithWordForFile(String file, String word) {
        // Write the word searching method here, return all lines that contain the word.
        // Make sure you return the full line that contains the word and that you return
        // ALL lines that contain the word

        ArrayList<String> list = new ArrayList<>();
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                if (line.contains(word)) {
                    list.add(line);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("ERROR");
        }
        String[] array = list.toArray(new String[0]);
        //System.out.println(Arrays.toString(array));

        //return list.toArray(new String[0]);
        return array;
    }

    public static void main(String[] args) {
        //Use this method to test your program
        for (int i = 1; i < args.length; i++) {
            System.out.println(Arrays.toString(getLinesWithWordForFile(args[i], args[0])));
        }
    }
}
