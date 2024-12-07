/**
 * @file admittance_matrix.m
 * @brief Generates a bus admittance matrix for a given set of buses and lines.
 *
 * This program calculates the bus admittance matrix for a power system network given a set of lines and their impedances.
 * The user provides the line data in a matrix format with columns representing the starting bus, ending bus, resistance, and reactance.
 * 
 * @author SREE SAI NANDINI
 * @date 2024-12-07
 */

%% Define the line data matrix
/**
 * @brief Defines the line data matrix with columns: bus1, bus2, Resistance (pu), Reactance (pu)
 * 
 * The line data matrix contains information about the lines in the power system network. 
 * Each row represents a line with the following columns:
 * 1. Starting bus number
 * 2. Ending bus number
 * 3. Resistance in per unit (pu)
 * 4. Reactance in per unit (pu)
 */
zdata = [
    1   2   0.02  0.06;
    1   3   0.08  0.24;
    2   3   0.06  0.25;
    2   4   0.06  0.18;
    2   5   0.04  0.12;
    3   4   0.01  0.03;
    4   5   0.08  0.24;
];

%% Extract data from the line data matrix
/**
 * @brief Extracts data from the line data matrix
 * 
 * This section extracts the relevant information from the line data matrix:
 * - Number of lines (branches)
 * - Starting bus numbers
 * - Ending bus numbers
 * - Resistance values
 * - Reactance values
 * - Total number of buses
 */
nbr = size(zdata(:,1), 1);  % Number of lines (branches)
nl = zdata(:,1);           % Starting bus numbers
nr = zdata(:,2);           % Ending bus numbers
R = zdata(:,3);            % Resistance (pu)
X = zdata(:,4);            % Reactance (pu)
nbus = max(max(nl), max(nr));  % Total number of buses

%% Calculate Impedance and Admittance
/**
 * @brief Calculates impedance and admittance from resistance and reactance
 * 
 * This section calculates the impedance and admittance values for each line using the given resistance and reactance values.
 */
Z = R + 1j * X;  % Impedance
y = 1 ./ Z;      % Admittance

%% Form the bus admittance matrix
/**
 * @brief Forms the bus admittance matrix
 * 
 * This section forms the bus admittance matrix, which is a key component in power system analysis.
 * The off-diagonal elements represent the admittance between two buses, while the diagonal elements represent the sum of admittances connected to a bus.
 */
Ybus = zeros(nbus, nbus);  % Initialize bus admittance matrix

% Formation of off-diagonal elements
for k = 1:nbr
    if nl(k) > 0 && nr(k) > 0
        Ybus(nl(k), nr(k)) = Ybus(nl(k), nr(k)) - y(k);
        Ybus(nr(k), nl(k)) = Ybus(nl(k), nr(k));
    end
end

% Formation of diagonal elements
for n = 1:nbus
    for k = 1:nbr
        if nl(k) == n || nr(k) == n
            Ybus(n, n) = Ybus(n, n) + y(k);
        end
    end
end

%% Display the bus admittance matrix
/**
 * @brief Displays the bus admittance matrix
 * 
 * This section prints the calculated bus admittance matrix to the console, formatting the complex numbers with real and imaginary parts.
 */
disp('Bus Admittance Matrix is:');
for i = 1:nbus
    for j = 1:nbus
        fprintf('%.2f + %.2fj  ', real(Ybus(i, j)), imag(Ybus(i, j)));
    end
    fprintf('\n');
end