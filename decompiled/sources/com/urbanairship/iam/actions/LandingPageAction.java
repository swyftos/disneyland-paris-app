package com.urbanairship.iam.actions;

import android.net.Uri;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.actions.Action;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionResult;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.AutomationTrigger;
import com.urbanairship.automation.InAppAutomation;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.content.HTML;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.Clock;
import com.urbanairship.util.UriUtils;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB5\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\"\b\u0002\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b¢\u0006\u0002\u0010\tBs\u0012\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0012\"\b\u0002\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0006H\u0016R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\bX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/iam/actions/LandingPageAction;", "Lcom/urbanairship/actions/Action;", "borderRadius", "", "scheduleExtender", "Lkotlin/Function2;", "Lcom/urbanairship/actions/ActionArguments;", "Lcom/urbanairship/automation/AutomationSchedule;", "Lcom/urbanairship/iam/actions/ScheduleExtender;", "(FLkotlin/jvm/functions/Function2;)V", "scheduler", "Lkotlin/coroutines/Continuation;", "", "", "allowListChecker", "Lkotlin/Function1;", "", "", "clock", "Lcom/urbanairship/util/Clock;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;FLcom/urbanairship/util/Clock;)V", "Lkotlin/jvm/functions/Function2;", "acceptsArguments", "arguments", "perform", "Lcom/urbanairship/actions/ActionResult;", "Companion", "LandingPageArgs", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLandingPageAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LandingPageAction.kt\ncom/urbanairship/iam/actions/LandingPageAction\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,201:1\n1#2:202\n*E\n"})
/* loaded from: classes5.dex */
public final class LandingPageAction extends Action {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final List DEFAULT_NAMES = CollectionsKt.listOf((Object[]) new String[]{"landing_page_action", "^p"});
    private final Function1 allowListChecker;
    private final float borderRadius;
    private final Clock clock;
    private final Function2 scheduleExtender;
    private final Function2 scheduler;

