package expo.modules.core.logging;

import com.tagcommander.lib.p193serverside.schemas.TCVideoEventPropertiesNames;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00052\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0003R$\u0010\f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0011\u0010\u0003¨\u0006\u0012"}, m1836d2 = {"Lexpo/modules/core/logging/PersistentFileLogSerialDispatchQueue;", "", "<init>", "()V", "Lkotlin/Function0;", "", "Lexpo/modules/core/logging/PersistentFileLogSerialDispatchQueueBlock;", "block", "add", "(Lkotlin/jvm/functions/Function0;)V", "stop", "Lkotlinx/coroutines/channels/Channel;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/Job;", "queueRunner", "Lkotlinx/coroutines/Job;", "getQueueRunner$annotations", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class PersistentFileLogSerialDispatchQueue {
    private final Channel channel = ChannelKt.Channel$default(-2, null, null, 6, null);
    private final Job queueRunner = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new PersistentFileLogSerialDispatchQueue$queueRunner$1(this, null), 3, null);

    /* JADX INFO: renamed from: expo.modules.core.logging.PersistentFileLogSerialDispatchQueue$add$1 */
    static final class C60851 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function0 $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C60851(Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PersistentFileLogSerialDispatchQueue.this.new C60851(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C60851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Channel channel = PersistentFileLogSerialDispatchQueue.this.channel;
                Function0 function0 = this.$block;
                this.label = 1;
                if (channel.send(function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void add(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        BuildersKt__BuildersKt.runBlocking$default(null, new C60851(block, null), 1, null);
    }

    public final void stop() {
        Job.DefaultImpls.cancel$default(this.queueRunner, (CancellationException) null, 1, (Object) null);
    }
}
