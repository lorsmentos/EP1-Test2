import java.util.Arrays;

public class Test_6 {
    static int[][] countdown(int[][] rules) {
        int[][] result = new int[rules.length][];
        for (int i = 0; i < rules.length; i++) {
            int counter = 0;
            int threshhold = rules[i][0];
            int start = rules[i][2];
            int subtract = rules[i][1];
            while (start >= threshhold) {
                start = start - subtract;
                counter++;
            }
            result[i] = new int[counter];
            threshhold = rules[i][0];
            start = rules[i][2];
            subtract = rules[i][1];
            for (int j = 0; j < result[i].length; j++) {
                int formula = start - subtract;
                result[i][j] = start;
                start = formula;
            }
        }
        return result;
    }

    static void extract(String[][] info, int[] positions) {
        int tooLong = 0;
        int even = 0;
        int odd = 1;
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[i].length; j++) {
                if (info[i][j].equals("SS21")) {
                    positions[even] = i;
                    positions[odd] = j;
                    even += 2;
                    odd += 2;
                    tooLong++;
                }
            }
            if (tooLong < positions.length) {
                int lastPos = Math.max(even, odd);
                for (int j = lastPos; j < positions.length; j++) {
                    positions[j] = -21;
                }
            }
        }
    }

    static boolean backAndForth(String csequence) {
        boolean only2 = false;
        if (csequence.length() == 2) return true;
        char c0 = csequence.charAt(0);
        char c1 = csequence.charAt(1);
        char c2 = csequence.charAt(2);
        if (c0 != c2 || c1 == c0) return false;
        return backAndForth(csequence.substring(1));
    }

    static void main() {
        int[][] pattern1 = {{0, 4, 16}, {1, 2, 10}, {4, 4, 7}};
        int[][] pattern2 = {{5, 22, 50}, {5, 2, 11}, {4, 2, 11}, {-2, 3, 10}};
        String[][] sem1 = {"WS20;SS21;WS21".split(";"), "SS21;gut;versteckt".split(";"), "SS21a;SS21;SS 21".split(";")};
        String[][] sem2 = {"last;test;in;SS21".split(";"), "SS21;endet;SS21".split(";"), "#TU;#;SS21;#Covid".split(";")};
        String[][] sem3 = {"nicht;versteckt".split(";"), {"SS21"}, "nur;ein;Text".split(";")};
        int[] ss21pos = new int[2 * sem1.length];
        int[] ss21pos2 = new int[4 * sem1.length];
        System.out.println(Arrays.deepToString(countdown(pattern1)));
        extract(sem1, ss21pos);
        for (int s = 0; s < ss21pos.length; s++) {
            System.out.print(ss21pos[s] + " ");
        }
        System.out.println();
        extract(sem1, ss21pos2);
        for (int k = 0; k < ss21pos2.length; k++) {
            System.out.print(ss21pos2[k] + " ");
        }
        System.out.println();
        String testString = "ababababababababababab";
        System.out.println(backAndForth(testString));
        System.out.println();
        String testString2 = "ababababaa" +
                "babababababab";
        System.out.println(backAndForth(testString2));
    }
}