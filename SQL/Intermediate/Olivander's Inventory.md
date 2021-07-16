Q.

헤르미온느는 최소의 gold galleons로 high power와 age를 중요하게 생각. 그리고 non-evil 해야 함

id, age, coins_needed, power 를 출력해라.

power는 내림차순으로 정렬, 같은 power는 age 내림차순 정렬

<strong>Table</strong>

- Wands

|Column|Type|
|------|-------|
|id|Integer|
|code|Integer|
|coins_needed|Integer|
|power|Integer|

    id : wand의 id
    code : wand의 code
    coins_needed : 사기위해 필요한 gold galleons(돈)
    power : wand의 퀄리티의 정도

- Wands_Property

|Column|Type|
|--------|-------|
|code|Integer|
|age|Integer|
|is_evil|Integer|

    code : wand의 code
    age : wand의 age (오래된 정도)
    is_evil : wand가 악인지 아닌지
    is_evil = 0 이면 악하지 않음
    code와 age는 1 : 1 관계


A.

```SQL
SELECT
    A.ID,
    B.AGE,
    A.COINS_NEEDED,
    A.POWER
FROM WANDS A
LEFT JOIN WANDS_PROPERTY B ON A.CODE = B.CODE
WHERE B.IS_EVIL = 0
AND A.COINS_NEEDED = (
    SELECT
        MIN(COINS_NEEDED)
    FROM WANDS W1
    LEFT JOIN WANDS_PROPERTY P1 ON (W1.CODE = P1.CODE)
    WHERE W1.POWER = A.POWER
    AND P1.AGE = B.AGE
)
ORDER BY A.POWER DESC, B.AGE DESC;
```

서브쿼리로 최소 필요한 돈의 조건을 검사하는데, 메인 쿼리와 서브 쿼리의 POWER와 AGE가 동일해야 한다.

(P.S. 잘 이해가 안된다. 더 간편하게 할 수 있을 것 같은데...)