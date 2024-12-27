<script src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js"></script>
## View this project on github:[Github - Bus Admittance Matrix](https://github.com/Sree2011/bus-admittance-matrix/)

# Generate Bus Admittance Matrix

# Formulas for calculation

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

For diagonal elements,\
$Y_{ii} = \sum_{j=0}^{n}y_{ij}$\
For off-diagonal elements,\
$Y_{ij} = Y_{ji} = -y_{ij}$



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


## Flowchart

```mermaid
graph TD
    subgraph main["main()"]
        direction TB
        A([Start]) --> B[\Display 'Enter the number of buses'\]
        B --> B1[/Input n/]
        B1 --> C[[Initialize Ybus matrix with 0+0j]]
        C --> D[[Initialize y matrix with 0+0j]]
        D --> E[\Display 'Enter 1 for impedance and 2 for admittance'\]
        E --> E1[/Input choice/]
        E1 --> F{Choice}
        F -- 1 --> G[["Call get_input(choice, n) to get admittance matrix from impedances"]]
        F -- 2 --> H[["Call get_input(choice, n) to get admittance matrix from admittances"]]
        F -- Else --> AB[\Display 'Invalid Input'\]
        G --> I[["Call calculate_matrix(y, n)"]]
        H --> I
        I --> J[["Call display_matrix(Ybus)"]]
        J --> K([End])
        AB --> K
    end
    subgraph "get_input(choice,n)"
        direction TB
        V([Start]) --> K2{Choice}
        K2 -- 1 --> L1{For each bus i}
        L1 --> L2{For each bus j}
        L2 --> M1[/Take impedance as input/]
        M1 --> M2[[Calculate admittance]]
        M2 --> M3[/store into y/]
        M3 --> L1
        M3 --> Q1([Return y to main])
        K2 -- 2 --> O1{For each bus i}
        O1 --> O2{For each bus j}
        O2 --> P1[/Take admittance as input/]
        P1 --> P2[/store into y/]
        P2 --> O1
        P2 --> Q1
    end

    subgraph "calculate_matrix(y,n)"
        direction TB
        R([Start]) --> R1{For each bus i and j}
        R1 --> S1{i == j}
        S1 -- Yes --> T1[[Calculate diagonal elements]]
        S1 -- No --> V1[[Calculate off-diagonal elements]]
        V1 --> U1[[Next Iteration]]
        U1 --> R1
        U1 --> W1([Return Ybus to main])
    end

    subgraph "display_matrix(ybus,n)"
        direction TB
        X([Start]) --> X1[\Print Bus Admittance Matrix\]
        X1 --> Y1{For each row in Ybus}
        Y1 --> Z1{For each element in row}
        Z1 --> AA1[\Print each element\]
        AA1 --> AB1[\Print new line\]
        Z1 --> Z2[[Next Iteration]]
        Z2 --> Y1
        Y1 --> W2([Return Ybus to main])
    end
   

   classDef input fill:#98F5F9,stroke:#333,stroke-width:2px,text-align:center;
   classDef process fill:#7DDA58,stroke:#333,stroke-width:2px,text-align:center;
   classDef output fill:#FE9900,stroke:#333,stroke-width:2px,text-align:center;
   classDef loop fill:#AD840E,stroke:#333,stroke-width:2px,text-align:center;
   classDef decision fill:#BFD641,stroke:#333,stroke-width:2px,text-align:center;
   classDef startEnd fill:#BA62D1,stroke:#333,stroke-width:2px,text-align:center;


   class B1,E1,M1,P1,M3,P2 input
   class C,D,G,H,I,J,M2,T1,V1,U1,Z2 process
   class B,E,AB,X1,Z1,AA1,AB1 output
   class F,K2,S1 decision
   class A,K,V,Q1,W1,W2,R,X,Z3 startEnd
   class L1,L2,O1,O2,R1,Y1,Z1 loop
```


## Class Diagram

```mermaid
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


```
**Adding annotations for MATLAB and Python implementations:**
- **note for Complex**:\
In MATLAB and Python, inbuilt libraries are used instead of this custom Complex class.\
- **note for Ybus_Java**:\
The MATLAB and Python versions implement similar functionality using inbuilt functions and data structures.




## Pseudocode

```pseudocode
BEGIN
    INITIALIZE Ybus matrix of size (n x n) with 0+0j
    INITIALIZE y matrix of size (n x n) with 0+0j

    FUNCTION get_input(choice, n)
        IF choice == 1 THEN
            FOR each bus i from 1 to n DO
                FOR each bus j from 1 to n DO
                    PRINT "Enter the impedance between bus i and bus j:"
                    yij = INPUT complex number
                    y[i][j] = 1 / yij
                END FOR
            END FOR
        ELSE IF choice == 2 THEN
            FOR each bus i from 1 to n DO
                FOR each bus j from 1 to n DO
                    PRINT "Enter the admittance between bus i and bus j:"
                    y[i][j] = INPUT complex number
                END FOR
            END FOR
        END IF
        RETURN y
    END FUNCTION

    FUNCTION calculate_matrix(y, n)
        FOR each bus i from 1 to n DO
            FOR each bus j from 1 to n DO
                IF i == j THEN
                    FOR each bus k from 1 to n DO
                        Ybus[i][j] = Ybus[i][j] + y[i][k]
                    END FOR
                ELSE
                    Ybus[i][j] = -y[i][j]
                END IF
            END FOR
        END FOR
        RETURN Ybus
    END FUNCTION

    FUNCTION display_matrix(Ybus)
        PRINT "Bus Admittance Matrix:"
        FOR each row in Ybus DO
            FOR each element in row DO
                PRINT element
            END FOR
            PRINT new line
        END FOR
    END FUNCTION
   
   PRINT "Enter the number of buses:"
   n = INPUT integer
   PRINT "Enter 1 for impedance and 2 for admittance"
   choice = INPUT integer

    y = get_input(choice, n)
    Ybus = calculate_matrix(y, n)
    display_matrix(Ybus)
END

```

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




