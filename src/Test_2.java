/*
int[][] generate(int[][] input) gibt ein neues Array zurück, welches dieselbe Struktur wie input besitzt.
Jede Zeile der Kopie enthält zuerst alle negativen Einträge der entsprechenden Zeile in input, und anschließend alle positiven Werte (inkl. 0).
Die Reihenfolge innerhalb der negativen und positiven Werte wird nicht verändert. Vorbedingung(en): input != null.
*/

/*int[][] generate(int[][] input){
    int [][]result=new int[input.length][];
    int[] helper1=new int[0];
    int[] helper2= new int [0];
    int steps=0;
    int negative=0;
    int positive=0;
    for(int i=0;i<input.length;i++){
        result[i]=new int [input[i].length];
        for(int j =0;j<input[i].length;j++){
            if(input[i][j]<0){
                negative++;}
            else {
                positive++;
            }
        }
        helper1 = new int [negative];
        for(int o=0;0<helper1.length;o++){
            System.out.print(" "+helper1[o]);
        }
        helper2 = new int[positive];
        for(int k=0;k<result[i].length-1;k++){
            if(k<helper1.length) {
                result[i][k] = helper1[k];
            }
            else{
                result[i][k] = helper1[steps];
                steps++;

            }
        }
    }

    return result;
}
*/
void fill(int[][] target, int[] values, int[] times){
int count =0;
int posTimes =0;
int posFill =0;
    for (int i = 0 ; i<target.length;i++){
        for (int j =0; j<target[i].length;j++){
           if(count <times[posTimes]){
               count++;
               target[i][j]=values[posFill];
           }
           else{
               count=0;
               posTimes++;
               posFill++;
               target[i][j]=values[posFill];
               count++;
           }
        }
    }
}

void main() {
    int[][] test1 = {{1, 2, 0, -1, -2, 3}, {-1, 2, 3}, {0, 0}, {}, {4, 5, -1}};
    int[][] test2 = {{1, 2, 3}, {4, 5, 2}, {-2, -3, 2, -1}, {3, 2, 1, 5}, {4, 5, 1, 4}};
    int[][] test3 = {{1, -1, 2, -2, 3}, {1, 2, 3}, {-3, -1, -2}};
    char[] age1 = {'d', 'u', '-', 'd', 'u', '-', 'd', 'a', '-', 'd', 'a'};
    char[] age2 = {'m', 'a', 'm', 'a', '!', 'n', 'e', 'i', 'n'};
   // System.out.println(Arrays.deepToString(generate(test3)));
    fill(test3,test2[0],test2[1]);
    System.out.println(Arrays.deepToString(test3));
}

