import java.util.List;

List<Integer> numbers = Arrays.asList(1,2,3,4,5);

numbers.stream().forEach(number -> System.out.println(number));
int sum = numbers.stream().filter(x->x%2==0).mapToInt(e -> e*2).sum();
System.out.println(sum);

