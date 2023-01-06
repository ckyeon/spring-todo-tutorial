# Spring Todo Tutorial

> 소요 시간: 8시간 * 7일
> 

## 학습자료

### 강의

- ****[스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard)****
- [**부스트코스 웹 백엔드**](https://m.boostcourse.org/web326/lectures/28762)
- **[생활코딩 JAVA 입문 수업](https://opentutorials.org/course/3930)**
- **[모든 개발자를 위한 HTTP 웹 기본 지식](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC)** (유료)

### 책

- **[점프 투 자바](https://wikidocs.net/book/31)**
- **[점프 투 스프링부트](https://wikidocs.net/book/7601)**

### 게시글

- [**RESTful API 설계 가이드**](https://sanghaklee.tistory.com/57)
- **[HTTP 상태 코드](https://developer.mozilla.org/ko/docs/Web/HTTP/Status)**
- **[HTTP 메소드](https://developer.mozilla.org/ko/docs/Web/HTTP/Methods)**
- [**@Controller와 @RestController**](https://ch4njun.tistory.com/218)

## 과제

### 제공사항

- 프로젝트 세팅
- 기본 클래스 및 패키지 구조

### 사용할 스택

- Spring Boot, Spring Data JPA, Lombok, Validation
- H2 Database

### 준비사항

1. H2 Database를 설치한다.
2. Insomnia를 설치한다.
3. ~~에서 기본 프로젝트를 clone한다.

### 요구사항

- Todo와 User Entity를 구현한다.
    - Entity를 구현한 후 프로젝트(TodoApplication)를 실행하면, Database에 Entity와 매핑된 Table이 생성된다.

- 아래의 API를 구현한다.
    - todo
        
        
        | Method | URI | 설명 |
        | --- | --- | --- |
        | GET | /todos | 전체 todo를 가져온다. |
        | GET | /todos/{id} | id에 해당하는 todo를 가져온다. |
        | POST | /todos/{userId} | userId에 해당하는 user가 todo를 작성한다. |
        | PETCH | /todos/{id} | id에 해당하는 todo를 수정한다. |
        | DEL | /todos/{id} | id에 해당하는 todo를 삭제한다. |
        | GET | /todos/{userId} | user가 작성한 전체 todo를 가져온다. |
        - 반환 예제 (이해를 위한 예제이므로 자유롭게 구현)
            
            GET /todos
            
            ```json
            [
            	{
            		"title": "test",
            		"body": "test",
            		"user": {
            			"id": 3,
            			"email": "test1@test.com",
            			"name": "test",
            			"description": "test description"
            		}
            	},
            	{
            		"title": "test",
            		"body": "test",
            		"user": {
            			"id": 2,
            			"email": "test0@test.com",
            			"name": "test",
            			"description": null
            		}
            	},
            	{
            		"title": "test",
            		"body": "test",
            		"user": {
            			"id": 4,
            			"email": "test2@test.com",
            			"name": "test",
            			"description": null
            		}
            	},
            	{
            		"title": "test",
            		"body": "test",
            		"user": {
            			"id": 4,
            			"email": "test2@test.com",
            			"name": "test",
            			"description": null
            		}
            	}
            ]
            ```
            
            GET /todos/{id}
            
            ```json
            {
            	"title": "test",
            	"body": "test",
            	"user": {
            		"id": 3,
            		"email": "test1@test.com",
            		"name": "test",
            		"description": "test description"
            	}
            }
            ```
            
    
    - user
        
        
        | Method | URI | 설명 |
        | --- | --- | --- |
        | GET | /users | 전체 user를 가져온다. |
        | GET | /users/{id} | id에 해당하는 user를 가져온다. |
        | POST | /users/sign-up | 회원가입 |
        | PETCH | /users/{id} | id에 해당하는 user를 수정한다. |
        | DEL | /users/{id} | id에 해당하는 user를 삭제한다. |
        - 반환 예제 (이해를 위한 예제이므로 자유롭게 구현)
            
            GET /users
            
            ```json
            [
            	{
            		"id": 2,
            		"email": "test0@test.com",
            		"name": "test"
            	},
            	{
            		"id": 3,
            		"email": "test1@test.com",
            		"name": "test"
            	},
            	{
            		"id": 4,
            		"email": "test2@test.com",
            		"name": "test"
            	},
            	{
            		"id": 5,
            		"email": "test3@test.com",
            		"name": "test"
            	}
            ]
            ```
            
            GET /users/{id}
            
            ```json
            {
            	"id": 3,
            	"email": "test1@test.com",
            	"name": "test",
            	"description": "test description"
            }
            ```
            

- Controller와 Service 계층은 dto를 이용해 데이터를 전달한다.

- API 마다 `ResponseDto`와 `RequestDto`를 이용해 요청과 응답에 대한 dto를 분리한다.

- 각 `RequestDto`에서 `Validator`를 이용해 값을 검증한다.

- 각 API는 Controller에서 올바른 Http Status와 Body(Void 가능)를 가진 `ResponseEntity`를 반환한다.
