CREATE TABLE items (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    code VARCHAR(50) NOT NULL UNIQUE,
    category VARCHAR(50), -- CORRENTE, LÂMINA, FILTRO, ÓLEO, etc.
    quantity INTEGER NOT NULL DEFAULT 0,
    min_quantity INTEGER DEFAULT 0, -- Quantidade mínima para alerta de estoque
    unit_price DECIMAL(10, 2) NOT NULL,
    cost_price DECIMAL(10, 2),
    supplier VARCHAR(100),
    location VARCHAR(50), -- Localização no estoque
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

    PRIMARY KEY(id)
);