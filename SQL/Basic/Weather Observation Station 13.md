Q.

38.7880 < SUM(LAT_N) < 137.2345 를 출력<br>
소수점 4째 자리까지 나오도록 해라.

A.
```
SELECT
    ROUND(SUM(LAT_N), 4)
FROM STATION
WHERE 1=1
AND LAT_N > 38.7880
AND LAT_N < 137.2345;
```