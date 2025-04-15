CREATE SEQUENCE loan_applications_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE loan_applications
(
    id              BIGINT PRIMARY KEY DEFAULT nextval('loan_applications_seq'),
    amount          NUMERIC,
    currency        VARCHAR(3),
    terms_in_months INTEGER,
    status          VARCHAR(10)
);
