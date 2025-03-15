package unidade2.lista2;

import unidade2.pilha.MyStackLinkedList;
import unidade2.pilha.StackInterface;


public class Questao8 {

    public static void main(String[] args) {
        System.out.println(operacaoPosfixa("304 11 + 2 -"));
    }

    private static double operacaoPosfixa(String operacao){
        String[] termos = operacao.split(" ");
        StackInterface<Double> stack = new MyStackLinkedList<>();

        for (String t : termos){
            if (t.equalsIgnoreCase("+") || t.equalsIgnoreCase("-")){
                Double segundo = stack.pop();
                Double primeiro = stack.pop();
                Double resultado = null;
                switch (t){
                    case "+":
                        resultado = primeiro + segundo;
                        break;
                    case "-":
                        resultado = primeiro - segundo;
                        break;
                }
                stack.push(resultado);
            } else {
                stack.push((double) Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
