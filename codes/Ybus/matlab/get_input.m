
% /// \brief Get impedance or admittance input from the user
% /// \param choice The user's choice for input type : 1 for impedance, 2 for admittance
% /// \param n The number of buses
% /// \return yp The admittance matrix
function yp = get_input(choice,n)

    % /// \brief Initialise the admittance matrix    
    y = zeros(n, n);
    if choice == 1

        % /// \brief Get the impedance between buses from the user
        for i = 1:n
            for j = 1:n
                fprintf("Enter the impedance between bus %d and %d: ", i, j);
                yij = input('');
                y(i, j) = 1/yij;
            end
        end
    
    elseif choice == 2
        % /// \brief Get the admittance between buses from the user
        for i = 1:n
            for j = 1:n
                fprintf("Enter the admittance between bus %d and %d: ", i, j);
                y(i, j) = input('');
            end
        end
    end
    yp = y;
end
 