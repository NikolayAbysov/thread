package com.dev;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorMain {
    private final static int LIST_SIZE = 1_000_000;
    private final static int THREAD_NUM = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws InterruptedException {
        List<Integer> integerList = ListProvider.getListInteger(LIST_SIZE);
        List<CallableSum> list = CallableSumListProvider.getCallableSumList(THREAD_NUM, integerList);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);
        List<Future<Integer>> futureList = executorService.invokeAll(list);

        Integer result = 0;

        for (Future<Integer> value : futureList) {
            try {
                result = result + value.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        System.out.println(result);
    }
}
