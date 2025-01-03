# Bus impedance matrix(Zbus)

- The Zbus matrix is usually built using the Zbus building algorithm.
- The bus impedance matrix (Zbus) is the inverse of the bus admittance matrix (Ybus).
- Here, the Ybus matrix is first formed, and then its inverse is taken to form the Zbus.

## Algorithm

1. **Get Input from the User:**
    - Define a function `get_input(choice, n)`:
        - If `choice` is 1:
            - For each bus `i` from 1 to `n`:
                - For each bus `j` from 1 to `n`:
                    - Prompt the user to enter the impedance between bus `i` and bus `j`.
                    - Store the reciprocal of the entered impedance in `y[i][j]`.
        - Else if `choice` is 2:
            - For each bus `i` from 1 to `n`:
                - For each bus `j` from 1 to `n`:
                    - Prompt the user to enter the admittance between bus `i` and bus `j`.
                    - Store the entered admittance in `y[i][j]`.
        - Return the matrix `y`.

2. **Calculate the Bus Admittance Matrix:**
    - Define a function `calculate_matrix(y, n)`:
        - For each bus `i` from 1 to `n`:
            - For each bus `j` from 1 to `n`:
                - If `i` is equal to `j`:
                    - For each bus `k` from 1 to `n`:
                        - Add `y[i][k]` to `Ybus[i][j]`.
                - Else:
                    - Set `Ybus[i][j]` to `-y[i][j]`.
        - Return the matrix `Ybus`.

3. **Calculate the Bus Impedance Matrix:**
    - Define a function `calculate_zbus(ybus)`:
        - Calculate the determinant of `ybus` and store it in `Det`.
        - If `Det` is 0:
            - Display "Matrix is singular".
        - Else:
            - Display "Bus Impedance matrix:".
            - Calculate the inverse of `ybus` and store it in `Inv`.
            - For each element `i` in `Inv`:
                - Display the element `i`.

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

    class Zbus_java{
        - Scanner sc
        + get_input(int choice, int n) Complex[][]
        + calculate_matrix(y,n) Complex[][]
        + calculate_zbus(ybus) Complex[][]
        + display_output(zbus) void
    }

    Zbus_java --> Complex : uses
</pre>

## Documentation

Here are the links to the documentation:

## Documentation

Here are the links to the documentations:


|Language|Link|
|:---:|:---:|
|Python|[Zbus_python](./docs/html/namespaceZbus__Python.html)|
|Java|[Zbus_java](./docs/html/Zbus__Java_8java.html)|
|MATLAB|[Zbus_matlab](./docs/html/Zbus__matlab_8m.html)|
