function YBus = calculate_matrix(y,n)
    %{
    \brief Calculate the bus admittance matrix
    \arg y The input admittance matrix
    \arg n The number of buses
    \return YBus The calculated bus admittance matrix
    %}

    
    Ybus = zeros(n, n);
    % \brief Initialise the bus admittance matrix
    %

for i = 1:n
    % \brief external loop
    for j = 1:n
        % \brief internal loop
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
