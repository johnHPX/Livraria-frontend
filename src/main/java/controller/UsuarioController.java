package controller;

import model.Usuario;
import repository.UsuarioRepository;

import java.util.ArrayList;

public class UsuarioController {

    public boolean cadastrar(String nome, String cpf, String endereco, String dataNasc, int qtdLivros, boolean devendo){
        try{
            Usuario usuario = new Usuario(nome, cpf, endereco, dataNasc, qtdLivros, devendo);
            UsuarioRepository ur = new UsuarioRepository();
            ur.criarUsuario(usuario);
            return true;
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro especifico: "+e.getCause());
            return false;
        }
    }

    public ArrayList<Usuario> listar(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try{
            UsuarioRepository ur = new UsuarioRepository();
            usuarios = ur.listarTodosUsuario();
            return usuarios;
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro especifico: "+e.getCause());
            return null;
        }
    }

    public boolean editar(int id, String nome, String cpf, String endereco, String dataNasc, int qtdLivros, boolean devendo){
        try{
            Usuario usuario = new Usuario(nome, cpf, endereco, dataNasc, qtdLivros, devendo);
            usuario.setId(id);
            UsuarioRepository ur = new UsuarioRepository();
            ur.alterarUsuario(usuario);
            return true;
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro especifico: "+e.getCause());
            return false;
        }
    }

    public boolean remover(int id){
        try{
            UsuarioRepository ur = new UsuarioRepository();
            ur.removerUsuario(id);
            return true;
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage()+"\nErro especifico: "+e.getCause());
            return false;
        }
    }
}
