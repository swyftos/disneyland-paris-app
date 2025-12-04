package com.allegion.accesssdk.utilities;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ljava/util/UUID;", "", "isEmpty", "(Ljava/util/UUID;)Z", "AccessSdk_qaRelease"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class UUIDUtilityKt {
    public static final boolean isEmpty(@NotNull UUID isEmpty) {
        Intrinsics.checkParameterIsNotNull(isEmpty, "$this$isEmpty");
        return Intrinsics.areEqual(isEmpty, UUIDUtility.INSTANCE.empty());
    }
}
