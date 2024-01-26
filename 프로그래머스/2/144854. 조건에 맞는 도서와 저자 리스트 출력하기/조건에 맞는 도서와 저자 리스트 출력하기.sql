-- 코드를 입력하세요
SELECT BOOK_ID, AUTHOR_NAME, date_format(PUBLISHED_DATE,"%Y-%m-%d") as PUBLISHED_DATE
from book, author
where book.author_id = author.author_id and category="경제"
order by PUBLISHED_DATE asc