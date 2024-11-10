package br.com.fiap.fintech.fintechgrandfinale.view.usuario;

import br.com.fiap.fintech.fintechgrandfinale.dao.TransacaoDao;
import br.com.fiap.fintech.fintechgrandfinale.dao.UsuarioDao;
import br.com.fiap.fintech.fintechgrandfinale.exception.NenhumRegistroEncontradoException;
import br.com.fiap.fintech.fintechgrandfinale.model.Transacao;
import br.com.fiap.fintech.fintechgrandfinale.model.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class ListarUsuariosView {
    public static void main(String[] args){
//        try{
//            UsuarioDao usuarioDao = new UsuarioDao();
//
//            List<Usuario> usuarios = usuarioDao.getAll();
//
//            for (Usuario usuario : usuarios){
//                DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//                System.out.println();
//                System.out.println("Id: " + usuario.getId_usuario());
//                System.out.println("Nome: " + usuario.getNome());
//                System.out.println("Email: " + usuario.getEmail());
//                System.out.println("Login: " + usuario.getLogin());
//                System.out.println("Senha: " + usuario.getSenha());
//                System.out.println("DATA do cadastro: " + LocalDate.parse(usuario.getDt_cadastro().toString()).format(dataFormatada));
//                System.out.println("Ativo: " + usuario.getAtivo());
//                System.out.println();
//            }
//            usuarioDao.fecharConexao();
//
//        }catch(SQLException e) {
//            System.err.println("Erro de SQL: " + e.getMessage());
//        }catch(NenhumRegistroEncontradoException e) {
//            System.err.println("Erro: " + e.getMessage());
//        }

//        try{
//            UsuarioDao usuarioDao = new UsuarioDao();
//
//            Usuario usuario = new Usuario();
//            usuario.setNome("Teste Dao");
//            usuario.setEmail("testeDao@teste.com");
//            usuario.setLogin("testeDao");
//            usuario.setSenha("54321");
//            usuario.setDt_cadastro(new Date());
//            usuarioDao.cadastrarUsuario(usuario);
//            usuarioDao.fecharConexao();
//        }catch (SQLException e){
//            System.err.println("Erro de SQL: " + e.getMessage());
//        }

//        try{
//            UsuarioDao usuarioDao = new UsuarioDao();
//            boolean autenticado = usuarioDao.login("testeTestando@gmail.com", "12345");
//
//            if(autenticado){
//                System.out.println("logado");
//            }else{
//                System.out.println("não logado");
//            }
//            usuarioDao.fecharConexao();
//        }catch(SQLException e) {
//            System.err.println("Erro de SQL: " + e.getMessage());
//        }
    }
}
