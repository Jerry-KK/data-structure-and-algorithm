package codecrush;

public class Solution2101 {

    public static void main(String[] args) {
        Solution2101 body = new Solution2101();
//        System.out.println(body.validateIp("123.345.12.1"));
//        System.out.println(body.validateIp("123.12.2.1"));
        System.out.println(body.validateIp("127.0.0.1"));
        System.out.println(body.validateIp(" 127.0.0.1"));
        System.out.println(body.validateIp(" 127 . 0 . 0 . 1 "));
    }

    public boolean validateIp(String ipStr){
        if (ipStr == null || ipStr.isEmpty()) {
            return false;
        }
        int n = 0,v = 0;
        boolean first = true, no = false;
        char last = '.';
        for (char c : ipStr.toCharArray()) {
            if(c == ' ') {
                if (last != '.') {
                    no = true;
                }
            } else if (c >= '0' && c <= '9') {
                last = c;
                if (no) {
                    return false;
                }
                if (first && c == '0') {
                    first = false;
                    v = 255;
                } else {
                    v = v * 10 + (c - '0');
                    if ( v > 255 ) {
                        return false;
                    }
                }
            }else if(c == '.') {
                last = c;
                ++n;
                v = 0;
                first = true;
                no = false;
            } else {
                return false;
            }
        }
        return n == 3 && last != '.';
    }

}
