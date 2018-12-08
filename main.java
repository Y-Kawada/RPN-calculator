import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws Exception {
        // Your code here!
        int kekka = 0;
        String user;
        Scanner sc = new Scanner(System.in);
        user = sc.nextLine();
        test(user != null);
        test(keisan(1,1,'+') == 1 + 1);
        test(keisan(1,2,'+') == 1 + 2);
        test(keisan(2,1,'-') == 2 - 1);
        test(keisan(2,3,'*') == 2 * 3);
        //test(keisan(3,4,'a') == -1);
        String[] siki = user.split(" ");
        try{
            kekka = keisan(saisho(user));
        } catch (IllegalArgumentException e){
            System.out.println("もう一度入力してください");
            return;
        }
        System.out.println(kekka);
    }
    public static void test(boolean b){
        count++;
        if(!b)throw new IllegalArgumentException(count+"回目の値が正常ではありません。");
    }
    public static boolean hanbetsu (String x){
        switch(x){
            case "+":
                return false;
            case "-":
                return false;
            case "*":
                return false;
            case "/":
                return false;
            default:
                return true;
        }
    }
    public static String[] saisho (String siki) throws IllegalArgumentException{
        String[] youso = siki.split(" ");
        List<String> youso2 = new ArrayList<String>(Arrays.asList(youso));
        String[] modorichi = new String[3];
            for (int i = youso2.size() - 1; i >= 2; i--){
             String a = youso2.get(i);
             String b = youso2.get(i - 1);
             String c = youso2.get(i - 2);
             if(!hanbetsu(a) && hanbetsu(b) && hanbetsu(c)){
                 modorichi[0] = c;
                 modorichi[1] = b;
                 modorichi[2] = a;
                 youso2.set(i - 2,String.valueOf(keisan(modorichi)));
                 youso2.remove(i);
                 youso2.remove(i - 1);
                 i = youso2.size();
            }
        }
            if(youso2.size() !=1)
                throw new IllegalArgumentException("もう一度入力してください");
        return modorichi;
    }
    public static int keisan (int x, int y, char z)throws IllegalArgumentException{
        int hoge = -1;
        switch(z){
            case '+':
                hoge = x + y;
                break;
            case '-':
                hoge = x - y;
                break;
            case '*':
                hoge = x * y;
                break;
            case '/':
                hoge = x / y;
                break;
            default :
                throw new IllegalArgumentException("もう一度入力してください");
        }
        return hoge;
    }
    public static int keisan (String[] siki){
        ArrayList<Integer> suji = new ArrayList<Integer>();
        suji.add(Integer.parseInt(siki[0]));
        suji.add(Integer.parseInt(siki[1]));
        ArrayList<Character> kigou = new ArrayList<Character>();
        kigou.add(siki[2].charAt(0));
        int x = suji.get(0);
        int y = suji.get(1);
        char z = kigou.get(0);
        int hog = keisan(x,y,z);
        return hog;
    }
}
