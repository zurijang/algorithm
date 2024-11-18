회사의 계층

Founder - Lead Manager - Senior Manager - Manager - Employee


Note:

- 테이블은 중복된 컬럼을 포함할 수 있다.
- Company_code : String 이여서 numeric으로 정렬할 수 없다. (C_1, C_2, C_10 이 있으면 C_1, C_10, C_2 순서로 정렬 됨)


Scheme :

- Company

|Column|Type|
|------|----|
|company_code|String|
|founder|String|

    - company_code : 회사 코드
    - founder : 설립자

- Lead_Manager

|Column|Type|
|------|----|
|lead_manager_code|String|
|company_code|String|

    - lead_manager_code : 리드 매니저 코드
    - company_code : 일하는 회사 코드

- Senior_Manager

|Column|Type|
|------|----|
|senior_manager_code|String|
|lead_manager_code|String|
|compnay_code|String|

    - senior_manager_code : 시니어 매니저 코드번호
    - lead_manager_code : 리드 매니저 코드 번호
    - company_code : 일하는 회사 코드 번호

- Manager

|Column|Type|
|------|----|
|manager_code|String|
|senior_manager_code|String|
|lead_manager_code|String|
|company_code|String|

    - manager_code : 매니저 코드 번호
    - senior_manager_code : 시니어 매니저 코드 번호
    - lead_manager_code : 리드 매니저 코드 번호
    - company_code : 일하는 회사 코드 번호

- Employee

|Column|Type|
|------|----|
|employee_code|String|
|manager_code|String|
|senior_manager_code|String|
|lead_manager_code|String|
|company_code|String|

    - employee_code : 직원 코드 번호
    - manager_code : 매니저 코드 번호
    - senior_manager_code : 시니어 매니저 코드 번호
    - lead_manager_code : 리드 매니저 코드 번호
    - company_code : 일하는 회사 코드 번호

Explanation

회사 C1은 리드 매니저가 LM1 한 명있다. 

LM1이 관리하는 시니어 매니저는 SM1, SM2 두 명 있다. 

SM1이 관리하는 매니저는 M1 한 명 있다. 

M1이 관리하는 직원 E1, E2 두 명 있다.


A.

```SQL
SELECT
    A.COMPANY_CODE,
    A.FOUNDER,
    COUNT(DISTINCT B.LEAD_MANAGER_CODE),
    COUNT(DISTINCT C.SENIOR_MANAGER_CODE),
    COUNT(DISTINCT D.MANAGER_CODE),
    COUNT(DISTINCT E.EMPLOYEE_CODE)
FROM COMPANY A
LEFT JOIN LEAD_MANAGER B ON A.COMPANY_CODE = B.COMPANY_CODE
LEFT JOIN SENIOR_MANAGER C ON A.COMPANY_CODE = C.COMPANY_CODE
LEFT JOIN MANAGER D ON A.COMPANY_CODE = D.COMPANY_CODE
LEFT JOIN EMPLOYEE E ON A.COMPANY_CODE = E.COMPANY_CODE
GROUP BY A.COMPANY_CODE, A.FOUNDER
ORDER BY A.COMPANY_CODE;
```

고유 인력을 놓쳐 DISTINCT 를 할 생각을 못하고, 각 회사별로 묶어서 각 테이블의 메인 컬럼(코드 번호)를 출력하면 되겠다 생각했는데, 예상과 다르게 중복된 값이 너무 많았다.
내가 놓친것은 문제에서 요구하는 것은 각 회사의 고유 인력 이었다는 것이다.

이를 해결하기 위해 DISTINCT 키워드로 중복요소를 제거한 개수를 카운트 하도록 했다.

