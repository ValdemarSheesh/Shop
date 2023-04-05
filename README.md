# Shop (тестовое задание)

## Технологии
- Gradle
- Spring
- Spring Boot 2.0
- Spring Data JPA
- база данных H2
- контейнер сервлетов Tomcat
- Junit
- Mockito
- Mapstruct

## Описание 
Сделать 3 сущности «Заказ» (Order), «Строка Заказа» (OrderLine) и «Товар» (Goods) которые сохраняются в базу данных. 

1. order
- id
- client
- date
- address

2. order_line
- id
- order_id
- goods_id
- count

3. goods
- id
- name
- price

## Требования

1. Реализовать CRUD-операции.
2. Приложение должно быть разделено по слоям DAO, Service, Controller.
3. Написать тесты для каждого слоя:
- для DAO используется JUnit, Spring, Spring Data JPA и база данных H2
- для Service используется JUnit, Spring, Mockito (не обращается к базе, использует Mock объекты)
- для Controller используется JUnit, Spring (не обращается к Service, использует MockMVC объекты)
