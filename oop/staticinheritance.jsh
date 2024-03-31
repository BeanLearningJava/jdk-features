//usr/bin/env jshell $0 $@; exit $?

/open PRINTING

/**
 * A JavaFX application using the Canvas API to create the Matrix falling/raining green code effect.
 */
public class Parent {
    protected static String protectedStaticString;
    protected String protectedString;
    public void printProtected() {
        println(protectedStaticString);
        println(protectedString);
    }

    Parent(String str) {
        protectedString = str;
    }
    Parent(){
        protectedString = "init in Parent";
    }
}

public class Child extends Parent {
    Child(String str) {
        protectedString = "onverridden in child: " + str;
    }
    Child(){}
}

Parent.protectedStaticString = "ok";
Child.protectedStaticString = "lovely";
println(Parent.protectedStaticString);
println(Child.protectedStaticString);

new Parent("init in Parent").printProtected();
new Child().printProtected();

/exit