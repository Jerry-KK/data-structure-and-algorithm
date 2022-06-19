package leetcode;

/**
 * @author lethe
 * @date 2022/2/27 15:28
 */
public class Leetcode553 {

    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int l = nums.length;
        sb.append(nums[0]);
        if(l > 2) {
            sb.append("/").append("(");
            for (int i = 1; i < l-1; i++) {
                sb.append(nums[i]).append("/");
            }
            sb.append(nums[l-1]).append(")");
        }else if(l == 2){
            sb.append("/").append(nums[l-1]);
        }
        return sb.toString();
    }

}
