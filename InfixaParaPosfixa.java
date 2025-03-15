package unidade2;

import unidade2.pilha.MyStackLinkedList;
import unidade2.pilha.StackInterface;

import java.util.Stack;

public class InfixaParaPosfixa {
    public static void main(String[] args) {
        String posfixa = infixaParaPosfixa("((2+2)/(1+1))*5");
        System.out.println(posfixa);
    }

    private static String infixaParaPosfixa(String s) {
        StringBuilder posfixa = new StringBuilder();
        StackInterface<Character> stack =  new MyStackLinkedList<>();
        char c;
        for (int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            switch (c){
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '('){
                        posfixa.append(stack.pop());
                    }
                    stack.pop();
                    break;
                case '+', '-':
                    while (!stack.isEmpty() && stack.peek() != '('){
                        posfixa.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                case '/', '*':
                    while (!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '+' && stack.peek() != '-' ){
                        posfixa.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                default:
                    posfixa.append(c);
            }
        }
        while (!stack.isEmpty()){
          posfixa.append(stack.pop());
        }
        return posfixa.toString();
    }

    private static double calculoNotacaoPosfixa(String s){
        Stack<Double> pilha = new Stack<>();
        char c;
        double inicio, fim, resultado = 0;

        for ( int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if ( Character.isDigit(c)){
                pilha.push((double) (c - '0'));
            }
            else {
                fim = pilha.pop();
                inicio = pilha.pop();
                resultado = switch (c) {
                    case '+' -> inicio + fim;
                    case '-' -> inicio - fim;
                    case '*' -> inicio * fim;
                    case '/' -> inicio / fim;
                    default -> resultado;
                };
                pilha.push(resultado);
            }
        }

        return pilha.pop();
    }
}
