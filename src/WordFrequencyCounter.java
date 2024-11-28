import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    // Hàm đếm số lần xuất hiện của từng từ
    public static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Sử dụng try-with-resources để tự động đóng BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Loại bỏ ký tự không cần thiết và tách từ
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        return wordFrequency;
    }

    // Phương thức hiển thị tần suất từ
    public static void displayWordFrequency(Map<String, Integer> wordFrequency) {
        System.out.println("Word Frequency in the file:");

        // Sắp xếp từ theo tần suất giảm dần (tuỳ chọn)
        Map<String, Integer> sortedFrequency = wordFrequency.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Sort by frequency
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        // In ra từ và tần suất
        for (Map.Entry<String, Integer> entry : sortedFrequency.entrySet()) {
            System.out.printf("%-15s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}