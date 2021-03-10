<h1>SQL기본</h1>

## 관계형 데이터베이스

관계형 데이터베이스는 1970년대 E.F.Codd박사의 논문에서 처음 소개 되었다.

관계형 데이터베이스는 릴레이션과 릴레이션의 조인 연산을 통해 합집합, 교집합, 차집합 등을 만들 수 있다.

데이터베이스는 계층형, 네트워크형, 관계형 데이터베이스 등이 있다.

계층형 데이터베이스는 트리 형태의 구조로 데이터를 저장, 관리한다.

- 1:N 관계를 표현한다.

네트워크형 데이터베이스는 오너와 멤버의 형태로 데이터를 저장, 관리한다.

- 1:N, M:N 관계를 표현한다.

관계형 데이터베이스는 릴레이션으로 데이터를 저장, 관리한다.

릴레이션을 사용하여 집합 연산과 관계 연산을 할 수 있다.

- 집합 연산
  - 합집합: 두 개의 릴레이션을 하나로 합하는 것, 중복된 튜플은 한 번만 조회
  - 차집합: 본래 릴레이션에는 존재하고 다른 릴레이션에는 존재하지 않는 것을 조회
  - 교집합: 두 개의 릴레이션 간의 공통된 것을 조회
  - 곱집합: 각 릴레이션에 존재하는 모든 데이터를 조합하여 연산
- 관계 연산
  - 선택 연산: 릴레이션에서 조건에 맞는 튜플을 조회한다.
  - 투영 연산: 릴레이션에서 조건에 맞는 속성만을 조회한다.
  - 결합 연산: 여러 릴레이션의 공통된 속성을 사용해서 새로운 릴레이션을 만들어 낸다.
  - 나누기 연산: 기준 릴레이션에서 나누는 릴레이션이 가지고 있는 속성과 동일한 값을 가지는 튜플을 추출하고 나누는 릴레이션의 속성을 삭제한 후 중복된 행을 제거하는 연산

위와 같은 종류의 데이터베이스를 관리하는 시스템을 데이터베이스 관리 시스템이라고 하며, DBMS라고도 한다.



<strong>테이블의 구조</strong>

- 기본키: 하나의 테이블에서 유일성, 최소성, Not Null을 만족하면서 해당 테이블을 대표하는 것
- 테이블은 행(튜플)과 칼럼(애트리뷰트)으로 구성된다.
- 외래키: 다른 테이블의 기본키를 참조하는 칼럼이다.
  - 외래키는 조인을 위해 사용한다.



<h3>SQL</h3>

SQL(Structured Query Language)은 데이터베이스에서 데이터의 구조를 정의,  데이터 조작, 데이터 제어를 하는 절차형 언어이다.



<strong>SQL의 종류</strong>

- DDL(Data Definition Language): 관계형 데이터베이스의 구조를 정의하는 언어이다.
  - CREATE, ALTER, DROP, RENAME문이 있다.
- DML(Data Manipulation Language): 테이블에서 데이터를 입력, 수정, 삭제, 조회하는 언어이다.
  - INSERT, UPDATE, DELETE, SELECT문이 있다.
- DCL(Data Control Language): 데이터베이스 사용자에게 권한을 부여하거나 회수한다.
  - GRANT, REVOKE, TRUMCATE문이 있다.
- TCL(Transaction Control Language): 트랜잭션을 제어하는 명령어이다.
  - COMMIT, ROLLBACK, SAVEPOINT문이 있다.



<strong>트랜잭션의 특성</strong>

- 원자성(Atomicity): 트랜잭션은 데이터베이스 연산의 전부가 실행되거나 전혀 실행되지 않아야 한다(ALL OR NOTHING)
- 일관성(Consistency): 트랜잭션 실행 결과로 데이터베이스의 상태가 모순되지 않아야 한다.
- 고립성(Isolation): 트랜잭션 실행 중에 생성하는 연산의 중간결과는 다른 트랜잭션이 접근할 수 없다.
- 영속성(Durability): 트랜잭션이 그 실행을 성공적으로 완료하면 그 결과는 영구적으로 보장되어야 한다.



<strong>SQL문의 실행 순서</strong>

