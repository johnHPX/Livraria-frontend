package view;

import controller.FuncionarioController;
import model.Funcionario;
import util.ErrorLogin;
import util.TratamentoException;

import java.util.Scanner;

public class FuncionarioView {

    public void menuLogin() throws ErrorLogin, TratamentoException {
        Scanner ler = new Scanner(System.in);
        System.out.print("CPF: ");
        String cpf = ler.nextLine();
        System.out.print("Senha: ");
        String senha = ler.nextLine();

        FuncionarioController fc = new FuncionarioController();
        Funcionario funcionario = fc.Logar(cpf, senha);
        if (funcionario.getId() == 0){
            throw new ErrorLogin();
        }
    }

}
