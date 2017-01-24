package java8.foreach.example;

import java.util.function.Consumer;

/**
 * Created by rohitkumar on 24/01/17.
 */
public class DisplayConsumer implements Consumer<Object> {

    @Override
    public void accept(Object o) {
        System.out.println(o.getClass().getName()+"--"+o.toString());
    }
}
