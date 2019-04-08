import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically() {
        List<String> alpahbeticallyOrderdWords = new ArrayList<>();

        String readLines = "";

        try {
            readLines = filePartReader.readLines();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String word : readLines.split("\\s")) {
            alpahbeticallyOrderdWords.add(word);
        }

        Collections.sort(alpahbeticallyOrderdWords);

        return alpahbeticallyOrderdWords;
    }

    public List getWordsContainingSubstring(String subString) {
        List<String> words = new ArrayList<>();
        String readLines = "";

        try {
            readLines = filePartReader.readLines();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String word : readLines.split("\\s")) {
            if (word.contains(subString)) {
                words.add(word);
            }
        }

        return words;
    }

    public List getStringsWhichPalindromes (){
        List<String> palindromes = new ArrayList<>();
        String readLines = "";

        try {
            readLines = filePartReader.readLines();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String word : readLines.split("\\s")) {
            word = word.replaceAll("[\\W]", "").toLowerCase();
            if (new StringBuilder(word).reverse().toString().equals(word)) {
                palindromes.add(word);
            }
        }

        return palindromes;
    }

    public static void main(String[] args) {

        FilePartReader filePartReader = new FilePartReader();
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        String nStr = fileWordAnalyzer.getWordsOrderedAlphabetically().toString();
        System.out.println(nStr + "\n");

        String words = fileWordAnalyzer.getWordsContainingSubstring("is").toString();
        System.out.println(words);

        String palindromes = fileWordAnalyzer.getStringsWhichPalindromes().toString();
        System.out.println("Palindromes:\n" + palindromes);
    }
}
