public class Matrix_Functions {
    // Function to get the cofactor matrix
    public static void getCofactor(Complex[][] A, Complex[][] temp, int p, int q, int n) {
        int i = 0, j = 0;
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = A[row][col];
                    
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    // Function to find determinant of a matrix
    public static Complex determinant(Complex[][] A, int n) {
        Complex D = new Complex(0, 0);
        
        if (n == 1)
            return A[0][0];
        
        Complex[][] temp = new Complex[n][n];
        int sign = 1;
        
        for (int f = 0; f < n; f++) {
            getCofactor(A, temp, 0, f, n);
            D = D.add(A[0][f].multiply(determinant(temp, n - 1)).multiply(new Complex(sign, 0)));
            sign = -sign;
        }
        
        return D;
    }

    // Function to find adjoint of a matrix
    public static void adjoint(Complex[][] A, Complex[][] adj) {
        int N = A.length;
        
        if (N == 1) {
            adj[0][0] = new Complex(1, 0);
            return;
        }
        
        int sign = 1;
        Complex[][] temp = new Complex[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                getCofactor(A, temp, i, j, N);
                sign = ((i + j) % 2 == 0) ? 1 : -1;
                adj[j][i] = determinant(temp, N - 1).multiply(new Complex(sign, 0));
            }
        }
    }

    // Function to find inverse of a matrix
    public static Complex[][] inverse(Complex[][] A) {
        int N = A.length;
        Complex det = determinant(A, N);
        
        if (det.getReal() == 0 && det.getImag() == 0) {
            System.out.println("Singular matrix, can't find its inverse");
            return null;
        }
        
        Complex[][] adj = new Complex[N][N];
        adjoint(A, adj);
        
        Complex[][] inv = new Complex[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                inv[i][j] = adj[i][j].divide(det);  // Adjust if determinant is complex
            }
        }
        
        return inv;
    }
}
