select distinct class
from courses
group by class
having count(*) >=5


