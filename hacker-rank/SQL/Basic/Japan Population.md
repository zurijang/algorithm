Q. Query the sum of the populations for all Japanese cities in CITY. The COUNTRYCODE for Japan is JPN.

The CITY table is described as follows:

|Field|Type|
|-----|----|
|ID|NUMBER|
|NAME|VARCHAR2(17)|
|COUNTRYCODE|VARCHAR2(3)|
|DISTRICT|VARHCAR2(20)|
|POPULATION|NUMBER|

A.
```
SELECT
    SUM(POPULATION)
FROM CITY
WHERE COUNTRYCODE = 'JPN';
```