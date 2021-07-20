package chapter06_linkedlist;

/**
 * @author koujn
 * @date 2021/7/20 9:25
 */
public class Test06 {
    public static void main(String[] args) {
        //String str = test1("gsasgessssse");
        String str = test2("gsasgesse");
        System.out.println(str);
    }

    //用双端队列解决最长回文字串
    public static String test1 (String str) {
        char[] chars = str.toCharArray();
        MyLinkedList list = new MyLinkedList();
        for (char c: chars) {
            list.add(c);
        }
        int size = chars.length;
        Node first = list.head.next;
        Node last = list.end.next;
        int len = 1;
        Node[] result = new Node[2];
        for (int i = 0; i < size; i++) {
            Node target = first;
            for (int k = 0; k < i; k++) {
                target = target.next;
            }
            Node same = last;
            for (int j = size - 1 ; j > i + len  ; j--) {
                if(target.data == same.data) {
                    boolean flag = true;
                    Node ff = target;
                    Node ee = same;
                    for (int k = 0; k <= (j - i)/2; k++) {
                        ff = ff.next;
                        ee = ee.previous;
                        if(ff.data != ee.data) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        result[0] = target;
                        result[1] = same;
                        len = j - i + 1;
                    }
                }
                same = same.previous;
            }
        }
        char[] res = new char[len];
        Node nn = result[0];
        for (int i = 0; i < len; i++) {
            res[i] = nn.data;
            nn = nn.next;
        }
        return String.valueOf(res);
    }

    /**
     * 思路2，直接判断整个字符串是不是回文字串，然后判断长度为length-1的子字符串是不是回文子串，以此类推。一旦找到就结束，
     * 循环次数： 1 + 2 + 3 + .. + n-1;
     * 判断一个字符串是不是回文字串，如果用链表存储，参考网上思路
     *  1.两个指针，一个步长为1，一个步长为2，找到链表中点
     *  2.把步长1的指针反向 ，遍历判断
     *
     *  下面代码没用链表，直接用的数组
     */
    public static String test2(String str) {
        char[] chars = str.toCharArray();
        for (int len = chars.length; len > 0; len--) {
            for (int i = 0; i <= chars.length-len; i++) {
                int start = i;
                int end = i + len - 1;
                boolean flag = true;
                for (int j = 0; j < len/2; j++) {
                    if(chars[start] != chars[end]) {
                        flag = false;
                        break;
                    }
                    start++;
                    end--;
                }
                if(flag) {
                    return String.valueOf(chars,i,len);
                }
            }
        }
        return String.valueOf(chars[0]);
    }

}
