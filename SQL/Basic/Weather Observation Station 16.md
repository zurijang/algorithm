Q.

LAT_N > 38.7780 보다 큰 것 중 <br>
가장작은 LAT_N 값<br>
소수점 4째자리 까지 나타낼 것

A.
```
SELECT
    ROUND(MIN(LAT_N), 4)
FROM STATION
WHERE LAT_N > 38.7780;
```