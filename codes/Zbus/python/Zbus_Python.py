# This program calculates bus impedance matrix for a given power system network
# Here, the inverse of the bus admittance matrix is calculated,
# which is the bus impedance matrix

import numpy as np

print("Enter the no.of buses:")
n = int(input())  # Get the number of buses from the user
# Initialize the admittance matrix with zeros
Ybus = np.array([[0+0j for i in range(n)] for j in range(n)])
# A Placeholder matrix
y = np.zeros((n,n),dtype=complex)

def get_input(choice,n):
    """
    Gets the input from the user based on the choice of impedance or
    admittance , calculates admittance values and returns them

    Args:
        choice(int) : the choice of the user(1 for impedance and 2 for admittance)
        n(int) : Total no.of buses in the system

    Returns:
        y(np.array) : Line Admittance matrix
    """
    if choice == 1:
        for i in range(n):
            for j in range(n):
                print("Enter the impedance between bus ",i+1," and bus ",j+1)
                yij = complex(input())
                y[i][j] = np.reciprocal(yij)
    elif choice == 2:
        for i in range(n):
            for j in range(n):
                print("Enter the admittance between bus ",i+1," and bus ",j+1)
                y[i][j] = complex(input())

    return y

def calculate_admittance_matrix(y):
    """
    Forms admittance matrix using the admittance value matrix y

    Args:
        y(np.array): Line Admittance Matrix
    
    Returns:
        Ybus(np.array) : Bus Admittance Matrix
    """
    # Form Bus Admittance Matrix
    for i in range(n):
        for j in range(n):
            if i == j: # Diagonal elements
                for k in range(n):
                    Ybus[i][j] = Ybus[i][j] + y[i][k]
            else:
                Ybus[i][j] = -y[i][j]
    return Ybus

def calculate_zbus(Ybus):
    """
    Calculates the bus impedance matrix from the bus admittance matrix

    Args:
        Ybus(np.array): Bus Admittance Matrix
    
    Returns:
        Zbus(np.array) : Bus Impedance Matrix
    """
    Zbus = np.linalg.inv(Ybus)
    return Zbus

def display_matrix(matrix):
    """
    Displays the matrix to the console

    Args:
        matrix(np.array): The matrix to be displayed
    """
    for row in matrix:
        for element in row:
            print("{:.4f}".format(element), end=" ")
        print()

def main():
    """
    The main function
    
    """

    print("Enter 1 for impedance and 2 for admittance")
    choice = int(input())  # Get the choice of input type (impedance or admittance)
    y = get_input(choice,n)
    Ybus = calculate_admittance_matrix(y)
    Zbus = calculate_zbus(Ybus)
    print("Bus Impedance Matrix:")
    display_matrix(Zbus)


if __name__ == "__main__":
    main()
