//usr/bin/env jshell $0 $@; exit $?

/open PRINTING

print("");
int[] arr = {1,2,3,4,5}

firstloop:
for(int i : arr) {
println("i="+i);
secondloop:
for(int j : arr) {
println("... j="+j);
if (j>2) {
    break secondloop;
    }
}
}

/exit
