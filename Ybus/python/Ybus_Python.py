"""
This program generates a bus admittance matrix for a given set of buses and lines.
It takes input from the user for the number of buses and lines, and their respective
parameters. The program then calculates the admittance matrix and prints it to the console.
"""
import numpy as np
print("Enter the no.of buses:")
n = int(input())  # Get the number of buses from the user
# Initialize the admittance matrix with zeros
Ybus = np.array([[0+0j for i in range(n)] for j in range(n)])

# A Placeholder matrix
y = np.zeros((2,2),dtype=complex)

print("Enter 1 for impedance and 2 for admittance")
choice = int(input())  # Get the choice of input type (impedance or admittance)

## Case 1: if the user knows impedance(Z) value
if choice == 1:
    # Calculate Admittance
    for i in range(n):
        for j in range(n):
            print("Enter the impedance between bus", i+1, "and", j+1, ":")
            yij = complex(input())
            y[i][j] = 1/yij
elif choice == 2:
    # Take Admittance as input
    for i in range(n):
        for j in range(n):
            print("Enter the admittance between bus", i+1, "and", j+1, ":")
            y[i][j] = complex(input())


# Form Bus Admittance Matrix
for i in range(n):
    for j in range(n):
        if i == j: # Diagonal elements
            for k in range(n):
                Ybus[i][j] = Ybus[i][j] + y[i][k]
        else:
            Ybus[i][j] = -y[i][j]



print(Ybus)
