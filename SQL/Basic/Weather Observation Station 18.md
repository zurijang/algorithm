Q.

Consider P1(a, b) and P2(c, d) to be two points on a 2D plane.

- a happens to equal the minimum value in Northern Latitude (LAT_N in STATION).
- b happens to equal the minimum value in Western Longitude (LONG_W in STATION).
- c happens to equal the maximum value in Northern Latitude (LAT_N in STATION).
- d happens to equal the maximum value in Western Longitude (LONG_W in STATOIN).

Query the <strong>Manhattan Distance</strong> between points P1 and P2 and round it to a scale of 4 decimal places.

A.

```SQL
SELECT
    ROUND(MAX(LAT_N)-MIN(LAT_N), 4)
    +ROUND(MAX(LONG_W)-MIN(LONG_W), 4)
FROM STATION;
```

P1 지점의 (위도, 경도)와 P2 지점의 (위도, 경도)가 있다고 가정했을 때, P1 지점은 위도와 경도가 가장 큰 값을 가지는 곳, P2 지점은 위도와 경도가 가장 작은 값을 가지는 곳이다.

이 두 지점을 이용해 맨해튼 거리 알고리즘으로 지점 사이의 거리를 구한다.<br> 
`|p1-q1| + |p2-q2|`