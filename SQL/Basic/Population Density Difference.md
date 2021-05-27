Q. Query the difference between the maximum and minimum populations in CITY.

The CITY table is described as follows:

|Field|Type|
|-----|----|
|ID|NUMBER|
|NAME|VARHCAR2(17)|
|COUNTRYCODE|VARCHAR2(3)|
|DISTRICT|VARHCAR2(20)|
|POPULATION|NUMBER|

A.
```
SELECT
    MAX(POPULATION)-MIN(POPULATION)
FROM CITY;
```