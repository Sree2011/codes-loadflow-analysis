# Static Load flow Equations
Real Power,
$$
\begin{equation}
P_i = \text{Re}\left(V_i^* \left( V_i Y_{ii} + \sum_{j=1, j \neq i}^{n} V_j Y_{ij} \right) \right)
\end{equation}
$$

Reactive Power,
$$
\begin{equation}
Q_i = -\text{Im}\left(V_i^* \left( V_i Y_{ii} + \sum_{j=1, j \neq i}^{n} V_j Y_{ij} \right) \right)
\end{equation}

$$

Apparent power,
$$
S_i = V_i^* \left( V_i Y_{ii} + \sum_{j=1, j \neq i}^{n} V_j Y_{ij} \right)
$$



## Algorithm

1. Start
2. Input P,Q,V,y
3. Form Ybus , store into Y
4. calculate real power
5. calculate reactive power
6. Apparent power, S = P - jQ or complex(P,-Q)
7. Display results
8. Stop