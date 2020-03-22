import java.util.Scanner;

public class NumberArray {
    public static void  displayArray (int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.printf("%-6d", array[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] addElement (int[][] array) {
        Scanner scanner = new Scanner(System.in);
        int value;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.printf("Enter integer element at row %d - col %d: ", row,col);
                array[row][col] = scanner.nextInt();
            }
        }
        return array;
    }

    public static int[][] findMax(int[][] array) {
        int max = array[0][0];
        int[][] result = new int[2][];
        result[0] = new int[1];
        result[1] = new int[2];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] > max) {
                    max = array[row][col];
                    result[0][0] = max;
                    result[1][0] = row;
                    result[1][1] = col;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        int row;
        int col;

        do {
            System.out.print("Enter number of rows in matrix: ");
            row = scanner.nextInt();
            System.out.print("Enter number of cols in matrix: ");
            col = scanner.nextInt();
            if (row >= 0 && row <= 10 && col >= 0 && col <= 10) {
                isValid = true;
            } else {
                System.out.println("Invalid input! Maximum row and col is 10!");
            }
        } while (!isValid);

        System.out.println();
        int[][] demoArray = new int[row][col];
        addElement(demoArray);
        System.out.println();
        System.out.println("Here is your matrix");
        displayArray(demoArray);

        System.out.println("Let me find the maximum Element in this matrix!");
        int[][] result = findMax(demoArray);
        System.out.printf("The maximum element is at %d - %d with a value of %d", result[1][0], result[1][1], result[0][0]);

    }
}
