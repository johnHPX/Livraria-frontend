package controller;

import model.Funcionario;
import repository.FuncionarioRepository;
import util.TratamentoException;

public class FuncionarioController {

    public Funcionario Logar(String login, String senha) throws TratamentoException {
        try{
            FuncionarioRepository fr = new FuncionarioRepository();
            Funcionario f  = fr.LoginFuncionario(login, senha);
            return f;
        }catch (TratamentoException e){
            throw new util.TratamentoException(e.getMessage(), e.getCause());
        }
    }

}
