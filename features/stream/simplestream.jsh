#!/usr/bin/env -S java --source 8

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);

		Stream<Integer> sequentialStream = myList.stream();

		Stream<Integer> parallelStream = myList.parallelStream();

		p("Parallel stream");
		Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
		highNums.forEach(p -> System.out.println("High Nums parallel="+p));

		p("Sequential stream");
		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
		highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));

	}

	static void p(String str) {
		System.out.println(" "); System.out.println(str);
	}
}