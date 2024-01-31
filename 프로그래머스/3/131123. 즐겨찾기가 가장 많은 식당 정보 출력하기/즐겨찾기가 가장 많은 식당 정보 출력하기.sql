-- 코드를 입력하세요
select rest_info.food_type, rest_info.rest_id,rest_info.rest_name,rest_info.favorites
from (SELECT food_type, rest_id, rest_name, max(FAVORITES) favorites
from rest_info
     group by food_type) tc join rest_info
on tc.favorites=rest_info.favorites and tc.food_type=rest_info.food_type
order by rest_info.food_type desc