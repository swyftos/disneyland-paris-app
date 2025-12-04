package com.allegion.analytics.tracker;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.StringRes;
import com.allegion.analytics.config.AlAppCenterAnalyticsConfig;
import com.allegion.analytics.config.IAlAppCenterAnalyticsConfig;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JU\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b22\u0010\n\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\f0\u000b\"\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\fH\u0016¢\u0006\u0002\u0010\u000fJQ\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r22\u0010\n\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\f0\u000b\"\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\fH\u0016¢\u0006\u0002\u0010\u0010JQ\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b22\u0010\n\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\f0\u000b\"\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\fH\u0016¢\u0006\u0002\u0010\u000fJQ\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r22\u0010\n\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\f0\u000b\"\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\fH\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\rH\u0016JQ\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b22\u0010\n\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\f0\u000b\"\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\fH\u0016¢\u0006\u0002\u0010\u000fJQ\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r22\u0010\n\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\f0\u000b\"\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\fH\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/allegion/analytics/tracker/AlLoggingEventTracker;", "Lcom/allegion/analytics/tracker/IAlEventTracker;", "config", "Lcom/allegion/analytics/config/IAlAppCenterAnalyticsConfig;", "(Lcom/allegion/analytics/config/IAlAppCenterAnalyticsConfig;)V", "event", "", "category", "", "action", "args", "", "Landroid/util/Pair;", "", "", "(II[Landroid/util/Pair;)V", "(Ljava/lang/String;Ljava/lang/String;[Landroid/util/Pair;)V", "failureEvent", "screenName", "successEvent", "Companion", "Analytics_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public class AlLoggingEventTracker implements IAlEventTracker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LOGGING_CATEGORY_SCREEN = "Screen";
    private static final String LOGGING_PROPERTY_DELIMETER = " ";
    private static final String LOGGING_PROPERTY_SUCCESSFUL = "Successful";
    private static final String LOGGING_PROPERTY_SUCCESSFUL_FALSE = "False";
    private static final String LOGGING_PROPERTY_SUCCESSFUL_TRUE = "True";
    private final IAlAppCenterAnalyticsConfig config;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/allegion/analytics/tracker/AlLoggingEventTracker$Companion;", "", "()V", "LOGGING_CATEGORY_SCREEN", "", "LOGGING_PROPERTY_DELIMETER", "LOGGING_PROPERTY_SUCCESSFUL", "LOGGING_PROPERTY_SUCCESSFUL_FALSE", "LOGGING_PROPERTY_SUCCESSFUL_TRUE", "instance", "Lcom/allegion/analytics/tracker/AlLoggingEventTracker;", "config", "Lcom/allegion/analytics/config/AlAppCenterAnalyticsConfig;", "Lcom/allegion/analytics/config/IAlAppCenterAnalyticsConfig;", "instance$Analytics_release", "Analytics_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AlLoggingEventTracker instance(@NotNull AlAppCenterAnalyticsConfig config) {
            Intrinsics.checkParameterIsNotNull(config, "config");
            return new AlLoggingEventTracker(config, null);
        }

        @NotNull
        public final AlLoggingEventTracker instance$Analytics_release(@NotNull IAlAppCenterAnalyticsConfig config) {
            Intrinsics.checkParameterIsNotNull(config, "config");
            return new AlLoggingEventTracker(config, null);
        }
    }

    private AlLoggingEventTracker(IAlAppCenterAnalyticsConfig iAlAppCenterAnalyticsConfig) {
        this.config = iAlAppCenterAnalyticsConfig;
    }

    public /* synthetic */ AlLoggingEventTracker(IAlAppCenterAnalyticsConfig iAlAppCenterAnalyticsConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(iAlAppCenterAnalyticsConfig);
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void screenName(@NotNull String screenName) {
        Intrinsics.checkParameterIsNotNull(screenName, "screenName");
        if (Timber.forest().isEmpty()) {
            Log.e("AlAnalytics", "TIMBER NOT PLANTED, ANALYTICS CANNOT BE LOGGED");
            return;
        }
        Timber.d("Debug AlAnalytics :: Screen " + screenName, new Object[0]);
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void successEvent(int category, int action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(new Pair("Successful", "True"));
        spreadBuilder.addSpread(args);
        event(category, action, (Pair<String, ? extends Object>[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void successEvent(@NotNull String category, @NotNull String action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(args, "args");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(new Pair("Successful", "True"));
        spreadBuilder.addSpread(args);
        event(category, action, (Pair<String, ? extends Object>[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void failureEvent(int category, int action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(new Pair("Successful", "False"));
        spreadBuilder.addSpread(args);
        event(category, action, (Pair<String, ? extends Object>[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void failureEvent(@NotNull String category, @NotNull String action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(args, "args");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(new Pair("Successful", "False"));
        spreadBuilder.addSpread(args);
        event(category, action, (Pair<String, ? extends Object>[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void event(@StringRes int category, @StringRes int action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        String string = this.config.getApplication().getApplicationContext().getString(category);
        Intrinsics.checkExpressionValueIsNotNull(string, "config.application.appli…ntext.getString(category)");
        String string2 = this.config.getApplication().getApplicationContext().getString(action);
        Intrinsics.checkExpressionValueIsNotNull(string2, "config.application.appli…Context.getString(action)");
        event(string, string2, (Pair<String, ? extends Object>[]) Arrays.copyOf(args, args.length));
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void event(@NotNull String category, @NotNull String action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(args, "args");
        if (Timber.forest().isEmpty()) {
            Log.e("AlAnalytics", "TIMBER NOT PLANTED, ANALYTICS CANNOT BE LOGGED");
            return;
        }
        HashMap map = new HashMap();
        for (Pair<String, ? extends Object> pair : args) {
            map.put(pair.first, String.valueOf(pair.second));
        }
        Timber.d("Debug AlAnalytics :: " + category + ' ' + action + " properties: " + map, new Object[0]);
    }
}
