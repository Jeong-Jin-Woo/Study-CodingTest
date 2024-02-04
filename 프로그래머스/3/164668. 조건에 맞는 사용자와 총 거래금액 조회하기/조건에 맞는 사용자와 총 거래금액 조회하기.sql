-- 코드를 입력하세요
select user_id, nickname, total_sales
from (SELECT user_id, nickname, sum(price) total_sales
from USED_GOODS_BOARD join USED_GOODS_USER 
on USED_GOODS_USER.user_id = USED_GOODS_BOARD.writer_id
where status = 'DONE'
group by user_id) t1
where total_sales >= 700000
order by total_sales