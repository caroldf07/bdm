package br.com.bdm;

import br.com.bdm.dao.OcorrenciaDao;
import br.com.bdm.view.Endereco;
import br.com.bdm.view.OcorrenciaDto;

import java.time.LocalDateTime;

public class Executavel {
    public static void main(String[] args) {
        /*Executar o método insert*/
        OcorrenciaDto ocorrenciaDto = new OcorrenciaDto(LocalDateTime.now(), new Endereco(
                "Rua Oseias Rocha Ramalho", "49", "São Carlos", "SP"),
                "severa", "dengue", "norte",
                "");
        OcorrenciaDao ocorrenciaDao = new OcorrenciaDao();
        System.out.println(ocorrenciaDao.registrarOcorrencia(ocorrenciaDto));
    }
}
