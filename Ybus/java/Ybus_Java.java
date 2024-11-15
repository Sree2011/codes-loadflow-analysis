import java.util.*;

public class Ybus_Java {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of buses:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline

        System.out.println("Enter 1 for impedance and 2 for admittance:");
        int choice = sc.nextInt();
        sc.nextLine();

        Complex[][] y = new Complex[n][n];
        Complex[][] Ybus = new Complex[n][n];

        // Initialize the Ybus matrix with zeros
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Ybus[i][j] = new Complex(0, 0);
            }
        }

        if (choice == 1) {
            // Take impedance as input and calculate Admittance
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.println("Enter the impedance between bus " + (i+1) + " and bus " + (j+1));
                    String s = sc.nextLine();
                    y[i][j] = Complex.fromString(s);
                    y[i][j] = y[i][j].reciprocal();
                }
            }
        } else if (choice == 2) {
            // Take Admittance as input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.println("Enter the admittance between bus " + (i+1) + " and bus " + (j+1));
                    String s = sc.nextLine();
                    y[i][j] = Complex.fromString(s);
                }
            }
        }

        // Form bus admittance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) { // Diagonal elements
                    for (int k = 0; k < n; k++) {
                        Ybus[i][j] = Ybus[i][j].add(y[i][k]);
                    }
                } else {
                    Ybus[i][j] = y[i][j].negate();
                }
            }
        }

        // Display the Y-bus matrix
        System.out.println("Y-bus Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Ybus[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
