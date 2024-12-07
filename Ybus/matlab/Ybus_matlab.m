%> Linedata Matrix
zdata = [
    1   2   0.02  0.06;
    1   3   0.08  0.24;
    2   3   0.06  0.25;
    2   4   0.06  0.18;
    2   5   0.04  0.12;
    3   4   0.01  0.03;
    4   5   0.08  0.24;
];

%> Number of branches
nbr = size(zdata, 1);

% Starting bus numbers
nl = zdata(:, 1);

% Ending bus numbers
nr = zdata(:, 2);

% Resistance
R = zdata(:, 3);

% Reactance
X = zdata(:, 4);

% Total number of buses
nbus = max(max(nl), max(nr));

% Impedance matrix
Z = R + 1j * X;

% Placeholder admittance matrix
y = 1 ./ Z;

%% Initialize the bus admittance matrix
Ybus = zeros(nbus, nbus);


function YBUS = create_admittance_matrix(nl, nr, nbr, nbus, y)
    Ybus = zeros(nbus, nbus);
    for k = 1:nbr
        if nl(k) > 0 && nr(k) > 0
            Ybus(nl(k), nr(k)) = Ybus(nl(k), nr(k)) - y(k);
            Ybus(nr(k), nl(k)) = Ybus(nl(k), nr(k));
        end
    end
    
    for n = 1:nbus
        for k = 1:nbr
            if nl(k) == n || nr(k) == n
                Ybus(n, n) = Ybus(n, n) + y(k);
            end
        end
    end
    YBUS = Ybus;
end

%% Display the bus admittance matrix function
function display_admittance_matrix(Ybus, nbus)
    disp('Bus Admittance Matrix:')
    for i = 1:nbus
        for j = 1:nbus
            fprintf('%.2f + %.2fj  ', real(Ybus(i, j)), imag(Ybus(i, j)));
        end
        fprintf('\n');
    end
end

%% Call the functions to create and display the matrix
YBUS = create_admittance_matrix(nl, nr, nbr, nbus, y);
display_admittance_matrix(YBUS, nbus);
