Q.

하나 이상의 챌린지에서 만점을 달성한 hacker_id 와 name를 출력해야 한다.

챌린지의 만점을 얻은 해커의 수를 기준으로 내림차순 정렬

만약 해커가 같은 점수를 얻었다면 hacker_id 를 오름차순으로 정렬


<strong>Table</strong>

- Hackers

|Column|Type|
|-------|------|
|hacker_id|Integer|
|name|String|


- Difficulty

|Column|Type|
|----------|-----|
|difficulty_level|Integer|
|score|Integer|

- Challenges

|Column|Type|
|----------|------|
|challenge_id|Integer|
|hacker_id|Integer|
|difficulty_level|Integer|

- Submissions

|Column|Type|
|--------|-------|
|submission_id|Integer|
|hacker_id|Integer|
|challenge_id|Integer|
|score|Integer|


A.

```SQL
SELECT
    H.HACKER_ID,
    H.NAME
FROM SUBMISSIONS S
INNER JOIN HACKERS H ON S.HACKER_ID = H.HACKER_ID
INNER JOIN CHALLENGES C ON S.CHALLENGE_ID = C.CHALLENGE_ID
INNER JOIN DIFFICULTY D ON C.DIFFICULTY_LEVEL = D.DIFFICULTY_LEVEL
WHERE S.SCORE = D.SCORE
AND C.DIFFICULTY_LEVEL = D.DIFFICULTY_LEVEL
GROUP BY H.HACKER_ID, H.NAME
HAVING COUNT(H.HACKER_ID) > 1
ORDER BY COUNT(H.HACKER_ID) DESC, H.HACKER_ID ASC;
```

처음에는 HACKERS 테이블 기준으로 LEFT JOIN 으로 시도를 했는데 조인이 잘 되지 않았다.

이후에 메인 테이블을 SUBMISSIONS 로 잡고 이거에 해당하는 값들을 INNER JOIN으로 병합하고 조건에 해당하는 각 도전에 대해 만점을 받은 이력이 2회 이상인 사람을 찾기 위한 조건을 걸어 해결했다.