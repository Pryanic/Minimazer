package org.stepic.hladush;

import java.util.Deque;

/**
 * Created by ihladush on 09.05.17.
 */
public abstract class ProcessedNode extends Node {
    public ProcessedNode(String value, int priority) {
        super(value, priority);
    }

    public abstract void process(Deque<Node> operands);

}
