package self.crossing;

/**
 * Created by xudeng on 1/25/17.
 */
public class Solution {

    public static class Point
    {
        public int x;
        public int y;
    }

    public static class Line
    {
        public Point start;
        public Point end;
    }

    public boolean isSelfCrossing(int[] x)
    {
        if (x.length <= 3)
        {
            return false;
        }
        Line[] lines = new Line[4];
        int startx = 0;
        int starty = 0;
        for (int i = 0; i < x.length; i++)
        {
            // index: 0 go north
            // 1: go west
            // 2: go south
            // 3. go east
            int index = i % 4;
            Line line = new Line();
            Point start = new Point();
            Point end = new Point();
            switch(index)
            {
                case 0:
                   start.x = startx;
                   start.y = starty;
                   end.x = start.x;
                   end.y = start.y + x[i];
                   break;
                case 1:
                    start = lines[0].end;
                    end.x = start.x - x[i];
                    end.y = start.y;
                    break;
                case 2:
                    start = lines[1].end;
                    end.x = start.x;
                    end.y = start.y - x[i];
                    break;
                case 3:
                    start = lines[2].end;
                    end.x = start.x + x[i];
                    end.y = start.y;
                    startx = end.x;
                    starty = end.y;
                default: break;
            }
            line.start =start;
            line.end = end;
            if (i > 3)
            {
                lines[3] = line;
            }else
            {
                lines[index] = line;
            }
            if (countNonNullElement(lines) == 4)
            {
                // lines[3] cross with lines[0]
                Line line0 = lines[0];
                Line line3 = lines[3];
                if (line0.start.x == line0.end.x)
                {
                    // line0 vertical with X axis
                    if (line3.start.y >= line0.start.y && line3.start.y <= line0.end.y)
                    {
                        return true;
                    }
                }else if (line0.start.y == line0.end.y)
                {
                    if (line3.start.x >= line0.start.x && line3.start.x <= line0.end.x)
                    {
                        return true;
                    }
                }
                removeFirstElement(lines);
            }
        }
        return false;
    }

    private int countNonNullElement(Line[] lines)
    {
        int result = 0;
        for(int i = 0; i < lines.length; i++)
        {
            if (lines[i] != null)
            {
                result++;
            }
        }
        return result;
    }

    private void removeFirstElement(Line[] lines)
    {
        for(int i = 1; i < lines.length ;i ++)
        {
            lines[i-1] = lines[i];
        }
        lines[lines.length -1] = null;
    }
    public static void main(String args[])
    {
        Solution main = new Solution();
        int [] data = new int[]{1,1,2,1,1};
        main.isSelfCrossing(data);
    }
}
