package com.urbanairship.automation.deferred;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m1836d2 = {"isInAppMessage", "", "Lcom/urbanairship/automation/deferred/DeferredAutomationData;", "urbanairship-automation_release"}, m1837k = 2, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class DeferredAutomationDataKt {

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeferredAutomationData.DeferredType.values().length];
            try {
                iArr[DeferredAutomationData.DeferredType.IN_APP_MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeferredAutomationData.DeferredType.ACTIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isInAppMessage(@NotNull DeferredAutomationData deferredAutomationData) {
        Intrinsics.checkNotNullParameter(deferredAutomationData, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[deferredAutomationData.getType().ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }
}
