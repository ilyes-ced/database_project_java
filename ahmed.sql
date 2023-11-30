CREATE TABLE delivery_guys(
    delivery_guy_id NUMBER PRIMARY KEY,
    firstname VARCHAR2(100),
    lastname VARCHAR2(100),
    email VARCHAR2(100),
    password VARCHAR2(100),
    phone_number VARCHAR2(15),
    status VARCHAR2(20),
    constraint test_name check (status in ('active','disactive'))
);

CREATE TABLE clients(
    client_id NUMBER PRIMARY KEY,
    firstname VARCHAR2(100),
    lastname VARCHAR2(100),
    email VARCHAR2(100),
    password VARCHAR2(100),
    phone_number VARCHAR2(15),
    profile_photo_path VARCHAR2(200)
);

CREATE TABLE agents(
    agent_id NUMBER PRIMARY KEY,
    firstname VARCHAR2(100),
    lastname VARCHAR2(100),
    email VARCHAR2(100),
    password VARCHAR2(100),
    phone_number VARCHAR2(15),
    ip_addr VARCHAR2(200)
);

CREATE TABLE addresses(
    address_id NUMBER PRIMARY KEY,
    street VARCHAR2(100),
    city VARCHAR2(100),
    postal_code VARCHAR2(5),
    country VARCHAR2(100)
);

CREATE TABLE orders(
    order_id NUMBER PRIMARY KEY,
    client_id NUMBER,
    delivery_guy_id NUMBER,
    address_id NUMBER,
    status VARCHAR2(20),
    review VARCHAR2(500),
    evaluation NUMBER(1,0),
    created_at DATE,
    confirmed_at DATE,
    delivered_at DATE,
    FOREIGN KEY (client_id) REFERENCES clients(client_id),
    FOREIGN KEY (delivery_guy_id) REFERENCES delivery_guys(delivery_guy_id),
    FOREIGN KEY (address_id) REFERENCES addresses(address_id),
    constraint test2 check (status in ('Draft','confirmed', 'delivered'))
);

CREATE TABLE order_lines(
    order_line_id NUMBER PRIMARY KEY,
    order_id NUMBER,
    item_id NUMBER,
    quantity NUMBER,
    photo_file_path VARCHAR2(200),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id)
);

CREATE TABLE items(
    item_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    price NUMBER(10,2),
    description VARCHAR2(500)
);

CREATE TABLE geo_position(
    position_id NUMBER PRIMARY KEY,
    latitude number,
    longitude number
);