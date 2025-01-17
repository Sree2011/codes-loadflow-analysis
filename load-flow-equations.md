<script src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js"></script>
<script type="module">
	import mermaid from 'https://cdn.jsdelivr.net/npm/mermaid@10/dist/mermaid.esm.min.mjs';
	mermaid.initialize({
		startOnLoad: true,
		theme: 'light'
	});
</script>

[Home](./README.md)

# Static Load flow Equations
Real Power,
$$
\begin{equation}
P_i = \text{Re}\left(V_i^* \left( V_i Y_{ii} + \sum_{j=1, j \neq i}^{n} V_j Y_{ij} \right) \right)
\end{equation}
$$

Reactive Power,
$$
\begin{equation}
Q_i = -\text{Im}\left(V_i^* \left( V_i Y_{ii} + \sum_{j=1, j \neq i}^{n} V_j Y_{ij} \right) \right)
\end{equation}
$$

Apparent power,
$$
S_i = V_i^* \left( V_i Y_{ii} + \sum_{j=1, j \neq i}^{n} V_j Y_{ij} \right)
$$



## Algorithm

1. Start
2. Input P,Q,V,y
3. - **Function 1: Calculate bus admittance matrix:**
        - **Input:** Line Admittance matrix
        - **Output:** Bus Admittance matrix
        - **Description:** Calculates bus admittance matrix
4. - **Function 2: Calculate real power:**
        - **Input:** Voltage matrix, Bus admittance matrix
        - **Output:** Real power matrix
        - **Description:** Calculates real power for each bus
5. - **Function 3: Calculate reactive power:**
        - **Input:** Voltage matrix, Bus admittance matrix
        - **Output:** Reactive power matrix
        - **Description:** Calculates reactive power for each bus
6. - **Function 4: Calculate apparent power:**
        - **Input:** Real power matrix, Reactive power matrix
        - **Output:** Apparent power matrix
        - **Description:** Calculates apparent power for each bus
7. - **Function 5: Display the results:**
        - **Input:** Voltage matrix, Bus admittance matrix, Real power matrix, Reactive Power matrix
        - **Output:** Display results
        - **Description:** Displays all matrices in the form of table
8. - **Function 6: Main function:**
        - **Input:** Command line args(Optional)
        - **Output:** DIsplay the results
        - **Description:** Main program for execution
9. Stop

## Class Diagram
<pre class="mermaid">
classDiagram
        class Complex{
        - float real
        - float imaginary
        + Complex(float real,float imaginary) Complex
        + getReal() float
        + getImag() float
        + fromString(String s) Complex
        + findMax(int[] array) int
        + add(Complex other) Complex
        + subtract(Complex other) Complex
        + multiply(Complex other) Complex
        + divide(Complex other) Complex
        + negate(Complex other) Complex
        + reciprocal(Complex other) Complex
        + toString() String
        }

        class Load_flow_Eqns{
                - Scanner sc
                + main(String args[]) void
                + calculate_ybus(Complex[][] y, int n) Complex[][]
                + calculate_real_power(Complex[][] ybus, Complex[][] V, int n) Complex[][]
                + calculate_reactive_power(Complex[][] ybus, Complex[][] V, int n) Complex[][]
                + calculate_apparent_power(Complex[][] P, Complex[][] Q, int n) Complex[][]
                + display_results(Complex[][] V,Complex[][] ybus,Complex[][] P,Complex[][] Q,Complex[][] S) void

        }

        Load_flow_Eqns --> Complex : uses
</pre>