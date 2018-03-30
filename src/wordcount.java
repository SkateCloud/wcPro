import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class wordcount {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        new wordcount().start(args);
        long t2 = System.currentTimeMillis();
        long dt = t2 - t1;
        System.out.println(("Elapsed " + dt + "ms"));
    }

    private void start(String[] args) {
        HashMap<String,Integer> words = new HashMap<>();
        String str = readFile(args[0]);
        {
            int state = 0;
            int beginIndex = -1;
            for (int i = 0; i <= str.length(); ++i) {
                char ch = i == str.length() ? ' ' : str.charAt(i);
                boolean isWordChar = ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') || ch == '-';
                if (state == 0 && isWordChar && ch != '-') {
                    beginIndex = i;
                    state = 1;
                } else if (state == 1 && !isWordChar) {
                    String word = str.substring(beginIndex, i).toLowerCase();
                    words.put(word, words.getOrDefault(word, 0) + 1);
                    state = 0;
                }
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        list.addAll(words.entrySet());
        list.sort((lhs, rhs) -> {
            int cmp = -lhs.getValue().compareTo(rhs.getValue());
            if (cmp != 0) return cmp;
            else return lhs.getKey().compareTo(rhs.getKey());
        });

        try (FileWriter fout = new FileWriter("result.txt")) {
            int maxsz = Math.min(list.size(), 100);
            for (int i = 0 ; i < maxsz; ++ i) {
                Map.Entry<String, Integer> item = list.get(i);
                fout.write(item.getKey());
                fout.write(' ');
                fout.write(item.getValue().toString());
                if (i != maxsz - 1)
                    fout.write('\n');
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private String readFile(String path) { // 读文件
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, "UTF-8");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
