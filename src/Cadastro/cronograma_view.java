/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Cadastro;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlIJTheme;
import controller.conUsuario;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import model.classUsuario;

/**
 *
 * @author PC
 */
public class cronograma_view extends javax.swing.JFrame {
    int dia = 0; //variavel para mudar o texto do label
    String texto = ""; //armazena os valores colocados no campo de texto
   
    public cronograma_view() {
        initComponents();
        listar();
        dias();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        diaField = new javax.swing.JLabel();
        btnLista = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSegunda = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        campo = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton1.setText("<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton2.setText(">");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton3.setText("Enviar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        diaField.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        diaField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diaField.setText("Dia: ");

        btnLista.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnLista.setText("Listar Tarefas");
        btnLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaActionPerformed(evt);
            }
        });

        tbSegunda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbSegunda);

        btnAtualizar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnAtualizar.setText("Editar Atividade");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(diaField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnLista)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton3)
                                                .addGap(68, 68, 68)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButton4)))
                .addGap(0, 351, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(diaField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(textField, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(34, 34, 34)
                .addComponent(btnLista)
                .addGap(93, 93, 93)
                .addComponent(campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnAtualizar)
                .addGap(241, 241, 241))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
        
    }//GEN-LAST:event_textFieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        texto = textField.getText();//pegando o valor do campo de texto e adicionando a variavel texto
        
        
        textField.setText("");//limpando o campo de texto após enviar o texto
        classUsuario usu = new classUsuario();
        conUsuario con = new conUsuario();
        if(dia == 0){//segunda
            usu.setDiaSemana("Segunda");
            usu.setTexto(texto);
            try {
                con.enviarCronograma(usu);
            } catch (SQLException ex) {
                Logger.getLogger(cronograma_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(dia == 1){//terça
             usu.setDiaSemana("Terca");
             usu.setTexto(texto);
            try {
                con.enviarCronograma(usu);
            } catch (SQLException ex) {
                Logger.getLogger(cronograma_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(dia == 2){//quarta
             usu.setDiaSemana("Quarta");
             usu.setTexto(texto);
            try {
                con.enviarCronograma(usu);
                
            } catch (SQLException ex) {
                Logger.getLogger(cronograma_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(dia == 3){//quinta
             usu.setDiaSemana("Quinta");
             usu.setTexto(texto);
            try {
                con.enviarCronograma(usu);
            } catch (SQLException ex) {
                Logger.getLogger(cronograma_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(dia == 4){//sexta
             usu.setDiaSemana("Sexta");
             usu.setTexto(texto);
            try {
                con.enviarCronograma(usu);
            } catch (SQLException ex) {
                Logger.getLogger(cronograma_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(dia == 5){//sabado
             usu.setDiaSemana("Sabado");
             usu.setTexto(texto);
            try {
                con.enviarCronograma(usu);
            } catch (SQLException ex) {
                Logger.getLogger(cronograma_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(dia == 6){//domingo
             usu.setDiaSemana("Domingo");
             usu.setTexto(texto);
            try {
                con.enviarCronograma(usu);
            } catch (SQLException ex) {
                Logger.getLogger(cronograma_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaActionPerformed
                   
  listar();
  

    }//GEN-LAST:event_btnListaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dia += 1;

        if(dia > 6){
            dia = 0;
        }

        dias();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dia -= 1;

        if(dia < 0){
            dia = 6;
        }

        dias();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
   
    carregarEAtualizar();
    listar();
    
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        PrincipalPage page = new PrincipalPage();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        FlatNightOwlIJTheme.setup();
            

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cronograma_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnLista;
    private javax.swing.JTextField campo;
    private javax.swing.JLabel diaField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbSegunda;
    private javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables
    
    private void dias(){
        if(dia == 0){
            diaField.setText("Dia: Segunda");
        }else if(dia == 1){
            diaField.setText("Dia: Terça");
        }else if(dia == 2){
            diaField.setText("Dia: Quarta");
        }else if(dia == 3){
            diaField.setText("Dia: Quinta");
        }else if(dia == 4){
            diaField.setText("Dia: Sexta");
        }else if(dia == 5){
            diaField.setText("Dia: Sabado");
        }else if(dia == 6){
            diaField.setText("Dia: Domingo");
        }
    }
    
   
    
   
       private void carregarEAtualizar() {
    // Obter a linha selecionada na tabela
    int setar = tbSegunda.getSelectedRow(); 
    
    // Criar um objeto classUsuario para encapsular as informações
    classUsuario usu = new classUsuario();

    // Pegar o texto da célula da tabela e atribuí-lo ao objeto
    String textoAtual = tbSegunda.getModel().getValueAt(setar, 1).toString(); // Coluna 1 com a atividade atual
    String novoTexto = campo.getText(); // Novo valor a ser definido no campo

    // Configurar os valores no objeto classUsuario
    usu.setTexto(textoAtual);  // Valor atual (critério para a consulta)
    usu.setNovaATT(novoTexto); // Novo valor a ser atualizado

    // Criar uma instância do controlador e passar o objeto atualizado
    conUsuario con = new conUsuario();
    try {
        con.alterarAtividade(usu); // Chama o método para atualizar no banco de dados
    } catch (SQLException ex) {
        Logger.getLogger(cronograma_view.class.getName()).log(Level.SEVERE, null, ex);
        System.err.println("Erro ao tentar atualizar a atividade: " + ex.getMessage());
    }
}

        
    
    private void listar(){
         conUsuario con = new conUsuario();
    Vector cabecalho = new Vector();
try{
   
    cabecalho.add("Dia");
    cabecalho.add("Tarefa");
   

   
    tbSegunda.setModel(new DefaultTableModel(con.buscarCronograma(),cabecalho));
   
}catch (Exception e) {
       
        JOptionPane.showMessageDialog(this, "Erro ao carregar cronograma: " + e.getMessage());
        e.printStackTrace();
    }

    }
  
   


}

 
