insert into items (id, name, quantity, description, category, is_displayed, private_comments, condition)
values ('6910e584-3fe3-11ed-b878-0242ac120002', 'Item1', '1', 'Item1description', 'A', 'TRUE', 'Item1comment',
        'Item1condition'),
       ('6910e804-3fe3-11ed-b878-0242ac120002', 'Item2', '2', 'Item2description', 'A', 'TRUE', 'Item2comment',
        'Item2condition'),
       ('6910e930-3fe3-11ed-b878-0242ac120002', 'Item3', '3', 'Item3description', 'A', 'TRUE', 'Item3comment',
        'Item3condition'),
       ('6910ea48-3fe3-11ed-b878-0242ac120002', 'Item4', '4', 'Item4description', 'A', 'TRUE', 'Item4comment',
        'Item4condition'),
       ('6910eb60-3fe3-11ed-b878-0242ac120002', 'Item5', '4', 'Item5description', 'B', 'TRUE', 'Item5comment',
        'Item5condition'),
       ('6910ec78-3fe3-11ed-b878-0242ac120002', 'Item6', '4', 'Item6description', 'B', 'TRUE', 'Item6comment',
        'Item6condition'),
       ('6910f0ba-3fe3-11ed-b878-0242ac120002', 'Item7', '4', 'Item7description', 'B', 'FALSE', 'Item7comment',
        'Item7condition'),
       ('6910f1fa-3fe3-11ed-b878-0242ac120002', 'Item8', '4', 'Item8description', 'B', 'FALSE', 'Item8comment',
        'Item8condition'),
       ('6910f312-3fe3-11ed-b878-0242ac120002', 'Item9', '4', 'Item9description', 'C', 'FALSE', 'Item9comment',
        'Item9condition'),
       ('6910f420-3fe3-11ed-b878-0242ac120002', 'Item10', '5', 'Item10description', 'C', 'FALSE', 'Item10comment',
        'Item10condition');

INSERT INTO USERS(id, name, surname, phone, email, fee_paid_on, username, password)
VALUES ('1c6eb4cd-b644-4932-8d88-ec97b3ba0b7b', 'A_name', 'A_surname', '2478075', 'admin@test.lt', '2020-01-01',
        'admin','{bcrypt}$2a$10$9Ox9WgR8X5SD04lLSdCwJ.AITH/cAZmcZ9tMkqJUFYSc0krItXT9W') /*admin*/,
       ('97591abe-5108-4bc2-afaa-6bc6a339619c', 'U_name', 'U_surname', '+361145678', 'user@test.lt', '2022-09-30',
        'user','{bcrypt}$2a$10$AsRCsrfh4423vjPr0xKpZeNpYixVcNtDpiGdM5xcIejUXOttH2jcu') /*user*/ /*USER*/;

INSERT INTO ROLES(id, name)
VALUES ('7f74bb02-9f14-43ce-8b28-8c0c889d1558', 'USER'),
       ('25dde1c9-f740-46a7-a598-d62f37126950', 'ADMIN');

INSERT INTO USERS_ROLES(user_id, role_id)
VALUES ('97591abe-5108-4bc2-afaa-6bc6a339619c', '7f74bb02-9f14-43ce-8b28-8c0c889d1558'),
       ('1c6eb4cd-b644-4932-8d88-ec97b3ba0b7b', '7f74bb02-9f14-43ce-8b28-8c0c889d1558'),
       ('1c6eb4cd-b644-4932-8d88-ec97b3ba0b7b', '25dde1c9-f740-46a7-a598-d62f37126950');