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

UDiscounter combinedDiscounter = udiscounters.stream().reduce(v -> v, UDiscounter::combine);

print("combinedDiscounter: ")
println(combinedDiscounter.apply(BigDecimal.valueOf(100)));

/exit