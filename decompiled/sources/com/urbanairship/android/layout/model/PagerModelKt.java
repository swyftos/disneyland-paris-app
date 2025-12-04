package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.property.ButtonClickBehaviorType;
import com.urbanairship.android.layout.property.ButtonClickBehaviorTypeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"pagerNextFallback", "Lcom/urbanairship/android/layout/model/PagerNextFallback;", "", "Lcom/urbanairship/android/layout/property/ButtonClickBehaviorType;", "getPagerNextFallback", "(Ljava/util/List;)Lcom/urbanairship/android/layout/model/PagerNextFallback;", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PagerModelKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonClickBehaviorType.values().length];
            try {
                iArr[ButtonClickBehaviorType.PAGER_NEXT_OR_DISMISS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonClickBehaviorType.PAGER_NEXT_OR_FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final PagerNextFallback getPagerNextFallback(@NotNull List<? extends ButtonClickBehaviorType> list) {
        PagerNextFallback pagerNextFallback;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ButtonClickBehaviorType buttonClickBehaviorTypeFirstPagerNextOrNull = ButtonClickBehaviorTypeKt.firstPagerNextOrNull(list);
        if (buttonClickBehaviorTypeFirstPagerNextOrNull != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[buttonClickBehaviorTypeFirstPagerNextOrNull.ordinal()];
            if (i == 1) {
                pagerNextFallback = PagerNextFallback.DISMISS;
            } else if (i == 2) {
                pagerNextFallback = PagerNextFallback.FIRST;
            } else {
                pagerNextFallback = PagerNextFallback.NONE;
            }
            if (pagerNextFallback != null) {
                return pagerNextFallback;
            }
        }
        return PagerNextFallback.NONE;
    }
}
