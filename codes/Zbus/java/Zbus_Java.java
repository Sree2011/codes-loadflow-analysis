import java.util.*;


public class Zbus_Java {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the no.of buses:");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter 1 for impedance and 2 for admittance: ");
        int choice = sc.nextInt();
        sc.nextLine();
        Complex[][] y = get_input(choice,n);
        Complex[][] Ybus = calculate_matrix(y, n);
        Complex[][] Zbus = calculate_zbus(Ybus, n);
        display_matrix(Zbus, n);
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
                break;

            case 2:
                for(int i=0;i<nbus;i++){
                    for(int j=0;j<nbus;j++){
                        System.out.println("Enter the admittance between bus "+(i+1) +" and bus "+ (j+1)+" : ");
                        y[i][j] = Complex.fromString(sc.nextLine());
                        
                    }
                }
                break;
            default:
                System.out.println("Invalid input!");
                break;
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
     * This function calculates the bus impedance matrix.
     * @param Ybus Bus admittance matrix
     * @param n Total no.of buses in the system
     * @return Zbus Bus impedance matrix
     */
    public static Complex[][] calculate_zbus(Complex[][] Ybus, int nbus){
        

        Complex[][] Zbus = Matrix_Functions.inverse(Ybus);

        return Zbus;
    }


    /**
     * This function displays the bus admittance matrix.
     * @param Zbus Bus impedance matrix
     * @param n Total no.of buses in the system
     */
    public static void display_matrix(Complex[][] Zbus,int nbus) {
        System.out.println("Bus Impedance Matrix is:");
        for (int i = 0; i < nbus; i++) {
            for (int j = 0; j < nbus; j++) {
                System.out.print(Zbus[i][j].toString() + " ");
            }
            System.out.println();
        }
    }
}


