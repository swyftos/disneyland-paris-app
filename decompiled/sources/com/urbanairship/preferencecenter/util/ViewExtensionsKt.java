package com.urbanairship.preferencecenter.util;

import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import com.urbanairship.UAirship;
import com.urbanairship.images.ImageRequestOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0000\u001a1\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0000\u001a\u001e\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0016\u0010\u000f\u001a\u00020\u0001*\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0000¨\u0006\u0011"}, d2 = {"loadImage", "", "Landroid/widget/ImageView;", "url", "", "options", "Lkotlin/Function1;", "Lcom/urbanairship/images/ImageRequestOptions$Builder;", "Lkotlin/ExtensionFunctionType;", "loadImageOrHide", "setHtml", "Landroid/widget/TextView;", "html", "linkify", "", "setTextOrHide", "text", "urbanairship-preference-center_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewExtensions.kt\ncom/urbanairship/preferencecenter/util/ViewExtensionsKt\n+ 2 Html.kt\nandroidx/core/text/HtmlKt\n*L\n1#1,39:1\n39#2,5:40\n*S KotlinDebug\n*F\n+ 1 ViewExtensions.kt\ncom/urbanairship/preferencecenter/util/ViewExtensionsKt\n*L\n37#1:40,5\n*E\n"})
/* loaded from: classes5.dex */
public final class ViewExtensionsKt {
    public static final void setTextOrHide(@NotNull TextView textView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setText(str);
        textView.setVisibility((str == null || StringsKt.isBlank(str)) ? 8 : 0);
    }

    public static /* synthetic */ void loadImage$default(ImageView imageView, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: com.urbanairship.preferencecenter.util.ViewExtensionsKt.loadImage.1
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
        UAirship.shared(new UAirship.OnReadyCallback() { // from class: com.urbanairship.preferencecenter.util.ViewExtensionsKt$$ExternalSyntheticLambda0
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
            function1 = new Function1() { // from class: com.urbanairship.preferencecenter.util.ViewExtensionsKt.loadImageOrHide.1
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

    public static /* synthetic */ void setHtml$default(TextView textView, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        setHtml(textView, str, z);
    }

    public static final void setHtml(@NotNull TextView textView, @NotNull String html, boolean z) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(html, "html");
        if (z) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setLinksClickable(true);
        }
        textView.setText(HtmlCompat.fromHtml(html, 0, null, null));
    }
}
