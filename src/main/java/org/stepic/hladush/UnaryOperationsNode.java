package org.stepic.hladush;

/**
 * Created by ihladush on 09.05.17.
 */
public  abstract class UnaryOperationsNode extends OperationsNode {
    public UnaryOperationsNode(String value, int priority) {
        super(value, priority);
    }

    public abstract Node getSingleChild();

}
