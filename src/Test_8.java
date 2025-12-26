import java.util.Arrays;

public class Test_8 {
    //Aufgabe 1
    static int[][] addTriangle(int[][] input) {
        int rows = 0;
        int copyIndex = 0;
        int result[][] = new int[input[0].length + input.length][];
        for (int i = 0; i < input[0].length; i++) {
            result[i] = new int[i + 1];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = i + 1;
            }
            rows++;
        }
        for (int j = rows; j < result.length; j++) {
            result[j] = input[copyIndex];
            copyIndex++;
        }
        return result;
    }

    //Aufgabe 2
    static void reverseBetween(int[][] input, int ind1, int ind2) {
        int max = Math.max(ind1, ind2);
        int min = Math.min(ind1, ind2);
        int helperMax = max;
        if (max != min + 1) {
            for (int i = min; i < max - min; i++) {
                int[] temp = input[i];
                input[i] = input[helperMax];
                input[helperMax] = temp;
                helperMax--;
            }
        } else {
            int[] temp = input[min];
            input[min] = input[max];
            input[max] = temp;
        }
    }

    static String clean(String seq){
        if(seq.isEmpty()){
            return "";
        }
int maxIndex= seq.length()-1;
        if(seq.charAt(0)=='('){
            if(seq.charAt(maxIndex)==')'){
                String result= seq.substring(1,seq.length()-1);
                return result;
            }
            return clean(seq.substring(0,seq.length()-1));
        }
        if (seq.charAt(maxIndex)==')'){
            if(seq.charAt(0)=='('){
                String result= seq.substring(1,seq.length()-1);
                return result;
            }
            return clean(seq.substring(1));
        }
        return clean(seq.substring(1,seq.length()-1));
    }

    static void main() {
        int[][] test1 = {{5, 7, 5, 7}, {5}, {0, 1, 1, 0}};
        int[][] test2 = {{5, 7, 9}, {5}, {8, 5}, {2}, {3}};
        int[][] test3 = {{1, 2}, {1, 2, 3}, {}};
        String seq = "1(234)67";
        String seq2 = "125167362767352175(I_return_correctly)849184781740927094";
        System.out.println(Arrays.deepToString(addTriangle(test1)));
        System.out.println();
        reverseBetween(test1, 2, 1);
        System.out.println(Arrays.deepToString(test1));
        reverseBetween(test2, 1, 4);
        System.out.println(Arrays.deepToString(test2));
        reverseBetween(test3, 2, 2);
        System.out.println(Arrays.deepToString(test3));
        reverseBetween(test3, 0, 2);
        System.out.println(Arrays.deepToString(test3));
        System.out.println();
    //    System.out.println(clean(seq));
        System.out.println(clean(seq2));
    }
}