-- Получить данные о подчиненности персонала: рабочие -бригадиры -
-- мастера - начальники участков и цехов. TODO

select DepC.human_id,
       Dep.name,
       DisC.human_id,
       Dis.firstname,

from "Department chief" DepC left join "Department" Dep on DepC.department_id = Dep.department_id
    left join "District chief" DisC on DepC.district_chef_id = DisC.human_id
    left join "District" Dis on DisC.district_id = Dis.district_id
    left join "Masters" M on DisC.master_id = M.human_id
    left join "Brigadier" B on M.brigadier_id = B.human_id
    left join "Brigades" Br on B.brigade_id = Br.brigade_id
    left join "Workers" W on W.brigade_id = B.brigade_id
-- Получить состав подчиненных указанного бригадира,
-- мастера и пр. TODO