- 파싱(Parsing): SQL문의 문법을 확인하고 구문분석한다.
- 실행(Execution): 옵티마이저(Optimizer)가 수립한 실행 계획에 따라 SQL을 실행한다.
- 인출(Fetch): 데이터를 읽어서 전송한다.

파싱 -> 실행 -> 인출의 순서로 실행된다.



## DDL

데이터베이스를 사용하기 위해서 먼저 테이블을 생성해야 한다.

- Create Table: 테이블을 생성한다.
  - 테이블을 생성할 때 기본키, 외래키, 제약사항 등을 설정할 수 있다.
- Alter Table: 테이블을 변경한다.
  - 칼럼의 추가 또는 삭제, 기본키 설정, 외래키 설정을 할 수 있다.
- Drop Table: 테이블을 삭제한다.
  - 테이블의 구조와 데이터 모두 삭제한다.



<strong>테이블 생성</strong>

```sql
Create Table EMP(
	empno number(10) primary key,
	ename varchar2(20) not null,
	sal number(6) default 0,
	createdate date default sysdate
);
```



- 테이블 이름은 Create Table (이름)을 사용한다.

- empno, ename, sal은 칼럼의 이름을 의미한다.

- number, varchar2은 칼럼의 데이터 타입을 의미한다.

- number(10), varchar2(20)과 같이 ()안의 값은 최대 길이를 설정하는 것을 의미한다.

- not null을 사용하여 null 데이터가 들어갈 수 없도록 설정할 수 있다.

- default를 사용하여 기본 값을 설정할 수 있다.

- constraint 이름 primary key(칼럼 이름)으로도 기본값을 설정할 수 있다.

- constraint 이름 foreign key(칼럼 이름) references 테이블이름(칼럼 이름)으로 외래키를 지정할 수 있다.

- 외래키와 기본키의 참조 관계에 있을 경우 On Delete CASCADE를 사용하여  기본키가 삭제되었을 경우 외래키도 함께 삭제하여 참조 무결성을 준수할 수 있다.



<strong>테이블 변경</strong>

기본적으로 ALTER TABLE 테이블 이름을 사용하여 특정 테이블의 이름, 칼럼 등을 수정할 수 있다.

- RENAME To 새 테이블 이름으로 테이블의 이름을 바꿀 수 있다.
- ADD (age number(2) default 1)과 같이 칼럼을 추가할 수 있다.
- MODIFY (age varchar(20) not null)과 같이 칼럼의 정보를 수정할 수 있다.
- DROP COLUMN 칼럼이름으로 칼럼을 삭제할 수 있다.
- RENAME COLUMN 칼럼이름 TO 새 칼럼이름으로 칼럼의 이름을 변경할 수 있다.



<strong>테이블 삭제</strong>

- DROP TABLE 테이블 이름으로 테이블을 삭제할 수 있다.
- DROP TABLE 테이블 이름 CASCADE CONSTRAINT 테이블의 데이터를 참조하는 외래키를 모두 같이 삭제할 수 있다.



<strong>뷰 생성 및 삭제</strong>

뷰란 테이블로부터 유도해낸 가상의 테이블이다.

실제로 데이터를 가지고 있지 않고 테이블을 참조해서 원하는 칼럼만 모아놓은 것이다.

뷰는 데이터 딕셔너리에 SQL문 형태로 저장하되 실행 시에 참조된다.

- <strong>뷰의 특징</strong>
  - 참조한 테이블이 변경되면 뷰도 변경된다.
  - 뷰의 검색은 참조한 테이블과 동일하게 할 수 있지만, 뷰에 대한 입력, 수정, 삭제에는 제약이 있다.
  - 특정 칼럼만 조회시켜서 보안성을 향상시킨다.
  - 한 번 생성된 뷰는 변경할 수 없고 변경을 원하면 삭제 후 재생성 해야한다.
  - ALTER문으로 뷰를 변경할 수 없다.



- CREATE VIEW 뷰 이름 AS SELECT * FROM 테이블 이름과 같이 CREATE VIEW로 생성하고 내부 데이터는 SELECT문으로 참조하여 지정한다.

- DROP VIEW 뷰 이름을 사용하여 뷰를 삭제할 수 있다.
- 뷰의 장점
  - 특정 칼럼만 조회할 수 있어 보안 기능이 있다.
  - 데이터의 관리가 간단하다.
  - SELECT문이 간단해진다.
  - 하나의 테이블에 여러 개의 뷰를 생성할 수 있다.
