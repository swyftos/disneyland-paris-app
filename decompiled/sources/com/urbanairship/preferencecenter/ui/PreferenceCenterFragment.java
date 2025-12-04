package com.urbanairship.preferencecenter.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ch.qos.logback.core.CoreConstants;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.dlp.BluetoothManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.preferencecenter.R;
import com.urbanairship.preferencecenter.data.Item;
import com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter;
import com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel;
import com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt;
import com.urbanairship.preferencecenter.widget.SectionDividerDecoration;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OpenForTesting
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 92\u00020\u0001:\u00039:;B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020$H\u0092@¢\u0006\u0002\u0010%J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u000bH\u0016J\u001a\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u000203H\u0012J\u0012\u00104\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u00106\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010\u000e2\b\u00108\u001a\u0004\u0018\u00010\u000eH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048RX\u0092\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0092\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u000e8RX\u0092\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168RX\u0092\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0014X\u0095\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0092.¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter;", "getAdapter", "()Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "contactManagementDialogDismisses", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "contactManagementDialogErrors", "Lkotlinx/coroutines/channels/Channel;", "", "onDisplayListener", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterFragment$OnDisplayPreferenceCenterListener;", "preferenceCenterId", "getPreferenceCenterId", "()Ljava/lang/String;", "preferenceCenterId$delegate", "viewModel", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel;", "getViewModel", "()Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel;", "viewModel$delegate", "viewModelScopeProvider", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "getViewModelScopeProvider$annotations", "getViewModelScopeProvider", "()Lkotlin/jvm/functions/Function0;", "views", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterFragment$Views;", "handle", "effect", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect;", "(Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "render", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State;", "setOnDisplayPreferenceCenterListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showHeaderItem", "title", "description", "Companion", "OnDisplayPreferenceCenterListener", "Views", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPreferenceCenterFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreferenceCenterFragment.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterFragment\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,255:1\n49#2:256\n51#2:260\n46#3:257\n51#3:259\n105#4:258\n*S KotlinDebug\n*F\n+ 1 PreferenceCenterFragment.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterFragment\n*L\n164#1:256\n164#1:260\n164#1:257\n164#1:259\n164#1:258\n*E\n"})
/* loaded from: classes5.dex */
public class PreferenceCenterFragment extends Fragment {

    @NotNull
    public static final String ARG_ID = "pref_center_id";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private final MutableSharedFlow contactManagementDialogDismisses;
    private final Channel contactManagementDialogErrors;
    private OnDisplayPreferenceCenterListener onDisplayListener;

