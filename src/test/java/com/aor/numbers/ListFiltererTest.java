package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {

    List<Integer> list, expected, list2, expected2;

    @BeforeEach
    public void listas() {
        list = Arrays.asList(-5, 1, 0, 2, 10, -8);
        expected = Arrays.asList(1, 2, 10);
        list2 = Arrays.asList(8, 4, 0, -2, -6, -9, 5, 3);
        expected2 = Arrays.asList(8, 4, 0, -2, -6);
    }

    @Test
    public void filterPositive(){

        GenericListFilter glf = Mockito.mock(GenericListFilter.class);
        Mockito.when(glf.accept(-5)).thenReturn(false);
        Mockito.when(glf.accept(1)).thenReturn(true);
        Mockito.when(glf.accept(0)).thenReturn(false);
        Mockito.when(glf.accept(2)).thenReturn(true);
        Mockito.when(glf.accept(10)).thenReturn(true);
        Mockito.when(glf.accept(-8)).thenReturn(false);

        PositiveFilter positiveFilter = new PositiveFilter();
        ListFilterer lsf = new ListFilterer(positiveFilter);

        List<Integer> distinct = lsf.filter(list);

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void filterDivisibleBy(){

        GenericListFilter glf = Mockito.mock(GenericListFilter.class);
        Mockito.when(glf.accept(8)).thenReturn(true);
        Mockito.when(glf.accept(4)).thenReturn(true);
        Mockito.when(glf.accept(0)).thenReturn(true);
        Mockito.when(glf.accept(-2)).thenReturn(true);
        Mockito.when(glf.accept(-6)).thenReturn(true);
        Mockito.when(glf.accept(-9)).thenReturn(false);
        Mockito.when(glf.accept(5)).thenReturn(false);
        Mockito.when(glf.accept(3)).thenReturn(false);

        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(2);
        ListFilterer lsf = new ListFilterer(divisibleByFilter);

        List<Integer> distinct = lsf.filter(list2);

        Assertions.assertEquals(expected2, distinct);
    }
}
