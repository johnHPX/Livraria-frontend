package util;

public class ErrorLogin extends Exception{

    public ErrorLogin(){
        super("ERRO: FUNCIONÁRIO NÃO INDENTIFICADO.\nVERIFIQUE SUAS CREDENCIAIS E TENTE NOVAMENTE.");
    }

}
