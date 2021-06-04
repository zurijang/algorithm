Q.

컬럼 N과 P를 갖는 테이블이 있다. N은 트리 노드이고 P는 N의 부모요소 이다.

- Root : 루트 노드
- Leaf : 자식 노드
- Inner : 부모 노드

노드의 값에 의한 노드 형태를 출력하는 쿼리문을 작성하시오.

A.
```SQL
SELECT
    BST.N,
    CASE
        WHEN BST.P IS NULL THEN 'Root'
        WHEN B.DP IS NULL THEN 'Leaf'
        ELSE 'Inner'
    END
FROM BST, (SELECT DISTINCT P AS DP FROM BST) B
WHERE BST.N = B.DP(+)
ORDER BY BST.N;
```

노드 N의 형태를 출력하기 위해 테이블로부터 N과 P에 요소의 값에 있는지에 따라 조건을 건다. BST 테이블과 P의 요소를 뽑은 테이블을 N과 DP의 값으로 `LEFT OUTER JOIN` 을 했다. DP의 값이 N과 같으면 B.DP에 해당하지 않는 컬럼은 NULL이 된다. ROOT는 부모가 없기에 P가 NULL이고, JOIN 조건으로 NULL의 값을 가지면 LEAF 그 외에는 INNER가 된다.