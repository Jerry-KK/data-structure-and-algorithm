package leetcode;

/**
 * @author lethe
 * @date 2021/9/12 22:29
 */
public class Leetcode678 {
    public static void main(String[] args) {
        //String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        String s = "(*))";
        Leetcode678 body = new Leetcode678();
        boolean b = body.checkValidString2(s);
        System.out.println(b);
    }

    //错误方法；未考虑（和*的先后次序
    public boolean checkValidString(String s) {
        char[] arr = s.toCharArray();
        int x = 0;
        int y = 0;
        for (char c: arr) {
            if(c == '(')    x++;
            else if(c == '*') y++;
            else {
                if(x>0)  x--;
                else if(y>0)    y--;
                else return false;
            }
        }
        return x  <= y;
    }

    public boolean checkValidString2(String s) {
        char[] arr = s.toCharArray();
        //标记位，遍历到null表示结束
        CNode next = null;
        for (char c: arr) {
            if(c == '(' || c == '*') {
                next = new CNode(c, next);
            }
            else {
                if(next == null)
                    return false;
                else {
                    if(next.data == '('){
                        next = next.next;
                    }else {
                        CNode pp = next;
                        CNode p = next.next;
                        boolean flag = true;
                        while (p != null){
                            if(p.data == '(') {
                                pp.next = p.next;
                                flag = false;
                                break;
                            }else {
                                pp = p;
                                p = p.next;
                            }
                        }
                        if(flag) {
                            if(next.data == '*') {
                                next = next.next;
                                flag = false;
                            }else {
                                pp = next;
                                p = next.next;
                                while (p != null){
                                    if(p.data == '*') {
                                        pp.next = p.next;
                                        flag = false;
                                        break;
                                    }else {
                                        pp = p;
                                        p = p.next;
                                    }
                                }
                            }
                        }
                        if(flag)    return false;
                    }

                }
            }
        }
        int x = 0;
        while (next!= null){
            if(next.data == '*'){
                x++;
            } else {
                if(x == 0)
                    return false;
                --x;
            }
            next = next.next;
        }
        return true;
    }

    //这里修改next无法改变原来的next
    public boolean find(CNode next,char tar) {
        if(next == null)
            return true;
        if(next.data == tar){
            next = next.next;
            return false;
        }
        CNode pp = next;
        CNode p = next.next;
        while (p != null){
            if(p.data == tar) {
                pp.next = p.next;
                return false;
            }else {
                pp = p;
                p = p.next;
            }
        }
        return true;
    }

}

class CNode{
    public char data;
    public CNode next;

    public CNode(char data, CNode next) {
        this.data = data;
        this.next = next;
    }
}