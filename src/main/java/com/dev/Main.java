package com.dev;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(ExecutorMain.calculateExecutorServiceSum());
        System.out.println(ForkJoinMain.calculateForkJoinSum());
    }
}
