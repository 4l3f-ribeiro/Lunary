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
import java.util.Vector;
import javax.swing.JOptionPane;

/**

 * @author ymanz
 */

public class conUsuario {
    
 
   

    public void Cadastrar(classUsuario obj) throws SQLException {
        classConexao conexao = new classConexao();

        
        String sqlVerificao = "SELECT COUNT(*) FROM aluno where nome = ? and email = ?";
        PreparedStatement psmtVerificar = conexao.conectar().prepareStatement(sqlVerificao);
        psmtVerificar.setString(1, obj.getNome());
        psmtVerificar.setString(2, obj.getEmail());
        
        ResultSet rs  = psmtVerificar.executeQuery();
        rs.next();
        
        if(rs.getInt(1)>0){
             JOptionPane.showMessageDialog(null, 
                    "Erro: Esse Nome ou Email já está cadastrado!", "Cadastro Duplicado", JOptionPane.ERROR_MESSAGE);
            int naoentrar = 1;
            obj.setNaoAbrir(naoentrar);
        }
        
        else{
             String sqlAluno = "INSERT INTO aluno(id, nome, email, senha, codcronometro) VALUES (null, ?, ?, ?, ?)";
        PreparedStatement psmtAluno = conexao.conectar().prepareStatement(sqlAluno, PreparedStatement.RETURN_GENERATED_KEYS);
        
        psmtAluno.setString(1, obj.getNome());
        psmtAluno.setString(2, obj.getEmail());
        psmtAluno.setString(3, obj.getSenha());

        int codcrono = 0;
        psmtAluno.setInt(4, codcrono);

        psmtAluno.executeUpdate();

        ResultSet rsAluno = psmtAluno.getGeneratedKeys();
        int idAluno = 0;
        if (rsAluno.next()) {
            idAluno = rsAluno.getInt(1); 
        }

        rsAluno.close();
        psmtAluno.close();

       
        String sqlCronometro = "INSERT INTO cronometro (codaluno, tempomensal, temposemanal, tempo) VALUES (?, 0, 0, 0)";
        PreparedStatement psmtCronometro = conexao.conectar().prepareStatement(sqlCronometro, PreparedStatement.RETURN_GENERATED_KEYS);

        psmtCronometro.setInt(1, idAluno);
        psmtCronometro.executeUpdate();

        ResultSet rsCronometro = psmtCronometro.getGeneratedKeys();
        int idCronometro = 0;
        if (rsCronometro.next()) {
            idCronometro = rsCronometro.getInt(1);
        }

        
        String sqlAtualizarAluno = "UPDATE aluno SET codcronometro = ? WHERE id = ?";
        PreparedStatement psmtAtualizarAluno = conexao.conectar().prepareStatement(sqlAtualizarAluno);
        psmtAtualizarAluno.setInt(1, idCronometro);
        psmtAtualizarAluno.setInt(2, idAluno);
        psmtAtualizarAluno.executeUpdate();

        
        String sqlInserirPontuacao = "INSERT INTO pontuacao (codaluno, total, acerto, erro) VALUES (?, 0, 0, 0)";
        PreparedStatement psmtPontuacao = conexao.conectar().prepareStatement(sqlInserirPontuacao, PreparedStatement.RETURN_GENERATED_KEYS);
        psmtPontuacao.setInt(1, idAluno);
        
        psmtPontuacao.executeUpdate();

        
        ResultSet rsPontuacao = psmtPontuacao.getGeneratedKeys();
        int idPontuacao = 0;
        if (rsPontuacao.next()) {
            idPontuacao = rsPontuacao.getInt(1);
        }

        rsPontuacao.close();
        psmtPontuacao.close();

        
        String sqlAtualizarPontuacao = "UPDATE aluno SET codpontuacao = ? WHERE id = ?";
        PreparedStatement psmtAtualizarPontuacao = conexao.conectar().prepareStatement(sqlAtualizarPontuacao);
        psmtAtualizarPontuacao.setInt(1, idPontuacao); 
        psmtAtualizarPontuacao.setInt(2, idAluno);
        psmtAtualizarPontuacao.executeUpdate();
        }
       
        
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
                         c.tempo,
                         p.total
                         
                     FROM 
                         aluno a
                     LEFT JOIN 
                         pontuacao p ON a.codpontuacao = p.idpontuacao LEFT JOIN cronometro c ON c.idcronometro = a.id  WHERE a.email = ? AND a.senha = ?"""
        ;
        PreparedStatement psmt = conexao.conectar().prepareStatement(sql);
        psmt.setString(1, objLogin.getEmail());
        psmt.setString(2, objLogin.getSenha());
        
        ResultSet rs = psmt.executeQuery();

        
        if (rs.next()) {
          
            objLogin.setNome(rs.getString("nome"));
            objLogin.setEmail(rs.getString("email"));
            objLogin.setAcerto(rs.getInt("acerto"));
            objLogin.setErro(rs.getInt("erro"));
            objLogin.setId(rs.getInt("id"));
            objLogin.setTempo(rs.getInt("tempo"));
            objLogin.setTotal(rs.getInt("total"));
            
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
    
     

     
     

        
    
       
 
    public void attTempo(classUsuario objLogin) throws SQLException {
    classUsuario usuarioLogado = classUsuario.Session.getUsuarioLogado();
    classConexao conexao = new classConexao();
   
    
    int tempo = objLogin.getTempo();
   

     
       
        
        
        
        String sqlUpdate = "UPDATE cronometro c JOIN aluno a ON a.codcronometro = c.idcronometro SET c.tempo = ? WHERE a.id = ?";
        PreparedStatement psmtUpdate = conexao.conectar().prepareStatement(sqlUpdate);

       
        psmtUpdate.setInt(1,tempo);
        psmtUpdate.setInt(2, usuarioLogado.getId());

        usuarioLogado.setTempo(tempo);
        int linhasAfetadas = psmtUpdate.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Tempo atualizado com sucesso para o id " + usuarioLogado.getId());
        } else {
            System.out.println("Falha ao atualizar o tempo.");
        }
        

        
    }
 public void attAcertos(classUsuario objLogin) throws SQLException {
    classUsuario usuarioLogado = classUsuario.Session.getUsuarioLogado();
    classConexao conexao = new classConexao();

    int acertos = objLogin.getAcerto();
    int acc = usuarioLogado.getAcerto();
    int total = acertos + acc;
    

    String sqlUpdate = "UPDATE pontuacao p JOIN aluno a ON a.codpontuacao = p.idpontuacao SET p.acerto = ? WHERE a.id = ?";

    try (PreparedStatement psmtUpdate = conexao.conectar().prepareStatement(sqlUpdate)) {
        psmtUpdate.setInt(1, total);
        
        psmtUpdate.setInt(2, usuarioLogado.getId());

        psmtUpdate.executeUpdate();
        
        
        usuarioLogado.setAcerto(total);
        
    } catch (SQLException e) {
       
        e.printStackTrace();
        throw new SQLException("Erro ao atualizar os acertos e erros.", e);
    }
}
public void attErro(classUsuario objLogin) throws SQLException {
    classUsuario usuarioLogado = classUsuario.Session.getUsuarioLogado();
    classConexao conexao = new classConexao();

    int erros = objLogin.getErro();
    int erradas = usuarioLogado.getErro();
    int total1 = erradas + erros;
    

    String sqlUpdate = "UPDATE pontuacao p JOIN aluno a ON a.codpontuacao = p.idpontuacao SET p.erro = ? WHERE a.id = ?";

    try (PreparedStatement psmtUpdate = conexao.conectar().prepareStatement(sqlUpdate)) {
        psmtUpdate.setInt(1, total1);
        
        psmtUpdate.setInt(2, usuarioLogado.getId());

        psmtUpdate.executeUpdate();
        
        
        usuarioLogado.setErro(total1);
        
    } catch (SQLException e) {
       
        e.printStackTrace();
        throw new SQLException("Erro ao atualizar os acertos e erros.", e);
    }
}
public void attTotal(classUsuario objLogin)throws SQLException{
    classUsuario usuarioLogado = classUsuario.Session.getUsuarioLogado();
    classConexao conexao = new classConexao();
    
    int erros = objLogin.getErrototal();
    int acertos = objLogin.getAcertototal();
    int totalbanco = usuarioLogado.getTotal();
    
    int ae = erros + acertos;
    
    int total = totalbanco + ae;
    
   
    
    
    String sqlUpdate = "UPDATE pontuacao p JOIN aluno a ON a.codpontuacao = p.idpontuacao SET p.total = ? WHERE a.id = ?";
    
      try (PreparedStatement psmtUpdate = conexao.conectar().prepareStatement(sqlUpdate)) {
        psmtUpdate.setInt(1, total);
        
        psmtUpdate.setInt(2, usuarioLogado.getId());

        psmtUpdate.executeUpdate();
        
        
        usuarioLogado.setTotal(total);
        
    } catch (SQLException e) {
       
        e.printStackTrace();
        throw new SQLException("Erro ao atualizar os acertos e erros.", e);
    }
}
public void enviarCronograma(classUsuario usu)throws SQLException{
    classUsuario usuarioLogado = classUsuario.Session.getUsuarioLogado();
    classConexao conexao = new classConexao();
    String diaSemana = usu.getDiaSemana();
    String text = usu.getTexto();
    int id =  usuarioLogado.getId();
    
    
    String sqlEnviar = "INSERT INTO cronograma (dia,atividade,codaluno) VALUES (?,?,?)";
    PreparedStatement psmtcronograma = conexao.conectar().prepareStatement(sqlEnviar);
        psmtcronograma.setString(1, diaSemana);
        psmtcronograma.setString(2, text);
        psmtcronograma.setInt(3, id);
        psmtcronograma.executeUpdate();

       
}
public Vector buscarCronograma() {
    
 Vector lista = new Vector();
classConexao conexao = new classConexao();
classUsuario usuarioLogado = classUsuario.Session.getUsuarioLogado();
int id = usuarioLogado.getId();

String sqlBuscar = """
     SELECT c.dia, c.atividade
     FROM cronograma c
     JOIN aluno a ON a.id = c.codaluno
     WHERE a.id = ?
     ORDER BY FIELD(c.dia, 'segunda', 'terca', 'quarta', 'quinta', 'sexta', 'sabado', 'domingo');
    """;

try {
    PreparedStatement psmtcronograma = conexao.conectar().prepareStatement(sqlBuscar);
    psmtcronograma.setInt(1, id);

    ResultSet rs = psmtcronograma.executeQuery();

   
   
   

    while (rs.next()) {
        classUsuario usu = new classUsuario();
        usu.setDiaSemana(rs.getString("dia"));
        usu.setTexto(rs.getString("atividade"));
       
        
        Vector novalinha = new Vector();
        
        novalinha.addElement(usu.getDiaSemana());
        novalinha.addElement(usu.getTexto());
        lista.addElement(novalinha);
    }

    
    

} catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Erro ao buscar cronograma: " + ex.getMessage());
    ex.printStackTrace();
}

return lista;



}
public void alterarAtividade(classUsuario usu) throws SQLException{
    classConexao conexao = new classConexao();
classUsuario usuarioLogado = classUsuario.Session.getUsuarioLogado();
int id = usuarioLogado.getId();


String sql = "UPDATE cronograma SET atividade = ? WHERE codaluno = ? AND atividade = ?";
try (PreparedStatement psmtcronograma = conexao.conectar().prepareStatement(sql)) {

    psmtcronograma.setString(1, usu.getNovaATT()); 
    psmtcronograma.setInt(2, id);                
    psmtcronograma.setString(3, usu.getTexto()); 
    int linhasAtualizadas = psmtcronograma.executeUpdate();

    
    if (linhasAtualizadas > 0) {
        System.out.println("Atividade atualizada com sucesso!");
    } else {
        System.out.println("Nenhuma atividade encontrada para atualizar.");
    }
} catch (SQLException ex) {
    ex.printStackTrace();
    System.err.println("Erro ao atualizar a atividade: " + ex.getMessage());
}

}
public void excluir(classUsuario usu)throws SQLException{
    classUsuario usuarioLogado = classUsuario.Session.getUsuarioLogado();
    classConexao conexao = new classConexao();
    String sqlExcluir="delete from aluno where id=?";
    PreparedStatement psmtexcluir = conexao.conectar().prepareStatement(sqlExcluir);
    
    psmtexcluir.setInt(1,usuarioLogado.getId());
    
    psmtexcluir.executeUpdate();
    
    
}
}

   

     
      

   

