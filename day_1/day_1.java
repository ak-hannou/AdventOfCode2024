import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class day_1 {
    public static void main(String[] args) {
        String filePath = "input.txt";
        List<Integer> column1 = new ArrayList<>();
        List<Integer> column2 = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] parts = line.split("\\s+");
                column1.add(Integer.parseInt(parts[0]));
                column2.add(Integer.parseInt(parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(column1);
        Collections.sort(column2);
        int totalDistance = 0;
        for (int i = 0; i < column1.size(); i++) {
            totalDistance += Math.abs(column1.get(i) - column2.get(i));
        }
        System.out.println();

        System.out.println(totalDistance);

        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < column1.size(); i++) {
            for (int j=0; j < column2.size(); j++) {
                if (column1.get(i).equals(column2.get(j))) {
                    counts.put(column1.get(i), counts.getOrDefault(column1.get(i), 0) + 1);
                }
            }
        }

        int totalSimilarity = 0;
        for (int key : counts.keySet()) {
            totalSimilarity += counts.get(key)*key;
        }
        System.out.println(totalSimilarity);
    }   
}