<h1>Spring Boot</h1>

yml 또는 properties 파일에서 설정을 바꿀 수 있다.

- server: <br>	port: 8088 - localhost 서버의 포트 번호를 바꿀 수 있다.

anotation을 사용하여 메소드에 메타 데이터를 결합시킨다.

anotation은 메소드위에 @를 사용하여 표시한다.

- lombok
  - Data
  - AllArgsConstructor
  - NoArgsConstructor
  
- RestController

- Mapping
  - GetMapping
  - PutMapping
  - PostMapping
  - DeleteMapping
  
- RestController

- Autowired

- RequestMapping

- ApiModel

  - ApiModel

  - ApiModelProperty

- Size

- Past

- Service

- ResponseStatus

- Filter

  - JsonFilter
  - JsonIgnore
  - JsonIgnoreProperties

- ControllerAdvice

- ExceptionHandler

- Bean



HATEOAS : Hypermedia As the Engine Of Application State

- 현재 리소스와 연관된(호출 가능한) 자원 상태 정보를 제공

groupId : org.springframeword.boot

artifctId : spring-boot-starter-hateoas 를 사용하여 의존성을 추가해주어 사용한다.



Swagger

- 개발자 도움말 페이지 생성

groupId : io.springfox

artifactId : springfox-swagger2, springfox-swagger-ui 를 사용하여 의존성을 추가해주어 사용한다.

public Docket name() 

​	return new Docket(DocumentationType.SWAGGER_2); 를 만들어 준다.

localhost:8088/v2/api-docs

localhost:8088/swagger-ui.html 로 브라우저에서 확인할 수 있다.

Contact, ApiInfo, Set을 이용하여 Docket().apiInfo.produces.consumes을 정의하여 커스터마이즈 할 수 있다.



Actuator

- 모니터링 기능

groupId : org.springframework.boot

artifactId : spring-boot-starter-actuator 를 사용하여 의존성을 추가해주어 사용한다.

localhost:8088/actuator 로 브라우저에서 사용할 수 있다.

yml 파일에 management: endpoints: web: exposure: include: "*" 를 사용하여 더 많은 정보를 확인할 수 있다.



spring-security

groupId : org.springframeword.boot

artifactId : spring-boot-starter-security 를 사용하여 의존성을 추가해주어 사용한다.

이후 실행하면 log에 password가 자동으로 생성된다.

인증을 하기 위해서는 postman에 Authorization에서 Basic Auth에 id는 user, password는 log에서 가져와 인증을 할 수 있다.

인증 id와 password를 지정해주기 위해서는 yml파일에 spring: security: user: name: (username) password: (password)를 사용하여 지정해줄 수 있다.

-> id와 password를 바꿔주려면 서버를 계속 재기동해야한다(좋은 방법이 아님)

따라서 WebSecurityConfigurerAdapter를 extends하는 클래스를 만들어 AuthenticationManagerBuilder에 id, password, role 을 지정해주어 사용한다.