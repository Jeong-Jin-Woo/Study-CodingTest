-- 코드를 입력하세요
select MEMBER_NAME,REVIEW_TEXT, date_format(REVIEW_DATE, "%Y-%m-%d") review_date
from MEMBER_PROFILE join rest_review using(member_id) 
                            join (SELECT member_id, count(*) count
                            from member_profile join rest_review using(MEMBER_ID)
                            group by member_id
                            order by count desc
                            limit 1) tc using(member_id)
order by REVIEW_DATE, REVIEW_TEXT
