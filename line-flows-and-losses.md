<script src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js"></script>
<script type="module">
	import mermaid from 'https://cdn.jsdelivr.net/npm/mermaid@11.4/dist/mermaid.esm.min.mjs';
	mermaid.initialize({
		startOnLoad: true,
		theme: 'light'
	});
</script>

[Home](./README.md)

# Line Flows and Line Losses

Finding line flows and line losses in a power system.


## Formulas for Calculation

### Voltage Between Buses

- **Bus i and bus j**:
  $$
  V_{ij} = V_{i} - V_{j}
  $$

- **Bus j and bus i**:
  $$
  V_{ji} = V_{j} - V_{i}
  $$

### Current Calculation

- **Current from bus i to bus j**:
  $$
  I_{ij} = y_{ij}(V_i - V_j) + y_{i0} V_i
  $$

- **Current from bus j to bus i**:
  $$
  I_{ji} = y_{ji}(V_j - V_i) + y_{j0} V_i
  $$

### Line Flows

- **From bus i to bus j**:
  $$
  S_{ij} = V_{ij}I_{ij}^{*}
  $$

- **From bus j to bus i**:
  $$
  S_{ji} = V_{ji}I_{ji}^{*}
  $$

### Line Losses

  $$
  S_{L_{ij}} = S_{ij} + S_{ji}
  $$


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
   + negate() Complex
   + reciprocal() Complex
   + toString() String
}

class Lineflow_Loss{
    - Scanner sc
    + main(String args[]) void
    + get_input(int n, Complex[][] V, Complex[][] I, Complex[][] y) (ArrayList<Complex[][]>)
    + calculate_lineflow_loss(int n, Complex[][] V, Complex[][] I, Complex[][] y) (ArrayList<Complex[][]>)
    + display_output(int n, Complex[][] V, Complex[][] I, Complex[][] S, Complex[][] SL) void
}

Lineflow_Loss --> Complex: uses
</pre>

## Documentation

|Language|Link|
|:---:|:---:|
|Python|[Lineflows_python](./docs/html/namespacelineflow__loss.html)|
|Java|[Lineflows_java](./docs/html/classlineflow__loss.html)|
|MATLAB|[Lineflows_matlab](./docs/html/lineflow__loss_8m.html)|