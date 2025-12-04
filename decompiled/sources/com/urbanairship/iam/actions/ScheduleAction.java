package com.urbanairship.iam.actions;

import com.urbanairship.actions.Action;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionResult;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.InAppAutomation;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B-\b\u0007\u0012$\b\u0002\u0010\u0002\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016R,\u0010\u0002\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/iam/actions/ScheduleAction;", "Lcom/urbanairship/actions/Action;", "scheduler", "Lkotlin/Function2;", "Lcom/urbanairship/automation/AutomationSchedule;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "acceptsArguments", "", "arguments", "Lcom/urbanairship/actions/ActionArguments;", "perform", "Lcom/urbanairship/actions/ActionResult;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScheduleAction extends Action {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final List DEFAULT_NAMES = CollectionsKt.listOf((Object[]) new String[]{"schedule_actions", "^sa"});
    private final Function2 scheduler;

    @JvmOverloads
    public ScheduleAction() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public static final List<String> getDEFAULT_NAMES() {
        return INSTANCE.getDEFAULT_NAMES();
    }

    /* renamed from: com.urbanairship.iam.actions.ScheduleAction$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AutomationSchedule automationSchedule, Continuation continuation) {
            return ((AnonymousClass1) create(automationSchedule, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationSchedule automationSchedule = (AutomationSchedule) this.L$0;
                InAppAutomation inAppAutomationShared = InAppAutomation.INSTANCE.shared();
                List<AutomationSchedule> listListOf = CollectionsKt.listOf(automationSchedule);
                this.label = 1;
                if (inAppAutomationShared.upsertSchedules(listListOf, this) == coroutine_suspended) {
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

    public /* synthetic */ ScheduleAction(Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new AnonymousClass1(null) : function2);
    }

    @JvmOverloads
    public ScheduleAction(@NotNull Function2<? super AutomationSchedule, ? super Continuation<? super Unit>, ? extends Object> scheduler) {
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        this.scheduler = scheduler;
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NotNull ActionArguments arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        int situation = arguments.getSituation();
        return situation == 0 || situation == 1 || situation == 3 || situation == 6;
    }

    @Override // com.urbanairship.actions.Action
    @NotNull
    public ActionResult perform(@NotNull ActionArguments arguments) throws IllegalArgumentException, NoSuchElementException, JsonException {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        AutomationSchedule.Companion companion = AutomationSchedule.INSTANCE;
        JsonValue jsonValue = arguments.getValue().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        AutomationSchedule automationScheduleFromJson = companion.fromJson(jsonValue);
        BuildersKt__BuildersKt.runBlocking$default(null, new C11341(automationScheduleFromJson, null), 1, null);
        ActionResult actionResultNewResult = ActionResult.newResult(ActionValue.wrap(automationScheduleFromJson.getIdentifier()));
        Intrinsics.checkNotNullExpressionValue(actionResultNewResult, "newResult(...)");
        return actionResultNewResult;
    }

    /* renamed from: com.urbanairship.iam.actions.ScheduleAction$perform$1, reason: invalid class name and case insensitive filesystem */
    static final class C11341 extends SuspendLambda implements Function2 {
        final /* synthetic */ AutomationSchedule $schedule;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11341(AutomationSchedule automationSchedule, Continuation continuation) {
            super(2, continuation);
            this.$schedule = automationSchedule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ScheduleAction.this.new C11341(this.$schedule, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function2 function2 = ScheduleAction.this.scheduler;
                AutomationSchedule automationSchedule = this.$schedule;
                this.label = 1;
                if (function2.invoke(automationSchedule, this) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/iam/actions/ScheduleAction$Companion;", "", "()V", "DEFAULT_NAMES", "", "", "getDEFAULT_NAMES$annotations", "getDEFAULT_NAMES", "()Ljava/util/List;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getDEFAULT_NAMES$annotations() {
        }

        private Companion() {
        }

        @NotNull
        public final List<String> getDEFAULT_NAMES() {
            return ScheduleAction.DEFAULT_NAMES;
        }
    }
}
