import java.util.Scanner;

public class Ex_4_16 {
    
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input the num:");
        int num = 0;
        do {
            try {
                String tmpInput = input.nextLine();
                num = Integer.parseInt(tmpInput);
                if (num < 1)
                    throw new OverRangeException();
                break;
            } catch (NumberFormatException e){
                System.out.print("Sorry, wrong input, try again:");
            } catch (OverRangeException e){
                System.out.print("Sorry, wrong input, try again:");
            }
        } while (true);
        input.close();
        System.out.print("The Minimum factor is ");
        int i = 2;
        while(num > 1){
            if (num % i == 0){
                System.out.print(i + " ");
                num /= i;
                continue;
            }
            i++;
        }
        System.out.println();
    }
}

class OverRangeException extends Exception {
    private static final long serialVersionUID = 1L;  
    public OverRangeException(){}
}
