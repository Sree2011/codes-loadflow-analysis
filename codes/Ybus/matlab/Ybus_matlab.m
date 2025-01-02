% /// Get the number of buses from the user
n = input('Enter the number of buses: ');


% /// Get the choice from the user - 1 for impedance and 2 for admittance
choice = input('Enter 1 for impedance and 2 for admittance:');



% /// get input from the user and calculate line admittances
% /// \link get_input.m get_input \endlink
y = get_input(choice,n);



% /// Form the bus admittance matrix based on the input
% /// \link calculate_matrix.m calculate_matrix \endlink
YBUS = calculate_matrix(y, n);



% /// Display the bus admittance matrix
% /// \link display_matrix.m display_matrix \endlink
display_matrix(YBUS, n);

