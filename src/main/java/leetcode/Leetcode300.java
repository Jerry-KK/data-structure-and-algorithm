package leetcode;

import java.util.Stack;

/**
 * @author koujn
 * @date 2021/12/2 13:37
 */
public class Leetcode300 {
    public static void main(String[] args) {
        Leetcode300 body = new Leetcode300();
        //int[] nums = {-813,82,-728,-82,-432,887,-551,324,-315,306,-164,-499,-873,-613,932,177,61,52,1000,-710,372,-306,-584,-332,-500,407,399,-648,290,-866,222,562,993,-338,-590,303,-16,-134,226,-648,909,582,177,899,-343,55,629,248,333,1,-921,143,629,981,-435,681,844,349,613,457,797,695,485,15,710,-450,-775,961,-445,-905,466,942,995,-289,-397,434,-14,34,-903,314,862,-441,507,-966,525,624,-706,39,152,536,874,-364,747,-35,446,-608,-554,-411,987,-354,-700,-34,395,-977,544,-330,596,335,-612,28,586,228,-664,-841,-999,-100,-620,718,489,346,450,772,941,952,-560,58,999,-879,396,-101,897,-1000,-566,-296,-555,938,941,475,-260,-52,193,379,866,226,-611,-177,507,910,-594,-856,156,71,-946,-660,-716,-295,-927,148,620,201,706,570,-659,174,637,-293,736,-735,377,-687,-962,768,430,576,160,577,-329,175,51,699,-113,950,-364,383,5,748,-250,-644,-576,-227,603,832,-483,-237,235,893,-336,452,-526,372,-418,356,325,-180,134,-698};
        int[] nums ={10,9,2,5,3,7,101,18};
        int[] i = body.lengthOfLIS(nums);
        System.out.println(i);
    }

    public int[] lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] size = new int[length];
        int[] order = new int[length];
        for (int i = length-1; i >=0 ; --i) {
            int max = 0;
            for (int j = i+1; j < length; j++) {
                if(nums[i] < nums[j] && size[j] >= max) {
                    max = size[j]+1;
                    order[i] = j;
                }
            }
            size[i] = max;
        }
        int s = -1;
        int res = 0;
        for (int i = 0; i < length; i++) {
            if(size[i] > res) {
                res = size[i];
                s = i;
            }
        }
        int[] r = new int[res+1];
        for (int i = 0; i < res+1; i++) {
            r[i] = nums[s];
            s = order[s];
        }
        return r;
    }

    public int lengthOfLIS2(int[] nums) {
        int len =1,n=nums.length;
        if(n == 0) {
            return 0;
        }
        int[] d = new int[n+1];
        d[len] = nums[0];
        for (int i = 0; i < n; i++) {
            if(nums[i] > d[len]) {
                d[++len] = nums[i];
            }else {
                int l = 1,r = len,pos = 0;
                while (l <= r) {
                    int mid = (l+r) >> 1;
                    if(d[mid] < nums[i]) {
                        pos = mid;
                        l = mid+1;
                    }else {
                        r = mid-1;
                    }
                }
                d[pos+1] = nums[i];
            }
        }
        return len;
    }

    public int lengthOfLIS3(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] d = new int[nums.length+1];
        d[1] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > d[len]){
                d[++len] = nums[i];
            }else {
                int s = 1,e =len,ops = 0;
                while (s <= e) {
                    int mid = ((e-s)>>1)+s;
                    if(d[mid] < nums[i]) {
                        ops = mid;
                        s = mid + 1;
                    }else {
                        e = mid - 1;
                    }
                }
                d[ops+1] = nums[i];
            }
        }
        return len;
    }

}
