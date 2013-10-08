import java.util.Scanner;
import java.lang.Math;

public class Ex_6_21 {

    static int getIntegerInput(Scanner input){
        int result = 0;
        do {
            try {
                String tmpInput = "";
                while(!input.hasNextLine()){}
                tmpInput = input.nextLine();
                result = Integer.parseInt(tmpInput);
                if (result <= 0)
                    throw new WrongInputException();
                break;
            } catch (WrongInputException e){
                System.out.print("Sorry, wrong input, try again:");
            } catch (NumberFormatException e){
                System.out.print("Sorry, wrong input, try again:");
            }
        } while (true);
        return result;
    }

    public static void main (String[] args){
        int ballSum = 0;
        int slotSum = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of balls to drop: ");
        ballSum = getIntegerInput(input);
        System.out.print("Enter the number of slots in the bean machine: ");
        slotSum = getIntegerInput(input);
        System.out.println();
        input.close();

        int[] slots = new int[slotSum + 1];

        for(int i = 0; i < ballSum; i++){
            int endPlace = 0;
            for(int j = 0; j < slotSum; j++){
                char dirction = ((int)(Math.random() * 2) == 0)?'L':'R';
                if (dirction == 'R')
                    endPlace++;
                System.out.print(dirction);
            }
            System.out.println();
            slots[endPlace]++;
        }
        System.out.println();

        int level = 0;
        for(int i = 0; i <= slotSum; i++)
            if(slots[i] > level)
                level = slots[i];

        for(; level > 0; level--){
            for(int i = 0; i <= slotSum; i++){
                char space = ' ';
                if (slots[i] == level){
                    space = 'O';
                    slots[i]--;
                }
                System.out.print(space);
            }
            System.out.println();
        }
    }
}

class WrongInputException extends Exception {
    private static final long serialVersionUID = 1L;
    public WrongInputException () {}
}
