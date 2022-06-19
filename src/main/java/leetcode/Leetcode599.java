package leetcode;

import java.util.*;

/**
 * @author lethe
 * @date 2022/3/14 22:29
 */
public class Leetcode599 {

    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Burger King","Tapioca Express","Shogun"};
        Leetcode599 body = new Leetcode599();
        String[] ans = body.findRestaurant(list1, list2);
        System.out.println(1);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hashMap.put(list1[i],i);
        }
        LinkedList<String> ans = new LinkedList<>();
        int min = 2000;
        for (int i = 0; i < list2.length; i++) {
            if(hashMap.containsKey(list2[i])) {
                int k = i + hashMap.get(list2[i]);
                if(k < min) {
                    min = k;
                    ans = new LinkedList<>();
                    ans.add(list2[i]);
                }else if(k == min) {
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[0]);
    }

}
