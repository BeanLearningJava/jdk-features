#!/usr/bin/env -S java --source 8

public class Demo {
    public static void main(String[] args) {
        p("https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html");
        p("https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html");
        RegisterInterface reg = new RegisterInterface() {
            public void register(String name, String email) {
                p("");
                p("Using an anonymous class to implement the abstract method");
                p("Name: " + name + " created ");
                register(email);
            }
        };

        RegisterInterface regLambda = (name, email) -> {
            p("");
            p("Using an anonymous/lambda function to implement the abstract method");
            p("Name: " + name + " created");
        };

        reg.register("peterbean410@gmail.com", "Peter Bean");
        regLambda.register("peterbean410@gmail.com", "Peter Bean");

        p("");
        p("Using a static method");
        RegisterInterface.echo("Message printed");

    }

    static void p(String str) {
        System.out.println(str);
    }
}

@FunctionalInterface
interface RegisterInterface {
    void register(String email, String name);

    default void register(String email) {
        System.out.println("Email: " + email + " registered using a default method");
    }

    ;

    static void echo(String str) {
        System.out.println(str);
    }

    boolean equals(Object obj);
}


