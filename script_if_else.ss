


int fibonacci(int a){
    if(a==0){
        return(0);
    }elif (a==1){
        return(1);
    }else{
        return(fibonacci(a-1)+fibonacci(a-2));
    }
    return(2);
};

int result = fibonacci(15);

print(result);

print("");

print(fibonacci(15));