Q.

LAT_N의 값이 137.2345 보다 작은것 중 가장 큰 값을 구하고, 소수점 4째자리까지 나타내라.

A.
```
SELECT
    ROUND(MAX(LAT_N), 4)
FROM STATION
WHERE LAT_N <137.2345;
```