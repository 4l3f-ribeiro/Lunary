package view;

import model.SomaGerador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.LineBorder;
import view.Subtracao;

public class Soma {
    private JFrame frame;
    private JButton[] botoesDeResposta;
    private JLabel rotuloDaPergunta;
    private int respostaCorreta;
    private SomaGerador geradorDePerguntas;
    public int correct;
    public int errada;

    public Soma() {
        geradorDePerguntas = new SomaGerador();
        
        frame = new JFrame("Quiz de Matemática");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            botoesDeResposta[i].addActionListener(new Soma.BotaoResposta());
            botoesDeResposta[i].setPreferredSize(new Dimension(250, 250));
            botoesDeResposta[i].setBackground(Color.CYAN);
            botoesDeResposta[i].setBorder(new LineBorder(Color.BLACK, 4));
            botoesDeResposta[i].setFont(new Font("Verdana", Font.BOLD, 24));

            painelDosBotoes.add(botoesDeResposta[i]);
        }
        frame.add(painelDosBotoes, BorderLayout.CENTER);

        // Gerar uma nova pergunta
        gerarNovaPergunta();
        
        frame.setVisible(true);
    }

    private void gerarNovaPergunta() {
        SomaGerador.Pergunta pergunta = geradorDePerguntas.gerarNovaPergunta();
        
        respostaCorreta = pergunta.getRespostaCorreta();
        rotuloDaPergunta.setText(pergunta.getNum1() + " + " + pergunta.getNum2() + " = ?");

        ArrayList<Integer> respostas = pergunta.getRespostas();

        // Definir respostas nos botões
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
                JOptionPane.showMessageDialog(frame, "Resposta Correta");
                correct++;
            } else {
                JOptionPane.showMessageDialog(frame, "Errada! A resposta correta era " + respostaCorreta);
                errada++;
            }
            gerarNovaPergunta();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Soma::new);
    }
}