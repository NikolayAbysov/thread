package com.dev;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableSum implements Callable<Integer> {
    private int startPosition;
    private int endPosition;
    private List<Integer> inputList;

    CallableSum(int startPosition, int endPosition, List<Integer> inputList) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.inputList = inputList;
    }

    @Override
    public Integer call() {
        Integer result = 0;
        for (int i = startPosition; i <= endPosition; i++) {
            result = result + inputList.get(i);
        }
        return result;
    }
}
