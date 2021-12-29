package leetcode;

/**
 * @author lethe
 * @date 2021/12/28 14:48
 */
public class Leetcode825 {

    public static void main(String[] args) {
        Leetcode825 body = new Leetcode825();
        int[] ages = {98,60,24,89,84,51,61,96,108,87,68,29,14,11,13,50,13,104,57,8,57,111,92,87,9,59,65,116,56,39,55,11,21,105,57,36,48,93,20,94,35,68,64,41,37,11,50,47,8,9};
//        int[] ages = {16,16};
        int res = body.numFriendRequests3(ages);
        System.out.println(res);
    }

    //桶排序，第二次遍历原数组
    public int numFriendRequests(int[] ages) {
        int[] arr = new int[121];
        for (int age: ages) {
            ++arr[age];
        }
        int res  = 0;
        for (int age:ages) {
            if(age > 14) {
                for (int i = age/2 +8; i <= age ; i++) {
                    res+=arr[i];
                }
                --res;
            }
        }
        return res;
    }

    //桶排序，第二次也是遍历桶排序数组
    public int numFriendRequests2(int[] ages) {
        int[] arr = new int[121];
        for (int age: ages) {
            ++arr[age];
        }
        int res  = 0;
        for (int age = 15; age <= 120; age++) {
            if(arr[age] > 0) {
                for (int i = age/2 +8; i < age ; i++) {
                    res+=(arr[i] * arr[age]);
                }
                if(arr[age] > 1)
                    res += (arr[age]-1)*arr[age];
            }
        }
        return res;
    }

    //桶排序，利用前缀和避免循环
    public int numFriendRequests3(int[] ages) {
        int[] arr = new int[121];
        for (int age: ages) {
            ++arr[age];
        }
        for (int i = 1; i <= 120; i++) {
            arr[i] += arr[i-1];
        }
        int res  = 0;
        for (int age = 15; age <= 120; age++) {
            int n = arr[age]-arr[age-1];
            if(n > 0) {
                res += ((arr[age - 1] - arr[age / 2 + 7]) * n);
                if (n > 1)
                    res += (n - 1) * n;
            }
        }
        return res;
    }

}
