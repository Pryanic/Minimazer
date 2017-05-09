package org.stepic.hladush;

import java.util.Deque;

/**
 * Created by ihladush on 06.05.17.
 */
public abstract class ReadOnlyNode extends Node {
    public ReadOnlyNode(String value) {
        super(value);
    }

    @Override
    public void calculate(Deque<Node> operands, Deque<ProcessedNode> operations) {
        operands.add(this);
    }
}
