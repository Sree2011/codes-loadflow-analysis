## Generate Bus Admittance Matrix

## Algorithm

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

    FUNCTION calculate_admittance_matrix(y, n)
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

    FUNCTION print_admittance_matrix(Ybus)
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
    Ybus = calculate_admittance_matrix(y, n)
    print_admittance_matrix(Ybus)
END

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

end

```
**Adding annotations for MATLAB and Python implementations:**
- **note for Complex**:\
In MATLAB and Python, inbuilt libraries are used instead of this custom Complex class.\
- **note for Ybus_Java**:\
The MATLAB and Python versions implement similar functionality using inbuilt functions and data structures.


## Flowchart

```mermaid
graph TD
   subgraph "FUNCTION main()"
   direction TB
      A([Start]) --> B[Display 'Enter the number of buses']@{shape: lean-right}
      B --> B1[Input n]@{shape: lean-left}
      B1 --> C[Initialize Ybus matrix with 0+0j]
      C --> D[Initialize y matrix with 0+0j]
      D --> E[Display 'Enter 1 for impedance and 2 for admittance']@{shape: lean-right}
      E --> E1[Input choice]@{shape: lean-left}
      E1 --> F[Choice]@{shape: hex}
      F -->|1| G[["Call get_input(choice, n) to get admittance matrix from impedances"]]
      F -->|2| H[["Call get_input(choice, n) to get admittance matrix from admittances"]]
      F --> |Else| AB[Display 'Invalid Input']@{shape: lean-right}
      G --> I[["Call calculate_admittance_matrix(y, n)"]]
      H --> I
      I --> J[["Call print_admittance_matrix(Ybus)"]]
      J --> K[End]
      AB --> K
   end
   subgraph "FUNCTION get_input(choice,n)"
   direction TB
      V[Start]@{shape: stadium} --> K2{Choice}
      K2 --> |1| L1{For each bus i}@{shape: notch-pent}
      L1 --> L2{For each bus j}@{shape: notch-pent}
      L2 --> M1[Take impedance as input]@{shape: lean-left}
      M1 --> M2[[Calculate admittance]]
      M2 --> M3[store into y]@{shape: lean-left}
      M3 --> L1
      M3 --> Q1
      
      K2 --> |2| O1{For each bus i}@{shape: notch-pent}
      O1 --> O2{For each bus j}@{shape: notch-pent}
      O2 --> P1[Take admittance as input]@{shape: lean-left}
      P1 --> P2[store into y]@{shape: lean-left}
      P2 --> O1
      P2 --> Q1[Return y to main]@{shape: stadium}
   
     
   end

   subgraph "FUNCTION calculate_admittance_matrix(y,n)"
   direction TB
      R[Start]@{shape: stadium} --> R1[For each bus i and j]@{shape: notch-pent}
      R1 --> S1[If i == j]
      S1 --> T1[Calculate diagonal elements]
      S1 --> U1[Else]
      U1 --> V1[Calculate off-diagonal elements]
      V1 --> W1[Return Ybus to main]@{shape: stadium}
   end

   subgraph "FUNCTION print_admittance_matrix(ybus,n)"
   direction TB
      X1[[Print Bus Admittance Matrix]]
      X1 --> Y1[For each row in Ybus]
      Y1 --> Z1[Print each element]
      Z1 --> AA1[Print new line]
      AA1 --> Y1
   end



```


## Documentation

Here are the links to the implementations:

1. [Python](./docs/html/namespaceYbus__Python.html)
2. [Java](./docs/html/classes.html)
3. [MATLAB](./docs/html/Ybus__matlab_8m.html)

## Documentation Tools

Here are the links to the documentation tools I used:

|Tool|Link|Description|
|:--:|:--:|:--:|
|Doxygen|[Link to doxygen](https://doxygen.nl/index.html)|Used to generate documentation for java and python files|
|Octave Publish Command|  [Octave documentation](https://www.gnu.org/software/octave/doc/interpreter/Publishing-Markdown.html)|Utilized to convert MATLAB scripts into documentation with integrated code, comments, and results|
|GitHub Actions|[GitHub Actions documentation](https://docs.github.com/en/actions)|Automated the generation and deployment of documentation. GitHub Actions helped streamline our CI/CD pipeline.|


## References

[1] Hadi Saadat, *"Power System Analysis"*. Psa Pub, United States, 2010.\
[2] Mohammad Shahidehpour; Yaoyu Wang, "Appendix C: IEEE30 Bus System Data," in Communication and Control in Electric Power Systems: Applications of Parallel and Distributed Processing , IEEE, 2003, pp.493-495, doi: 10.1002/0471462926.app3.
