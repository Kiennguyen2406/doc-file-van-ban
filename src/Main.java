import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // Đếm tần suất xuất hiện của các từ trong tập tin "sample.txt"
            Map<String, Integer> wordCount = WordFrequencyCounter.countWordFrequency("sample.txt");

            // Hiển thị kết quả
            WordFrequencyCounter.displayWordFrequency(wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
