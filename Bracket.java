package package8;

import java.util.Scanner;

public class Bracket {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of parentheses in expression: ");
        int N = Integer.parseInt(input.nextLine());

        int o = 0; // count of right bracket sequence

        for ( String s : new Bracket().generateString(N)){

            if (checkString(s)){
            System.out.println(o + " " + s);
            o++;
            }
        }
    }

    /**
     * This function is generate all bracket sequence
     */
    public String[] generateString(int N){

        // ****Some magic**** :D

        // First we need to find number of array
        int number = (int)Math.pow(2, N*2);
        String[] arr = new String[number];
        StringBuilder stringBuilder = new StringBuilder();

        // it's to adding 0 to array when we will be convert from 0 and 1 to '(' and ')'
        for (int j = 0; j < N*4; j++) {
            stringBuilder.append(0);
        }

        // it's to fill in all sequences
        for (int i = 0; i < arr.length; i++){
            arr[i] = ""+stringBuilder + Integer.toBinaryString(number);
            number--;
        }

        // correcting, remove extra digits
        for (int i = 0; i < arr.length; i++){
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(arr[i]);
            arr[i] = ""+stringBuilder.delete(0, stringBuilder.length()-N*2);
        }

        // and switch 0 and 1 to '(' and ')'
        for (int i = 0; i < arr.length; i++){
            arr[i] = arr[i].replace('0', '(');
            arr[i] = arr[i].replace('1', ')');
        }

        return arr;
    }

    /**
     * This function is check string brackets and return TRUE if
     * bracket sequence is correct
     */
    static boolean checkString(String s){
        int openClose = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                openClose++;
            } else openClose--;
            if (openClose < 0)
                return false;
        }
        return openClose == 0;
    }
}