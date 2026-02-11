package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SomaGerador {
    private Random rand = new Random();

    public Pergunta gerarNovaPergunta() {
        int num1 = rand.nextInt(10) + 1;
        int num2 = rand.nextInt(10) + 1;
        int respostaCorreta = num1 + num2;

        // Gerar respostas
        ArrayList<Integer> respostas = new ArrayList<>();
        respostas.add(respostaCorreta);
        while (respostas.size() < 4) {
            int respostaErrada = rand.nextInt(19) + 2; // Número aleatório entre 2 e 20
            if (respostaErrada != respostaCorreta && !respostas.contains(respostaErrada)) {
                respostas.add(respostaErrada);
            }
        }

        // Embaralhar respostas
        Collections.shuffle(respostas);

        return new Pergunta(num1, num2, respostaCorreta, respostas);
    }

    public static class Pergunta {
        private final int num1;
        private final int num2;
        private final int respostaCorreta;
        private final ArrayList<Integer> respostas;

        public Pergunta(int num1, int num2, int respostaCorreta, ArrayList<Integer> respostas) {
            this.num1 = num1;
            this.num2 = num2;
            this.respostaCorreta = respostaCorreta;
            this.respostas = respostas;
        }

        public int getNum1() {
            return num1;
        }

        public int getNum2() {
            return num2;
        }

        public int getRespostaCorreta() {
            return respostaCorreta;
        }

        public ArrayList<Integer> getRespostas() {
            return respostas;
        }
    }
}
