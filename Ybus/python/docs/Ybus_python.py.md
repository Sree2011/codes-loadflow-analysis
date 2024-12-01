<!-- markdownlint-disable -->

<a href="..\..\..\Ybus\python\Ybus_python.py#L0"><img align="right" style="float:right;" src="https://img.shields.io/badge/-source-cccccc?style=flat-square"></a>

# <kbd>module</kbd> `Ybus_python.py`
The user needs to keep the linedata matrix into four columns: Bus 1, Bus 2, Resistance, and Reactance. Then, replace the zdata matrix with their own. For now, the linedata of the IEEE-30 Bus system is considered. The program then calculates the admittance matrix and prints it to the console. 



**Attributes:**
 
 - <b>`zdata`</b> (np.array):  Linedata matrix with columns: bus1, bus2, Resistance (pu), Reactance (pu). 
 - <b>`nbr`</b> (int):  Number of lines or branches. 
 - <b>`nl`</b> (np.array):  Starting bus numbers. 
 - <b>`nr`</b> (np.array):  Ending bus numbers. 
 - <b>`R`</b> (np.array):  Resistance (pu). 
 - <b>`X`</b> (np.array):  Reactance (pu). 
 - <b>`Z`</b> (np.array):  Impedance. 
 - <b>`nbus`</b> (int):  Total number of buses. 
 - <b>`y`</b> (np.array):  Admittance. 
 - <b>`Ybus`</b> (np.array):  Bus admittance matrix. 

Author: Sree Sai Nandini 

**Global Variables**
---------------
- **zdata**
- **Ybus**

---

<a href="..\..\..\Ybus\python\Ybus_python.py#L23"><img align="right" style="float:right;" src="https://img.shields.io/badge/-source-cccccc?style=flat-square"></a>

## <kbd>function</kbd> `calculate_admittance_matrix`

```python
calculate_admittance_matrix(zdata)
```

Calculate the bus admittance matrix. 



**Args:**
 
 - <b>`zdata`</b> (np.array):  Linedata matrix with columns: bus1, bus2, Resistance (pu), Reactance (pu). 



**Returns:**
 
 - <b>`np.array`</b>:  Bus admittance matrix. 


---

<a href="..\..\..\Ybus\python\Ybus_python.py#L72"><img align="right" style="float:right;" src="https://img.shields.io/badge/-source-cccccc?style=flat-square"></a>

## <kbd>function</kbd> `print_admittance_matrix`

```python
print_admittance_matrix(Ybus)
```

Print the bus admittance matrix to the console. 



**Args:**
 
 - <b>`Ybus`</b> (np.array):  Bus admittance matrix. 




---

_This file was automatically generated via [lazydocs](https://github.com/ml-tooling/lazydocs)._
