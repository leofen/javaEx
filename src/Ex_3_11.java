import java.util.Scanner;

public class Ex_3_11 {
    
    public static class OverRangeException extends Exception {
        private static final long serialVersionUID = 1L;  
        public OverRangeException(){}
    }
    
    final static String[] monthName = new String[]{"January ","February ","March ","April ","May ","June ","July ","August ","September ","October ","November ","December "};
    final static int[] monthLength = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input the month:");
        int month = 0;
        do {
            try {
                String tmpInput = input.nextLine();
                month = Integer.parseInt(tmpInput);
                if (month < 1 || month > 12)
                    throw new OverRangeException();
                break;
            } catch (NumberFormatException e){
                System.out.print("Sorry, wrong input, try again:");
            } catch (OverRangeException e){
                System.out.print("Sorry, wrong input, try again:");
            }
        } while (true); 

        System.out.print("Please input the year:");
        int year = 0;
        do {
            try {
                String tmpInput = input.nextLine();
                year = Integer.parseInt(tmpInput);
                if (year < 0)
                    throw new OverRangeException();
                break;
            } catch (NumberFormatException e){
                System.out.print("Sorry, wrong input, try again:");
            } catch (OverRangeException e){
                System.out.print("Sorry, wrong input, try again:");
            }
        } while (true); 
        input.close();

        boolean leap = ( ( year % 4 == 0 && year % 100 != 0) || year % 400 == 0 )?true:false;
        int days = (leap && month == 2)?29:monthLength[month - 1];
        System.out.println(monthName[month - 1] + year + " has " + days + " days ");
    }
}
