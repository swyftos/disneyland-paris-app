package com.urbanairship.android.layout.view;

import android.content.Context;
import com.urbanairship.android.layout.util.CachedImage;
import com.urbanairship.android.layout.view.BaseView;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/urbanairship/android/layout/view/ImageButtonView$1$2", "Lcom/urbanairship/android/layout/view/BaseView$VisibilityChangeListener;", "onVisibilityChanged", "", "visibility", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageButtonView$1$2 implements BaseView.VisibilityChangeListener {
    final /* synthetic */ CachedImage $cached;
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.BooleanRef $isLoaded;
    final /* synthetic */ String $url;
    final /* synthetic */ ImageButtonView this$0;

    ImageButtonView$1$2(Ref.BooleanRef booleanRef, String str, Context context, ImageButtonView imageButtonView, CachedImage cachedImage) {
        this.$isLoaded = booleanRef;
        this.$url = str;
        this.$context = context;
        this.this$0 = imageButtonView;
        this.$cached = cachedImage;
    }

    @Override // com.urbanairship.android.layout.view.BaseView.VisibilityChangeListener
    public void onVisibilityChanged(int visibility) {
        if (visibility == 0) {
            Ref.BooleanRef booleanRef = this.$isLoaded;
            if (booleanRef.element) {
                return;
            }
            ImageButtonView.lambda$0$loadImage(this.$context, this.this$0, this.$cached, booleanRef, this.$url);
        }
    }
}
