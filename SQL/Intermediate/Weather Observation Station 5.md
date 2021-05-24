Q. Query the <strong>two cities in STATION</strong> with the <strong>shortest</strong> and <strong>longest</strong> CITY names, as well as their respective lengths (i.e.: number of characters in the name). If there is more than one smallest or largest city, <strong>choose the one that comes first when ordered alphabetically.</strong>

The STATION table is described as follows:

where LAT_N is the northern latitude and LONG_W is the western longitude.

|Field|Type|
|-----|----|
|ID|NUMBER|
|CITY|VARCHAR2(21)|
|STATE|VARCHAR2(2)|
|LAT_N|NUMBER|
|LONG_W|NUMBER|

<strong>Sample Input</strong><br>
For example, CITY has four entries: DEF, ABC, PQRS and WXY.

<strong>Sample Output</strong><br>
```
ABC 3
PQRS 4
```
<strong>Explanation</strong><br>
When ordered alphabetically, the CITY names are listed as ABC, DEF, PQRS, and WXY, with lengths 3, 3, 4, and 3. The longest name is PQRS, but there are 3 options for shortest named city. Choose ABC, because it comes first alphabetically.

<strong>Note</strong><br>
You can write two separate queries to get the desired output. <strong>It need not be a single query.</strong>

A.
```
SELECT 
    CITY, 
    LENGTH(CITY)
FROM STATION
ORDER BY LENGTH(CITY), CITY
LIMIT 1;

SELECT
    CITY,
    LENGTH(CITY)
FROM STATION
ORDER BY LENGTH(CITY) DESC, CITY
LIMIT 1;
```

최소 CITY 명 길이, 최대 CITY 명 길이를 따로 구한다. 첫번째로 `LENGTH(CITY)`를 기준으로 정렬한 뒤 CITY 알파벳 순서로 정렬한다. 다음으로 LIMIT을 통해 첫 번째 행만 반환했다.