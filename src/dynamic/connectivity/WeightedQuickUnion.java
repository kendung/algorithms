package dynamic.connectivity;

/**
 * Created by xudeng on 1/7/17.
 */
public class WeightedQuickUnion {

    private int[] idx;
    private int[] size;

    public WeightedQuickUnion(int N)
    {
        idx = new int[N];
        size = new int[N];
        for(int i = 0; i < N; i++)
        {
            idx[i] = i;
            size[i] = 1;
        }
    }

    public int root(int component) {
        if (component < 0 || component >= idx.length) {
            throw new IllegalArgumentException("Illegal index");
        }
        int parent = idx[component];
        while (parent != component) {
            component = parent;
            parent = idx[component];
        }
        return parent;
    }

    public boolean connected(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        return rootP == rootQ;
    }

    public void union(int p, int q)
    {
        if (!connected(p, q)) {
            int rootP = root(p);
            int rootQ = root(q);
            if (size[rootP] <= size[rootQ])
            {
                idx[rootP] = rootQ;
                size[rootQ] = size[rootQ] + size[rootP];
            }else
            {
                idx[rootQ] = rootP;
                size[rootP] = size[rootP] + size[rootQ];
            }
        }
    }
    public void print() {
        for (int i = 0; i < idx.length; i++) {
            System.out.print(idx[i] + ",");
        }
    }

    public static void main(String args[])
    {
        WeightedQuickUnion main = new WeightedQuickUnion(10);
        main.union(4,3);
        main.union(3,8);
        main.union(6,5);
        main.print();
    }
}
