insert into delivery_guys values(sequence_delivery_guys.nextval ,'ahmed', 'kechicheb', 'ahmed@gmail.com', 'pass', '0111111111', 'active');
insert into delivery_guys values(sequence_delivery_guys.nextval ,'ali', 'jamel', 'ali@gmail.com', 'pass', '222222222', 'active');
insert into delivery_guys values(sequence_delivery_guys.nextval ,'alex', 'afzff', 'alex@gmail.com', 'pass', '22222222222', 'active');
insert into delivery_guys values(sequence_delivery_guys.nextval ,'dude', 'dude', 'dude@gmail.com', 'pass', '2222222222', 'disactive');



insert into clients values(sequence_clients.nextval, 'ahmed', 'kechicheb', 'ahmed@gmail.com', 'pass', '0111111111', 'photo_def.jpg');
insert into clients values(sequence_clients.nextval, 'ali', 'jamel', 'ali@gmail.com', 'pass', '22222', 'photo_def.jpg');
insert into clients values(sequence_clients.nextval, 'alex', 'afzff', 'alex@gmail.com', 'pass', '2222222', 'photo_def.jpg');
insert into clients values(sequence_clients.nextval, 'dude', 'dude', 'dude@gmail.com', 'pass', '222222', 'photo_def.jpg');



insert into agents values(sequence_agents.nextval, 'ahmed', 'kechicheb', 'ahmed@gmail.com', 'pass', '0111111111', '192.168.0.1');
insert into agents values(sequence_agents.nextval, 'ali', 'jamel', 'ali@gmail.com', 'pass', '22222', '192.168.0.2');
insert into agents values(sequence_agents.nextval, 'alex', 'afzff', 'alex@gmail.com', 'pass', '2222222', '192.168.0.3');
insert into agents values(sequence_agents.nextval, 'dude', 'dude', 'dude@gmail.com', 'pass', '222222', '192.168.0.4');


/* i dont know real values */
insert into geo_position values(sequence_geo_position.nextval, 50, 50);


/* add geo_position */
insert into addresses values(sequence_addresses.nextval, 'random street', 'annaba', '20330', 'algeria', 1);
insert into addresses values(sequence_addresses.nextval, 'random street', 'constn', '20331', 'algeria', 1);
insert into addresses values(sequence_addresses.nextval, 'random street', 'skikda', '20332', 'algeria', 1);
insert into addresses values(sequence_addresses.nextval, 'random street', 'batna', '20333', 'algeria', 1);


/* needs  2 addresses first */
insert into orders values(sequence_addresses.nextval, 1, 1, 1, 2, 'Draft', 'good', 0, TO_DATE('2023/12/10 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2023/12/10 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2023/12/10 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into orders values(sequence_addresses.nextval, 2, 1, 1, 3, 'Draft', 'good', 0, TO_DATE('2023/12/10 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2023/12/10 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2023/12/10 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into orders values(sequence_addresses.nextval, 1, 3, 1, 4, 'Draft', 'good', 0, TO_DATE('2023/12/10 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2023/12/10 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2023/12/10 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));
insert into orders values(sequence_addresses.nextval, 3, 2, 2, 4, 'Draft', 'good', 0, TO_DATE('2023/12/10 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2023/12/10 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2023/12/10 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));


insert into items values(sequence_items.nextval, 'vaccum', '20000', 'it cleans the floor');
insert into items values(sequence_items.nextval, 'tv', '30000', 'you watch it');
insert into items values(sequence_items.nextval, 'car', '3000000', 'you drive it');
insert into items values(sequence_items.nextval, 'laptop', '70000', 'laptop');


/* needs items */
insert into order_lines values(sequence_order_lines.nextval, 1, 1, 1, 'default_pic.jpg');
insert into order_lines values(sequence_order_lines.nextval, 1, 2, 1, 'default_pic.jpg');
insert into order_lines values(sequence_order_lines.nextval, 1, 3, 1, 'default_pic.jpg');
insert into order_lines values(sequence_order_lines.nextval, 1, 4, 1, 'default_pic.jpg');
insert into order_lines values(sequence_order_lines.nextval, 2, 4, 1, 'default_pic.jpg');
insert into order_lines values(sequence_order_lines.nextval, 2, 3, 1, 'default_pic.jpg');
