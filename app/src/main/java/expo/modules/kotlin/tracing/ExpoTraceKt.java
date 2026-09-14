package expo.modules.kotlin.tracing;

import androidx.exifinterface.media.ExifInterface;
import androidx.tracing.Trace;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\"\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0081\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a7\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\b\u001a\t\u0010\u000b\u001a\u00020\nH\u0086\b\u001a#\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086\b\u001a#\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, m1836d2 = {"trace", ExifInterface.GPS_DIRECTION_TRUE, "blockName", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "tag", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "beginTraceBlock", "", "endTraceBlock", "beginAsyncTraceBlock", "cookie", "", "endAsyncTraceBlock", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nExpoTrace.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExpoTrace.kt\nexpo/modules/kotlin/tracing/ExpoTraceKt\n+ 2 Trace.kt\nandroidx/tracing/TraceKt\n*L\n1#1,62:1\n25#1:63\n27#2,5:64\n27#2,5:69\n*S KotlinDebug\n*F\n+ 1 ExpoTrace.kt\nexpo/modules/kotlin/tracing/ExpoTraceKt\n*L\n14#1:63\n14#1:64,5\n25#1:69,5\n*E\n"})
public final class ExpoTraceKt {
    public static final <T> T trace(@NotNull String tag, @NotNull String blockName, @NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(blockName, "blockName");
        Intrinsics.checkNotNullParameter(block, "block");
        Trace.beginSection("[" + tag + "] " + blockName);
        try {
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            Trace.endSection();
            InlineMarker.finallyEnd(1);
        }
    }

    @PublishedApi
    public static final <T> T trace(@NotNull String blockName, @NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(blockName, "blockName");
        Intrinsics.checkNotNullParameter(block, "block");
        Trace.beginSection("[ExpoModulesCore] " + blockName);
        try {
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            Trace.endSection();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void beginTraceBlock(@NotNull String tag, @NotNull String blockName) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(blockName, "blockName");
        Trace.beginSection("[" + tag + "] " + blockName);
    }

    public static final void endTraceBlock() {
        Trace.endSection();
    }

    public static /* synthetic */ void beginAsyncTraceBlock$default(String tag, String blockName, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(blockName, "blockName");
        Trace.beginAsyncSection("[" + tag + "] " + blockName, i);
    }

    public static final void beginAsyncTraceBlock(@NotNull String tag, @NotNull String blockName, int i) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(blockName, "blockName");
        Trace.beginAsyncSection("[" + tag + "] " + blockName, i);
    }

    public static /* synthetic */ void endAsyncTraceBlock$default(String tag, String blockName, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(blockName, "blockName");
        Trace.endAsyncSection("[" + tag + "] " + blockName, i);
    }

    public static final void endAsyncTraceBlock(@NotNull String tag, @NotNull String blockName, int i) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(blockName, "blockName");
        Trace.endAsyncSection("[" + tag + "] " + blockName, i);
    }
}
