package dynamic.connectivity;

import java.rmi.activation.ActivationGroup_Stub;

/**
 * Created by xudeng on 1/7/17.
 */
public class QuickUnionAlgorithm {

    private int[] idx;

    public QuickUnionAlgorithm(int N) {
        idx = new int[N];
        for (int i = 0; i < N; i++) {
            idx[i] = i;
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

    public void union(int p, int q) {
        if (!connected(p, q)) {
            int rootP = root(p);
            int rootQ = root(q);
            idx[rootP] = rootQ;
        }
    }

    public void print() {
        for (int i = 0; i < idx.length; i++) {
            System.out.print(idx[i] + ",");
        }
    }

    public static void main(String args[]) {
        QuickUnionAlgorithm main = new QuickUnionAlgorithm(10);
        main.union(4, 3);
        main.union(3, 8);
        main.union(6,5);
        main.union(9,4);
        main.union(2,1);
        main.union(5,0);
        main.union(7,2);
        main.union(6,1);
        main.union(7,3);
        if (main.connected(5,4))
        {
            System.out.println("5 is connected with 4");
        }else
        {
            System.out.println("5 is not connected with 4");
        }
        main.print();
    }
}
