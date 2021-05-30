Q.

1. The sum of all values in LAT_N rounded to a scale of 2 decimal places.
2. The sum of all values in LONG_W rounded to a scale of 2 decimal places.

A.
```
SELECT
    ROUND(SUM(LAT_N), 2),
    ROUND(SUM(LONG_W), 2)
FROM STATION;
```

위도, 경도 합을 구해 소수점 둘째 자리까지 나오도록 반올림한 결과 출력