package com.contentsquare.android.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.proto.sessionreplay.v1.GraphMetadataKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.contentsquare.proto.sessionreplay.v1.ViewKt;
import com.contentsquare.proto.sessionreplay.v1.ViewStyleKt;
import com.google.protobuf.ByteString;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.io.File;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSessionReplayTreeLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionReplayTreeLogger.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/SessionReplayTreeLogger\n+ 2 ViewKt.kt\ncom/contentsquare/proto/sessionreplay/v1/ViewKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 GraphMetadataKt.kt\ncom/contentsquare/proto/sessionreplay/v1/GraphMetadataKtKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 ViewStyleKt.kt\ncom/contentsquare/proto/sessionreplay/v1/ViewStyleKtKt\n*L\n1#1,178:1\n11#2:179\n1#3:180\n1#3:182\n1#3:186\n11#4:181\n1855#5,2:183\n11#6:185\n*S KotlinDebug\n*F\n+ 1 SessionReplayTreeLogger.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/SessionReplayTreeLogger\n*L\n121#1:179\n121#1:180\n126#1:182\n146#1:186\n126#1:181\n131#1:183,2\n146#1:185\n*E\n"})
/* loaded from: classes2.dex */
public final class K5 {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final Logger b;

    @Nullable
    public ViewLight c;

    @Nullable
    public Bitmap d;
    public int e;

    @NotNull
    public final File f;

    public K5(Context context, PreferencesStore preferencesStore) {
        Logger logger = new Logger("SessionReplayTreeLogger");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.a = preferencesStore;
        this.b = logger;
        this.f = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), CommonProperties.FRAMES);
    }

    public static SessionRecordingV1.View a(ViewLight viewLight) {
        ViewKt.Dsl.Companion companion = ViewKt.Dsl.INSTANCE;
        SessionRecordingV1.View.Builder builderNewBuilder = SessionRecordingV1.View.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ViewKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setRecordingId(viewLight.getRecordingId());
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        ViewStyleKt.Dsl.Companion companion2 = ViewStyleKt.Dsl.INSTANCE;
        SessionRecordingV1.ViewStyle.Builder builderNewBuilder2 = SessionRecordingV1.ViewStyle.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder2, "newBuilder()");
        ViewStyleKt.Dsl dsl_create2 = companion2._create(builderNewBuilder2);
        dsl_create2.setX(viewLight.getPosX());
        dsl_create2.setY(viewLight.getPosY());
        dsl_create2.setWidth(viewLight.getWidth());
        dsl_create2.setHeight(viewLight.getHeight());
        String viewBitmapHash = viewLight.getViewBitmapHash();
        if (viewBitmapHash == null) {
            dsl_create2.setBackgroundColorHex(ExtensionsKt.toColorHex(viewLight.getBackgroundColor()));
        } else {
            byte[] encodedBitmap = viewLight.getEncodedBitmap();
            if (encodedBitmap != null) {
                ByteString byteStringCopyFrom = ByteString.copyFrom(encodedBitmap);
                Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom, "copyFrom(encodeBitmap)");
                dsl_create2.setBitmap(byteStringCopyFrom);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (viewBitmapHash == null) {
            viewBitmapHash = "null";
        }
        sb.append(viewBitmapHash);
        if (viewLight.getIsMasked()) {
            sb.append("-masked");
        }
        if (viewLight.getIsForceMasked()) {
            sb.append("-forced");
        }
        if (viewLight.getIsAnimating()) {
            sb.append("-animating");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        dsl_create2.setBitmapHash(string);
        dsl_create2.setAlpha(viewLight.getViewAlpha());
        dsl_create2.setIsVisible(viewLight.getIsVisible());
        dsl_create2.setClipChildren(viewLight.getIsClipChildren());
        dsl_create.setStyle(dsl_create2._build());
        SessionRecordingV1.View.Format formatForNumber = SessionRecordingV1.View.Format.forNumber(viewLight.getIsWebView() ? 3 : 2);
        Intrinsics.checkNotNullExpressionValue(formatForNumber, "forNumber(viewFormat)");
        dsl_create.setFormat(formatForNumber);
        if (viewLight.getClassName() != null || viewLight.getIncrementalPath() != null) {
            GraphMetadataKt.Dsl.Companion companion3 = GraphMetadataKt.Dsl.INSTANCE;
            SessionRecordingV1.GraphMetadata.Builder builderNewBuilder3 = SessionRecordingV1.GraphMetadata.newBuilder();
            Intrinsics.checkNotNullExpressionValue(builderNewBuilder3, "newBuilder()");
            GraphMetadataKt.Dsl dsl_create3 = companion3._create(builderNewBuilder3);
            String className = viewLight.getClassName();
            if (className == null) {
                className = "";
            }
            dsl_create3.setClassName(className);
            String incrementalPath = viewLight.getIncrementalPath();
            dsl_create3.setIncrementalPath(incrementalPath != null ? incrementalPath : "");
            dsl_create.setMetadata(dsl_create3._build());
        }
        Iterator<T> it = viewLight.getChildren().iterator();
        while (it.hasNext()) {
            dsl_create.addChildren(dsl_create.getChildren(), a((ViewLight) it.next()));
        }
        return dsl_create._build();
    }
}
