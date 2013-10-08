public class Ex_5_16 {
    
    public static int numberOfDaysInAYear(int year){
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)?366:365;
    }

    public static void main (String[] args){
        for (int i = 2000; i < 2010; i++)
            System.out.printf("The days of %d year is %d\n", i, numberOfDaysInAYear(i));
    }
}
