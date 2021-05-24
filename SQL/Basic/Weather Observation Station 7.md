Q. Query the list of CITY names ending with vowels (a, e, i, o, u) from STATION. Your result cannot contain duplicates.

<strong>Input Format</strong><br>
The STATION table is described as follows:
|Field|Type|
|-----|----|
|ID|NUMBER|
|CITY|VARCHAR2(21)|
|STATE|VARCHAR2(2)|
|LAT_N|NUMBER|
|LONG_W|NUMBER|

where LAT_N is the northern latitude and LONG_W is the western longitude.

A.
```
SELECT DISTINCT CITY
FROM STATION
WHERE LOWER(SUBSTR(CITY, -1, 1)) IN ('a', 'e', 'i', 'o', 'u');
```

11번 문제와 동일한 구조로, CITY의 마지막 알파벳이 모음인 값을 구하기위해 `SUBSTR`에 -1로 뒤에서 첫번째 값을 지정해서 마지막 값을 비교할 수 있었다.