package kiem_tra_module2.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    public static void writeListToCSV(String pathFile, List<String> stringList, boolean append) {
        File file = new File(pathFile);
        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String line : stringList) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException exception) {
            System.out.println("Lỗi ghi tệp: " + pathFile);
        }
    }

    public static void writeLineToCSV(String pathFile, String record) {
        File file = new File(pathFile);
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(record);
            bufferedWriter.newLine();
        } catch (IOException exception) {
            System.out.println("Lỗi khi ghi dòng vào tệp: " + pathFile);
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

        } catch (IOException exception) {
            System.out.println("Lỗi đọc tệp: " + pathFile);
        }

        return stringList;
    }
}
