package com.urbanairship.embedded;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class EmbeddedSize {
    private final EmbeddedDimension height;
    private final EmbeddedDimension width;

    public final EmbeddedDimension component1() {
        return this.width;
    }

    public final EmbeddedDimension component2() {
        return this.height;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmbeddedSize)) {
            return false;
        }
        EmbeddedSize embeddedSize = (EmbeddedSize) obj;
        return Intrinsics.areEqual(this.width, embeddedSize.width) && Intrinsics.areEqual(this.height, embeddedSize.height);
    }

    public int hashCode() {
        return (this.width.hashCode() * 31) + this.height.hashCode();
    }

    public String toString() {
        return "EmbeddedSize(width=" + this.width + ", height=" + this.height + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public EmbeddedSize(EmbeddedDimension width, EmbeddedDimension height) {
        Intrinsics.checkNotNullParameter(width, "width");
        Intrinsics.checkNotNullParameter(height, "height");
        this.width = width;
        this.height = height;
    }
}
