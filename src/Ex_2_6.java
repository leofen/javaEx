import java.util.Scanner;

public class Ex_2_6{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 1000:");
        int num = 0;
        do {
            try {
                String tmpInput = input.nextLine();
                num = Integer.parseInt(tmpInput);
                if (num < 0 || num > 1000)
                    throw new OverRangeException();
                break;
            } catch (NumberFormatException e){
                System.out.print("Sorry, wrong input, try again:");
            } catch (OverRangeException e){
                System.out.print("Sorry, wrong input, try again:");
            }
        } while (true); 
        input.close();
        int result = 0;
        while(num > 0){
            result += num%10;
            num /= 10;
        }
        System.out.println("The sum of the digits is " + result);
    }

}

class OverRangeException extends Exception {
    private static final long serialVersionUID = 1L;  
    public OverRangeException(){}
}
