package leetcode;

import java.util.LinkedList;

/**
 * @author lethe
 * @date 2022/5/6 20:07
 */
public class Leetcode933 {

    class RecentCounter {

        private LinkedList<Integer> list;


        public RecentCounter() {
            list = new LinkedList<>();
        }

        public int ping(int t) {
            while(!list.isEmpty() && list.getFirst() + 3000 < t ) {
                list.removeFirst();
            }
            list.addLast(t);
            return list.size();
        }
    }

    /*public static void main(String[] args) {
        Integer a = 10;
        f(a);
        System.out.println(a);
    }

    public static void f(Integer va) {
        va =3;
    }*/

    public static void main(String[] args) {
        int i = 100;
        int j = 100;
        compare(i,j);
    }

    public static void compare(Integer obj1, Integer obj2) {
        Integer obj3 = obj1 + 1;
        Integer obj4 = obj2 + 1;
        System.out.println("" + (obj3 == obj4));
    }
}
