function [P,Q] = calculate_load_flow(n,V,I,y)
    % Initialize matrices
    S = zeros(n, n); % Complex power
    SL = zeros(n, n); % Line losses

    % Calculate complex power
    for i = 1:n
        for j = 1:n
            S(i,j) = V(i,j) * conj(I(i,j));
            S(j,i) = V(j,i) * conj(I(j,i));    
        end
    end

    % Calculate line losses
    for i = 1:n
        for j = 1:n
            SL(i,j) = S(i,j) - S(j,i);
            if i == j
                SL(i,j) = 0; % No losses on the diagonal
            else
                continue;
        end
    end

    % Calculate load flow equations
    P = real(S);
    Q = imag(S);
    SLR = real(SL);
    SLI = imag(SL);

    % Display results
    disp('Complex Power (S):');
    disp(S);
    disp('Line Losses (SL):');
    disp(SL);
    disp('Real Power (P):');
    disp(P);
    disp('Reactive Power (Q):');
    disp(Q);
    disp('Real Line Losses (SLR):');
    disp(SLR);
    disp('Reactive Line Losses (SLI):');
    disp(SLI);
    

end