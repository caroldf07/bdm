package br.com.bdm.script;

import java.io.IOException;

public class ScriptConversaoEndereco {

    public static void executarScript() {
        Process process;

        try {
            process = Runtime.getRuntime().exec("python localizacao.py");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
