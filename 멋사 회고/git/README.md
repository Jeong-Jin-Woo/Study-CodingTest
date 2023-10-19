# Git
## Repository Control(in gitBash)
 - git init -> .git 레포지토리를 생성
 - git config --global init.bashBranch main -> branch를 main으로 변경 (확인은 해당 명령어에서 main 제거)
   --> git config --global 변수명 -> git 변수명 확인. (변수명 뒤에 해당 변수명을 바꿀 이름을 적을수 있음)
 - git config --global user.email -> Github email 확인
 - git config --global user.name -> Github 이름 확인

 - git remote -v -> 현재 연결 되어있는 저장소 보기
 - git remote origin add "URL주소" ->Github 저장소에 올리거나 로컬 레포지토리에 받을 URL주소를 적고 원격 레포지토리에 연결
 - git pull origin main -> 로컬 > 원격 레포지토리로 파일이나 폴더 저장

 - git add . -> .은 전체(숨김파일 및 폴더 포함)를 의미, 현재 add된 로컬 저장되어있는 파일 및 폴더(빈폴더 제외)를 원격 레포지토리에 commit하기 전 단계(올릴 것 정하는 단계)
 - git status -> 현재 add 된 파일 목록 표시 (저장소의 가장 최근 커밋상태와 작업폴더 사이의 동기화 상태)
 - git reset -> add 된 파일 및 폴더를 한번에 뺄 수 있다.

 - git log -> 커밋 코드, 커밋한 시간 커밋한 사용자 그리고 커밋메시지 를 알 수 있다.
 - git checkout "커밋 코드" -> 해당 커밋 코드의 작업 상태로 되돌아갈 수 있다.

 - git commit -m "커밋 할 메시지" -> 로컬 저장공간과 로컬레포지토리에 저장되어있는 파일이나 폴더를 동기화
 - git push origin main -> main은 branch, commit된 폴더 및 파일을 원격 레포지토리에 저장

 - git clone "URL주소" . -> .은 전체를 의미, ##### git init - git remote origin add "URL주소" - git pull origin main 을 한번에 수행.

 - push 수행 순서 : git clone "URL" . -> git add . -> git commit -m "Commit Message" -> git push origin main
 - pull 수행 순서 : git clone "URL" . OR git init -> git remote origin add "URL주소" -> git pull origin main 
<hr>

 - cd ~ -> 홈 디렉토리로 이동
 - cd .. -> 부모 디렉토리로 이동
 - cd 폴더명 -> 해당 디렉토리로 이동
<hr>

 - rm -rf .git -> .git 레포지토리 삭제 (rm .git --> 불가능, 숨김 폴더이기 때문)
 - rm -rf * -> 숨김 파일 및 폴더 빼고 전부(폴더, 파일) 삭제
<hr>

 - touch 파일명 -> touch 명령어 후에 자신이 만들고싶은 파일 이름 및 확장자를 만들 수 있음
<hr>

 - ls -> 숨김파일제외 폴더, 파일 검색
 - ls -a -> 숨김폴더 및 파일 포함 검색
 - ls -al -> 숨김폴더 및 파일 포함 모두 list형식으로 검색
 - ls -alh -> 숨김 폴더 및 파일 total 사이즈를 사람이 해석할 수 있게 표시, 모두 list형식으로 검색
