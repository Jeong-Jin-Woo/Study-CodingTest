-- 코드를 입력하세요
# select car_id, t1.car_type, truncate((DAILY_FEE * (100-DISCOUNT_RATE) / 100) * 30, 0) fee
# from (
# select *
# from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
# where (car_type='세단' or car_type='SUV') and duration_type='30일 이상') t1
# join
# (SELECT distinct CAR_RENTAL_COMPANY_CAR.car_id, 
# car_type, daily_fee
# from CAR_RENTAL_COMPANY_CAR join CAR_RENTAL_COMPANY_RENTAL_HISTORY
# on CAR_RENTAL_COMPANY_CAR.car_id = CAR_RENTAL_COMPANY_RENTAL_HISTORY.car_id
# where ((date(CAR_RENTAL_COMPANY_RENTAL_HISTORY.end_date) < '2022-11-01')
# or (date(CAR_RENTAL_COMPANY_RENTAL_HISTORY.start_date) > '2022-11-30'))
# and (car_type='SUV' or car_type='세단')
# ) t2
# on t1.car_type = t2.car_type
# where ((DAILY_FEE * (100-DISCOUNT_RATE) / 100) * 30) >= 500000 
# and ((DAILY_FEE * (100-DISCOUNT_RATE) / 100) * 30) < 2000000
# order by fee desc, car_type, car_id desc
select car_id, t1.car_type, truncate((DAILY_FEE * (100-DISCOUNT_RATE) / 100) * 30, 0) fee
from CAR_RENTAL_COMPANY_CAR t1 join CAR_RENTAL_COMPANY_DISCOUNT_PLAN t2 using(car_type)
where t2.duration_type ='30일 이상' and  t1.car_type in ("SUV", "세단") and car_id not in (SELECT CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
WHERE END_DATE >= '2022-11-1' AND START_DATE <= '2022-11-30')
and (DAILY_FEE * (100-DISCOUNT_RATE) / 100) * 30 >= 500000 and 
(DAILY_FEE * (100-DISCOUNT_RATE) / 100) * 30 < 2000000