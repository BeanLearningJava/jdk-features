#!/usr/bin/env -S java --source 8

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.lang.Integer;

public class Java8ForEachExample {
    static void printIntro() {
        println("");

        println("	Whenever we need to traverse through a Collection, we need to create an Iterator whose whole purpose is to iterate over, ");
        println("and then we have business logic in a loop for each of the elements in the Collection. ");
        println("We might get ConcurrentModificationException if the iterator is not used properly.");
        println("https://www.digitalocean.com/community/tutorials/java-util-concurrentmodificationexception");

        println("");

        println("	Java 8 has introduced forEach method in java.lang.Iterable interface so that while writing code we focus on business logic. ");
        println("The forEach method takes java.util.function.Consumer object as an argument,");
        println("so it helps in having our business logic at a separate location that we can reuse.");

        println("");
    }

    public static void main(String[] args) {
        println("https://www.digitalocean.com/community/tutorials/java-8-features-with-examples");
        printIntro();

        // Creating sample Collection
        List<Integer> myList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) myList.add(i);

        println("");
        println("Traversing using Iterator");
        Iterator<Integer> it = myList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            println("Iterator Value::" + i);
        }

        println("");
        println("Traversing through forEach method of Iterable with anonymous class");
        myList.forEach(new Consumer<Integer>() {

            public void accept(Integer t) {
                println("forEach anonymous class Value::" + t);
            }

        });

        println("");
        println("Traversing with Consumer interface implementation");
        Java8ForEachExample.MyConsumer actionConsumer = new Java8ForEachExample.MyConsumer();
        myList.forEach(actionConsumer);
    }

    // Consumer implementation that can be reused
    static class MyConsumer implements Consumer<Integer> {

        public void accept(Integer t) {
            println("Consumer impl Value::" + t);
        }
    }

    static void println(String str) {
        System.out.println(str);
    }
}
