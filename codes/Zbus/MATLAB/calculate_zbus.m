function Zbus = calculate_zbus(ybus)
    % /// Form the bus impedance matrix by taking inverse of ybus matrix
    Zbus = inv(ybus);
end