package flatten.nested.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xudeng on 1/13/17.
 */
public class NestedIterator implements Iterator<Integer> {

    private List<NestedInteger> nestedList;
    private List<Integer> flatten;
    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.flatten = new ArrayList<>();
        travers();
        iterator = this.flatten.iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
       return iterator.hasNext();
    }

    private void travers() {
        for (NestedInteger item : nestedList) {
            visit(item);
        }
    }

    private void visit(NestedInteger item) {
        if (item.isInteger()) {
            flatten.add(item.getInteger());
        } else if (item.getList() == null ||
                item.getList().size() == 0){
            return;
        }else
        {
            for(NestedInteger subitem : item.getList())
            {
                visit(subitem);
            }
        }
    }

}
