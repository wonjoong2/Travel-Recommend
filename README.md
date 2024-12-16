## 1.개요
***
* 프로젝트 명 : 떠나자 국내여행!
* 구성 : 1인 개발
* 일정 : 2024.11.25 ~ 2023.12.11 (2주) 
* 개발 언어 : `Java`
* 개발 환경 : `Apache Tomcat`, `AWS`, `Windows 10`, `DBeaver`, `Git/Github`, `JPA`, `Mybatis`
* API: `빠른 로그인(Google)`, `이메일 인증`, `다음 우편번호 서비스`
* 데이터베이스 : `MariaDB`
* 형상관리 : `Github`
+ 간단소개
  + 혼자서도 충분히 국내 여행을 즐길 수 있다! 본인이 관심있는 여행지역과 장소를 관리하고 사람들과 소통할 수 있는 웹서비스를 기획했습니다.

## 2.주요 기능
***
### 1. 로그인 기능
* 일반 로그인 및 빠른 로그인(Google) 구현
* 세션에 로그인 정보 없는 경우 로그인 화면으로 이동
+ 회원가입
  + 회원가입시 필수 입력사항 Validation Check
+ 아이디 찾기
  + 이메일 인증 기능을 통해 회원 아이디 조회
+ 비밀번호 찾기
  + 회원 아이디, 이메일을 이용해 회원 비밀번호 재설정
### 2-1. 마이페이지(개인정보)
* 회원정보 조회
* 회원 정보 변경 가능(비밀번호, 전화번호, 주소, 이메일)
### 2-2. 마이페이지(여행정보)
* 저장한 여행지 목록 조회
* 구글맵으로 내가 저장한 여행지 한눈에 조회 가능
### 3.커뮤니티 페이지
* 게시글 작성,수정,삭제
* 제목 별 검색 기능
* 댓글 기능

## 3.DB 설계
***

## 4.API 설계
***
### 회원 관련 API
| 기능 | Method | Url | Return |
| --- | --- | --- | --- |
| 행1 열1 | 행1 열2 | 행1 열3 |
| 행2 열1 | 행2 열2 | 행2 열3 |
| 행3 열1 | 행3 열2 | 행3 열3 |

### 마이페이지 관련 API
| 기능 | Method | Url | Return |
| --- | --- | --- | --- |
| 행1 열1 | 행1 열2 | 행1 열3 |
| 행2 열1 | 행2 열2 | 행2 열3 |
| 행3 열1 | 행3 열2 | 행3 열3 |
