package ss4_lop_va_doi_tuong.StopWatch;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int n = 100000;
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(1_000_000);
        }

        StopWatch timer = new StopWatch();

        timer.start();

        StopWatch.selectionSort(array);

        timer.stop();

        System.out.println("Time elapsed for selection sort on " + n + " elements: " + timer.getElapsedTime() + " milliseconds");
    }
}
