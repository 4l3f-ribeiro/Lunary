package view;

import Cadastro.PrincipalPage;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlIJTheme;
import controller.conUsuario;
import model.SubtracaoGerador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;
import model.classUsuario;

public class Subtracao {
    classUsuario usu = new classUsuario();
    conUsuario con = new conUsuario();
    private JFrame frame;
    private JButton[] botoesDeResposta;
    private JLabel rotuloDaPergunta;
    private JButton botaoVoltar;
    private int respostaCorreta;
    private SubtracaoGerador geradorDePerguntas;
    public int correct;
    public int errada;
    public int totalacertos;
    public int totaerros;

    public Subtracao() {
        geradorDePerguntas = new SubtracaoGerador();

        frame = new JFrame("Quiz de Matemática");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

       // Criando parte da pergunta
        rotuloDaPergunta = new JLabel();
        rotuloDaPergunta.setForeground(Color.BLUE);

        rotuloDaPergunta.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(rotuloDaPergunta, BorderLayout.NORTH);

        rotuloDaPergunta.setFont(new Font("Verdana", Font.BOLD, 48));

        // Criar os botões de resposta
        JPanel painelDosBotoes = new JPanel();
        painelDosBotoes.setLayout(new FlowLayout()); // Deixar em formato de botão

        botoesDeResposta = new JButton[4];

        for (int i = 0; i < 4; i++) {
            botoesDeResposta[i] = new JButton();
            botoesDeResposta[i].addActionListener(new BotaoResposta());
            botoesDeResposta[i].setPreferredSize(new Dimension(150, 150));
            botoesDeResposta[i].setBackground(Color.CYAN);
            botoesDeResposta[i].setBorder(new LineBorder(Color.BLACK, 4));
            botoesDeResposta[i].setFont(new Font("Verdana", Font.BOLD, 24));

            painelDosBotoes.add(botoesDeResposta[i]);
        }

        frame.add(painelDosBotoes, BorderLayout.CENTER);

        
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(new Font("Verdana", Font.BOLD, 18));
        botaoVoltar.setBackground(Color.RED);
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setBorder(new LineBorder(Color.BLACK, 3));
        botaoVoltar.setPreferredSize(new Dimension(100, 40));

        botaoVoltar.addActionListener(e -> {
            frame.dispose();
            PrincipalPage page = new PrincipalPage();
            page.setVisible(true);
            try {
                con.attTotal(usu);
            } catch (SQLException ex) {
                Logger.getLogger(Subtracao.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Voltando para o Menu Principal!");
        });

        
        frame.add(botaoVoltar, BorderLayout.SOUTH);

        gerarNovaPergunta();

        frame.setVisible(true);
    }

    private void gerarNovaPergunta() {
        SubtracaoGerador.Pergunta pergunta = geradorDePerguntas.gerarNovaPergunta();

        respostaCorreta = pergunta.getRespostaCorreta();
        rotuloDaPergunta.setText(pergunta.getNum1() + " - " + pergunta.getNum2() + " = ?");

        ArrayList<Integer> respostas = pergunta.getRespostas();

       
        for (int i = 0; i < 4; i++) {
            botoesDeResposta[i].setText(String.valueOf(respostas.get(i)));
        }
    }

    private class BotaoResposta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton botaoClicado = (JButton) e.getSource();
            int respostaSelecionada = Integer.parseInt(botaoClicado.getText());
            if (respostaSelecionada == respostaCorreta) {
                JOptionPane.showMessageDialog(frame, "Resposta Correta!");
                correct = 1;
                  totalacertos += 1;
                usu.setAcertototal(totalacertos);
                usu.setAcerto(correct);
                try {
                    con.attAcertos(usu);
                } catch (SQLException ex) {
                    Logger.getLogger(Subtracao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Incorreto! A resposta correta era " + respostaCorreta);
                errada = 1;
                 totaerros += 1;

                
                usu.setErrototal(totaerros);
                usu.setErro(errada);
                try {
                    con.attErro(usu);
                } catch (SQLException ex) {
                    Logger.getLogger(Subtracao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            gerarNovaPergunta();
            FlatNightOwlIJTheme.setup();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Subtracao::new);
    }
}
