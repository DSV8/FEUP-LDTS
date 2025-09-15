package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    @BeforeEach
    public void helper() {
        this.list = Arrays.asList(1, 2, 4, 2, 5);
        this.max_bug_7263 = Arrays.asList(-1, -4, -5);
        this.bug_report_8726 = Arrays.asList(1, 2, 4, 2);
    }

    private List<Integer> list;
    private List<Integer> max_bug_7263;
    private List<Integer> bug_report_8726;

    @Test
    public void sum() {
        //List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        //List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        //List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        //List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator();
        //int distinct = aggregator.distinct(list);

        ListDeduplicator deduplicator = new ListDeduplicator();

        int distinct = aggregator.distinct(bug_report_8726, deduplicator);
        Assertions.assertEquals(3, distinct);

        //Assertions.assertEquals(4, distinct);
    }
}
