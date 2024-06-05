int fun1(int x){
    for(int i = 0; i<20; i++){
        if(i==3){
            return(x);
        }
    }
    return(1);
};

int b = fun1(20);
print(b);
