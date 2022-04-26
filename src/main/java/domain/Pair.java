package domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public final class Pair {
    private final Currency from;
    private final Currency to;
}
