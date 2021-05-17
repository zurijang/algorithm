Q. Write a query that prints a list of employee names (i.e.: the name attribute) for employees in Employee having a salary greater than $2000 per month who have been employees for less than 10 months. Sort your result by ascending employee_id.


<storng>Input Format</strong><br>
The Employee table containing employee data for a company is described as follows:
|Column|Type|
|------|----|
|employee_id|Integer|
|name|String|
|months|Integer|
|salary|Integer|

where employee_id is an employee's ID number, name is their name, months is the total number of months they've been working for the company, and salary is their monthly salary.

<strong> Sample Input</strong>
|employee_id|name|months|salary|
|-----------|----|------|------|
|12228|Rose|15|1968|
|33645|Angela|1|3443|
|45692|Frank|17|1608|
|56118|Patrick|7|1345|
|59725|Lisa|11|2330|
|74197|Kimberly|16|4372|
|78454|Bonnie|8|1771|
|83565|Michael|6|2017|
|98607|Todd|5|3396|
|99989|Joe|9|3573|

<strong>Sample Output</strong>
```
Angela
Michael
Todd
Joe
```

<strong>Explanation</strong><br>
Angela has been an employee for 1 month and earns $3443 per month.<br>
Michael has been an employee for 6 months and earns $2017 per month.<br>
Todd has been an employee for 5 months and earns $3396 per month.<br>
Joe has been an employee for 9 months and earns $3573 per month.<br>
We order our output by ascending employee_id.


A.
```
SELECT NAME
FROM EMPLOYEE
WHERE MONTHS < 10
AND SALARY > 2000;
```