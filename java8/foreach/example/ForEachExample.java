package java8.foreach.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by rohitkumar on 24/01/17.
 */
public class ForEachExample {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        for (int number = 1; number <=10; number++) {
            integers.add(number);
        }

        /**
         * Before Java - 8, TRAVERSE LIST
         *\
         *traverseIterator(integers);

        /**
         * Traverse using foreach
         */
        //traverseForEach(integers);

        /**
         * Traverse using Consumer.
         */
       // traverseForEach2(integers);


        /**
         * Traverse using MyConsumer,
         */
        traverseForEach3(integers);

    }

    /**
     *
     * @param integers
     */
    private static void traverseForEach3(List<Integer> integers) {

        //MyConsumer action = new MyConsumer();
        DoubleMyValue doubleMyValue = new DoubleMyValue();
        integers.forEach(doubleMyValue);
    }

    /**
     *
     * @param integers
     */
    private static void traverseIterator(List<Integer> integers) {

        Iterator<Integer> it = integers.iterator();
        while(it.hasNext()) {
            Integer i = it.next();
            System.out.println("Iterator Value::"+i);
        }
    }

    /**
     * Functional Programming.
     * @param integers
     */
    private static void traverseForEach(List<Integer> integers) {

        integers.forEach(value -> System.out.println("Number = " + value));
    }

    /**
     *
     * @param integers
     */
    private static void traverseForEach2(List<Integer> integers) {

        integers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Number "+integer);
            }
        });
    }



    static class MyConsumer implements Consumer<Integer> {

        @Override
        public void accept(Integer integer) {

            System.out.println("MyConsumer = "+integer);
            System.out.println("Number * 2 = "+integer*2);
        }
    }

    static class DoubleMyValue implements Consumer<Integer> {

        @Override
        public void accept(Integer integer) {

            System.out.println("Number * 2 = "+integer*2);
        }
    }

}
