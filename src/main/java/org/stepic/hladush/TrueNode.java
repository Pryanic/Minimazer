package org.stepic.hladush;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
//todo make this singletone
public class TrueNode extends ReadOnlyNode {
    public static final String VALUE = "TRUE";

    private static TrueNode instance = new TrueNode();

    private TrueNode() {
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
