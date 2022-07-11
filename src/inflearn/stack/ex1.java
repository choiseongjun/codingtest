package inflearn.stack;

import java.util.Scanner;
import java.util.Stack;

public class ex1 {

    static String solution(String str){

        String answer = "Yes";
        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()){
            if(x=='(') stack.push(x);
            else{
                if(stack.isEmpty()) return "No";
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return "No";

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String k = sc.next();
        solution(k);
    }
}
