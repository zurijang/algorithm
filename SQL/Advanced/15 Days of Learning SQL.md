Q.

2016년 3월 1일 시작, 2016년 3월 15일 끝

매일 최소 1개 SUBMISSION을 만든 HACKER를 출력해라.

각 날별로 연속적으로 참여중인 HACKER의 수, SUBMISSION을 가장 많이 만든 해커의 HACKER_ID, NAME.

만약 2명 이상이면 HACKER_ID를 오름차순으로 정렬해라.

콘테스트의 날짜별로 정렬해야 한다.

**HACKERS**

|Column|Type|
|------|----|
|hacker_id|Integer|
|name|String|

**Submissions**

|Column|Type|
|------|----|
|submission_Date|Date|
|submission_id|Integer|
|hacker_id|Integer|
|score|Integer|


A.

```SQL
SELECT
    A.SUBMISSION_DATE,
    (SELECT COUNT(DISTINCT B.HACKER_ID) 
     FROM SUBMISSIONS B
     WHERE B.SUBMISSION_DATE = A.SUBMISSION_DATE
     AND (SELECT COUNT(DISTINCT C.SUBMISSION_DATE) FROM SUBMISSIONS C
          WHERE C.HACKER_ID = B.HACKER_ID
          AND C.SUBMISSION_DATE < A.SUBMISSION_DATE) = DATEDIFF(A.SUBMISSION_DATE, '2016-03-01')) AS UNIQUE_NUM,
    (SELECT HACKER_ID FROM SUBMISSIONS D WHERE D.SUBMISSION_DATE = A.SUBMISSION_DATE GROUP BY HACKER_ID ORDER BY COUNT(SUBMISSION_ID) DESC, HACKER_ID LIMIT 1) AS RESULT_HACKER_ID,
    (SELECT NAME FROM HACKERS WHERE HACKER_ID = RESULT_HACKER_ID)
FROM (SELECT DISTINCT SUBMISSION_DATE FROM SUBMISSIONS) A
ORDER BY A.SUBMISSION_DATE;
```

이 문제는 매일 연달아 참가한 `HACKER`의 수를 구하는 부분에서 애를먹었다. `HACKER_ID`가 참여한 날짜를 구해야 하는데, 각 날짜를 기준으로 (여기서는 '2016-03-01' 시작) 시작 날짜와 현재 날짜의 차를 구했을 때, 각 날짜에 `HACKER_ID`가 있는 개수가 같으면 첫날부터 기준날까지 매일 참가하였다는 결론을 이해하기가 어려웠다.

처음에는 각 항목별로 `JOIN`을 활용해 구해보려고 하였으나, 3-4 개의 조인을 걸면서 쿼리는 지저분해지면서 에러가 발생했는데, 에러의 늪에 갇혔었다.

무조건 `JOIN` 만이 답은 아니고 `Sub Query`를 잘 짜는 것이 더 효율적이라는 것을 느꼈다.