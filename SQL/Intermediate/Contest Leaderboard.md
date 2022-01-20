Q.

모든 도전과제의 최대 스코어의 합을 구해야 함.

해커아이디, 이름, 전체 점수의 데이터를 뽑고, 점수, 해커 아이디 순서로 정렬하라.

전체 점수 합이 0점인 결과는 제외하라.


- Hackers

|Column|Type|
|--------|------|
|hacker_id|Integer|
|name|String|

    hacker_id : 해커의 id
    name : 해커의 이름


- Submissions

|Column|Type|
|------|------|
|submission_id|Integer|
|hacker_id|Integer|
|challenge_id|Integer|
|score|Integer|


A.

```SQL
SELECT
    S.HACKER_ID,
    H.NAME,
    SUM(S.SCORE)
FROM (
    SELECT
    HACKER_ID,
    CHALLENGE_ID,
    MAX(SCORE) AS SCORE
FROM SUBMISSIONS
GROUP BY HACKER_ID, CHALLENGE_ID
) S
LEFT JOIN HACKERS H ON S.HACKER_ID = H.HACKER_ID
GROUP BY S.HACKER_ID, H.NAME
HAVING SUM(S.SCORE) != 0
ORDER BY SUM(S.SCORE) DESC, HACKER_ID ASC;
```

같은 도전과제에 대한 제출 중 큰 값을 구하기 위해 인라인뷰를 통해 획득 점수가 더 큰 값을 고를 수 있도록 했다.

다음으로 인라인뷰와 해커테이블의 이름을 조인하고 인라인뷰의 점수들을 합하고 이 값이 0인 것을 `HAVING` 절에서 제외시켰다.