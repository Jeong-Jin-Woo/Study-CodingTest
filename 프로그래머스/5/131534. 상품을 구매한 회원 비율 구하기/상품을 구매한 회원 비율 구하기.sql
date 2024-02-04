select year(SALES_DATE) YEAR, month(SALES_DATE) MONTH , count(distinct user_id) PUCHASED_USERS,
round(count(distinct user_id)/
    (SELECT count(*)
    from user_info
    where joined LIKE '2021%'), 1) PUCHASED_RATIO
from user_info join online_sale using(user_id)
where joined LIKE '2021%'
group by year, month
order by year, month