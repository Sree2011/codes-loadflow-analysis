<!-- markdownlint-disable -->

<a href="..\..\..\Ybus\python\Ybus_python.py#L0"><img align="right" style="float:right;" src="https://img.shields.io/badge/-source-cccccc?style=flat-square"></a>

# <kbd>module</kbd> `Ybus_python.py`




**Global Variables**
---------------
- **zdata**
- **nbr**
- **nl**
- **nr**
- **R**
- **X**
- **nbus**
- **Ybus**

---

<a href="..\..\..\Ybus\python\Ybus_python.py#L30"><img align="right" style="float:right;" src="https://img.shields.io/badge/-source-cccccc?style=flat-square"></a>

## <kbd>function</kbd> `calculate_admittance`

```python
calculate_admittance(R, X)
```

Calculates the admittance values from resistance and reactance. 



**Args:**
 
 - <b>`R`</b> (np.array):  Resistance values. 
 - <b>`X`</b> (np.array):  Reactance values. 



**Returns:**
 
 - <b>`np.array`</b>:  Admittance values. 


---

<a href="..\..\..\Ybus\python\Ybus_python.py#L46"><img align="right" style="float:right;" src="https://img.shields.io/badge/-source-cccccc?style=flat-square"></a>

## <kbd>function</kbd> `calculate_admittance_matrix`

```python
calculate_admittance_matrix(zdata)
```

Calculates the bus admittance matrix from the linedata. 



**Args:**
 
 - <b>`zdata`</b> (np.array):  Linedata matrix. 



**Returns:**
 
 - <b>`np.array`</b>:  Bus admittance matrix. 


---

<a href="..\..\..\Ybus\python\Ybus_python.py#L76"><img align="right" style="float:right;" src="https://img.shields.io/badge/-source-cccccc?style=flat-square"></a>

## <kbd>function</kbd> `print_admittance_matrix`

```python
print_admittance_matrix(Ybus)
```

Prints the bus admittance matrix to the console. 



**Args:**
 
 - <b>`Ybus`</b> (np.array):  Bus admittance matrix. 




---

_This file was automatically generated via [lazydocs](https://github.com/ml-tooling/lazydocs)._
