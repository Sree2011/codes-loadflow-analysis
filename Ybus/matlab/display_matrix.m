function display_matrix(Ybus, nbus)
    %{
    \brief Display the bus admittance matrix
    \param Ybus The bus admittance matrix
    \param nbus The number of buses
    %}


    disp('Bus Admittance Matrix:')
    for i = 1:nbus
        % \brief external loop
        for j = 1:nbus
            % \brief external loop
            fprintf('%.2f + %.2fj\t', real(Ybus(i, j)), imag(Ybus(i, j)));
        end
        fprintf('\n');
    end
end
