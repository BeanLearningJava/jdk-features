//usr/bin/env jshell --execution local "-J-Darg1=$1" "-J-Darg2=$1" "$0"; exit $?

String var = System.getProperty("arg1");

/open PRINTING

println(var)

StringBuilder sb = new StringBuilder("original string \n");
sb.append("appended str");

println(sb.toString())

/exit
