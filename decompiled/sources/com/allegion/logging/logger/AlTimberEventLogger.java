package com.allegion.logging.logger;

import com.allegion.altranslation.AlJsonKt;
import com.allegion.logging.AlLogging;
import com.allegion.logging.entry.IAlEntry;
import com.allegion.logging.event.AlActionType;
import com.allegion.logging.event.AlEventType;
import com.allegion.logging.event.IAlActionEvent;
import com.allegion.logging.event.IAlCustomEvent;
import com.allegion.logging.property.AlPropertyKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\tH\u0002J\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/allegion/logging/logger/AlTimberEventLogger;", "", "()V", "EVENT_MESSAGE_FORMAT", "", "write", "", "entry", "Lcom/allegion/logging/event/IAlActionEvent;", "Lcom/allegion/logging/event/IAlCustomEvent;", "writeEntry", "Lcom/allegion/logging/entry/IAlEntry;", "writeEntry$AlLogging_release", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlTimberEventLogger {
    private static final String EVENT_MESSAGE_FORMAT = "%s\nprops: %s\nuser: %s";
    public static final AlTimberEventLogger INSTANCE = new AlTimberEventLogger();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AlActionType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AlActionType.INFO.ordinal()] = 1;
            iArr[AlActionType.FAILURE.ordinal()] = 2;
            iArr[AlActionType.SUCCESS.ordinal()] = 3;
            int[] iArr2 = new int[AlEventType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[AlEventType.INFO.ordinal()] = 1;
            iArr2[AlEventType.FAILURE.ordinal()] = 2;
            iArr2[AlEventType.SUCCESS.ordinal()] = 3;
        }
    }

    private AlTimberEventLogger() {
    }

    @JvmStatic
    public static final void writeEntry$AlLogging_release(@NotNull IAlEntry entry) {
        Intrinsics.checkParameterIsNotNull(entry, "entry");
        if (entry instanceof IAlActionEvent) {
            INSTANCE.write((IAlActionEvent) entry);
        } else if (entry instanceof IAlCustomEvent) {
            INSTANCE.write((IAlCustomEvent) entry);
        }
    }

    private final void write(IAlActionEvent entry) {
        Timber.tag(entry.getCategory());
        int i = WhenMappings.$EnumSwitchMapping$0[entry.getType().ordinal()];
        if (i == 1) {
            String action = entry.getAction();
            Object[] args = entry.getArgs();
            Timber.i(action, Arrays.copyOf(args, args.length));
        } else if (i == 2) {
            String action2 = entry.getAction();
            Object[] args2 = entry.getArgs();
            Timber.e(action2, Arrays.copyOf(args2, args2.length));
        } else {
            if (i != 3) {
                return;
            }
            String action3 = entry.getAction();
            Object[] args3 = entry.getArgs();
            Timber.i(action3, Arrays.copyOf(args3, args3.length));
        }
    }

    private final void write(IAlCustomEvent entry) {
        String json = AlJsonKt.toJson(AlPropertyKt.consolidate(AlLogging.getProperties(), entry));
        Timber.tag(entry.getCategory());
        int i = WhenMappings.$EnumSwitchMapping$1[entry.getType().ordinal()];
        if (i == 1) {
            Timber.i(EVENT_MESSAGE_FORMAT, entry.getAction(), AlJsonKt.toJson(entry.getProperties()), json);
        } else if (i == 2) {
            Timber.e(EVENT_MESSAGE_FORMAT, entry.getAction(), AlJsonKt.toJson(entry.getProperties()), json);
        } else {
            if (i != 3) {
                return;
            }
            Timber.i(EVENT_MESSAGE_FORMAT, entry.getAction(), AlJsonKt.toJson(entry.getProperties()), json);
        }
    }
}
