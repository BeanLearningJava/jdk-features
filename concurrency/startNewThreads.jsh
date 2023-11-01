//usr/bin/env jshell $0 $@; exit $?

/open PRINTING

int count = 0;

Runnable fn = () -> {
  println(++count + " platform thread started");
};

new Thread(fn).start();
Thread.ofPlatform().start(fn);
Thread thread = Thread.ofPlatform().daemon().name("my-custom-thread").unstarted(fn);
thread.start();

println("---------------------");
println("---------------------");
println("---------------------");

var vcount = 0;
Runnable fn2 = () -> {
    println(++vcount + " virtual thread started");

};

Thread.ofVirtual().start(fn2);
Thread thread = Thread.startVirtualThread(fn2);
Executors.newVirtualThreadPerTaskExecutor().submit(fn2);




/exit 