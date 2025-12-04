package org.junit.internal.runners.rules;

import org.junit.runners.model.FrameworkMember;

/* loaded from: classes6.dex */
class ValidationError extends Exception {
    private static final long serialVersionUID = 3176511008672645574L;

    public ValidationError(FrameworkMember frameworkMember, Class cls, String str) {
        super(String.format("The @%s '%s' %s", cls.getSimpleName(), frameworkMember.getName(), str));
    }
}
