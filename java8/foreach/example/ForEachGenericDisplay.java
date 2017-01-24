package java8.foreach.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rohitkumar on 24/01/17.
 */
public class ForEachGenericDisplay {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        for (int number = 1; number <=10; number++) {
            integers.add(number);
        }
        display(integers);

        List<Double> doubles = new ArrayList<>();
        for (double number = 1; number <=10; number++) {
            doubles.add(number);
        }
        display(doubles);

        List<Long> longs = new ArrayList<>();
        for (long number = 1; number <=10; number++) {
            longs.add(number);
        }
        display(longs);

        List<Date> dates = new ArrayList<>();
        for (long nanoSec = 10000; nanoSec<= 10010; nanoSec++) {
            Date date = new Date(nanoSec);
            dates.add(date);
        }
        display(dates);

    }

    private static void display(List<?> list) {

        DisplayConsumer displayConsumer = new DisplayConsumer();
        list.forEach(displayConsumer);
    }


}
