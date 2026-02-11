/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ymanz
 */
public class classUsuario {
    private String nome;
    private String email;
    private String senha;
    private int acerto;
    private int erro;
    private int tempo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int id;

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    

    public int getAcerto() {
        return acerto;
    }

    public void setAcerto(int acerto) {
        this.acerto = acerto;
    }

    public int getErro() {
        return erro;
    }

    public void setErro(int erro) {
        this.erro = erro;
    }
  
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
   public class Session {
    private static classUsuario usuarioLogado;

    public static classUsuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(classUsuario usuario) {
        usuarioLogado = usuario;
    }
}
}
