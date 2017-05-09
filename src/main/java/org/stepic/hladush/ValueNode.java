package org.stepic.hladush;

import java.util.regex.Pattern;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public class ValueNode extends ReadOnlyNode {
    private static final Pattern PATTERN = Pattern.compile("[^a-z]");

    public ValueNode(String value) {
        super(value);

        if (PATTERN.matcher(value).find()) {
            throw new IllegalArgumentException(
                    String.format("Not allowed value %s. Only small characters allowed", value)
            );
        }
    }

    @Override
    public String toString() {
        return getValue();
    }
}
