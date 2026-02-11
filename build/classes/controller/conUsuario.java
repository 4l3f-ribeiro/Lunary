/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.classConexao;
import model.classUsuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**

 * @author ymanz
 */

public class conUsuario {
    public void Cadastrar (classUsuario obj)throws SQLException{
        classConexao conexao = new classConexao();
        
        String sql="Insert into aluno(id,nome,email,senha)"+"values(null,?,?,?)";
        PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
        
        psmt.setString(1, obj.getNome());
        psmt.setString(2, obj.getEmail());
        psmt.setString(3, obj.getSenha());
        
        
        
        psmt.executeUpdate();
        
    }
    public boolean Login(classUsuario objLogin) {
    classConexao conexao = new classConexao();
    boolean usuarioEncontrado = false;
    
    try {
        String sql = """
                     SELECT 
                         a.id, 
                         a.nome, 
                         a.email, 
                         p.total, 
                         p.erro, 
                         p.acerto,
                         c.tempo
                         
                     FROM 
                         aluno a
                     LEFT JOIN 
                         pontuacao p ON a.codpontuacao = p.idpontuacao LEFT JOIN cronometro c ON c.idcronometro = a.id  WHERE a.email = ? AND a.senha = ?""" //pega os dados msm sem nada em pontuacao
        ;
        PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
        psmt.setString(1, objLogin.getEmail());
        psmt.setString(2, objLogin.getSenha());
        
        ResultSet rs = psmt.executeQuery();

        // Verifica se encontrou algum registro
        if (rs.next()) {
            // Caso o usuário seja encontrado, define os dados do objeto
            objLogin.setNome(rs.getString("nome"));
            objLogin.setEmail(rs.getString("email"));
            objLogin.setAcerto(rs.getInt("acerto"));
            objLogin.setErro(rs.getInt("erro"));
            objLogin.setId(rs.getInt("id"));
            objLogin.setTempo(rs.getInt("tempo"));
            
            usuarioEncontrado = true;
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
        }

        // Fecha ResultSet após o uso para nao dar erro
        rs.close();
        psmt.close();
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar usuário: " + erro.getMessage());
    } 
    return usuarioEncontrado;
}
    
      public ResultSet MudarSenha(String senha){
        classConexao conexao = new classConexao();
        try{
              String sql = "SELECT * FROM aluno where email=?";
        PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
        psmt.setString(1,senha);
        
        ResultSet rs = psmt.executeQuery();
        return rs;
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Usuario nao encontrado");
            return null;
        }
}
     
      public int tempo() throws SQLException {
    // Criando a conexão
    classConexao conexao = new classConexao();
    classUsuario usuarioLogado = classUsuario.Session.getUsuarioLogado();
    
    // SQL para buscar o tempo do aluno logado
    String sql = "SELECT c.tempo FROM cronometro c JOIN aluno a ON c.codaluno = a.id WHERE a.id = ?";
    
    // Usando try-with-resources para garantir o fechamento dos recursos
    try (PreparedStatement psmt = conexao.conectar().prepareStatement(sql)) {
        // Definindo o ID do aluno logado na consulta
        psmt.setInt(1, usuarioLogado.getId());
        
        // Executando a consulta
        try (ResultSet rs = psmt.executeQuery()) {
            // Verificando se o resultado foi encontrado
            if (rs.next()) {
                // Recuperando o tempo
                int tempo = rs.getInt("tempo");
                
                // Atualizando o tempo do usuário logado, se necessário
                usuarioLogado.setTempo(tempo);
                
                // Retornando o tempo
                return tempo;
            }
        }
    } catch (SQLException e) {
        // Tratar exceção de SQL
        e.printStackTrace();
    }
    
    // Se não encontrar o tempo, retornará 0
    return 0;
}

        
    
       
 
      public void attTempo(classUsuario objLogin)throws SQLException{
          classUsuario usuarioLogado = classUsuario.Session.getUsuarioLogado();
          classConexao conexao = new classConexao();
          
          String sql ="UPDATE cronometro c JOIN aluno a ON c.idcronometro = a.codcronometro SET c.tempo = c.tempo + ? where a.id=? ";
          PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
          int tempoParaAdicionar = usuarioLogado.getTempo();
          int id = usuarioLogado.getId();
          psmt.setInt(1, tempoParaAdicionar);
          psmt.setInt(2, usuarioLogado.getId());
          
          int linhasAfetadas = psmt.executeUpdate();
          
          if (linhasAfetadas > 0) {
        System.out.println("Tempo atualizado com sucesso do id"+id);
    } else {
        System.out.println("Falha ao atualizar o tempo.");
    }
      }
     
      }

   

