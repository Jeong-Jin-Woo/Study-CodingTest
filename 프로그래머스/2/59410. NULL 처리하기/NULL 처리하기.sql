-- 코드를 입력하세요
# SELECT animal_type, NULLIF(name,"No name"), sex_upon_intake
# from animal_ins;

SELECT animal_type, IFNULL(NAME,"No name") name, sex_upon_intake
from animal_ins;