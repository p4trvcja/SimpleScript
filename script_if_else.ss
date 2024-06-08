int factorial(int n){
    int one(){
        return(1);
    };
    if((n==1) or (n ==0)){
        return(one());
    }
    return(n*factorial(n-1));
};

print(factorial(5));