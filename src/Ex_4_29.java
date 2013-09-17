import java.util.Scanner;

public class Ex_4_29 {
    
    public static class OverRangeException extends Exception {
        private static final long serialVersionUID = 1L;  
        public OverRangeException(){}
    }
    
    final static String[] monthName = new String[]{"January ","February ","March ","April ","May ","June ","July ","August ","September ","October ","November ","December "};
    final static int[] monthLength = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    final static int[] monthLengthLeap = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input the year:");
        int year = 0;
        do {
            try {
                String tmpInput = input.nextLine();
                year = Integer.parseInt(tmpInput);
                if (year < 1)
                    throw new OverRangeException();
                break;
            } catch (NumberFormatException e){
                System.out.print("Sorry, wrong input, try again:");
            } catch (OverRangeException e){
                System.out.print("Sorry, wrong input, try again:");
            }
        } while (true); 
        System.out.print("Please input the first day's week number:");
        int week = 0;
        do {
            try {
                String tmpInput = input.nextLine();
                week = Integer.parseInt(tmpInput);
                if (week < 1 || week > 7)
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
        displayCalender(year , week , monthName , (leap)?monthLengthLeap:monthLength);
    }

    public static void displayCalender(int year, int week, String[] name, int[] length){
        for(int i = 0; i < 12; i++ ){
            System.out.println("               " + name[i] + year);
            System.out.println("   _______________________________________");
            System.out.println("   Sun   Mon   Tue   Wed   Thu   Fri   Sat");
            int sapceDays = week % 7;
            while(sapceDays-- > 0){
                System.out.print("      ");
            }
            for (int j = 1; j <= length[i]; j++){
                System.out.format("%6d",j);
                week = (week + 1) % 7;
                if (week == 0)
                    System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }

}
