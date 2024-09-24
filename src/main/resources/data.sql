delete users;

INSERT INTO users (full_name, document, email, type, password) 
VALUES ('Leandro', '123456789', 'leandro@example.com', 1, '123');

INSERT INTO users (full_name, document, email, type, password) 
VALUES ('Francielle', '987654321', 'francielle@example.com', 2, '123');

delete wallet;

insert into wallet(user_id, balance)
     select 1, 1000 union all
     select 2, 1000;