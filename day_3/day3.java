package day_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day3 {
    public static void main(String[] args) {
        String filePath = "input.txt";
        StringBuilder sb = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String stringInput = sb.toString();

        String regex = "mul\\(\\d{1,3},\\d{1,3}\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringInput);
        
        StringBuilder newStrBuilder = new StringBuilder();
        while (matcher.find()) {
            newStrBuilder.append(matcher.group());
        }
        String newStr = newStrBuilder.toString();

        String regex2 = "\\(\\d{1,3},\\d{1,3}\\)";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(newStr);

        int sum1 = 0;

        while (matcher2.find()) {
            String match = matcher2.group();
            String[] numbers = match.substring(1, match.length() - 1).split(",");
            int a = Integer.parseInt(numbers[0].trim());
            int b = Integer.parseInt(numbers[1].trim());
            sum1 += a * b;
        }

        System.out.println(sum1);

        int sum2 = 0;
        boolean currentState = true;
        String regexp2 = "(?:mul\\((\\d{1,3}),(\\d{1,3})\\))|(do\\(\\)|don't\\(\\))";
        
        Pattern patternp2 = Pattern.compile(regexp2);
        Matcher matcherp2 = patternp2.matcher(stringInput);
        
        while (matcherp2.find()) {
            String first = matcherp2.group(1);
            String second = matcherp2.group(2);
            String state = matcherp2.group(3);
            
            if (state != null) {
                if (state.equals("do()")) {
                    currentState = true;
                } else if (state.equals("don't()")) {
                    currentState = false;
                }
            } else {
                if (currentState) {
                    sum2 += Integer.parseInt(first) * Integer.parseInt(second);
                }
            }
        }
        System.out.println(sum2);
    }
}

