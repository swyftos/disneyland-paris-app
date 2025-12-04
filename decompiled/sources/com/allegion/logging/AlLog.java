package com.allegion.logging;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.allegion.logging.entry.AlExceptionEntry;
import com.allegion.logging.entry.AlExceptionLogEntry;
import com.allegion.logging.entry.AlLogEntry;
import com.allegion.logging.entry.AlLoggingLevel;
import com.allegion.logging.entry.IAlEntry;
import com.allegion.logging.event.AlActionEvent;
import com.allegion.logging.event.AlActionType;
import com.allegion.logging.event.AlCustomEvent;
import com.allegion.logging.event.AlEventType;
import com.allegion.logging.logger.AlDebugEntryLogger;
import com.allegion.logging.logger.AlDebugEventLogger;
import com.allegion.logging.logger.AlTimberEntryLogger;
import com.allegion.logging.logger.AlTimberEventLogger;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.contentsquare.android.core.system.DeviceInfo;
import gherkin.GherkinLanguageConstants;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\fJ\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J7\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\bH\u0007J\b\u0010\u0011\u001a\u00020\bH\u0007J5\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u0016J\u001a\u0010\u0012\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J?\u0010\u0012\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u0019J-\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\fJ\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J7\u0010\u001a\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u000fJ-\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\fJ\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J7\u0010\u001b\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001dH\u0002J-\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\fJ\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J7\u0010\u001e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u001f\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0003J=\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010%JU\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020&2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042.\u0010\n\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010'0\u000b\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010'H\u0007¢\u0006\u0002\u0010(J6\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020&2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010)H\u0007J-\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\fJ-\u0010,\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\fJ\u0012\u0010,\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J7\u0010,\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u000fJ-\u0010-\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\fJ\u0012\u0010-\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J7\u0010-\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u000fJ-\u0010.\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\fJ\u0012\u0010.\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J7\u0010.\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/allegion/logging/AlLog;", "", "()V", "EVENT_CATEGORY_SCREEN", "", "subscriptions", "Lio/reactivex/disposables/CompositeDisposable;", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "", "message", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "exception", "", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "addDebugLoggers", "clearDebugLoggers", "createLogEntry", "Lcom/allegion/logging/entry/AlLogEntry;", "level", "Lcom/allegion/logging/entry/AlLoggingLevel;", "(Lcom/allegion/logging/entry/AlLoggingLevel;Ljava/lang/String;[Ljava/lang/Object;)Lcom/allegion/logging/entry/AlLogEntry;", "Lcom/allegion/logging/entry/AlExceptionEntry;", "Lcom/allegion/logging/entry/AlExceptionLogEntry;", "(Lcom/allegion/logging/entry/AlLoggingLevel;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lcom/allegion/logging/entry/AlExceptionLogEntry;", "d", "e", "getCategoryAndAction", "Lkotlin/Pair;", "i", "onUnexpectedError", "trackEvent", "type", "Lcom/allegion/logging/event/AlActionType;", "category", "action", "(Lcom/allegion/logging/event/AlActionType;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "Lcom/allegion/logging/event/AlEventType;", "Landroidx/core/util/Pair;", "(Lcom/allegion/logging/event/AlEventType;Ljava/lang/String;Ljava/lang/String;[Landroidx/core/util/Pair;)V", "", "trackScreen", "screenName", "v", DeviceInfo.WIDTH, "wtf", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlLog {
    private static final String EVENT_CATEGORY_SCREEN = "Screen";
    public static final AlLog INSTANCE = new AlLog();
    private static final CompositeDisposable subscriptions = new CompositeDisposable();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/allegion/logging/entry/IAlEntry;", "Lkotlin/ParameterName;", "name", "entry", "invoke"}, k = 3, mv = {1, 1, 15})
    /* renamed from: com.allegion.logging.AlLog$addDebugLoggers$1, reason: invalid class name */
    static final /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<IAlEntry, Unit> {
        AnonymousClass1(AlDebugEntryLogger alDebugEntryLogger) {
            super(1, alDebugEntryLogger);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "writeEntry";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AlDebugEntryLogger.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "writeEntry(Lcom/allegion/logging/entry/IAlEntry;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IAlEntry iAlEntry) {
            invoke2(iAlEntry);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull IAlEntry p1) {
            Intrinsics.checkParameterIsNotNull(p1, "p1");
            AlDebugEntryLogger.writeEntry(p1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "e", "invoke"}, k = 3, mv = {1, 1, 15})
    /* renamed from: com.allegion.logging.AlLog$addDebugLoggers$2, reason: invalid class name */
    static final /* synthetic */ class AnonymousClass2 extends FunctionReference implements Function1<Throwable, Unit> {
        AnonymousClass2(AlLog alLog) {
            super(1, alLog);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "onUnexpectedError";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AlLog.class);
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
            ((AlLog) this.receiver).onUnexpectedError(th);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/allegion/logging/entry/IAlEntry;", "Lkotlin/ParameterName;", "name", "entry", "invoke"}, k = 3, mv = {1, 1, 15})
    /* renamed from: com.allegion.logging.AlLog$addDebugLoggers$3, reason: invalid class name */
    static final /* synthetic */ class AnonymousClass3 extends FunctionReference implements Function1<IAlEntry, Unit> {
        AnonymousClass3(AlDebugEventLogger alDebugEventLogger) {
            super(1, alDebugEventLogger);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "writeEntry";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AlDebugEventLogger.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "writeEntry$AlLogging_release(Lcom/allegion/logging/entry/IAlEntry;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IAlEntry iAlEntry) {
            invoke2(iAlEntry);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull IAlEntry p1) {
            Intrinsics.checkParameterIsNotNull(p1, "p1");
            AlDebugEventLogger.writeEntry$AlLogging_release(p1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "e", "invoke"}, k = 3, mv = {1, 1, 15})
    /* renamed from: com.allegion.logging.AlLog$addDebugLoggers$4, reason: invalid class name */
    static final /* synthetic */ class AnonymousClass4 extends FunctionReference implements Function1<Throwable, Unit> {
        AnonymousClass4(AlLog alLog) {
            super(1, alLog);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "onUnexpectedError";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AlLog.class);
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
            ((AlLog) this.receiver).onUnexpectedError(th);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/allegion/logging/entry/IAlEntry;", "Lkotlin/ParameterName;", "name", "entry", "invoke"}, k = 3, mv = {1, 1, 15})
    /* renamed from: com.allegion.logging.AlLog$addDebugLoggers$5, reason: invalid class name */
    static final /* synthetic */ class AnonymousClass5 extends FunctionReference implements Function1<IAlEntry, Unit> {
        AnonymousClass5(AlTimberEntryLogger alTimberEntryLogger) {
            super(1, alTimberEntryLogger);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "writeEntry";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AlTimberEntryLogger.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "writeEntry(Lcom/allegion/logging/entry/IAlEntry;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IAlEntry iAlEntry) {
            invoke2(iAlEntry);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull IAlEntry p1) {
            Intrinsics.checkParameterIsNotNull(p1, "p1");
            AlTimberEntryLogger.writeEntry(p1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "e", "invoke"}, k = 3, mv = {1, 1, 15})
    /* renamed from: com.allegion.logging.AlLog$addDebugLoggers$6, reason: invalid class name */
    static final /* synthetic */ class AnonymousClass6 extends FunctionReference implements Function1<Throwable, Unit> {
        AnonymousClass6(AlLog alLog) {
            super(1, alLog);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "onUnexpectedError";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AlLog.class);
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
            ((AlLog) this.receiver).onUnexpectedError(th);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/allegion/logging/entry/IAlEntry;", "Lkotlin/ParameterName;", "name", "entry", "invoke"}, k = 3, mv = {1, 1, 15})
    /* renamed from: com.allegion.logging.AlLog$addDebugLoggers$7, reason: invalid class name */
    static final /* synthetic */ class AnonymousClass7 extends FunctionReference implements Function1<IAlEntry, Unit> {
        AnonymousClass7(AlTimberEventLogger alTimberEventLogger) {
            super(1, alTimberEventLogger);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "writeEntry";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AlTimberEventLogger.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "writeEntry$AlLogging_release(Lcom/allegion/logging/entry/IAlEntry;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IAlEntry iAlEntry) {
            invoke2(iAlEntry);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull IAlEntry p1) {
            Intrinsics.checkParameterIsNotNull(p1, "p1");
            AlTimberEventLogger.writeEntry$AlLogging_release(p1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "e", "invoke"}, k = 3, mv = {1, 1, 15})
    /* renamed from: com.allegion.logging.AlLog$addDebugLoggers$8, reason: invalid class name */
    static final /* synthetic */ class AnonymousClass8 extends FunctionReference implements Function1<Throwable, Unit> {
        AnonymousClass8(AlLog alLog) {
            super(1, alLog);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "onUnexpectedError";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AlLog.class);
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
            ((AlLog) this.receiver).onUnexpectedError(th);
        }
    }

    static {
        addDebugLoggers();
    }

    private AlLog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"LogNotTimber"})
    public final void onUnexpectedError(Throwable e) {
        Log.e("AlLog", "Unexpected Error", e);
    }

    @JvmStatic
    public static final void addDebugLoggers() {
        clearDebugLoggers();
        if (Timber.forest().isEmpty()) {
            CompositeDisposable compositeDisposable = subscriptions;
            Observable<IAlEntry> entries = AlLogging.getEntries();
            final AnonymousClass1 anonymousClass1 = new AnonymousClass1(AlDebugEntryLogger.INSTANCE);
            Consumer<? super IAlEntry> consumer = new Consumer() { // from class: com.allegion.logging.AlLog$sam$io_reactivex_functions_Consumer$0
                @Override // io.reactivex.functions.Consumer
                public final /* synthetic */ void accept(Object obj) {
                    Intrinsics.checkExpressionValueIsNotNull(anonymousClass1.invoke(obj), "invoke(...)");
                }
            };
            AlLog alLog = INSTANCE;
            final AnonymousClass2 anonymousClass2 = new AnonymousClass2(alLog);
            compositeDisposable.add(entries.subscribe(consumer, new Consumer() { // from class: com.allegion.logging.AlLog$sam$io_reactivex_functions_Consumer$0
                @Override // io.reactivex.functions.Consumer
                public final /* synthetic */ void accept(Object obj) {
                    Intrinsics.checkExpressionValueIsNotNull(anonymousClass2.invoke(obj), "invoke(...)");
                }
            }));
            Observable<IAlEntry> entries2 = AlLogging.getEntries();
            final AnonymousClass3 anonymousClass3 = new AnonymousClass3(AlDebugEventLogger.INSTANCE);
            Consumer<? super IAlEntry> consumer2 = new Consumer() { // from class: com.allegion.logging.AlLog$sam$io_reactivex_functions_Consumer$0
                @Override // io.reactivex.functions.Consumer
                public final /* synthetic */ void accept(Object obj) {
                    Intrinsics.checkExpressionValueIsNotNull(anonymousClass3.invoke(obj), "invoke(...)");
                }
            };
            final AnonymousClass4 anonymousClass4 = new AnonymousClass4(alLog);
            compositeDisposable.add(entries2.subscribe(consumer2, new Consumer() { // from class: com.allegion.logging.AlLog$sam$io_reactivex_functions_Consumer$0
                @Override // io.reactivex.functions.Consumer
                public final /* synthetic */ void accept(Object obj) {
                    Intrinsics.checkExpressionValueIsNotNull(anonymousClass4.invoke(obj), "invoke(...)");
                }
            }));
            return;
        }
        CompositeDisposable compositeDisposable2 = subscriptions;
        Observable<IAlEntry> entries3 = AlLogging.getEntries();
        final AnonymousClass5 anonymousClass5 = new AnonymousClass5(AlTimberEntryLogger.INSTANCE);
        Consumer<? super IAlEntry> consumer3 = new Consumer() { // from class: com.allegion.logging.AlLog$sam$io_reactivex_functions_Consumer$0
            @Override // io.reactivex.functions.Consumer
            public final /* synthetic */ void accept(Object obj) {
                Intrinsics.checkExpressionValueIsNotNull(anonymousClass5.invoke(obj), "invoke(...)");
            }
        };
        AlLog alLog2 = INSTANCE;
        final AnonymousClass6 anonymousClass6 = new AnonymousClass6(alLog2);
        compositeDisposable2.add(entries3.subscribe(consumer3, new Consumer() { // from class: com.allegion.logging.AlLog$sam$io_reactivex_functions_Consumer$0
            @Override // io.reactivex.functions.Consumer
            public final /* synthetic */ void accept(Object obj) {
                Intrinsics.checkExpressionValueIsNotNull(anonymousClass6.invoke(obj), "invoke(...)");
            }
        }));
        Observable<IAlEntry> entries4 = AlLogging.getEntries();
        final AnonymousClass7 anonymousClass7 = new AnonymousClass7(AlTimberEventLogger.INSTANCE);
        Consumer<? super IAlEntry> consumer4 = new Consumer() { // from class: com.allegion.logging.AlLog$sam$io_reactivex_functions_Consumer$0
            @Override // io.reactivex.functions.Consumer
            public final /* synthetic */ void accept(Object obj) {
                Intrinsics.checkExpressionValueIsNotNull(anonymousClass7.invoke(obj), "invoke(...)");
            }
        };
        final AnonymousClass8 anonymousClass8 = new AnonymousClass8(alLog2);
        compositeDisposable2.add(entries4.subscribe(consumer4, new Consumer() { // from class: com.allegion.logging.AlLog$sam$io_reactivex_functions_Consumer$0
            @Override // io.reactivex.functions.Consumer
            public final /* synthetic */ void accept(Object obj) {
                Intrinsics.checkExpressionValueIsNotNull(anonymousClass8.invoke(obj), "invoke(...)");
            }
        }));
    }

    @JvmStatic
    public static final void clearDebugLoggers() {
        subscriptions.clear();
    }

    private final Pair<String, String> getCategoryAndAction() {
        Throwable stack = new Throwable().fillInStackTrace();
        Intrinsics.checkExpressionValueIsNotNull(stack, "stack");
        StackTraceElement[] stackTrace = stack.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        StackTraceElement stackTraceElement = stackTrace[3];
        Intrinsics.checkExpressionValueIsNotNull(stackTraceElement, "trace[3]");
        String className = stackTraceElement.getClassName();
        Intrinsics.checkExpressionValueIsNotNull(className, "trace[3].className");
        StackTraceElement stackTraceElement2 = stackTrace[3];
        Intrinsics.checkExpressionValueIsNotNull(stackTraceElement2, "trace[3]");
        String className2 = stackTraceElement2.getClassName();
        Intrinsics.checkExpressionValueIsNotNull(className2, "trace[3].className");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) className2, InstructionFileId.DOT, 0, false, 6, (Object) null) + 1;
        if (className == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = className.substring(iLastIndexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        sb.append(GherkinLanguageConstants.TAG_PREFIX);
        StackTraceElement stackTraceElement3 = stackTrace[3];
        Intrinsics.checkExpressionValueIsNotNull(stackTraceElement3, "trace[3]");
        sb.append(stackTraceElement3.getLineNumber());
        sb.append("]");
        String string = sb.toString();
        StackTraceElement stackTraceElement4 = stackTrace[3];
        Intrinsics.checkExpressionValueIsNotNull(stackTraceElement4, "trace[3]");
        return new Pair<>(string, stackTraceElement4.getMethodName());
    }

    private final AlLogEntry createLogEntry(AlLoggingLevel level, String message, Object... args) {
        Pair<String, String> categoryAndAction = getCategoryAndAction();
        return new AlLogEntry(level, categoryAndAction.component1(), categoryAndAction.component2(), message, Arrays.copyOf(args, args.length));
    }

    private final AlExceptionLogEntry createLogEntry(AlLoggingLevel level, Throwable exception, String message, Object... args) {
        Pair<String, String> categoryAndAction = getCategoryAndAction();
        return new AlExceptionLogEntry(level, categoryAndAction.component1(), categoryAndAction.component2(), exception, message, Arrays.copyOf(args, args.length));
    }

    private final AlExceptionEntry createLogEntry(AlLoggingLevel level, Throwable exception) {
        Pair<String, String> categoryAndAction = getCategoryAndAction();
        return new AlExceptionEntry(level, categoryAndAction.component1(), categoryAndAction.component2(), exception);
    }

    @JvmStatic
    public static final void d(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.DEBUG, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void d(@Nullable Throwable exception, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.DEBUG, exception, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void d(@Nullable Throwable exception) {
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.DEBUG, exception));
    }

    @JvmStatic
    public static final void i(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.INFO, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void i(@Nullable Throwable exception, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.INFO, exception, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void i(@Nullable Throwable exception) {
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.INFO, exception));
    }

    @JvmStatic
    public static final void v(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.VERBOSE, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void v(@Nullable Throwable exception, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.VERBOSE, exception, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void v(@Nullable Throwable exception) {
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.VERBOSE, exception));
    }

    @JvmStatic
    public static final void w(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.WARNING, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void w(@Nullable Throwable exception, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.WARNING, exception, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void w(@Nullable Throwable exception) {
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.WARNING, exception));
    }

    @JvmStatic
    public static final void e(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.ERROR, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void e(@Nullable Throwable exception, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.ERROR, exception, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void e(@Nullable Throwable exception) {
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.ERROR, exception));
    }

    @JvmStatic
    public static final void a(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.ASSERT, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void a(@Nullable Throwable exception, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.ASSERT, exception, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void a(@Nullable Throwable exception) {
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.ASSERT, exception));
    }

    @JvmStatic
    public static final void wtf(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.ASSERT, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void wtf(@Nullable Throwable exception, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.ASSERT, exception, message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void wtf(@Nullable Throwable exception) {
        AlLogging.publish(INSTANCE.createLogEntry(AlLoggingLevel.ASSERT, exception));
    }

    @SafeVarargs
    @JvmStatic
    public static final void trackEvent(@NotNull AlActionType type, @NotNull String category, @NotNull String action, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(new AlActionEvent(type, category, action, Arrays.copyOf(args, args.length)));
    }

    @SafeVarargs
    @JvmStatic
    public static final void trackEvent(@NotNull AlEventType type, @NotNull String category, @NotNull String action, @NotNull androidx.core.util.Pair<String, Object>... args) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(args, "args");
        AlLogging.publish(new AlCustomEvent(type, category, action, (androidx.core.util.Pair[]) Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void trackEvent(@NotNull AlEventType type, @NotNull String category, @NotNull String action, @NotNull Map<String, ? extends Object> args) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(args, "args");
        List<Pair> list = MapsKt.toList(args);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Pair pair : list) {
            arrayList.add(androidx.core.util.Pair.create(pair.getFirst(), pair.getSecond()));
        }
        Object[] array = arrayList.toArray(new androidx.core.util.Pair[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        androidx.core.util.Pair[] pairArr = (androidx.core.util.Pair[]) array;
        AlLogging.publish(new AlCustomEvent(type, category, action, (androidx.core.util.Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
    }

    @SafeVarargs
    @JvmStatic
    public static final void trackScreen(@NotNull String screenName, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(screenName, "screenName");
        Intrinsics.checkParameterIsNotNull(args, "args");
        trackEvent(AlActionType.INFO, "Screen", screenName, Arrays.copyOf(args, args.length));
    }
}
