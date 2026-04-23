# 일정 관리 API

일정을 생성하고 조회, 수정, 삭제할 수 있는 API 입니다.
Spring Boot와 JPA를 사용했고 작성일이랑 수정일은 JPA Auditing으로 자동으로 들어가게 했습니다.

## API 명세서

### 일정 생성
- POST /schedules
- request
```
{
    "title": "공부하기",
    "content": "Spring 공부하기",
    "author": "민병준",
    "password": "1234"
}
```
- response
```
{
    "id": 1,
    "title": "공부하기",
    "content": "Spring 공부하기",
    "author": "민병준",
    "createdAt": "2026-04-22T14:30:00",
    "modifiedAt": "2026-04-22T14:30:00"
}
```

### 전체 일정 조회
- GET /schedules
- 작성자명으로 조회하고 싶으면 GET /schedules?author=민병준 이렇게 하면 됩니다

```
[
    {
        "id": 2,
        "title": "운동하기",
        "content": "헬스장 가기",
        "author": "민병준",
        "createdAt": "2026-04-22T15:00:00",
        "modifiedAt": "2026-04-22T16:00:00"
    },
    {
        "id": 1,
        "title": "공부하기",
        "content": "Spring 공부하기",
        "author": "민병준",
        "createdAt": "2026-04-22T14:30:00",
        "modifiedAt": "2026-04-22T14:30:00"
    }
]
```
수정일 기준으로 내림차순 정렬됩니다

### 선택 일정 조회
- GET /schedules/{id}
- request: 없음
- response
```
{
    "id": 1,
    "title": "공부하기",
    "content": "Spring 공부하기",
    "author": "민병준",
    "createdAt": "2026-04-22T14:30:00",
    "modifiedAt": "2026-04-22T14:30:00"
}
```

### 일정 수정
- PUT /schedules/{id}
- 제목이랑 작성자명만 수정할 수 있습니다
- 비밀번호가 맞아야 수정됩니다
- request
```
{
    "title": "수정한 제목",
    "author": "수정한 작성자",
    "password": "1234"
}
```
- response
```

{
    "id": 1,
    "title": "수정한 제목",
    "content": "Spring 공부하기",
    "author": "수정한 작성자",
    "createdAt": "2026-04-22T14:30:00",
    "modifiedAt": "2026-04-22T17:00:00"
}
```

### 일정 삭제
- DELETE /schedules/{id}
- 비밀번호가 맞아야 삭제됩니다
- request
```
{
    "password": "1234"
}
```
- response: 없음 (200 OK만 반환)

비밀번호는 모든 응답에서 안 보이게 했습니다


<img width="460" height="277" alt="스크린샷 2026-04-23 10 21 01" src="https://github.com/user-attachments/assets/30d1831b-e9e8-4eaa-9a27-d8f849319eed" />

