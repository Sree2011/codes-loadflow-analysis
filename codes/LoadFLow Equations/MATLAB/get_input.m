%{
    \fn get_input(n,V,I,y)
    \brief Get input from the user
    \arg n The number of buses
    \arg V The bus voltages
    \arg I The bus currents
    \arg y The bus admittances
    \return V The bus voltages
    \return I The bus currents
    \return y The bus admittances

%}
[V,I,y] = function get_input(n,V,I,y)
    n = input('Enter the number of buses: ');
    V = zeros(n, n); % Bus voltages
    I = zeros(n, n); % Bus currents
    y = zeros(n, n); % Bus admittances
    % Get bus voltages
    for i = 1:n
        V(i, :) = input(['Enter the voltage for bus ' num2str(i) ': ']);
    end
    % Get bus currents
    for i = 1:n
        I(i, :) = input(['Enter the current for bus ' num2str(i) ': ']);
    end
    % Get bus admittances
    for i = 1:n
        y(i, :) = input(['Enter the admittance for bus ' num2str(i) ': ']);
    end
    % Return the bus voltages, currents, and admittances
    return V, I, y;
end