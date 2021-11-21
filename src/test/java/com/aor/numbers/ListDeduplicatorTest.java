package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

//        class StubListDeduplicator implements GenericListDeduplicator{
//            @Override public List<Integer> deduplicate(List<Integer> list) {
//                return  Arrays.asList(1, 2, 4);
//            }
//        }
//        ListDeduplicator duplicator = new ListDeduplicator();
//        StubListDeduplicator deduplicator = new StubListDeduplicator();
//        int distinct = duplicator.deduplicate(list,deduplicator);
//
//        Assertions.assertEquals(expected, distinct);

        class StubListSorter implements GenericListSorter{
            @Override public List<Integer> sort(List<Integer> list) {
                return  Arrays.asList(1, 2, 2, 4);
            }
        }

        ListDeduplicator duplicator = new ListDeduplicator();
        StubListSorter sorter = new StubListSorter();
        List<Integer> distinct = duplicator.deduplicate2(list,sorter);


        Assertions.assertEquals(expected, distinct);
    }
}
