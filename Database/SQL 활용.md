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

- ROLLUP은 GROUP BY의 칼럼에 대해 Subtotal을 만들어 준다.
- ROLLUP을 할 때 GROUP BY구에 칼럼이 두 개 이상 오면 순서에 따라 결과가 달라진다.

```sql
SELECT DECODE(DDEPTNO, NULL, '전체합계', DEPTNO), SUM(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO);
```



<h3>GROUP BY</h3>

- GROUP BY 함수는 ROLLUP, CUBE, GROUPING SETS에서 생성되는 합계값을 구분하기 위해 만들어진 함수
- 소계, 합계 등이 계산되면 GROUPING 함수는 1을 반환하고 그렇지 않으면 0을 반환하여 합계값을 식별할 수 있다.

```sql
SELECT DEPTNO, GROUPING(DEPTNO), JOB, GROUPING(JOB), SUM(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB);
```



<h3>GROUPING SETS</h3>

- GROUPING SETS 함수는 GROUP BY에 나오는 칼럼의 순서에 관계없이 다양한 소계를 만들 수 있다.
- GROUPING SETS 함수는 GROUP BY에 나오는 칼럼의 순서와 관계없이 개별적으로 처리한다.

```sql
SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY GROUPING SETS(DEPTNO, JOB);
```



<h3>CUBE</h3>

- CUBE는 CUBE에서 제시한 칼럼에 대해서 결합 가능한 모든 집계를 계산한다.
- 다차원 집계를 제공하여 다양하게 데이터를 분석할 수 있게 한다.

```sql
SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY CUBE(DEPTNO, JOB);
```



## 윈도우 함수

<h3>윈도우 함수</h3>

- 윈도우 함수는 행과 행 간의 관계를 정의하기 위해 제공되는 함수이다.
- 윈도우 함수를 사용해서 순위, 합계, 평균, 행 위치 등을 조작할 수 있다.

```sql
SELECT WINDOW_FUNCTION(ARGUMENTS)
		OVER(PARTITION BY 칼럼
				ORDER BY WINDOWING절)
FROM 테이블 명;
```



<strong>윈도우 함수 구조</strong>

- ARGUMENTS(인수): 윈도우 함수에 따라 0~N개의 인수를 설정한다.
- PARTITION BY: 전체 집합을 기준에 의해 소그룹으로 나눈다.
- ORDER BY: 어떤 항목에 대해서 정렬한다.
- WINDOWING: 행 기준의 범위를 정한다.
  - ROWS는 물리적 결과의 행 수이고 RANGE는 논리적인 값에 의한 범위이다.



<strong>WINDOWING 구조</strong>

- ROWS: 부분집합인 윈도우 크기를 물리적 단위로 행의 집합을 지정한다.
- RANGE: 논리적인 주소에 의해 행 집합을 지정한다.
- BETWEEN ~ AND: 윈도우의 시작과 끝의 위치를 지정한다.
- UNBOUNDED PRECEDING: 윈도우의 시작 위치가 첫 번째 행임을 의미한다.
- UNBOUNDED FOLLOWING: 윈도우 마지막 위치가 마지막 행임을 의미한다.
- CURRENT ROW: 윈도우 시작 위치가 현재 행임을 의미한다.

전체 합계 조회

```sql
SELECT EMPNO, ENAME, SAL, SUM(SAL) OVER(ORDER BY SAL
										ROWS BETWEEN UNBOUNDED PRECEDING
										AND UNBOUNDED FOLLOWING) TOTSAL
FROM EMP;
```



누적 합계 조회

```sql
SELECT EMPNO, ENAME, SAL, SUM(SAL) OVER(ORDER BY SAL
										ROWS BETWEEN UNBOUNDED PRECEDING
										AND CURRENT ROW) TOTSAL
FROM EMP;
```



<h3>순위 함수</h3>

<strong>순위 관련 윈도우 함수</strong>

- RANK: 특정항목 및 파티션에 대해 순위를 계산한다.
  - 동일한 순위는 동일한 값이 부여된다.
- DENSE_RANK: 동일한 순위를 하나의 건수로 계산한다.
- ROW_NUMBER: 동일한 순위에 대해서 고유의 순위를 부여한다.



```sql
SELECT ENAME, SLA, RANK() OVER (ORDER BY SAL DESC) ALL_RANK,
					RANK() OVER (PARTITION BY JOB ORDER BY SAL DESC) JOB_RANK
					DENSE_RANK() OVER (ORDER BY SAL DESC) DENSE_RANK
					ROW_NUMBER() OVER (ORDER BY SAL DESC) ROW_NUM
FROM EMP;
```



<h3>집계 함수</h3>

- 윈도우 함수를 제공한다.



<strong>집계관련 윈도우 함수</strong>

- SUM: 파티션 별로 합계를 계산한다.
- AVG: 파티션 별로 평균을 계산한다.
- COUNT: 파티션 별로 행 수를 계산한다.
- MAX, MIN: 파티션 별로 최댓값, 최솟값을 계산한다.



