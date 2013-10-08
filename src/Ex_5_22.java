import java.lang.Math;

public class Ex_5_22 {

    public static double sqrt (double num){
        double nextGuess = 1;
        double lastGuess = 0;
        while(nextGuess - lastGuess < -0.0001 || nextGuess - lastGuess > 0.0001){
            lastGuess = nextGuess;
            nextGuess = (lastGuess + (num / lastGuess)) / 2;
        }
        return nextGuess;
    }

    public static void main (String[] args){
        System.out.println("                         The test for sqrt");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < 20; i++){
            System.out.printf("The sqrt of %d is %f, and the result of standard sqrt is %f\n", i, sqrt(i), Math.sqrt(i)); 
        }
    }

}
