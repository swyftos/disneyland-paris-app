package coil3.request;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil3.Extras;
import coil3.ExtrasKt;
import coil3.Image;
import coil3.ImageLoader;
import coil3.Image_androidKt;
import coil3.content.Collections_jvmCommonKt;
import coil3.content.Context;
import coil3.content.Utils_androidKt;
import coil3.target.ImageViewTarget;
import coil3.transform.Transformation;
import coil3.transition.CrossfadeTransition;
import coil3.transition.Transition;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0007\u0010\u000b\u001a\u001b\u0010\f\u001a\u00020\u0000*\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\b\u001a\u001b\u0010\f\u001a\u00020\u0000*\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\u000b\u001a\u001b\u0010\r\u001a\u00020\u0000*\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\b\u001a\u001b\u0010\r\u001a\u00020\u0000*\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000b\u001a%\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012¢\u0006\u0004\b\u0010\u0010\u0013\u001a\u0019\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\b\u001a\u0019\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0017\u001a\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u001c\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u0019\u0010!\u001a\u00020\u0000*\u00020\u00002\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"\u001a\u0019\u0010!\u001a\u00020\u0016*\u00020\u00162\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010#\u001a\u001b\u0010%\u001a\u00020\u0000*\u00020\u00002\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b%\u0010&\u001a\u001b\u0010%\u001a\u00020\u0016*\u00020\u00162\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b%\u0010'\u001a\u0019\u0010*\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+\u001a\u0019\u0010*\u001a\u00020\u0016*\u00020\u00162\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010,\u001a\u001b\u0010/\u001a\u00020\u0000*\u00020\u00002\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100\u001a\u001b\u0010/\u001a\u00020\u0000*\u00020\u00002\b\u0010/\u001a\u0004\u0018\u000101¢\u0006\u0004\b/\u00102\u001a\u0019\u00103\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b3\u0010+\u001a\u0019\u00103\u001a\u00020\u0016*\u00020\u00162\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b3\u0010,\u001a\u0019\u00104\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b4\u0010+\u001a\u0019\u00104\u001a\u00020\u0016*\u00020\u00162\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b4\u0010,\u001a\u0019\u00105\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b5\u0010+\u001a\u0019\u00105\u001a\u00020\u0016*\u00020\u00162\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b5\u0010,\" \u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0012068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108\"\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0018068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00108\"\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001f068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00108\"\u001c\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00108\"\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020(068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00108\"\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u000101068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00108\"\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020(068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00108\"\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020(068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00108\"\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020(068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u00108\"\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012*\u00020A8F¢\u0006\u0006\u001a\u0004\bB\u0010C\"\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012*\u00020D8F¢\u0006\u0006\u001a\u0004\bB\u0010E\"!\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001206*\u00020F8F¢\u0006\u0006\u001a\u0004\bB\u0010G\"\u0015\u0010J\u001a\u00020\u0005*\u00020A8F¢\u0006\u0006\u001a\u0004\bH\u0010I\"\u0015\u0010\u001c\u001a\u00020\u0018*\u00020A8F¢\u0006\u0006\u001a\u0004\bK\u0010L\"\u001b\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001806*\u00020F8F¢\u0006\u0006\u001a\u0004\bK\u0010G\"\u0015\u0010!\u001a\u00020\u001f*\u00020A8F¢\u0006\u0006\u001a\u0004\bM\u0010N\"\u0015\u0010!\u001a\u00020\u001f*\u00020D8F¢\u0006\u0006\u001a\u0004\bM\u0010O\"\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f06*\u00020F8F¢\u0006\u0006\u001a\u0004\bM\u0010G\"\u0017\u0010%\u001a\u0004\u0018\u00010$*\u00020A8G¢\u0006\u0006\u001a\u0004\bP\u0010Q\"\u0017\u0010%\u001a\u0004\u0018\u00010$*\u00020D8G¢\u0006\u0006\u001a\u0004\bP\u0010R\"\u001d\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$06*\u00020F8G¢\u0006\u0006\u001a\u0004\bP\u0010G\"\u0015\u0010*\u001a\u00020(*\u00020A8F¢\u0006\u0006\u001a\u0004\bS\u0010T\"\u0015\u0010*\u001a\u00020(*\u00020D8F¢\u0006\u0006\u001a\u0004\bS\u0010U\"\u001b\u0010*\u001a\b\u0012\u0004\u0012\u00020(06*\u00020F8F¢\u0006\u0006\u001a\u0004\bS\u0010G\"\u0017\u0010/\u001a\u0004\u0018\u000101*\u00020A8F¢\u0006\u0006\u001a\u0004\bV\u0010W\"\u0017\u0010/\u001a\u0004\u0018\u000101*\u00020D8F¢\u0006\u0006\u001a\u0004\bV\u0010X\"\u001d\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010106*\u00020F8F¢\u0006\u0006\u001a\u0004\bV\u0010G\"\u0015\u00103\u001a\u00020(*\u00020A8F¢\u0006\u0006\u001a\u0004\bY\u0010T\"\u0015\u00103\u001a\u00020(*\u00020D8F¢\u0006\u0006\u001a\u0004\bY\u0010U\"\u001b\u00103\u001a\b\u0012\u0004\u0012\u00020(06*\u00020F8F¢\u0006\u0006\u001a\u0004\bY\u0010G\"\u0015\u00104\u001a\u00020(*\u00020A8F¢\u0006\u0006\u001a\u0004\bZ\u0010T\"\u0015\u00104\u001a\u00020(*\u00020D8F¢\u0006\u0006\u001a\u0004\bZ\u0010U\"\u001b\u00104\u001a\b\u0012\u0004\u0012\u00020(06*\u00020F8F¢\u0006\u0006\u001a\u0004\bZ\u0010G\"\u0015\u00105\u001a\u00020(*\u00020A8F¢\u0006\u0006\u001a\u0004\b[\u0010T\"\u0015\u00105\u001a\u00020(*\u00020D8F¢\u0006\u0006\u001a\u0004\b[\u0010U\"\u001b\u00105\u001a\b\u0012\u0004\u0012\u00020(06*\u00020F8F¢\u0006\u0006\u001a\u0004\b[\u0010G¨\u0006\\"}, m1836d2 = {"Lcoil3/request/ImageRequest$Builder;", "Landroid/widget/ImageView;", "imageView", TypedValues.AttributesType.S_TARGET, "(Lcoil3/request/ImageRequest$Builder;Landroid/widget/ImageView;)Lcoil3/request/ImageRequest$Builder;", "", "drawableResId", ReactTextInputShadowNode.PROP_PLACEHOLDER, "(Lcoil3/request/ImageRequest$Builder;I)Lcoil3/request/ImageRequest$Builder;", "Landroid/graphics/drawable/Drawable;", "drawable", "(Lcoil3/request/ImageRequest$Builder;Landroid/graphics/drawable/Drawable;)Lcoil3/request/ImageRequest$Builder;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "fallback", "", "Lcoil3/transform/Transformation;", "transformations", "(Lcoil3/request/ImageRequest$Builder;[Lcoil3/transform/Transformation;)Lcoil3/request/ImageRequest$Builder;", "", "(Lcoil3/request/ImageRequest$Builder;Ljava/util/List;)Lcoil3/request/ImageRequest$Builder;", "durationMillis", "crossfade", "Lcoil3/ImageLoader$Builder;", "(Lcoil3/ImageLoader$Builder;I)Lcoil3/ImageLoader$Builder;", "Lcoil3/transition/Transition$Factory;", "newCrossfadeTransitionFactory", "(I)Lcoil3/transition/Transition$Factory;", "factory", "transitionFactory", "(Lcoil3/request/ImageRequest$Builder;Lcoil3/transition/Transition$Factory;)Lcoil3/request/ImageRequest$Builder;", "(Lcoil3/ImageLoader$Builder;Lcoil3/transition/Transition$Factory;)Lcoil3/ImageLoader$Builder;", "Landroid/graphics/Bitmap$Config;", "config", "bitmapConfig", "(Lcoil3/request/ImageRequest$Builder;Landroid/graphics/Bitmap$Config;)Lcoil3/request/ImageRequest$Builder;", "(Lcoil3/ImageLoader$Builder;Landroid/graphics/Bitmap$Config;)Lcoil3/ImageLoader$Builder;", "Landroid/graphics/ColorSpace;", "colorSpace", "(Lcoil3/request/ImageRequest$Builder;Landroid/graphics/ColorSpace;)Lcoil3/request/ImageRequest$Builder;", "(Lcoil3/ImageLoader$Builder;Landroid/graphics/ColorSpace;)Lcoil3/ImageLoader$Builder;", "", "enable", "premultipliedAlpha", "(Lcoil3/request/ImageRequest$Builder;Z)Lcoil3/request/ImageRequest$Builder;", "(Lcoil3/ImageLoader$Builder;Z)Lcoil3/ImageLoader$Builder;", "Landroidx/lifecycle/LifecycleOwner;", "owner", TCEventPropertiesNames.TCL_LIFECYCLE, "(Lcoil3/request/ImageRequest$Builder;Landroidx/lifecycle/LifecycleOwner;)Lcoil3/request/ImageRequest$Builder;", "Landroidx/lifecycle/Lifecycle;", "(Lcoil3/request/ImageRequest$Builder;Landroidx/lifecycle/Lifecycle;)Lcoil3/request/ImageRequest$Builder;", "allowConversionToBitmap", "allowHardware", "allowRgb565", "Lcoil3/Extras$Key;", "transformationsKey", "Lcoil3/Extras$Key;", "transitionFactoryKey", "bitmapConfigKey", "colorSpaceKey", "premultipliedAlphaKey", "lifecycleKey", "allowConversionToBitmapKey", "allowHardwareKey", "allowRgb565Key", "Lcoil3/request/ImageRequest;", "getTransformations", "(Lcoil3/request/ImageRequest;)Ljava/util/List;", "Lcoil3/request/Options;", "(Lcoil3/request/Options;)Ljava/util/List;", "Lcoil3/Extras$Key$Companion;", "(Lcoil3/Extras$Key$Companion;)Lcoil3/Extras$Key;", "getCrossfadeMillis", "(Lcoil3/request/ImageRequest;)I", "crossfadeMillis", "getTransitionFactory", "(Lcoil3/request/ImageRequest;)Lcoil3/transition/Transition$Factory;", "getBitmapConfig", "(Lcoil3/request/ImageRequest;)Landroid/graphics/Bitmap$Config;", "(Lcoil3/request/Options;)Landroid/graphics/Bitmap$Config;", "getColorSpace", "(Lcoil3/request/ImageRequest;)Landroid/graphics/ColorSpace;", "(Lcoil3/request/Options;)Landroid/graphics/ColorSpace;", "getPremultipliedAlpha", "(Lcoil3/request/ImageRequest;)Z", "(Lcoil3/request/Options;)Z", "getLifecycle", "(Lcoil3/request/ImageRequest;)Landroidx/lifecycle/Lifecycle;", "(Lcoil3/request/Options;)Landroidx/lifecycle/Lifecycle;", "getAllowConversionToBitmap", "getAllowHardware", "getAllowRgb565", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ImageRequests_androidKt {
    private static final Extras.Key allowConversionToBitmapKey;
    private static final Extras.Key allowHardwareKey;
    private static final Extras.Key allowRgb565Key;
    private static final Extras.Key lifecycleKey;
    private static final Extras.Key premultipliedAlphaKey;
    private static final Extras.Key transformationsKey = new Extras.Key(CollectionsKt.emptyList());
    private static final Extras.Key transitionFactoryKey = new Extras.Key(Transition.Factory.NONE);
    private static final Extras.Key bitmapConfigKey = new Extras.Key(Utils_androidKt.getDEFAULT_BITMAP_CONFIG());
    private static final Extras.Key colorSpaceKey = new Extras.Key(Utils_androidKt.getNULL_COLOR_SPACE());

    @NotNull
    public static final ImageRequest.Builder target(@NotNull ImageRequest.Builder builder, @NotNull ImageView imageView) {
        return builder.target(new ImageViewTarget(imageView));
    }

    @NotNull
    public static final ImageRequest.Builder placeholder(@NotNull ImageRequest.Builder builder, @DrawableRes final int i) {
        return builder.placeholder(new Function1() { // from class: coil3.request.ImageRequests_androidKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImageRequests_androidKt.placeholder$lambda$0(i, (ImageRequest) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Image placeholder$lambda$0(int i, ImageRequest imageRequest) {
        return Image_androidKt.asImage(Context.getDrawableCompat(imageRequest.getContext(), i));
    }

    @NotNull
    public static final ImageRequest.Builder placeholder(@NotNull ImageRequest.Builder builder, @Nullable Drawable drawable) {
        return builder.placeholder(drawable != null ? Image_androidKt.asImage(drawable) : null);
    }

    @NotNull
    public static final ImageRequest.Builder error(@NotNull ImageRequest.Builder builder, @DrawableRes final int i) {
        return builder.error(new Function1() { // from class: coil3.request.ImageRequests_androidKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImageRequests_androidKt.error$lambda$1(i, (ImageRequest) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Image error$lambda$1(int i, ImageRequest imageRequest) {
        return Image_androidKt.asImage(Context.getDrawableCompat(imageRequest.getContext(), i));
    }

    @NotNull
    public static final ImageRequest.Builder error(@NotNull ImageRequest.Builder builder, @Nullable Drawable drawable) {
        return builder.error(drawable != null ? Image_androidKt.asImage(drawable) : null);
    }

    @NotNull
    public static final ImageRequest.Builder fallback(@NotNull ImageRequest.Builder builder, @DrawableRes final int i) {
        return builder.fallback(new Function1() { // from class: coil3.request.ImageRequests_androidKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImageRequests_androidKt.fallback$lambda$2(i, (ImageRequest) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Image fallback$lambda$2(int i, ImageRequest imageRequest) {
        return Image_androidKt.asImage(Context.getDrawableCompat(imageRequest.getContext(), i));
    }

    @NotNull
    public static final ImageRequest.Builder fallback(@NotNull ImageRequest.Builder builder, @Nullable Drawable drawable) {
        return builder.fallback(drawable != null ? Image_androidKt.asImage(drawable) : null);
    }

    @NotNull
    public static final ImageRequest.Builder transformations(@NotNull ImageRequest.Builder builder, @NotNull Transformation... transformationArr) {
        return transformations(builder, (List<? extends Transformation>) ArraysKt.toList(transformationArr));
    }

    @NotNull
    public static final ImageRequest.Builder transformations(@NotNull ImageRequest.Builder builder, @NotNull List<? extends Transformation> list) {
        builder.getExtras().set(transformationsKey, Collections_jvmCommonKt.toImmutableList(list));
        final Ref.IntRef intRef = new Ref.IntRef();
        builder.memoryCacheKeyExtra("coil#transformations", CollectionsKt.joinToString$default(list, null, null, null, 0, null, new Function1() { // from class: coil3.request.ImageRequests_androidKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImageRequests_androidKt.transformations$lambda$4$lambda$3(intRef, (Transformation) obj);
            }
        }, 31, null));
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence transformations$lambda$4$lambda$3(Ref.IntRef intRef, Transformation transformation) {
        StringBuilder sb = new StringBuilder();
        int i = intRef.element;
        intRef.element = i + 1;
        sb.append(i);
        sb.append(':');
        sb.append(transformation.getCacheKey());
        return sb.toString();
    }

    @NotNull
    public static final List<Transformation> getTransformations(@NotNull ImageRequest imageRequest) {
        return (List) ExtrasKt.getExtra(imageRequest, transformationsKey);
    }

    @NotNull
    public static final List<Transformation> getTransformations(@NotNull Options options) {
        return (List) ExtrasKt.getExtra(options, transformationsKey);
    }

    @NotNull
    public static final Extras.Key<List<Transformation>> getTransformations(@NotNull Extras.Key.Companion companion) {
        return transformationsKey;
    }

    static {
        Boolean bool = Boolean.TRUE;
        premultipliedAlphaKey = new Extras.Key(bool);
        lifecycleKey = new Extras.Key(null);
        allowConversionToBitmapKey = new Extras.Key(bool);
        allowHardwareKey = new Extras.Key(bool);
        allowRgb565Key = new Extras.Key(Boolean.FALSE);
    }

    @NotNull
    public static final ImageRequest.Builder crossfade(@NotNull ImageRequest.Builder builder, int i) {
        return transitionFactory(builder, newCrossfadeTransitionFactory(i));
    }

    @NotNull
    public static final ImageLoader.Builder crossfade(@NotNull ImageLoader.Builder builder, int i) {
        return transitionFactory(builder, newCrossfadeTransitionFactory(i));
    }

    private static final Transition.Factory newCrossfadeTransitionFactory(int i) {
        if (i > 0) {
            return new CrossfadeTransition.Factory(i, false, 2, null);
        }
        return Transition.Factory.NONE;
    }

    public static final int getCrossfadeMillis(@NotNull ImageRequest imageRequest) {
        Transition.Factory transitionFactory = getTransitionFactory(imageRequest);
        CrossfadeTransition.Factory factory = transitionFactory instanceof CrossfadeTransition.Factory ? (CrossfadeTransition.Factory) transitionFactory : null;
        if (factory != null) {
            return factory.getDurationMillis();
        }
        return 0;
    }

    @NotNull
    public static final ImageRequest.Builder transitionFactory(@NotNull ImageRequest.Builder builder, @NotNull Transition.Factory factory) {
        builder.getExtras().set(transitionFactoryKey, factory);
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder transitionFactory(@NotNull ImageLoader.Builder builder, @NotNull Transition.Factory factory) {
        builder.getExtras().set(transitionFactoryKey, factory);
        return builder;
    }

    @NotNull
    public static final Transition.Factory getTransitionFactory(@NotNull ImageRequest imageRequest) {
        return (Transition.Factory) ExtrasKt.getExtra(imageRequest, transitionFactoryKey);
    }

    @NotNull
    public static final Extras.Key<Transition.Factory> getTransitionFactory(@NotNull Extras.Key.Companion companion) {
        return transitionFactoryKey;
    }

    @NotNull
    public static final ImageRequest.Builder bitmapConfig(@NotNull ImageRequest.Builder builder, @NotNull Bitmap.Config config) {
        builder.getExtras().set(bitmapConfigKey, config);
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder bitmapConfig(@NotNull ImageLoader.Builder builder, @NotNull Bitmap.Config config) {
        builder.getExtras().set(bitmapConfigKey, config);
        return builder;
    }

    @NotNull
    public static final Bitmap.Config getBitmapConfig(@NotNull ImageRequest imageRequest) {
        return (Bitmap.Config) ExtrasKt.getExtra(imageRequest, bitmapConfigKey);
    }

    @NotNull
    public static final Bitmap.Config getBitmapConfig(@NotNull Options options) {
        return (Bitmap.Config) ExtrasKt.getExtra(options, bitmapConfigKey);
    }

    @NotNull
    public static final Extras.Key<Bitmap.Config> getBitmapConfig(@NotNull Extras.Key.Companion companion) {
        return bitmapConfigKey;
    }

    @RequiresApi(26)
    @NotNull
    public static final ImageRequest.Builder colorSpace(@NotNull ImageRequest.Builder builder, @NotNull ColorSpace colorSpace) {
        builder.getExtras().set(colorSpaceKey, colorSpace);
        return builder;
    }

    @RequiresApi(26)
    @NotNull
    public static final ImageLoader.Builder colorSpace(@NotNull ImageLoader.Builder builder, @NotNull ColorSpace colorSpace) {
        builder.getExtras().set(colorSpaceKey, colorSpace);
        return builder;
    }

    @RequiresApi(26)
    @Nullable
    public static final ColorSpace getColorSpace(@NotNull ImageRequest imageRequest) {
        return (ColorSpace) ExtrasKt.getExtra(imageRequest, colorSpaceKey);
    }

    @RequiresApi(26)
    @Nullable
    public static final ColorSpace getColorSpace(@NotNull Options options) {
        return (ColorSpace) ExtrasKt.getExtra(options, colorSpaceKey);
    }

    @RequiresApi(26)
    @NotNull
    public static final Extras.Key<ColorSpace> getColorSpace(@NotNull Extras.Key.Companion companion) {
        return colorSpaceKey;
    }

    @NotNull
    public static final ImageRequest.Builder premultipliedAlpha(@NotNull ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(premultipliedAlphaKey, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder premultipliedAlpha(@NotNull ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(premultipliedAlphaKey, Boolean.valueOf(z));
        return builder;
    }

    public static final boolean getPremultipliedAlpha(@NotNull ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, premultipliedAlphaKey)).booleanValue();
    }

    public static final boolean getPremultipliedAlpha(@NotNull Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, premultipliedAlphaKey)).booleanValue();
    }

    @NotNull
    public static final Extras.Key<Boolean> getPremultipliedAlpha(@NotNull Extras.Key.Companion companion) {
        return premultipliedAlphaKey;
    }

    @NotNull
    public static final ImageRequest.Builder lifecycle(@NotNull ImageRequest.Builder builder, @Nullable LifecycleOwner lifecycleOwner) {
        return lifecycle(builder, lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null);
    }

    @NotNull
    public static final ImageRequest.Builder lifecycle(@NotNull ImageRequest.Builder builder, @Nullable Lifecycle lifecycle) {
        builder.getExtras().set(lifecycleKey, lifecycle);
        return builder;
    }

    @Nullable
    public static final Lifecycle getLifecycle(@NotNull ImageRequest imageRequest) {
        return (Lifecycle) ExtrasKt.getExtra(imageRequest, lifecycleKey);
    }

    @Nullable
    public static final Lifecycle getLifecycle(@NotNull Options options) {
        return (Lifecycle) ExtrasKt.getExtra(options, lifecycleKey);
    }

    @NotNull
    public static final Extras.Key<Lifecycle> getLifecycle(@NotNull Extras.Key.Companion companion) {
        return lifecycleKey;
    }

    @NotNull
    public static final ImageRequest.Builder allowConversionToBitmap(@NotNull ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(allowConversionToBitmapKey, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder allowConversionToBitmap(@NotNull ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(allowConversionToBitmapKey, Boolean.valueOf(z));
        return builder;
    }

    public static final boolean getAllowConversionToBitmap(@NotNull ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, allowConversionToBitmapKey)).booleanValue();
    }

    public static final boolean getAllowConversionToBitmap(@NotNull Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, allowConversionToBitmapKey)).booleanValue();
    }

    @NotNull
    public static final Extras.Key<Boolean> getAllowConversionToBitmap(@NotNull Extras.Key.Companion companion) {
        return allowConversionToBitmapKey;
    }

    @NotNull
    public static final ImageRequest.Builder allowHardware(@NotNull ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(allowHardwareKey, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder allowHardware(@NotNull ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(allowHardwareKey, Boolean.valueOf(z));
        return builder;
    }

    public static final boolean getAllowHardware(@NotNull ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, allowHardwareKey)).booleanValue();
    }

    public static final boolean getAllowHardware(@NotNull Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, allowHardwareKey)).booleanValue();
    }

    @NotNull
    public static final Extras.Key<Boolean> getAllowHardware(@NotNull Extras.Key.Companion companion) {
        return allowHardwareKey;
    }

    @NotNull
    public static final ImageRequest.Builder allowRgb565(@NotNull ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(allowRgb565Key, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder allowRgb565(@NotNull ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(allowRgb565Key, Boolean.valueOf(z));
        return builder;
    }

    public static final boolean getAllowRgb565(@NotNull ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, allowRgb565Key)).booleanValue();
    }

    public static final boolean getAllowRgb565(@NotNull Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, allowRgb565Key)).booleanValue();
    }

    @NotNull
    public static final Extras.Key<Boolean> getAllowRgb565(@NotNull Extras.Key.Companion companion) {
        return allowRgb565Key;
    }
}
