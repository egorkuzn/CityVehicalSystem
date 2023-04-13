-- 7. Получить данные о подчиненности персонала: рабочие -бригадиры -
-- мастера - начальники участков и цехов.
select DepH.firstname || ' '|| DepH.fathername || ' ' || DepH.surname as "Начальник цеха",
       Dep.name as "Цех",
       DisH.firstname || ' '|| DisH.fathername || ' '|| DisH.surname as "Начальник участка",
       Dis.firstname as "Участок",
       MH.firstname || ' '|| MH.fathername || ' '|| MH.surname as "Мастер",
       BH.firstname || ' '|| BH.fathername || ' '|| BH.surname as "Бригадир",
       Br.brigade_id as "Бригада",
       WH.firstname || ' '|| WH.fathername || ' '|| WH.surname as "Рабочий"
from "Department chief" DepC left join "Department" Dep on DepC.department_id = Dep.department_id
                            left join "Humans" DepH on DepC.human_id = DepH.human_id
                            left join "District chief" DisC on DepC.district_chef_id = DisC.human_id
                            left join "Humans" DisH on DisC.human_id = DisH.human_id
                            left join "District" Dis on DisC.district_id = Dis.district_id
                            left join "Masters" M on DisC.master_id = M.human_id
                            left join "Humans" MH on M.human_id = MH.human_id
                            left join "Brigadier" B on M.brigadier_id = B.human_id
                            left join "Humans" BH on BH.human_id = B.human_id
                            left join "Brigades" Br on B.brigade_id = Br.brigade_id
                            left join "Workers" W on W.brigade_id = B.brigade_id
                            left join "Humans" WH on W.human_id = WH.human_id;
-- 13. Получить состав подчиненных указанного бригадира,
-- мастера и пр.
select distinct firstname, fathername, surname
from "Department chief" DepC,
    "District chief" DisC,
    "Masters" M,
    "Brigadier" B,
    "Workers" W,
    "Humans" H
where case
    when DisC.human_id = :manager_id then DisC.master_id = H.human_id
    when DepC.human_id = :manager_id then DepC.district_chef_id = H.human_id
    when M.human_id = :manager_id then M.brigadier_id = H.human_id
    when B.human_id = :manager_id then B.brigade_id = W.brigade_id and H.human_id = W.human_id
    end;