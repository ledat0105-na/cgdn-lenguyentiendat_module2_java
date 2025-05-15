package ss2_vong_lap_loop;

public class hien_thi_cac_so_ngto_nho_hon_100 {
    public static void main(String[] args) {
        System.out.println("Các số nguyên tố nhỏ hơn 100 là: ");

        for (int i = 2; i < 100; i++) {
            if (laSoNguyenTo(i)) {
                System.out.println(i + " ");
            }
        }
    }

    public static boolean laSoNguyenTo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
