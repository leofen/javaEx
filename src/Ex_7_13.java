import java.util.Scanner;
import java.util.Arrays;

public class Ex_7_13 {

    public static int[] locateLargest (double[][] a){
        int[] position = new int[2];
        double max = a[0][0];

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                if (a[i][j] > max){
                    position[0] = j;
                    position[1] = i;
                    max = a[i][j];
                }
            }
        }

        return position;
    }

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        
        int rows = 0, columns = 0;
        System.out.print("Enter the number of rows and columns of the array : ");
        do {
            try {
                while (!input.hasNextLine()){}
                String[] tmpInput = input.nextLine().split(" ",2);
                if (tmpInput.length != 2)
                    throw new WrongInputException();
                rows = Integer.parseInt(tmpInput[0]);
                columns = Integer.parseInt(tmpInput[1]);
                break;
            } catch (WrongInputException e){
                System.out.print("Sorry, please input two number in a line and split with space : ");
            } catch (NumberFormatException e){
                System.out.print("Sorry, please input integer : ");
            }
        } while (true);

        double[][] array = new double[rows][columns];
        
        System.out.println("Enter the array:");
        for (int i = 0; i < rows; i++){
            do {
                try {
                    while (!input.hasNextLine()){}
                    String[] tmpInput = input.nextLine().split(" ",columns);
                    if (tmpInput.length != columns)
                        throw new WrongInputException();
                    for (int k = 0; k < columns; k++)
                        array[i][k] = Double.parseDouble(tmpInput[k]);
                    break;
                } catch (WrongInputException e){
                    System.out.printf("Sorry, please input %d doubles in a line : ",columns);
                } catch (NumberFormatException e){
                    System.out.print("Sorry, please input doubles : )");
                }
            } while (true);    
        }
        
        System.out.println("The location of the largest element is at " + Arrays.toString(locateLargest(array)));
        input.close();
    }
}

class WrongInputException extends Exception {
    private static final long serialVersionUID = 1L;
    public WrongInputException () {}
}
