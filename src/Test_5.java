import java.util.Arrays;

public class Test_5 {
    static int[][] removeLeadingZeros(int[][] inputArray) {
        int[][] result = new int[inputArray.length][];
        for (int i = 0; i < inputArray.length; i++) {
            boolean numberPresent = false;
            int howMany0s = 0;
            for (int j = 0; j < inputArray[i].length; j++) {
                if (numberPresent == false) {
                    if (inputArray[i][j] == 0) {
                        howMany0s++;
                    } else {
                        numberPresent = true;
                    }
                }
            }
            result[i] = new int[inputArray[i].length - howMany0s];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = inputArray[i][j + howMany0s];
            }
        }

        return result;
    }

    static void mask(int[][] inputArray, int[] rows, int[] cols) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                for (int k = 0; k < rows.length; k++) {
                    for (int l = 0; l < cols.length; l++) {
                        if (i == rows[k] && j == cols[l]) {
                            inputArray[i][j] = 0;
                        }
                    }
                }
            }
        }
    }

    static String replicateCharacters(String sequence, String repSequence){
        if(sequence.length()==0){
            return "";
        }
        int rep0= ((int) repSequence.charAt(0));
        if ( rep0=='1'){
            return ""+sequence.charAt(0)+sequence.charAt(0)+replicateCharacters(sequence.substring(1),repSequence.substring(1));
        }

        return ""+sequence.charAt(0)+replicateCharacters(sequence.substring(1),repSequence.substring(1));
    }
    public static void main() {
        int[][] test1 = {{0, 2, 4}, {2, 0, 0}, {0, 0, 1}};
        int[][] test2 = {{1, 2, 3}, {1, 2, 3, 4, 5}, {1, 2, 3}, {1, 2, 3, 4, 5}};
        int[][] test3 = {{2}, {0, 7}, {6, 7, 8}, {6, 0}, {0, 0}};
        String seq1 = "ABA";
        System.out.println(Arrays.deepToString(removeLeadingZeros(test1)));
        System.out.println(Arrays.deepToString(removeLeadingZeros(test3)));

        int [] rows={1,2,3};
        int [] cols={0,1,4};
        mask(test2,rows,cols);
        System.out.println(Arrays.deepToString(test2));
        mask(test3,new int[]{0,2,4},new int[]{0,1});
        System.out.println(Arrays.deepToString(test3));
        mask(test1,new int[]{},new int[]{0,1});
        System.out.println(Arrays.deepToString(test1));
        System.out.println(replicateCharacters(seq1, "010"));
        System.out.println(replicateCharacters("SAMBA", "10001"));
    }
}