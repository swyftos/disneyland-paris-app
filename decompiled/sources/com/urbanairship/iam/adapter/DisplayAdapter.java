package com.urbanairship.iam.adapter;

import android.content.Context;
import androidx.annotation.MainThread;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/adapter/DisplayAdapter;", "", "isReady", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "display", "Lcom/urbanairship/iam/adapter/DisplayResult;", "context", "Landroid/content/Context;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "(Landroid/content/Context;Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DisplayAdapter {
    @MainThread
    @Nullable
    Object display(@NotNull Context context, @NotNull InAppMessageAnalyticsInterface inAppMessageAnalyticsInterface, @NotNull Continuation<? super DisplayResult> continuation);

    @NotNull
    StateFlow<Boolean> isReady();
}
