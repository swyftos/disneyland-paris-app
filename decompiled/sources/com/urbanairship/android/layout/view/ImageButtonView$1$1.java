package com.urbanairship.android.layout.view;

import android.content.Context;
import com.urbanairship.android.layout.util.ResourceUtils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
final class ImageButtonView$1$1 extends Lambda implements Function1 {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImageButtonView$1$1(Context context) {
        super(1);
        this.$context = context;
    }

    public final Float invoke(int i) {
        return Float.valueOf(ResourceUtils.dpToPx(this.$context, i));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
