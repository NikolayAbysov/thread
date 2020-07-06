package com.dev;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

class ForkJoinMain {
    private final static int LIST_SIZE = 1_000_000;
    private final static int THREAD_NUM = Runtime.getRuntime().availableProcessors();

    static int calculateForkJoinSum() throws ExecutionException, InterruptedException {
        List<Integer> integerList = ListProvider.getListInteger(LIST_SIZE);
        List<CallableSum> list = CallableSumListProvider.getCallableSumList(THREAD_NUM, integerList);

        ForkJoinPool pool = new ForkJoinPool(THREAD_NUM);
        List<Future<Integer>> futureList = pool.invokeAll(list);

        Integer result = 0;

        for (Future<Integer> value : futureList) {
            result = result + value.get();
        }
        return result;
    }
}
