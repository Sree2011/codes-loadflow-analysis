## Generate Bus Admittance Matrix

## Algorithm
1. Start

2. Take Input:
   - Line data (Bus1, Bus2, Resistance, Reactance)

3. Preprocess Line Data:
   - Extract the number of branches (nbr) from line data
   - Extract starting bus numbers (nl) from line data
   - Extract ending bus numbers (nr) from line data
   - Extract resistance values (R) from line data
   - Extract reactance values (X) from line data
   - Determine the number of buses (nbus) from the maximum bus number in line data

4. Calculate Admittance:
   - For each branch:
     - Calculate impedance (Z) = R + jX
     - Calculate admittance (y) = 1 / Z

5. Initialize Admittance Matrix:
   - Create an empty complex matrix Ybus of size nbus x nbus

6. Populate Admittance Matrix:
   - For each branch:
     - Update off-diagonal elements:
       - Ybus[nl-1, nr-1] -= y
       - Ybus[nr-1, nl-1] -= y
     - Update diagonal elements:
       - Ybus[nl-1, nl-1] += y
       - Ybus[nr-1, nr-1] += y

7. Print Admittance Matrix:
   - Print the real and imaginary parts of each element in Ybus


## Pseudocode

```pseudocode

INPUT MATRIX zdata
ASSIGN FIRST COLUMN of zdata to nl
ASSIGN SECOND COLUMN of zdata to nr
ASSIGN THIRD COLUMN of zdata to R
ASSIGN FOURTH COLUMN of zdata to X
CALCULATE nbus as MAX(MAX(nl,MAX(nr)))
CALCULATE MATRIX Z as (MATRIX R +j*(MATRIX X))
CALCULATE MATRIX y as RECIPROCAL(MATRIX Z)
INITIALIZE MATRIX ybus WITH ZEROS

FUNCTION create_admittance_matrix(nl,nr,nbr,nbus,y)
    INITIALIZE MATRIX ybus WITH ZEROS // ONLY IF REQUIRED

    // FORMATION OF OFF-DIAGONAL ELEMENTS
    FOR k FROM 1 TO nbr
        IF nl[k] > 0 AND nr[k] > 0 (>= for zero-indexed languages like java)
            Ybus[nl[k],nr[k]] = Ybus[nl[k],nr[k]] - y[k]
            Ybus[nr[k],nl[k]] = Ybus[nl[k],nr[k]]
        ENDIF
    ENDFOR

    // FORMATION OF DIAGONAL ELEMENTS
    FOR n FROM 1 TO nbus
        FOR k FROM 1 TO nbr
            IF nl[k] == n OR nr[k] == n
                Ybus[n,n] = Ybus[n,n] + y[k]
            ENDIF
        ENDFOR
    ENDFOR
    RETURN Ybus
ENDFUNCTION


FUNCTION display_admittance_matrix(Ybus, nbus)
    DISPLAY 'Bus Admittance Matrix:'
    FOR i FROM 1 TO nbus
        FOR j FROM 1TO nbus
            DISPLAY Ybus[i,j]
        ENDFOR
        DISPLAY NEWLINE
    ENDFOR
ENDFUNCTION

// DRIVER CODE
YBUS = create_admittance_matrix(nl, nr, nbr, nbus, y);
display_admittance_matrix(YBUS, nbus);
```

## Documentation

Here are the links to the implementations:

1. [Python](./docs/html/namespaceYbus__Python.html)
2. [Java](./docs/html/classes.html)
3. [MATLAB](./Ybus/matlab/html/Ybus_matlab.html)

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
