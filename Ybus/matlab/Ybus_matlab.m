% This program generates a bus admittance matrix for a given set of buses and lines.
% The user need to keep linedata matrix into four columns.: Bus 1,Bus 2, Resistance and Reactance.
% Then, replace the zdata matrix with their own. For now, the linedata of the IEEE-30 Bus system is considered.
% The program then calculates the admittance matrix and prints it to the console.

% @author SREE SAI NANDINI

clear all;
clc;
% Define the linedata matrix with columns: bus1, bus2, Resistance (pu), Reactance (pu)
%  bus1 bus2 R(pu) X(pu)
zdata = [
    1   2  0.02  0.06;
    1   3  0.08  0.24;
    2   3  0.06  0.25;
    2   4  0.06  0.18;
    2   5  0.04  0.12;
    3   4  0.01  0.03;
    4   5  0.08  0.24;
];
% Extract data

% Number of lines or branches
nbr = size(zdata(:,1))(1);


% Starting bus numbers
nl = zdata(:,1);
% Ending bus numbers
nr = zdata(:,2);
% Resistance (pu)
R = zdata(:,3);
% Reactance (pu)
X = zdata(:,4);
% Total number of buses
nbus = max(max(nl),max(nr));

% Calculate Impedance
Z = R+j*X;

% Calculate Admittance
y = ones(nbr,1)./Z;

% Form bus admittance matrix
Ybus = zeros(nbus,nbus);

% Formation of off diagonal elements
for k=1:nbr
    if nl(k)>0 & nr(k) >0
        Ybus(nl(k),nr(k)) = Ybus(nl(k),nr(k)) - y(k);
        Ybus(nr(k),nl(k)) = Ybus(nl(k),nr(k));
    end
end

% Formation of diagonal elements
for n = 1:nbus
    for k = 1:nbr
        if nl(k) == n | nr(k) == n
            Ybus(n,n) = Ybus(n,n)+y(k);
        else,end
    end
end



disp('Bus Admittance Matrix is:');

for i = 1:nbus
    for j = 1:nbus
        % Print the complex number with real and imaginary parts
        fprintf('%.2f + %.2fj  ', real(Ybus(i, j)), imag(Ybus(i, j))); 
    end
    fprintf('\n'); % Print a new line after each row
end