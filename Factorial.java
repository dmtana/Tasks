package package8;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {

        // Switch to string (to easy work)
        String f100 = ""+fact(100);

        int factorial = 0;

        // Sum all number of 100!
        for(int i = 0; i < f100.length(); i++){
            factorial += Integer.parseInt(""+f100.charAt(i));
        }

        System.out.println(factorial);
    }

    /**
     * Function to find the factorial of number
     * */
    private static BigInteger fact(long n) {
        BigInteger result = BigInteger.ONE;
        for (long i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
