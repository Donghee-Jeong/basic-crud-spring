# 유저 CRUD 프로젝트
간단한 유저 등록, 조회, 수정, 삭제 기능을 구현해보자.
## 기술스택
- Java 11
- Spring Boot 2.7.15
- Thymeleaf
## TDD
- MemoryUserRepositoryTest
    - save(User) : User
    - findById(Integer:id) : User
    - update(User) : User
    - delete(User) : void
## API
- GET /users : 유저 리스트
- GET /users/new : 새로운 유저 등록