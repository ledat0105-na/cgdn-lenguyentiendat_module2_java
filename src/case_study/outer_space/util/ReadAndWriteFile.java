package case_study.outer_space.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    public static void writeListToCSV(String pathFile, List<String> stringList) {
        File file = new File(pathFile);
        try (FileWriter fileWriter = new FileWriter(file, false);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String line : stringList) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + pathFile);
        }
    }

    public static void writeLineToCSV(String path, String record) {
        File file = new File(path);
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(record);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dòng vào file: " + path);
        }
    }

    public static List<String> readFileCSV(String pathFile) {
        List<String> stringList = new ArrayList<>();
        File file = new File(pathFile);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    stringList.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + pathFile);
        }
        return stringList;
    }
}