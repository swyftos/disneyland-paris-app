package com.urbanairship.android.layout.environment;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.environment.LayoutState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.android.layout.property.StateAction;
import com.urbanairship.android.layout.reporting.FormInfo;
import com.urbanairship.android.layout.reporting.LayoutData;
import com.urbanairship.android.layout.reporting.PagerData;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 C2\u00020\u0001:\u0002CDB\u007f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\b\u0010+\u001a\u00020,H\u0002J\"\u0010-\u001a\u00020,2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0001J\u0010\u00102\u001a\u00020,2\u0006\u00103\u001a\u000204H\u0002J*\u00105\u001a\u0002062\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\n\b\u0002\u00109\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010!J.\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020!2\b\u0010>\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010AH\u0002ø\u0001\u0000¢\u0006\u0002\bBR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"Lcom/urbanairship/android/layout/environment/LayoutState;", "", "pager", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State$Pager;", "checkbox", "Lcom/urbanairship/android/layout/environment/State$Checkbox;", "radio", "Lcom/urbanairship/android/layout/environment/State$Radio;", FirebaseAnalytics.Param.SCORE, "Lcom/urbanairship/android/layout/environment/State$Score;", "layout", "Lcom/urbanairship/android/layout/environment/State$Layout;", "thomasState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/urbanairship/android/layout/environment/ThomasState;", "thomasForm", "Lcom/urbanairship/android/layout/environment/ThomasForm;", "parentForm", "pagerTracker", "Lcom/urbanairship/android/layout/environment/PagersViewTracker;", "(Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/SharedState;Lkotlinx/coroutines/flow/StateFlow;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/PagersViewTracker;)V", "getCheckbox", "()Lcom/urbanairship/android/layout/environment/SharedState;", "getLayout", "getPager", "getPagerTracker", "()Lcom/urbanairship/android/layout/environment/PagersViewTracker;", "getParentForm", "()Lcom/urbanairship/android/layout/environment/ThomasForm;", "getRadio", "runningJobs", "", "", "Lkotlinx/coroutines/Job;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getScore", "getThomasForm", "getThomasState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearState", "", "processStateActions", "actions", "", "Lcom/urbanairship/android/layout/property/StateAction;", "formValue", "removeTempMutation", "mutation", "Lcom/urbanairship/android/layout/environment/LayoutState$StateMutation;", "reportingContext", "Lcom/urbanairship/android/layout/reporting/LayoutData;", "formContext", "Lcom/urbanairship/android/layout/reporting/FormInfo;", "pagerContext", "Lcom/urbanairship/android/layout/reporting/PagerData;", "buttonId", "setState", "key", "value", "Lcom/urbanairship/json/JsonValue;", Constants.FirelogAnalytics.PARAM_TTL, "Lkotlin/time/Duration;", "setState-moChb0s", "Companion", "StateMutation", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLayoutState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutState.kt\ncom/urbanairship/android/layout/environment/LayoutState\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,521:1\n1855#2,2:522\n*S KotlinDebug\n*F\n+ 1 LayoutState.kt\ncom/urbanairship/android/layout/environment/LayoutState\n*L\n80#1:522,2\n*E\n"})
/* loaded from: classes5.dex */
public final class LayoutState {

    @JvmField
    @NotNull
    public static final LayoutState EMPTY = new LayoutState(null, null, null, null, new SharedState(State.Layout.INSTANCE.getDEFAULT()), ThomasStateKt.makeThomasState(null, null), null, null, null);
    private final SharedState checkbox;
    private final SharedState layout;
    private final SharedState pager;
    private final PagersViewTracker pagerTracker;
    private final ThomasForm parentForm;
    private final SharedState radio;
    private Map runningJobs;
    private final CoroutineScope scope;
    private final SharedState score;
    private final ThomasForm thomasForm;
    private final StateFlow thomasState;

    public LayoutState(@Nullable SharedState<State.Pager> sharedState, @Nullable SharedState<State.Checkbox> sharedState2, @Nullable SharedState<State.Radio> sharedState3, @Nullable SharedState<State.Score> sharedState4, @NotNull SharedState<State.Layout> layout, @NotNull StateFlow<ThomasState> thomasState, @Nullable ThomasForm thomasForm, @Nullable ThomasForm thomasForm2, @Nullable PagersViewTracker pagersViewTracker) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(thomasState, "thomasState");
        this.pager = sharedState;
        this.checkbox = sharedState2;
        this.radio = sharedState3;
        this.score = sharedState4;
        this.layout = layout;
        this.thomasState = thomasState;
        this.thomasForm = thomasForm;
        this.parentForm = thomasForm2;
        this.pagerTracker = pagersViewTracker;
        this.scope = CoroutineScopeKt.CoroutineScope(AirshipDispatchers.INSTANCE.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.runningJobs = new LinkedHashMap();
    }

