package com.allegion.logging.logger;

import com.allegion.logging.entry.AlLoggingLevel;
import com.allegion.logging.entry.IAlEntry;
import com.allegion.logging.entry.IAlExceptionEntry;
import com.allegion.logging.entry.IAlExceptionLogEntry;
import com.allegion.logging.entry.IAlLogEntry;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/allegion/logging/logger/AlTimberEntryLogger;", "", "()V", "write", "", "entry", "Lcom/allegion/logging/entry/IAlExceptionEntry;", "Lcom/allegion/logging/entry/IAlExceptionLogEntry;", "Lcom/allegion/logging/entry/IAlLogEntry;", "writeEntry", "Lcom/allegion/logging/entry/IAlEntry;", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlTimberEntryLogger {
    public static final AlTimberEntryLogger INSTANCE = new AlTimberEntryLogger();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[AlLoggingLevel.values().length];
            $EnumSwitchMapping$0 = iArr;
            AlLoggingLevel alLoggingLevel = AlLoggingLevel.DEBUG;
            iArr[alLoggingLevel.ordinal()] = 1;
            AlLoggingLevel alLoggingLevel2 = AlLoggingLevel.WARNING;
            iArr[alLoggingLevel2.ordinal()] = 2;
            AlLoggingLevel alLoggingLevel3 = AlLoggingLevel.INFO;
            iArr[alLoggingLevel3.ordinal()] = 3;
            AlLoggingLevel alLoggingLevel4 = AlLoggingLevel.ERROR;
            iArr[alLoggingLevel4.ordinal()] = 4;
            AlLoggingLevel alLoggingLevel5 = AlLoggingLevel.VERBOSE;
            iArr[alLoggingLevel5.ordinal()] = 5;
            AlLoggingLevel alLoggingLevel6 = AlLoggingLevel.ASSERT;
            iArr[alLoggingLevel6.ordinal()] = 6;
            int[] iArr2 = new int[AlLoggingLevel.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[alLoggingLevel.ordinal()] = 1;
            iArr2[alLoggingLevel2.ordinal()] = 2;
            iArr2[alLoggingLevel3.ordinal()] = 3;
            iArr2[alLoggingLevel4.ordinal()] = 4;
            iArr2[alLoggingLevel5.ordinal()] = 5;
            iArr2[alLoggingLevel6.ordinal()] = 6;
            int[] iArr3 = new int[AlLoggingLevel.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[alLoggingLevel.ordinal()] = 1;
            iArr3[alLoggingLevel2.ordinal()] = 2;
            iArr3[alLoggingLevel3.ordinal()] = 3;
            iArr3[alLoggingLevel4.ordinal()] = 4;
            iArr3[alLoggingLevel5.ordinal()] = 5;
            iArr3[alLoggingLevel6.ordinal()] = 6;
        }
    }

    private AlTimberEntryLogger() {
    }

    @JvmStatic
    public static final void writeEntry(@NotNull IAlEntry entry) {
        Intrinsics.checkParameterIsNotNull(entry, "entry");
        if (entry instanceof IAlLogEntry) {
            INSTANCE.write((IAlLogEntry) entry);
        } else if (entry instanceof IAlExceptionLogEntry) {
            INSTANCE.write((IAlExceptionLogEntry) entry);
        } else if (entry instanceof IAlExceptionEntry) {
            INSTANCE.write((IAlExceptionEntry) entry);
        }
    }

    private final void write(IAlLogEntry entry) {
        Timber.tag(entry.getCategory() + ' ' + entry.getAction());
        switch (WhenMappings.$EnumSwitchMapping$0[entry.getLevel().ordinal()]) {
            case 1:
                String message = entry.getMessage();
                Object[] args = entry.getArgs();
                Timber.d(message, Arrays.copyOf(args, args.length));
                break;
            case 2:
                String message2 = entry.getMessage();
                Object[] args2 = entry.getArgs();
                Timber.w(message2, Arrays.copyOf(args2, args2.length));
                break;
            case 3:
                String message3 = entry.getMessage();
                Object[] args3 = entry.getArgs();
                Timber.i(message3, Arrays.copyOf(args3, args3.length));
                break;
            case 4:
                String message4 = entry.getMessage();
                Object[] args4 = entry.getArgs();
                Timber.e(message4, Arrays.copyOf(args4, args4.length));
                break;
            case 5:
                String message5 = entry.getMessage();
                Object[] args5 = entry.getArgs();
                Timber.v(message5, Arrays.copyOf(args5, args5.length));
                break;
            case 6:
                String message6 = entry.getMessage();
                Object[] args6 = entry.getArgs();
                Timber.wtf(message6, Arrays.copyOf(args6, args6.length));
                break;
        }
    }

    private final void write(IAlExceptionEntry entry) {
        Timber.tag(entry.getCategory() + ' ' + entry.getAction());
        switch (WhenMappings.$EnumSwitchMapping$1[entry.getLevel().ordinal()]) {
            case 1:
                Timber.d(entry.getException());
                break;
            case 2:
                Timber.w(entry.getException());
                break;
            case 3:
                Timber.i(entry.getException());
                break;
            case 4:
                Timber.e(entry.getException());
                break;
            case 5:
                Timber.v(entry.getException());
                break;
            case 6:
                Timber.wtf(entry.getException());
                break;
        }
    }

    private final void write(IAlExceptionLogEntry entry) {
        Timber.tag(entry.getCategory() + ' ' + entry.getAction());
        switch (WhenMappings.$EnumSwitchMapping$2[entry.getLevel().ordinal()]) {
            case 1:
                Throwable exception = entry.getException();
                String message = entry.getMessage();
                Object[] args = entry.getArgs();
                Timber.d(exception, message, Arrays.copyOf(args, args.length));
                break;
            case 2:
                Throwable exception2 = entry.getException();
                String message2 = entry.getMessage();
                Object[] args2 = entry.getArgs();
                Timber.w(exception2, message2, Arrays.copyOf(args2, args2.length));
                break;
            case 3:
                Throwable exception3 = entry.getException();
                String message3 = entry.getMessage();
                Object[] args3 = entry.getArgs();
                Timber.i(exception3, message3, Arrays.copyOf(args3, args3.length));
                break;
            case 4:
                Throwable exception4 = entry.getException();
                String message4 = entry.getMessage();
                Object[] args4 = entry.getArgs();
                Timber.e(exception4, message4, Arrays.copyOf(args4, args4.length));
                break;
            case 5:
                Throwable exception5 = entry.getException();
                String message5 = entry.getMessage();
                Object[] args5 = entry.getArgs();
                Timber.v(exception5, message5, Arrays.copyOf(args5, args5.length));
                break;
            case 6:
                Throwable exception6 = entry.getException();
                String message6 = entry.getMessage();
                Object[] args6 = entry.getArgs();
                Timber.wtf(exception6, message6, Arrays.copyOf(args6, args6.length));
                break;
        }
    }
}