- 뷰의 단점
  - 뷰는 독자적인 인덱스를 만들 수 없다.
  - 삽입, 수정, 삭제 연산이 제약된다.
  - 데이터 구조를 변경할 수 없다.



## DML

<strong>INSERT문</strong>

- INSERT문은 테이블에 데이터를 입력하는 DML문이다.
- INSERT INTO table (column1, column2, ...) VALUES (exp1, exp2, ...);과 같이 사용할 수 있다.
- 테이블의 모든 칼럼에 데이터를 삽입하는 경우 column을 생략할 수 있다.
- INSERT문을 사용한다고 데이터 파일에 저장되지 않고 TCL문의 COMMIT을 실행해야 한다.
- AUTO COMMIT 설정을 하여 COMMIT을 생략할 수 있다.
- INSERT INTO table 이후 SELECT문을 사용하여 데이터를 삽입할 수 있다.
- NOLOGGING을 사용하여 로그 파일의 기록을 최소화하여 입력 성능을 향상시킨다.
  - Buffer Cache 메모리 영역을 생략하고 기록한다.



<strong>UPDATE문</strong>

- 입력된 데이터의 값을 수정하는 DML문이다.
- 원하는 조건으로 데이터를 검색해서 수정할 수 있다.
- 조건을 입력하지 않으면 모든 데이터가 수정되므로 유의해야 한다.
- 조건에 포함되는 모든 튜플이 영향을 받는다.
- UPDATE 테이블이름 SET 바꿀 데이터 WHERE 조건문으로 사용한다.



<strong>DELETE문</strong>

- 입력된 데이터의 값을 삭제하는 DML문이다.
- 원하는 조건을 검색해서 해당되는 행을 삭제한다.
- 조건문을 입력하지 않으면 모든 데이터가 삭제된다.
- 데이터를 삭제한다고 테이블의 용량이 초기화 되지는 않는다.
- DELETE FROM 테이블이름 WHERE 조건문으로 사용한다.
- TRUNCATE TABLE 테이블 이름을 사용하여 모든 데이터를 삭제하면서 테이블 용량이 초기화되게 할 수 있다.



<strong>SELECT문</strong>

- 입력된 데이터를 조회하기 위해 사용하는 DML문이다.
- 특정 칼럼이나 특정 행만을 조회할 수 있다.
- SELECT column1, column2와 같이 여러 칼럼을 조회할 수 있고, 모든 칼럼 조회는 * 기호를 사용한다.
- FROM 테이블이름을 사용하여 원하는 테이블을 지정한다.
- WHERE을 사용하여 조건문을 지정한다.
- ORDER BY를 사용하여 데이터를 오름차순(ASC), 내림차순(DESC)으로 정렬을 할 수 있다.
  - 정렬은 모든 실행이 끝난 후 데이터를 출력하기 전에 실행한다.
  - 데이터베이스 메모리를 많이 사용하기 때문에 대량의 데이터를 사용하면 성능 저하가 발생한다.
    - 메모리는 내부의 SORT_AREA_SIZE를 사용하고 이 값이 너무 작으면 성능 저하가 발생할 수 있다.
  - 특별히 지정하지 않으면 오름차순으로 정렬된다.

- 정렬은 데이터베이스에 부하를 주므로 인덱스를 사용하여 ORDER BY를 회피할 수 있다.
  - /*+INDEX_DESC(테이블이름) */과 같이 힌트를 사용하여 내림차순으로 읽게 한다.

- DISTINCT문을 사용하면 중복된 데이터를 한 번만 조회하게 한다.
- ALIAS는 칼럼명이 너무 길 때 별칭으로 사용한다.
  - SELECT NAME AS "이름"과 같이 사용한다.



<strong>WHERE문</strong>

- WHERE문에서는 비교 연산자, 부정 비교 연산자, 논리 연산자, SQL 연산자, 부정 SQL 연산자를 사용할 수 있다.
- 비교 연산자에는 =, <, <=, >, >= 연산자가 있다.
- 부정 비교 연산자에는 !=, ^=, <>, NOT 칼럼명 =, NOT 칼럼명 > 연산자가 있다.
  - NOT 칼럼명 > 연산자만 크지 않은 것을 조회하고 나머지는 같지 않은 것을 조회한다.
