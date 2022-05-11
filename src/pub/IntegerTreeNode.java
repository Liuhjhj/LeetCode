package pub;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuhjhj
 * @date 2022/5/11
 **/
public class IntegerTreeNode {

    String val;
    List<StringTreeNode> children;

    IntegerTreeNode(String val) {
        this();
        this.val = val;
    }

    IntegerTreeNode() {
        children = new ArrayList<>(16);
    }
}
