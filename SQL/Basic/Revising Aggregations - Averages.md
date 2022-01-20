Q. Query the average population of all cities in CITY where District is California.

The CITY table is described as foolows:

|Field|Type|
|-----|----|
|ID|NUMBER|
|NAME|VARCHAR2(17)|
|COUNTRYCODE|VARCHAR2(3)|
|DISTRICT|VARCHAR2(20)|
|POPULATION|NUMBER|

A.
```
SELECT
    AVG(POPULATION)
FROM CITY
WHERE DISTRICT='California';
```