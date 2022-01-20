Q.

STATION 테이블로부터 LAT_N이 38.7780 보다 큰 것 중에서 가장 작은 LONG_W를 출력해라.

A.

```SQL
SELECT 
    ROUND(LONG_W, 4) 
FROM STATION 
WHERE LAT_N = (SELECT MIN(LAT_N) 
               FROM STATION 
               WHERE LAT_N > 38.7780
);
```

