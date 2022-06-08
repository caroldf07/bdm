-- Gerado por Oracle SQL Developer Data Modeler 21.2.0.183.1957
--   em:        2022-06-06 20:18:48 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g


-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE t_consulta_ocorrencia
(
    cd_ocorrencia        CHAR PRIMARY KEY NOT NULL,
    dt_inicio_ocorrencia DATE             NOT NULL,
    dt_fim_ocorrencia    DATE             NOT NULL,
    latitude             NUMERIC,
    longitude            NUMERIC,
    cd_doenca            CHAR,
    cd_regiao            CHAR             NOT NULL,
    gravidade            VARCHAR(30),
    comorbidade          VARCHAR(30)
);

CREATE TABLE t_doenca
(
    cd_doenca CHAR PRIMARY KEY NOT NULL,
    nm_doenca VARCHAR(15)      NOT NULL
);

CREATE TABLE t_regiao
(
    cd_regiao CHAR PRIMARY KEY NOT NULL,
    nm_regiao VARCHAR(15)      NOT NULL
);

ALTER TABLE t_consulta_ocorrencia
    ADD CONSTRAINT fk_t_doenca FOREIGN KEY (cd_doenca)
        REFERENCES t_doenca (cd_doenca);

ALTER TABLE t_consulta_ocorrencia
    ADD CONSTRAINT fk_t_regiao FOREIGN KEY (cd_regiao)
        REFERENCES t_regiao (cd_regiao);

INSERT INTO T_REGIAO(cd_regiao, nm_regiao)
VALUES (default, 'NORTE');
INSERT INTO T_DOENCA(cd_doenca, nm_doenca)
VALUES (default, 'DENGUE');

-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             3
-- CREATE INDEX                             0
-- ALTER TABLE                              5
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 5
