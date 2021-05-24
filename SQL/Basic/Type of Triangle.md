Q. Write a query identifying the type of each record in the TRIANGLES table using its three side lengths. Output one of the following statements for each record in the table:

- Equilateral : It's a triangle with 3 sides of equal length.
- Isosceles: It's a triangle with 2 sides of equal length.
- Scalene: It's a triangle with 3 sides of differing lengths.
- Not A Triangle: The given values of A, B, and C don't form a triangle.

<strong>Input Format</strong><br>
The TRIANGLES table is described as follows:
|Column|Type|
|------|----|
|A|Integer|
|B|Integer|
|C|Integer|

Each row in the table denotes the lengths of each of a triangle's three sides.

<strong>Sample Input</strong><br>
|A|B|C|
|--|--|--|
|20|20|23|
|20|20|20|
|20|21|22|
|13|14|30|

<strong>Sample Output</strong><br>
```
Isosceles
Equilateral
Salene
Not A Triangle
```

<strong>Explanation</strong><br>
Values in the tuple (20,20,23) form an Isosceles triangle, because A=B.<br>
Values in the tuple (20,20,20) form an Equilateral triangle, because A=B=C. <br>
Values in the tuple (20,21,22) form a Scalene triangle, because A!=B!=C.<br>
Values in the tuple (13,14,30) cannot form a triangle because the combined vlaue of sides A and B is not larger than that of side C.<br>

A.
```
SELECT CASE
        WHEN A + B > C AND B + C > A AND A + C > B THEN
            CASE
                WHEN A = B AND B = C AND C = A THEN 'Equilateral'
                WHEN A = B OR B = C OR C = A THEN 'Isosceles'
                ELSE 'Scalene'
            END
        ELSE 'Not A Triangle'
    END
FROM TRIANGLES;
```
`CASE-WHEN-END`로 두 변의 합이 다른 한 변의 길이보다 커야하는 삼각형의 조건을 확인하고 정삼각형, 이등변삼각형, 삼각형 일 때의 조건을 확인한다.