
public class Ex_4_23 {
    public static void main (String[] args) {
        double result = 0;
        for (double i = 1.0; i <= 50000.0; i++){
            result += (1.0 / i);
        }
        System.out.println("from left to right: " + result);
        result = 0;
        for (double i = 50000.0; i >= 1.0; i--){
            result += (1.0 / i);
        }
        System.out.println("from right to left: " + result);
    }
}