- 논리 연산자에는 AND, OR, NOT 연산자가 있다.
- SQL 연산자에는 LIKE, BETWEEN, IN, IS NULL 연산자가 있다.
- 부정 SQL연산자에는 NOT BETWEEN, NOT IN, IS NOT NULL 연산자가 있다.
  - LIKE문은 와일드 카드(%, _)를 사용하여 조회할 수 있다.
    - 와일드 카드(%)는 모든 것을 조회하는 기호로 '조%'라면 '조'로 시작하는 모든 문자를 조회한다.
    - 와일드 카드(_)는 한 개의 단일 문자를 의미한다.
  - BETWEEN문은 지정된 범위에 있는 값을 조회할 수 있다.
    - BETWEEN A AND B로 범위를 지정한다. (A <= X <= B)
    - NOT이 들어가면 전체에서 BETWEEN A AND B 뺀 결과와 같다. (X < A AND B < X)
  - IN문은 OR의 의미를 가지고 있어 하나의 조건만 만족해도 조회가 된다.
- NULL값은 모르는 값 혹은 값의 부재를 의미한다.
  - NULL과 숫자 혹은 날짜를 더하면 NULL이 된다.
  - NULL과 어떤 값을 비교할 때, '알 수 없음'이 반환된다.
  - NULL을 조회할 경우 IS NULL로, NULL이 아닌 것을 조회할 경우 IS NOT NULL을 사용한다.
  - NULL관련 함수
    - NVL: NULL이면 다른 값으로 바꾸는 함수 
      - NVL(칼럼, 0)과 같이 사용 - 칼럼이 NULL이면 0으로 바꿈
    - NVL2: NVL과 DECODE를 하나로 만든 함수 
      - NVL2(칼럼, 1, 0)와 같이 사용 - 칼럼이 NULL이 아니면 1, NULL이면 0을 반환
    - NULLIF: 두 개의 값이 같으면 NULL, 아니라면 첫 번째 값을 반환한다.
      - NULLIF(exp1, exp2)와 같이 사용
    - COALESCE: NULL이 아닌 최초의 인자 값을 반환한다.
      - COALESCE(exp1, exp2, exp3, ...)와 같이 사용



<strong>GROUP BY</strong>

```sql
GROUP BY 사용 예시
SELECT DEPTNO, SUM(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING SUM(SAL) > 10000
```

- GROUP BY는 테이블에서 소규모 행을 그룹화하여 합계, 평균, 최댓값, 최솟값 등을 계산할 수 있다.
  - 집계 함수의 종류
    - COUNT(): 행 수를 조회한다.
    - SUM(): 합계를 계산한다.
    - AVG(): 평균을 계산한다.
    - MAX(), MIN(): 최댓값과 최솟값을 계산한다.
    - STDDEV(): 표준편차를 계산한다.
    - VARIAN(): 분산을 계산한다.

- HAVING구에 조건문을 사용한다.
  - 집계 함수의 조건은 HAVING구에 넣고 칼럼에 대한 조건은 WHERE에 넣어야 한다.

- ORDER BY를 사용해서 정렬할 수 있다.



<strong>SELECT문 실행 순서</strong>

- SQL의 실행 순서는 조회된 데이터를 이해하는데 중요하다.
- FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY순으로 실행된다.



<strong>명시적, 암시적 형변환</strong>

- 형 변환이란 두 개의 데이터의 데이터 타입이 일치하도록 변환하는 것
- 명시적 형변환은 개발자가 형변환 함수를 사용해 데이터 타입을 일치시키는 것
  - 형변환 함수
    - TO_NUMBER(문자열): 문자열을 숫자로 변환한다.
    - TO_CHAR(숫자 혹은 날짜, [FORMAT]): 숫자 혹은 날짜를 지정된 FORMAT의 문자로 변환한다.
    - TO_DATE(문자열, FORMAT): 문자열을 지정된 FORMAT의 날짜형으로 변환한다.
- 암시적 형변환은 개발자가 형변환을 하지 않은 경우 DBMS에서 자동으로 형변환하는 것을 의미한다.



