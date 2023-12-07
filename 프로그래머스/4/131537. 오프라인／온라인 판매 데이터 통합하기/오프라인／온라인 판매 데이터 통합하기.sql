-- 코드를 입력하세요
SELECT date_format(SALES_DATE,'%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, IFNULL(USER_ID, NULL) AS USER_ID, SALES_AMOUNT from ONLINE_SALE where SALES_DATE between '2022-03-01' and '2022-03-31'

union all

SELECT date_format(SALES_DATE,'%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT from OFFLINE_SALE where SALES_DATE between '2022-03-01' and '2022-03-31'

order by sales_date, product_id, user_id;