package org.stepic.hladush;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public abstract class Node {
    private Node parent;
    private boolean isOperation;
    private String value;

    public Node(boolean isOperation,String value) {
        this.isOperation = isOperation;
    }
}
