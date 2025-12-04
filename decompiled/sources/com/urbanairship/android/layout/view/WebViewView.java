package com.urbanairship.android.layout.view;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.exifinterface.media.ExifInterface;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.model.WebViewModel;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.view.WebViewView;
import com.urbanairship.android.layout.widget.TappableView;
import com.urbanairship.android.layout.widget.TouchAwareAirshipWebView;
import com.urbanairship.app.FilteredActivityListener;
import com.urbanairship.app.SimpleActivityListener;
import com.urbanairship.util.ManifestUtils;
import com.urbanairship.webkit.AirshipWebViewClient;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007H\u0003J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018H\u0016R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/android/layout/view/WebViewView;", "Landroid/widget/FrameLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "Lcom/urbanairship/android/layout/widget/TappableView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/WebViewModel;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/WebViewModel;Lcom/urbanairship/android/layout/environment/ViewEnvironment;)V", "activityListener", "com/urbanairship/android/layout/view/WebViewView$activityListener$1", "Lcom/urbanairship/android/layout/view/WebViewView$activityListener$1;", "chromeClient", "Landroid/webkit/WebChromeClient;", "filteredActivityListener", "Lcom/urbanairship/app/FilteredActivityListener;", "webView", "Lcom/urbanairship/android/layout/widget/TouchAwareAirshipWebView;", "loadWebView", "", "setChromeClient", "taps", "Lkotlinx/coroutines/flow/Flow;", "ClientListener", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWebViewView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewView.kt\ncom/urbanairship/android/layout/view/WebViewView\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,227:1\n17#2:228\n19#2:232\n49#2,3:233\n46#3:229\n51#3:231\n105#4:230\n*S KotlinDebug\n*F\n+ 1 WebViewView.kt\ncom/urbanairship/android/layout/view/WebViewView\n*L\n95#1:228\n95#1:232\n95#1:233,3\n95#1:229\n95#1:231\n95#1:230\n*E\n"})
/* loaded from: classes5.dex */
public final class WebViewView extends FrameLayout implements BaseView, TappableView {
    private final WebViewView$activityListener$1 activityListener;
    private WebChromeClient chromeClient;
    private final FilteredActivityListener filteredActivityListener;
    private final WebViewModel model;
    private final ViewEnvironment viewEnvironment;
    private TouchAwareAirshipWebView webView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.urbanairship.android.layout.view.WebViewView$activityListener$1, com.urbanairship.app.ActivityListener] */
    public WebViewView(@NotNull Context context, @NotNull WebViewModel model, @NotNull ViewEnvironment viewEnvironment) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        this.model = model;
        this.viewEnvironment = viewEnvironment;
        ?? r3 = new SimpleActivityListener() { // from class: com.urbanairship.android.layout.view.WebViewView$activityListener$1
            @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                TouchAwareAirshipWebView touchAwareAirshipWebView = this.this$0.webView;
                if (touchAwareAirshipWebView != null) {
                    touchAwareAirshipWebView.onPause();
                }
            }

            @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                TouchAwareAirshipWebView touchAwareAirshipWebView = this.this$0.webView;
                if (touchAwareAirshipWebView != null) {
                    touchAwareAirshipWebView.onResume();
                }
            }

            @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                TouchAwareAirshipWebView touchAwareAirshipWebView = this.this$0.webView;
                if (touchAwareAirshipWebView != null) {
                    WebViewView webViewView = this.this$0;
                    Bundle bundle = new Bundle();
                    touchAwareAirshipWebView.saveState(bundle);
                    webViewView.model.setSavedState(bundle);
                }
            }
        };
        this.activityListener = r3;
        FilteredActivityListener filteredActivityListener = new FilteredActivityListener(r3, viewEnvironment.hostingActivityPredicate());
        this.filteredActivityListener = filteredActivityListener;
        viewEnvironment.getActivityMonitor().addActivityListener(filteredActivityListener);
        WebChromeClient webChromeClientCreate = viewEnvironment.webChromeClientFactory().create();
        Intrinsics.checkNotNullExpressionValue(webChromeClientCreate, "create(...)");
        setChromeClient(webChromeClientCreate);
        loadWebView(model);
        model.setListener$urbanairship_layout_release(new BaseModel.Listener() { // from class: com.urbanairship.android.layout.view.WebViewView.1
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                WebViewView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                WebViewView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background) {
                Intrinsics.checkNotNullParameter(background, "new");
                LayoutUtils.updateBackground(WebViewView.this, old, background);
            }
        });
    }

    @Override // com.urbanairship.android.layout.widget.TappableView
    @NotNull
    public Flow<Unit> taps() {
        final Flow<MotionEvent> flow;
        TouchAwareAirshipWebView touchAwareAirshipWebView = this.webView;
        if (touchAwareAirshipWebView == null || (flow = touchAwareAirshipWebView.touchEvents()) == null) {
            return FlowKt.emptyFlow();
        }
        final Flow<MotionEvent> flow2 = new Flow<MotionEvent>() { // from class: com.urbanairship.android.layout.view.WebViewView$taps$$inlined$filter$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 WebViewView.kt\ncom/urbanairship/android/layout/view/WebViewView\n*L\n1#1,218:1\n18#2:219\n19#2:221\n95#3:220\n*E\n"})
            /* renamed from: com.urbanairship.android.layout.view.WebViewView$taps$$inlined$filter$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.android.layout.view.WebViewView$taps$$inlined$filter$1$2", f = "WebViewView.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.android.layout.view.WebViewView$taps$$inlined$filter$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.urbanairship.android.layout.view.WebViewView$taps$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.android.layout.view.WebViewView$taps$$inlined$filter$1$2$1 r0 = (com.urbanairship.android.layout.view.WebViewView$taps$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.android.layout.view.WebViewView$taps$$inlined$filter$1$2$1 r0 = new com.urbanairship.android.layout.view.WebViewView$taps$$inlined$filter$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L48
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                        r6 = r5
                        android.view.MotionEvent r6 = (android.view.MotionEvent) r6
                        boolean r6 = com.urbanairship.android.layout.util.ViewExtensionsKt.isActionUp(r6)
                        if (r6 == 0) goto L48
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L48
                        return r1
                    L48:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.view.WebViewView$taps$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super MotionEvent> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        return new Flow<Unit>() { // from class: com.urbanairship.android.layout.view.WebViewView$taps$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 WebViewView.kt\ncom/urbanairship/android/layout/view/WebViewView\n*L\n1#1,218:1\n50#2:219\n95#3:220\n*E\n"})
            /* renamed from: com.urbanairship.android.layout.view.WebViewView$taps$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.android.layout.view.WebViewView$taps$$inlined$map$1$2", f = "WebViewView.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.android.layout.view.WebViewView$taps$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.urbanairship.android.layout.view.WebViewView$taps$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.android.layout.view.WebViewView$taps$$inlined$map$1$2$1 r0 = (com.urbanairship.android.layout.view.WebViewView$taps$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.android.layout.view.WebViewView$taps$$inlined$map$1$2$1 r0 = new com.urbanairship.android.layout.view.WebViewView$taps$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L43
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                        android.view.MotionEvent r5 = (android.view.MotionEvent) r5
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L43
                        return r1
                    L43:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.view.WebViewView$taps$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Unit> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = flow2.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    private final void loadWebView(final WebViewModel model) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        TouchAwareAirshipWebView touchAwareAirshipWebView = new TouchAwareAirshipWebView(context);
        this.webView = touchAwareAirshipWebView;
        Bundle savedState = model.getSavedState();
        if (savedState != null) {
            touchAwareAirshipWebView.restoreState(savedState);
        }
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(this.webView, layoutParams);
        final ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setId(R.id.progress);
        progressBar.setIndeterminate(true);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        frameLayout.addView(progressBar, layoutParams2);
        WebSettings settings = touchAwareAirshipWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        if (ManifestUtils.shouldEnableLocalStorage()) {
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
        }
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowContentAccess(false);
        AirshipWebViewClient airshipWebViewClientCreate = this.viewEnvironment.webViewClientFactory().create();
        airshipWebViewClientCreate.addListener(new ClientListener() { // from class: com.urbanairship.android.layout.view.WebViewView$loadWebView$client$1$1
            @Override // com.urbanairship.android.layout.view.WebViewView.ClientListener
            protected void onPageFinished(@NotNull WebView webView) {
                Intrinsics.checkNotNullParameter(webView, "webView");
                webView.setVisibility(0);
                progressBar.setVisibility(8);
            }

            @Override // com.urbanairship.android.layout.view.WebViewView.ClientListener
            protected void onRetry(@NotNull WebView webView) {
                Intrinsics.checkNotNullParameter(webView, "webView");
                String url = model.getViewInfo().getUrl();
                InstrumentationCallbacks.loadUrlCalled(webView);
                webView.loadUrl(url);
            }

            @Override // com.urbanairship.webkit.AirshipWebViewClient.Listener
            public boolean onClose(@NotNull WebView webView) {
                Intrinsics.checkNotNullParameter(webView, "webView");
                model.onClose();
                return true;
            }
        });
        touchAwareAirshipWebView.setWebChromeClient(this.chromeClient);
        touchAwareAirshipWebView.setVisibility(4);
        touchAwareAirshipWebView.setWebViewClient(airshipWebViewClientCreate);
        addView(frameLayout);
        if (!UAirship.shared().getUrlAllowList().isAllowed(model.getViewInfo().getUrl(), 2)) {
            UALog.e("URL not allowed. Unable to load: %s", model.getViewInfo().getUrl());
        } else if (savedState == null) {
            String url = model.getViewInfo().getUrl();
            InstrumentationCallbacks.loadUrlCalled(touchAwareAirshipWebView);
            touchAwareAirshipWebView.loadUrl(url);
        }
    }

    private final void setChromeClient(WebChromeClient chromeClient) {
        this.chromeClient = chromeClient;
        TouchAwareAirshipWebView touchAwareAirshipWebView = this.webView;
        if (touchAwareAirshipWebView == null) {
            return;
        }
        touchAwareAirshipWebView.setWebChromeClient(chromeClient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class ClientListener implements AirshipWebViewClient.Listener {

        @NotNull
        public static final Companion Companion = new Companion(null);
        private boolean error;
        private long retryDelay = 1000;

        protected abstract void onPageFinished(WebView webView);

        protected abstract void onRetry(WebView webView);

        @Override // com.urbanairship.webkit.AirshipWebViewClient.Listener
        public void onPageFinished(@NotNull WebView view, @Nullable String str) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (this.error) {
                final WeakReference weakReference = new WeakReference(view);
                view.postDelayed(new Runnable() { // from class: com.urbanairship.android.layout.view.WebViewView$ClientListener$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewView.ClientListener.onPageFinished$lambda$1(weakReference, this);
                    }
                }, this.retryDelay);
                this.retryDelay *= 2;
            } else {
                onPageFinished(view);
            }
            this.error = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPageFinished$lambda$1(WeakReference webViewWeakReference, ClientListener this$0) {
            Intrinsics.checkNotNullParameter(webViewWeakReference, "$webViewWeakReference");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WebView webView = (WebView) webViewWeakReference.get();
            if (webView != null) {
                this$0.onRetry(webView);
            }
        }

        @Override // com.urbanairship.webkit.AirshipWebViewClient.Listener
        public void onReceivedError(@NotNull WebView view, @NotNull WebResourceRequest request, @NotNull WebResourceError error) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(error, "error");
            UALog.e("Error loading web view! %d - %s", Integer.valueOf(error.getErrorCode()), error.getDescription());
            this.error = true;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/android/layout/view/WebViewView$ClientListener$Companion;", "", "()V", "START_RETRY_DELAY", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
