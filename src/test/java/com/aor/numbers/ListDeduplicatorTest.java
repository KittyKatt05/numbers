package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    List<Integer> list;
    List<Integer> expected;
    @BeforeEach
    public void lista() {
        list = Arrays.asList(1,2,4,2);
        expected = Arrays.asList(1,2,4);
    }

    @Test
    public void deduplicate() {

//        class StubListSorter implements GenericListSorter{
//            @Override public List<Integer> sort(List<Integer> list) {
//                return  Arrays.asList(1, 2, 2, 4);
//            }
//        }
//
//        ListDeduplicator duplicator = new ListDeduplicator();
//        StubListSorter sorter = new StubListSorter();
//        List<Integer> distinct = duplicator.deduplicate2(list,sorter);
//
//
//        Assertions.assertEquals(expected, distinct);

//Using Mockito:

        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4));

        ListDeduplicator duplicator = new ListDeduplicator();
        List<Integer> distinct = duplicator.deduplicate2(list,sorter);

        Assertions.assertEquals(expected, distinct);
    }
}
