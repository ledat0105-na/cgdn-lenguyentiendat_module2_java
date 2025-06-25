package ss17_binary_file.binary_file_product.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileUtil {

    public static <T> void writeToFile(String path, List<T> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(list);
            System.out.println("Ghi file thành công.");
        } catch (IOException e) {
            System.out.println("Ghi file thất bại: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> readFromFile(String path) {
        File file = new File(path);
        if (!file.exists() || file.length() == 0) {
            System.out.println("File không tồn tại hoặc rỗng.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Đọc file thất bại: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
