package coil3.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil3.content.LifecyclesKt;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1836d2 = {"Lcoil3/request/LifecycleRequestDelegate;", "Lcoil3/request/RequestDelegate;", "Landroidx/lifecycle/DefaultLifecycleObserver;", TCEventPropertiesNames.TCL_LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlinx/coroutines/Job;)V", ViewProps.START, "", "awaitStarted", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "dispose", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class LifecycleRequestDelegate implements RequestDelegate, DefaultLifecycleObserver {
    private final Job job;
    private final Lifecycle lifecycle;

    public LifecycleRequestDelegate(@NotNull Lifecycle lifecycle, @NotNull Job job) {
        this.lifecycle = lifecycle;
        this.job = job;
    }

    @Override // coil3.request.RequestDelegate
    public void start() {
        this.lifecycle.addObserver(this);
    }

    @Override // coil3.request.RequestDelegate
    @Nullable
    public Object awaitStarted(@NotNull Continuation<? super Unit> continuation) {
        Object objAwaitStarted = LifecyclesKt.awaitStarted(this.lifecycle, continuation);
        return objAwaitStarted == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitStarted : Unit.INSTANCE;
    }

    @Override // coil3.request.RequestDelegate
    public void complete() {
        this.lifecycle.removeObserver(this);
    }

    @Override // coil3.request.RequestDelegate
    public void dispose() {
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        dispose();
    }
}
