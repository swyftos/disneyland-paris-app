package com.allegion.accessblecredential.utility;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/allegion/accessblecredential/utility/ValidationUtility;", "", "", "data", "", "populatedValidData", "(Ljava/lang/String;)Z", "credential", "populatedValidCredentialFormat", "<init>", "()V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class ValidationUtility {
    public static final ValidationUtility INSTANCE = new ValidationUtility();

    private ValidationUtility() {
    }

    public final boolean populatedValidCredentialFormat(@Nullable String credential) {
        if (credential == null || credential.length() <= 0) {
            return false;
        }
        return (StringsKt.contains$default((CharSequence) credential, (CharSequence) "0x", false, 2, (Object) null) && credential.length() == 39) || credential.length() == 23;
    }

    public final boolean populatedValidData(@Nullable String data) {
        return data != null && data.length() > 0;
    }
}
