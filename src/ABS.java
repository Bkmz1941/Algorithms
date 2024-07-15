import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ABS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();

        int inputConfig[] = new int[2];
        String[] strs = input.split("\\s+");
        for (int i = 0; i < 2; i++) inputConfig[i] = Integer.parseInt(strs[i]);

        Map<Integer, String> absData = new HashMap<>();
        List<Map.Entry<Integer, String>> userData = new ArrayList<>();

        int order = 0;

        while (absData.size() != inputConfig[0]) {
            String absLine = reader.readLine().trim();
            absData.put(order, absLine);
            order++;
        }
        while (userData.size() != inputConfig[1]) {
            String userDataLine = reader.readLine().trim();
            String[] userDataLineArray = userDataLine.split("\\s+");
            userData.add(Map.entry(Integer.valueOf(userDataLineArray[0]), userDataLineArray[1]));
        }

        for (Map.Entry<Integer, String> entry: userData) {
            Integer key = entry.getKey();
            if (key < 0) {
                System.out.println("-1");
                continue;
            }
            String value = entry.getValue();
            List<Map.Entry<Integer, String>> localAbsSet = new ArrayList<>();
            int count = 0;
            for (Map.Entry<Integer, String> absEntry: absData.entrySet()) {
                if (absEntry.getValue().startsWith(value)) {
                    localAbsSet.add(Map.entry(count, absEntry.getValue()));
                    count++;
                }
            }
            if (key > count || localAbsSet.isEmpty()) {
                System.out.println("-1");
            } else {
                for (Map.Entry<Integer, String> absEntry : absData.entrySet()) {
                    if (absEntry.getValue().equals(localAbsSet.get(key).getValue())) {
                        System.out.println(absEntry.getKey());
                    }
                }
            }
        }
    }
}