
/**
 * This class creates a bus admittance matrix (Ybus).
 * Functions:
 * - {@code main()}: The main function that executes the formation of the Ybus matrix.
 */
import java.util.*;
public class Ybus_Java {

    
    /**
     * Main function that executes the formation of the Ybus matrix.
     * 
     * @param args Command line arguments.
     */

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the no.of buses:");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter 1 for impedance and 2 for admittance: ");
        int choice = sc.nextInt();
        sc.nextLine();

        Complex[][] Ybus = create_admittance_matrix(choice, n);
        display_admittance_matrix(Ybus, n);


    }

    
    public static Complex[][] create_admittance_matrix(int choice,int nbus){
        Complex[][] y = new Complex[nbus][nbus];
        Complex[][] Ybus = new Complex[nbus][nbus];

        // INITIALISE Ybus with zeros

        

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

        
        // Formation of Ybus





        
        return Ybus;
        
    }

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


