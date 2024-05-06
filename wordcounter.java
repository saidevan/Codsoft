import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class wordcounter {

    static Scanner scanner = new Scanner(System.in);
    static File myFile = new File("text.txt");

    static Set<String> commonWords = new HashSet<>();
    static {
        
        commonWords.add("the");
        commonWords.add("and");
    }

    static int wordCounter(String text) {
        int count = 0;

        String[] words = text.split("\\s+");
        for (String word : words) {
            if (!commonWords.contains(word.toLowerCase())) {
                count++;
            }
        }

        return count;
    }

    static void ReadFile() {
        try {
            int line = 0, fResult = 0;
            Scanner fileReader = new Scanner(myFile);
            while (fileReader.hasNextLine()) {

                String text = fileReader.nextLine();
                line++;

                fResult += wordCounter(text);

            }
            System.out.println("Lines : " + line);
            System.out.println("Words : " + fResult);
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error Occur : Read File ");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter the text to count words:");
        String text = scanner.nextLine();
        System.out.println("Word count: " + wordCounter(text));

        scanner.close();
    }
}
