# Bus impedance matrix(Zbus)

- The Zbus matrix is usually built using the Zbus building algorithm.
- The bus impedance matrix (Zbus) is the inverse of the bus admittance matrix (Ybus).
- Here, the Ybus matrix is first formed, and then its inverse is taken to form the Zbus.

## Algorithm

### Step 1: Get Input from the User

    #### Input:
    - `choice`: Integer (1 for impedance, 2 for admittance)
    - `n`: Number of buses
    - Impedance or admittance values between each pair of buses

    #### Process:
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

    #### Output:
    - Return the matrix `y`.

### Step 2: Calculate the Bus Admittance Matrix

    #### Input:
    - `y`: Matrix of admittance values
    - `n`: Number of buses

    #### Process:
    - Define a function `calculate_matrix(y, n)`:
        - For each bus `i` from 1 to `n`:
            - For each bus `j` from 1 to `n`:
                - If `i` is equal to `j`:
                    - For each bus `k` from 1 to `n`:
                        - Add `y[i][k]` to `Ybus[i][j]`.
                - Else:
                    - Set `Ybus[i][j]` to `-y[i][j]`.

    #### Output:
    - Return the matrix `Ybus`.

### Step 3: Calculate the Bus Impedance Matrix

    #### Input:
    - `ybus`: Bus admittance matrix

    #### Process:
    - Define a function `calculate_zbus(ybus)`:
        - Calculate the determinant of `ybus` and store it in `Det`.
        - If `Det` is 0:
            - Display "Matrix is singular".
        - Else:
            - Display "Bus Impedance matrix:".
            - Calculate the inverse of `ybus` and store it in `Inv`.
            - For each element `i` in `Inv`:
                - Display the element `i`.

    #### Output:
    - Display the bus impedance matrix or a message indicating that the matrix is singular.
