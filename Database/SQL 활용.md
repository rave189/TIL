<h1>SQL 활용</h1>

## JOIN

조인은 여러 개의 릴레이션을 사용해서 새로운 릴레이션을 만드는 과정이다.

<h3>EQUI 조인</h3>

EQUI 조인은 두 개의 다른 테이블 간에 일치하는 것을 조인하는 것이다.

```sql
SELECT *
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;
```



<strong>INNER JOIN</strong>

INNER JOIN은 ON을 사용해서 테이블을 연결한다.

```sql
SELECT *
FROM EMP INNER JOIN DEPT
ON EMP.DEPTNO = DEPT.DEPTNO
AND EMP.ENAME LIKE '임%'
ORDER BY ENAME;
```

조인문에 추가 조건과 정렬을 할 수 있다.



- EQUI 조인의 실행 계획을 보면 해시 함수를 사용하여 두 개의 테이블을 연결한다.
- 해시 함수는 테이블을 해시 메모리에 적재한 후에 해시 함수로써 연결하는 방법이다.
- 해시 조인은 EQUI 조인만 사용 가능한 방법이다.



<strong>INTERSECT 연산</strong>

INTERSECT 연산은 두 개의 테이블에서 교집합을 조회한다.

```sql
SELECT DEPTNO FROM EMP
INTERSECT
SELECT DEPTNO FROM DEPT;
```



<h3>Non-EQUI 조인</h3>

Non-EQUI 조인은 두 개의 테이블 간에 조인하는 경우 =을 사용하지 않고 >, <, >=, <= 등을 사용한다.

따라서 Non-EQUI 조인은 정확하게 일치하지 않는 것을 조인하는 것이다.



<h3>OUTER JOIN</h3>

- OUTER JOIN은 두 개의 테이블 간에 교집합을 조회하고 한 쪽 테이블에만 있는 데이터도 포함시켜서 조회한다.
- 교집합을 조회하고 왼쪽 테이블에만 있는 행도 포함하면 LEFT OUTER JOIN이다.
- 교집합을 조회하고 오른쪽 테이블에만 있는 행도 포함하면 RIGHT OUTER JOIN이다.
- CROSS JOIN은 조인 조건구 없이 2개의 테이블을 하나로 조인한다.
  - 조인구가 없어 카테시안 곱이 발생

```sql
SELECT * FROM DEPT LEFT(RIGHT) OUTER JOIN EMP
ON EMP.DEPTNO = DEPT.DEPTNO;
```



<h3>UNION</h3>

- UNION 연산은 두 개의 테이블을 하나로 만드는 연산이다.
  - 두 개의 테이블의 칼럼 수, 칼럼의 데이터 형식 모두가 일치해야한다.

- UNION 연산은 두 개의 테이블을 하나로 합치면서 중복된 데이터를 제거한다.
- 중복된 데이터를 제거하기 때문에 정렬이 발생한다.
- UNION ALL을 사용하여 중복된 데이터를 제거하지 않고 정렬을 하지 않으면서 테이블을 합칠 수 있다.



<h3>MINUS</h3>

- 두 개의 테이블에서 차집합을 조회한다.

  - 먼저 쓴 SELECT에는 있고 뒤에 쓴 SELECT 문에는 없는 데이터를 조회한다.
  - MS-SQL에서는 EXCEPT로 사용할 수 있다.

  

## 계층형 조회(Connect by)

- 계층형 조회는 계층형으로 데이터를 조회하는 것이다.
  - ex) 부장, 차장, 과장, 대리, 사원 순으로 트리 형태로 조회
- START WITH구는 시작 조건을 의미한다.
- CONNECT BY PRIOR는 조인 조건을 의미한다.

```sql
SELECT MAX(LEVEL)
FROM Limbest.EMP
START WITH MGR IS NULL
CONNECT BY PRIOR EMPNO = MGR;
```

- 계층형 조회 결과를 명확히 보려면 LPAD 함수를 사용할 수 있다.

```sql
SELECT LEVEL, LPAD(' ', 4 * (LEVEL-1) || EMPNO, MGR, CONNECT_BY_ISLEAF)
FROM EMP
START WITH MGR IS NULL
CONNECT BY PRIOR EMPNO = MGR;
```



<strong>CONNECT BY 키워드</strong>

- LEVEL: 검색 항목의 깊이를 의미한다.
- CONNECT_BY_ROOT: 계층 구조에서 최상위 값을 표시한다.
- CONNECT_BY_ISLEAF: 계층 구조에서 가장 최하위를 표시한다.
- SYS_CONNECT_BY_PATH: 계층 구조의 전체 전개 경로를 표시한다.
- NOCYCLE: 순환구조가 발생한 지점까지만 전개된다.
- CONNECT_BY_ISCYCLE: 순환 구조 발생 지점을 표시한다.



## 서브 쿼리(Subquery)

- 서브 쿼리는 SELECT문 내에 다시 SELECT문을 사용하는 것이다.
- FROM구에 SELECT 문을 사용하는 인라인 뷰(inline view)와 SELECT문에 사용하는 스칼라 서브쿼리(Scala Subquery)가 있다.
- WHERE구에 SELECT문을 사용하면 서브쿼리라고 한다.
- 반환 행 수가 한 개인 쿼리를 단일 행 서브쿼리라고 한다.
  - 비교 연산자(=, <, <=, >=, <>)를 사용한다.
- 반환 행 수가 여러 개인 쿼리를 다중 행 서브쿼리라고 한다.
  - 다중 행 비교 연산자인 IN, ANY, ALL, EXITS를 사용한다.



<strong>스칼라 서브쿼리</strong>

- 스칼라 서브쿼리는 반드시 한 행과 한 칼럼만 반환해야 한다.
  - 여러 행이 반환되면 오류가 발생한다.



<strong>연관(Correlated) 쿼리</strong>

- 연관 서브쿼리는 서브쿼리 내에서 메인 쿼리 내의 칼럼을 사용하는 것을 의미한다.

```sql
SELECT *
FROM EMP a
WHERE a.DEPTNO = (SELECT DEPTNO FROM DEPT b
					WHERE b.DEPTNO = a.DEPTNO);
```



## 그룹 함수(Group Function)

<h3>ROLLUP</h3>

