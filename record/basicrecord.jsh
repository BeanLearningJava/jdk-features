//usr/bin/env jshell $0 $@; exit $?

/open PRINTING

println("Can Java Record have methods ?"); 

public record Student(String name, int age) {
    boolean canStudy() {
        if (age > 0) {
            return true;
        }
        return false;
    }
}

println("Can an unborn baby study ?"); 

var s = new Student("Unborn baby", 0);
println("- " + s.canStudy());

println("Can a teenager study ?"); 
s = new Student("Teen", 15);
println("- " + s.canStudy());

/exit
