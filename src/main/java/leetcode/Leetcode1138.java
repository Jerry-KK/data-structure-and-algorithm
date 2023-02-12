package leetcode;

/**
 * @author lethe
 * @date 2023/2/12 22:54
 */
public class Leetcode1138 {

    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        for (char c: target.toCharArray()) {
            int e = c - 'a';
            int x2 = e/5;
            int y2 = e%5;
            for (int i = 0; i < y-y2; i++)
                sb.append('L');
            for (int i = 0; i < x-x2; i++)
                sb.append('U');
            for (int i = 0; i < y2-y; i++)
                sb.append('R');
            for (int i = 0; i < x2-x; i++)
                sb.append('D');
            sb.append('!');
            x = x2;
            y = y2;
        }
        return sb.toString();
    }

    int[][] arr = new int[26][2];

    {
        for (int i = 0; i < 26; i++) {
            arr[i][0] = i/5;
            arr[i][1] = i%5;
        }
    }

    public String alphabetBoardPath2(String target) {
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        for (char c: target.toCharArray()) {
            int e = c - 'a';
            int x2 = arr[e][0];
            int y2 = arr[e][1];
            for (int i = 0; i < y-y2; i++)
                sb.append('L');
            for (int i = 0; i < x-x2; i++)
                sb.append('U');
            for (int i = 0; i < y2-y; i++)
                sb.append('R');
            for (int i = 0; i < x2-x; i++)
                sb.append('D');
            sb.append('!');
            x = x2;
            y = y2;
        }
        return sb.toString();
    }

    public String alphabetBoardPath3(String target) {
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        int x2 = 0;
        int y2 = 0;
        for (int j = 0; j < target.length(); j++) {
            int e = target.charAt(j) - 'a';
            x2 = e/5;
            y2 = e%5;
            for (int i = 0; i < y-y2; i++)
                sb.append('L');
            for (int i = 0; i < x-x2; i++)
                sb.append('U');
            for (int i = 0; i < y2-y; i++)
                sb.append('R');
            for (int i = 0; i < x2-x; i++)
                sb.append('D');
            sb.append('!');
            x = x2;
            y = y2;
        }
        return sb.toString();
    }

    public String alphabetBoardPath4(String target) {
        StringBuilder sb = new StringBuilder();
        int x2, y2, x = 0, y = 0;
        for (int j = 0; j < target.length(); j++) {
            int e = target.charAt(j) - 'a';
            x2 = e/5;
            y2 = e%5;
            for (int i = 0; i < y-y2; i++)
                sb.append('L');
            for (int i = 0; i < x-x2; i++)
                sb.append('U');
            for (int i = 0; i < y2-y; i++)
                sb.append('R');
            for (int i = 0; i < x2-x; i++)
                sb.append('D');
            sb.append('!');
            x = x2;
            y = y2;
        }
        return sb.toString();
    }

    String[] str1 = {"","L","LL","LLL","LLLL"};
    String[] str2 = {"","R","RR","RRR","RRRR"};
    String[] str3 = {"","U","UU","UUU","UUUU","UUUUU"};
    String[] str4 = {"","D","DD","DDD","DDDD","DDDDD"};

    public String alphabetBoardPath5(String target) {
        StringBuilder sb = new StringBuilder();
        int x2, y2, x = 0, y = 0;
        for (int j = 0; j < target.length(); j++) {
            int e = target.charAt(j) - 'a';
            x2 = e/5;
            y2 = e%5;
            if(y > y2)
                sb.append(str1[y-y2]);
            if(x > x2)
                sb.append(str3[x-x2]);
            if(y < y2)
                sb.append(str2[y2-y]);
            if(x < x2)
                sb.append(str4[x2-x]);
            sb.append('!');
            x = x2;
            y = y2;
        }
        return sb.toString();
    }




}
