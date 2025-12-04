package com.urbanairship.iam.adapter;

import android.content.Context;
import androidx.annotation.MainThread;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/adapter/CustomDisplayAdapter;", "", "CallbackAdapter", "SuspendingAdapter", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapter$CallbackAdapter;", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapter$SuspendingAdapter;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface CustomDisplayAdapter {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/adapter/CustomDisplayAdapter$CallbackAdapter;", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapter;", "display", "", "context", "Landroid/content/Context;", "callback", "Lcom/urbanairship/iam/adapter/DisplayFinishedCallback;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface CallbackAdapter extends CustomDisplayAdapter {
        @MainThread
        void display(@NotNull Context context, @NotNull DisplayFinishedCallback callback);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/adapter/CustomDisplayAdapter$SuspendingAdapter;", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapter;", "isReady", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "display", "Lcom/urbanairship/iam/adapter/CustomDisplayResolution;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface SuspendingAdapter extends CustomDisplayAdapter {
        @Nullable
        Object display(@NotNull Context context, @NotNull Continuation<? super CustomDisplayResolution> continuation);

        @NotNull
        StateFlow<Boolean> isReady();
    }
}
