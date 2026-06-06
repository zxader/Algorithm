-- 코드를 입력하세요
SELECT distinct o.user_id, o.product_id
from online_sale o 
where (
    select count(*)
    from online_sale t
    where o.user_id = t.user_id and o.product_id = t.product_id and o.sales_date != t.sales_date
) > 0
order by o.user_id, o.product_id desc