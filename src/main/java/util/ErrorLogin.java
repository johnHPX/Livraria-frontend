package util;

public class ErrorLogin extends Exception{

    public ErrorLogin(){
        super("FUNCIONÁRIO NÃO INDENTIFICADO.\nVERIFIQUE SUAS CREDENCIAIS E TENTE NOVAMENTE.", new Throwable("NÃO REGISTRADO NO BANCO DE DADOS"));
    }

}
