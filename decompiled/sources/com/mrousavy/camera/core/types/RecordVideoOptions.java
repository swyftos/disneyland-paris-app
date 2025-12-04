package com.mrousavy.camera.core.types;

import android.content.Context;
import com.facebook.react.bridge.ReadableMap;
import com.mrousavy.camera.core.utils.FileUtils;
import com.mrousavy.camera.core.utils.OutputFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/mrousavy/camera/core/types/RecordVideoOptions;", "", "file", "Lcom/mrousavy/camera/core/utils/OutputFile;", "videoCodec", "Lcom/mrousavy/camera/core/types/VideoCodec;", "<init>", "(Lcom/mrousavy/camera/core/utils/OutputFile;Lcom/mrousavy/camera/core/types/VideoCodec;)V", "getFile", "()Lcom/mrousavy/camera/core/utils/OutputFile;", "getVideoCodec", "()Lcom/mrousavy/camera/core/types/VideoCodec;", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RecordVideoOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final OutputFile file;
    private final VideoCodec videoCodec;

    public RecordVideoOptions(@NotNull OutputFile file, @NotNull VideoCodec videoCodec) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(videoCodec, "videoCodec");
        this.file = file;
        this.videoCodec = videoCodec;
    }

    @NotNull
    public final OutputFile getFile() {
        return this.file;
    }

    @NotNull
    public final VideoCodec getVideoCodec() {
        return this.videoCodec;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/mrousavy/camera/core/types/RecordVideoOptions$Companion;", "", "<init>", "()V", "fromJSValue", "Lcom/mrousavy/camera/core/types/RecordVideoOptions;", "context", "Landroid/content/Context;", "map", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final RecordVideoOptions fromJSValue(@NotNull Context context, @NotNull ReadableMap map) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(map, "map");
            File directory = map.hasKey("path") ? FileUtils.INSTANCE.getDirectory(map.getString("path")) : context.getCacheDir();
            VideoFileType videoFileTypeFromUnionValue = map.hasKey("fileType") ? VideoFileType.INSTANCE.fromUnionValue(map.getString("fileType")) : VideoFileType.MOV;
            VideoCodec videoCodecFromUnionValue = map.hasKey("videoCodec") ? VideoCodec.INSTANCE.fromUnionValue(map.getString("videoCodec")) : VideoCodec.H264;
            Intrinsics.checkNotNull(directory);
            return new RecordVideoOptions(new OutputFile(context, directory, videoFileTypeFromUnionValue.toExtension()), videoCodecFromUnionValue);
        }
    }
}
