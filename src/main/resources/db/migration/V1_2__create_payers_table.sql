DROP TABLE IF EXISTS payers;

CREATE TABLE payers(
    id NUMERIC(10,0) NOT NULL,
    code VARCHAR(10),
    name VARCHAR(50) NOT NULL,
    address1 VARCHAR(30),
    address2 VARCHAR(30),
    city VARCHAR(20) NOT NULL,
    state VARCHAR(2) NOT NULL,
    zip VARCHAR(5),
    zip_extension VARCHAR(4),
    phone NUMERIC(13,0),
    fax NUMERIC(13,0),
    redi_code CHAR(1) NOT NULL,
    payor_id VARCHAR(10) NOT NULL,
    revenue_type CHAR(20) NOT NULL,
    omit_service_segment BOOLEAN DEFAULT FALSE,
    inv_dos_sort BOOLEAN DEFAULT FALSE,
    terms_net_days NUMERIC(3, 0),

    xray DECIMAL(10,2),
    ultrasound DECIMAL(10,2),
    doppler DECIMAL(10,2),
    add_xray DECIMAL(10,2),
    add_ultrasound DECIMAL(10,2),
    dry_run DECIMAL(10,2),
    ekg DECIMAL(10,2),
    employee DECIMAL(10,2),
    va DECIMAL(10,2),
    ppd DECIMAL(10,2),
    stat DECIMAL(10,2),
    pct_of_mcr NUMERIC(3,0),
    mcr2nd_id VARCHAR(3),

    exclude_xr_setup BOOLEAN DEFAULT FALSE,
    exclude_xr_trans BOOLEAN DEFAULT FALSE,
    exclude_us_setup BOOLEAN DEFAULT FALSE,
    exclude_us_trans BOOLEAN DEFAULT FALSE,
    use_tc_fee BOOLEAN DEFAULT FALSE,
    lookup_schedule BOOLEAN DEFAULT FALSE,
    after_hours BOOLEAN DEFAULT FALSE,
    group_transport BOOLEAN DEFAULT FALSE,
    exclude_tc_clm BOOLEAN DEFAULT FALSE,
    exclude_prof_clm BOOLEAN DEFAULT FALSE,

    clearinghouse_code VARCHAR(15),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,

    deleted BOOLEAN DEFAULT FALSE,
    CONSTRAINT pk__payers_id PRIMARY KEY (id)
);

CREATE INDEX ix__payers_code ON payers(code ASC);
CREATE INDEX ix__payers_name ON payers(name ASC);
CREATE UNIQUE INDEX uix__payers_id ON payers(id ASC);

