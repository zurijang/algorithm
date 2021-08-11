Q.

Symmetric pairs를 구하라.

`X1=X2 and X2=X1`

A.

```SQL
SELECT
    T1.X, T1.Y
FROM FUNCTIONS T1
INNER JOIN FUNCTIONS T2 ON T1.X = T2.Y AND T1.Y = T2.X
GROUP BY T1.X, T1.Y
HAVING COUNT(T1.X) > 1 OR T1.X < T1.Y
ORDER BY T1.X ASC;
```

(X, Y) 와 (Y, X) 를 나타내기 위해 같은 테이블을 활용해 조인 조건을 통해 X와 Y의 값이 같은지 확인을 했다.

이 결과를 X, Y 쌍으로 `GROUP BY` 하고, (X, Y) (Y, X) 쌍이 있어야하기 때문에 집계함수 중 `COUNT` 로 2개 이상인 값을 찾고, X의 값이 Y의 값보다 작은 것을 찾도록 조건을 줬다.

