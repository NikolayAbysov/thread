package com.dev;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinMain {
    private final static int LIST_SIZE = 1_000_000;
    private final static int THREAD_NUM = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        List<Integer> integerList = ListProvider.getListInteger(LIST_SIZE);
        List<CallableSum> list = CallableSumListProvider.getCallableSumList(THREAD_NUM, integerList);

        ForkJoinPool pool = new ForkJoinPool(THREAD_NUM);
        List<Future<Integer>> futureList = pool.invokeAll(list);

        Integer result = 0;

        for (Future<Integer> value : futureList) {
            try {
                result = result + value.get();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result);
    }
}
