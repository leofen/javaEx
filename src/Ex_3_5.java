import java.util.Scanner;

public class Ex_3_5 {
    
    public static void main (String[] args) {
        int number1 = (int) (System.currentTimeMillis() % 10);
        int number2 = (int) (System.currentTimeMillis() * 3 % 10);
        int number3 = (int) (System.currentTimeMillis() * 5 % 10);
        Scanner input = new Scanner(System.in);
        System.out.print("What is the answer of " + number1 + " + " + number2 + " + " + number3 + " ? ");
        int result = 0;
        do {
            try {
                String tmpInput = input.nextLine();
                result = Integer.parseInt(tmpInput);
                break;
            } catch (NumberFormatException e){
                System.out.print("Sorry, wrong input, try again:");
            }
        } while (true);
        input.close();
        System.out.println(number1 + " + " + number2 + " + " + number3 + " = " + result + " is " + (number1 + number2 + number3 == result));
    }
}
