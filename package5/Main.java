package package5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter the number of spiral array of numbers: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfSpiralArray = Integer.parseInt(scanner.nextLine());
        System.out.println("Yours spiralArray: "+numberOfSpiralArray);

        SpiralArray spiralArray = new SpiralArray(numberOfSpiralArray);
        spiralArray.display();
    }
}
