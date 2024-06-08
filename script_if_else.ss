int fibonacci(int a) {
    if (a == 0) {
        return(0);
    } elif (a == 1) {
        return(1);
    }
    return((fibonacci(a-1) + fibonacci(a-2)));
    
};

print(fibonacci(16));