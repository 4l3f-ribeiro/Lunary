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

 


    public String getNovaATT() {
        return novaATT;
    }

    public void setNovaATT(String novaATT) {
        this.novaATT = novaATT;
    }
    private String novaATT;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    private String texto;
    private int acerto;
    private int erro;
    private int tempo;

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
    private String diaSemana;

    public int getErrototal() {
        return errototal;
    }

    public void setErrototal(int errototal) {
        this.errototal = errototal;
    }

    public int getAcertototal() {
        return acertototal;
    }

    public void setAcertototal(int acertototal) {
        this.acertototal = acertototal;
    }
    private int errototal;
    private int acertototal;

    public int getNaoAbrir() {
        return naoAbrir;
    }

    public void setNaoAbrir(int naoAbrir) {
        this.naoAbrir = naoAbrir;
    }
    private int naoAbrir;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    private int total;

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
