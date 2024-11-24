## Generate Bus Admittance Matrix



## Algorithm
1. **Initialization**:
   - Import necessary libraries.
   - Initialize variables for the number of buses `n` and the choice of input type (impedance or admittance).

2. **Input Number of Buses**:
   - Prompt the user to enter the number of buses.
   - Initialize the bus admittance matrix `Ybus` with complex zeros.
   - Initialize a placeholder matrix `y` with complex zeros.

3. **Input Choice for Impedance or Admittance**:
   - Prompt the user to choose between entering impedance or admittance values.

4. **Input Impedance or Admittance Values**:
   - **Case 1**: If the user chooses impedance:
     - For each pair of buses, prompt the user to enter the impedance value.
     - Calculate the admittance for each pair as the reciprocal of the impedance and store it in matrix `y`.
   - **Case 2**: If the user chooses admittance:
     - For each pair of buses, prompt the user to enter the admittance value directly and store it in matrix `y`.

5. **Form Bus Admittance Matrix**:
   - For each bus `i`:
     - For each bus `j`:
       - If `i` equals `j` (diagonal elements):
         - Sum the admittances of all lines connected to bus `i` and update `Ybus[i][j]`.
       - Otherwise (off-diagonal elements):
         - Set the element `Ybus[i][j]` to the negative of the corresponding admittance value `y[i][j]`.

6. **Output Bus Admittance Matrix**:
   - Print the bus admittance matrix `Ybus`.

## Pseudocode

```pseudocode
Initialize variables and matrices
Prompt user to enter the number of buses
Prompt user to choose between impedance and admittance

If choice is impedance:
    For each bus pair (i, j):
        Prompt user to enter the impedance value between bus i and bus j
        Calculate admittance and store in matrix y

Else if choice is admittance:
    For each bus pair (i, j):
        Prompt user to enter the admittance value between bus i and bus j
        Store the admittance value in matrix y

# Form bus admittance matrix:
For each bus i:
    For each bus j:
        If i == j:
            Sum admittances of all lines connected to bus i
            Update Ybus[i][j]
        Else:
            Set Ybus[i][j] to -y[i][j]

Print bus admittance matrix Ybus
```

## The Actual Code

Here are the links to the implementations:

1. [Python](./Ybus/python/Ybus_Python.py)
2. [Java](./Ybus/java/Ybus_Java.java)
3. [MATLAB](./Ybus/matlab/Ybus_matlab.m)


## References

[1] Hadi Saadat, *"Power System Analysis"*. Psa Pub, United States, 2010.
[2] Mohammad Shahidehpour; Yaoyu Wang, "Appendix C: IEEE30 Bus System Data," in Communication and Control in Electric Power Systems: Applications of Parallel and Distributed Processing , IEEE, 2003, pp.493-495, doi: 10.1002/0471462926.app3.
