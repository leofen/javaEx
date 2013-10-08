
public class Ex_6_20 {
    
    public static boolean queen(int num, int level, int[] placed){
        for(int i = 1; i <= num; i++){
            boolean flag = true;
            for(int j = 1; j < level; j++){
                if(placed[j] == i || Math.abs(placed[j] - i) == Math.abs(j - level)){
                    flag = false;
                    break;
                }
            }
            if (flag == true){
                placed[level] = i;
                if (num == level)
                    return true;
                else if (queen(num, level + 1, placed) == true)
                    return true;
            }
        }
        return false;
    }

    public static void displayQueen(int num){
        int[] placed = new int[num + 1];
        if (queen(num, 1, placed) == true){
            for (int i = 1; i <= num; i++){
                for (int j = 1; j <= num; j++){
                    if (placed[i] == j)
                        System.out.print("|Q");
                    else
                        System.out.print("| ");
                }
                System.out.println("|");
            }
        } else {
            System.out.println("Sorry, no result");
        }
    }

    public static void main (String[] args){
       displayQueen(8); 
    }
}
