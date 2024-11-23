package 题.栈;


import java.util.Stack;

/*思路：
* 碰到非运算符就拼接字符串，
*   第一次碰到运算符直接入栈
*   如果字符比较完了那么直接按照顺序出栈
* 碰到多个运算符判断优先级，如果碰到的优先级比栈的低或者相等直接弹出，然后再放入当前运算符
*   如果碰到的优先级比栈的高，那么入栈，然后再循环判断
*
*
*
* 如果有括号：（a+b）*c                                    a*(b+c)
* 碰到左括号，左括号入栈                      a
* 碰到a 拼接a                               s*
* 碰到+ 判断栈中有没有其他符号，没有入栈          s*(
* 碰到b 拼接ab                              ab
* 碰到右括号，弹出栈顶符号拼接 ab+                s*(+
* 碰到* 判断栈中有没有其他运算符 没有入栈             abc
* 碰到c 拼接ab+c                                    )
* 最后循环拿出* ab+c*                             abc+*
* */
public class 中缀表达式转后缀表达式 {

    public static void main(String[] args) {
        Stack<Character> stk = new Stack<>();
        String exp="a*(b+c)";
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<exp.length();i++){
            char c = exp.charAt(i);
            if(level(c)==0){
                sb.append(c);
            }else{
                //如果栈是空的，说明第一次判断，直接入栈
                if(stk.isEmpty()){
                    stk.push(c);


                }else{

                    //如果有左括号，入栈后面的逻辑都是共用的，括号里也遵守算式法则
                    if(c=='('){
                        stk.push(c);

                        //当碰到了右括号，把括号里的内容全部弹出栈 因为括号优先级最高，剩余的内容都要有限弹出
                    }else if(c==')'){
                        while(!stk.isEmpty()){
                            if(stk.peek()=='('){
                                stk.pop();
                            }else{
                                sb.append(stk.pop());
                            }
                        }

                    //如果栈顶运算符小于当前运算符，将当前运算符入栈
                    }else if(level(stk.peek()) < level(c)){
                        stk.push(c);

                        //如果栈顶运算符大于等于当前运算符，拼接然后入栈当前运算符
                    }else{
                        while(!stk.isEmpty()){
                            sb.append(stk.pop());
                        }
                        stk.push(c);
                    }
                }
            }
        }

        while (!stk.isEmpty()){
            if(stk.peek()!='(' && stk.peek()!=')' ){

            }
            sb.append(stk.pop());
        }
        System.out.println(sb);

    }


    //判断运算符优先级
    static int level(char c){
        //乘除优先级高所以数字高
        if(c=='*'|| c=='/'){
            return 2;
        }else if(c=='+'|| c=='-'){
            return 1;
            //如果是括号返回-1虽然是最小的，但是在代码里一开始会直接捕获括号
        }else if(c=='('|| c==')'){
            //如果是0说明是非运算符返回0
            return -1;
        }else{
            return 0;
        }
    }
}


