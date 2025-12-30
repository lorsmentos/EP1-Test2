import java.util.Arrays;

public class Test_10 {
    static boolean[][] create(int[] input) {
        boolean[][] result = new boolean[input.length][];
        for (int i = 0; i < input.length; i++) {
            result[i] = new boolean[Math.max(2, input[i]) + 1];
            if (result[i].length == 3) {
                if (input[i] < result[i].length - 1 && input[i] > 0) {
                    result[i][input[i]] = true;
                }
            } else {
                result[i][result[i].length - 1] = true;
            }
        }
        return result;
    }

    static void move(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i][input[i].length - 1] != 0) {
                int[] helper = input[i];
                input[i] = new int[input[i].length + 1];
                for (int j = 1; j < input[i].length; j++) {
                    input[i][j] = helper[j - 1];
                }
            } else {
                int[] helper = new int[input[i].length - 1];
                for (int j = 0; j < input[i].length - 1; j++) {
                    helper[j] = input[i][j];
                }
                for (int k = 1; k < input[i].length; k++) {
                    input[i][k] = helper[k - 1];
                }
                input[i][0] = 0;
            }
        }
    }
     static boolean oddOccurrences(String s, char ch) {
        if (s.isEmpty()) {
            return false;
        }
        boolean rest = oddOccurrences(s.substring(1), ch);

        if (s.charAt(0) == ch) {
            return !rest; // Umschalten
        } else {
            return rest;
        }
    }

    static void main() {
        int[] test1 = {3, 0, 6, -1, 1};
        int[][] test2 = {{0}, {6, -5}, {0, 0}, {0, 1, 2, 0}};
        int[][] test3 = {{1, 2, 7, 3, 0}, {-8}, {0, 2}, {1, 4, -2, 1}};
        System.out.println(Arrays.deepToString(create(test1)));
        System.out.println(Arrays.deepToString(create(new int[]{3})));
        System.out.println(Arrays.deepToString(create(new int[]{-2, 0})));
        move(test2);
        System.out.println(Arrays.deepToString(test2));
        move(test3);
        System.out.println(Arrays.deepToString(test3));
        System.out.println(oddOccurrences("This is not a test!", 's'));
        System.out.println(oddOccurrences("This is not a test!", 'T'));
        System.out.println(oddOccurrences("This is not a test!", 't'));
        System.out.println(oddOccurrences("This is not a test!", ' '));
        System.out.println(oddOccurrences("", 'x'));
    }
}