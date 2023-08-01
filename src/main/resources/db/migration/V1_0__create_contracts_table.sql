DROP TABLE IF EXISTS contracts;

CREATE TABLE contracts(
    id NUMERIC(5,0) NOT NULL,
    name VARCHAR(40) NOT NULL,
    effective_from DATE,
    effective_thru DATE,
    invoice_discount BOOLEAN DEFAULT FALSE,
    deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT pk__contracts_id PRIMARY KEY (id)
);

CREATE INDEX ix__contracts_name on contracts(name ASC);
CREATE UNIQUE INDEX uix__contracts_id on contracts(id ASC);