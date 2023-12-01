CREATE SEQUENCE sequence_delivery_guys  START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sequence_clients        START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sequence_agents         START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sequence_geo_position   START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sequence_addresses      START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sequence_orders         START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sequence_items          START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sequence_order_lines    START WITH 1 INCREMENT BY 1;



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

CREATE TABLE geo_position(
    position_id NUMBER PRIMARY KEY,
    latitude number,
    longitude number
);

CREATE TABLE addresses(
    address_id NUMBER PRIMARY KEY,
    street VARCHAR2(100),
    city VARCHAR2(100),
    postal_code VARCHAR2(5),
    country VARCHAR2(100),
    geo_position_id number,
    FOREIGN KEY (geo_position_id) REFERENCES geo_position(position_id)
);

CREATE TABLE orders(
    order_id NUMBER PRIMARY KEY,
    client_id NUMBER,
    delivery_guy_id NUMBER,
    src_address_id NUMBER,
    dist_address_id NUMBER,
    status VARCHAR2(20),
    review VARCHAR2(500),
    evaluation NUMBER(1,0),
    created_at DATE,
    confirmed_at DATE,
    delivered_at DATE,
    FOREIGN KEY (client_id) REFERENCES clients(client_id),
    FOREIGN KEY (delivery_guy_id) REFERENCES delivery_guys(delivery_guy_id),
    FOREIGN KEY (src_address_id) REFERENCES addresses(address_id),
    FOREIGN KEY (dist_address_id) REFERENCES addresses(address_id),
    constraint test2 check (status in ('Draft','confirmed', 'delivered'))
);

CREATE TABLE items(
    item_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    price NUMBER(10,2),
    description VARCHAR2(500)
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














/*

SELECT * FROM o orders, c clients, a addresses, d delivery_guys
WHERE delivery_guy_id=? and
o.client_id=c.id and
o.delivery_guy_id=d.id and
o.address_id=a.id






SELECT *
FROM orders o
INNER JOIN clients c ON o.client_id = c.client_id
INNER JOIN addresses a ON o.src_address_id = a.address_id and o.dist_address_id = a.address_id 
INNER JOIN delivery_guys d ON o.delivery_guy_id = d.delivery_guy_id and d.delivery_guy_id=1;



SELECT *
FROM orders o
INNER JOIN clients c ON o.client_id = c.client_id
INNER JOIN addresses a_src ON o.src_address_id = a_src.address_id
INNER JOIN addresses a_dist ON o.dist_address_id = a_dist.address_id 
INNER JOIN delivery_guys d ON o.delivery_guy_id = d.delivery_guy_id 
where d.delivery_guy_id = 1;


SELECT *
FROM orders o
LEFT JOIN clients c ON o.client_id = c.client_id
LEFT JOIN addresses a_src ON o.src_address_id = a_src.address_id
LEFT JOIN addresses a_dist ON o.dist_address_id = a_dist.address_id 
LEFT JOIN delivery_guys d ON o.delivery_guy_id = d.delivery_guy_id 
where d.delivery_guy_id = 1;


/* add geoposition */
SELECT
o.order_id, o.client_id, o.delivery_guy_id, o.src_address_id, o.dist_address_id, o.status, o.review, o.evaluation, o.created_at, o.confirmed_at, o.delivered_at,

c.client_id as client_client_id, c.firstname as client_firstname, c.lastname as client_lastname, c.email as client_email, c.password as client_password, c.phone_number as client_phone_number, c.profile_photo_path as client_profile_photo_path,
d.delivery_guy_id as delivery_delivery_guy_id, d.firstname as delivery_firstname, d.lastname as delivery_lastname, d.email as delivery_email, d.password as delivery_password, d.phone_number as delivery_phone_number, d.status as delivery_status,

a_src.address_id as src_src_address_id, a_src.street as src_street, a_src.city as src_city, a_src.postal_code as src_postal_code, a_src.country as src_country, a_src.geo_position_id as src_geo_position_id,
a_dist.address_id as dist_dist_address_id, a_dist.street as dist_street, a_dist.city as dist_city, a_dist.postal_code as dist_postal_code, a_dist.country as dist_country, a_dist.geo_position_id as dist_geo_position_id,

geo_src.position_id as src_position_id, geo_src.latitude as src_latitude, geo_src.longitude as src_longitude,
geo_dist.position_id as dist_position_id, geo_dist.latitude as dist_latitude, geo_dist.longitude as dist_longitude
FROM orders o
LEFT JOIN clients c ON o.client_id = c.client_id
LEFT JOIN addresses a_src ON o.src_address_id = a_src.address_id
LEFT JOIN addresses a_dist ON o.dist_address_id = a_dist.address_id 
LEFT JOIN geo_position geo_src ON o.src_address_id = geo_src.position_id
LEFT JOIN geo_position geo_dist ON o.dist_address_id = geo_dist.position_id 
LEFT JOIN delivery_guys d ON o.delivery_guy_id = d.delivery_guy_id 
where d.delivery_guy_id = 1;



"SELECT"+
"o.order_id, o.client_id, o.delivery_guy_id, o.src_address_id, o.dist_address_id, o.status, o.review, o.evaluation, o.created_at, o.confirmed_at, o.delivered_at,"+
"c.client_id as client_client_id, c.firstname as client_firstname, c.lastname as client_lastname, c.email as client_email, c.password as client_password, c.phone_number as client_phone_number, c.profile_photo_path as client_profile_photo_path,"+
"d.delivery_guy_id as delivery_delivery_guy_id, d.firstname as delivery_firstname, d.lastname as delivery_lastname, d.email as delivery_email, d.password as delivery_password, d.phone_number as delivery_phone_number, d.status as delivery_status,"+
"a_src.address_id as src_src_address_id, a_src.street as src_street, a_src.city as src_city, a_src.postal_code as src_postal_code, a_src.country as src_country, a_src.geo_position_id as src_geo_position_id,"+
"a_dist.address_id as dist_dist_address_id, a_dist.street as dist_street, a_dist.city as dist_city, a_dist.postal_code as dist_postal_code, a_dist.country as dist_country, a_dist.geo_position_id as dist_geo_position_id,"+
"geo_src.position_id as src_position_id, geo_src.latitude as src_latitude, geo_src.longitude as src_longitude,"+
"geo_dist.position_id as dist_position_id, geo_dist.latitude as dist_latitude, geo_dist.longitude as dist_longitude"+
"FROM orders o"+
"LEFT JOIN clients c ON o.client_id = c.client_id"+
"LEFT JOIN addresses a_src ON o.src_address_id = a_src.address_id"+
"LEFT JOIN addresses a_dist ON o.dist_address_id = a_dist.address_id "+
"LEFT JOIN geo_position geo_src ON o.src_address_id = geo_src.position_id"+
"LEFT JOIN geo_position geo_dist ON o.dist_address_id = geo_dist.position_id "+
"LEFT JOIN delivery_guys d ON o.delivery_guy_id = d.delivery_guy_id "+
"where d.delivery_guy_id = 1"+

*/