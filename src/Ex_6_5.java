import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Ex_6_5 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten integers(in a line, split with space):");
        int[] num = new int[10];
        do {
            try {
                String[] tmpInput = input.nextLine().split(" ",10);
                if (tmpInput.length != 10)
                    throw new WrongInputException();
                for (int i = 0; i < tmpInput.length; i++)
                    num[i] = Integer.parseInt(tmpInput[i]);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Wrong input, please try again:");
            } catch (WrongInputException e) {
                System.out.print("Wrong input, please try again:");
            }
        } while (true);
        input.close();
        //通过 Set 实现筛选元素
        Set<Integer> existNum = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++){
            existNum.add(new Integer(num[i]));
        }
        System.out.println("The distinct numbers are:" + existNum);
    }

}

class WrongInputException extends Exception {
    private static final long serialVersionUID = 1L;
    public WrongInputException () {}
}
