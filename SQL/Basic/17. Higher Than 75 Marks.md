Query the Name of any student in STUDENTS who scored higher than 75 Marks. Order your output by the last three characters of each name. If two or more students both have names ending in the same last three characters (i.e.: Bobby, Robby, etc.), secondary sort them by ascending ID.

<strong>Input Format</strong>

The STUDENTS table is described as follows:

|Column|Type|
|------|----|
|ID|Integer|
|Name|String|
|Marks|Integer|

The Name column only contains uppercase(A-Z) and lowercase (a-z) letters.

<strong>Sample Input</sample>
|ID|Name|Marks|
|--|----|-----|
|1|Ashley|81|
|2|Samantha|75|
|4|Julia|76|
|3|Belvet|84|

<strong>Sample Output</strong>
```
Ashley
Julia
Belvet
```

<strong>Explanation</strong><br>
Only Ashley, Julia, and Belvet have MArks > 75. If you look at the last three characters of each of their names, there are no duplicates and 'ley'<'lia'<'vet'.

A.
```
SELECT NAME
FROM STUDENTS
WHERE MARKS > 75
ORDER BY SUBSTR(NAME, -3, 3), ID ASC;
```

정렬 기준이 2개였다.

1. 이름 끝에서 3자리
2. ID

이름 끝에서 3자리를 구하기 위해 `SUBSTR`을 사용해 -3으로 뒤에서 3번째를 지정했다.