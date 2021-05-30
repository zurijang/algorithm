Q.

총 수입 = salary * months<br>
총 수입이 제일 높은 경우와 그 인원 수를 출력

A.
```
SELECT
    MAX(E.EARNINGS),
    COUNT(*)
FROM (
    SELECT
        EMPLOYEE_ID,
        NAME,
        MONTHS,
        SALARY,
        MONTHS*SALARY AS EARNINGS
    FROM EMPLOYEE
) E
GROUP BY E.EARNINGS
ORDER BY E.EARNINGS DESC
LIMIT 1;
```

서브쿼리를 이용해 총 수입 (EARNINGS) 컬럼을 추가하고 `GROUP BY`로 총 수입을 묶은 것의 최대와 그 수를 출력하도록 했다. `ORDER BY` 와 `LIMIT` 을 활용해 총 수익이 가장 큰 경우를 구할 수 있었다.