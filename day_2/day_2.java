import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class day_2 {
    public static void main(String[] args) {
        String filePath = "input.txt";
        List<List<Integer>> data = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] parts = line.split("\\s+");
                List<Integer> row = new ArrayList<>();
                for (String part : parts) {
                    row.add(Integer.parseInt(part));
                }
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int safe_count_1 = 0;
        int safe_count_2 = 0;
        for (List<Integer> row : data) {
            if (checkSafe(row)) {
                safe_count_1++;
                safe_count_2++;
            }
            else {
                for(int i = 0; i < row.size(); i++){
                    List<Integer> row_copy_head = new ArrayList<>(row.subList(0, i));
                    List<Integer> row_copy_tail = new ArrayList<>(row.subList(i+1, row.size()));
                    row_copy_head.addAll(row_copy_tail);
                    if(checkSafe(row_copy_head)){
                        safe_count_2++;
                        break;
                    }
                }
            }
        }
        System.out.println("Part 1: " + safe_count_1);
        System.out.println("Part 2: " + safe_count_2);
    }
    
    private static boolean checkSafe(List<Integer> row) {
        boolean increasing = false;
        for (int i = 0; i < row.size() - 1; i++) {
            if (row.get(i) == row.get(i + 1)) {
                return false;
            }
            if (i == 0) {
                if (row.get(i) < row.get(i + 1)) {
                    increasing = true;
                }
            }
            if ((row.get(i) < row.get(i + 1) && increasing) || (row.get(i) > row.get(i + 1) && !increasing)) {
                if (!(Math.abs(row.get(i) - row.get(i + 1)) <= 3)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}