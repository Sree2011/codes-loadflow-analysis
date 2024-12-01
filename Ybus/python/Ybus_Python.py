"""
The user needs to keep the linedata matrix into four columns: Bus 1, Bus 2, Resistance, and Reactance.
Then, replace the zdata matrix with their own. For now, the linedata of the IEEE-30 Bus system is considered.
The program then calculates the admittance matrix and prints it to the console.

Attributes:
    zdata (np.array): Linedata matrix with columns: bus1, bus2, Resistance (pu), Reactance (pu).
    nbr (int): Number of lines or branches.
    nl (np.array): Starting bus numbers.
    nr (np.array): Ending bus numbers.
    R (np.array): Resistance (pu).
    X (np.array): Reactance (pu).
    Z (np.array): Impedance.
    nbus (int): Total number of buses.
    y (np.array): Admittance.
    Ybus (np.array): Bus admittance matrix.

Author: Sree Sai Nandini
"""

import numpy as np

def calculate_admittance_matrix(zdata):
    """
    Calculate the bus admittance matrix.

    Args:
        zdata (np.array): Linedata matrix with columns: bus1, bus2, Resistance (pu), Reactance (pu).

    Returns:
        np.array: Bus admittance matrix.
    """
    # Number of lines or branches
    nbr = len(zdata[:,1])
    
    # Starting bus numbers
    nl = np.array(zdata[:,0], dtype=int)
    # Ending bus numbers
    nr = np.array(zdata[:,1], dtype=int)
    # Resistance (pu)
    R = zdata[:,2]
    # Reactance (pu)
    X = zdata[:,3]
    # Impedance
    Z = np.zeros(nbr, dtype=complex)
    # Total number of buses
    nbus = int(max(max(nl), max(nr)))
    
    # Calculate Impedance
    for i in range(len(R)):
        Z[i] = complex(R[i], X[i])
    
    # Calculate Admittance
    y = 1 / Z
    # Form bus admittance matrix
    Ybus = np.zeros((nbus, nbus), dtype=complex)
    
    # Formation of off diagonal elements
    for k in range(nbr):
        if nl[k] > 0 and nr[k] > 0:
            Ybus[nl[k]-1, nr[k]-1] = Ybus[nl[k]-1, nr[k]-1] - y[k]
            Ybus[nr[k]-1, nl[k]-1] = Ybus[nl[k]-1, nr[k]-1]
    
    # Formation of diagonal elements
    for n in range(nbus):
        for k in range(nbr):
            if nl[k]-1 == n or nr[k]-1 == n:
                Ybus[n, n] += y[k]
    
    return Ybus

def print_admittance_matrix(Ybus):
    """
    Print the bus admittance matrix to the console.

    Args:
        Ybus (np.array): Bus admittance matrix.
    """
    print('Bus Admittance Matrix is:')
    for i in range(len(Ybus)):
        for j in range(len(Ybus)):
            print("{num.real:+0.02f} {num.imag:+0.02f}j".format(num=Ybus[i][j]), end="  ")
        print()

# Example linedata matrix for IEEE-30 Bus system
zdata = np.array([
    [1, 2, 0.02, 0.06],
    [1, 3, 0.08, 0.24],
    [2, 3, 0.06, 0.25],
    [2, 4, 0.06, 0.18],
    [2, 5, 0.04, 0.12],
    [3, 4, 0.01, 0.03],
    [4, 5, 0.08, 0.24]
])

# Calculate and print the admittance matrix
Ybus = calculate_admittance_matrix(zdata)
print_admittance_matrix(Ybus)
