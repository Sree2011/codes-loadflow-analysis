
/**
 * This class creates a bus admittance matrix (Ybus).
 * Functions:
 * - {@code main()}: The main function that executes the formation of the Ybus matrix.
 */
import java.util.*;
public class Ybus_Java {

    /// \brief Scanner object to take input from the user
    static Scanner sc = new Scanner(System.in);

    /**
     * Main function that executes the formation of the Ybus matrix.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        System.out.println("Enter the no.of buses:");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter 1 for impedance and 2 for admittance: ");
        int choice = sc.nextInt();
        sc.nextLine();
        Complex[][] y = get_input(choice,n);
        Complex[][] Ybus = calculate_matrix(y, n);
        display_admittance_matrix(Ybus, n);


    }


    /**
     * This function takes the input from the user.
     * @param choice User choice: 1 for impedance and 2 for admittance
     * @param nbus Total no.of buses in the system
     * @return y line admittance matrix
     */
    public static Complex[][] get_input(int choice,int nbus){
        Complex[][] y = new Complex[nbus][nbus];

        /// \brief Initialize the line admittance matrix
        for (int i = 0; i < nbus; i++) {
            for (int j = 0; j < nbus; j++) {
                y[i][j] = new Complex(0, 0); // Initialize all elements
            }
        }

        switch(choice){
            case 1:
                for(int i=0;i<nbus;i++){
                    for(int j=0;j<nbus;j++){
                        System.out.println("Enter the impedance between bus "+(i+1) +" and bus "+ (j+1)+" : ");
                        Complex yij = Complex.fromString(sc.nextLine());
                        y[i][j] = yij.reciprocal();
                    }
                }

            case 2:
                for(int i=0;i<nbus;i++){
                    for(int j=0;j<nbus;j++){
                        System.out.println("Enter the admittance between bus "+(i+1) +" and bus "+ (j+1)+" : ");
                        y[i][j] = Complex.fromString(sc.nextLine());
                    }
                }
            default:
                System.out.println("Invalid input!");
        }

    
        return y;
        
    }




    /**
     * This function calculates the bus admittance matrix.
     * @param y Line admittance matrix
     * @param n Total no.of buses in the system
     * @return Ybus Bus admittance matrix
     */
    public static Complex[][] calculate_matrix(Complex[][] y, int n){
        Complex[][] Ybus = new Complex[n][n];

        /// \brief Initialize the bus admittance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Ybus[i][j] = new Complex(0, 0); // Initialize all elements
            }
        }


        for (int i = 0; i < n; i++) {
            /// \brief External loop
            for (int j = 0; j < n; j++) {
                /// \brief Internal loop
                if (i == j) {
                    for (int k = 0; k < n; k++) {
                        Ybus[i][j] = Ybus[i][j].add(y[i][k]);
                    }
                } else {
                    Ybus[i][j] = y[i][j].negate();
                }
            }
        }

        return Ybus;
    }


    /**
     * This function displays the bus admittance matrix.
     * @param Ybus Bus admittance matrix
     * @param n Total no.of buses in the system
     */
    public static void display_admittance_matrix(Complex[][] Ybus,int nbus) {
        System.out.println("Bus Admittance Matrix is:");
        for (int i = 0; i < nbus; i++) {
            for (int j = 0; j < nbus; j++) {
                System.out.print(Ybus[i][j].toString() + " ");
            }
            System.out.println();
        }
    }
}


