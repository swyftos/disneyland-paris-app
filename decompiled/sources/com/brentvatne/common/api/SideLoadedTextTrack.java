package com.brentvatne.common.api;

import android.net.Uri;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.brentvatne.common.toolbox.ReactBridgeUtils;
import com.facebook.react.bridge.ReadableMap;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/brentvatne/common/api/SideLoadedTextTrack;", "", "<init>", "()V", TCEventPropertiesNames.TCD_LANGUAGE, "", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "type", "getType", "setType", "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SideLoadedTextTrack {
    private String language;
    private String title;
    private String type;
    private Uri uri;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String SIDELOAD_TEXT_TRACK_LANGUAGE = TCEventPropertiesNames.TCD_LANGUAGE;
    private static final String SIDELOAD_TEXT_TRACK_TITLE = "title";
    private static final String SIDELOAD_TEXT_TRACK_URI = ReactNativeBlobUtilConst.DATA_ENCODE_URI;
    private static final String SIDELOAD_TEXT_TRACK_TYPE = "type";

    public SideLoadedTextTrack() {
        Uri EMPTY = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        this.uri = EMPTY;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(@Nullable String str) {
        this.language = str;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public final Uri getUri() {
        return this.uri;
    }

    public final void setUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<set-?>");
        this.uri = uri;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/brentvatne/common/api/SideLoadedTextTrack$Companion;", "", "<init>", "()V", "SIDELOAD_TEXT_TRACK_LANGUAGE", "", "getSIDELOAD_TEXT_TRACK_LANGUAGE", "()Ljava/lang/String;", "SIDELOAD_TEXT_TRACK_TITLE", "getSIDELOAD_TEXT_TRACK_TITLE", "SIDELOAD_TEXT_TRACK_URI", "getSIDELOAD_TEXT_TRACK_URI", "SIDELOAD_TEXT_TRACK_TYPE", "getSIDELOAD_TEXT_TRACK_TYPE", "parse", "Lcom/brentvatne/common/api/SideLoadedTextTrack;", "src", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String getSIDELOAD_TEXT_TRACK_LANGUAGE() {
            return SideLoadedTextTrack.SIDELOAD_TEXT_TRACK_LANGUAGE;
        }

        @NotNull
        public final String getSIDELOAD_TEXT_TRACK_TITLE() {
            return SideLoadedTextTrack.SIDELOAD_TEXT_TRACK_TITLE;
        }

        @NotNull
        public final String getSIDELOAD_TEXT_TRACK_URI() {
            return SideLoadedTextTrack.SIDELOAD_TEXT_TRACK_URI;
        }

        @NotNull
        public final String getSIDELOAD_TEXT_TRACK_TYPE() {
            return SideLoadedTextTrack.SIDELOAD_TEXT_TRACK_TYPE;
        }

        @NotNull
        public final SideLoadedTextTrack parse(@Nullable ReadableMap src) {
            SideLoadedTextTrack sideLoadedTextTrack = new SideLoadedTextTrack();
            if (src == null) {
                return sideLoadedTextTrack;
            }
            sideLoadedTextTrack.setLanguage(ReactBridgeUtils.safeGetString(src, getSIDELOAD_TEXT_TRACK_LANGUAGE()));
            sideLoadedTextTrack.setTitle(ReactBridgeUtils.safeGetString(src, getSIDELOAD_TEXT_TRACK_TITLE(), ""));
            sideLoadedTextTrack.setUri(Uri.parse(ReactBridgeUtils.safeGetString(src, getSIDELOAD_TEXT_TRACK_URI(), "")));
            sideLoadedTextTrack.setType(ReactBridgeUtils.safeGetString(src, getSIDELOAD_TEXT_TRACK_TYPE(), ""));
            return sideLoadedTextTrack;
        }
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }
}
