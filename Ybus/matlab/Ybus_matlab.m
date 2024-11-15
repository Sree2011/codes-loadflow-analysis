% This program generates a bus admittance matrix for a given set of buses and lines.
% It takes input from the user for the number of buses and lines, and their respective
% parameters. The program then calculates the admittance matrix and prints it to the console.

clear all;
clc;

n = input('Enter the number of buses: ');
choice = input('Enter 1 for impedance and 2 for admittance: ');

if choice == 1
    % Take impedance as input and calculate admittance
    z = zeros(n);
    y = zeros(n);
    for i = 1:n
        for j = 1:n
            if i ~= j
                fprintf('Enter the impedance value between %d & %d: ', i, j);
                z(i, j) = input('');
                y(i, j) = 1 / z(i, j);
            end
        end
    end
elseif choice == 2
    % Take admittance as input
    y = zeros(n);
    for i = 1:n
        for j = 1:n
            if i ~= j
                fprintf('Enter the admittance value between %d & %d: ', i, j);
                y(i, j) = input('');
            end
        end
    end
else
    error('Invalid choice. Please enter 1 or 2.');
end

% Form bus admittance matrix
Ybus = zeros(n);
for i = 1:n
    for j = 1:n
        if i == j
            for k = 1:n
                if i ~= k
                    Ybus(i, j) = Ybus(i, j) + y(i, k);
                end
            end
        else
            Ybus(i, j) = -y(i, j);
        end
    end
end

disp('Bus Admittance Matrix is:');
disp(Ybus);
