
n = input('Enter the number of buses: ');
% \brief Get the number of buses from the user


choice = input('Enter 1 for impedance and 2 for admittance:');
% \brief Get the choice from the user ( 1 for impedance and 2 for admittance)


function yp = get_input(choice,n)
    
    % \brief Get impedance or admittance input from the user
    % \param choice The user's choice for input type (1 for impedance, 2 for admittance)
    % \param n The number of buses
    % \return yp The admittance matrix
    


    y = zeros(n, n);

    
    if choice == 1
        for i = 1:n
            for j = 1:n
                fprintf("Enter the impedance between bus %d and %d: ", i, j);
                yij = input('');
                y(i, j) = 1/yij;
            end
        end
    
    elseif choice == 2
        for i = 1:n
            for j = 1:n
                fprintf("Enter the admittance between bus %d and %d: ", i, j);
                y(i, j) = input('');
            end
        end
    end
    yp = y;
end

% /**!
% * \brief Calculate the bus admittance matrix
% * \param y The input admittance matrix
% * \param n The number of buses
% * \return YBus The calculated bus admittance matrix
% */
function YBus = calculate_admittance_matrix(y,n)
        % /**!
        % * \brief Initialise the bus admittance matrix
        % */
        Ybus = zeros(n, n);

    for i = 1:n
        for j = 1:n
            if i == j
                for k = 1:n
                    Ybus(i, j) = Ybus(i, j) + y(i, k);
                end
            else
                Ybus(i, j) = -y(i, j);
            end
        end
    end

    YBus = Ybus;
end

% /**!
% * \brief Display the bus admittance matrix
% * \param Ybus The bus admittance matrix
% * \param nbus The number of buses
% */
function display_admittance_matrix(Ybus, nbus)
    disp('Bus Admittance Matrix:')
    for i = 1:nbus
        for j = 1:nbus
            fprintf('%.2f + %.2fj\t', real(Ybus(i, j)), imag(Ybus(i, j)));
        end
        fprintf('\n');
    end
end

% /**!
% * \brief Driver code
% */
y = get_input(choice,n);
YBUS = calculate_admittance_matrix(y, n);
display_admittance_matrix(YBUS, n);
