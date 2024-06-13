

int silnia(int n){
    int one(){
        return(1);
    };
    if(n==1 or n==0){
        return(one());
    }
    return (silnia(n-1)*n);
};


print(silnia(10));