    @Nullable
    public final SharedState<State.Pager> getPager() {
        return this.pager;
    }

    @Nullable
    public final SharedState<State.Checkbox> getCheckbox() {
        return this.checkbox;
    }

    @Nullable
    public final SharedState<State.Radio> getRadio() {
        return this.radio;
    }

    @Nullable
    public final SharedState<State.Score> getScore() {
        return this.score;
    }

    @NotNull
    public final SharedState<State.Layout> getLayout() {
        return this.layout;
    }

    @NotNull
    public final StateFlow<ThomasState> getThomasState() {
        return this.thomasState;
    }

    @Nullable
    public final ThomasForm getThomasForm() {
        return this.thomasForm;
    }

    @Nullable
    public final ThomasForm getParentForm() {
        return this.parentForm;
    }

    @Nullable
    public final PagersViewTracker getPagerTracker() {
        return this.pagerTracker;
    }

    @NotNull
    public final CoroutineScope getScope() {
        return this.scope;
    }

    public static /* synthetic */ LayoutData reportingContext$default(LayoutState layoutState, FormInfo formInfo, PagerData pagerData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            formInfo = null;
        }
        if ((i & 2) != 0) {
            pagerData = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return layoutState.reportingContext(formInfo, pagerData, str);
    }

    @NotNull
    public final LayoutData reportingContext(@Nullable FormInfo formContext, @Nullable PagerData pagerContext, @Nullable String buttonId) {
        PagerData pagerDataCopy$default;
        StateFlow<State.Form> formUpdates;
        State.Form value;
        List<ReportingEvent.PageSummaryData.PageView> listViewedPages;
        StateFlow changes;
        State.Pager pager;
        if (pagerContext != null) {
            pagerDataCopy$default = pagerContext;
        } else {
            SharedState sharedState = this.pager;
            if (sharedState == null || (changes = sharedState.getChanges()) == null || (pager = (State.Pager) changes.getValue()) == null) {
                pagerDataCopy$default = null;
            } else {
                pagerContext = pager.reportingContext(CollectionsKt.emptyList());
                pagerDataCopy$default = pagerContext;
            }
        }
        if (pagerDataCopy$default != null) {
            PagersViewTracker pagersViewTracker = this.pagerTracker;
            if (pagersViewTracker != null && (listViewedPages = pagersViewTracker.viewedPages(pagerDataCopy$default.getIdentifier())) != null) {
                pagerDataCopy$default = PagerData.copy$default(pagerDataCopy$default, null, 0, null, 0, listViewedPages, false, 47, null);
            }
        } else {
            pagerDataCopy$default = null;
        }
        if (formContext == null) {
            ThomasForm thomasForm = this.thomasForm;
            formContext = (thomasForm == null || (formUpdates = thomasForm.getFormUpdates()) == null || (value = formUpdates.getValue()) == null) ? null : value.reportingContext();
        }
        return new LayoutData(formContext, pagerDataCopy$default, buttonId);
    }

    public static /* synthetic */ void processStateActions$default(LayoutState layoutState, List list, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        layoutState.processStateActions(list, obj);
    }

    /* renamed from: setState-moChb0s$default, reason: not valid java name */
    static /* synthetic */ void m2716setStatemoChb0s$default(LayoutState layoutState, String str, JsonValue jsonValue, Duration duration, int i, Object obj) {
        if ((i & 4) != 0) {
            duration = null;
        }
        layoutState.m2715setStatemoChb0s(str, jsonValue, duration);
    }

