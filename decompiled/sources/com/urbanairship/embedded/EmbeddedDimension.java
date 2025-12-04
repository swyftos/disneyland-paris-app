package com.urbanairship.embedded;

import ch.qos.logback.core.CoreConstants;

/* loaded from: classes5.dex */
final class EmbeddedDimension {
    private final boolean fill;
    private final int spec;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmbeddedDimension)) {
            return false;
        }
        EmbeddedDimension embeddedDimension = (EmbeddedDimension) obj;
        return this.spec == embeddedDimension.spec && this.fill == embeddedDimension.fill;
    }

    public int hashCode() {
        return (Integer.hashCode(this.spec) * 31) + Boolean.hashCode(this.fill);
    }

    public String toString() {
        return "EmbeddedDimension(spec=" + this.spec + ", fill=" + this.fill + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public EmbeddedDimension(int i, boolean z) {
        this.spec = i;
        this.fill = z;
    }

    public final int getSpec() {
        return this.spec;
    }

    public final boolean getFill() {
        return this.fill;
    }
}
