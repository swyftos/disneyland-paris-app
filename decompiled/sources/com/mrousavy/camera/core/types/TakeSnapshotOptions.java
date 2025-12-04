package com.mrousavy.camera.core.types;

import android.content.Context;
import com.facebook.react.bridge.ReadableMap;
import com.mrousavy.camera.core.utils.FileUtils;
import com.mrousavy.camera.core.utils.OutputFile;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/mrousavy/camera/core/types/TakeSnapshotOptions;", "", "file", "Lcom/mrousavy/camera/core/utils/OutputFile;", "quality", "", "<init>", "(Lcom/mrousavy/camera/core/utils/OutputFile;I)V", "getFile", "()Lcom/mrousavy/camera/core/utils/OutputFile;", "getQuality", "()I", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TakeSnapshotOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final OutputFile file;
    private final int quality;

    public static /* synthetic */ TakeSnapshotOptions copy$default(TakeSnapshotOptions takeSnapshotOptions, OutputFile outputFile, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            outputFile = takeSnapshotOptions.file;
        }
        if ((i2 & 2) != 0) {
            i = takeSnapshotOptions.quality;
        }
        return takeSnapshotOptions.copy(outputFile, i);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final OutputFile getFile() {
        return this.file;
    }

    /* renamed from: component2, reason: from getter */
    public final int getQuality() {
        return this.quality;
    }

    @NotNull
    public final TakeSnapshotOptions copy(@NotNull OutputFile file, int quality) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new TakeSnapshotOptions(file, quality);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TakeSnapshotOptions)) {
            return false;
        }
        TakeSnapshotOptions takeSnapshotOptions = (TakeSnapshotOptions) other;
        return Intrinsics.areEqual(this.file, takeSnapshotOptions.file) && this.quality == takeSnapshotOptions.quality;
    }

    public int hashCode() {
        return (this.file.hashCode() * 31) + Integer.hashCode(this.quality);
    }

    @NotNull
    public String toString() {
        return "TakeSnapshotOptions(file=" + this.file + ", quality=" + this.quality + ")";
    }

    public TakeSnapshotOptions(@NotNull OutputFile file, int i) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        this.quality = i;
    }

    @NotNull
    public final OutputFile getFile() {
        return this.file;
    }

    public final int getQuality() {
        return this.quality;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/mrousavy/camera/core/types/TakeSnapshotOptions$Companion;", "", "<init>", "()V", "fromJSValue", "Lcom/mrousavy/camera/core/types/TakeSnapshotOptions;", "context", "Landroid/content/Context;", "map", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final TakeSnapshotOptions fromJSValue(@NotNull Context context, @NotNull ReadableMap map) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(map, "map");
            int i = map.hasKey("quality") ? map.getInt("quality") : 100;
            File directory = map.hasKey("path") ? FileUtils.INSTANCE.getDirectory(map.getString("path")) : context.getCacheDir();
            Intrinsics.checkNotNull(directory);
            return new TakeSnapshotOptions(new OutputFile(context, directory, ".jpg"), i);
        }
    }
}
