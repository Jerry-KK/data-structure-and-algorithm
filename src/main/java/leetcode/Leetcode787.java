package leetcode;

/**
 * @author koujn
 * @date 2021/8/25 17:22
 */
public class Leetcode787 {

    public static void main(String[] args) {
        int n = 3,src = 0, dst = 2, k = 1;
        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};

        Leetcode787 lt = new Leetcode787();
        lt.findCheapestPrice(n,edges,src,dst,k);
        System.out.println(lt.monty);



    }

    int monty = Integer.MAX_VALUE;
    int z;


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] nArr = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            nArr[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        z = k;
        test(src,nArr,dst,0,0);
        return monty;
    }

    public void test(int a,int[][] nArr, int dst, int k,int val) {
        if(k>z+1 || val > monty){
            return;
        }
        if(a == dst) {
            if(val < monty)
                monty = val;
            return;
        }
        for (int i = 0; i < nArr.length; i++) {
            if(nArr[a][i] != 0) {
                test(i,nArr,dst,k+1,val+nArr[a][i]);
            }
        }
    }


}
