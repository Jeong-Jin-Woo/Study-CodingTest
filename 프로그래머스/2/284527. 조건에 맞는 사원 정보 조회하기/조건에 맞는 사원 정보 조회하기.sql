-- 코드를 작성해주세요
select sum(score) score, hr_grade.EMP_NO, emp_name, position, email
from hr_grade join hr_employees using(EMP_NO)
where year = 2022
group by emp_no, year
order by score desc
limit 1