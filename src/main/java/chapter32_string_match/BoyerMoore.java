package chapter32_string_match;

/**
 * BF（Boyer-Moore）算法
 * 1.坏字符规则（bad character rule）
 * 2.好后缀规则（good suffix shift）
 * @author koujn
 * @date 2021/8/7 11:21
 */
public class BoyerMoore {

    //散列表长度，这里默认字符集为ASCII编码，所有长度为256
    private static final int SIZE = 256;

    //生成模式串b的散列表数组bc
    //用于匹配话字符在模式串中最后出现的位置（有个问题，如果坏字符在模式串中位置比主串位置靠后，也能匹配吗？这就是会出现的向后倒退滑动的情况）
    private void generateBC(char[] b, int m, int[] bc) {
        //初始化bc,-1表示不存在该字符
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < b.length; i++) {
            //保存每个字符最后出现的位置
            bc[b[i]] = i;
        }
    }

    //bm算法
    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE];
        generateBC(b, m , bc);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b,m,suffix,prefix);
        //i表示主串和模式串对齐的第一个字符
        int i = 0;
        while ( i <= n-m) {
            int j;
            //模式串从后往前匹配
            for (j = m - 1; j >= 0 ; j--) {
                if(a[j + i] != b[j])
                    //坏字符对应模式串的下标是j
                    break;
            }
            if(j < 0 ) {
                //匹配成功，返回主串和模式串第一个匹配的字符的位置
                return i;
            }
            //计算向后滑动的位数，j表示主串中坏字符对应模式串中的位置，bc[a[j+i]]表示坏字符在模式中一样字符的最后出现位置
            int x = j - bc[a[j+i]];
            int y = 0;
            //如果有好后缀的话
            if( j < m-1) {
                y = moveGyGS(j, m , suffix , prefix);
            }
            i = i + Math.max(x,y);
        }
        return -1;
    }

    // j表示坏字符对应的模式串中的字符下标; m表示模式串长度
    private int moveGyGS(int j, int m , int[] suffix , boolean[] prefix) {
        // 好后缀长度
        int k  = m - 1 - j;
        //1.在模式串中,查找跟好后缀匹配的另一个字串
        if(suffix[k] != -1)
            return j - suffix[k] + 1;
        //2.在好后缀的好后缀字串中，查找最长的、能跟模式串前缀串匹配的后缀字串
        // j表示坏字符对应的模式串中的字符下标;所以好后缀开始的下标为j+1;好后缀字串的开始下标为j+2,模式串的结束位置为m-1
        for (int r = j + 2; r <= m-1; ++r) {
            //m-r 为 好后缀字串的长度，m-r = (m-1) - r + 1
            if(prefix[m-r] == true)
                //从0位置滑动到r，所以滑动距离为r
                return  r;
        }
        //不满足上述两个条件，滑动模式串的距离
        return m;
    }

    //b表示模式串,m表示长度,suffix,prefix数组事先申请好了
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        //初始化
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        //从i位置开始往前（减1）遍历与后缀字符对比，k，表示相同字符的数量
        //当k == i时表示模式串的k长度后缀就是k长度的前缀。
        //j相当于i-k,需要比较的串的位置
        for (int i = 0; i < m-1; i++) {
            int j = i;
            //公共后缀子串长度
            int k = 0;
            //与b[0,m-1]求公共后缀字串
            while ( j >= 0 && b[j] == b[m-1-k]) {
                j--;
                k++;
                //j+1表示公共后缀字串在b[0,i]中的起始下标
                suffix[k] = j+1;
            }
            if( j < 0) {
                prefix[k] = true;
            }
        }
    }
}
