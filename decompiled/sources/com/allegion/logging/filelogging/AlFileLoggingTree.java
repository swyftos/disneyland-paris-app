package com.allegion.logging.filelogging;

import android.annotation.SuppressLint;
import android.util.Log;
import com.contentsquare.android.core.system.DeviceInfo;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import com.michaelflisar.lumberjack.FileLoggingSetup;
import com.michaelflisar.lumberjack.FileLoggingTree;
import com.michaelflisar.lumberjack.filter.ILogFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ/\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J9\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0014J/\u0010\u0015\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J9\u0010\u0015\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0014J/\u0010\u0016\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J9\u0010\u0016\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0014J7\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016JA\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u001dH\u0002J/\u0010\u001e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0012\u0010\u001e\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J9\u0010\u001e\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0014J/\u0010\u001f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0012\u0010\u001f\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J9\u0010\u001f\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0014J/\u0010 \u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0012\u0010 \u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J9\u0010 \u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/allegion/logging/filelogging/AlFileLoggingTree;", "Lcom/michaelflisar/lumberjack/FileLoggingTree;", "combineTags", "", "setup", "Lcom/michaelflisar/lumberjack/FileLoggingSetup;", ViewProps.FILTER, "Lcom/michaelflisar/lumberjack/filter/ILogFilter;", "(ZLcom/michaelflisar/lumberjack/FileLoggingSetup;Lcom/michaelflisar/lumberjack/filter/ILogFilter;)V", "stackDepthError", "", "d", "", "message", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "t", "", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "log", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "(ILjava/lang/String;[Ljava/lang/Object;)V", "(ILjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "logSafe", "Lkotlin/Function0;", "v", DeviceInfo.WIDTH, "wtf", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
@SuppressLint({"LogNotTimber"})
/* loaded from: classes2.dex */
public final class AlFileLoggingTree extends FileLoggingTree {
    private final String stackDepthError;

    public AlFileLoggingTree(boolean z, @Nullable FileLoggingSetup fileLoggingSetup, @Nullable ILogFilter iLogFilter) {
        super(z, fileLoggingSetup, iLogFilter);
        this.stackDepthError = "Stacktrace depth was insufficient";
    }

    @Override // timber.log.Timber.Tree
    public void v(@Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.v.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.v(message, args);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void v(@Nullable final Throwable t, @Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.v.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.v(t, message, args);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void v(@Nullable final Throwable t) {
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.v.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.v(t);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void d(@Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.d.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.d(message, args);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void d(@Nullable final Throwable t, @Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.d.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.d(t, message, args);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void d(@Nullable final Throwable t) {
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.d.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.d(t);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void i(@Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.i.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.i(message, args);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void i(@Nullable final Throwable t, @Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.i.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.i(t, message, args);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void i(@Nullable final Throwable t) {
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.i.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.i(t);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void w(@Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.w.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.w(message, args);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void w(@Nullable final Throwable t, @Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.w.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.w(t, message, args);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void w(@Nullable final Throwable t) {
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.w.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.w(t);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void e(@Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.e.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.e(message, args);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void e(@Nullable final Throwable t, @Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.e.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.e(t, message, args);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void e(@Nullable final Throwable t) {
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.e.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.e(t);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void wtf(@Nullable final Throwable t) {
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.wtf.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.wtf(t);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void wtf(@Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.wtf.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.wtf(message, args);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void wtf(@Nullable final Throwable t, @Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.wtf.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.wtf(t, message, args);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void log(final int priority, @Nullable final Throwable t) {
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.log.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.log(priority, t);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void log(final int priority, @Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.log.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.log(priority, message, args);
            }
        });
    }

    @Override // timber.log.Timber.Tree
    public void log(final int priority, @Nullable final Throwable t, @Nullable final String message, @NotNull final Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        logSafe(new Function0<Unit>() { // from class: com.allegion.logging.filelogging.AlFileLoggingTree.log.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AlFileLoggingTree.super.log(priority, t, message, args);
            }
        });
    }

    private final void logSafe(Function0<Unit> log) {
        try {
            log.invoke();
        } catch (Exception e) {
            Log.d(AlFileLoggingTree.class.getSimpleName(), this.stackDepthError);
            String simpleName = AlFileLoggingTree.class.getSimpleName();
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            Log.e(simpleName, message);
        }
    }
}