<strong>내장형 함수</strong>

- 모든 데이터베이스는 SQL에서 사용할 수 있는 내장형 함수를 가지고 있다.

- DBMS별로 차이가 있지만 거의 비슷한 방법으로 사용이 가능하다.

- 위에서 배운 형변환 함수, 문자열 및 숫자형 함수, 날짜형 함수가 있다.
- oracle 데이터베이스에는 더미 테이블인 DUAL 테이블이 있다.
  - 문자열 함수
    - ASCII(문자): 문자 혹은 숫자를 ASCII 코드값으로 변환한다.
    - CHAR(ASCII 코드값): ASCII 코드값을 문자로 변환한다.
    - SUBSTR(문자열, m, n): 문자열에서 m번재 위치부터 n개를 자른다.
    - CONCAT(문자열1, 문자열2): 문자열 1번과 2번을 결합한다.
    - LOWER(문자열): 영문자를 소문자로 변환한다.
    - UPPER(문자열): 영문자를 대문자로 변환한다.
    - LENGTH 혹은 LEN(문자열): 공백을 포함해서 문자열의 길이를 알려준다.
    - LTRIM(문자열, 지정문자): 왼쪽에서 지정된 문자를 삭제한다.
      - 지정된 문자를 생략하면 공백을 삭제한다.
    - RTRIM(문자열, 지정문자): 오른쪽에서 지정된 문자를 삭제한다.
      - 지정된 문자를 생략하면 공백을 삭제한다.
    - TRIM(문자열, 지정문자): 왼쪽, 오른쪽에서 지정된 문자를 삭제한다.
      - 지정된 문자를 생략하면 공백을 삭제한다.
  - 숫자형 함수
    - ABS(숫자): 절대값을 반환한다.
    - SIGN(숫자): 양수, 음수, 0을 구별한다.
    - MOD(숫자1, 숫자2): 숫자1을 숫자2로 나누어 나머지를 계산한다.
      - %로도 사용할 수 있다.
    - CEIL/CEILING(숫자): 숫자보다 크거나 같은 최소의 정수를 반환한다.(올림)
    - FLOOR(숫자): 숫자보다 작거나 같은 최대의 정수를 반환한다.(버림)
    - ROUND(숫자, m): 소수점 m에서 반올림한다.
      - m의 기본값은 0이다.
    - TRUNC(숫자, m): 소수점 m 자리에서 절삭한다.
      - m의 기본값은 0이다.
- SYSDATE는 오늘 날짜를 구하는 함수이다.
- 연도, 월, 일만 알고싶다면 EXTRACT 함수를 사용한다.
  - EXTRACT('YEAR' | 'MONTH', 'DAY' from dual)과 같이 사용한다.



<strong>DECODE와 CASE문</strong>

DECODE문으로 IF문을 구현할 수 있다.

```sql
DECODE(EMPNO, 1000, 'TRUE', 'FALSE')
```

EMPNO과 1000이 같으면 TRUE로 가고 아닌 경우 FALSE로 간다.



CASE문은 여러 개의 조건을 설정할 수 있다.

```sql
CASE 
	WHEN EMPNO = 1000 THEN 'A'
	WHEN EMPNO = 1001 THEN 'B'
	ELSE 'C'
END
```



<strong>ROWNUM과 ROWID</strong>

ROWNUM은 ORACLE 데이터베이스의 SELECT문 결과에 대해서 논리적인 일련번호를 부여한다.

주로 조회되는 행 수를 제한할 때 사용된다.

ROWNUM을 사용하여 페이지 단위 출력을 하기 위해서는 인라인 뷰를 사용해야 한다.

ORACLE은 ROWNUM을 사용하고 SQL Server는 TOP문을, MySQL은 LIMIT구를 사용한다.



ROWID는 ORACLE 데이터베이스 내에서 데이터를 구분할 수 있는 유일한 값이다.

SELECT문으로 확인이 가능하다.

ROWID를 통해 데이터가 어떤 데이터 파일, 어느 블록에 저장되어 있는 지 알 수 있다.

ROWID구조

