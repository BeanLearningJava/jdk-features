//usr/bin/env jshell $0 $@; exit $?

/open PRINTING

println("Strategy Design Pattern: https://www.baeldung.com/java-strategy-pattern")

public interface Discounter {
    BigDecimal applyDiscount(BigDecimal amount);

    static Discounter newYearDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.8));
    }

}

public static class EasterDiscounter implements Discounter {
    @Override
    public BigDecimal applyDiscount(final BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.5));
    }
}

public static class ChristmasDiscounter implements Discounter {
   @Override
   public BigDecimal applyDiscount(final BigDecimal amount) {
       return amount.multiply(BigDecimal.valueOf(0.9));
   }
}

Discounter easterDiscounter = new EasterDiscounter()

print("EasterDiscounter: ")
println(easterDiscounter.applyDiscount(BigDecimal.TEN))

Discounter lambdaDiscounter = amount -> amount.multiply(BigDecimal.valueOf(0.5));
print("lambdaDiscounter: ")
println(lambdaDiscounter.applyDiscount(BigDecimal.valueOf(100)))




public interface UDiscounter extends UnaryOperator<BigDecimal> {
    default UDiscounter combine(UDiscounter after) {
        return value -> after.apply(this.apply(value));
    }
}

List<Discounter> discounters = new ArrayList<Discounter>(
    List.of(
    amount -> amount.multiply(BigDecimal.valueOf(0.9)),
    amount -> amount.multiply(BigDecimal.valueOf(0.8)),
    amount -> amount.multiply(BigDecimal.valueOf(0.5))
  )
);


List<UDiscounter> udiscounters = new ArrayList<UDiscounter>(
    List.of(
        amount -> amount.multiply(BigDecimal.valueOf(0.9)),
        amount -> amount.multiply(BigDecimal.valueOf(0.8)),
        amount -> amount.multiply(BigDecimal.valueOf(0.5))
    )
);
/**
Essentially, we are refactoring our Discounter and leveraging a fact that applying a discount is a function 
    that converts a BigDecimal instance into another BigDecimal instance, 
    allowing us to access predefined methods. As the UnaryOperator comes with an apply() method, we can just replace applyDiscount with it.
The combine() method is just an abstraction around applying one Discounter to the results of this. 
    It uses the built-in functional apply() in order to achieve this.

Now, Let’s try applying multiple Discounters cumulatively to an amount. We will do this by using the functional reduce() and our combine():
*/
UDiscounter combinedDiscounter = udiscounters.stream().reduce(v -> v, UDiscounter::combine);
/**
Pay special attention to the first reduce argument. 
    When no discounts provided, we need to return the unchanged value. 
    This can be achieved by providing an identity function as the default discounter.

This is a useful and less verbose alternative to performing a standard iteration. 
    If we consider the methods we are getting out of the box for functional composition, it also gives us a lot more functionality for free.
*/
print("combinedDiscounter: ")
println(combinedDiscounter.apply(BigDecimal.valueOf(100)));

/exit