CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE goods
(
    id    BIGINT           NOT NULL,
    name  VARCHAR(255),
    price DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_goods PRIMARY KEY (id)
);

CREATE TABLE order_line
(
    id       BIGINT           NOT NULL,
    order_id BIGINT,
    count    DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_orderline PRIMARY KEY (id)
);

CREATE TABLE order_line_goods_list
(
    order_line_id BIGINT NOT NULL,
    goods_list_id BIGINT NOT NULL
);

CREATE TABLE orders
(
    id      BIGINT NOT NULL,
    client  VARCHAR(255),
    date    date,
    address VARCHAR(255),
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

ALTER TABLE order_line_goods_list
    ADD CONSTRAINT uc_order_line_goods_list_goodslist UNIQUE (goods_list_id);

ALTER TABLE order_line
    ADD CONSTRAINT FK_ORDERLINE_ON_ORDER FOREIGN KEY (order_id) REFERENCES orders (id);

ALTER TABLE order_line_goods_list
    ADD CONSTRAINT fk_ordlingoolis_on_goods FOREIGN KEY (goods_list_id) REFERENCES goods (id);

ALTER TABLE order_line_goods_list
    ADD CONSTRAINT fk_ordlingoolis_on_order_line FOREIGN KEY (order_line_id) REFERENCES order_line (id);