| 구조           | 길이  | 설명                                                         |
| -------------- | ----- | ------------------------------------------------------------ |
| 오브젝트 번호  | 1~6   | 오브젝트별로 유일한 값을 가지고 있으며, 해당 오브젝트가 속해 있는 값이다. |
| 상대 파일 번호 | 7~9   | 테이블스페이스에 속해 있는 데이터 파일에 대한 상대 파일번호이다. |
| 블록 번호      | 10~15 | 데이터 파일 내부에서 어느 블록에 데이터가 있는지 알려준다.   |
| 데이터 번호    | 16~18 | 데이터 블록에 데이터가 저장되어 있는 순서를 의미한다.        |



<strong>WITH구문</strong>

WITH구문은 서브쿼리를 사용해서 임시 테이블이나 뷰처럼 활용할 수 있는 구문이다.

```sql
WITH viewData AS
	(SELECT * FROM EMP
	UNION ALL
	SELECT * FROM EMP
	)
	SELECT * FROM viewData WHERE EMPNO=1000;
```



## DCL

<strong>GRANT</strong>

GRANT문은 데이터베이스 사용자에게 사용자 권한을 부여한다.

데이터베이스 사용에는 권한이 필요하며 연결, 입력, 수정, 삭제, 조회를 할 수 있다.

```sql
GRANT privileges(권한) ON 테이블이름 TO user;
```

privileges(권한)

- SELECT: 지정된 테이블에 대해서 SELECT 권한을 부여한다.
- INSERT: 지정된 테이블에 대해서 INSERT 권한을 부여한다.
- UPDATE: 지정된 테이블에 대해서 UPDATE 권한을 부여한다.
- DELETE: 지정된 테이블에 대해서 DELETE 권한을 부여한다.
- REFERENCES: 지정된 테이블을 참조하는 제약조건을 생성하는 권한을 부여한다.
- ALTER: 지정된 테이블에 대해서 수정할 수 있는 권한을 부여한다.
- INDEX: 지정된 테이블에 대해서 인덱스를 생성할 수 있는 권한을 부여한다.
- ALL: 테이블에 대한 모든 권한을 부여한다.



```sql
GRANT ALL ON EMP WITH GRANT OPTION
```

WITH GRANT OPTION

- WITH GRANT OPTION: 특정 사용자에게 권한을 부여할 수 있는 권한을 부여한다.
- WITH ADMIN OPTION: 테이블에 대한 모든 권한을 부여한다.



```sql
REVOKE privileges ON 테이블이름 FROM user;
```

REVOKE문은 데이터베이스 사용자에게 부여된 권한을 회수한다.



## TCL

<strong>COMMIT</strong>

- COMMIT은 INSERT, UPDATE, DELETE문으로 변경한 데이터를 데이터베이스에 반영한다.

- 변경 전 이전 데이터는 잃어버린다.
- 다른 모든 데이터베이스 사용자는 변경된 데이터를 볼 수 있다.
- COMMIT이 완료되면 데이터베이스 변경으로 인한 LOCK이 해제 된다.
- COMMIT을 실행하면 하나의 트랜잭션 과정을 종료한다.
- ORACLE 데이터베이스는 암시적 트랜잭션 관리를 한다.
- AUTO COMMIT으로 DDL 및 DCL을 사용하는 경우, 프로그램을 정상 종료하는 경우 자동 COMMIT된다.



<strong>ROLLBACK</strong>

- ROLLBACK을 실행하면 데이터에 대한 변경 사용을 모두 취소하고 트랜잭션을 종료한다.
- INSERT, UPDATE, DELETE문의 작업을 모두 취소한다. 단, 이전 COMMIT한 곳 까지만 복구한다.
- ROLLBACK을 실행하면 LOCK이 해제되고 다른 사용자도 베이터베이스 행을 조작할 수 있다.



<strong>SAVEPOINT</strong>

```sql
SAVEPOINT save1
```



- SAVEPOINT는 트랜잭션을 작게 분할하여 관리하는 것으로 지정된 위치 이후의 트랜잭션만 ROLLBACK할 수 있다.
- 지정된 SAVEPOINT까지만 데이터 변경을 취소하고 싶은 경우 ROLLBACK TO SAVEPOINT이름을 실행한다.
- ROLLBACK을 실행하면 SAVEPOINT와 관계없이 데이터의 모든 변경사항을 저장하지 않는다.