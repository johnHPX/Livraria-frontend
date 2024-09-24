package controller;

import model.Funcionario;
import repository.FuncionarioRepository;

public class FuncionarioController {

    public Funcionario Logar(String login, String senha){
        try{
            FuncionarioRepository fr = new FuncionarioRepository();
            Funcionario f = fr.LoginFuncionario(login, senha);
            return f;
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro especifico: "+e.getCause());
            return null;
        }
    }



}
