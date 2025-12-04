package com.urbanairship.iam.adapter;

import android.content.Context;
import com.google.firebase.messaging.Constants;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.automation.utils.NetworkMonitor;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.InAppMessageContentExtender;
import com.urbanairship.iam.actions.InAppActionRunner;
import com.urbanairship.iam.assets.AirshipCachedAssets;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0002J9\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J\"\u0010#\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J*\u0010$\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0002J4\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000b2$\u0010(\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\fj\u0002`\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R8\u0010\t\u001a,\u0012\u0004\u0012\u00020\u000b\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\fj\u0002`\u00100\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Lcom/urbanairship/iam/adapter/DisplayAdapterFactory;", "", "context", "Landroid/content/Context;", "networkMonitor", "Lcom/urbanairship/automation/utils/NetworkMonitor;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "(Landroid/content/Context;Lcom/urbanairship/automation/utils/NetworkMonitor;Lcom/urbanairship/app/ActivityMonitor;)V", "customAdapters", "", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapterType;", "Lkotlin/Function3;", "Lcom/urbanairship/iam/InAppMessage;", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapter;", "Lcom/urbanairship/iam/adapter/AdapterBuilder;", "messageContentExtender", "Lcom/urbanairship/iam/InAppMessageContentExtender;", "getMessageContentExtender", "()Lcom/urbanairship/iam/InAppMessageContentExtender;", "setMessageContentExtender", "(Lcom/urbanairship/iam/InAppMessageContentExtender;)V", "extendMessage", "message", "makeAdapter", "Lkotlin/Result;", "Lcom/urbanairship/iam/adapter/DisplayAdapter;", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "assets", "actionRunner", "Lcom/urbanairship/iam/actions/InAppActionRunner;", "makeAdapter-BWLJW6A", "(Lcom/urbanairship/iam/InAppMessage;ILcom/urbanairship/iam/assets/AirshipCachedAssets;Lcom/urbanairship/iam/actions/InAppActionRunner;)Ljava/lang/Object;", "makeCustomAdapter", "makeDefaultAdapter", "setAdapterFactoryBlock", "", "type", "factoryBlock", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayAdapterFactory {
    private final ActivityMonitor activityMonitor;
    private final Context context;
    private final Map customAdapters;
    private InAppMessageContentExtender messageContentExtender;
    private final NetworkMonitor networkMonitor;

    public DisplayAdapterFactory(@NotNull Context context, @NotNull NetworkMonitor networkMonitor, @NotNull ActivityMonitor activityMonitor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(networkMonitor, "networkMonitor");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        this.context = context;
        this.networkMonitor = networkMonitor;
        this.activityMonitor = activityMonitor;
        this.customAdapters = new LinkedHashMap();
    }

    @Nullable
    public final InAppMessageContentExtender getMessageContentExtender() {
        return this.messageContentExtender;
    }

    public final void setMessageContentExtender(@Nullable InAppMessageContentExtender inAppMessageContentExtender) {
        this.messageContentExtender = inAppMessageContentExtender;
    }

    private final DisplayAdapter makeCustomAdapter(Context context, InAppMessage message, AirshipCachedAssets assets) {
        CustomDisplayAdapterType customDisplayAdapterType;
        Function3 function3;
        CustomDisplayAdapter customDisplayAdapter;
        InAppMessageDisplayContent displayContent = message.getDisplayContent();
        if (displayContent instanceof InAppMessageDisplayContent.BannerContent) {
            customDisplayAdapterType = CustomDisplayAdapterType.BANNER;
        } else if (displayContent instanceof InAppMessageDisplayContent.FullscreenContent) {
            customDisplayAdapterType = CustomDisplayAdapterType.FULLSCREEN;
        } else if (displayContent instanceof InAppMessageDisplayContent.HTMLContent) {
            customDisplayAdapterType = CustomDisplayAdapterType.HTML;
        } else if (displayContent instanceof InAppMessageDisplayContent.ModalContent) {
            customDisplayAdapterType = CustomDisplayAdapterType.MODAL;
        } else if (displayContent instanceof InAppMessageDisplayContent.CustomContent) {
            customDisplayAdapterType = CustomDisplayAdapterType.CUSTOM;
        } else {
            if (!(displayContent instanceof InAppMessageDisplayContent.AirshipLayoutContent)) {
                throw new NoWhenBranchMatchedException();
            }
            customDisplayAdapterType = null;
        }
        if (customDisplayAdapterType == null) {
            return null;
        }
        synchronized (this.customAdapters) {
            function3 = (Function3) this.customAdapters.get(customDisplayAdapterType);
        }
        if (function3 == null || (customDisplayAdapter = (CustomDisplayAdapter) function3.invoke(context, message, assets)) == null) {
            return null;
        }
        return new CustomDisplayAdapterWrapper(customDisplayAdapter);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.urbanairship.iam.adapter.DisplayAdapter makeDefaultAdapter(com.urbanairship.iam.InAppMessage r11, int r12, com.urbanairship.iam.assets.AirshipCachedAssets r13, com.urbanairship.iam.actions.InAppActionRunner r14) {
        /*
            r10 = this;
            com.urbanairship.iam.InAppMessage r1 = r10.extendMessage(r11)
            com.urbanairship.iam.content.InAppMessageDisplayContent r11 = r1.getDisplayContent()
            boolean r0 = r11 instanceof com.urbanairship.iam.content.InAppMessageDisplayContent.BannerContent
            r2 = 0
            if (r0 == 0) goto L18
            com.urbanairship.iam.adapter.banner.BannerDisplayDelegate r12 = new com.urbanairship.iam.adapter.banner.BannerDisplayDelegate
            com.urbanairship.iam.content.InAppMessageDisplayContent$BannerContent r11 = (com.urbanairship.iam.content.InAppMessageDisplayContent.BannerContent) r11
            com.urbanairship.app.ActivityMonitor r0 = r10.activityMonitor
            r12.<init>(r11, r13, r0, r14)
        L16:
            r3 = r12
            goto L62
        L18:
            boolean r0 = r11 instanceof com.urbanairship.iam.content.InAppMessageDisplayContent.FullscreenContent
            if (r0 == 0) goto L26
            com.urbanairship.iam.adapter.fullscreen.FullscreenDisplayDelegate r12 = new com.urbanairship.iam.adapter.fullscreen.FullscreenDisplayDelegate
            com.urbanairship.iam.content.InAppMessageDisplayContent$FullscreenContent r11 = (com.urbanairship.iam.content.InAppMessageDisplayContent.FullscreenContent) r11
            com.urbanairship.app.ActivityMonitor r0 = r10.activityMonitor
            r12.<init>(r11, r13, r0, r14)
            goto L16
        L26:
            boolean r0 = r11 instanceof com.urbanairship.iam.content.InAppMessageDisplayContent.HTMLContent
            if (r0 == 0) goto L3c
            com.urbanairship.iam.adapter.html.HtmlDisplayDelegate r12 = new com.urbanairship.iam.adapter.html.HtmlDisplayDelegate
            r4 = r11
            com.urbanairship.iam.content.InAppMessageDisplayContent$HTMLContent r4 = (com.urbanairship.iam.content.InAppMessageDisplayContent.HTMLContent) r4
            com.urbanairship.json.JsonMap r6 = r1.getExtras()
            com.urbanairship.app.ActivityMonitor r7 = r10.activityMonitor
            r3 = r12
            r5 = r13
            r8 = r14
            r3.<init>(r4, r5, r6, r7, r8)
            goto L62
        L3c:
            boolean r0 = r11 instanceof com.urbanairship.iam.content.InAppMessageDisplayContent.ModalContent
            if (r0 == 0) goto L4a
            com.urbanairship.iam.adapter.modal.ModalDisplayDelegate r12 = new com.urbanairship.iam.adapter.modal.ModalDisplayDelegate
            com.urbanairship.iam.content.InAppMessageDisplayContent$ModalContent r11 = (com.urbanairship.iam.content.InAppMessageDisplayContent.ModalContent) r11
            com.urbanairship.app.ActivityMonitor r0 = r10.activityMonitor
            r12.<init>(r11, r13, r0, r14)
            goto L16
        L4a:
            boolean r0 = r11 instanceof com.urbanairship.iam.content.InAppMessageDisplayContent.AirshipLayoutContent
            if (r0 == 0) goto L61
            com.urbanairship.iam.adapter.layout.AirshipLayoutDisplayDelegate r0 = new com.urbanairship.iam.adapter.layout.AirshipLayoutDisplayDelegate
            r4 = r11
            com.urbanairship.iam.content.InAppMessageDisplayContent$AirshipLayoutContent r4 = (com.urbanairship.iam.content.InAppMessageDisplayContent.AirshipLayoutContent) r4
            com.urbanairship.json.JsonMap r7 = r1.getExtras()
            com.urbanairship.app.ActivityMonitor r8 = r10.activityMonitor
            r3 = r0
            r5 = r13
            r6 = r12
            r9 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9)
            goto L62
        L61:
            r3 = r2
        L62:
            if (r3 != 0) goto L65
            return r2
        L65:
            com.urbanairship.iam.adapter.DelegatingDisplayAdapter r11 = new com.urbanairship.iam.adapter.DelegatingDisplayAdapter
            com.urbanairship.automation.utils.NetworkMonitor r4 = r10.networkMonitor
            com.urbanairship.app.ActivityMonitor r5 = r10.activityMonitor
            r0 = r11
            r2 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.adapter.DisplayAdapterFactory.makeDefaultAdapter(com.urbanairship.iam.InAppMessage, int, com.urbanairship.iam.assets.AirshipCachedAssets, com.urbanairship.iam.actions.InAppActionRunner):com.urbanairship.iam.adapter.DisplayAdapter");
    }

    public final void setAdapterFactoryBlock(@NotNull CustomDisplayAdapterType type, @NotNull Function3<? super Context, ? super InAppMessage, ? super AirshipCachedAssets, ? extends CustomDisplayAdapter> factoryBlock) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(factoryBlock, "factoryBlock");
        synchronized (this.customAdapters) {
            this.customAdapters.put(type, factoryBlock);
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    /* renamed from: makeAdapter-BWLJW6A, reason: not valid java name */
    public final Object m2876makeAdapterBWLJW6A(@NotNull InAppMessage message, int priority, @NotNull AirshipCachedAssets assets, @NotNull InAppActionRunner actionRunner) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        DisplayAdapter displayAdapterMakeCustomAdapter = makeCustomAdapter(this.context, message, assets);
        if (displayAdapterMakeCustomAdapter == null) {
            displayAdapterMakeCustomAdapter = makeDefaultAdapter(message, priority, assets, actionRunner);
        }
        if (displayAdapterMakeCustomAdapter != null) {
            return Result.m2968constructorimpl(displayAdapterMakeCustomAdapter);
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m2968constructorimpl(ResultKt.createFailure(new IllegalArgumentException("No display adapter for message " + message)));
    }

    private final InAppMessage extendMessage(InAppMessage message) {
        InAppMessageDisplayContent displayContent;
        InAppMessageContentExtender inAppMessageContentExtender = this.messageContentExtender;
        if (inAppMessageContentExtender == null || (displayContent = inAppMessageContentExtender.extend(message)) == null) {
            displayContent = message.getDisplayContent();
        }
        return message.newBuilder().setDisplayContent(displayContent).build();
    }
}
