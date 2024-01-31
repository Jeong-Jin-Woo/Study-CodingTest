-- 코드를 입력하세요
select flavor
from (select first_half.flavor, first_half.total_order + total_order2 total
from first_half join
    (SELECT shipment_id, FLAVOR, sum(total_order) TOTAL_ORDER2
    from july
    group by flavor) tc
on first_half.shipment_id = tc.shipment_id) tc2
order by total desc
limit 3;