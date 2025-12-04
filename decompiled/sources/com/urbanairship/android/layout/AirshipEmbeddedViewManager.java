package com.urbanairship.android.layout;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.joran.action.Action;
import com.google.firebase.messaging.Constants;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.display.DisplayArgs;
import com.urbanairship.android.layout.info.LayoutInfo;
import com.urbanairship.embedded.AirshipEmbeddedInfo;
import com.urbanairship.json.JsonMap;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017JJ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH'J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH'J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J<\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\n\u001a\u00020\u000b2\u001c\b\u0002\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH'¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/AirshipEmbeddedViewManager;", "", "addPending", "", "args", "Lcom/urbanairship/android/layout/display/DisplayArgs;", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "extras", "Lcom/urbanairship/json/JsonMap;", "embeddedViewId", "", "viewInstanceId", "layoutInfoProvider", "Lkotlin/Function0;", "Lcom/urbanairship/android/layout/info/LayoutInfo;", "displayArgsProvider", "allPending", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/urbanairship/android/layout/EmbeddedDisplayRequest;", "dismiss", "dismissAll", "displayRequests", "Lcom/urbanairship/android/layout/EmbeddedDisplayRequestResult;", "comparator", "Ljava/util/Comparator;", "Lcom/urbanairship/embedded/AirshipEmbeddedInfo;", "Lkotlin/Comparator;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface AirshipEmbeddedViewManager {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    void addPending(@NotNull String embeddedViewId, @NotNull String viewInstanceId, int priority, @NotNull JsonMap extras, @NotNull Function0<LayoutInfo> layoutInfoProvider, @NotNull Function0<DisplayArgs> displayArgsProvider);

    @NotNull
    Flow<List<EmbeddedDisplayRequest>> allPending();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    void dismiss(@NotNull String embeddedViewId, @NotNull String viewInstanceId);

    void dismissAll(@NotNull String embeddedViewId);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    Flow<EmbeddedDisplayRequestResult> displayRequests(@NotNull String embeddedViewId, @Nullable Comparator<AirshipEmbeddedInfo> comparator, @NotNull CoroutineScope scope);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Deprecated
        public static void addPending(@NotNull AirshipEmbeddedViewManager airshipEmbeddedViewManager, @NotNull DisplayArgs args, int i, @NotNull JsonMap extras) {
            Intrinsics.checkNotNullParameter(args, "args");
            Intrinsics.checkNotNullParameter(extras, "extras");
            AirshipEmbeddedViewManager.super.addPending(args, i, extras);
        }
    }

    static /* synthetic */ void addPending$default(AirshipEmbeddedViewManager airshipEmbeddedViewManager, String str, String str2, int i, JsonMap EMPTY_MAP, Function0 function0, Function0 function02, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPending");
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            EMPTY_MAP = JsonMap.EMPTY_MAP;
            Intrinsics.checkNotNullExpressionValue(EMPTY_MAP, "EMPTY_MAP");
        }
        airshipEmbeddedViewManager.addPending(str, str2, i3, EMPTY_MAP, function0, function02);
    }

    static /* synthetic */ void addPending$default(AirshipEmbeddedViewManager airshipEmbeddedViewManager, DisplayArgs displayArgs, int i, JsonMap jsonMap, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPending");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        airshipEmbeddedViewManager.addPending(displayArgs, i, jsonMap);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    default void addPending(@NotNull final DisplayArgs args, int priority, @NotNull JsonMap extras) {
        String embeddedId;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(extras, "extras");
        final LayoutInfo payload = args.getPayload();
        BasePresentation presentation = payload.getPresentation();
        EmbeddedPresentation embeddedPresentation = presentation instanceof EmbeddedPresentation ? (EmbeddedPresentation) presentation : null;
        if (embeddedPresentation == null || (embeddedId = embeddedPresentation.getEmbeddedId()) == null) {
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.android.layout.AirshipEmbeddedViewManager$addPending$embeddedViewId$1$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to add pending embedded view. Required embedded view ID is null!";
                }
            }, 1, null);
            return;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        addPending(embeddedId, string, priority, extras, new Function0() { // from class: com.urbanairship.android.layout.AirshipEmbeddedViewManager.addPending.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final LayoutInfo invoke() {
                return payload;
            }
        }, new Function0() { // from class: com.urbanairship.android.layout.AirshipEmbeddedViewManager.addPending.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final DisplayArgs invoke() {
                return args;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Flow displayRequests$default(AirshipEmbeddedViewManager airshipEmbeddedViewManager, String str, Comparator comparator, CoroutineScope coroutineScope, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: displayRequests");
        }
        if ((i & 2) != 0) {
            comparator = null;
        }
        return airshipEmbeddedViewManager.displayRequests(str, comparator, coroutineScope);
    }
}
