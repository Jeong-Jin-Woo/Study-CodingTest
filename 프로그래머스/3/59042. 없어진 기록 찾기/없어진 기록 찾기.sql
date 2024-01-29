-- 코드를 입력하세요
select animal_outs.ANIMAL_ID, animal_outs.NAME
from animal_outs left outer join animal_ins 
on animal_outs.animal_id = animal_ins.animal_id
where animal_ins.animal_id is null
order by animal_outs.ANIMAL_ID;