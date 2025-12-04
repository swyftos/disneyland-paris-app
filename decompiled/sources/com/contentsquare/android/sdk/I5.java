package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class I5 {

    @NotNull
    public static final Logger a = new Logger("SessionReplayRules");

    @NotNull
    public static final L4 a(@NotNull L4 input, @NotNull String ruleName, @NotNull Function0<? extends L4> rule) {
        L4 output;
        String str;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(ruleName, "ruleName");
        Intrinsics.checkNotNullParameter(rule, "rule");
        int iOrdinal = input.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            output = input;
        } else if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            output = input;
        } else {
            output = rule.invoke();
        }
        Intrinsics.checkNotNullParameter(ruleName, "ruleName");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        if (input == L4.EVALUATE) {
            int iOrdinal2 = output.ordinal();
            if (iOrdinal2 == 0) {
                str = "session replay will start.";
            } else if (iOrdinal2 == 1) {
                str = "session replay will stop.";
            } else if (iOrdinal2 == 2) {
                str = "continue evaluate.";
            } else {
                if (iOrdinal2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "breaking the rule chain.";
            }
            a.d("-> " + StringsKt.padEnd(ruleName, 30, '.') + " applied, " + str + ' ');
        }
        return output;
    }
}
