import java.util.Scanner;

public class Ex_7_9 {
    
    static final int O = 1;
    static final int X = 2;

    static int[][] map = new int[3][3];

    static int getIntegerInput(Scanner input){
        int result = 0;
        do {
            try {
                String tmpInput = "";
                while(!input.hasNextLine()){}
                tmpInput = input.nextLine();
                result = Integer.parseInt(tmpInput);
                if (result < 1 || result > 3)
                    throw new WrongInputException();
                break;
            } catch (WrongInputException e){
                System.out.print("Sorry, only 1 2 3 is allowed, try again:");
            } catch (NumberFormatException e){
                System.out.print("Sorry, wrong input, try again:");
            }
        } while (true);
        return result;
    }
 
    public static void showMap(){
        System.out.println("-------------");
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if (map[i][j] == O)
                    System.out.print("| O ");
                else if (map[i][j] == X)
                    System.out.print("| X ");
                else
                    System.out.print("|   ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    public static int check(){
        boolean full = true;

        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if (map[i][j] == 0)
                    full = false;
                else if (map[i][j] == O || map[i][j] == X){
                    int key = map[i][j];
                    //横向检索
                    if ( j - 1 >= 0 && j + 1 < map[i].length && map[i][j - 1] == key && map[i][j + 1] == key)
                        return key;
                    //纵向检索
                    else if ( i - 1 >= 0 && i + 1 < map.length && map[i - 1][j] == key && map[i + 1][j] == key)
                        return key;
                    //斜向检索
                    else if ( i - 1 >= 0 && j - 1 >= 0 && i + 1 < map.length && j + 1 < map[i].length && map[i - 1][j - 1] == key && map[i + 1][j + 1] == key)
                        return key;
                    else if ( i - 1 >= 0 && j - 1 >= 0 && i + 1 < map.length && j + 1 < map[i].length && map[i + 1][j - 1] == key && map[i - 1][j + 1] == key)
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

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        clearMap();
        showMap();
        int result = 0;
        boolean turn = true;

        do {
            if (result == -1){
                System.out.println("Draw ,continue");
                clearMap();
                showMap();
            }
            int x = 0, y = 0;
            do {
                System.out.printf("Enter a row (1,2 or 3) for player %c: ",(turn)?'X':'O');
                y = getIntegerInput(input) - 1;
                System.out.printf("Enter a column (1,2 or 3) for player %c: ",(turn)?'X':'O');
                x = getIntegerInput(input) - 1;
            } while (map[y][x] != 0);
            map[y][x] = (turn)?X:O;
            showMap();

            turn = !turn;
            result = check();
        } while (result != O && result != X);
        
        System.out.printf("%c player won\n",(result == X)?'X':'O');
        input.close();
    }
}

class WrongInputException extends Exception {
    private static final long serialVersionUID = 1L;
    public WrongInputException () {}
}
