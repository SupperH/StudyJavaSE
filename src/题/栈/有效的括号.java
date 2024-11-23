package 题.栈;

//给定一个只包括([{)]}判断是否是有效括号
//有效括号成对出现，而且嵌套关系要正确 比如：
//(){} true
//({)} false

import 栈.Stack;

public class 有效的括号 {
    public static void main(String[] args) {
        /*思路： 每次碰到左括号，把对应的右括号放到栈中，当碰到右括号就从栈拿出内容
        * ，如果能匹配上，则继续，如果匹配不上直接返回false
        * 最后，如果栈中没内容了那么就返回true 如果还有内容那么也返回false*/

        java.util.Stack<Character> stk = new java.util.Stack<>();
        String s = "(]";

        for(int i = 0;i<s.length();i++){
            char c =s.charAt(i);
            if(c=='('){
                stk.push(')');
            }else if(c=='['){
                stk.push(']');
            }else if(c=='{'){
                stk.push('}');
            }else{
                if(!stk.isEmpty()&& c==stk.peek()){
                    stk.pop();
                }else{
                    System.out.println("false");
                    break;
                }
            }
        }

        if(stk.isEmpty()){
            System.out.println("true");
        }else{
            System.out.println("false");

        }



    }
}
