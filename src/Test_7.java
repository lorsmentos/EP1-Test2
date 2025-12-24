import java.util.Arrays;

public class Test_7 {
    static int[][] getRectangular(int[][] input) {
        int maxLen = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i].length > input[i - 1].length) {
                maxLen = i;
            }

        }
        int countThrough = 0;
        int[][] result = new int[input.length][input[maxLen].length];
        for (int i = 0; i < result.length; i++) {
            countThrough = 0;
            if (input[i].length != 0) {
                while (countThrough < result[i].length) {
                    int j = 0;
                    for (j = 0; j < input[i].length; j++) {
                        if (countThrough < result[i].length) {
                            result[i][countThrough] = input[i][j];
                            countThrough++;
                        }
                    }
                }
            }
        }

        return result;
    }

    static Object[] removeEntry(int[][] input, int col) {
        int result[][] = new int[input.length][];
        for (int i = 0; i < input.length; i++) {
            if (input[i].length > 2) {
                int stepsFill = 0;
                result[i] = new int[input[i].length - 1];
                for (int j = 0; j < input[i].length; j++) {
                    if (j == col) {
                        j++;
                    }
                    if (stepsFill < result[i].length) {
                        result[i][stepsFill] = input[i][j];
                        stepsFill++;
                    }
                }
            } else {
                result[i] = input[i];
            }
        }
        return result;
    }

    static boolean isAlternating(int[] seq, int index) {

        if (seq.length <= 1 ||(seq.length <= 2 && ((seq[0]<0 && seq[1]>0)||seq[0]<0 && seq[1]>0))||index>seq.length)  {
            return true;
        }
        boolean positive0=true;
        boolean positive1=true;
        if(seq[index]<0){
            positive0=false;
        }
        if (seq[index+1]<0){
            positive1=false;
        }
        if (positive0==positive1) {
            return false;
        }

        int[] seqNew = new int[seq.length - 1];
        for (int i = 1; i < seq.length; i++) {
            seqNew[i - 1] = seq[i];
        }
        if(index!=0){
            index=index-1;
        }

        return isAlternating(seqNew, index);
    }

    public static void main() {
        int[][] test1 = {{5}, {5, 7, 9}, {8, 5}, {}};
        int[][] test2 = {{1, 2}, {1, 2, 3}, {1, 2, 3, 4}};
        int[][] test3 = {{}, {1, 2, 3, 4}, {1}};
        int[][] test4 = {{1, 2, 3, 4, 5}, {1, 2, 3}, {1, 2, 3, 4}};
        int[] seq = {1, 2, -5, 3, -1, 6, -3, 3};
        System.out.println(Arrays.deepToString(getRectangular(test1)));
        System.out.println();
        System.out.println(Arrays.deepToString(getRectangular(test2)));
        System.out.println();
        System.out.println(Arrays.deepToString(getRectangular(test3)));
        System.out.println();
        System.out.println(Arrays.deepToString(removeEntry(test2, 2)));
        System.out.println();
        System.out.println(Arrays.deepToString(removeEntry(test4, 1)));
        System.out.println(isAlternating(seq, 0));
        System.out.println(isAlternating(seq, 1));
        System.out.println(isAlternating(seq, 6));
        System.out.println(isAlternating(seq, 7));
    }
}