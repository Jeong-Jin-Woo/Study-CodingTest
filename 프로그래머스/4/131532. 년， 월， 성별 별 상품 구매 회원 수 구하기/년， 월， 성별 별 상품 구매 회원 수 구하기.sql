-- 코드를 입력하세요
SELECT year(sales_date) year, month(sales_date) month, gender, count(distinct user_id) users
from user_info join online_sale using(user_id)
where gender is not null
group by year(sales_date), month(sales_date), gender
order by year, month, gender