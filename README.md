# Load flow Analysis

This repository contains codes, equations and algorithms for performing load flow analysis in power systems. The documentation is generated using Doxygen for Java, Python and MATLAB files. Automated CI/CD pipeline is set up using GitHub Actions. References include key textbooks and IEEE standards for power system analysis.

## Table of contents

|S.No.|Topic|Page|
|:---|:---|:---|
|1|Bus Admittance Matrix|[1](./bus-admittance-matrix.md)|
|2|Line flows and line losses|[2](./line-flows-and-losses.md)|
|3|Load flow Equations|[3](./load-flow-equations.md)|
|4|Bus impedance matrix|[4](./bus-impedance-matrix.md)|




## Documentation Tools

Here are the links to the documentation tools I used:

| Tool             | Link                                                                 | Description                                                                 |
|:----------------:|:--------------------------------------------------------------------:|:---------------------------------------------------------------------------:|
| Doxygen          | [Link to doxygen](https://doxygen.nl/index.html)                     | Used to generate documentation for java and python files                    |
| Octave Publish Command | [Octave documentation](https://www.gnu.org/software/octave/doc/interpreter/Publishing-Markdown.html) | Utilized to convert MATLAB scripts into documentation with integrated code, comments, and results |
| GitHub Actions   | [GitHub Actions documentation](https://docs.github.com/en/actions)   | Automated the generation and deployment of documentation. GitHub Actions helped streamline our CI/CD pipeline. |


## References

[1] H. Saadat, *Power System Analysis*, 2nd ed. United States: McGraw, 2004, ISBN: 978-0071239554.

[2] M. Shahidehpour and Y. Wang, "Appendix C: IEEE30 Bus System Data," in *Communication and Control in Electric Power Systems: Applications of Parallel and Distributed Processing*, IEEE, 2003, pp. 493-495, doi: 10.1002/0471462926.app3.
