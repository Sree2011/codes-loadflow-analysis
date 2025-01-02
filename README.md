<script src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js"></script>
<script type="module">
	import mermaid from 'https://cdn.jsdelivr.net/npm/mermaid@10/dist/mermaid.esm.min.mjs';
	mermaid.initialize({
		startOnLoad: true,
		theme: 'light'
	});
</script>
# Generate Bus Admittance Matrix


$$

\begin{equation*}

    \begin{bmatrix} 
    I_1 \\
    I_2 \\ 
    \vdots \\ 
    I_i \\ 
    \vdots 
    \\ I_n 
    \end{bmatrix}

    =

    \begin{bmatrix} 
    Y_{11} & Y_{12} & \cdots & Y_{1i} & \cdots & Y_{1n} \\
    Y_{21} & Y_{22} & \cdots & Y_{2i} & \cdots & Y_{2n} \\
    \vdots & \vdots & \ddots & \vdots & \ddots & \vdots \\ 
    Y_{i1} & Y_{i2} & \cdots & Y_{ii} & \cdots & Y_{in} \\ 
    \vdots & \vdots & \ddots & \vdots & \ddots & \vdots \\ 
    Y_{n1} & Y_{n2} & \cdots & Y_{ni} & \cdots & Y_{nn}
    \end{bmatrix}
    \begin{bmatrix} 
    V_1 \\ 
    V_2 \\ 
    \vdots \\ 
    V_i \\ 
    \vdots \\ 
    V_n 
    \end{bmatrix}

\end{equation*}
$$

$$
[I_{bus}] = [Y_{bus}][V_{bus}]
$$

**Formulas for calculation:**

For diagonal elements,
$$
Y_{ii} = \sum_{j=0}^{n}y_{ij}
$$

For off-diagonal elements,
$$
Y_{ij} = Y_{ji} = -y_{ij}
$$

where $y_{ij}$ is the admittance of the line between bus i and bus j.


# Algorithm

1. **Initialize Variables**:
   - Get the number of buses from the user.
   - Initialize the line admittance matrix and bus admittance matrix with zeros.

2. **Define Functions**:
   - **Function 1: get_input**
     - Input: User choice (impedance or admittance) and number of buses.
     - Output: Line Admittance Matrix.
     - Description: Gets the input from the user based on the choice and calculates admittance values.

   - **Function 2: calculate_admittance_matrix**
     - Input: Line Admittance Matrix.
     - Output: Bus Admittance Matrix.
     - Description: Forms the bus admittance matrix using the admittance value matrix.

   - **Function 3: print_admittance_matrix**
     - Input: Bus Admittance Matrix.
     - Output: None (prints the matrix to the console).
     - Description: Prints the bus admittance matrix.

3. **Main Function**:
   - Step 1: Ask the user to enter the number of buses.
   - Step 2: Ask the user to choose between impedance or admittance.
   - Step 3: Call `get_input` to get the line admittance matrix.
   - Step 4: Call `calculate_admittance_matrix` to form the bus admittance matrix.
   - Step 5: Call `print_admittance_matrix` to display the bus admittance matrix.


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

class Ybus_Java{
   - Scanner sc
   + main(String args[]) void
   + get_input(int choice, int n) Complex[][]
   + calculate_matrix(Complex[][] y, int n) Complex[][]
   + display_matrix(Complex[][] ybus, int n) void
}


Ybus_Java --> Complex: uses


</pre>
**Adding annotations for MATLAB and Python implementations:**
- **note for Complex**:\
In MATLAB and Python, inbuilt libraries are used instead of this custom Complex class.\
- **note for Ybus_Java**:\
The MATLAB and Python versions implement similar functionality using inbuilt functions and data structures.


## Documentation

Here are the links to the implementations:

1. [Python](./docs/html/namespaceYbus__Python.html)
2. [Java](./docs/html/classes.html)
3. [MATLAB](./docs/html/Ybus__matlab_8m.html)

## Documentation Tools

Here are the links to the documentation tools I used:

| Tool             | Link                                                                 | Description                                                                 |
|:----------------:|:--------------------------------------------------------------------:|:---------------------------------------------------------------------------:|
| Doxygen          | [Link to doxygen](https://doxygen.nl/index.html)                     | Used to generate documentation for java and python files                    |
| Octave Publish Command | [Octave documentation](https://www.gnu.org/software/octave/doc/interpreter/Publishing-Markdown.html) | Utilized to convert MATLAB scripts into documentation with integrated code, comments, and results |
| GitHub Actions   | [GitHub Actions documentation](https://docs.github.com/en/actions)   | Automated the generation and deployment of documentation. GitHub Actions helped streamline our CI/CD pipeline. |


## References

[1] Hadi Saadat, *"Power System Analysis"*. Psa Pub, United States, 2010.\
[2] Mohammad Shahidehpour; Yaoyu Wang, "Appendix C: IEEE30 Bus System Data," in Communication and Control in Electric Power Systems: Applications of Parallel and Distributed Processing , IEEE, 2003, pp.493-495, doi: 10.1002/0471462926.app3.
