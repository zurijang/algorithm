Q. Query a count of the number of cities in CITY having a Population larger than 100,000

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
    COUNT(*)
FROM CITY
WHERE POPULATION >= 100000;
```
