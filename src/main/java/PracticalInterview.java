import java.util.Stack;

public class PracticalInterview {
    //Given this input: “3[asdf]” you have to generate an output string: asdfasdfasdf)
    public static void main(String[] args) {
        String str = "3[asdf]";
        System.out.println(stringDecoder(str));
    }

    public static String stringDecoder(String str){
        Stack<Integer> counter = new Stack<>();
        Stack<StringBuilder> result = new Stack<>();
        StringBuilder strBuilder = new StringBuilder();
        int x = 0;
        char[] strCharArray = str.toCharArray();
        for(char ch : strCharArray){
            if(Character.isDigit(ch)){
                x = x * 10 + ch - '0';
            } else if (ch == '['){
                counter.push(x);
                result.push(strBuilder);
                strBuilder = new StringBuilder();
                x = 0;
            } else if(ch == ']'){
                StringBuilder stringBuilder = result.pop();
                int currentX = counter.pop();
                for(int i = 0; i < currentX; i++){
                    stringBuilder.append(strBuilder);
                }
                strBuilder = stringBuilder;
            } else {
                strBuilder.append(ch);
            }
        }
        return strBuilder.toString();
    }
}
