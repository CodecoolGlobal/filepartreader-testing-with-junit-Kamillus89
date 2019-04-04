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

        
    }

    public static void main(String[] args) {

        FilePartReader filePartReader = new FilePartReader();
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        String nStr = fileWordAnalyzer.getWordsOrderedAlphabetically().toString();
        System.out.println(nStr);
    }
}
