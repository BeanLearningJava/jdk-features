println("START creating 10k Virtual Threads");
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    IntStream.range(0, 10_000).forEach(i -> {
        executor.submit(() -> {
            Thread.sleep(java.time.Duration.ofSeconds(1));
            return i;
        });
    });
}  // executor.close() is called implicitly, and waits
println("DONE creating 10k Virtual Threads");

println("How about Native Threads");
Thread.sleep(java.time.Duration.ofSeconds(1));

println("START creating 10k Native Threads");
try (var executor = Executors.newCachedThreadPool()) {
    IntStream.range(0, 10_000).forEach(i -> {
        executor.submit(() -> {
            Thread.sleep(java.time.Duration.ofSeconds(1));
            return i;
        });
        println("osthread #" + (i+1));
    });
}  // executor.close() is called implicitly, and waits
println("Are we DONE?");
