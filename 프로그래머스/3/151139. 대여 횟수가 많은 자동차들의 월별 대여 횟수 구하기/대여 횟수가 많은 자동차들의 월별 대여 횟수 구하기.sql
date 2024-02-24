select month(start_date) month, car_id, count(car_id) records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date >= '2022-08-01' and start_date < '2022-11-01' and
        car_id in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                where start_date >= '2022-08-01' and start_date < '2022-11-01'
                  group by car_id
                  having count(*) >= 5)
group by month(start_date), car_id
order by month, car_id desc
