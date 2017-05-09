package org.stepic.hladush;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public class FalseNode extends ReadOnlyNode {
    public static final String VALUE = "FALSE";

    private static FalseNode instance = new FalseNode();

    private FalseNode() {
        super(VALUE);
    }

    public static Node getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
