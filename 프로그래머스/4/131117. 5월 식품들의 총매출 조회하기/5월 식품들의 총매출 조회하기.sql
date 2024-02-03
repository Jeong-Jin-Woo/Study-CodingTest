-- 코드를 입력하세요
# SELECT product_id, product_name, (amount*price) total_sales
# from food_product join food_order using(PRODUCT_ID)
# where PRODUCE_DATE >= '2022-05-01' and PRODUCE_DATE < '2022-06-01'

SELECT product_id, product_name, sum((amount*price)) total_sales
from food_product join food_order using(PRODUCT_ID)
where PRODUCE_DATE >= '2022-05-01' and PRODUCE_DATE < '2022-06-01'
group by product_name
order by total_sales desc, product_id