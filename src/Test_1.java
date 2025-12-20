int[][] generate(int[][] input){
int countRows=0;
int rowsFill=0;
    int inputLength= input.length;
    int [][] result= new int [inputLength*2-1][];
    for (int i=0;i<inputLength;i++){
        result[i]= new int [input[i].length-i];
        countRows++;
        for (int j=0;j< result[i].length;j++){
            result [i][j]=input[i][j];

        }
    }

    for (int i =result.length-1;i>=countRows;i--){
        result[i]=new int [inputLength-rowsFill];
        for (int j=0;j< result[i].length;j++){
            result [i][j]=input[rowsFill][j];
        }
        rowsFill++;
    }
    return result;
}

int[][] reorder(int[][] input){
    int temp=0;
    int start=0;

    for(int i =0;i<input.length;i++){
        int end= input[i].length-1;
        for(int j =0;j< input[i].length;j++){
          while(start<end) {
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
void main() {



    int[][] test1 = {{5, 2, 4}, {2, 7, 3}, {9, 5, 8}};
    int[][] test2 = {{1}};
    int[][] test3 = {{6, 7, 8}, {7, 5, 3, 1}, {2}};
    ;
    System.out.println(Arrays.deepToString(generate(test1)));
    System.out.println(Arrays.deepToString(generate(test2)));
   int result [][]= reorder(generate(test1));
    System.out.println(Arrays.deepToString(result));
   // System.out.println(Arrays.deepToString(generate(test3)));
}