int[][] rearrange(int[][] inputArray) {

    int counter = 0;
    int stepsFill=0;
    for (int[] rows : inputArray) {
        for (int e : rows) {
            counter++;
        }
    }
    int [] helperArray= new int [counter];
    for (int i =0; i<inputArray.length;i++){
        for (int j = 0; j <inputArray[i].length ; j++) {
            helperArray[stepsFill]=inputArray[i][j];
            System.out.print(helperArray[stepsFill]+" ");
            stepsFill++;
        }
    }


    int[][] result = new int[(counter % 4) + 1][4];

    if (counter % 4 == 0) {
        result = new int[counter % 4][4];
    }
    boolean even=false;

    for (int i = 0; i < result.length; i++) {
        for (int j = 0; j < result[i].length; j++) {

        }
    }

    return result;
}

void label(int[][] inputArray) {
    for (int i = 0; i < inputArray.length - 1; i++) {
        boolean same = false;
        if (inputArray[i].length == inputArray[i + 1].length) {
            for (int j = 0; j < inputArray[i].length - 1; j++) {
                if (inputArray[i][j] == inputArray[i + 1][j]) {
                    same = true;
                } else {
                    same = false;
                }
            }
            if (same == true) {
                for (int k = 0; k < inputArray[i].length; k++) {
                    inputArray[i][k] = -9;
                }
            }
        }
    }
    System.out.println(Arrays.deepToString(inputArray));
}


int findMaxOppositeSum(int[] sequence, int start, int end) {
    if (start > end) {
        return 0;
    }
    int sum = sequence[start] + sequence[end];
    return Math.max(findMaxOppositeSum(sequence, start + 1, end - 1), sum);
}

void main() {
    int[][] test1 = {{5, 2, 4}, {8, 5, 4}, {9, 6, 8, 7}};
    int[][] test2 = {{0, 1, 2}, {0, 1, 2}, {0, 1, 2}};
    int[][] test3 = {{6}, {2, 4}, {2, 4}, {2, 4}, {4, 2}};
    int[] seq1 = {4, 3, 2, 1, 10, 5, 5, 5};
    System.out.println(findMaxOppositeSum(seq1, 0, 7));
    label(test3);
    label(test1);
    label(test2);
    System.out.println(Arrays.deepToString(rearrange(test1)));
}