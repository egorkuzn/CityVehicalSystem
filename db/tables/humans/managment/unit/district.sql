create table "District" (
    district_id   serial primary key,
    firstname     text not null check ( length(firstname) > 0 ),
    department_id int not null check ( department_id > 0 ),

    foreign key (department_id) references "Department"
);

insert into "District" (firstname, department_id)
values
('Участок подготовки кузова', 8),
('Участок сварки и пайки', 8),
('Участок окраски и антикоррозийной защиты', 8),
('Участок сборки двигателя и трансмиссии', 8),
('Участок сборки ходовой части и электрооборудования', 8),
('Участок сборки салона и обивки', 8),
('Участок контроля качества и испытаний', 8);

insert into "District" (firstname, department_id)
values
('Участок диагностики и оценки повреждений', 9),
('Участок разборки и демонтажа кузовных элементов', 9),
('Участок восстановления и выправления кузова', 9),
('Участок шпатлевки и шлифовки поверхности', 9),
('Участок подбора и подготовки краски', 9),
('Участок окраски и сушки кузова', 9),
('Участок сборки и монтажа кузовных элементов', 9),
('Участок полировки и защиты кузова', 9);

insert into "District" (firstname, department_id)
values
('Участок производства и сборки аккумуляторов', 10),
('Участок производства и сборки генераторов и стартеров', 10),
('Участок производства и сборки светового оборудования', 10),
('Участок производства и сборки приборной панели и датчиков', 10),
('Участок производства и сборки системы зажигания и электронного управления двигателем', 10),
('Участок производства и сборки системы антиблокировки тормозов и курсовой устойчивости', 10),
('Участок производства и сборки системы кондиционирования и отопления', 10),
('Участок производства и сборки системы навигации и мультимедиа', 10);



