%{ 
    \file lfeqns.m
    \brief Load Flow Equations
    \details This script calculates the load flow equations for a power system.
    It initializes matrices for bus voltages, currents, admittances, complex power,
    and line losses. The user is prompted to enter the values for these matrices.
    The script then calculates the load flow equations based on the input values.
%}

% Initialize matrices
n = 3; % Number of buses
V = zeros(n, n); % Bus voltages
I = zeros(n, n); % Bus currents
y = zeros(n, n); % Bus admittances
S = zeros(n, n); % Complex power
SL = zeros(n, n); % Line losses


% \file get_input.m
% \brief Get input from the user
% This function prompts the user to enter bus voltages, currents, and admittances
[V, I, y] = get_input(n, V, I, y);


% \file calculate_load_flow.m
% \brief Calculate load flow equations
% This function calculates the load flow equations based on the input values
[P,Q] = calculate_load_flow(n, V, I, y);
