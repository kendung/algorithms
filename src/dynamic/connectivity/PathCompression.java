package dynamic.connectivity;

/**
 * Created by xudeng on 1/7/17.
 */
public class PathCompression {
    private int[] idx;
    private int[] size;

    public PathCompression(int N)
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
        int node = component;
        int parent = idx[node];
        while (parent != node) {
            node = parent;
            parent = idx[node];
        }
        int root = parent;
        // set the parent of all the nodes in the path to root,second pass
        parent = idx[component];
        while(component != parent)
        {
            idx[component] = root;
            component = parent;
            parent = idx[component];
        }
        return root;
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
        PathCompression main = new PathCompression(10);
        main.union(4,3);
        main.union(3,8);
        main.union(6,5);
        main.union(5,8);
        main.union(6,9);
        main.union(1,7);
        main.union(1,2);
        main.union(0,4);
       if (main.connected(1,6))
       {
           System.out.println("node 1 is connected with node 6");
       }else
       {
           System.out.println("node 1 is not connected with node 6");
       }
       main.print();
    }
}
