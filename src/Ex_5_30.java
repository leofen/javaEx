public class Ex_5_30 {

    /*
     * 筛法找素数
     */
    public static void sieve (boolean[] num, int n){
        num[1] = false;//1不是素数也不是合数
        for (int i = 2; i < n; i++){
            if (num[i] == true){
                int muti = 2;
                while(muti * i < n){
                    num[muti * i] = false;
                    muti++;
                }
            }
        }
    }

    public static void main (String[] args){
        boolean[] num = new boolean[1001];
        for (int i = 1; i < 1001; i++)
            num[i] = true;
        sieve(num, 1001);
        for (int i = 1; i < 1001; i++){
            if (num[i] == true && i + 2 < 1001 &&num[i + 2] == true)
                System.out.printf("(%d,%d)\n", i, i + 2);
        }
    }
}
