https://www.hackerrank.com

Q. Query the NAME field for all American cities in the CITY table with populations larger than 120000. the CountryCode for America is USA.

The CITY table is described as follows:

|Field|Type|
|-----|----|
|ID|NUMBER|
|NAME|VARCHAR2(17)|
|COUNTRYCODE|VARCHAR2(3)|
|DISTRICT|VARCHAR2(20)|
|POPULATION|NUMBER|

A.
```
SELECT NAME 
FROM CITY
WHERE POPULATION >= 120000
AND COUNTRYCODE = 'USA';
```
