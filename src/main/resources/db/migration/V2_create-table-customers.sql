CREATE TABLE customers (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    cpf_cnpj VARCHAR(14) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    street varchar(100) not null,
    number varchar(20),
    complement varchar(50),
    neighborhood varchar(50) not null,
    city varchar(50) not null,
    state varchar(2) not null,
    zip_code varchar(8) not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

    PRIMARY KEY(id)
);