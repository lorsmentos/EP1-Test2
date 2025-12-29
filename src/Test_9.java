import java.util.Arrays;

public class Test_9 {
    static int[][] repeat(int[][] input, int[] reps) {
        int[][] result = new int[input.length][];
        for (int i = 0; i < reps.length; i++) {
            result[i] = new int[(input[i].length * Math.abs(reps[i])) + input[i].length];
        }
        for (int i = 0; i < result.length; i++) {
            int steps = 0;
            int fillCouter = 0;
            int  fillCouterReverse = input[i].length-1;
            while (steps < result[i].length) {
                if (reps[i]>=0) {
                    if (fillCouter > input[i].length - 1) {
                        fillCouter = 0;
                        result[i][steps] = input[i][fillCouter];
                        fillCouter++;
                        steps++;
                    } else {
                        result[i][steps] = input[i][fillCouter];
                        steps++;
                        fillCouter++;
                    }
                }
                else{
                    if (fillCouterReverse < 0) {
                        fillCouterReverse = input[i].length-1;
                        result[i][steps] = input[i][fillCouterReverse];
                        fillCouterReverse--;
                        steps++;
                    } else {
                        result[i][steps] = input[i][fillCouterReverse];
                        steps++;
                        fillCouterReverse--;
                    }

                }

            }

        }
        return result;
    }
    static void rasp(int[][] input){
        int end;
        if(input.length%2==0){
             end = input.length-2;
        }
        else {
             end = input.length-3;
        }
            for (int i = 0; i <=end; i=i+2) {
                int lastElement= input[i][input[i].length-1];
                int []helper0= input[i];
                input[i]= new int [input[i].length-1];
                int[] helper1 = input[i+1];
                input[i+1]=new int[input[i+1].length+1];
                for (int j = 0; j <input[i+1].length -1; j++) {
                    input[i+1][j]= helper1[j];
                }
                for (int k = 0; k <input[i].length; k++) {
                    input[i][k]= helper0[k];
                }

                input[i+1][input[i+1].length-1]=lastElement;


            }

    }
   static boolean hasNOrderedPairs(int[] seq, int n, int index){
       if (seq.length==0) {
           return true;

       }
       int []seqNew= new int[seq.length-1];
       for (int i = 1; i <seq.length ; i++) {
           seqNew[i-1]=seq[i];
       }
       return hasNOrderedPairs(seqNew,n,index);
   }

    static void main() {
        int[][] test1 = {{1}, {1, 2, 3}, {1, 2, 3, 4}, {1, 2}};
        int[][] test2 = {{1, 2, 3}, {0}, {1, 2}, {0}, {1}};
        int[] seq = {2, 8, 8, 5, 2, 5, 7, 3};
      //  System.out.println(Arrays.deepToString(repeat(test1, new int[]{0,-1, 2,-1})));
        rasp(test2);
        System.out.println(Arrays.deepToString(test2));
    }
}