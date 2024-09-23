import model.Usuario;
import repository.UsuarioRepository;

public class Main {

    public static void main(String[] args){
        Usuario u1 = new Usuario("Pedro", "12345678901", "Rua veriador pedro", "1994/04/28", 0, false);
        try{
            UsuarioRepository ur = new UsuarioRepository();
            ur.criarUsuario(u1);
            System.out.println("Sucesso!");
        }catch (Exception e){
            System.err.println("Erro: "+e.getMessage()+"\nErro Específico: "+e.getCause());
        }
    }

}
