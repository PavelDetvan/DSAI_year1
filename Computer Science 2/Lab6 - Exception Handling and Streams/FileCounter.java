import java.io.*;
import java.util.Scanner;

public class FileCounter {

    // int for the number of letters
    private static int chars = 0;
    // int for the number of letters
    private static int words = 0;
    // int for the number of letters
    private static int lines = 0;

    public static void processFile(String fileName) {
        lines = 0;
        words = 0;
        chars = 0;

        File file = new File(fileName);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                lines++;
                String[] word = line.split(" ");
                words += word.length;
                for(int i = 0; i<word.length; i++){
                    int temp = word[i].length();
                    chars += temp;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public static int getWordCount() {
        return words;
    }

    public static int getCharacterCount() {
        return chars;
    }

    public static int getLineCount() {
        return lines;
    }

    

    public static void main(String[] args) {
        
        System.out.println("Specify file: ");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        processFile(fileName);
        System.out.println("words: " + getWordCount());
        System.out.println("chars: " + getCharacterCount());
        System.out.println("lines: " + getLineCount());
    }

}