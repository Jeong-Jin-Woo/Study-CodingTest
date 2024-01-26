
select count(cnt)
from(
select count(*) cnt
from animal_ins
where name is not null
group by name
)cnt