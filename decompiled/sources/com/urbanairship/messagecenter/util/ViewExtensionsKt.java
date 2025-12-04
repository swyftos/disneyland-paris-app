package com.urbanairship.messagecenter.util;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.urbanairship.UAirship;
import com.urbanairship.images.ImageRequestOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a/\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\rH\u0000\u001a1\u0010\u000e\u001a\u00020\u0006*\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\rH\u0000\u001a\u0016\u0010\u000f\u001a\u00020\u0006*\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0000¨\u0006\u0012"}, d2 = {"dpToPx", "", "Landroid/view/View;", "dp", "", "loadImage", "", "Landroid/widget/ImageView;", "url", "", "options", "Lkotlin/Function1;", "Lcom/urbanairship/images/ImageRequestOptions$Builder;", "Lkotlin/ExtensionFunctionType;", "loadImageOrHide", "setTextOrHide", "Landroid/widget/TextView;", "text", "urbanairship-message-center_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewExtensionsKt {
    public static final void setTextOrHide(@NotNull TextView textView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setText(str);
        textView.setVisibility((str == null || StringsKt.isBlank(str)) ? 8 : 0);
    }

    public static /* synthetic */ void loadImage$default(ImageView imageView, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: com.urbanairship.messagecenter.util.ViewExtensionsKt.loadImage.1
                public final void invoke(ImageRequestOptions.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((ImageRequestOptions.Builder) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        loadImage(imageView, str, function1);
    }

    public static final void loadImage(@NotNull final ImageView imageView, @NotNull final String url, @NotNull final Function1<? super ImageRequestOptions.Builder, Unit> options) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(options, "options");
        UAirship.shared(new UAirship.OnReadyCallback() { // from class: com.urbanairship.messagecenter.util.ViewExtensionsKt$$ExternalSyntheticLambda0
            @Override // com.urbanairship.UAirship.OnReadyCallback
            public final void onAirshipReady(UAirship uAirship) {
                ViewExtensionsKt.loadImage$lambda$0(url, options, imageView, uAirship);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadImage$lambda$0(String url, Function1 options, ImageView this_loadImage, UAirship airship) {
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(this_loadImage, "$this_loadImage");
        Intrinsics.checkNotNullParameter(airship, "airship");
        ImageRequestOptions.Builder builderNewBuilder = ImageRequestOptions.newBuilder(url);
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
        options.invoke(builderNewBuilder);
        ImageRequestOptions imageRequestOptionsBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(imageRequestOptionsBuild, "build(...)");
        airship.getImageLoader().load(this_loadImage.getContext(), this_loadImage, imageRequestOptionsBuild);
    }

    public static /* synthetic */ void loadImageOrHide$default(ImageView imageView, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: com.urbanairship.messagecenter.util.ViewExtensionsKt.loadImageOrHide.1
                public final void invoke(ImageRequestOptions.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((ImageRequestOptions.Builder) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        loadImageOrHide(imageView, str, function1);
    }

    public static final void loadImageOrHide(@NotNull ImageView imageView, @Nullable String str, @NotNull Function1<? super ImageRequestOptions.Builder, Unit> options) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        if (str != null && !StringsKt.isBlank(str)) {
            imageView.setVisibility(0);
            loadImage(imageView, str, options);
        } else {
            imageView.setVisibility(8);
        }
    }

    public static final int dpToPx(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (int) (i * view.getResources().getDisplayMetrics().density);
    }

    public static final float dpToPx(@NotNull View view, float f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return f * view.getResources().getDisplayMetrics().density;
    }
}
