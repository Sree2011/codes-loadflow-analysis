
public class Matrix_Functions {
    

    public static Complex[][] add(Complex[][] A, Complex[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        Complex[][] result = new Complex[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j].add(B[i][j]);
            }
        }
        return result;
    }

    public static Complex[][] subtract(Complex[][] A, Complex[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        Complex[][] result = new Complex[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j].subtract(B[i][j]);
            }
        }
        return result;
    }

    public static Complex[][] multiply(Complex[][] A, Complex[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        Complex[][] result = new Complex[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = new Complex(0, 0);
                for (int k = 0; k < colsA; k++) {
                    result[i][j] = result[i][j].add(A[i][k].multiply(B[k][j]));
                }
            }
        }
        return result;
    }

    public static Complex[][] transpose(Complex[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        Complex[][] result = new Complex[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;
    }

    public static Complex[][] inverse(Complex[][] A) {
        int n = A.length;
        Complex[][] result = new Complex[n][n];
        Complex[][] augmentedMatrix = new Complex[n][2 * n];

        // Create the augmented matrix [A|I]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = A[i][j];
            }
            augmentedMatrix[i][i + n] = new Complex(1,0);
        }

        // Perform Gaussian elimination
        for (int i = 0; i < n; i++) {
            // Make the diagonal element 1
            Complex diagElement = augmentedMatrix[i][i];
            if (diagElement == new Complex(0,0)) {
                System.out.println("Matrix is singular");
                return null;
            }
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j].divide(diagElement);
            }

            // Make the other elements in the column 0
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    Complex factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[k][j] = augmentedMatrix[k][j].subtract(factor.multiply(augmentedMatrix[i][j]));
                    }
                }
            }
        }

        // Extract the inverse matrix from the augmented matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = augmentedMatrix[i][j + n];
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "Matrix_Functions []";
    }

    


}
