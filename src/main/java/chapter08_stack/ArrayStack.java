package chapter08_stack;

/**
 * @author lethe
 * @date 2021/7/20 21:03
 */
public class ArrayStack {
    private int[] arr;
    private int count;
    private int size;

    public ArrayStack(int n) {
        arr = new int[n];
        count = n;
        size = 0;
    }

    public void add(int val) throws Exception {
        if(count == size + 1) {
            throw new Exception("栈满了！");
        }
        arr[size] = val;
        size++;
    }

    public int remove() throws Exception {
        if(size == 0) {
            throw new Exception("栈为空!");
        }
        int res = arr[size - 1];
        size--;
        return res;
    }
}
