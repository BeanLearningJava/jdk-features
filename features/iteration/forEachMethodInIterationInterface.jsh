#!/usr/bin/env -S java --source 8

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.lang.Integer;

public class Java8ForEachExample {

    public static void main(String[] args) {
        System.out.println("https://www.digitalocean.com/community/tutorials/java-8-features-with-examples");
        System.out.println("");

        System.out.println("	Whenever we need to traverse through a Collection, we need to create an Iterator whose whole purpose is to iterate over, ");
        System.out.println("and then we have business logic in a loop for each of the elements in the Collection. ");
        System.out.println("We might get ConcurrentModificationException if the iterator is not used properly.");
        System.out.println("https://www.digitalocean.com/community/tutorials/java-util-concurrentmodificationexception");

        System.out.println("");
        // System.out.println("");

        System.out.println("	Java 8 has introduced forEach method in java.lang.Iterable interface so that while writing code we focus on business logic. ");
        System.out.println("The forEach method takes java.util.function.Consumer object as an argument,");
        System.out.println("so it helps in having our business logic at a separate location that we can reuse.");

        System.out.println("");

        //creating sample Collection
        List<Integer> myList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) myList.add(i);

        System.out.println("");
        //traversing using Iterator
        Iterator<Integer> it = myList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Iterator Value::" + i);
        }

        System.out.println("");
        //traversing through forEach method of Iterable with anonymous class
        myList.forEach(new Consumer<Integer>() {

            public void accept(Integer t) {
                System.out.println("forEach anonymous class Value::" + t);
            }

        });

        System.out.println("");
        //traversing with Consumer interface implementation
        MyConsumer action = new MyConsumer();
        myList.forEach(action);

    }
}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer> {

    public void accept(Integer t) {
        System.out.println("Consumer impl Value::" + t);
    }
}
