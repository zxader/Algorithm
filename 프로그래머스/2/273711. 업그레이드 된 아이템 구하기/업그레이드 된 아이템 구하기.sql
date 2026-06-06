-- 코드를 작성해주세요

select i.item_id, item_name, rarity
from item_info i join item_tree t
on i.item_id = t.item_id
where 
(select rarity
from item_info
where item_id = parent_item_id) = 'RARE'
order by i.item_id desc

