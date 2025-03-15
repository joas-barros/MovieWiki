package unidade2;

import java.util.Stack;

public class Playground {
    public static void main(String[] args) {

    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c;
        for ( int i = 0; i < s.length(); i++){
            c = s.charAt(i);

            switch (c){
                case '(': stack.push(')'); break;
                case '{': stack.push('}'); break;
                case '[': stack.push(']'); break;

                case ')', '}' , ']':
                    if(stack.isEmpty()){
                        return false;
                    } else if (stack.pop() != c){
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}
