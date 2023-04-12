-- 4. Получить данные о распределении пассажирского автотранспорта по
-- маршрутам.
select A.route_id,
       A.route_name,
       case when B."Transport count" isnull then 0
           else B."Transport count"
       end
       + case when C."Transport count" isnull then 0
             else C."Transport count"
       end as "Transport count"
from "Routes" A left join (
    select R.route_id,
           count(*) as "Transport count"
    from "Routes" as R,
         "Vehicle-Bus model" as VBM
    where (VBM.route_id = R.route_id)
    group by R.route_id
    ) B on A.route_id = B.route_id
    left join (
    select R.route_id,
           count(*) as "Transport count"
    from "Routes" as R,
         "Vehicle-Shuttle model" as VSM
    where (VSM.route_id = R.route_id)
    group by R.route_id
    ) C on A.route_id = C.route_id;