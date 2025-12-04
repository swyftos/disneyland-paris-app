package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B\u001b\b\u0016\u0012\u0010\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J9\u0010\u0016\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017JC\u0010\u001a\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ9\u0010\u001c\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001c\u0010\u0017J'\u0010\u001e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\"\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b$\u0010\u000fJ\u001f\u0010&\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0018H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b(\u0010\u000fJ\u001f\u0010)\u001a\u00020 2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b)\u0010*R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/facebook/imagepipeline/listener/ForwardingRequestListener2;", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "", "listenersToAdd", "<init>", "(Ljava/util/Set;)V", "", "([Lcom/facebook/imagepipeline/listener/RequestListener2;)V", "requestListener", "", "addRequestListener", "(Lcom/facebook/imagepipeline/listener/RequestListener2;)V", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "producerContext", "onRequestStart", "(Lcom/facebook/imagepipeline/producers/ProducerContext;)V", "", "producerName", "onProducerStart", "(Lcom/facebook/imagepipeline/producers/ProducerContext;Ljava/lang/String;)V", "", "extraMap", "onProducerFinishWithSuccess", "(Lcom/facebook/imagepipeline/producers/ProducerContext;Ljava/lang/String;Ljava/util/Map;)V", "", "t", "onProducerFinishWithFailure", "(Lcom/facebook/imagepipeline/producers/ProducerContext;Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", "onProducerFinishWithCancellation", "producerEventName", "onProducerEvent", "(Lcom/facebook/imagepipeline/producers/ProducerContext;Ljava/lang/String;Ljava/lang/String;)V", "", "successful", "onUltimateProducerReached", "(Lcom/facebook/imagepipeline/producers/ProducerContext;Ljava/lang/String;Z)V", "onRequestSuccess", "throwable", "onRequestFailure", "(Lcom/facebook/imagepipeline/producers/ProducerContext;Ljava/lang/Throwable;)V", "onRequestCancellation", "requiresExtraMap", "(Lcom/facebook/imagepipeline/producers/ProducerContext;Ljava/lang/String;)Z", "", "requestListeners", "Ljava/util/List;", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nForwardingRequestListener2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ForwardingRequestListener2.kt\ncom/facebook/imagepipeline/listener/ForwardingRequestListener2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,125:1\n37#1:128\n38#1,7:130\n45#1:138\n37#1:139\n38#1,7:141\n45#1:149\n37#1:150\n38#1,7:152\n45#1:160\n37#1:161\n38#1,7:163\n45#1:171\n37#1:172\n38#1,7:174\n45#1:182\n37#1:183\n38#1,7:185\n45#1:193\n37#1:194\n38#1,7:196\n45#1:204\n37#1:205\n38#1,7:207\n45#1:215\n37#1:216\n38#1,7:218\n45#1:226\n37#1:227\n38#1,7:229\n45#1:237\n1863#2,2:126\n1863#2:129\n1864#2:137\n1863#2:140\n1864#2:148\n1863#2:151\n1864#2:159\n1863#2:162\n1864#2:170\n1863#2:173\n1864#2:181\n1863#2:184\n1864#2:192\n1863#2:195\n1864#2:203\n1863#2:206\n1864#2:214\n1863#2:217\n1864#2:225\n1863#2:228\n1864#2:236\n1755#2,3:238\n*S KotlinDebug\n*F\n+ 1 ForwardingRequestListener2.kt\ncom/facebook/imagepipeline/listener/ForwardingRequestListener2\n*L\n48#1:128\n48#1:130,7\n48#1:138\n52#1:139\n52#1:141,7\n52#1:149\n60#1:150\n60#1:152,7\n60#1:160\n71#1:161\n71#1:163,7\n71#1:171\n81#1:172\n81#1:174,7\n81#1:182\n91#1:183\n91#1:185,7\n91#1:193\n101#1:194\n101#1:196,7\n101#1:204\n107#1:205\n107#1:207,7\n107#1:215\n111#1:216\n111#1:218,7\n111#1:226\n115#1:227\n115#1:229,7\n115#1:237\n37#1:126,2\n48#1:129\n48#1:137\n52#1:140\n52#1:148\n60#1:151\n60#1:159\n71#1:162\n71#1:170\n81#1:173\n81#1:181\n91#1:184\n91#1:192\n101#1:195\n101#1:203\n107#1:206\n107#1:214\n111#1:217\n111#1:225\n115#1:228\n115#1:236\n119#1:238,3\n*E\n"})
/* loaded from: classes3.dex */
public final class ForwardingRequestListener2 implements RequestListener2 {
    private final List requestListeners;

    public ForwardingRequestListener2(@Nullable Set<? extends RequestListener2> set) {
        if (set == null) {
            this.requestListeners = new ArrayList();
            return;
        }
        ArrayList arrayList = new ArrayList(set.size());
        this.requestListeners = arrayList;
        CollectionsKt.filterNotNullTo(set, arrayList);
    }

    public ForwardingRequestListener2(@NotNull RequestListener2... listenersToAdd) {
        Intrinsics.checkNotNullParameter(listenersToAdd, "listenersToAdd");
        ArrayList arrayList = new ArrayList(listenersToAdd.length);
        this.requestListeners = arrayList;
        ArraysKt.filterNotNullTo(listenersToAdd, arrayList);
    }

    public final void addRequestListener(@NotNull RequestListener2 requestListener) {
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        this.requestListeners.add(requestListener);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerEvent(@NotNull ProducerContext producerContext, @NotNull String producerName, @NotNull String producerEventName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Intrinsics.checkNotNullParameter(producerEventName, "producerEventName");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onProducerEvent(producerContext, producerName, producerEventName);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithCancellation(@Nullable ProducerContext producerContext, @Nullable String producerName, @Nullable Map<String, String> extraMap) {
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onProducerFinishWithCancellation(producerContext, producerName, extraMap);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithFailure(@Nullable ProducerContext producerContext, @Nullable String producerName, @Nullable Throwable t, @Nullable Map<String, String> extraMap) {
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onProducerFinishWithFailure(producerContext, producerName, t, extraMap);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithSuccess(@Nullable ProducerContext producerContext, @Nullable String producerName, @Nullable Map<String, String> extraMap) {
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onProducerFinishWithSuccess(producerContext, producerName, extraMap);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerStart(@NotNull ProducerContext producerContext, @NotNull String producerName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onProducerStart(producerContext, producerName);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestCancellation(@NotNull ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onRequestCancellation(producerContext);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestFailure(@NotNull ProducerContext producerContext, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onRequestFailure(producerContext, throwable);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestStart(@NotNull ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onRequestStart(producerContext);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestSuccess(@NotNull ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onRequestSuccess(producerContext);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onUltimateProducerReached(@NotNull ProducerContext producerContext, @NotNull String producerName, boolean successful) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onUltimateProducerReached(producerContext, producerName, successful);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public boolean requiresExtraMap(@NotNull ProducerContext producerContext, @NotNull String producerName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        List list = this.requestListeners;
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((RequestListener2) it.next()).requiresExtraMap(producerContext, producerName)) {
                return true;
            }
        }
        return false;
    }
}
