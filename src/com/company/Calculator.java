package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Calculator {
    private ArrayList<Integer> numbers;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    Calculator(){
        fill();
    }

    //Filler for array
    private void fill(){
        numbers = new ArrayList<>();

        try {
            while(true){
                String context = reader.readLine();
                if(context.equals("")){
                    break;
                }

                this.numbers.add(Integer.parseInt(context));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Main logic
    void showMenu(){
        System.out.println("//Your Array\\\\");
        for (int index = 0; index < this.numbers.size(); index++) {
            System.out.print(index + "\t");
        }
        System.out.println();
        for (int item : this.numbers){
            System.out.print(item + "\t");
        }

        System.out.println("\n\n///Menu\\\\\\");
        System.out.println("1. Adding");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Fill with another array");
        System.out.println("6. Exit");

        int selector = 0;

        try {
            selector = Integer.parseInt(this.reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> input_indexes;
        String response;

        switch (selector){
            case 6:
                System.exit(0);
            case 1:
                input_indexes = new ArrayList<>();

                System.out.println("Enter indexes of numbers for 'add' operation (press Enter to calculate all numbers):");
                while(true){
                    try {
                        String context = this.reader.readLine();
                        if(context.equals("")){
                            break;
                        }

                        input_indexes.add(Integer.parseInt(context));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                response = (input_indexes.size() != 0) ?
                        "Sum of selected numbers: " : "Sum of all numbers: ";

                System.out.println(response + add(input_indexes) + "\n");
                break;
            case 2:
                input_indexes = new ArrayList<>();

                System.out.println("Enter indexes of numbers for 'subtraction' operation (press Enter to calculate all numbers):");
                while(true){
                    try {
                        String context = this.reader.readLine();
                        if(context.equals("")){
                            break;
                        }

                        input_indexes.add(Integer.parseInt(context));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                response = (input_indexes.size() != 0) ?
                        "Subtraction of selected numbers: " : "Subtraction of all numbers: ";

                System.out.println(response + subtract(input_indexes) + "\n");
                break;
            case 3:
                input_indexes = new ArrayList<>();

                System.out.println("Enter indexes of numbers for 'multiplication' operation (press Enter to calculate all numbers):");
                while(true){
                    try {
                        String context = this.reader.readLine();
                        if(context.equals("")){
                            break;
                        }

                        input_indexes.add(Integer.parseInt(context));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                response = (input_indexes.size() != 0) ?
                        "Multiplication of selected numbers: " : "Multiplication of all numbers: ";

                System.out.println(response + multiply(input_indexes) + "\n");
                break;
            case 4:
                input_indexes = new ArrayList<>();

                System.out.println("Enter indexes of numbers for 'division' operation (press Enter to calculate all numbers):");
                while(true){
                    try {
                        String context = this.reader.readLine();
                        if(context.equals("")){
                            break;
                        }

                        input_indexes.add(Integer.parseInt(context));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                response = (input_indexes.size() != 0) ?
                        "Division of selected numbers: " : "Division of all numbers: ";

                System.out.println(response + division(input_indexes) + "\n");
                break;
            case 5:
                fill();
                break;
            default:
                System.out.println("Unknown command...");
        }
    }

    //Sum of numbers
    private int add(ArrayList<Integer> indexes) {
        int sum = 0;

        if (indexes.size() > 0) {
            for (int index : indexes) {
                if (index > (this.numbers.size() - 1)) {
                    continue;
                }

                sum += this.numbers.get(index);
            }
        } else {
            for(int num : this.numbers){
                sum += num;
            }
        }

        return sum;
    }

    //Subtraction of numbers
    private int subtract(ArrayList<Integer> indexes) {
        int sub = this.numbers.get(0);

        if (indexes.size() > 0) {
            sub = this.numbers.get(indexes.get(0));

            for (int index = 1; index < indexes.size(); index++) {
                if (index > (this.numbers.size() - 1)) {
                    continue;
                }

                sub -= this.numbers.get(indexes.get(index));
            }
        } else {
            for(int num = 1; num < numbers.size(); num++){
                sub -= this.numbers.get(num);
            }
        }

        return sub;
    }

    //Multiply of numbers
    private int multiply(ArrayList<Integer> indexes) {
        int sum = 1;

        if (indexes.size() > 0) {
            for (int index : indexes) {
                if (index > (this.numbers.size() - 1)) {
                    continue;
                }

                sum *= this.numbers.get(index);
            }
        } else {
            for(int num : this.numbers){
                sum *= num;
            }
        }

        return sum;
    }

    //Division of numbers
    private int division(ArrayList<Integer> indexes) {
        int div = this.numbers.get(0);

        if (indexes.size() > 0) {
            div = this.numbers.get(indexes.get(0));

            for (int index = 1; index < indexes.size(); index++) {
                if ((index > (this.numbers.size() - 1))
                        || (this.numbers.get(indexes.get(index)) == 0)) {
                    continue;
                }

                div /= this.numbers.get(indexes.get(index));
            }
        } else {
            for(int num = 1; num < numbers.size(); num++){
                if(this.numbers.get(num) == 0){
                    continue;
                }

                div /= this.numbers.get(num);
            }
        }

        return div;
    }
}
