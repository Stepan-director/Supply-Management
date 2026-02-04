!!! ЕСЛИ СОБИРАЕТЕСЬ ТЕСТИРОВАТЬ, А Я НЕ ЗНАЮ, КАК ВЫ ЭТО ДЕЛАЕТЕ, ТО, НА ВСЯКИЙ СЛУЧАЙ, ДЛЯ УПРОЩЕНИЯ ВАШЕЙ РАБОТЫ МОЖЕТЕ ТЕСТИТЬ КОПИПАСТОМ ))) !!!

create table delivery ( id BIGSERIAL PRIMARY KEY, supplier_id bigint, supplier_name varchar(255), delivery_date date, amount DOUBLE PRECISION, status varchar(255) );

create table suppliers ( id BIGSERIAL PRIMARY KEY, name varchar(255) not null, phone varchar(50) );

create table products ( id BIGSERIAL PRIMARY KEY, name varchar(255), type varchar(100), variety varchar(100) );

create table delivery_product ( id BIGSERIAL PRIMARY KEY, delivery_id bigint, product_id bigint, quantity DOUBLE PRECISION, price DOUBLE PRECISION, total_amount DOUBLE PRECISION );

create table supplier_products ( id BIGSERIAL PRIMARY KEY, supplier_id bigint, supplier_name varchar(255), product_id BIGINT, product_name varchar(255), product_type varchar(255), variety varchar(255), price DOUBLE PRECISION, measure_unit varchar(50) default 'кг' );

create table warehouse ( id BIGSERIAL PRIMARY KEY, product_id bigint not null, product_name varchar(255), product_type varchar(100), variety varchar(100), quantity DOUBLE PRECISION not null, measure_unit varchar(50) default 'кг', received_date date not null default current_date );

ДЛЯ ТЕСТОВ В POSTMANE или где удобно

!!! SupplierController !!!

http://localhost:8080/supplier/create
{ "name" : "Фабрикат натрия", "phone": "+7(909)-333-000-21" }

http://localhost:8080/supplier/1

http://localhost:8080/supplier/update { "id": 1, "name" : "Капризуля Лысая", "phone": "+7(909)-333-111-21" }

http://localhost:8080/supplier/delete/1

!!! ProductController !!!

http://localhost:8080/product/create
{ "name" : "Капризуля Лысая", "type": "Тот ещё фрукт", "variety": "Дорогая" }

http://localhost:8080/product/getType
{ "type": "Тот ещё фрукт" }

http://localhost:8080/product/getName
{ "name": "Груша" }

!!! SupplierProductController !!!

http://localhost:8080/supplierProduct
{ "supplierId": "1", "productId": "1", "price": "100" }

http://localhost:8080/supplierProduct/Груша

http://localhost:8080/supplierProduct (PUT)

{ "id" : 1, "price" : 112.0 }

!!! DeliveryController !!!

http://localhost:8080/delivery
{ "supplierId": 1 }

http://localhost:8080/delivery/1/confirm

http://localhost:8080/delivery/1/cancel

http://localhost:8080/delivery/1 (DELETE)

http://localhost:8080/delivery/1/items

{ "productId": 1, "quantity": 4 }

http://localhost:8080/delivery/1/accept (после этого метода заполняется таблица со складом, над ним не особо работал - не удалить, не добавить через котнроллер)

!!! ReportController !!!

http://localhost:8080/reports?startDate=2026-02-03&endDate=2026-02-04
ВЫВОД: { "data": [ { "Стоимость (руб)": 444.0, "Поставщик": "Капризуля Лысая", "Вес (кг)": 4.0, "Продукт": "null null" }, { "Стоимость (руб)": 444.0, "Поставщик": "Капризуля Лысая", "Вес (кг)": 4.0, "Продукт": "Груша Дорогая" }, { "Стоимость (руб)": 444.0, "Поставщик": "Капризуля Лысая", "Вес (кг)": 4.0, "Продукт": "Груша Дорогая" } ] }
