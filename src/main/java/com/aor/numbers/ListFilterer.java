package com.aor.numbers;

import com.sun.tools.javac.jvm.Gen;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {

    private GenericListFilter filter;

    public ListFilterer(GenericListFilter filter) {
        this.filter = filter;
    }

    public List<Integer> filter(List<Integer> list){
        List<Integer> filtrada = new ArrayList<>();
        for (Integer i : list){
            if(filter.accept(i)) {
                filtrada.add(i);
            }
        }
        return filtrada;

    }
}
