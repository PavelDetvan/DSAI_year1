import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    /**
     * method to clean the word - delete all punctuation marks and put the word into lower case
     * @param word to be cleaned
     * @return clean word
     */
    public String clean(String word) {
        word = word.toLowerCase();
        word = word.replaceAll("\\p{Punct}", "");
        return word;
    }

    /**
     * method to process line and insert the words from the line into a trie
     * @param line to be processed
     * @param lineNumber number of the current line
     * @param trie trie to which we want to insert
     */
    public void processLine(String line, int lineNumber, Trie trie) {
        // TODO: Implement this
        line = clean(line);
        String[] split = line.split(" ");
        for (String word : split) {
            trie.insert(word, lineNumber);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Main <input_file>");
            System.exit(1);
        }
        String inputFile = args[0];
        Trie trie = new Trie();
        Main main = new Main();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int lineNumber = 1;
            // Read the text line by line
            while ((line = br.readLine()) != null) {
                main.processLine(line, lineNumber, trie);
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }
        // Test your implementation here.
        // i.e.  trie.search(“my”);
        
        System.out.println(Arrays.toString(trie.search("times")));
     }
}
