

int calculateFactorial(int n){
    if(n == 1){
        return(1);
    }
    int x = n-1;
    return(n*calculateFactorial(x));
};

int number = 5;
print(calculateFactorial(number));