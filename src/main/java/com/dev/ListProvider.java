package com.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListProvider {
    public static List<Integer> getListInteger(int listSize) {
        Random ran = new Random();
        List<Integer> listInteger = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            listInteger.add(ran.nextInt());
        }
        return listInteger;
    }
}
