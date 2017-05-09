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

    protected abstract void addTrueNode();

    protected abstract void addChild(Node node);

    protected abstract void addAndNode(ANDNode node);

    protected abstract void addFalseNode();

    protected abstract void addNotNode(NOTNode node);

    protected void add(Node node) {
        switch (node.getValue()) {
            case "TRUE":
                addTrueNode();
                break;
            case "FALSE":
                addFalseNode();
                break;
            case "AND":
                addAndNode((ANDNode) node);
                break;
            case "OR":
                addOrNode((ORNode) node);
                break;
            case "NOT":
                addNotNode((NOTNode)node);
            default:
                addChild(node);
        }
    }
}
