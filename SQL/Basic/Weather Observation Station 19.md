Q. Consider P1(a, c) and P2(b, d) to be two points on a 2D plane where (a, b) are the respective minimum and maximum values of Northern Latitude (LAT_N) and (c, d) are the respective minimum and maximum values of Western Longitude (LONG_W) in STATION.

A.
```SQL
SELECT
    ROUND(SQRT(
        POWER((MAX(LAT_N)-MIN(LAT_N)), 2)
     + POWER((MAX(LONG_W)-MIN(LONG_W)), 2)
          ), 
          4)
FROM STATION;
```

P1은 최대 LAT_N과 최소 LAT_N을 포인트로 가지고, P2는 최대 LONG_W와 최소 LONG_W를 포인트로 가진다.

<strong>Euclidean Distance</strong> 알고리즘에 P1, P2를 적용시킨다.