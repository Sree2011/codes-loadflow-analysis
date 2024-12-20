
n = input('Enter the number of buses: ');
% \brief Get the number of buses from the user


choice = input('Enter 1 for impedance and 2 for admittance:');
% \brief Get the choice from the user - 1 for impedance and 2 for admittance


% @brief get input
% @link ./get_input.m
y = get_input(choice,n);


% @link ./calculate_matrix.m
YBUS = calculate_matrix(y, n);



% @link ./display_matrix.m
display_matrix(YBUS, n);
