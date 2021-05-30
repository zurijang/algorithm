Q.

LONG_W 를 소수점 4째 자리까지 나타낼 것<br>
LAT_N < 137.2345 조건을 만족하는 값<br>
위 조건 중 가장 큰 LONG_W 값

A.
```
SELECT
    ROUND(LONG_W, 4)
FROM STATION
WHERE LAT_N < 137.2345
ORDER BY LAT_N DESC
LIMIT 1;
```