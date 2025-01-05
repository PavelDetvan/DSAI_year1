import java.util.Arrays;

public class MatrixMult {

    public static void main(String[] args) {
        //double[][] mat1 = {{1,5},{2,3},{1,7}};
        double[][] mat1 = {{3,4,2}};
        
        //double[][] mat2 = {{1,2,3,7},{5,2,8,1}};
        double[][] mat2 = {{13,9,7,15},{8,7,4,6},{6,4,0,3}};

       System.out.println(check(mat1, mat2));
       multiplyMatrices(mat1, mat2);
       
    }

    public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        double multipliedMatrix[][] = new double[firstMatrix.length][secondMatrix[0].length]; //creating new matrix
        int rows1 = firstMatrix.length;
        int cols1 = firstMatrix[0].length;
        int rows2 = secondMatrix.length;
        int cols2 = secondMatrix[0].length;

        if(check(firstMatrix, secondMatrix)==true){
            //for loop through matrixes and assigning multiplied values to the multipliedMatrix
            for(int i = 0; i<rows1; i++){
                for(int j = 0; j<cols2;j++){
                    for(int k = 0; k<cols1; k++){
                        multipliedMatrix[i][j] += firstMatrix[i][k]*secondMatrix[k][j];
                    }
                }
                
            }
             //printing matrix
            for(int i = 0; i<multipliedMatrix.length;i++){
                System.out.println(Arrays.toString(multipliedMatrix[i]));
            } 
        
        }
        else{
            System.out.println("WARNING");
        }
        return multipliedMatrix;
        
    }

    public static boolean check(double[][] firstMatrix, double[][] secondMatrix){
        //checking whether we can do the multiplication
        if(firstMatrix[0].length==secondMatrix.length){
            return true;
        }
        return false; 
    }
}
