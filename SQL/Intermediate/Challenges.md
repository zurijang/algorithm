Q.

hacker_id, name, 각 학생에 의해 만들어진 challenge 수를 출력하라.

challenge를 많이 한 학생을 내림차순으로 정렬하고, hacker_id의 순으로 정렬하라.

한 명 이상의 학생이 동일한 수의 도전 과제를 냈고 그 수가 최대 도전과제 개수보다 적다면, 그 학생들은 결과에서 제외한다. → 최대 도전 과제 중복학생들을 제외하고 중복되는 항목은 모두 제외

<strong>Table</strong>

- Hackers

|Column|Type|
|--------|------|
|hacker_id|Integer|
|name|String|

    hacker_id : 해커의 id
    name : 해커의 이름

- Challenges

|Column|Type|
|---------|-------|
|challenge_id|Integer|
|hacker_id|Integer|

    challenge_id : challenge의 id
    hacker_id : 해커의 id


A.

```SQL
SELECT 
    h.HACKER_ID AS HACKER_ID,
    h.NAME AS NAME,
    COUNT(c.challenge_id) AS CHALLENGES_CREATED
FROM HACKERS h
LEFT JOIN CHALLENGES c ON h.HACKER_ID = c.HACKER_ID
GROUP BY h.HACKER_ID, h.NAME
HAVING CHALLENGES_CREATED = (
    SELECT 
        MAX(TEMP.CNT) 
    FROM (
        SELECT 
            COUNT(HACKER_ID) AS CNT 
        FROM CHALLENGES 
        GROUP BY HACKER_ID
    ) TEMP
)
OR CHALLENGES_CREATED IN (
    SELECT
        A.CNT
    FROM (
        SELECT
            COUNT(*) AS CNT
        FROM CHALLENGES
        GROUP BY HACKER_ID
    ) A
    GROUP BY A.CNT
    HAVING COUNT(A.CNT) = 1
)
ORDER BY COUNT(C.CHALLENGE_ID) DESC, HACKER_ID ASC;
```

MYSQL 에서는 식별자로 HAVING 조건을 걸 수 있지만, ORACLE 에서는 식별자로 조건을 걸 수 없음을 발견

데이터 조회 속도는 ORACLE이 더 빠름

- SELECT 문에 있는 서브쿼리 : 스칼라 서브쿼리
- FROM 절에 있는 서브쿼리 : 인라인 뷰
- WHERE 절에 있는 서브쿼리 : 서브쿼리
- 단일 행 서브쿼리(Single Row Subquery) : 서브쿼리의 결과가 1행
- 다중 행 서브쿼리(Multiple-Row Subquery) : 서브쿼리의 결과가 여러 행
- 다중 컬럼 서브쿼리(Multi-Column Subquery) : 서브쿼리의 결과가 여러 컬럼

중복된 경우를 생각했을 때 도전과제를 가장 많이 낸 중복된 경우의 학생들을 출력하고 그 외에 중복된 학생들은 제외시켜야 했다.

서브쿼리에 인라인 뷰를 활용해 HACKER_ID 별로 도전과제 개수를 뽑고, 각각의 조건에서 개수의 최대값과 개수가 1개인 것을 뽑을 수 있도록 OR 를 사용.

