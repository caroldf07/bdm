-- Cadastro doença:
INSERT INTO T_DOENCA(cd_doenca, nm_doenca) VALUES ('[CD_DOENCA]', '[NOME_DOENCA]');

-- Atualização doença:
UPDATE T_DOENCA SET nm_doenca = '[NOME_DOENCA]' WHERE cd_doenca = '[CD_DOENCA]';

-- Buscar todas as doenças:
SELECT * FROM T_DOENCA;

-- Busca doença por código:
SELECT * FROM T_DOENCA WHERE cd_doenca = '[CD_DOENCA]';

-- Busca doença por nome:
SELECT * FROM T_DOENCA WHERE nm_doenca = '[NOME_DOENCA]';

-- Cadastro Região:
INSERT INTO T_REGIAO(cd_regiao, nm_regiao) VALUES ('[CD_REGIAO]','[NOME_REGIAO]');

-- Atualização Região:
UPDATE T_REGIAO SET nm_regiao = '[NOME_REGIAO]' WHERE cd_regiao = '[CD_REGIAO]';

-- Buscar todas as regiões:
SELECT * FROM T_REGIAO;

-- Busca Região por código:
SELECT * FROM T_REGIAO WHERE cd_regiao = '[CD_REGIAO]';

-- Busca Região por nome:
SELECT * FROM T_REGIAO WHERE nm_regiao = '[NOME_REGIAO]';

-- Registro de Ocorrência:
INSERT INTO T_CONSULTA_OCORRENCIA(cd_ocorrencia, dt_inicio_ocorrencia, dt_fim_ocorrencia, latitude, longitude, cd_doenca, cd_regiao, gravidade, comorbidade) VALUES ('[CD_OCORRENCIA]', TO_DATE('[DATA_INICIO_OCORRENCIA]','DD/MM/YYYY'), TO_DATE('[DATA_FIM_OCORRENCIA]','DD/MM/YYYY'), '[LATITUDE]', '[LONGITUDE]', '[CD_DOENCA]', '[CD_REGIAO]', '[GRAVIDADE]', '[COMORBIDADE]');
INSERT INTO T_CONSULTA_OCORRENCIA(cd_ocorrencia, dt_inicio_ocorrencia, dt_fim_ocorrencia, latitude, longitude, cd_doenca, cd_regiao, gravidade, comorbidade) VALUES ('[CD_OCORRENCIA]', TO_DATE('[DATA_INICIO_OCORRENCIA]','DD/MM/YYYY'), TO_DATE('[DATA_FIM_OCORRENCIA]','DD/MM/YYYY'), '[LATITUDE]', '[LONGITUDE]', (SELECT cd_doenca FROM T_DOENCA WHERE nm_doenca = '[NOME_DOENCA]'), (SELECT cd_regiao FROM T_REGIAO WHERE nm_regiao = '[NOME_REGIAO]'), '[GRAVIDADE]', '[COMORBIDADE]');

-- Alteração de Ocorrência:
UPDATE T_CONSULTA_OCORRENCIA SET dt_inicio_ocorrencia = TO_DATE('[DATA_INICIO_OCORRENCIA]', 'DD/MM/YYYY'), dt_fim_ocorrencia = TO_DATE('[DATA_FIM_OCORRENCIA]','DD/MM/YYYY'), latitude = '[LATITUDE]', longitude = '[LONGITUDE]', cd_doenca = '[CD_DOENCA]', cd_regiao = '[CD_REGIAO]', gravidade = '[GRAVIDADE]', comorbidade = '[COMORBIDADE]' WHERE cd_ocorrencia = '[CD_OCORRENCIA]';

-- Listar todas as ocorrências:
SELECT * FROM T_CONSULTA_OCORRENCIA ORDER BY dt_inicio_ocorrencia; 

-- Buscar ocorrências por código:
SELECT * FROM T_CONSULTA_OCORRENCIA WHERE cd_ocorrencia = '[CD_OCORRENCIA]';

-- Listar ocorrências por doença (busca por código da doença):
SELECT * FROM T_CONSULTA_OCORRENCIA WHERE cd_doenca = '[CD_DOENCA]' ORDER BY dt_inicio_ocorrencia;

-- Listar ocorrências por doença (Buscar por nome da doença):
SELECT * FROM T_CONSULTA_OCORRENCIA WHERE cd_doenca = (SELECT cd_doenca FROM T_DOENCA WHERE nm_doenca = '[NOME_DOENCA]') ORDER BY dt_inicio_ocorrencia;

-- Listar ocorrências por região (buscar por código da região):
SELECT * FROM T_CONSULTA_OCORRENCIA WHERE cd_regiao = '[CD_REGIAO]' ORDER BY dt_inicio_ocorrencia;

-- Lista ocorrências por região (buscar por nome da região):
SELECT * FROM T_CONSULTA_OCORRENCIA WHERE cd_regiao = (SELECT cd_regiao FROM T_REGIAO WHERE nm_regiao = '[NOME_REGIAO]') ORDER BY dt_inicio_ocorrencia;

-- Listar ocorrência por comorbidade:
SELECT * FROM T_CONSULTA_OCORRENCIA WHERE comorbidade = '[COMORBIDADE]' ORDER BY dt_inicio_ocorrencia;

-- Listar ocorrência por gravidade:
SELECT * FROM T_CONSULTA_OCORRENCIA WHERE gravidade = '[GRAVIDADE]' ORDER BY dt_inicio_ocorrencia;

-- listar ocorrência por latitude e longitude:
SELECT * FROM T_CONSULTA_OCORRENCIA WHERE latitude = '[LATITUDE]' AND longitude = '[LONGITUDE]' ORDER BY dt_inicio_ocorrencia;

-- Listar ocorrência por data de ínicio:
SELECT * FROM T_CONSULTA_OCORRENCIA WHERE dt_inicio_ocorrencia = TO_DATE('[DATA_INICIO_OCORRENCIA]', 'DD/MM/YYYY')  ORDER BY dt_inicio_ocorrencia;

-- Listar ocorrência por data de fim:
SELECT * FROM T_CONSULTA_OCORRENCIA WHERE dt_fim_ocorrencia = TO_DATE('[DATA_FIM_OCORRENCIA]', 'DD/MM/YYYY') ORDER BY dt_inicio_ocorrencia;

-- Listar ocorrência por data de início e data de fim:
SELECT * FROM T_CONSULTA_OCORRENCIA WHERE dt_inicio_ocorrencia = TO_DATE('[DATA_INICIO_OCORRENCIA]', 'DD/MM/YYYY') AND dt_fim_ocorrencia = TO_DATE('[DATA_FIM_OCORRENCIA]', 'DD/MM/YYYY') ORDER BY dt_inicio_ocorrencia;