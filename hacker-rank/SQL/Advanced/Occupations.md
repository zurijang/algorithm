Q. 

OCCUPATIONS 테이블을 Pivot 해라.
이름을 알파벳순으로 정렬한다. 

Doctor, Professor, Singer, Actor 순서로 출력하라.


|Column|Type|
|------|----|
|Name|String|
|Occupation|String|


A.

```SQL
SELECT
    DOC.NAME DOCTR,
    PROF.NAME PROFESSOR,
    SING.NAME SINGER,
    ACT.NAME ACTOR
FROM (
    SELECT
        ROWNUM RN,
        NAME
    FROM (
        SELECT
            NAME
        FROM OCCUPATIONS
        WHERE OCCUPATION = 'Doctor'
        ORDER BY NAME
    )
) DOC
FULL OUTER JOIN (
    SELECT
        ROWNUM RN,
        NAME
    FROM (
        SELECT
            NAME
        FROM OCCUPATIONS
        WHERE OCCUPATION = 'Professor'
        ORDER BY NAME
    )
) PROF ON DOC.RN = PROF.RN
FULL OUTER JOIN (
    SELECT
        ROWNUM RN,
        NAME
    FROM (
        SELECT
            NAME
        FROM OCCUPATIONS
        WHERE OCCUPATION = 'Singer'
        ORDER BY NAME
    )
) SING ON PROF.RN = SING.RN
FULL OUTER JOIN (
    SELECT
        ROWNUM RN,
        NAME
    FROM (
        SELECT
            NAME
        FROM OCCUPATIONS
        WHERE OCCUPATION = 'Actor'
        ORDER BY NAME
    )
) ACT ON SING.RN = ACT.RN;
```

`NAME`과 `OCCUPATION`의 데이터로 이루어진 테이블에서 `ROWNUM`을 추가하여 각 직업별로 스키마화 했다.

각 `OCCUPATION` 별 데이터 수를 알기 힘들기에 `ROWNUM`을 기준으로 `FULL OUTER JOIN` 하여 PIVOT 화 할 수 있었다.