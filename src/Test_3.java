int[][] labelPath(int n, int[][] points) {
    int[][] result = new int[n][n];
    int counter = 0;
    for (int i = 0; i < result.length; i++) {
        for (int j = 0; j < result[i].length; j++) {
            result[i][j] = n;
        }
    }
    for (int k = 0; k < points.length; k++) {
        result[points[k][0]][points[k][1]] = -1;
    }
    return result;
}

void findMatches(int[][] data, int[] pattern, int[] target) {

    for (int i = 0; i < data.length; i++) {
        int count = 0;
        for (int j = 0; j < data[i].length; j++) {
            if (j + 1 < data[i].length) {
                if (data[i][j]==pattern[0] && data[i][j + 1] == pattern[1]) {
                    count++;
                }
            }
            target[i] = count;
        }
    }
    for(int k=0;k<target.length;k++){
        System.out.print(target[k]+" ");
    }

}

void main() {
    int []pattern={0,1};
    int[][] data0 = {{3, 0}, {0, 1}, {2, 2}};
    int[][] data1 = {{0, 1, 0, 0, 1, 0}, {}, {2, 2, 2, 2, 0, 1}};
    int[][] data5 = {{0, 1, 1, 1, 0, 0}, {0,1}, {2, 2, 0, 1, 0, 1}};
    int[][] data3 = {{3, 1}, {2, 1}, {2, 0}};
    int[] target1 = {0, 0, 0};
    int[] target2 = {9, 9, 9, 9};
    System.out.println(Arrays.deepToString(labelPath(4, data0)));
    System.out.println(Arrays.deepToString(labelPath(5, data3)));
    findMatches(data1,pattern,target1);
    System.out.println();
    findMatches(data5,pattern,target1);

}