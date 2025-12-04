package com.urbanairship.android.layout.view;

import com.urbanairship.android.layout.model.MediaModel;
import com.urbanairship.android.layout.widget.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
final class MediaView$configureImageView$1$iv$1$2 extends Lambda implements Function1 {
    final /* synthetic */ MediaModel $model;
    final /* synthetic */ CropImageView $this_apply;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaView$configureImageView$1$iv$1$2(CropImageView cropImageView, MediaModel mediaModel) {
        super(1);
        this.$this_apply = cropImageView;
        this.$model = mediaModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.$this_apply.setContentDescription(it);
        if (Intrinsics.areEqual(this.$model.getViewInfo().getAccessibilityHidden(), Boolean.TRUE)) {
            return;
        }
        this.$this_apply.setImportantForAccessibility(1);
    }
}