    /* renamed from: setState-moChb0s, reason: not valid java name */
    private final void m2715setStatemoChb0s(final String key, JsonValue value, Duration ttl) {
        if (value != null && !value.isNull()) {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            final StateMutation stateMutation = new StateMutation(string, key, value);
            this.layout.update(new Function1() { // from class: com.urbanairship.android.layout.environment.LayoutState$setState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final State.Layout invoke(State.Layout current) {
                    Intrinsics.checkNotNullParameter(current, "current");
                    Map<String, LayoutState.StateMutation> mutableMap = MapsKt.toMutableMap(current.getMutations());
                    mutableMap.put(key, stateMutation);
                    return current.copy(mutableMap);
                }
            });
            if (ttl != null) {
                Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LayoutState$setState$job$1(ttl, this, stateMutation, null), 3, null);
                Job job = (Job) this.runningJobs.get(key);
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.runningJobs.put(key, jobLaunch$default);
                return;
            }
            return;
        }
        this.layout.update(new Function1() { // from class: com.urbanairship.android.layout.environment.LayoutState$setState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State.Layout invoke(State.Layout current) {
                Intrinsics.checkNotNullParameter(current, "current");
                Map<String, LayoutState.StateMutation> mutableMap = MapsKt.toMutableMap(current.getMutations());
                mutableMap.remove(key);
                return current.copy(mutableMap);
            }
        });
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/android/layout/environment/LayoutState$StateMutation;", "", "id", "", "key", "value", "Lcom/urbanairship/json/JsonValue;", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;)V", "getId", "()Ljava/lang/String;", "getKey", "getValue", "()Lcom/urbanairship/json/JsonValue;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class StateMutation {
        private final String id;
        private final String key;
        private final JsonValue value;

        public static /* synthetic */ StateMutation copy$default(StateMutation stateMutation, String str, String str2, JsonValue jsonValue, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stateMutation.id;
            }
            if ((i & 2) != 0) {
                str2 = stateMutation.key;
            }
            if ((i & 4) != 0) {
                jsonValue = stateMutation.value;
            }
            return stateMutation.copy(str, str2, jsonValue);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final JsonValue getValue() {
            return this.value;
        }

        @NotNull
        public final StateMutation copy(@NotNull String id, @NotNull String key, @NotNull JsonValue value) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return new StateMutation(id, key, value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StateMutation)) {
                return false;
            }
            StateMutation stateMutation = (StateMutation) other;
            return Intrinsics.areEqual(this.id, stateMutation.id) && Intrinsics.areEqual(this.key, stateMutation.key) && Intrinsics.areEqual(this.value, stateMutation.value);
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.key.hashCode()) * 31) + this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "StateMutation(id=" + this.id + ", key=" + this.key + ", value=" + this.value + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public StateMutation(@NotNull String id, @NotNull String key, @NotNull JsonValue value) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.id = id;
            this.key = key;
            this.value = value;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final JsonValue getValue() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeTempMutation(final StateMutation mutation) {
        this.layout.update(new Function1() { // from class: com.urbanairship.android.layout.environment.LayoutState.removeTempMutation.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State.Layout invoke(State.Layout current) {
                Intrinsics.checkNotNullParameter(current, "current");
                Map<String, StateMutation> mutableMap = MapsKt.toMutableMap(current.getMutations());
                StateMutation stateMutation = mutableMap.get(mutation.getKey());
                if (stateMutation != null && stateMutation.equals(mutation)) {
                    mutableMap.remove(mutation.getKey());
                }
                return current.copy(mutableMap);
            }
        });
    }

    private final void clearState() {
        this.layout.update(new Function1() { // from class: com.urbanairship.android.layout.environment.LayoutState.clearState.1
            @Override // kotlin.jvm.functions.Function1
            public final State.Layout invoke(State.Layout it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copy(MapsKt.emptyMap());
            }
        });
    }

    public final void processStateActions(@Nullable List<? extends StateAction> actions, @Nullable Object formValue) {
        if (actions != null) {
            for (StateAction stateAction : actions) {
                if (stateAction instanceof StateAction.SetFormValue) {
                    JsonValue jsonValueWrapOpt = JsonValue.wrapOpt(formValue);
                    Intrinsics.checkNotNullExpressionValue(jsonValueWrapOpt, "wrapOpt(...)");
                    StringBuilder sb = new StringBuilder();
                    sb.append("StateAction: SetFormValue ");
                    StateAction.SetFormValue setFormValue = (StateAction.SetFormValue) stateAction;
                    sb.append(setFormValue.getKey());
                    sb.append(" = ");
                    sb.append(jsonValueWrapOpt);
                    UALog.v(sb.toString(), new Object[0]);
                    m2716setStatemoChb0s$default(this, setFormValue.getKey(), jsonValueWrapOpt, null, 4, null);
                } else if (stateAction instanceof StateAction.SetState) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("StateAction: SetState ");
                    StateAction.SetState setState = (StateAction.SetState) stateAction;
                    sb2.append(setState.getKey());
                    sb2.append(" = ");
                    sb2.append(setState.getValue());
                    sb2.append(", ttl = ");
                    sb2.append(setState.m2736getTtlFghU774());
                    UALog.v(sb2.toString(), new Object[0]);
                    m2715setStatemoChb0s(setState.getKey(), setState.getValue(), setState.m2736getTtlFghU774());
                } else if (Intrinsics.areEqual(stateAction, StateAction.ClearState.INSTANCE)) {
                    UALog.v("StateAction: ClearState", new Object[0]);
                    clearState();
                }
            }
        }
    }
}
