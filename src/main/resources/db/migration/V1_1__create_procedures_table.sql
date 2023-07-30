CREATE TABLE procedures(
    code VARCHAR(10) NOT NULL,
    description VARCHAR(40) NOT NULL,
    global_fee DECIMAL(10, 2) DEFAULT 0.0,
    technical_fee DECIMAL(10,2) DEFAULT 0.0,
    professional_fee DECIMAL(10,2) DEFAULT 0.0,
    cost DECIMAL(10,2) DEFAULT 0.0,
    default_units DECIMAL(5,2) DEFAULT 1.00,
    default_modifier VARCHAR(2),
    tos_code CHAR(1),
    pos_code VARCHAR(2),
    modality CHAR(1) NOT NULL,
    deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT pk__procedures_code PRIMARY KEY (code)
);

CREATE INDEX ix__procedures_description ON procedures(description ASC);
CREATE UNIQUE INDEX uix__procedures_code ON procedures(code ASC);