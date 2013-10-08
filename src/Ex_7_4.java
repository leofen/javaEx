import java.util.Arrays;
import java.util.Comparator;

public class Ex_7_4 {

    static final int[][] workTimes = { 
        {0, 2, 4, 3, 4, 5, 8, 8 },
        {1, 7, 3, 4, 3, 3, 4, 4 },
        {2, 3, 3, 4, 3, 3, 2, 2 },
        {3, 9, 3, 4, 7, 3, 4, 1 },
        {4, 3, 5, 4, 3, 6, 3, 8 },
        {5, 3, 4, 4, 6, 3, 4, 4 },
        {6, 3, 7, 4, 8, 3, 8, 4 },
        {7, 6, 3, 5, 9, 2, 7, 9 }
    };

    public static void main (String[] args){
        int[][] totalTimeAndNo = new int[8][2];

        for (int i = 0; i < workTimes.length; i++){
            totalTimeAndNo[i][1] = i;
            for (int j = 0; j < workTimes[i].length; j++){
                totalTimeAndNo[i][0] += workTimes[i][j];
            }
        }
        
        Arrays.sort(totalTimeAndNo, new Comparator<int[]>() {
            @Override 
            public int compare(int[] o1, int[] o2){
                return ((Integer)o2[0]).compareTo(o1[0]);
            }
        });
        
        System.out.println("           总工时");
        for (int[] pair:totalTimeAndNo){
            System.out.printf("Employee %d  %d\n", pair[1], pair[0]);
        }
    }
}
