import java.util.Scanner;

public class Ex_7_20 {
    
    static final int R = 1;
    static final int Y = 2;

    static int[][] map = new int[6][7];

    static int getIntegerInput(Scanner input){
        int result = 0;
        do {
            try {
                String tmpInput = "";
                while(!input.hasNextLine()){}
                tmpInput = input.nextLine();
                result = Integer.parseInt(tmpInput);
                if (result < 0 || result > 6)
                    throw new WrongInputException();
                break;
            } catch (WrongInputException e){
                System.out.print("Sorry, only (0-6) is allowed, try again:");
            } catch (NumberFormatException e){
                System.out.print("Sorry, wrong input, try again:");
            }
        } while (true);
        return result;
    }
 
    public static void showMap(){
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if (map[i][j] == R)
                    System.out.print("|R");
                else if (map[i][j] == Y)
                    System.out.print("|Y");
                else
                    System.out.print("| ");
            }
            System.out.println("|");
            System.out.println("---------------");
        }
    }

    public static int check(){
        boolean full = true;

        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if (map[i][j] == 0)
                    full = false;
                else if (map[i][j] == R || map[i][j] == Y){
                    int key = map[i][j];
                    //横向检索
                    if ( j + 3 < map[i].length && map[i][j + 1] == key && map[i][j + 2] == key && map[i][j + 3] == key)
                        return key;
                    //纵向检索
                    else if ( i + 3 < map.length && map[i + 1][j] == key && map[i + 2][j] == key && map[i + 3][j] == key)
                        return key;
                    //斜向检索
                    else if ( i + 3 < map.length && j + 3 < map[i].length && map[i + 1][j + 1] == key && map[i + 2][j + 2] == key && map[i + 3][j + 3] == key)
                        return key;
                    else if ( j - 3 >= 0 && i + 3 < map.length && map[i + 1][j - 1] == key && map[i + 2][j - 2] == key && map[i + 3][j - 3] == key)
                        return key;
                }
            }
        }

        return (full)?-1:0;
    }

    public static void clearMap(){
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++)
                map[i][j] = 0;
    }

    public static void clearArray(int[] a){
        for (int i = 0; i < a.length; i++)
            a[i] = 0;
    }

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        clearMap();
        showMap();
        int result = 0;
        boolean turn = true;
        int column = 0;
        int[] existDisks = new int[7];

        do {
            if (result == -1){
                System.out.println("Draw ,continue");
                clearMap();
                showMap();
                clearArray(existDisks);
            }
            do {
                System.out.printf("Enter a disk at column (0-6) for player %s: ",(turn)?"Yellow":"Red");
                column = getIntegerInput(input);
            } while (existDisks[column] >= 6 || map[6 - existDisks[column] - 1][column] != 0);
            map[6 - existDisks[column] - 1][column] = (turn)?Y:R;
            existDisks[column]++;
            showMap();

            turn = !turn;
            result = check();
        } while (result != R && result != Y);
        
        System.out.printf("%s player won\n",(result == Y)?"Yellow":"Red");
        input.close();
    }
}

class WrongInputException extends Exception {
    private static final long serialVersionUID = 1L;
    public WrongInputException () {}
}
