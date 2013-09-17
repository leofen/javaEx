
public class Ex_4_19 {
    
    public final static int HIGH = 8;

    public static void main (String[] args) {
        for (int i = 0; i < HIGH; i++){
            int begin = HIGH - i - 2;
            int end = HIGH + i;
            for (int j = 0; j < end; j++){
                if (j > begin){
                    System.out.format("%4d", (int)(Math.pow(2 , Math.min(Math.abs(j - begin),Math.abs(j - end)) - 1)));
                } else 
                    System.out.print("    ");
            }
            System.out.println();
        }
    }
}
