package array._0341;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class NestedIterator implements Iterator<Integer> {
    private LinkedList<NestedInteger> it;
    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> result = new LinkedList<>();
        for (NestedInteger node:nestedList) {
            traverse(node, result);
        }
        this.it = result.iterator();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    private void traverse(NestedInteger root, List<Integer> result) {
        if (root.isInteger()) {
            // 到达叶子节点
            result.add(root.getInteger());
            return;
        }
        // 遍历框架
        for (NestedInteger child : root.getList()) {
            traverse(child, result);
        }
    }
}
