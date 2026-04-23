# 일정 관리 API (Part 2)

일정과 유저를 관리할 수 있는 API 입니다
유저를 만들고 그 유저로 일정을 생성하는 방식입니다

## API 명세서

### 유저 API

#### 회원 생성
- POST /members
- request
```json
{
    "username": "민병준",
    "email": "test@test.com",
    "password": "1234"
}
```
- response
```json
{
    "id": 1,
    "username": "민병준",
    "email": "test@test.com",
    "createdAt": "2026-04-22T14:30:00",
    "updatedAt": "2026-04-22T14:30:00"
}
```

#### 회원 전체 조회
- GET /members
- request: 없음
- response
```json
[
    {
        "id": 1,
        "username": "민병준",
        "email": "test@test.com",
        "createdAt": "2026-04-22T14:30:00",
        "updatedAt": "2026-04-22T14:30:00"
    }
]
```

#### 회원 단건 조회
- GET /members/{id}
- request: 없음
- response
```json
{
    "id": 1,
    "username": "민병준",
    "email": "test@test.com",
    "createdAt": "2026-04-22T14:30:00",
    "updatedAt": "2026-04-22T14:30:00"
}
```

#### 회원 수정
- PUT /members/{id}
- request
```json
{
    "username": "수정한 이름",
    "email": "new@test.com",
    "password": "5678"
}
```
- response
```json
{
    "id": 1,
    "username": "수정한 이름",
    "email": "new@test.com",
    "createdAt": "2026-04-22T14:30:00",
    "updatedAt": "2026-04-22T17:00:00"
}
```

#### 회원 삭제
- DELETE /members/{id}
- request: 없음
- response: 없음 (200 OK만 반환)

#### 로그인
- POST /members/login
- request
```json
{
    "email": "test@test.com",
    "password": "1234"
}
```
- response: "로그인 성공"

#### 로그아웃
- POST /members/logout
- request: 없음
- response: "로그아웃 성공"

---
