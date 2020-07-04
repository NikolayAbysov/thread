package com.dev;

import java.util.ArrayList;
import java.util.List;

class CallableSumListProvider {
    static List<CallableSum> getCallableSumList(int listSize, List<Integer> inputList) {
        List<CallableSum> result = new ArrayList<>();
        int position = 0;

        for (int i = 0; i < listSize; i++) {
            result.add(new CallableSum(position, (position + (inputList.size() / listSize) - 1), inputList));
            position = position + (inputList.size() / listSize);
        }
        return result;
    }
}
