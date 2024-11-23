package 题.栈;

//后缀表达式也叫做逆波兰表达式
//计算机使用的就是后缀表达式
//在java代码中我们使用中缀表达式表达算数，但是在编译过程jvm会将其优化成后缀表达式
//这一点可以通过反编译看出来
//比如式子：
//4 13 5 / + 得到的就是 4+13/5
public class 后缀表达式求值 {
    //思路，先入栈，碰到运算符就计算相邻的两个数，然后再入栈循环如此

    public static void main(String[] args) {
        String[] str = {"4","13","5","/","+"};
        java.util.Stack<Integer> stk = new java.util.Stack<>();
        for(String s : str){
            int result = 1;
            int num1=1;
            int num2=1;
           switch (s){
               case "+":
                   num1=stk.pop();
                   num2=stk.pop();
                   result = num2+num1;
                   stk.push(result);
                   break;

               case "*":
                   num1=stk.pop();
                   num2=stk.pop();
                   result = num2*num1;
                   stk.push(result);
                   break;

               case "-":
                   num1=stk.pop();
                   num2=stk.pop();
                   result = num2-num1;
                   stk.push(result);
                   break;

               case "/":
                   num1=stk.pop();
                   num2=stk.pop();
                   result = num2/num1;
                   stk.push(result);
                   break;

               default:
                   stk.push(Integer.parseInt(s));
                   break;

           }
        }
        System.out.println(stk.pop());
    }
}
