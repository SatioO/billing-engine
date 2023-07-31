CREATE TABLE payers_contracts_mapper (
    payer_id NUMERIC(10,0) NOT NULL,
    contract_id NUMERIC(5,0) NOT NULL,

    CONSTRAINT fk__payers_id FOREIGN KEY(payer_id) REFERENCES payers(id) ON DELETE CASCADE,
    CONSTRAINT fk__contract_id FOREIGN KEY(contract_id) REFERENCES contracts(id) ON DELETE CASCADE
);