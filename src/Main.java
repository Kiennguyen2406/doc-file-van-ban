import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {

            Map<String, Integer> wordCount = WordFrequencyCounter.countWordFrequency("sample.txt");


            WordFrequencyCounter.displayWordFrequency(wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
