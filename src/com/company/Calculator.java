package com.company;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> numbers;

    Calculator(ArrayList<Integer> input){
        this.numbers = input;
    }

    int add(ArrayList<Integer> indexes) {
        int sum = 0;

        for(int index : indexes){
            if(index > (this.numbers.size() - 1)){
                continue;
            }

            sum += this.numbers.get(index);
        }

        return sum;
    }
}
