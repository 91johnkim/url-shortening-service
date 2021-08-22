#URL Shortening Service


### 개발 스펙
* Java 1.8
* SpringBoot 2.5.4
* Jpa
* H2 (in-memory) , 서비스 재시작시 초기화
* Thymeleaf
* JUnit 4.13.1
* Gradle

### 서비스 설명

1) Web (localhost:8080)
   1) Url을 입력받아 Shortening된 Url 리턴.
   2) Shortening된 Url을 입력하면 기존 Url로 이동.
   
2) API (localhost:8080/api/v1/url-shortener)
   1) 사용자에게 입력받은 Url 리스트 출력 (url ,변환횟수, ssl여부)
   2) 사용자에게 입력받은 Url, Shortening된 Url로 변환 후 리턴
      1) 기존 입력 받은 url 이라면 변환 횟수를 업데이트 하고 신규 url 이면 저장한다
      2) url의 신규 여부는  http:// https://를 기준으로 한다
      

### 빌드 및 실행

해당 서비스를 빌드, 실행하기 위해서 아래 내역을 우선 확인하시기 바랍니다.

1) JDK
   1) 설치여부 확인 : 
   2) 설치 방법 : 
2) Gradle
   1) 설치여부 확인 :
   2) 설치 방법 :
3) Git
   1) 설치여부 확인 :
   2) 설치 방법 :

   

빌드 및 실행방법

첫번째. git clone 명령으로 해당 프로젝트 파일을 받아온다.


두번째. Gradle로 해당 프로젝트를 빌드한다.


세번째. Java 명령으로 빌드파일을 실행시킨다.


