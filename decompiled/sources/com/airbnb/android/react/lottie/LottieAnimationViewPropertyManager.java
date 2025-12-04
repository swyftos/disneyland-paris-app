package com.airbnb.android.react.lottie;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import ch.qos.logback.core.pattern.parser.Parser;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.util.RNLog;
import com.facebook.react.views.text.ReactFontManager;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010S\u001a\u00020TJ\u0018\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u0010:\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010\u0011R\u001c\u0010=\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u000f\"\u0004\b?\u0010\u0011R\u001c\u0010@\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000f\"\u0004\bB\u0010\u0011R\u001e\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u0010\n\u0002\u0010I\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001e\u0010J\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\bK\u0010\u001d\"\u0004\bL\u0010\u001fR\u001e\u0010M\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\bN\u0010\u001d\"\u0004\bO\u0010\u001fR\u001e\u0010P\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u0010\n\u0002\u0010I\u001a\u0004\bQ\u0010F\"\u0004\bR\u0010H¨\u0006X"}, d2 = {"Lcom/airbnb/android/react/lottie/LottieAnimationViewPropertyManager;", "", "view", "Lcom/airbnb/lottie/LottieAnimationView;", "<init>", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "viewWeakReference", "Ljava/lang/ref/WeakReference;", "TAG", "", "animationNameDirty", "", "value", "animationName", "getAnimationName", "()Ljava/lang/String;", "setAnimationName", "(Ljava/lang/String;)V", "scaleType", "Landroid/widget/ImageView$ScaleType;", "getScaleType", "()Landroid/widget/ImageView$ScaleType;", "setScaleType", "(Landroid/widget/ImageView$ScaleType;)V", "imageAssetsFolder", "getImageAssetsFolder", "setImageAssetsFolder", "enableMergePaths", "getEnableMergePaths", "()Ljava/lang/Boolean;", "setEnableMergePaths", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableSafeMode", "getEnableSafeMode", "setEnableSafeMode", "colorFilters", "Lcom/facebook/react/bridge/ReadableArray;", "getColorFilters", "()Lcom/facebook/react/bridge/ReadableArray;", "setColorFilters", "(Lcom/facebook/react/bridge/ReadableArray;)V", "textFilters", "getTextFilters", "setTextFilters", "renderMode", "Lcom/airbnb/lottie/RenderMode;", "getRenderMode", "()Lcom/airbnb/lottie/RenderMode;", "setRenderMode", "(Lcom/airbnb/lottie/RenderMode;)V", "layerType", "", "getLayerType", "()Ljava/lang/Integer;", "setLayerType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "animationJson", "getAnimationJson", "setAnimationJson", "animationURL", "getAnimationURL", "setAnimationURL", "sourceDotLottie", "getSourceDotLottie", "setSourceDotLottie", "progress", "", "getProgress", "()Ljava/lang/Float;", "setProgress", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "loop", "getLoop", "setLoop", "autoPlay", "getAutoPlay", "setAutoPlay", "speed", "getSpeed", "setSpeed", "commitChanges", "", "parseColorFilter", "colorFilter", "Lcom/facebook/react/bridge/ReadableMap;", "lottie-react-native_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLottieAnimationViewPropertyManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LottieAnimationViewPropertyManager.kt\ncom/airbnb/android/react/lottie/LottieAnimationViewPropertyManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,268:1\n1#2:269\n739#3,9:270\n37#4,2:279\n*S KotlinDebug\n*F\n+ 1 LottieAnimationViewPropertyManager.kt\ncom/airbnb/android/react/lottie/LottieAnimationViewPropertyManager\n*L\n258#1:270,9\n259#1:279,2\n*E\n"})
/* loaded from: classes2.dex */
public final class LottieAnimationViewPropertyManager {
    private final String TAG;
    private String animationJson;
    private String animationName;
    private boolean animationNameDirty;
    private String animationURL;
    private Boolean autoPlay;
    private ReadableArray colorFilters;
    private Boolean enableMergePaths;
    private Boolean enableSafeMode;
    private String imageAssetsFolder;
    private Integer layerType;
    private Boolean loop;
    private Float progress;
    private RenderMode renderMode;
    private ImageView.ScaleType scaleType;
    private String sourceDotLottie;
    private Float speed;
    private ReadableArray textFilters;
    private final WeakReference viewWeakReference;

