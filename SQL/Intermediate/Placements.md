Q.

Students, Friends, Packages 테이블이 있다.

*Students*

|Column|Type|
|------|----|
|ID|Integer|
|Name|String|

*Friends*

|Column|Type|
|------|------|
|ID|Integer|
|Friend_ID|Integer|

*Packages*

|Column|Type|
|------|----|
|ID|Integer|
|Salary|Float|


베스트 프렌드가 보다 높은 salary를 제공받는 학생들의 이름을 출력하라.

salary amount가 높은 순으로 정렬

같은 salary의 학생은 없음이 보장됨


A.

```SQL
SELECT
    S.NAME
FROM STUDENTS S
LEFT JOIN FRIENDS F ON S.ID = F.ID
LEFT JOIN PACKAGES P ON S.ID = P.ID
LEFT JOIN PACKAGES P2 ON F.FRIEND_ID = P2.ID
WHERE P.SALARY < P2.SALARY
ORDER BY P2.SALARY ASC;
```

자신과 친구의 연봉을 비교하기위해 ID, FRIEND_ID 를 기준으로 각각의 연봉을 조인하여 비교했다.