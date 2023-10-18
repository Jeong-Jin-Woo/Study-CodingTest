# git Local Repository Control(in gitBash)
 - git init -> .git 레포지토리를 생성
 - git config --global init.bashBranch main -> branch를 main으로 변경 (확인은 해당 명령어에서 main 제거)
   --> git config --global 변수명 -> git 변수명 확인. (변수명 뒤에 해당 변수명을 바꿀 이름을 적을수 있음)
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
