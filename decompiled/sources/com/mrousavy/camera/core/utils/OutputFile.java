package com.mrousavy.camera.core.utils;

import android.content.Context;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\n \u0011*\u0004\u0018\u00010\u00050\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0012\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/mrousavy/camera/core/utils/OutputFile;", "", "context", "Landroid/content/Context;", "directory", "Ljava/io/File;", "extension", "", "<init>", "(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getDirectory", "()Ljava/io/File;", "getExtension", "()Ljava/lang/String;", "file", "kotlin.jvm.PlatformType", "getFile", "Ljava/io/File;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class OutputFile {
    private final Context context;
    private final File directory;
    private final String extension;
    private final File file;

    public static /* synthetic */ OutputFile copy$default(OutputFile outputFile, Context context, File file, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            context = outputFile.context;
        }
        if ((i & 2) != 0) {
            file = outputFile.directory;
        }
        if ((i & 4) != 0) {
            str = outputFile.extension;
        }
        return outputFile.copy(context, file, str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final File getDirectory() {
        return this.directory;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getExtension() {
        return this.extension;
    }

    @NotNull
    public final OutputFile copy(@NotNull Context context, @NotNull File directory, @NotNull String extension) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(extension, "extension");
        return new OutputFile(context, directory, extension);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutputFile)) {
            return false;
        }
        OutputFile outputFile = (OutputFile) other;
        return Intrinsics.areEqual(this.context, outputFile.context) && Intrinsics.areEqual(this.directory, outputFile.directory) && Intrinsics.areEqual(this.extension, outputFile.extension);
    }

    public int hashCode() {
        return (((this.context.hashCode() * 31) + this.directory.hashCode()) * 31) + this.extension.hashCode();
    }

    @NotNull
    public String toString() {
        return "OutputFile(context=" + this.context + ", directory=" + this.directory + ", extension=" + this.extension + ")";
    }

    public OutputFile(@NotNull Context context, @NotNull File directory, @NotNull String extension) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(extension, "extension");
        this.context = context;
        this.directory = directory;
        this.extension = extension;
        File fileCreateTempFile = File.createTempFile("mrousavy", extension, directory);
        this.file = fileCreateTempFile;
        String absolutePath = directory.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        String absolutePath2 = context.getCacheDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
        if (StringsKt.contains$default((CharSequence) absolutePath, (CharSequence) absolutePath2, false, 2, (Object) null)) {
            fileCreateTempFile.deleteOnExit();
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final File getDirectory() {
        return this.directory;
    }

    @NotNull
    public final String getExtension() {
        return this.extension;
    }

    public final File getFile() {
        return this.file;
    }
}
