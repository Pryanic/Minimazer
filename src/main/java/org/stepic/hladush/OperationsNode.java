package org.stepic.hladush;

import java.util.Set;

/**
 * Created by ihladush on 09.05.17.
 */
public abstract class OperationsNode extends ProcessedNode {
    public OperationsNode(String value, int priority) {
        super(value, priority);
    }

    public abstract Set<Node> getChildren();

    public abstract String toString();

    protected abstract void addOrNode(ORNode node);

    protected abstract void addTrueNode(Node node);

    protected abstract void addChild(Node node);

    protected abstract void addAndNode(ANDNode node);

    protected abstract void addFalseNode(Node node);

    protected void add(Node node) {
        switch (node.getValue()) {
            case "TRUE":
                addTrueNode(node);
                break;
            case "FALSE":
                addFalseNode(node);
                break;
            case "AND":
                addAndNode((ANDNode) node);
                break;
            case "OR":
                addOrNode((ORNode) node);
                break;
            default:
                addChild(node);
        }
    }
}
