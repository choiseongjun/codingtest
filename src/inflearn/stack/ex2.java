package inflearn.stack;

import java.util.Scanner;
import java.util.Stack;

public class ex2 {

    public static String solution(String s){
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char x:s.toCharArray()){
            if(x==')'){
                while(stack.pop()!='(');
            }else{
                stack.push(x);
            }
        }
        for(int i=0;i<stack.size();i++) answer+=stack.get(i);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String result = solution(str);
        System.out.println(result);
    }
}
//(A(BC)D)EF(G(H)(IJ)K)LM(N)