package pub;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuhjhj
 * @date 2022/5/11
 **/
public class StringTreeNode {

    public String val;
    public List<StringTreeNode> children;

    public StringTreeNode(String val) {
        this();
        this.val = val;
    }

    StringTreeNode() {
        children = new ArrayList<>(16);
    }
}
