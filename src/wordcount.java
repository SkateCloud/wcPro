import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class wordcount {
    public static void main(String[] args) { new wordcount().start(args); }

    private void start(String[] args) {
        StringBuilder answer = new StringBuilder();
        HashMap<String,Integer> words = new HashMap<>();
        String str = readFile(args[0]);
        String pattern = "[a-zA-Z][a-zA-Z\\-]*";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        while (m.find()) {
            String word = str.substring(m.start(),m.end()).toLowerCase();
            words.put(word, words.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        list.addAll(words.entrySet());
        list.sort((lhs, rhs) -> {
            int cmp = -lhs.getValue().compareTo(rhs.getValue());
            if (cmp != 0) return cmp;
            else return lhs.getKey().compareTo(rhs.getKey());
        });
        for (int i = 0 ; i < list.size() - 1 && i < 99 ; ++ i) {
            answer.append(list.get(i).getKey()).append(' ').append(list.get(i).getValue()).append('\n');
        }
        answer.append(list.get(list.size()-1).getKey()).append(' ').append(list.get(list.size()-1).getValue());
        writeFile(answer.toString());
    }

    private String readFile(String path) { // 读文件
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, "UTF-8");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void writeFile(String answer) {
        try (FileWriter fout = new FileWriter("result.txt")) {
            fout.append(answer);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return;
    }
}
