// Aufgabe 1
int[][] generate(int[][] input) {
    int countRows = 0;
    int rowsFill = 0;
    int inputLength = input.length;
    int[][] result = new int[inputLength * 2 - 1][];
    for (int i = 0; i < inputLength; i++) {
        result[i] = new int[input[i].length - i];
        countRows++;
        for (int j = 0; j < result[i].length; j++) {
            result[i][j] = input[i][j];
        }
    }

    for (int i = result.length - 1; i >= countRows; i--) {
        result[i] = new int[inputLength - rowsFill];
        for (int j = 0; j < result[i].length; j++) {
            result[i][j] = input[rowsFill][j];
        }
        rowsFill++;
    }
    return result;
}

// Aufgabe 2
int[][] reorder(int[][] input) {
    for (int i = 0; i < input.length; i++) {
        int end = input[i].length - 1;
        int temp = 0;
        int start = 0;
        for (int j = 0; j < input[i].length; j++) {
            while (start < end) {
                temp = input[i][end];
                input[i][end] = input[i][start];
                input[i][start] = temp;
                start++;
                end--;
            }
        }
    }
    return input;
}

boolean isPresentNTimes(String sequence, char marker, int count) {
    if (sequence.isEmpty()) {
        return count==0;
    }
    if (sequence.charAt(0) == marker) {
        isPresentNTimes(sequence.substring(1), marker, count=count-1);
    }
        return isPresentNTimes(sequence.substring(1), marker, count);
}

void main() {
    int count;
    int[][] test1 = {{5, 2, 4}, {2, 7, 3}, {9, 5, 8}};
    int[][] test2 = {{1}};
    int[][] test3 = {{6, 7, 8}, {7, 5, 3, 1}, {2}};
    ;
    System.out.println(Arrays.deepToString(generate(test1)));
    System.out.println(Arrays.deepToString(generate(test2)));
    int result[][] = reorder(generate(test1));
    System.out.println(Arrays.deepToString(result));
    // System.out.println(Arrays.deepToString(generate(test3)));
    String seq1 = "ABBAACBA";
 System.out.println(isPresentNTimes(seq1,'A',4));
 System.out.println(isPresentNTimes(seq1,'A',3));
 System.out.println(isPresentNTimes(seq1,'A',5));
 System.out.println(isPresentNTimes(seq1,'A',0));
}