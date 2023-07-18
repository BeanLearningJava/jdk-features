#!/usr/bin/env -S java --source 8

public class Demo {
    public static void main(String[] args) {
        RegisterInterface reg = new RegisterInterface() {
            public void register(String name, String email) {
                System.out.println("Name: " + name + " created");
                register(email);
            }
        };

        System.out.println("https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html");
        reg.register("peterbean410@gmail.com", "Peter Bean");
    }
}
interface RegisterInterface {
    void register(String email, String name);
    default void register(String email) {
        System.out.println("Email: " + email + " registered.");
    };
}


