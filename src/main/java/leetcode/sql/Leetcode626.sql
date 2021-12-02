select t1.id,t2.student
from seat t1
left join seat t2
on t2.id = t1.id - POW(-1,t1.id%2)


select t1.id,t2.student
from seat t1
left join seat t2
on t2.id = CASE  WHEN t1.id - POW(-1,t1.id%2) > (select max(id) from seat) THEN  t1.id ELSE  t1.id - POW(-1,t1.id%2) END;