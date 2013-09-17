import java.util.Scanner;

public class Ex_2_25 {
    public static void main (String[] args) {
        System.out.print("Enter the time zone offset to GMT:");
        Scanner input = new Scanner(System.in);
        int off = 0;
        do {
            try {
                String tmpInput = input.nextLine();
                off = Integer.parseInt(tmpInput);
                break;
            } catch (NumberFormatException e){
                System.out.print("Sorry, wrong input, try again:");
            }
        } while (true);
        input.close();
        long totalSeconds = System.currentTimeMillis() / 1000;
        totalSeconds += (off * 60 * 60);
        long currentSeconds = totalSeconds % 60;
        long currentMinutes = (totalSeconds / 60) % 60;
        long currentHours = (totalSeconds / (60 * 60)) % 24;
        System.out.format("Current time is %d:%d:%d\n", currentHours, currentMinutes, currentSeconds);
    }
}
