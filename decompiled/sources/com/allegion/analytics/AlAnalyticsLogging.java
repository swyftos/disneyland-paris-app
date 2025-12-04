package com.allegion.analytics;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;
import com.allegion.logging.AlLog;
import com.allegion.logging.AlLogging;
import com.allegion.logging.entry.IAlEntry;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.distribute.Distribute;
import com.microsoft.appcenter.utils.async.AppCenterConsumer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/allegion/analytics/AlAnalyticsLogging;", "", "()V", "subscriptions", "Lio/reactivex/disposables/CompositeDisposable;", "addAppCenterAnalyticsLogger", "", "addAppCenterExceptionLogger", "clearLoggers", "initialize", "config", "Lcom/allegion/analytics/AlAnalyticsConfig;", "onUnexpectedError", "e", "", "Analytics_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlAnalyticsLogging {
    public static final AlAnalyticsLogging INSTANCE = new AlAnalyticsLogging();
    private static final CompositeDisposable subscriptions = new CompositeDisposable();

    private AlAnalyticsLogging() {
    }

    public static final /* synthetic */ CompositeDisposable access$getSubscriptions$p(AlAnalyticsLogging alAnalyticsLogging) {
        return subscriptions;
    }

    @JvmStatic
    public static final void initialize(@NotNull AlAnalyticsConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        List listMutableListOf = CollectionsKt.mutableListOf(Analytics.class);
        if (config.getTrackCrashes()) {
            listMutableListOf.add(Crashes.class);
        }
        if (config.getEnableDistribute()) {
            listMutableListOf.add(Distribute.class);
        }
        Distribute.setUpdateTrack(2);
        Application application = config.getApplication();
        String appSecretKey = config.getAppSecretKey();
        Object[] array = listMutableListOf.toArray(new Class[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Class[] clsArr = (Class[]) array;
        AppCenter.start(application, appSecretKey, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        Analytics.setEnabled(true);
        if (config.getTrackCrashes()) {
            Crashes.setEnabled(true);
        }
        if (config.getEnableDistribute()) {
            Distribute.setEnabled(true);
            Distribute.setEnabledForDebuggableBuild(true);
        }
        Analytics.isEnabled().thenAccept(new AppCenterConsumer<Boolean>() { // from class: com.allegion.analytics.AlAnalyticsLogging.initialize.1

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/allegion/logging/entry/IAlEntry;", "Lkotlin/ParameterName;", "name", "event", "invoke"}, k = 3, mv = {1, 1, 15})
            /* renamed from: com.allegion.analytics.AlAnalyticsLogging$initialize$1$1, reason: invalid class name and collision with other inner class name */
            static final /* synthetic */ class C00211 extends FunctionReference implements Function1<IAlEntry, Unit> {
                C00211(AlAppCenterAnalyticsLogger alAppCenterAnalyticsLogger) {
                    super(1, alAppCenterAnalyticsLogger);
                }

                @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
                public final String getName() {
                    return "writeEntry";
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final KDeclarationContainer getOwner() {
                    return Reflection.getOrCreateKotlinClass(AlAppCenterAnalyticsLogger.class);
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final String getSignature() {
                    return "writeEntry$Analytics_release(Lcom/allegion/logging/entry/IAlEntry;)V";
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IAlEntry iAlEntry) {
                    invoke2(iAlEntry);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull IAlEntry p1) {
                    Intrinsics.checkParameterIsNotNull(p1, "p1");
                    AlAppCenterAnalyticsLogger.writeEntry$Analytics_release(p1);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "e", "invoke"}, k = 3, mv = {1, 1, 15})
            /* renamed from: com.allegion.analytics.AlAnalyticsLogging$initialize$1$2, reason: invalid class name */
            static final /* synthetic */ class AnonymousClass2 extends FunctionReference implements Function1<Throwable, Unit> {
                AnonymousClass2(AlAnalyticsLogging alAnalyticsLogging) {
                    super(1, alAnalyticsLogging);
                }

                @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
                public final String getName() {
                    return "onUnexpectedError";
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final KDeclarationContainer getOwner() {
                    return Reflection.getOrCreateKotlinClass(AlAnalyticsLogging.class);
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final String getSignature() {
                    return "onUnexpectedError(Ljava/lang/Throwable;)V";
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th) {
                    ((AlAnalyticsLogging) this.receiver).onUnexpectedError(th);
                }
            }

            @Override // com.microsoft.appcenter.utils.async.AppCenterConsumer
            public final void accept(Boolean isEnabled) {
                AlLog.d("AppCenter.Analytics isEnabled: %s", isEnabled);
                Intrinsics.checkExpressionValueIsNotNull(isEnabled, "isEnabled");
                if (isEnabled.booleanValue()) {
                    AlAnalyticsLogging alAnalyticsLogging = AlAnalyticsLogging.INSTANCE;
                    AlAnalyticsLogging.access$getSubscriptions$p(alAnalyticsLogging).add(AlLogging.getEntries().subscribe(new AlAnalyticsLogging$sam$io_reactivex_functions_Consumer$0(new C00211(AlAppCenterAnalyticsLogger.INSTANCE)), new AlAnalyticsLogging$sam$io_reactivex_functions_Consumer$0(new AnonymousClass2(alAnalyticsLogging))));
                }
            }
        });
        Crashes.isEnabled().thenAccept(new AppCenterConsumer<Boolean>() { // from class: com.allegion.analytics.AlAnalyticsLogging.initialize.2

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/allegion/logging/entry/IAlEntry;", "Lkotlin/ParameterName;", "name", "event", "invoke"}, k = 3, mv = {1, 1, 15})
            /* renamed from: com.allegion.analytics.AlAnalyticsLogging$initialize$2$1, reason: invalid class name */
            static final /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<IAlEntry, Unit> {
                AnonymousClass1(AlAppCenterExceptionLogger alAppCenterExceptionLogger) {
                    super(1, alAppCenterExceptionLogger);
                }

                @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
                public final String getName() {
                    return "writeEntry";
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final KDeclarationContainer getOwner() {
                    return Reflection.getOrCreateKotlinClass(AlAppCenterExceptionLogger.class);
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final String getSignature() {
                    return "writeEntry$Analytics_release(Lcom/allegion/logging/entry/IAlEntry;)V";
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IAlEntry iAlEntry) {
                    invoke2(iAlEntry);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull IAlEntry p1) {
                    Intrinsics.checkParameterIsNotNull(p1, "p1");
                    AlAppCenterExceptionLogger.writeEntry$Analytics_release(p1);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "e", "invoke"}, k = 3, mv = {1, 1, 15})
            /* renamed from: com.allegion.analytics.AlAnalyticsLogging$initialize$2$2, reason: invalid class name and collision with other inner class name */
            static final /* synthetic */ class C00222 extends FunctionReference implements Function1<Throwable, Unit> {
                C00222(AlAnalyticsLogging alAnalyticsLogging) {
                    super(1, alAnalyticsLogging);
                }

                @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
                public final String getName() {
                    return "onUnexpectedError";
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final KDeclarationContainer getOwner() {
                    return Reflection.getOrCreateKotlinClass(AlAnalyticsLogging.class);
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final String getSignature() {
                    return "onUnexpectedError(Ljava/lang/Throwable;)V";
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th) {
                    ((AlAnalyticsLogging) this.receiver).onUnexpectedError(th);
                }
            }

            @Override // com.microsoft.appcenter.utils.async.AppCenterConsumer
            public final void accept(Boolean isEnabled) {
                AlLog.d("AppCenter.Crashes isEnabled: %s", isEnabled);
                Intrinsics.checkExpressionValueIsNotNull(isEnabled, "isEnabled");
                if (isEnabled.booleanValue()) {
                    AlAnalyticsLogging alAnalyticsLogging = AlAnalyticsLogging.INSTANCE;
                    AlAnalyticsLogging.access$getSubscriptions$p(alAnalyticsLogging).add(AlLogging.getEntries().subscribe(new AlAnalyticsLogging$sam$io_reactivex_functions_Consumer$0(new AnonymousClass1(AlAppCenterExceptionLogger.INSTANCE)), new AlAnalyticsLogging$sam$io_reactivex_functions_Consumer$0(new C00222(alAnalyticsLogging))));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"LogNotTimber"})
    public final void onUnexpectedError(Throwable e) {
        Log.e("AlLog", "Unexpected Error", e);
    }

    @JvmStatic
    public static final void clearLoggers() {
        subscriptions.clear();
    }

    @JvmStatic
    public static final void addAppCenterAnalyticsLogger() {
        Analytics.isEnabled().thenAccept(new AppCenterConsumer<Boolean>() { // from class: com.allegion.analytics.AlAnalyticsLogging.addAppCenterAnalyticsLogger.1

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/allegion/logging/entry/IAlEntry;", "Lkotlin/ParameterName;", "name", "event", "invoke"}, k = 3, mv = {1, 1, 15})
            /* renamed from: com.allegion.analytics.AlAnalyticsLogging$addAppCenterAnalyticsLogger$1$1, reason: invalid class name and collision with other inner class name */
            static final /* synthetic */ class C00191 extends FunctionReference implements Function1<IAlEntry, Unit> {
                C00191(AlAppCenterAnalyticsLogger alAppCenterAnalyticsLogger) {
                    super(1, alAppCenterAnalyticsLogger);
                }

                @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
                public final String getName() {
                    return "writeEntry";
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final KDeclarationContainer getOwner() {
                    return Reflection.getOrCreateKotlinClass(AlAppCenterAnalyticsLogger.class);
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final String getSignature() {
                    return "writeEntry$Analytics_release(Lcom/allegion/logging/entry/IAlEntry;)V";
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IAlEntry iAlEntry) {
                    invoke2(iAlEntry);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull IAlEntry p1) {
                    Intrinsics.checkParameterIsNotNull(p1, "p1");
                    AlAppCenterAnalyticsLogger.writeEntry$Analytics_release(p1);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "e", "invoke"}, k = 3, mv = {1, 1, 15})
            /* renamed from: com.allegion.analytics.AlAnalyticsLogging$addAppCenterAnalyticsLogger$1$2, reason: invalid class name */
            static final /* synthetic */ class AnonymousClass2 extends FunctionReference implements Function1<Throwable, Unit> {
                AnonymousClass2(AlAnalyticsLogging alAnalyticsLogging) {
                    super(1, alAnalyticsLogging);
                }

                @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
                public final String getName() {
                    return "onUnexpectedError";
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final KDeclarationContainer getOwner() {
                    return Reflection.getOrCreateKotlinClass(AlAnalyticsLogging.class);
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final String getSignature() {
                    return "onUnexpectedError(Ljava/lang/Throwable;)V";
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th) {
                    ((AlAnalyticsLogging) this.receiver).onUnexpectedError(th);
                }
            }

            @Override // com.microsoft.appcenter.utils.async.AppCenterConsumer
            public final void accept(Boolean isEnabled) {
                AlLog.d("AppCenter.Analytics isEnabled: %s", isEnabled);
                Intrinsics.checkExpressionValueIsNotNull(isEnabled, "isEnabled");
                if (isEnabled.booleanValue()) {
                    AlAnalyticsLogging alAnalyticsLogging = AlAnalyticsLogging.INSTANCE;
                    AlAnalyticsLogging.access$getSubscriptions$p(alAnalyticsLogging).add(AlLogging.getEntries().subscribe(new AlAnalyticsLogging$sam$io_reactivex_functions_Consumer$0(new C00191(AlAppCenterAnalyticsLogger.INSTANCE)), new AlAnalyticsLogging$sam$io_reactivex_functions_Consumer$0(new AnonymousClass2(alAnalyticsLogging))));
                }
            }
        });
    }

    @JvmStatic
    public static final void addAppCenterExceptionLogger() {
        Crashes.isEnabled().thenAccept(new AppCenterConsumer<Boolean>() { // from class: com.allegion.analytics.AlAnalyticsLogging.addAppCenterExceptionLogger.1

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/allegion/logging/entry/IAlEntry;", "Lkotlin/ParameterName;", "name", "event", "invoke"}, k = 3, mv = {1, 1, 15})
            /* renamed from: com.allegion.analytics.AlAnalyticsLogging$addAppCenterExceptionLogger$1$1, reason: invalid class name and collision with other inner class name */
            static final /* synthetic */ class C00201 extends FunctionReference implements Function1<IAlEntry, Unit> {
                C00201(AlAppCenterExceptionLogger alAppCenterExceptionLogger) {
                    super(1, alAppCenterExceptionLogger);
                }

                @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
                public final String getName() {
                    return "writeEntry";
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final KDeclarationContainer getOwner() {
                    return Reflection.getOrCreateKotlinClass(AlAppCenterExceptionLogger.class);
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final String getSignature() {
                    return "writeEntry$Analytics_release(Lcom/allegion/logging/entry/IAlEntry;)V";
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IAlEntry iAlEntry) {
                    invoke2(iAlEntry);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull IAlEntry p1) {
                    Intrinsics.checkParameterIsNotNull(p1, "p1");
                    AlAppCenterExceptionLogger.writeEntry$Analytics_release(p1);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "e", "invoke"}, k = 3, mv = {1, 1, 15})
            /* renamed from: com.allegion.analytics.AlAnalyticsLogging$addAppCenterExceptionLogger$1$2, reason: invalid class name */
            static final /* synthetic */ class AnonymousClass2 extends FunctionReference implements Function1<Throwable, Unit> {
                AnonymousClass2(AlAnalyticsLogging alAnalyticsLogging) {
                    super(1, alAnalyticsLogging);
                }

                @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
                public final String getName() {
                    return "onUnexpectedError";
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final KDeclarationContainer getOwner() {
                    return Reflection.getOrCreateKotlinClass(AlAnalyticsLogging.class);
                }

                @Override // kotlin.jvm.internal.CallableReference
                public final String getSignature() {
                    return "onUnexpectedError(Ljava/lang/Throwable;)V";
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th) {
                    ((AlAnalyticsLogging) this.receiver).onUnexpectedError(th);
                }
            }

            @Override // com.microsoft.appcenter.utils.async.AppCenterConsumer
            public final void accept(Boolean isEnabled) {
                AlLog.d("AppCenter.Crashes isEnabled: %s", isEnabled);
                Intrinsics.checkExpressionValueIsNotNull(isEnabled, "isEnabled");
                if (isEnabled.booleanValue()) {
                    AlAnalyticsLogging alAnalyticsLogging = AlAnalyticsLogging.INSTANCE;
                    AlAnalyticsLogging.access$getSubscriptions$p(alAnalyticsLogging).add(AlLogging.getEntries().subscribe(new AlAnalyticsLogging$sam$io_reactivex_functions_Consumer$0(new C00201(AlAppCenterExceptionLogger.INSTANCE)), new AlAnalyticsLogging$sam$io_reactivex_functions_Consumer$0(new AnonymousClass2(alAnalyticsLogging))));
                }
            }
        });
    }
}
