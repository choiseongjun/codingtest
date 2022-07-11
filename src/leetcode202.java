import java.util.ArrayList;

public class leetcode202 {
    public boolean isHappy(int num) {
        int res= num;
        int len = (int)Math.log10(num)+1;
        if(len == 1) return false;


        ArrayList<Integer> arrNum = new ArrayList<>();

        while(res!=1){
            while(res > 0) {
                arrNum.add(res %10);
                res /= 10;
            }
            res = 0;
            for(int i=0;i<arrNum.size();i++){
                double e = arrNum.get(i);
                res+=Math.pow(e,2);
            }
            System.out.println("res="+res);
            if(res==1){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n =19;
        leetcode202 p = new leetcode202();
        boolean test = p.isHappy(n);
        System.out.println(test);
    }
}
