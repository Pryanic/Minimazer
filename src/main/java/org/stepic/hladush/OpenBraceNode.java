package org.stepic.hladush;

import java.util.Deque;

/**
 * Created by ihladush on 06.05.17.
 */
public class OpenBraceNode extends BraceNode {
    public static final String VALUE = "(";
    private final static OpenBraceNode INSTANCE = new OpenBraceNode();

    private OpenBraceNode() {
        super(VALUE, Integer.MIN_VALUE);
    }

    public static OpenBraceNode getInstance() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public void calculate(Deque<Node> operands, Deque<ProcessedNode> operations) {
        operations.add(this);
    }
}
