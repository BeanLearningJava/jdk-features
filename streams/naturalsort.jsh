//usr/bin/env jshell $0 $@; exit $?

/open PRINTING

println("Streams natural sort");
// https://softwareengineering.stackexchange.com/questions/332487/how-does-sorting-with-java-8-stream-work-under-the-hood

var letters = List.of("Z", "N", "C");
// letters.stream().sorted().toList();
letters.stream().sorted().forEach(System.out::println);

/exit
