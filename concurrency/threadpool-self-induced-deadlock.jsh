//usr/bin/env jshell $0 $@; exit $?

// https://nurkiewicz.com/2018/09/thread-pool-self-induced-deadlocks.html

System.out.println("First Run is OK");
ExecutorService pool = Executors.newFixedThreadPool(10);
pool.submit(() -> {
    try {
        System.out.println("First");
        pool.submit(() -> System.out.println("Second")).get();
        System.out.println("Third");
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }
});

System.out.println("------------------");
System.out.println("------------------");
System.out.println("------------------");
System.out.println("Second Run is OK");
ExecutorService pool = Executors.newSingleThreadExecutor();
pool.submit(() -> {
    System.out.println("First");
    pool.submit(() -> System.out.println("Second"));
    System.out.println("Third");
});


System.out.println("------------------");
System.out.println("------------------");
System.out.println("------------------");
System.out.println("Third Run is NOT OK");
ExecutorService pool = Executors.newSingleThreadExecutor();
pool.submit(() -> {
    try {
        System.out.println("First");
        pool.submit(() ->System.out.println("Second")).get();
        System.out.println("Third");
    } catch (InterruptedException e) {
        
e.printStackTrace();
    } catch (ExecutionException e) {
        e.printStackTrace();
    }
});

/exit