    @JvmOverloads
    public LandingPageAction() {
        this(BitmapDescriptorFactory.HUE_RED, null, 3, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public LandingPageAction(float f) {
        this(f, null, 2, 0 == true ? 1 : 0);
    }

    @NotNull
    public static final List<String> getDEFAULT_NAMES() {
        return INSTANCE.getDEFAULT_NAMES();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LandingPageAction(Function2 function2, Function1 function1, Function2 function22, float f, Clock DEFAULT_CLOCK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Function2 function23 = (i & 4) != 0 ? null : function22;
        if ((i & 16) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(function2, function1, function23, f, DEFAULT_CLOCK);
    }

    public LandingPageAction(@NotNull Function2<? super AutomationSchedule, ? super Continuation<? super Unit>, ? extends Object> scheduler, @NotNull Function1<? super String, Boolean> allowListChecker, @Nullable Function2<? super ActionArguments, ? super AutomationSchedule, AutomationSchedule> function2, float f, @NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(allowListChecker, "allowListChecker");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.scheduler = scheduler;
        this.allowListChecker = allowListChecker;
        this.scheduleExtender = function2;
        this.borderRadius = f;
        this.clock = clock;
    }

    public /* synthetic */ LandingPageAction(float f, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 2.0f : f, (i & 2) != 0 ? null : function2);
    }

    /* renamed from: com.urbanairship.iam.actions.LandingPageAction$1, reason: invalid class name */
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

    @JvmOverloads
    public LandingPageAction(float f, @Nullable Function2<? super ActionArguments, ? super AutomationSchedule, AutomationSchedule> function2) {
        this(new AnonymousClass1(null), new Function1() { // from class: com.urbanairship.iam.actions.LandingPageAction.2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return Boolean.valueOf(UAirship.shared().getUrlAllowList().isAllowed(url, 2));
            }
        }, function2, f, null, 16, null);
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NotNull ActionArguments arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        int situation = arguments.getSituation();
        return situation == 0 || situation == 6 || situation == 2 || situation == 3 || situation == 4;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12, types: [T, com.urbanairship.automation.AutomationSchedule, java.lang.Object] */
    @Override // com.urbanairship.actions.Action
    @NotNull
    public ActionResult perform(@NotNull ActionArguments arguments) throws IllegalArgumentException, JsonException {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        PushMessage pushMessage = (PushMessage) arguments.getMetadata().getParcelable(ActionArguments.PUSH_MESSAGE_METADATA);
        String sendId = pushMessage != null ? pushMessage.getSendId() : null;
        LandingPageArgs.Companion companion = LandingPageArgs.Companion;
        JsonValue jsonValue = arguments.getValue().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        LandingPageArgs landingPageArgsFromJson = companion.fromJson(jsonValue, this.allowListChecker);
        String str = "Landing Page " + landingPageArgsFromJson.getUri();
        String string = landingPageArgsFromJson.getUri().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        InAppMessage inAppMessage = new InAppMessage(str, new InAppMessageDisplayContent.HTMLContent(new HTML(string, landingPageArgsFromJson.getHeight(), landingPageArgsFromJson.getWidth(), landingPageArgsFromJson.getAspectLock(), Boolean.FALSE, null, null, this.borderRadius, false, 96, null)), (JsonMap) null, (JsonMap) null, Boolean.valueOf(sendId != null), InAppMessage.DisplayBehavior.IMMEDIATE, 12, (DefaultConstructorMarker) null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (sendId == null) {
            sendId = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(sendId, "toString(...)");
        }
        ?? automationSchedule = new AutomationSchedule(sendId, CollectionsKt.listOf(AutomationTrigger.INSTANCE.m2779activeSessionWZ4Q5Ns(1)), null, Integer.MIN_VALUE, null, null, null, null, null, null, null, new AutomationSchedule.ScheduleData.InAppMessageData(inAppMessage), Boolean.TRUE, null, null, null, null, null, null, "landing_page", null, ULong.m3028constructorimpl(this.clock.currentTimeMillis()), "landing_page", null, 9955316, null);
        objectRef.element = automationSchedule;
        Function2 function2 = this.scheduleExtender;
        if (function2 != null) {
            objectRef.element = function2.invoke(arguments, automationSchedule);
        }
        BuildersKt__BuildersKt.runBlocking$default(null, new C11332(objectRef, null), 1, null);
        ActionResult actionResultNewEmptyResult = ActionResult.newEmptyResult();
        Intrinsics.checkNotNullExpressionValue(actionResultNewEmptyResult, "newEmptyResult(...)");
        return actionResultNewEmptyResult;
    }

    /* renamed from: com.urbanairship.iam.actions.LandingPageAction$perform$2, reason: invalid class name and case insensitive filesystem */
    static final class C11332 extends SuspendLambda implements Function2 {
        final /* synthetic */ Ref.ObjectRef $schedule;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11332(Ref.ObjectRef objectRef, Continuation continuation) {
            super(2, continuation);
            this.$schedule = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LandingPageAction.this.new C11332(this.$schedule, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11332) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function2 function2 = LandingPageAction.this.scheduler;
                T t = this.$schedule.element;
                this.label = 1;
                if (function2.invoke(t, this) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/iam/actions/LandingPageAction$Companion;", "", "()V", "DEFAULT_BORDER_RADIUS", "", "DEFAULT_NAMES", "", "", "getDEFAULT_NAMES$annotations", "getDEFAULT_NAMES", "()Ljava/util/List;", "PRODUCT_ID", "QUEUE", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
            return LandingPageAction.DEFAULT_NAMES;
        }
    }

    private static final class LandingPageArgs {
        public static final Companion Companion = new Companion(null);
        private final Boolean aspectLock;
        private final long height;
        private final Uri uri;
        private final long width;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LandingPageArgs)) {
                return false;
            }
            LandingPageArgs landingPageArgs = (LandingPageArgs) obj;
            return Intrinsics.areEqual(this.uri, landingPageArgs.uri) && this.height == landingPageArgs.height && this.width == landingPageArgs.width && Intrinsics.areEqual(this.aspectLock, landingPageArgs.aspectLock);
        }

        public int hashCode() {
            int iHashCode = ((((this.uri.hashCode() * 31) + Long.hashCode(this.height)) * 31) + Long.hashCode(this.width)) * 31;
            Boolean bool = this.aspectLock;
            return iHashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "LandingPageArgs(uri=" + this.uri + ", height=" + this.height + ", width=" + this.width + ", aspectLock=" + this.aspectLock + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public LandingPageArgs(Uri uri, long j, long j2, Boolean bool) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
            this.height = j;
            this.width = j2;
            this.aspectLock = bool;
        }

        public /* synthetic */ LandingPageArgs(Uri uri, long j, long j2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(uri, (i & 2) != 0 ? 0L : j, (i & 4) == 0 ? j2 : 0L, (i & 8) != 0 ? null : bool);
        }

        public final Uri getUri() {
            return this.uri;
        }

        public final long getHeight() {
            return this.height;
        }

        public final long getWidth() {
            return this.width;
        }

        public final Boolean getAspectLock() {
            return this.aspectLock;
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/iam/actions/LandingPageAction$LandingPageArgs$Companion;", "", "()V", "ASPECT_LOCK_KEY", "", "ASPECT_LOCK_LEGACY_KEY", "HEIGHT_KEY", "URL_KEY", "WIDTH_KEY", "fromJson", "Lcom/urbanairship/iam/actions/LandingPageAction$LandingPageArgs;", "value", "Lcom/urbanairship/json/JsonValue;", "isUrlAllowed", "Lkotlin/Function1;", "", "Lcom/urbanairship/iam/actions/UrlChecker;", "parseUri", "Landroid/net/Uri;", "checker", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nLandingPageAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LandingPageAction.kt\ncom/urbanairship/iam/actions/LandingPageAction$LandingPageArgs$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,201:1\n79#2,16:202\n79#2,16:218\n79#2,16:234\n79#2,16:250\n*S KotlinDebug\n*F\n+ 1 LandingPageAction.kt\ncom/urbanairship/iam/actions/LandingPageAction$LandingPageArgs$Companion\n*L\n164#1:202,16\n165#1:218,16\n166#1:234,16\n167#1:250,16\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final LandingPageArgs fromJson(@NotNull JsonValue value, @NotNull Function1<? super String, Boolean> isUrlAllowed) throws IllegalArgumentException, JsonException {
                Long lValueOf;
                Long lValueOf2;
                long j;
                Boolean boolValueOf;
                Boolean bool;
                Boolean bool2;
                Boolean boolValueOf2;
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(isUrlAllowed, "isUrlAllowed");
                if (value.isString()) {
                    return new LandingPageArgs(parseUri(value, isUrlAllowed), 0L, 0L, null, 14, null);
                }
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValueRequire = jsonMapRequireMap.require("url");
                Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                Uri uri = parseUri(jsonValueRequire, isUrlAllowed);
                JsonValue jsonValue = jsonMapRequireMap.get("height");
                if (jsonValue == null) {
                    lValueOf = null;
                } else {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        lValueOf = (Long) jsonValue.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        lValueOf = (Long) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        lValueOf = Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        lValueOf = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        lValueOf = (Long) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        lValueOf = (Long) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        lValueOf = (Long) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        lValueOf = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        lValueOf = (Long) jsonValue.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        lValueOf = (Long) jsonValue.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'height" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        lValueOf = (Long) jsonValue.getJsonValue();
                    }
                }
                long jLongValue = lValueOf != null ? lValueOf.longValue() : 0L;
                JsonValue jsonValue2 = jsonMapRequireMap.get("width");
                if (jsonValue2 == null) {
                    lValueOf2 = null;
                } else {
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        lValueOf2 = (Long) jsonValue2.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        lValueOf2 = (Long) Boolean.valueOf(jsonValue2.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        lValueOf2 = Long.valueOf(jsonValue2.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        lValueOf2 = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        lValueOf2 = (Long) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        lValueOf2 = (Long) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        lValueOf2 = (Long) Integer.valueOf(jsonValue2.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        lValueOf2 = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        lValueOf2 = (Long) jsonValue2.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        lValueOf2 = (Long) jsonValue2.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'width" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        lValueOf2 = (Long) jsonValue2.getJsonValue();
                    }
                }
                long jLongValue2 = lValueOf2 != null ? lValueOf2.longValue() : 0L;
                JsonValue jsonValue3 = jsonMapRequireMap.get("aspect_lock");
                if (jsonValue3 == null) {
                    j = jLongValue2;
                    boolValueOf = null;
                } else {
                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        Boolean bool3 = (Boolean) jsonValue3.optString();
                        boolValueOf = bool3;
                        j = jLongValue2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf = Boolean.valueOf(jsonValue3.getBoolean(false));
                        j = jLongValue2;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            j = jLongValue2;
                            bool = (Boolean) Long.valueOf(jsonValue3.getLong(0L));
                        } else {
                            j = jLongValue2;
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                bool = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                bool = (Boolean) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                bool = (Boolean) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                boolValueOf = (Boolean) Integer.valueOf(jsonValue3.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                boolValueOf = (Boolean) jsonValue3.optList();
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                boolValueOf = (Boolean) jsonValue3.optMap();
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'aspect_lock" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                boolValueOf = (Boolean) jsonValue3.getJsonValue();
                            }
                        }
                        boolValueOf = bool;
                    }
                }
                if (boolValueOf == null) {
                    JsonValue jsonValue4 = jsonMapRequireMap.get("aspectLock");
                    if (jsonValue4 == null) {
                        bool2 = null;
                    } else {
                        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Boolean.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            boolValueOf2 = (Boolean) jsonValue4.optString();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            boolValueOf2 = Boolean.valueOf(jsonValue4.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            boolValueOf2 = (Boolean) Long.valueOf(jsonValue4.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            boolValueOf2 = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            boolValueOf2 = (Boolean) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            boolValueOf2 = (Boolean) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            boolValueOf2 = (Boolean) Integer.valueOf(jsonValue4.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            boolValueOf2 = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            boolValueOf2 = (Boolean) jsonValue4.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            boolValueOf2 = (Boolean) jsonValue4.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'aspectLock" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            boolValueOf2 = (Boolean) jsonValue4.getJsonValue();
                        }
                        bool2 = boolValueOf2;
                    }
                } else {
                    bool2 = boolValueOf;
                }
                return new LandingPageArgs(uri, jLongValue, j, bool2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v15, types: [T, android.net.Uri, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v5, types: [T, android.net.Uri] */
            @NotNull
            public final Uri parseUri(@NotNull JsonValue value, @NotNull Function1<? super String, Boolean> checker) throws IllegalArgumentException {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(checker, "checker");
                String string = value.getString();
                if (string == null || string.length() == 0) {
                    throw new IllegalArgumentException();
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? r2 = UriUtils.parse(string);
                if (r2 == 0) {
                    throw new IllegalArgumentException();
                }
                objectRef.element = r2;
                String string2 = r2.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                if (string2.length() == 0) {
                    throw new IllegalArgumentException();
                }
                String scheme = ((Uri) objectRef.element).getScheme();
                if (scheme == null || scheme.length() == 0) {
                    ?? r22 = Uri.parse("https://" + objectRef.element);
                    Intrinsics.checkNotNullExpressionValue(r22, "parse(...)");
                    objectRef.element = r22;
                }
                String string3 = ((Uri) objectRef.element).toString();
                Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                if (!checker.invoke(string3).booleanValue()) {
                    UALog.e$default(null, new Function0() { // from class: com.urbanairship.iam.actions.LandingPageAction$LandingPageArgs$Companion$parseUri$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Landing page URL is not allowed " + objectRef.element;
                        }
                    }, 1, null);
                    throw new IllegalArgumentException();
                }
                return (Uri) objectRef.element;
            }
        }
    }
}
