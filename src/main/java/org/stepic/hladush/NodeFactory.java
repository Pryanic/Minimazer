package org.stepic.hladush;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public class NodeFactory {

    public static Node createNode(String value){
        switch (value) {
            case "NOT":
                return new NOTNode();
            case "TRUE":
                return TrueNode.getInstance();
            case "FALSE":
                return FalseNode.getInstance();
            case "OR":
                return new ORNode();
            case "AND":
                return new ANDNode();
            default:
                return new ValueNode(value);
        }
    }

}
