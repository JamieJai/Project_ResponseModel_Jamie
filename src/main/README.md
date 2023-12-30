# 응답 에러 모델 구현

## 개요
이 문서는 응답 에러 처리를 위한 모델 구현에 대한 가이드를 제공합니다. 본 구현은 Spring Boot와 Java를 사용하여 REST API에서 발생하는 다양한 에러 상황을 효과적으로 관리하고 클라이언트에 명확한 정보를 제공하도록 설계되었습니다.

## 구성 요소

### CustomException
- **패키지**: `responseerror.demo.exception`
- **설명**: 사용자 정의 예외 클래스로, `RuntimeException`을 상속받습니다. 이 클래스는 에러 코드(`ErrorCode`), 에러 메시지, 그리고 추가 데이터를 포함합니다.

### ErrorCode
- **패키지**: `responseerror.demo.exception`
- **설명**: 에러 코드와 관련 HTTP 상태, 사용자에게 보여줄 메시지를 정의하는 Enum 입니다. 예를 들어, `BAD_REQUEST`는 4000 코드, `HttpStatus.BAD_REQUEST` 상태와 "BAD REQUEST" 메시지를 가집니다.

### ApiResponse
- **패키지**: `responseerror`
- **설명**: API 응답을 위한 표준 모델입니다. 상태 코드, 메시지, 결과 데이터 등을 포함합니다. `Status`, `Metadata`, 그리고 결과 데이터를 포함하는 구조로 되어 있습니다.

### BaseController
- **패키지**: `responseerror.demo.api`
- **설명**: 모든 컨트롤러가 상속받아야 하는 기본 컨트롤러입니다. 공통 응답 생성 메소드와 예외 처리 핸들러를 제공합니다.

### StudentApiController
- **패키지**: `responseerror.demo.api`
- **설명**: 학생 데이터 관련 API를 제공하는 컨트롤러입니다. `BaseController`를 상속받아 공통 기능을 사용하며, 학생을 추가하고 조회하는 기능을 제공합니다.

## 사용 방법

### 예외 처리
1. `CustomException`을 사용하여 에러 상황을 정의합니다.
2. `BaseController`의 `@ExceptionHandler`를 통해 `CustomException`을 처리하도록 합니다.
3. 클라이언트에게는 `ApiResponse` 형태로 명확하고 일관된 에러 정보를 제공합니다.

### API 응답 생성
- `makeResponse` 메소드를 사용하여 결과 데이터를 `ApiResponse` 객체로 변환합니다. 이 메소드는 단일 결과 또는 결과 리스트를 처리할 수 있습니다.

## 결론
이 구현을 통해 REST API에서 발생하는 다양한 에러 상황을 효과적으로 관리하고, 사용자에게 명확하고 일관된 응답을 제공할 수 있습니다. 이는 API의 사용성과 유지보수성을 크게 향상시키는 요소입니다.
