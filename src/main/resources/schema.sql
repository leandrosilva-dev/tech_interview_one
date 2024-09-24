drop table if exists users;

CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,     
    full_name VARCHAR(255) NOT NULL,          
    document VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    type INTEGER not null,
    password VARCHAR(255) NOT NULL,           
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

alter table users add constraint unique_document unique (document);

alter table users add constraint unique_email unique(email);

create table if not exists wallet(
    id bigint auto_increment primary key,
    user_id integer not null,
    balance numeric(20,2) not null
);

drop table if exists transfer;

create table if not exists transfer(
    id bigint auto_increment primary key,
    payer integer not null,
    payee integer not null,
    amount numeric(20,2) not null
);