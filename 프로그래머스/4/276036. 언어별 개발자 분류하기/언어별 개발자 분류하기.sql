select (if(skill_code & (select sum(code) from skillcodes where category='Front End') and skill_code & (select sum(code) from skillcodes where name = 'Python'),'A',
          if(skill_code & (select sum(code) from skillcodes where name = 'C#'), 'B',
            if(skill_code & (select sum(code) from skillcodes where category='Front End'), 'C', NULL)))) grade, id, email
from developers
having grade is not null
order by grade, id