select f.flavor
from first_half f
right join july j
on f.flavor = j.flavor
group by f.shipment_id
order by sum(f.total_order) + sum(j.total_order) desc
limit 3