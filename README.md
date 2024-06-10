# Naver-Webtoon<img src="https://github.com/joohee56/Naver-Webtoon/assets/83942393/1e8027e1-2b5e-4673-9577-4bcb98c89622" width="60px">
네이버 웹툰</br>
</br>

## 소개
* **제작 목적** : 실제 서비스 되고 있는 서비스를 제작해봄으로써 실사용자가 필요로 하는 기능을 인지하고, 학습한 기술을 적용해보자.
* **역할** : 개인 프로젝트
* **제작 기간** : `2024.02.19 ~ 2024.05.29`
</br>

## 사용자 주요 유스케이스 2가지
### 1. 일반 유저의 웹툰 관람
![image](https://github.com/joohee56/Naver-Webtoon/assets/83942393/8bcb518e-7e38-4ec9-889a-992a53403381)
</br>

### 2. 작가의 웹툰 등록
![image](https://github.com/joohee56/Naver-Webtoon/assets/83942393/f1ad6e8c-fa62-46d8-b139-1fb9d3e97670)
</br>

## 기능
⚠️프로젝트에 사용된 웹툰들은 학습용도로 일부만을 캡쳐하여 사용하였습니다. </br>
</br>

|로그인|회원가입|
|:----:|:----:|
|![로그인](https://github.com/joohee56/Naver-Webtoon/assets/83942393/0a4757d4-8ea2-4012-a6dc-21b5ba7bf1e0)|![회원가입](https://github.com/joohee56/Naver-Webtoon/assets/83942393/80a3aa77-103a-4466-be24-e16762c86f81)|
</br>
</br>

|웹툰 랭킹|
|:----:|
|![웹툰 랭킹](https://github.com/joohee56/Naver-Webtoon/assets/83942393/f3ce4394-0170-40e8-861d-6f05ea3c51b0)|
- 정해진 시간에 별도의 새로고침 없이 자동으로 업데이트됩니다.
- 순위 측정은 가장 최근에 등록된 총 10개의 회차에 받은 '좋아요' 수를 누적한 값을 통해 매겨집니다. 
</br>
</br>

|웹툰 랭킹 표시|
|:----:|
|![웹툰 랭킹 표시](https://github.com/joohee56/Naver-Webtoon/assets/83942393/a18c9cb5-1919-4932-b269-2b4036780819)|
- 랭킹이 변동될 경우, 상승/하강한 작품에는 각각 빨간색/파란색 삼각형으로 상승, 하강이 표시됩니다.
</br>
</br>

|장르별 웹툰|
|:----:|
|![장르별 웹툰](https://github.com/joohee56/Naver-Webtoon/assets/83942393/fdc0e595-6449-4c9e-87d9-55a6f806cc72)|
- 홈화면에서 원하는 장르의 웹툰을 고를 수 있습니다. 
- `[사용자 스토리] 로맨스 웹툰을 좋아하고, 스릴러 웹툰을 무서워하는 독자로서, 로맨스 관련 웹툰만 필터링하고 싶다.`
</br>
</br>

|신규 작품 등록|
|:----:|
|![신규 작품 등록](https://github.com/joohee56/Naver-Webtoon/assets/83942393/3356b047-a35e-4150-bff6-c841cb5f9a18)|
- 입력 양식의 값을 채운 후 등록 버튼을 클릭합니다.
- 등록된 웹툰은 도전만화에 노출됩니다.
</br>
</br>

|신규 회차 등록 (1)|
|:----:|
|![신규 회차 등록 -1 ](https://github.com/joohee56/Naver-Webtoon/assets/83942393/f9fbf9eb-e13e-4906-8cb8-681a8a41b04a)|
- 등록할 작품을 선택하면, 회차 번호는 자동으로 입력됩니다.
- 회차명, 대표 이미지, 원고로 사용될 이미지들을 선택하여 업로드합니다.
</br>
</br>

|신규 회차 등록 (2)|
|:----:|
|![신규 회차 등록 2 - 보완](https://github.com/joohee56/Naver-Webtoon/assets/83942393/e30475df-0e20-4ce0-a847-048c32a0b63f)|
- 미리보기를 통해 업로드한 이미지들을 확인할 수 있습니다.
- 맨 위, 위, 아래, 맨 아래 이동 버튼을 통해 이미지의 순서를 변경할 수 있습니다.
- 전체 미리보기 버튼을 통해 하나로 이어진 원고를 확인할 수 있습니다.
- 확인 버튼을 통해 최종적으로 회차를 업로드합니다. 
</br>
</br>

|페이징|
|:----:|
|![페이징](https://github.com/joohee56/Naver-Webtoon/assets/83942393/6b0ceb70-2607-47fc-9103-c80865435bb5)|
</br>
</br>

|메뉴바 트랜지션|
|:----:|
|![메뉴바 트랜지션](https://github.com/joohee56/Naver-Webtoon/assets/83942393/fe07cd45-0fe7-4d54-ab4e-c45dc0abe009)|
- 사용자의 스크롤이 원고 내부에 위치하면 메뉴바가 사라집니다.
- 화면을 클릭 시 메뉴바가 나타나거나, 사라집니다.
- 사용자의 스크롤이 원고 끝에 도달하면 다시 메뉴바가 나타납니다.
</br>
</br>

|댓글 등록|
|:----:|
|![댓글 등록](https://github.com/joohee56/Naver-Webtoon/assets/83942393/835b32b4-92a5-4fd9-bd23-f5dfa4d9aa76)|
- 로그인 후 댓글을 등록할 수 있습니다.
- 가장 많은 '좋아요'와 적은 '싫어요'를 받은 상위 4개의 댓글은 BEST 댓글로 등록됩니다.
</br>
</br>

|댓글 삭제|
|:----:|
|![댓글 삭제](https://github.com/joohee56/Naver-Webtoon/assets/83942393/2a93571c-d7d5-43d8-9036-e6344d30918e)|
- 본인이 작성한 댓글의 한해서 메뉴 버튼이 활성화됩니다.
</br>
</br>




