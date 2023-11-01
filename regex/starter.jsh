//usr/bin/env jshell $0 $@; exit $?

/open PRINTING

// https://www.baeldung.com/regular-expressions-java

println("# Simple Regex Pattern -> compile -> matcher -> find")
Pattern pattern = Pattern.compile("foo");
Matcher matcher = pattern.matcher("foofoo");

int matchCount;

while(matcher.find()) {
    matchCount++;
}

print("- Found ");
println(matchCount);


println("# Meta Characters")
int countMatches(String regex, String text) {
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(text);

int matchCount = 0;

while(matcher.find()) {
    matchCount++;
}
return matchCount;
}

void runTest(String regex, String text) {
    int count = countMatches(regex, text);
    println("- Found " + count + " when searching " + text + " for " + regex);
}

runTest(".", "1234567890123456789012345678")

/exit
