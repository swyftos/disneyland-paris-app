package com.urbanairship.iam.view;

import com.urbanairship.iam.content.Banner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m1836d2 = {"toBorderRadius", "", "Lcom/urbanairship/iam/content/Banner$Placement;", "urbanairship-automation_release"}, m1837k = 2, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class BannerViewKt {

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Banner.Placement.values().length];
            try {
                iArr[Banner.Placement.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Banner.Placement.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toBorderRadius(Banner.Placement placement) {
        int i = WhenMappings.$EnumSwitchMapping$0[placement.ordinal()];
        if (i == 1) {
            return 12;
        }
        if (i == 2) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }
}
