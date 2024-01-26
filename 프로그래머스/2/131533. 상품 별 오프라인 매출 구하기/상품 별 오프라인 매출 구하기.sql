-- 코드를 입력하세요
SELECT PRODUCT_CODE, sum(price*sales_amount) as SALES
from product, offline_sale
where product.product_id=offline_sale.product_id
group by product_code
order by sales desc, product_code