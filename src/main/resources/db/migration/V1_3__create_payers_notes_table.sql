DROP TABLE IF EXISTS payers_notes;

CREATE TABLE payers_notes(
    id SERIAL,
    payer_id NUMERIC(10,0) NOT NULL,
    note VARCHAR(350),
    invoice VARCHAR(350),

    CONSTRAINT pk__payers_notes_id PRIMARY KEY (id),
    CONSTRAINT payer_id FOREIGN KEY(payer_id) REFERENCES payers(id) ON DELETE CASCADE
);