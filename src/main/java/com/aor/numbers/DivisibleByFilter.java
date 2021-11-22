package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{

    int div;

    public DivisibleByFilter(int div){
        this.div = div;
    }

    @Override
    public boolean accept(Integer number){
        if(number % div == 0) {
            return true;
        }
        return false;
    }
}
