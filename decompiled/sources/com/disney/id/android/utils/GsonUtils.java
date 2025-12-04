package com.disney.id.android.utils;

import com.disney.id.android.lightbox.InjectedExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/disney/id/android/utils/GsonUtils;", "", "()V", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GsonUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/disney/id/android/utils/GsonUtils$Companion;", "", "()V", "createStandardGson", "Lcom/google/gson/Gson;", "prettyPrint", "", "disableHtmlEscaping", "serializeNulls", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Gson createStandardGson$default(Companion companion, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            if ((i & 4) != 0) {
                z3 = true;
            }
            return companion.createStandardGson(z, z2, z3);
        }

        @NotNull
        public final Gson createStandardGson(boolean prettyPrint, boolean disableHtmlEscaping, boolean serializeNulls) {
            GsonBuilder dateFormat = new GsonBuilder().setExclusionStrategies(new InjectedExclusionStrategy()).setDateFormat(StringPatterns.dateFormatPattern);
            if (serializeNulls) {
                dateFormat.serializeNulls();
            }
            if (prettyPrint) {
                dateFormat.setPrettyPrinting();
            }
            if (disableHtmlEscaping) {
                dateFormat.disableHtmlEscaping();
            }
            Gson gsonCreate = dateFormat.create();
            Intrinsics.checkNotNullExpressionValue(gsonCreate, "create(...)");
            return gsonCreate;
        }
    }
}
