package view;

import util.ErrorLogin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfacePrograma {

    public static void cabecalho(){
        System.out.println("===================================");
        System.out.println("\t\tBIBLIOTECA IFCE V0.1\t\t");
        System.out.println("===================================");
    }

    public void rodape() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("-----------------------------------");
        System.out.println("\t\tPROGRAMA ENCERRADO\t\t");
        System.out.println("___________________________________");
        System.exit(0);
    }

    public void menuPrincipal() throws InterruptedException {
        try{
            System.out.println("\t\t\tLOGIN\t\t");
            FuncionarioView fv = new FuncionarioView();
            fv.menuLogin();
            Scanner ler = new Scanner(System.in);
            while(true){
                System.out.println("---------------------------------");
                System.out.println("\t\t\tPRINCIPAL\t\t");
                System.out.println("\t\tFUNCIONARIO: John\t\t");
                System.out.println("---------------------------------");
                System.out.println("\t\t1 - ALUGAR\t\t");
                System.out.println("\t\t2 - EXPIRADOS\t\t");
                System.out.println("\t\t3 - LIVROS\t\t");
                System.out.println("\t\t4 - USUARIOS\t\t");
                System.out.println("\t\t5 - DESLOGAR\t\t");
                try{
                    System.out.print("\t\tOPÇÃO: ");
                    int op = ler.nextInt();
                    switch (op){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            System.out.println("---------------------------------");
                            UsuarioView uv = new UsuarioView();
                            uv.menuUsuario();
                            break;
                        default:
                            ler.close();
                            rodape();
                    }
                }catch (InputMismatchException e){
                    System.err.println("VOCÊ DIGITOU UM VALOR INVALIDO\nDIGITE UM NÚMERO INTEIRO COM BASE NAS OPÇÕES DO MENU");
                    ler.nextLine(); // Limpar o buffer anterior
                    Thread.sleep(500);
                }
            }
        } catch (ErrorLogin e){
            System.err.println(e.getMessage());
            rodape();
        }
    }

    public void start() throws InterruptedException {
        cabecalho();
        menuPrincipal();
    }
}