    public LottieAnimationViewPropertyManager(@NotNull final LottieAnimationView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.TAG = "lottie-react-native";
        this.viewWeakReference = new WeakReference(view);
        view.setFontAssetDelegate(new FontAssetDelegate() { // from class: com.airbnb.android.react.lottie.LottieAnimationViewPropertyManager.1
            @Override // com.airbnb.lottie.FontAssetDelegate
            public Typeface fetchFont(String fontFamily) {
                Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
                ReactFontManager companion = ReactFontManager.INSTANCE.getInstance();
                AssetManager assets = view.getContext().getAssets();
                Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
                return companion.getTypeface(fontFamily, -1, -1, assets);
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
            @Override // com.airbnb.lottie.FontAssetDelegate
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public android.graphics.Typeface fetchFont(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
                /*
                    r2 = this;
                    java.lang.String r0 = "fontFamily"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    java.lang.String r3 = "fontStyle"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
                    java.lang.String r3 = "fontName"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)
                    int r3 = r4.hashCode()
                    r0 = -1
                    switch(r3) {
                        case -1994163307: goto L5c;
                        case -1955878649: goto L50;
                        case -1543850116: goto L47;
                        case 2076325: goto L3b;
                        case 2605753: goto L30;
                        case 64266207: goto L24;
                        case 73417974: goto L18;
                        default: goto L17;
                    }
                L17:
                    goto L64
                L18:
                    java.lang.String r3 = "Light"
                    boolean r3 = r4.equals(r3)
                    if (r3 != 0) goto L21
                    goto L64
                L21:
                    r3 = 200(0xc8, float:2.8E-43)
                    goto L68
                L24:
                    java.lang.String r3 = "Black"
                    boolean r3 = r4.equals(r3)
                    if (r3 != 0) goto L2d
                    goto L64
                L2d:
                    r3 = 900(0x384, float:1.261E-42)
                    goto L68
                L30:
                    java.lang.String r3 = "Thin"
                    boolean r3 = r4.equals(r3)
                    if (r3 == 0) goto L64
                    r3 = 100
                    goto L68
                L3b:
                    java.lang.String r3 = "Bold"
                    boolean r3 = r4.equals(r3)
                    if (r3 != 0) goto L44
                    goto L64
                L44:
                    r3 = 700(0x2bc, float:9.81E-43)
                    goto L68
                L47:
                    java.lang.String r3 = "Regular"
                    boolean r3 = r4.equals(r3)
                    if (r3 != 0) goto L59
                    goto L64
                L50:
                    java.lang.String r3 = "Normal"
                    boolean r3 = r4.equals(r3)
                    if (r3 != 0) goto L59
                    goto L64
                L59:
                    r3 = 400(0x190, float:5.6E-43)
                    goto L68
                L5c:
                    java.lang.String r3 = "Medium"
                    boolean r3 = r4.equals(r3)
                    if (r3 != 0) goto L66
                L64:
                    r3 = r0
                    goto L68
                L66:
                    r3 = 500(0x1f4, float:7.0E-43)
                L68:
                    com.facebook.react.views.text.ReactFontManager$Companion r4 = com.facebook.react.views.text.ReactFontManager.INSTANCE
                    com.facebook.react.views.text.ReactFontManager r4 = r4.getInstance()
                    com.airbnb.lottie.LottieAnimationView r2 = r1
                    android.content.Context r2 = r2.getContext()
                    android.content.res.AssetManager r2 = r2.getAssets()
                    java.lang.String r1 = "getAssets(...)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
                    android.graphics.Typeface r2 = r4.getTypeface(r5, r0, r3, r2)
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.airbnb.android.react.lottie.LottieAnimationViewPropertyManager.AnonymousClass1.fetchFont(java.lang.String, java.lang.String, java.lang.String):android.graphics.Typeface");
            }
        });
    }

    @Nullable
    public final String getAnimationName() {
        return this.animationName;
    }

    public final void setAnimationName(@Nullable String str) {
        this.animationName = str;
        this.animationNameDirty = true;
    }

    @Nullable
    public final ImageView.ScaleType getScaleType() {
        return this.scaleType;
    }

    public final void setScaleType(@Nullable ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    @Nullable
    public final String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    public final void setImageAssetsFolder(@Nullable String str) {
        this.imageAssetsFolder = str;
    }

    @Nullable
    public final Boolean getEnableMergePaths() {
        return this.enableMergePaths;
    }

    public final void setEnableMergePaths(@Nullable Boolean bool) {
        this.enableMergePaths = bool;
    }

    @Nullable
    public final Boolean getEnableSafeMode() {
        return this.enableSafeMode;
    }

    public final void setEnableSafeMode(@Nullable Boolean bool) {
        this.enableSafeMode = bool;
    }

    @Nullable
    public final ReadableArray getColorFilters() {
        return this.colorFilters;
    }

    public final void setColorFilters(@Nullable ReadableArray readableArray) {
        this.colorFilters = readableArray;
    }

    @Nullable
    public final ReadableArray getTextFilters() {
        return this.textFilters;
    }

    public final void setTextFilters(@Nullable ReadableArray readableArray) {
        this.textFilters = readableArray;
    }

    @Nullable
    public final RenderMode getRenderMode() {
        return this.renderMode;
    }

    public final void setRenderMode(@Nullable RenderMode renderMode) {
        this.renderMode = renderMode;
    }

    @Nullable
    public final Integer getLayerType() {
        return this.layerType;
    }

    public final void setLayerType(@Nullable Integer num) {
        this.layerType = num;
    }

    @Nullable
    public final String getAnimationJson() {
        return this.animationJson;
    }

    public final void setAnimationJson(@Nullable String str) {
        this.animationJson = str;
    }

    @Nullable
    public final String getAnimationURL() {
        return this.animationURL;
    }

    public final void setAnimationURL(@Nullable String str) {
        this.animationURL = str;
    }

    @Nullable
    public final String getSourceDotLottie() {
        return this.sourceDotLottie;
    }

    public final void setSourceDotLottie(@Nullable String str) {
        this.sourceDotLottie = str;
    }

    @Nullable
    public final Float getProgress() {
        return this.progress;
    }

    public final void setProgress(@Nullable Float f) {
        this.progress = f;
    }

    @Nullable
    public final Boolean getLoop() {
        return this.loop;
    }

    public final void setLoop(@Nullable Boolean bool) {
        this.loop = bool;
    }

    @Nullable
    public final Boolean getAutoPlay() {
        return this.autoPlay;
    }

    public final void setAutoPlay(@Nullable Boolean bool) {
        this.autoPlay = bool;
    }

    @Nullable
    public final Float getSpeed() {
        return this.speed;
    }

    public final void setSpeed(@Nullable Float f) {
        this.speed = f;
    }

    public final void commitChanges() {
        Object objM2968constructorimpl;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.viewWeakReference.get();
        if (lottieAnimationView == null) {
            return;
        }
        ReadableArray readableArray = this.textFilters;
        if (readableArray != null && readableArray.size() > 0) {
            TextDelegate textDelegate = new TextDelegate(lottieAnimationView);
            int size = readableArray.size();
            for (int i = 0; i < size; i++) {
                ReadableMap map = readableArray.getMap(i);
                if (map != null) {
                    textDelegate.setText(map.getString("find"), map.getString(Parser.REPLACE_CONVERTER_WORD));
                }
            }
            lottieAnimationView.setTextDelegate(textDelegate);
        }
        String str = this.animationJson;
        if (str != null) {
            lottieAnimationView.setAnimationFromJson(str, String.valueOf(str.hashCode()));
            this.animationJson = null;
        }
        String str2 = this.animationURL;
        if (str2 != null) {
            File file = new File(str2);
            if (file.exists()) {
                lottieAnimationView.setAnimation(new FileInputStream(file), String.valueOf(str2.hashCode()));
            } else {
                lottieAnimationView.setAnimationFromUrl(str2, String.valueOf(str2.hashCode()));
            }
            this.animationURL = null;
        }
        String str3 = this.sourceDotLottie;
        if (str3 != null) {
            File file2 = new File(str3);
            if (file2.exists()) {
                lottieAnimationView.setAnimation(new ZipInputStream(new FileInputStream(file2)), String.valueOf(str3.hashCode()));
                this.sourceDotLottie = null;
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                objM2968constructorimpl = Result.m2968constructorimpl(Uri.parse(str3).getScheme());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM2968constructorimpl = Result.m2968constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m2973isFailureimpl(objM2968constructorimpl)) {
                objM2968constructorimpl = null;
            }
            String str4 = (String) objM2968constructorimpl;
            if (str4 != null) {
                if (Intrinsics.areEqual(str4, "file")) {
                    String path = Uri.parse(str3).getPath();
                    if (path != null) {
                        lottieAnimationView.setAnimation(new ZipInputStream(new FileInputStream(new File(path))), String.valueOf(str3.hashCode()));
                    } else {
                        Log.w(this.TAG, "URI path is null for asset: " + str3);
                    }
                } else {
                    lottieAnimationView.setAnimationFromUrl(str3);
                }
                this.sourceDotLottie = null;
                return;
            }
            int identifier = lottieAnimationView.getResources().getIdentifier(str3, "raw", lottieAnimationView.getContext().getPackageName());
            if (identifier == 0) {
                RNLog.e("Animation for " + str3 + " was not found in raw resources");
                return;
            }
            lottieAnimationView.setAnimation(identifier);
            this.animationNameDirty = false;
            this.sourceDotLottie = null;
        }
        if (this.animationNameDirty) {
            lottieAnimationView.setAnimation(this.animationName);
            this.animationNameDirty = false;
        }
        Float f = this.progress;
        if (f != null) {
            lottieAnimationView.setProgress(f.floatValue());
            this.progress = null;
        }
        Boolean bool = this.loop;
        if (bool != null) {
            lottieAnimationView.setRepeatCount(bool.booleanValue() ? -1 : 0);
            this.loop = null;
        }
        Boolean bool2 = this.autoPlay;
        if (bool2 != null && bool2.booleanValue() && !lottieAnimationView.isAnimating()) {
            lottieAnimationView.playAnimation();
        }
        Float f2 = this.speed;
        if (f2 != null) {
            lottieAnimationView.setSpeed(f2.floatValue());
            this.speed = null;
        }
        ImageView.ScaleType scaleType = this.scaleType;
        if (scaleType != null) {
            lottieAnimationView.setScaleType(scaleType);
            this.scaleType = null;
        }
        RenderMode renderMode = this.renderMode;
        if (renderMode != null) {
            lottieAnimationView.setRenderMode(renderMode);
            this.renderMode = null;
        }
        Integer num = this.layerType;
        if (num != null) {
            lottieAnimationView.setLayerType(num.intValue(), null);
        }
        String str5 = this.imageAssetsFolder;
        if (str5 != null) {
            lottieAnimationView.setImageAssetsFolder(str5);
            this.imageAssetsFolder = null;
        }
        Boolean bool3 = this.enableMergePaths;
        if (bool3 != null) {
            lottieAnimationView.enableMergePathsForKitKatAndAbove(bool3.booleanValue());
            this.enableMergePaths = null;
        }
        Boolean bool4 = this.enableSafeMode;
        if (bool4 != null) {
            lottieAnimationView.setSafeMode(bool4.booleanValue());
            this.enableSafeMode = null;
        }
        ReadableArray readableArray2 = this.colorFilters;
        if (readableArray2 == null || readableArray2.size() <= 0) {
            return;
        }
        int size2 = readableArray2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ReadableMap map2 = readableArray2.getMap(i2);
            if (map2 != null) {
                parseColorFilter(map2, lottieAnimationView);
            }
        }
    }

    private final void parseColorFilter(ReadableMap colorFilter, LottieAnimationView view) {
        int iIntValue;
        List listEmptyList;
        if (colorFilter.getType("color") == ReadableType.Map) {
            Integer color = ColorPropConverter.getColor(colorFilter.getMap("color"), view.getContext());
            Intrinsics.checkNotNull(color);
            iIntValue = color.intValue();
        } else {
            iIntValue = colorFilter.getInt("color");
        }
        String str = colorFilter.getString("keypath") + ".**";
        String strQuote = Pattern.quote(InstructionFileId.DOT);
        Intrinsics.checkNotNullExpressionValue(strQuote, "quote(...)");
        List<String> listSplit = new Regex(strQuote).split(str, 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        view.addValueCallback(new KeyPath((String[]) Arrays.copyOf(strArr, strArr.length)), (KeyPath) LottieProperty.COLOR_FILTER, (LottieValueCallback<KeyPath>) new LottieValueCallback(new SimpleColorFilter(iIntValue)));
    }
}
