package org.stepic.hladush;

import java.util.Deque;

/**
 * Created by ihladush on 09.05.17.
 */
public abstract class BraceNode extends ProcessedNode {
    public BraceNode(String value, int priority) {
        super(value, priority);
    }

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public void process(Deque<Node> operands, Deque<ProcessedNode> operations) {
        throw new UnsupportedOperationException("This operations doesn't support");
    }
}
