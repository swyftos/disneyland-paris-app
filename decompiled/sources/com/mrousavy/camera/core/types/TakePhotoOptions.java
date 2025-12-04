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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/mrousavy/camera/core/types/TakePhotoOptions;", "", "file", "Lcom/mrousavy/camera/core/utils/OutputFile;", "flash", "Lcom/mrousavy/camera/core/types/Flash;", "enableShutterSound", "", "<init>", "(Lcom/mrousavy/camera/core/utils/OutputFile;Lcom/mrousavy/camera/core/types/Flash;Z)V", "getFile", "()Lcom/mrousavy/camera/core/utils/OutputFile;", "getFlash", "()Lcom/mrousavy/camera/core/types/Flash;", "getEnableShutterSound", "()Z", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TakePhotoOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean enableShutterSound;
    private final OutputFile file;
    private final Flash flash;

    public static /* synthetic */ TakePhotoOptions copy$default(TakePhotoOptions takePhotoOptions, OutputFile outputFile, Flash flash, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            outputFile = takePhotoOptions.file;
        }
        if ((i & 2) != 0) {
            flash = takePhotoOptions.flash;
        }
        if ((i & 4) != 0) {
            z = takePhotoOptions.enableShutterSound;
        }
        return takePhotoOptions.copy(outputFile, flash, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final OutputFile getFile() {
        return this.file;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final Flash getFlash() {
        return this.flash;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnableShutterSound() {
        return this.enableShutterSound;
    }

    @NotNull
    public final TakePhotoOptions copy(@NotNull OutputFile file, @NotNull Flash flash, boolean enableShutterSound) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(flash, "flash");
        return new TakePhotoOptions(file, flash, enableShutterSound);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TakePhotoOptions)) {
            return false;
        }
        TakePhotoOptions takePhotoOptions = (TakePhotoOptions) other;
        return Intrinsics.areEqual(this.file, takePhotoOptions.file) && this.flash == takePhotoOptions.flash && this.enableShutterSound == takePhotoOptions.enableShutterSound;
    }

    public int hashCode() {
        return (((this.file.hashCode() * 31) + this.flash.hashCode()) * 31) + Boolean.hashCode(this.enableShutterSound);
    }

    @NotNull
    public String toString() {
        return "TakePhotoOptions(file=" + this.file + ", flash=" + this.flash + ", enableShutterSound=" + this.enableShutterSound + ")";
    }

    public TakePhotoOptions(@NotNull OutputFile file, @NotNull Flash flash, boolean z) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(flash, "flash");
        this.file = file;
        this.flash = flash;
        this.enableShutterSound = z;
    }

    public final boolean getEnableShutterSound() {
        return this.enableShutterSound;
    }

    @NotNull
    public final OutputFile getFile() {
        return this.file;
    }

    @NotNull
    public final Flash getFlash() {
        return this.flash;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/mrousavy/camera/core/types/TakePhotoOptions$Companion;", "", "<init>", "()V", "fromJS", "Lcom/mrousavy/camera/core/types/TakePhotoOptions;", "context", "Landroid/content/Context;", "map", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final TakePhotoOptions fromJS(@NotNull Context context, @NotNull ReadableMap map) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(map, "map");
            Flash flashFromUnionValue = map.hasKey("flash") ? Flash.INSTANCE.fromUnionValue(map.getString("flash")) : Flash.OFF;
            boolean z = map.hasKey("enableShutterSound") ? map.getBoolean("enableShutterSound") : false;
            File directory = map.hasKey("path") ? FileUtils.INSTANCE.getDirectory(map.getString("path")) : context.getCacheDir();
            Intrinsics.checkNotNull(directory);
            return new TakePhotoOptions(new OutputFile(context, directory, ".jpg"), flashFromUnionValue, z);
        }
    }
}
