package com.allegion.accesssdk.utilities;

import android.content.res.Resources;
import com.allegion.logging.AlLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/allegion/accesssdk/utilities/StringHelper;", "", "<init>", "()V", "Companion", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class StringHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\"\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\t¨\u0006\f"}, d2 = {"Lcom/allegion/accesssdk/utilities/StringHelper$Companion;", "", "", "id", "", "getString", "(I)Ljava/lang/String;", "", "formatArgs", "(I[Ljava/lang/Object;)Ljava/lang/String;", "<init>", "()V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final String getString(int id) throws Resources.NotFoundException {
            try {
                String string = Resources.getSystem().getString(id);
                Intrinsics.checkExpressionValueIsNotNull(string, "Resources.getSystem().getString(id)");
                return string;
            } catch (Exception e) {
                AlLog.w(e);
                return "";
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String getString(int id, @NotNull Object... formatArgs) throws Resources.NotFoundException {
            Intrinsics.checkParameterIsNotNull(formatArgs, "formatArgs");
            try {
                String string = Resources.getSystem().getString(id, formatArgs);
                Intrinsics.checkExpressionValueIsNotNull(string, "Resources.getSystem().getString(id, formatArgs)");
                return string;
            } catch (Exception e) {
                AlLog.w(e);
                return "";
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final String getString(int i) {
        return INSTANCE.getString(i);
    }

    @JvmStatic
    @NotNull
    public static final String getString(int i, @NotNull Object... objArr) {
        return INSTANCE.getString(i, objArr);
    }
}
