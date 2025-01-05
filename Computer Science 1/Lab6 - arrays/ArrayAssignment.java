import java.util.Arrays;

import javax.management.relation.Role;

public class ArrayAssignment {

    public static int allNumsWithin(int[] A, int k) {
        if(A.length>k){
            //if the array is empty
        if(A.length==0){
            return 0;
        }
        
        int len = A.length*2;

        for(int i = 0; i<A.length; i++){

            int[] check = new int[k];
            int counter = 0;

            for(int j = i; j<A.length && counter<k; j++){
                if(A[j]<k){
                if(check[A[j]]==0){
                    check[A[j]]=1;
                    counter++;
                }
                if((counter==k) && (j-i<len)){
                    len = j-i+1;
                }
            }
            }
        }
        if(len <= A.length){
            return len;
        }
        else{
            return 0;
        }
        }
        else{
            return 0;
        }
    }

    public static void diagonalPrint(int[][] M) {
        if(M.length<=M[0].length){
            int columns = M[0].length;
            int rows = M.length;
            int diagonals = columns + rows - 1;
            
            for(int i = 0; i<rows; i++){
                int x = i;
                int y = 0;

                while(x>=0){
                    System.out.print(M[x][y] + " ");
                    x--;
                    y++;
                }

            }

            for(int i = 1; i<columns; i++){
                int x = rows-1;
                int y = i;

                while(y<columns){
                    System.out.print(M[x][y] + " ");
                    x--;
                    y++;
                }
            }
        }
        else{
            int columns = M[0].length;
            int rows = M.length;
            int diagonals = columns + rows - 1;
            
            for(int i = 0; i<=rows-1; i++){
                int x = i;
                int y = 0;

                while(x>=0 && y<columns){
                    System.out.print(M[x][y] + " ");
                    x--;
                    y++;
                }
            }

            for(int i = 1; i<columns; i++){
                int x = rows-1;
                int y = i;

                while(y<columns){
                    System.out.print(M[x][y] + " ");
                    x--;
                    y++;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[][] matrix = {  {1,2},
                            {5,6},
                            {7,8}};

        diagonalPrint(matrix);

        int[] A = {0, 1, 1, 4, 3, 0, 1, 0, 0, 2};
        System.out.println();
        System.out.println(allNumsWithin(A, 3));
    }
}
