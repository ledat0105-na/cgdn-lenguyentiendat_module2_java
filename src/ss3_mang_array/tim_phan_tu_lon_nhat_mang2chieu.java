package ss3_mang_array;

public class tim_phan_tu_lon_nhat_mang2chieu {
    public static void main(String[] args) {
        double[][] maTran = {
                {1.5, 2.8, 3.9},
                {4.2, 9.1, 2.2},
                {3.3, 7.4, 0.5}
        };
        double max = maTran[0][0];
        int hangMax = 0;
        int cotMax = 0;

        for (int i = 0; i < maTran.length; i++) {
            for (int j = 0; j < maTran[i].length; j++) {
                if (maTran[i][j] > max) {
                    max = maTran[i][j];
                    hangMax = i;
                    cotMax = j;
                }
            }
        }
        System.out.println("Giá trị lớn nhất là: " + max);
        System.out.println("Vị trí: hàng " + hangMax + ", cột " + cotMax);
    }
}
