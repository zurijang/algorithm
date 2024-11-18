Q. Samantha was tasked with calculating the average monthly salaries for all employees in the EMPLOYEES table, but did not realize her keyboard's 0 key was broken until after completing the calculation. She wants your help finding the difference between her miscalculation (using salaries with any zeros removed), and the actual average salary.

Write a query calculating the amout of error (i.e: actual - miscalculated average monthly salaries), and round it up to the next integer.

<strong>Input Format</strong><br>
The EMPLOYEES<br> 
table is described as follows:

|Column|Type|
|------|----|
|ID|Integer|
|Name|String|
|Salary|Integer|

Note: Salary is per month.

Constraints<br>

1000 < Salary < 10^5

<strong>Sample Input</strong><br>

|ID|Name|Salary|
|--|----|-------|
|1|Kristeen|1420|
|2|Ashley|2006|
|3|Julia|2210|
|4|Maria|3000|

<strong>Sample Output</strong><br>
```
2061
```

<strong>Explanation</strong><br>
The table below shows the salaries without zeros as they were entered by Samantha:

|ID|Name|Salary|
|--|----|------|
|1|Kristeen|142|
|2|Ashley|26|
|3|Julia|221|
|4|Maria|3|

Samantha computes an average salary of 98.00. The Actual average salary is 2159.00.<br>
The resulting error between the two calculations is 2159.00 - 98.00 = 2061.00. Since it is equal to the integer 2061, it does not get rounded up.

A.
```
SELECT
    CEIL(AVG(SALARY)-AVG(REPLACE(SALARY, '0', '')))
FROM EMPLOYEES;
```

문제에서 요구하는 것은 월급의 평균과 0이 제거된 월급의 평균간의 차이이다. `REPLACE()` 로 0을 공백으로 대체하고, 정수 올림 함수 `CEIL()`로 소수점 아래자리를 처리했다.