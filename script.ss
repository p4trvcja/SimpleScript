int sum(int a, int b) {
    return(a + b);
};

int x(int d) {
    sum(3, 5);
    print(d);
    return(10);
};

x(30);
print(sum(1, 2));