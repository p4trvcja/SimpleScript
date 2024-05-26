string text1 = "abcd";
string text2 = text1 concat " efgh";
print(text2);

string hello = ", ";
string helloWorld = "hello, " concat "World!";
print(find(hello in "hello, World"));

string s = "input: nothing |";
string[] output = ["hello", " this", " is", " the", " output!!!"];

s = s concat " output: ";
for(string o in output) {
    s = s concat o;
}
print(s);