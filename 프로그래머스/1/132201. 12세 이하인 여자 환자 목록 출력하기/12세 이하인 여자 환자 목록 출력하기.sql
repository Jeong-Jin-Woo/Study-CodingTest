-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO,'NONE') AS TLNO from PATIENT where age <= 12 and gend_cd='W' order by AGE desc, PT_NAME asc;