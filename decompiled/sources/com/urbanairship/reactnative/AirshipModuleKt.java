package com.urbanairship.reactnative;

import ch.qos.logback.core.joran.action.Action;
import com.facebook.react.bridge.Promise;
import com.urbanairship.android.framework.proxy.EventType;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a9\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u001e\u0010\b\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0000¢\u0006\u0002\u0010\u000b\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0000¨\u0006\u000f"}, d2 = {"toReactType", "", "Lcom/urbanairship/json/JsonSerializable;", "resolve", "", "Lcom/facebook/react/bridge/Promise;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "function", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lcom/facebook/react/bridge/Promise;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "isForeground", "", "Lcom/urbanairship/android/framework/proxy/EventType;", "ua_react-native-airship_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AirshipModuleKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.PUSH_TOKEN_RECEIVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventType.BACKGROUND_NOTIFICATION_RESPONSE_RECEIVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventType.BACKGROUND_PUSH_RECEIVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EventType.FOREGROUND_PUSH_RECEIVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Nullable
    public static final Object toReactType(@NotNull JsonSerializable jsonSerializable) {
        Intrinsics.checkNotNullParameter(jsonSerializable, "<this>");
        JsonValue jsonValue = jsonSerializable.getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return Utils.convertJsonValue(jsonValue);
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModuleKt$resolve$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function1 $function;
        final /* synthetic */ Promise $this_resolve;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.$function = function1;
            this.$this_resolve = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$function, this.$this_resolve, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1 function1 = this.$function;
                    this.label = 1;
                    obj = function1.invoke(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (obj instanceof Unit) {
                    this.$this_resolve.resolve(null);
                } else if (obj instanceof JsonSerializable) {
                    this.$this_resolve.resolve(AirshipModuleKt.toReactType((JsonSerializable) obj));
                } else if (obj instanceof Number) {
                    this.$this_resolve.resolve(Boxing.boxDouble(((Number) obj).doubleValue()));
                } else {
                    Promise promise = this.$this_resolve;
                    JsonValue jsonValueWrapOpt = JsonValue.wrapOpt(obj);
                    Intrinsics.checkNotNullExpressionValue(jsonValueWrapOpt, "wrapOpt(...)");
                    promise.resolve(AirshipModuleKt.toReactType(jsonValueWrapOpt));
                }
            } catch (Exception e) {
                this.$this_resolve.reject("AIRSHIP_ERROR", e);
            }
            return Unit.INSTANCE;
        }
    }

    public static final void resolve(@NotNull Promise promise, @NotNull CoroutineScope scope, @NotNull Function1<? super Continuation<Object>, ? extends Object> function) {
        Intrinsics.checkNotNullParameter(promise, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(function, "function");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(function, promise, null), 3, null);
    }

    public static final boolean isForeground(@NotNull EventType eventType) {
        Intrinsics.checkNotNullParameter(eventType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()];
        return (i == 1 || i == 2 || i == 3 || i == 4) ? false : true;
    }
}
