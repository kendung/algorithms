package dynamic.connectivity;

/**
 * Created by xudeng on 1/5/17.
 */
public class QuickFindUF {

    private int[] ids;

    public QuickFindUF(int N)
    {
        ids = new int[N];
        for(int i = 0; i < N; i++)
        {
            ids[i] = i;
        }
    }

    public int find(int site)
    {
        if (site < 0 || site >= ids.length)
        {
            throw new IllegalArgumentException("Illegal array index for Array ids");
        }
        return ids[site];
    }

    public boolean connected(int p, int q)
    {
        return ids[p] == ids[q];
    }

    public void union(int p, int q)
    {
        int pid = ids[p];
        int qid = ids[q];
        if (pid == qid)
        {
            return;
        }
        for (int i = 0; i < ids.length; i++)
        {
            if (ids[i] == pid)
            {
                ids[i] = qid;
            }
        }
    }
    public void print()
    {
        for (int i = 0; i < ids.length; i++)
        {
            System.out.println(ids[i] + ",");
        }
    }

    public static void main(String args[])
    {
        QuickFindUF main = new QuickFindUF(10);
        main.union(4,3);
        main.union(3,8);
        main.union(6,5);
        main.union(9,4);
        main.print();
        if (main.connected(0,8))
        {
            System.out.println("site 0 is connected to site 8");
        }else
        {
            System.out.println("site 0 is not connected to site 8");
        }
    }

}
