package preciseUnits;

import java.util.Objects;

import org.jetbrains.annotations.Nullable;

//TODO: add javadoc
public abstract class AbstractUnit {
    private static final String DEFAULT_NAME = "UNNAMED UNIT";

    public String name;

    @SuppressWarnings("unused")
    public AbstractUnit() {
        this(DEFAULT_NAME);
    }

    public AbstractUnit(@Nullable String name) {
        this.name = Objects.requireNonNullElse(name, DEFAULT_NAME);
    }
}