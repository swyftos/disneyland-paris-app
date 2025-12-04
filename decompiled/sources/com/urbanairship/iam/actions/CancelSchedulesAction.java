package com.urbanairship.iam.actions;

import ch.qos.logback.core.CoreConstants;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.actions.Action;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionResult;
import com.urbanairship.automation.InAppAutomation;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0017\b\u0007\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/iam/actions/CancelSchedulesAction;", "Lcom/urbanairship/actions/Action;", "automationGetter", "Lkotlin/Function0;", "Lcom/urbanairship/automation/InAppAutomation;", "(Lkotlin/jvm/functions/Function0;)V", "acceptsArguments", "", "arguments", "Lcom/urbanairship/actions/ActionArguments;", "perform", "Lcom/urbanairship/actions/ActionResult;", "Arguments", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CancelSchedulesAction extends Action {
    private final Function0 automationGetter;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final List DEFAULT_NAMES = CollectionsKt.listOf((Object[]) new String[]{"cancel_scheduled_actions", "^csa"});
    private static final String GROUPS = "groups";
    private static final String IDS = "ids";
    private static final String ALL = AirshipConfigOptions.FEATURE_ALL;

    @JvmOverloads
    public CancelSchedulesAction() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public static final String getALL() {
        return INSTANCE.getALL();
    }

    @NotNull
    public static final List<String> getDEFAULT_NAMES() {
        return INSTANCE.getDEFAULT_NAMES();
    }

    @NotNull
    public static final String getGROUPS() {
        return INSTANCE.getGROUPS();
    }

    @NotNull
    public static final String getIDS() {
        return INSTANCE.getIDS();
    }

    public /* synthetic */ CancelSchedulesAction(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0() { // from class: com.urbanairship.iam.actions.CancelSchedulesAction.1
            @Override // kotlin.jvm.functions.Function0
            public final InAppAutomation invoke() {
                return InAppAutomation.INSTANCE.shared();
            }
        } : function0);
    }

    @JvmOverloads
    public CancelSchedulesAction(@NotNull Function0<InAppAutomation> automationGetter) {
        Intrinsics.checkNotNullParameter(automationGetter, "automationGetter");
        this.automationGetter = automationGetter;
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NotNull ActionArguments arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        int situation = arguments.getSituation();
        return situation == 0 || situation == 1 || situation == 3 || situation == 6;
    }

    @Override // com.urbanairship.actions.Action
    @NotNull
    public ActionResult perform(@NotNull ActionArguments arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Arguments.Companion companion = Arguments.Companion;
        JsonValue jsonValue = arguments.getValue().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        BuildersKt__BuildersKt.runBlocking$default(null, new C11321(companion.fromJson(jsonValue), (InAppAutomation) this.automationGetter.invoke(), null), 1, null);
        ActionResult actionResultNewEmptyResult = ActionResult.newEmptyResult();
        Intrinsics.checkNotNullExpressionValue(actionResultNewEmptyResult, "newEmptyResult(...)");
        return actionResultNewEmptyResult;
    }

    /* renamed from: com.urbanairship.iam.actions.CancelSchedulesAction$perform$1, reason: invalid class name and case insensitive filesystem */
    static final class C11321 extends SuspendLambda implements Function2 {
        final /* synthetic */ Arguments $args;
        final /* synthetic */ InAppAutomation $automation;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11321(Arguments arguments, InAppAutomation inAppAutomation, Continuation continuation) {
            super(2, continuation);
            this.$args = arguments;
            this.$automation = inAppAutomation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11321(this.$args, this.$automation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2e
                if (r1 == r4) goto L2a
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r6)
                goto L8a
            L16:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1e:
                java.lang.Object r1 = r5.L$1
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r4 = r5.L$0
                com.urbanairship.automation.InAppAutomation r4 = (com.urbanairship.automation.InAppAutomation) r4
                kotlin.ResultKt.throwOnFailure(r6)
                goto L59
            L2a:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L46
            L2e:
                kotlin.ResultKt.throwOnFailure(r6)
                com.urbanairship.iam.actions.CancelSchedulesAction$Arguments r6 = r5.$args
                boolean r6 = r6.getCancelAll()
                if (r6 == 0) goto L49
                com.urbanairship.automation.InAppAutomation r6 = r5.$automation
                com.urbanairship.automation.AutomationSchedule$ScheduleType r1 = com.urbanairship.automation.AutomationSchedule.ScheduleType.ACTIONS
                r5.label = r4
                java.lang.Object r5 = r6.cancelSchedulesWith$urbanairship_automation_release(r1, r5)
                if (r5 != r0) goto L46
                return r0
            L46:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            L49:
                com.urbanairship.iam.actions.CancelSchedulesAction$Arguments r6 = r5.$args
                java.util.List r6 = r6.getGroups()
                if (r6 == 0) goto L72
                com.urbanairship.automation.InAppAutomation r1 = r5.$automation
                java.util.Iterator r6 = r6.iterator()
                r4 = r1
                r1 = r6
            L59:
                boolean r6 = r1.hasNext()
                if (r6 == 0) goto L72
                java.lang.Object r6 = r1.next()
                java.lang.String r6 = (java.lang.String) r6
                r5.L$0 = r4
                r5.L$1 = r1
                r5.label = r3
                java.lang.Object r6 = r4.cancelSchedules(r6, r5)
                if (r6 != r0) goto L59
                return r0
            L72:
                com.urbanairship.iam.actions.CancelSchedulesAction$Arguments r6 = r5.$args
                java.util.List r6 = r6.getScheduleIDs()
                if (r6 == 0) goto L8a
                com.urbanairship.automation.InAppAutomation r1 = r5.$automation
                r3 = 0
                r5.L$0 = r3
                r5.L$1 = r3
                r5.label = r2
                java.lang.Object r5 = r1.cancelSchedules(r6, r5)
                if (r5 != r0) goto L8a
                return r0
            L8a:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.actions.CancelSchedulesAction.C11321.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0007R\u001c\u0010\u0010\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/iam/actions/CancelSchedulesAction$Companion;", "", "()V", "ALL", "", "getALL$annotations", "getALL", "()Ljava/lang/String;", "DEFAULT_NAMES", "", "getDEFAULT_NAMES$annotations", "getDEFAULT_NAMES", "()Ljava/util/List;", "GROUPS", "getGROUPS$annotations", "getGROUPS", "IDS", "getIDS$annotations", "getIDS", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getALL$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getDEFAULT_NAMES$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getGROUPS$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getIDS$annotations() {
        }

        private Companion() {
        }

        @NotNull
        public final List<String> getDEFAULT_NAMES() {
            return CancelSchedulesAction.DEFAULT_NAMES;
        }

        @NotNull
        public final String getGROUPS() {
            return CancelSchedulesAction.GROUPS;
        }

        @NotNull
        public final String getIDS() {
            return CancelSchedulesAction.IDS;
        }

        @NotNull
        public final String getALL() {
            return CancelSchedulesAction.ALL;
        }
    }

    private static final class Arguments {
        public static final Companion Companion = new Companion(null);
        private final boolean cancelAll;
        private final List groups;
        private final List scheduleIDs;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Arguments)) {
                return false;
            }
            Arguments arguments = (Arguments) obj;
            return this.cancelAll == arguments.cancelAll && Intrinsics.areEqual(this.scheduleIDs, arguments.scheduleIDs) && Intrinsics.areEqual(this.groups, arguments.groups);
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.cancelAll) * 31;
            List list = this.scheduleIDs;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            List list2 = this.groups;
            return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
        }

        public String toString() {
            return "Arguments(cancelAll=" + this.cancelAll + ", scheduleIDs=" + this.scheduleIDs + ", groups=" + this.groups + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Arguments(boolean z, List list, List list2) {
            this.cancelAll = z;
            this.scheduleIDs = list;
            this.groups = list2;
        }

        public final boolean getCancelAll() {
            return this.cancelAll;
        }

        public final List getScheduleIDs() {
            return this.scheduleIDs;
        }

        public final List getGroups() {
            return this.groups;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/actions/CancelSchedulesAction$Arguments$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/iam/actions/CancelSchedulesAction$Arguments;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nCancelSchedulesAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancelSchedulesAction.kt\ncom/urbanairship/iam/actions/CancelSchedulesAction$Arguments$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,122:1\n1#2:123\n1#2:134\n1603#3,9:124\n1855#3:133\n1856#3:135\n1612#3:136\n*S KotlinDebug\n*F\n+ 1 CancelSchedulesAction.kt\ncom/urbanairship/iam/actions/CancelSchedulesAction$Arguments$Companion\n*L\n101#1:134\n101#1:124,9\n101#1:133\n101#1:135\n101#1:136\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            private static final List fromJson$getSingleOrList(JsonValue jsonValue) {
                if (jsonValue.isString()) {
                    return CollectionsKt.listOf(jsonValue.getString(""));
                }
                JsonList jsonListOptList = jsonValue.optList();
                Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
                ArrayList arrayList = new ArrayList();
                Iterator<JsonValue> it = jsonListOptList.iterator();
                while (it.hasNext()) {
                    String string = it.next().getString();
                    if (string != null) {
                        arrayList.add(string);
                    }
                }
                return arrayList;
            }

            @NotNull
            public final Arguments fromJson(@NotNull JsonValue value) throws IllegalArgumentException {
                boolean zAreEqual;
                Intrinsics.checkNotNullParameter(value, "value");
                String string = value.getString();
                if (string != null) {
                    String lowerCase = string.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    zAreEqual = Intrinsics.areEqual(lowerCase, CancelSchedulesAction.INSTANCE.getALL());
                } else {
                    zAreEqual = false;
                }
                JsonMap jsonMapOptMap = value.optMap();
                Companion companion = CancelSchedulesAction.INSTANCE;
                JsonValue jsonValue = jsonMapOptMap.get(companion.getIDS());
                List listFromJson$getSingleOrList = jsonValue != null ? fromJson$getSingleOrList(jsonValue) : null;
                JsonValue jsonValue2 = value.optMap().get(companion.getGROUPS());
                List listFromJson$getSingleOrList2 = jsonValue2 != null ? fromJson$getSingleOrList(jsonValue2) : null;
                if (!zAreEqual && listFromJson$getSingleOrList == null && listFromJson$getSingleOrList2 == null) {
                    throw new IllegalArgumentException();
                }
                return new Arguments(zAreEqual, listFromJson$getSingleOrList, listFromJson$getSingleOrList2);
            }
        }
    }
}
