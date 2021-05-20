Q. Generate the following two result sets:
1. Query an alphabetically ordered list of all names in OCCUPATIONS, immediately followed by the first letter of each profession as a parenthetical(i.e.: enclosed in parentheses). For example: AnActorName(A), ADcotrName(D), AProfessorName(P), and ASingerNAme(S).
2. Query the number of ocurrences of each occupation in OCCUPATIONS. Sort the occurrences in ascending order, and output them in the following format:
```
There are a total of [occupation_count] [occupation]s.
```
where [occupation_count] is the number of occurrences of an occupation in OCCUPATIONS and [occupation] is the lowercase occupation name. If more than one Occupation has the same [occupation_count], they should be ordered alphabetically.

Note: There will be at least two entries in the table for each type of occupation.

<strong>Input Format</strong><br>

|Column|Type|
|------|----|
|Name|String|
|Occupation|String|

The OCCUPATIONS table is described as follows:<br>
contain one of the following values: Doctor, Professor, Singer or Actor.

<strong>Sample Input</strong><br>
An OCCUPATIONS table that contains the following records:

|Name|Occupation|
|----|----------|
|Samantha|Doctor|
|Julia|Actor|
|Maria|Actor|
|Meera|Singer|
|Ashely|Professor|
|Ketty|Professor|
|Christeen|Professor|
|Jane|Actor|
|Jenny|Doctor|
|Priya|Singer|


<strong>Sample Output</strong><br>
```
Ashely(P)
Christeen(P)
Jane(A)
Jenny(D)
Julia(A)
Ketty(P)
Maria(A)
Meera(S)
Priya(S)
Samantha(D)
There are a total of 2 doctors.
There are a total of 2 singers.
There are a total of 3 actors.
There are a total of 3 professors.
```

<strong>Explanation</strong><br>

The results of the first query are formatted to the problem description's specifications.<br>
The results of the second query are ascendingly ordered first by number of names corresponding tho each profession ( 2<=2<=3<=3 ), and then alphabetically by profession (doctor <= singer, and actor <= professor).


A.
```
SELECT
    NAME || '(' || SUBSTR(OCCUPATION, 1, 1) || ')'
FROM OCCUPATIONS
ORDER BY NAME;

SELECT
    'There are a total of ', COUNT(OCCUPATION), CONCAT(LOWER(OCCUPATION), 's.')
FROM OCCUPATIONS
GROUP BY OCCUPATION
ORDER BY COUNT(OCCUPATION) ASC, OCCUPATION ASC;
```