    /* renamed from: preferenceCenterId$delegate, reason: from kotlin metadata */
    private final Lazy preferenceCenterId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final Function0 viewModelScopeProvider;
    private Views views;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterFragment$OnDisplayPreferenceCenterListener;", "", "onDisplayPreferenceCenter", "", "title", "", "description", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnDisplayPreferenceCenterListener {
        boolean onDisplayPreferenceCenter(@Nullable String title, @Nullable String description);
    }

    @JvmStatic
    @NotNull
    public static final PreferenceCenterFragment create(@NotNull String str) {
        return INSTANCE.create(str);
    }

    @VisibleForTesting
    protected static /* synthetic */ void getViewModelScopeProvider$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }

    public static final /* synthetic */ Object access$handle(PreferenceCenterFragment preferenceCenterFragment, PreferenceCenterViewModel.Effect effect, Continuation continuation) {
        return preferenceCenterFragment.handle(effect, continuation);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterFragment$Companion;", "", "()V", "ARG_ID", "", "create", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterFragment;", "preferenceCenterId", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPreferenceCenterFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreferenceCenterFragment.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterFragment$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,255:1\n1#2:256\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final PreferenceCenterFragment create(@NotNull String preferenceCenterId) {
            Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
            PreferenceCenterFragment preferenceCenterFragment = new PreferenceCenterFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PreferenceCenterFragment.ARG_ID, preferenceCenterId);
            preferenceCenterFragment.setArguments(bundle);
            return preferenceCenterFragment;
        }
    }

    public PreferenceCenterFragment() {
        super(R.layout.ua_fragment_preference_center);
        this.preferenceCenterId = LazyKt.lazy(new Function0() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$preferenceCenterId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                String string = arguments != null ? arguments.getString(PreferenceCenterFragment.ARG_ID) : null;
                if (string == null) {
                    throw new IllegalArgumentException("Missing required argument: PreferenceCenterFragment.ARG_ID");
                }
                Intrinsics.checkNotNullExpressionValue(string, "requireNotNull(...)");
                return string;
            }
        });
        this.viewModel = LazyKt.lazy(new Function0() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$viewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PreferenceCenterViewModel invoke() {
                PreferenceCenterFragment preferenceCenterFragment = this.this$0;
                return (PreferenceCenterViewModel) new ViewModelProvider(preferenceCenterFragment, PreferenceCenterViewModel.INSTANCE.factory$urbanairship_preference_center_release(preferenceCenterFragment.getPreferenceCenterId())).get(this.this$0.getPreferenceCenterId(), PreferenceCenterViewModel.class);
            }
        });
        this.viewModelScopeProvider = new Function0() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$viewModelScopeProvider$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return ViewModelKt.getViewModelScope(this.this$0.getViewModel());
            }
        };
        this.adapter = LazyKt.lazy(new Function0() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$adapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PreferenceCenterAdapter invoke() {
                return new PreferenceCenterAdapter(this.this$0.getViewModelScopeProvider());
            }
        });
        this.contactManagementDialogErrors = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.contactManagementDialogDismisses = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPreferenceCenterId() {
        return (String) this.preferenceCenterId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PreferenceCenterViewModel getViewModel() {
        return (PreferenceCenterViewModel) this.viewModel.getValue();
    }

    @NotNull
    protected Function0<CoroutineScope> getViewModelScopeProvider() {
        return this.viewModelScopeProvider;
    }

    private PreferenceCenterAdapter getAdapter() {
        return (PreferenceCenterAdapter) this.adapter.getValue();
    }

    private static final class Views {
        private final ViewGroup error;
        private final TextView errorMessage;
        private final Button errorRetryButton;
        private final RecyclerView list;
        private final ViewGroup loading;
        private final View view;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Views)) {
                return false;
            }
            Views views = (Views) obj;
            return Intrinsics.areEqual(this.view, views.view) && Intrinsics.areEqual(this.list, views.list) && Intrinsics.areEqual(this.loading, views.loading) && Intrinsics.areEqual(this.error, views.error) && Intrinsics.areEqual(this.errorMessage, views.errorMessage) && Intrinsics.areEqual(this.errorRetryButton, views.errorRetryButton);
        }

        public int hashCode() {
            return (((((((((this.view.hashCode() * 31) + this.list.hashCode()) * 31) + this.loading.hashCode()) * 31) + this.error.hashCode()) * 31) + this.errorMessage.hashCode()) * 31) + this.errorRetryButton.hashCode();
        }

        public String toString() {
            return "Views(view=" + this.view + ", list=" + this.list + ", loading=" + this.loading + ", error=" + this.error + ", errorMessage=" + this.errorMessage + ", errorRetryButton=" + this.errorRetryButton + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Views(View view, RecyclerView list, ViewGroup loading, ViewGroup error, TextView errorMessage, Button errorRetryButton) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(loading, "loading");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            Intrinsics.checkNotNullParameter(errorRetryButton, "errorRetryButton");
            this.view = view;
            this.list = list;
            this.loading = loading;
            this.error = error;
            this.errorMessage = errorMessage;
            this.errorRetryButton = errorRetryButton;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Views(View view, RecyclerView recyclerView, ViewGroup viewGroup, ViewGroup viewGroup2, TextView textView, Button button, int i, DefaultConstructorMarker defaultConstructorMarker) {
            RecyclerView recyclerView2;
            ViewGroup viewGroup3;
            ViewGroup viewGroup4;
            TextView textView2;
            Button button2;
            if ((i & 2) != 0) {
                View viewFindViewById = view.findViewById(R.id.list);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                recyclerView2 = (RecyclerView) viewFindViewById;
            } else {
                recyclerView2 = recyclerView;
            }
            if ((i & 4) != 0) {
                View viewFindViewById2 = view.findViewById(R.id.loading);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                viewGroup3 = (ViewGroup) viewFindViewById2;
            } else {
                viewGroup3 = viewGroup;
            }
            if ((i & 8) != 0) {
                View viewFindViewById3 = view.findViewById(R.id.error);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                viewGroup4 = (ViewGroup) viewFindViewById3;
            } else {
                viewGroup4 = viewGroup2;
            }
            if ((i & 16) != 0) {
                View viewFindViewById4 = viewGroup4.findViewById(R.id.error_text);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                textView2 = (TextView) viewFindViewById4;
            } else {
                textView2 = textView;
            }
            if ((i & 32) != 0) {
                View viewFindViewById5 = viewGroup4.findViewById(R.id.error_button);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
                button2 = (Button) viewFindViewById5;
            } else {
                button2 = button;
            }
            this(view, recyclerView2, viewGroup3, viewGroup4, textView2, button2);
        }

        public final RecyclerView getList() {
            return this.list;
        }

        public final Button getErrorRetryButton() {
            return this.errorRetryButton;
        }

        public final void showContent() {
            this.error.setVisibility(8);
            this.loading.setVisibility(8);
            this.list.setVisibility(0);
        }

        public final void showError() {
            this.list.setVisibility(8);
            this.loading.setVisibility(8);
            this.error.setVisibility(0);
        }

        public final void showLoading() {
            this.list.setVisibility(8);
            this.error.setVisibility(8);
            this.loading.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return super.onCreateView(inflater.cloneInContext(new ContextThemeWrapper(requireContext(), R.style.UrbanAirship_PreferenceCenter_Fragment)), container, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Views views = new Views(view, null, null, null, null, null, 62, null);
        this.views = views;
        views.getList().setAdapter(getAdapter());
        views.getList().setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView list = views.getList();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        list.addItemDecoration(new SectionDividerDecoration(contextRequireContext, new PreferenceCenterFragment$onViewCreated$1$1(views.getList())));
        views.getList().setHasFixedSize(true);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner);
        Views views2 = null;
        BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new C12882(null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new AnonymousClass3(null), 3, null);
        final SharedFlow<PreferenceCenterAdapter.ItemEvent> itemEvents = getAdapter().getItemEvents();
        Flow flowOnEach = FlowKt.onEach(new Flow<PreferenceCenterViewModel.Action>() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PreferenceCenterFragment.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterFragment\n*L\n1#1,218:1\n50#2:219\n165#3,15:220\n*E\n"})
            /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$$inlined$map$1$2", f = "PreferenceCenterFragment.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$$inlined$map$1$2$1, reason: invalid class name */
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
                public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$$inlined$map$1$2$1 r0 = (com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$$inlined$map$1$2$1 r0 = new com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto Lce
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r5 = r5.$this_unsafeFlow
                        com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$ItemEvent r6 = (com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent) r6
                        boolean r7 = r6 instanceof com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ChannelSubscriptionChange
                        if (r7 == 0) goto L4e
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$PreferenceItemChanged r7 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$PreferenceItemChanged
                        com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$ItemEvent$ChannelSubscriptionChange r6 = (com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ChannelSubscriptionChange) r6
                        com.urbanairship.preferencecenter.data.Item$ChannelSubscription r2 = r6.getItem()
                        boolean r6 = r6.isChecked()
                        r7.<init>(r2, r6)
                        goto Lc5
                    L4e:
                        boolean r7 = r6 instanceof com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ContactSubscriptionChange
                        if (r7 == 0) goto L66
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$ScopedPreferenceItemChanged r7 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$ScopedPreferenceItemChanged
                        com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$ItemEvent$ContactSubscriptionChange r6 = (com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ContactSubscriptionChange) r6
                        com.urbanairship.preferencecenter.data.Item$ContactSubscription r2 = r6.getItem()
                        java.util.Set r4 = r6.getScopes()
                        boolean r6 = r6.isChecked()
                        r7.<init>(r2, r4, r6)
                        goto Lc5
                    L66:
                        boolean r7 = r6 instanceof com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ContactSubscriptionGroupChange
                        if (r7 == 0) goto L7e
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$ScopedPreferenceItemChanged r7 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$ScopedPreferenceItemChanged
                        com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$ItemEvent$ContactSubscriptionGroupChange r6 = (com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ContactSubscriptionGroupChange) r6
                        com.urbanairship.preferencecenter.data.Item$ContactSubscriptionGroup r2 = r6.getItem()
                        java.util.Set r4 = r6.getScopes()
                        boolean r6 = r6.isChecked()
                        r7.<init>(r2, r4, r6)
                        goto Lc5
                    L7e:
                        boolean r7 = r6 instanceof com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ButtonClick
                        if (r7 == 0) goto L8e
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$ButtonActions r7 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$ButtonActions
                        com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$ItemEvent$ButtonClick r6 = (com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ButtonClick) r6
                        java.util.Map r6 = r6.getActions()
                        r7.<init>(r6)
                        goto Lc5
                    L8e:
                        boolean r7 = r6 instanceof com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ContactManagementAddClick
                        if (r7 == 0) goto L9e
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$RequestAddChannel r7 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$RequestAddChannel
                        com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$ItemEvent$ContactManagementAddClick r6 = (com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ContactManagementAddClick) r6
                        com.urbanairship.preferencecenter.data.Item$ContactManagement r6 = r6.getItem()
                        r7.<init>(r6)
                        goto Lc5
                    L9e:
                        boolean r7 = r6 instanceof com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ContactManagementRemoveClick
                        if (r7 == 0) goto Lb2
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$RequestRemoveChannel r7 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$RequestRemoveChannel
                        com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$ItemEvent$ContactManagementRemoveClick r6 = (com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ContactManagementRemoveClick) r6
                        com.urbanairship.preferencecenter.data.Item$ContactManagement r2 = r6.getItem()
                        com.urbanairship.contacts.ContactChannel r6 = r6.getChannel()
                        r7.<init>(r2, r6)
                        goto Lc5
                    Lb2:
                        boolean r7 = r6 instanceof com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ContactManagementResendClick
                        if (r7 == 0) goto Ld1
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$ResendChannelVerification r7 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$ResendChannelVerification
                        com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$ItemEvent$ContactManagementResendClick r6 = (com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter.ItemEvent.ContactManagementResendClick) r6
                        com.urbanairship.preferencecenter.data.Item$ContactManagement r2 = r6.getItem()
                        com.urbanairship.contacts.ContactChannel r6 = r6.getChannel()
                        r7.<init>(r2, r6)
                    Lc5:
                        r0.label = r3
                        java.lang.Object r5 = r5.emit(r7, r0)
                        if (r5 != r1) goto Lce
                        return r1
                    Lce:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    Ld1:
                        kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                        r5.<init>()
                        throw r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super PreferenceCenterViewModel.Action> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = itemEvents.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AnonymousClass5(null));
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(flowOnEach, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3));
        Views views3 = this.views;
        if (views3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            views2 = views3;
        }
        InstrumentationCallbacks.setOnClickListenerCalled(views2.getErrorRetryButton(), new View.OnClickListener() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PreferenceCenterFragment.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$2, reason: invalid class name and case insensitive filesystem */
    static final class C12882 extends SuspendLambda implements Function2 {
        int label;

        C12882(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterFragment.this.new C12882(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12882) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$2$1, reason: invalid class name */
        /* synthetic */ class AnonymousClass1 implements FlowCollector, FunctionAdapter {
            final /* synthetic */ PreferenceCenterFragment $tmp0;

            AnonymousClass1(PreferenceCenterFragment preferenceCenterFragment) {
                this.$tmp0 = preferenceCenterFragment;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.FunctionAdapter
            public final Function getFunctionDelegate() {
                return new AdaptedFunctionReference(2, this.$tmp0, PreferenceCenterFragment.class, "render", "render(Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State;)V", 4);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(PreferenceCenterViewModel.State state, Continuation continuation) {
                Object objInvokeSuspend$render = C12882.invokeSuspend$render(this.$tmp0, state, continuation);
                return objInvokeSuspend$render == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvokeSuspend$render : Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<PreferenceCenterViewModel.State> states = PreferenceCenterFragment.this.getViewModel().getStates();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(PreferenceCenterFragment.this);
                this.label = 1;
                if (states.collect(anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object invokeSuspend$render(PreferenceCenterFragment preferenceCenterFragment, PreferenceCenterViewModel.State state, Continuation continuation) {
            preferenceCenterFragment.render(state);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterFragment.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$3$1, reason: invalid class name */
        /* synthetic */ class AnonymousClass1 implements FlowCollector, FunctionAdapter {
            final /* synthetic */ PreferenceCenterFragment $tmp0;

            AnonymousClass1(PreferenceCenterFragment preferenceCenterFragment) {
                this.$tmp0 = preferenceCenterFragment;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.FunctionAdapter
            public final Function getFunctionDelegate() {
                return new AdaptedFunctionReference(2, this.$tmp0, PreferenceCenterFragment.class, "handle", "handle(Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 8);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(PreferenceCenterViewModel.Effect effect, Continuation continuation) {
                Object objInvokeSuspend$handle = AnonymousClass3.invokeSuspend$handle(this.$tmp0, effect, continuation);
                return objInvokeSuspend$handle == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvokeSuspend$handle : Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<PreferenceCenterViewModel.Effect> effects = PreferenceCenterFragment.this.getViewModel().getEffects();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(PreferenceCenterFragment.this);
                this.label = 1;
                if (effects.collect(anonymousClass1, this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object invokeSuspend$handle(PreferenceCenterFragment preferenceCenterFragment, PreferenceCenterViewModel.Effect effect, Continuation continuation) {
            return preferenceCenterFragment.handle(effect, continuation);
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$onViewCreated$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass5(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass5 anonymousClass5 = PreferenceCenterFragment.this.new AnonymousClass5(continuation);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PreferenceCenterViewModel.Action action, Continuation continuation) {
            return ((AnonymousClass5) create(action, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PreferenceCenterFragment.this.getViewModel().handle((PreferenceCenterViewModel.Action) this.L$0);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(PreferenceCenterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handle(PreferenceCenterViewModel.Action.Refresh.INSTANCE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
        getViewModel().handle(PreferenceCenterViewModel.Action.Refresh.INSTANCE);
    }

    public void setOnDisplayPreferenceCenterListener(@Nullable OnDisplayPreferenceCenterListener listener) {
        this.onDisplayListener = listener;
    }

    public void showHeaderItem(@Nullable String title, @Nullable String description) {
        getAdapter().setHeaderItem$urbanairship_preference_center_release(title, description);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(PreferenceCenterViewModel.State state) {
        Unit unit;
        Views views = null;
        if (state instanceof PreferenceCenterViewModel.State.Loading) {
            Views views2 = this.views;
            if (views2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
            } else {
                views = views2;
            }
            views.showLoading();
            return;
        }
        if (state instanceof PreferenceCenterViewModel.State.Error) {
            Views views3 = this.views;
            if (views3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("views");
            } else {
                views = views3;
            }
            views.showError();
            return;
        }
        if (!(state instanceof PreferenceCenterViewModel.State.Content)) {
            throw new NoWhenBranchMatchedException();
        }
        OnDisplayPreferenceCenterListener onDisplayPreferenceCenterListener = this.onDisplayListener;
        if (onDisplayPreferenceCenterListener != null) {
            PreferenceCenterViewModel.State.Content content = (PreferenceCenterViewModel.State.Content) state;
            if (!onDisplayPreferenceCenterListener.onDisplayPreferenceCenter(content.getTitle(), content.getSubtitle())) {
                showHeaderItem(content.getTitle(), content.getSubtitle());
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            PreferenceCenterViewModel.State.Content content2 = (PreferenceCenterViewModel.State.Content) state;
            showHeaderItem(content2.getTitle(), content2.getSubtitle());
        }
        PreferenceCenterViewModel.State.Content content3 = (PreferenceCenterViewModel.State.Content) state;
        getAdapter().submit(content3.getListItems(), content3.getChannelSubscriptions(), content3.getContactSubscriptions(), content3.getContactChannelState());
        Views views4 = this.views;
        if (views4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("views");
        } else {
            views = views4;
        }
        views.showContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object handle(PreferenceCenterViewModel.Effect effect, Continuation continuation) {
        if (effect instanceof PreferenceCenterViewModel.Effect.ShowContactManagementAddDialog) {
            ContactChannelManagementDialogsKt.showContactManagementAddDialog(this, ((PreferenceCenterViewModel.Effect.ShowContactManagementAddDialog) effect).getItem(), new AnonymousClass2(getViewModel()), FlowKt.consumeAsFlow(this.contactManagementDialogErrors), this.contactManagementDialogDismisses);
            return Unit.INSTANCE;
        }
        if (effect instanceof PreferenceCenterViewModel.Effect.ShowContactManagementAddConfirmDialog) {
            Item.ContactManagement.ActionableMessage onSubmit = ((PreferenceCenterViewModel.Effect.ShowContactManagementAddConfirmDialog) effect).getItem().getAddPrompt().getPrompt().getOnSubmit();
            if (onSubmit != null) {
                ContactChannelManagementDialogsKt.showContactManagementAddConfirmDialog(this, onSubmit);
                return Unit.INSTANCE;
            }
        } else {
            if (effect instanceof PreferenceCenterViewModel.Effect.ShowContactManagementRemoveDialog) {
                PreferenceCenterViewModel.Effect.ShowContactManagementRemoveDialog showContactManagementRemoveDialog = (PreferenceCenterViewModel.Effect.ShowContactManagementRemoveDialog) effect;
                ContactChannelManagementDialogsKt.showContactManagementRemoveDialog(this, showContactManagementRemoveDialog.getItem(), showContactManagementRemoveDialog.getChannel(), new AnonymousClass4(getViewModel()));
                return Unit.INSTANCE;
            }
            if (effect instanceof PreferenceCenterViewModel.Effect.ShowChannelVerificationResentDialog) {
                Item.ContactManagement.ActionableMessage onSuccess = ((PreferenceCenterViewModel.Effect.ShowChannelVerificationResentDialog) effect).getItem().getPlatform().getResendOptions$urbanairship_preference_center_release().getOnSuccess();
                if (onSuccess != null) {
                    ContactChannelManagementDialogsKt.showContactManagementResentDialog(this, onSuccess);
                    return Unit.INSTANCE;
                }
            } else {
                if (Intrinsics.areEqual(effect, PreferenceCenterViewModel.Effect.DismissContactManagementAddDialog.INSTANCE)) {
                    MutableSharedFlow mutableSharedFlow = this.contactManagementDialogDismisses;
                    Unit unit = Unit.INSTANCE;
                    Object objEmit = mutableSharedFlow.emit(unit, continuation);
                    return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : unit;
                }
                if (!(effect instanceof PreferenceCenterViewModel.Effect.ShowContactManagementAddDialogError)) {
                    throw new NoWhenBranchMatchedException();
                }
                Object objSend = this.contactManagementDialogErrors.send(((PreferenceCenterViewModel.Effect.ShowContactManagementAddDialogError) effect).getMessage(), continuation);
                return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
            }
        }
        return null;
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$handle$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass2(Object obj) {
            super(1, obj, PreferenceCenterViewModel.class, "handle", "handle(Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PreferenceCenterViewModel.Action) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(PreferenceCenterViewModel.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PreferenceCenterViewModel) this.receiver).handle(p0);
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterFragment$handle$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass4(Object obj) {
            super(1, obj, PreferenceCenterViewModel.class, "handle", "handle(Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PreferenceCenterViewModel.Action) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(PreferenceCenterViewModel.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PreferenceCenterViewModel) this.receiver).handle(p0);
        }
    }
}
