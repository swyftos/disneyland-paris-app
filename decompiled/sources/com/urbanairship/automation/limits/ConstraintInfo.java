package com.urbanairship.automation.limits;

import ch.qos.logback.core.CoreConstants;
import com.urbanairship.automation.limits.storage.ConstraintEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class ConstraintInfo {
    private final ConstraintEntity constraint;
    private final List occurrences;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConstraintInfo)) {
            return false;
        }
        ConstraintInfo constraintInfo = (ConstraintInfo) obj;
        return Intrinsics.areEqual(this.constraint, constraintInfo.constraint) && Intrinsics.areEqual(this.occurrences, constraintInfo.occurrences);
    }

    public int hashCode() {
        return (this.constraint.hashCode() * 31) + this.occurrences.hashCode();
    }

    public String toString() {
        return "ConstraintInfo(constraint=" + this.constraint + ", occurrences=" + this.occurrences + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ConstraintInfo(ConstraintEntity constraint, List occurrences) {
        Intrinsics.checkNotNullParameter(constraint, "constraint");
        Intrinsics.checkNotNullParameter(occurrences, "occurrences");
        this.constraint = constraint;
        this.occurrences = occurrences;
    }

    public final ConstraintEntity getConstraint() {
        return this.constraint;
    }

    public final List getOccurrences() {
        return this.occurrences;
    }
}
