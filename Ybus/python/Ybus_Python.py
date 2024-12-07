import numpy as np

"""
**Example linedata matrix for IEEE-30 Bus system**

Replace this with your own linedata matrix. 
Ensure the format is: Bus1, Bus2, Resistance (pu), Reactance (pu)
"""
zdata = np.array([
    [1, 2, 0.02, 0.06],
    [1, 3, 0.08, 0.24],
    # ... other lines
])

"""
nbr: int
This variable stores number of lines or branches in the power system network
"""
nbr = len(zdata[:, 1])

# Starting and ending bus numbers
"""
nl: int
This variable stores the starting bus numbers from the line data
"""
nl = np.array(zdata[:, 0], dtype=int)

"""
nr: int
This variable stores the ending bus numbers from the line data
"""
nr = np.array(zdata[:, 1], dtype=int)

# Resistance and reactance (pu)
R = zdata[:, 2]
X = zdata[:, 3]

# Total number of buses
nbus = int(max(max(nl), max(nr)))


def calculate_admittance(R, X):
    """
    Calculates the admittance values from resistance and reactance.

    Args:
        R (np.array): Resistance values.
        X (np.array): Reactance values.

    Returns:
        np.array: Admittance values.
    """
    Z = R + 1j * X  # Calculate impedance
    y = 1 / Z  # Calculate admittance
    return y


def calculate_admittance_matrix(zdata):
    """
    Calculates the bus admittance matrix from the linedata.

    Args:
        zdata (np.array): Linedata matrix.

    Returns:
        np.array: Bus admittance matrix.
    """
    y = calculate_admittance(R, X)

    # Initialize the bus admittance matrix
    Ybus = np.zeros((nbus, nbus), dtype=complex)

    # Form off-diagonal elements
    for k in range(nbr):
        if nl[k] > 0 and nr[k] > 0:
            Ybus[nl[k] - 1, nr[k] - 1] -= y[k]
            Ybus[nr[k] - 1, nl[k] - 1] -= y[k]

    # Form diagonal elements
    for n in range(nbus):
        for k in range(nbr):
            if nl[k] - 1 == n or nr[k] - 1 == n:
                Ybus[n, n] += y[k]

    return Ybus


def print_admittance_matrix(Ybus):
    """
    Prints the bus admittance matrix to the console.

    Args:
        Ybus (np.array): Bus admittance matrix.
    """
    print('Bus Admittance Matrix:')
    for row in Ybus:
        for element in row:
            print(f"{element.real:+0.02f} {element.imag:+0.02f}j", end="  ")
        print()


# Calculate and print the admittance matrix
Ybus = calculate_admittance_matrix(zdata)
print_admittance_matrix(Ybus)