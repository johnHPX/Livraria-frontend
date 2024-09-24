package view;

import controller.UsuarioController;
import model.Usuario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UsuarioView {

    private void telaCriarUsuario(){
        Scanner ler = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.print("NOME: ");
        String nome = ler.nextLine();
        System.out.print("CPF: ");
        String cpf = ler.nextLine();
        System.out.print("ENDEREÇO: ");
        String endereco = ler.nextLine();
        System.out.print("DATA DE NASCIMENTO: ");
        String dataNasc = ler.nextLine();

        UsuarioController uc = new UsuarioController();
        boolean ok = uc.cadastrar(nome, cpf, endereco, dataNasc, 0, false);
        System.out.println("---------------------------------");
        if (!ok){
            System.out.println("ERRO AO CADASTRAR USUÁRIO :(");
            System.out.println("TENTE NOVAMENTE MAIS TARDE!");
        }else{
            System.out.println("USUÁRIO CADASTRADO COM SUCESSO :)");
        }
        System.out.println("---------------------------------");
    }

    private void telaListarUsuario(){
        UsuarioController uc = new UsuarioController();
        ArrayList<Usuario> usuarios = uc.listar();
        System.out.println("============================================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\tUSUÁRIOS CADASTRADOS");
        for (Usuario u: usuarios){
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("\t%-5s %-20s %-15s %-30s %-20s %-12s %-10s%n",
                    "ID", "NOME", "CPF", "ENDERECO", "DATA DE NASCIMENTO", "LIVROS PEGOS", "ESTÁ DEVENDO");
            System.out.println("............................................................................................................................");
            System.out.printf("\t%-5d %-20s %-15s %-30s %-20s %-12d %-10s%n",
                    u.getId(),
                    u.getNome(),
                    u.getCpf(),
                    u.getEndereco(),
                    u.getDataNasc(),
                    u.getQtdLivros(),
                    u.isDevendo() ? "Sim" : "Não");
        }
        System.out.println("============================================================================================================================");
    }

    private void telaEditarUsuario(){
        Scanner ler = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.print("ID: ");
        int id = ler.nextInt();
        ler.nextLine();
        System.out.print("NOME: ");
        String nome = ler.nextLine();
        System.out.print("CPF: ");
        String cpf = ler.nextLine();
        System.out.print("ENDEREÇO: ");
        String endereco = ler.nextLine();
        System.out.print("DATA DE NASCIMENTO: ");
        String dataNasc = ler.nextLine();
        System.out.print("QUANTOS LIVROS EMPRESTADOS? ");
        int qtdLivros = ler.nextInt();
        System.out.print("ESTÁ DEVENDO? ");
        boolean estaDevendo = ler.nextBoolean();

        UsuarioController uc = new UsuarioController();
        boolean ok = uc.editar(id, nome, cpf, endereco, dataNasc, qtdLivros, estaDevendo);
        System.out.println("---------------------------------");
        if (!ok){
            System.out.println("ERRO AO EDITAR USUÁRIO :(");
            System.out.println("TENTE NOVAMENTE MAIS TARDE!");
        }else{
            System.out.println("USUÁRIO EDITADO COM SUCESSO :)");
        }
        System.out.println("---------------------------------");
    }

    private void telaRemoverUsuario(){
        Scanner ler = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.print("ID: ");
        int id = ler.nextInt();

        UsuarioController uc = new UsuarioController();
        boolean ok = uc.remover(id);
        System.out.println("---------------------------------");
        if (!ok){
            System.out.println("ERRO AO REMOVER USUÁRIO :(");
            System.out.println("TENTE NOVAMENTE MAIS TARDE!");
        }else{
            System.out.println("USUÁRIO REMOVIDO COM SUCESSO :)");
        }
        System.out.println("---------------------------------");
    }

    public void menuUsuario() throws InterruptedException {
        Scanner ler = new Scanner(System.in);
        int op = 1;
        while (op != 6){
            System.out.println("\t1 - CADASTRAR USUÁRIO\t\t");
            System.out.println("\t2 - BUSCAR USUÁRIO\t\t");
            System.out.println("\t3 - LISTAR USUÁRIOS\t\t");
            System.out.println("\t4 - EDITAR USUÁRIO\t\t");
            System.out.println("\t5 - REMOVER USUÁRIO\t\t");
            System.out.println("\t6 - VOLTAR AO MENU PRINCIPAL\t\t\t\t");
            System.out.println("---------------------------------");
            try{
                System.out.print("\tOPÇÃO: ");
                op = ler.nextInt();
                switch (op){
                    case 1:
                        telaCriarUsuario();
                        break;
                    case 2:
                        break;
                    case 3:
                        telaListarUsuario();
                        break;
                    case 4:
                        telaEditarUsuario();
                        break;
                    case 5:
                        telaRemoverUsuario();
                        break;
                    default:
                        op = 6;
                        break;
                }
            }catch (InputMismatchException e){
                System.err.println("VOCÊ DIGITOU UM VALOR INVALIDO\nDIGITE UM NÚMERO INTEIRO COM BASE NAS OPÇÕES DO MENU");
                Thread.sleep(500);
                System.out.println("---------------------------------");
                ler.nextLine();
            }
        }

    }

}
