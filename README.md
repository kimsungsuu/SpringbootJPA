# 📌 Spring boot & JPA

## 1. 프로젝트 설명
> Spring boot와 Jpa를 이용한 게시판 만들기

* * *
</br>

## 2. 주요 기능
> - CRUD
> - 등록 및 수정시 메시지 출력(alert)
> - 파일 업로드
> - 페이징
> - 검색

* * *

</br>

## 3. 기술 스택
> - Java 11
> - Spring boot 2.7.8
> - JPA 3.0
> - MySQL 8
> - thymeleaf 3.1

* * *

</br>

## 4. 문제 해결 경험
> - 문제 발견 ) 검색 후 페이징 기능에서 다른 페이지로 넘어갈 때 원치않는 게시글 리스트가 출력되었습니다. 
>   - 문제의 원인이 다른 페이지로 넘어갈 때 searchKeyword를 받지 못하는 것이라는걸 깨달았습니다.
>   - 따라서 페이징 요청 처리를 맡은 view url 로직에 param.searchKeyword를 추가하여 동적으로 처리하게끔 설정했습니다.
> </br> [코드 확인](https://github.com/ksungsu/SpringbootJPA/blob/464e20b01b8b3cf2f5cf4f01dadc75976f58a310/src/main/resources/templates/boardList.html#L22)

* * *

</br>

## 5. 기타 백엔드 개발
> - MVC 기반 게시판 구현
>   - persistence layer, service layer, representation layer 분리하여 구현
> - thymeleaf 사용
>   - th:each, th:if, th:text.. 등을 사용하여 view 로직 구현
> - SSR(Server Side Rendering) 방식
>   - 작업 결과를 최종 HTML을 생성하고 호출하여 검증





