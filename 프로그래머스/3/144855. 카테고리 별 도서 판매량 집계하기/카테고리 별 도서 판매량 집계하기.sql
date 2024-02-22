-- 코드를 입력하세요
SELECT category, sum(sales) total_sales
from book join book_sales using(book_id)
where sales_date like "2022-01%"
group by category
order by category