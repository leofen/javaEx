import java.util.Scanner;

public class Ex_6_18 {
    
    public static void bubbleSort(double[] nums){
        for (int i = nums.length - 1; i >= 0; i--){
            for (int j = 0; j < i; j++){
                if (nums[j] > nums[j + 1]){
                    double tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten doubles(in a line, split with space):");
        double[] num = new double[10];
        do {
            try {
                String[] tmpInput = input.nextLine().split(" ",10);
                if (tmpInput.length != 10)
                    throw new WrongInputException();
                for (int i = 0; i < tmpInput.length; i++)
                    num[i] = Double.parseDouble(tmpInput[i]);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Wrong input, please try again:");
            } catch (WrongInputException e) {
                System.out.print("Wrong input, please try again:");
            }
        } while (true);
        input.close();
        bubbleSort(num);
        System.out.print("After bubbleSort: ");
        for (int i = 0; i < num.length; i++)
            System.out.print(num[i] + " ");
        System.out.println();
    }

}
class WrongInputException extends Exception {
    private static final long serialVersionUID = 1L;
    public WrongInputException () {}
}
