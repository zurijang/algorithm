Q. Find the difference between the total number of CITY entries in the table and the number of distinct CITY entries in the table.

The STATION table is described as follows:

where LAT_N is the northern latitude and LONG_W is the western longitude.

|Field|Type|
|-----|----|
|ID|NUMBER|
|CITY|VARCHAR2(21)|
|STATE|VARCHAR2(2)|
|LAT_N|NUMBER|
|LONG_W|NUMBER|

For example, if there are three records in the table with CITY values 'New York', 'New York', 'Bengalaru', there are 2 different city names: 'New York' and 'Bengalaru'. The query retruns 1, because total nubmer of records - nubmer of unique city names = 3 - 2 = 1

A.
```
SELECT COUNT(CITY)-COUNT(DISTINCT CITY)
FROM STATION;
```

전체 'CITY'의 개수 - 중복을 제외한 'CITY'의 개수의 결과를 찾아야한다. `COUNT` 함수를 활용해 각각의 개수를 구해서 뺀 값을 반환했다.

In conclusion, the whole value is subtracted from the duplicate. So, the total number of CITY using `COUNT` function is subtracted by the number of CITY excluding duplicates using `COUNT` function.