
% /// \brief Display the bus admittance matrix
% /// \param Ybus The bus admittance matrix
% /// \param nbus The number of buses
function display_matrix(Ybus, nbus)
    disp('Bus Admittance Matrix:')

    % /// \brief external loop
    for i = 1:nbus
        
        % /// \brief internal loop
        for j = 1:nbus
            
            % /// \brief Display the real and imaginary parts of the bus admittance matrix
            fprintf('%.2f + %.2fj\t', real(Ybus(i, j)), imag(Ybus(i, j)));
        end

        % /// \brief Move to the next line
        fprintf('\n');
    end
end
