
public class Ybus_Java {

    public static void main(String[] args) {
        /**
         * Define the linedata matrix with columns: bus1, bus2, Resistance (pu), Reactance (pu)
         **/
        float[][] zdata = {
                {1, 2, 0.02f, 0.06f},
                {1, 3, 0.08f, 0.24f},
                {2, 3, 0.06f, 0.25f},
                {2, 4, 0.06f, 0.18f},
                {2, 5, 0.04f, 0.12f},
                {3, 4, 0.01f, 0.03f},
                {4, 5, 0.08f, 0.24f}
        };

        // Extract data

        /**@variable nl The starting bus number */
        int[] nl = new int[zdata.length]; // Starting bus numbers

        
        int[] nr = new int[zdata.length]; // Ending bus numbers
        float[] R = new float[zdata.length]; // Resistance (pu)
        float[] X = new float[zdata.length]; // Reactance (pu)

        for (int i = 0; i < zdata.length; i++) {
            nl[i] = (int) zdata[i][0];
            nr[i] = (int) zdata[i][1];
            R[i] = zdata[i][2];
            X[i] = zdata[i][3];
        }

        // Total number of buses (considering max bus number)
        int nbus = Math.max(Complex.findMax(nl), Complex.findMax(nr));

        // Initialize matrices
        Complex[] Z = new Complex[zdata.length];
        Complex[] y = new Complex[zdata.length];
        Complex[][] Ybus = new Complex[nbus][nbus];

        for (int i = 0; i < zdata.length; i++) {
            y[i] = new Complex(0, 0);
        }

        for (int i = 0; i < nbus; i++) {
            for (int j = 0; j < nbus; j++) {
                Ybus[i][j] = new Complex(0, 0);
            }
        }

        for(int i=0;i<zdata.length;i++){
            Z[i] = new Complex(R[i],X[i]);
            y[i] = Z[i].reciprocal();
        }

      
        // Form Bus Admittance matrix
        // Formation of off-diagonal elements
        for (int k = 0; k < zdata.length; k++) {
            int i = nl[k] - 1; // Start bus index (zero-based)
            int j = nr[k] - 1; // End bus index (zero-based)
            if (i >= 0 && j >= 0) {
                // Off-diagonal elements are the negative of the admittances
                Ybus[i][j] = Ybus[i][j].subtract(y[k]);
                Ybus[j][i] = Ybus[i][j]; // Symmetrical
            }
        }

        // Formation of diagonal elements
        for (int n = 0; n < nbus; n++) {
            for (int k = 0; k < zdata.length; k++) {
                int i = nl[k] - 1; // Start bus index (zero-based)
                int j = nr[k] - 1; // End bus index (zero-based)
                if (i == n || j == n) {
                    // Diagonal elements are the sum of the admittances
                    Ybus[n][n] = Ybus[n][n].add(y[k]);
                }
            }
        }

        System.out.println("Bus Admittance Matrix is:");
        for (int i = 0; i < nbus; i++) {
            for (int j = 0; j < nbus; j++) {
                System.out.print(Ybus[i][j].toString() + " ");
            }
            System.out.println();
        }
     }
 }