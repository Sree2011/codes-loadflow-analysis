% Get the number of buses from the user
n = input('Enter the number of buses: ');



% Get user's input for impedance or admittance
choice = input('Enter 1 for impedance and 2 for admittance:');

function yp = get_input(choice,n)
    % Initialize the placeholder matrix with zeros
    y = zeros(n, n);

    % Case 1: User provides impedance values
    if choice == 1
        for i = 1:n
            for j = 1:n
                fprintf("Enter the impedance between bus %d and %d: ", i, j);
                yij = input('');
                y(i, j) = 1/yij; % Calculate admittance from impedance
            end
        end
    % Case 2: User provides admittance values
    elseif choice == 2
        for i = 1:n
            for j = 1:n
                fprintf("Enter the admittance between bus %d and %d: ", i, j);
                y(i, j) = input(''); % Input complex admittance
            end
        end
    end

end
% Function to calculate the bus admittance matrix
function YBus = calculate_admittance_matrix(y,n)
    % Initialize the admittance matrix with zeros
    Ybus = zeros(n, n);
    
    % Form the bus admittance matrix
    for i = 1:n
        for j = 1:n
            if i == j % Diagonal elements
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

% Function to display the bus admittance matrix
function display_admittance_matrix(Ybus, nbus)
    disp('Bus Admittance Matrix:')
    for i = 1:nbus
        for j = 1:nbus
            fprintf('%.2f + %.2fj\t', real(Ybus(i, j)), imag(Ybus(i, j)));
        end
        fprintf('\n');
    end
end

% Call the functions to create and display the matrix
YBUS = calculate_admittance_matrix(choice, n);
display_admittance_matrix(YBUS, n);