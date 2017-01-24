package java8.lamda.example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by rohitkumar on 24/01/17.
 *
 * Parallel Stream Example
 */
public class Sample4 {

    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /*System.out.println("Start Time = "+new Date());
        System.out.println(sequentialStream(values));
        System.out.println("EndTime = "+new Date());*/

        System.out.println("Start Time = "+new Date());
        System.out.println(parallelStream(values));
        System.out.println("EndTime = "+new Date());

        Stream<Integer> stream = values.stream();

    }

    private static int sequentialStream(List<Integer> values) {
        return values.stream()
                .mapToInt(Sample4 :: doubleIt)
                .sum();
    }

    private static int doubleIt(Integer value) {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value * 2;
    }

    /**
     * If input size huge, then we have to think about performance.
     * @param values
     * @return
     */
    private static int parallelStream(List<Integer> values) {
        return values.parallelStream()
                .mapToInt(Sample4::doubleIt)
                .sum();
    }
}
