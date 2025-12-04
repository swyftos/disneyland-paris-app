package com.brentvatne.react;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaDrm;
import android.media.MediaFormat;
import android.media.UnsupportedSchemeException;
import androidx.media3.common.MimeTypes;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J,\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\u0013"}, d2 = {"Lcom/brentvatne/react/VideoDecoderInfoModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getName", "", "getWidevineLevel", "", ContextChain.TAG_PRODUCT, "Lcom/facebook/react/bridge/Promise;", "isCodecSupported", "mimeType", "width", "", "height", "isHEVCSupported", "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVideoDecoderInfoModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoDecoderInfoModule.kt\ncom/brentvatne/react/VideoDecoderInfoModule\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,73:1\n12574#2,2:74\n*S KotlinDebug\n*F\n+ 1 VideoDecoderInfoModule.kt\ncom/brentvatne/react/VideoDecoderInfoModule\n*L\n58#1:74,2\n*E\n"})
/* loaded from: classes2.dex */
public final class VideoDecoderInfoModule extends ReactContextBaseJavaModule {

    @NotNull
    private static final String REACT_CLASS = "VideoDecoderInfoModule";

    @NotNull
    private static final String SECURITY_LEVEL_PROPERTY = "securityLevel";

    @NotNull
    private static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);

    public VideoDecoderInfoModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @ReactMethod
    public final void getWidevineLevel(@NotNull Promise p) {
        Intrinsics.checkNotNullParameter(p, "p");
        int i = 0;
        try {
            String propertyString = new MediaDrm(WIDEVINE_UUID).getPropertyString(SECURITY_LEVEL_PROPERTY);
            Intrinsics.checkNotNullExpressionValue(propertyString, "getPropertyString(...)");
            switch (propertyString.hashCode()) {
                case 2405:
                    if (propertyString.equals("L1")) {
                        i = 1;
                        break;
                    }
                    break;
                case 2406:
                    if (!propertyString.equals("L2")) {
                        break;
                    } else {
                        i = 2;
                        break;
                    }
                case 2407:
                    if (!propertyString.equals("L3")) {
                        break;
                    } else {
                        i = 3;
                        break;
                    }
            }
        } catch (UnsupportedSchemeException e) {
            e.printStackTrace();
        }
        p.resolve(Integer.valueOf(i));
    }

    @ReactMethod
    public final void isCodecSupported(@Nullable String mimeType, double width, double height, @Nullable Promise p) {
        boolean z = false;
        MediaCodecList mediaCodecList = new MediaCodecList(0);
        Intrinsics.checkNotNull(mimeType);
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(mimeType, (int) width, (int) height);
        Intrinsics.checkNotNullExpressionValue(mediaFormatCreateVideoFormat, "createVideoFormat(...)");
        String strFindDecoderForFormat = mediaCodecList.findDecoderForFormat(mediaFormatCreateVideoFormat);
        if (strFindDecoderForFormat == null) {
            if (p != null) {
                p.resolve("unsupported");
                return;
            }
            return;
        }
        MediaCodecInfo[] codecInfos = mediaCodecList.getCodecInfos();
        Intrinsics.checkNotNullExpressionValue(codecInfos, "getCodecInfos(...)");
        int length = codecInfos.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            MediaCodecInfo mediaCodecInfo = codecInfos[i];
            if (StringsKt.equals(mediaCodecInfo.getName(), strFindDecoderForFormat, true) && mediaCodecInfo.isHardwareAccelerated()) {
                z = true;
                break;
            }
            i++;
        }
        if (p != null) {
            p.resolve(z ? "software" : "hardware");
        }
    }

    @ReactMethod
    public final void isHEVCSupported(@NotNull Promise p) {
        Intrinsics.checkNotNullParameter(p, "p");
        isCodecSupported(MimeTypes.VIDEO_H265, 1920.0d, 1080.0d, p);
    }
}
