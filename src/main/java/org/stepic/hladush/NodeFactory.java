package org.stepic.hladush;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public class NodeFactory {

    public static Node createNode(String value) {
        switch (value) {
//            case "NOT":
//                return new NOTNode();
            case TrueNode.VALUE:
                return TrueNode.getInstance();
            case FalseNode.VALUE:
                return FalseNode.getInstance();
            case ORNode.VALUE:
                return new ORNode();
            case ANDNode.VALUE:
                return new ANDNode();
            case OpenBraceNode.VALUE:
                return OpenBraceNode.getInstance();
            case CloseBraceNode.VALUE:
                return CloseBraceNode.getInstance();
            default:
                return new ValueNode(value);
        }
    }

}