```sql
SELECT ENAME, SAL, SUM(SAL) OVER (PARTITION BY MGR) SUM_MGR
FROM EMP;
```



<h3>행 순서 관련 함수</h3>

- 행 순서 관련 함수는 상위 행의 값을 하위에 출력하거나 하위 행의 값을 상위 행에 출력할 수 있다.
- 특정 위치의 행을 출력할 수 있다.



<strong>행 순서 관련 윈도우 함수</strong>

- FIRST_VALUE: 파티션에서 가장 처음에 나오는 값을 구한다.
  - MIN 함수를 사용해서 같은 결과를 구할 수 있다.
- LAST_VALUE: 파티션에서 가장 나중에 나오는 값을 구한다.
  - MAX 함수를 사용해서 같은 결과를 구할 수 있다.
- LAG: 이전 행을 가져 온다.
- LEAD: 윈도우에서 특정 위치의 행을 가지고 온다.
  - 기본값은 1이다.



```sql
SELECT DEPTNO, ENAME, SAL,
	FIRST_VALUE(ENAME) OVER (PARTITION BY DEPTNO ORDER BY SAL 
							DESC ROWS UNBOUNDED PRECEDING) AS DEPT_A,
	LAST_VALUE(ENAME) OVER (PARTITION BY DEPTNO ORDER BY SAL DESC ROWS 
							BETWEEN CURRENT ROW AND UNBOUNDED FOLLOWING) AS DEPT_A,
	LAG(SAL) OVER (ORDER BY SAL DESC) AS PRE_SAL,
	LEAD(SAL,2) OVER (ORDER BY SAL DESC) AS PRE_SAL
FROM EMP;
```



<h3>비율 관련 함수</h3>

- 비율 관련 함수는 누적 백분율, 순서 백분율, 파티션을 N분할한 결과 등을 조회할 수 있다.



<strong>비율 관련 윈도우 함수</strong>

- CUME_DIST: 파티션 전체 건수에서 현재 행보다 작거나 같은 건수에 대한 누적 백분율을 조회한다.
  - 누적 분포상에 위치를 0~1 사이의 값을 가진다.
- PERCENT_RANK: 파티션에서 제일 먼저 나온 것을 0으로 제일 늦게 나온 것을 1로하여 값이 아닌 행의 순서별 백분율을 조회한다.
- NTILE: 파티션별로 전체 건수를 ARGUMENT 값으로 N 등분한 결과를 조회한다.
- RATIO_TO_REPORT: 파티션 내에 전체 SUM(칼럼)에 대한 행 별 컬럼값의 백분율을 소수점까지 조회한다.



```sql
SELECT DEPTNO, ENAME, SAL,
	PERCENT_RANK() OVER (PARTITION BY DEPTNO ORDER BY SAL DESC) AS PERCENT SAL,
	NTILE(4) OVER (ORDER BY SAL DESC) AS N_TILE
FROM EMP;
```



## 테이블 파티션

<h3>Partition 기능</h3>

- 파티션은 대용량의 테이블을 여러 개의 데이터 파일에 분리해서 저장한다.
- 테이블의 데이터가 물리적으로 분리된 데이터 파일에 저장되면 입력, 수정, 삭제, 조회 성능이 향상된다.
- 파티션은 각각의 파티션 별로 독립적으로 관리될 수 있다. 즉, 파티션 별로 백업하고 복구가 가능하면 파티션 전용 인덱스 생성도 가능하다.
- 데이터를 조회할 때 데이터의 범위를 줄여서 성능을 향상시킨다.



<h3> Range Partition</h3>

- Range Partition은 테이블의 칼럼 중에서 값의 범위를 기준으로 여러 개의 파티션으로 데이터를 나누어 저장하는 것이다.



<h3> List Partition</h3>

- List Partition은 특정 값을 기준으로 분할하는 방법이다.



<h3> Hash Partition</h3>

- Hash Partition은 데이터베이스 관리 시스템이 내부적으로 해시 함수를 사용해서 데이터를 분할한다.
- 결과적으로 DBMS에서 알아서 분할 및 관리하는 것이다.
- Hash Partition 이외에도 Composite Partition이 있는데, Composite Partition은 여러 개의 파티션 기법을 조합해서 사용하는 것이다.



<h3> 파티션 인덱스</h3>

- 파티션 인덱스는 4가지 유형의 인덱스를 제공한다.
- 즉, 파티션 키를 사용해서 인덱스를 만드는 Prefixed Index와 해당 파티션만 사용하는 Local Index 등으로 나누어 진다.



<strong>파티션 인덱스</strong>

- Global Index: 여러 개의 파티션에서 하나의 인덱스를 사용한다.
- Local Index: 해당 파티션 별로 각자의 인덱스를 사용한다.
- Prefixed Index: 파티션 키와 인덱스 키가 동일하다.
- Non Prefixed Index: 파티션 키와 인덱스 키가 다르다.