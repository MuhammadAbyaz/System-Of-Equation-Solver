import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] arrayOfCoefficient = new int[3][3];
        int[][] arrayOfConstant = new int[3][1];

        System.out.println("Enter coefficient of x, y and z: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrayOfCoefficient[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter constant terms: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                arrayOfConstant[i][j] = scanner.nextInt();
            }
        }
        System.out.println("The value of first variable is: " + (firstVariableDeterminant(arrayOfCoefficient, arrayOfConstant)) / determinant(arrayOfCoefficient));
        System.out.println("The value of second variable is: " + (secondVariableDeterminant(arrayOfCoefficient, arrayOfConstant)) / determinant(arrayOfCoefficient));
        System.out.println("The value of third variable is: " + (thirdVariableDeterminant(arrayOfCoefficient, arrayOfConstant)) / determinant(arrayOfCoefficient));
    }
    
    public static int firstVariableDeterminant(int[][] arrayOfCoefficient, int[][] arrayOfConstant) {
        int[][] firstMatrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                firstMatrix[i][j] = arrayOfCoefficient[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                firstMatrix[i][j] = arrayOfConstant[i][j];
            }
        }
        return determinant(firstMatrix);
    }

    public static int secondVariableDeterminant(int[][] arrayOfCoefficient, int[][] arrayOfConstant) {
        int[][] secondMatrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                secondMatrix[i][j] = arrayOfCoefficient[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                secondMatrix[i][j + 1] = arrayOfConstant[i][j];
            }
        }
        return determinant(secondMatrix);
    }

    public static int thirdVariableDeterminant(int[][] arrayOfCoefficient, int[][] arrayOfConstant) {
        int[][] thirdMatrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                thirdMatrix[i][j] = arrayOfCoefficient[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                thirdMatrix[i][j + 2] = arrayOfConstant[i][j];
            }
        }
        return determinant(thirdMatrix);
    }

    public static int determinant(int[][] matrix) {
        int firstDeterminant = matrix[0][0] * ((matrix[2][2] * matrix[1][1]) - (matrix[1][2] * matrix[2][1]));
        int secondDeterminant = -matrix[0][1] * ((matrix[2][2] * matrix[1][0]) - (matrix[2][0] * matrix[1][2]));
        int thirdDeterminant = matrix[0][2] * ((matrix[2][1] * matrix[1][0]) - (matrix[1][1] * matrix[2][0]));
        int determinantOfMatrix = firstDeterminant + secondDeterminant + thirdDeterminant;
        return determinantOfMatrix;
    }

}