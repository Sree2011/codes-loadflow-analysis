<script type="module">
	import mermaid from 'https://cdn.jsdelivr.net/npm/mermaid@10/dist/mermaid.esm.min.mjs';
	mermaid.initialize({
		startOnLoad: true,
		theme: 'light'
	});
</script>

[Home](./README.md)

# Bus impedance matrix(Zbus)

- The Zbus matrix is usually built using the Zbus building algorithm.
- The bus impedance matrix (Zbus) is the inverse of the bus admittance matrix (Ybus).
- Here, the Ybus matrix is first formed, and then its inverse is taken to form the Zbus.

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

    class Matrix_Functions{
        + getCofactor(Complex[][] A, Complex[][] temp, int p, int q, int n) void
        + determinant(Complex[][] A, int n) Complex
        + adjoint(Complex[][] A, Complex[][] adj) void
        + inverse(Complex[][] A) Complex[][]

    }

    class Zbus_java{
        - Scanner sc
        + get_input(int choice, int n) Complex[][]
        + calculate_matrix(Complex[][] y,int n) Complex[][]
        + calculate_zbus(Complex[][] ybus) Complex[][]
        + display_output(Complex[][] zbus) void
    }

    Zbus_java --> Complex : uses
    Zbus_java --> Matrix_Functions : uses
    Matrix_Functions --> Complex : uses

</pre>

## Documentation

Here are the links to the documentation:

|Language|Link|
|:---:|:---:|
|Python|[Zbus_python](./docs/html/namespaceZbus__Python.html)|
|Java|[Zbus_java](./docs/html/Zbus__Java_8java.html)|
|MATLAB|[Zbus_matlab](./docs/html/Zbus__matlab_8m.html)|
