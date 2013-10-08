import java.lang.Math;

public class Ex_5_23 {

    public static char getRandomCharacter(char ch1, char ch2){
        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
    }

    public static void main (String[] args){
        for (int i = 0; i < 100; i++){
            if (i % 10 == 0)
                System.out.println();
            System.out.print(getRandomCharacter('A','Z'));
        }
        System.out.println();
        for (int i = 0; i < 100; i++){
            if (i % 10 == 0)
                System.out.println();
            System.out.print(getRandomCharacter('a','z'));
        }
    }
}
