Q. Query the list of CITY names starting with vowels(i.e., a, e, i, o. or u) from STATION. Your result cannot contain duplicates.

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
SELECT 
    DISTINCT CITY
FROM STATION
WHERE LOWER(SUBSTR(CITY, 1, 1)) IN ('a', 'e', 'i', 'o', 'u');
```

CITY의 시작 알파벳이 모음(a, e, i, o, u) 인 값을 중복을 제거하고 출력하기를 원한다. `DISTINCT` 로 중복값을 제거하고, `SUBSTR`을 통해 CITY의 첫 번째 자리값을 자르고, `IN`을 통해 값의 존재유무를 비교했다.