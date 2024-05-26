print("petla for ze zdefiniowanymi wczesniej zmiennymi");
int i,j;
for(i=0; i < 5; i++) {
    for(j=0; j < i; j++) {
        print(j);
    }
    print("");
}

print("petla for z nowymi zmiennymi");
print("");

for(int x=0; x < 3; x++) {
    for(int y = 0; y < 3; y++) {
        print(y);
    }
    print("");
}