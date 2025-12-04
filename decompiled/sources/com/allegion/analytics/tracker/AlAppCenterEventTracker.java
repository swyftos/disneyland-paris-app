package com.allegion.analytics.tracker;

import android.util.Pair;
import androidx.annotation.StringRes;
import com.allegion.analytics.config.AlAppCenterAnalyticsConfig;
import com.allegion.analytics.config.IAlAppCenterAnalyticsConfig;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JU\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b22\u0010\n\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\f0\u000b\"\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\fH\u0016¢\u0006\u0002\u0010\u000fJQ\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r22\u0010\n\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\f0\u000b\"\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\fH\u0016¢\u0006\u0002\u0010\u0010JQ\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b22\u0010\n\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\f0\u000b\"\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\fH\u0016¢\u0006\u0002\u0010\u000fJQ\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r22\u0010\n\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\f0\u000b\"\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\fH\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\rH\u0016JQ\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b22\u0010\n\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\f0\u000b\"\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\fH\u0016¢\u0006\u0002\u0010\u000fJQ\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r22\u0010\n\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\f0\u000b\"\u0012\u0012\u0004\u0012\u00020\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\fH\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/allegion/analytics/tracker/AlAppCenterEventTracker;", "Lcom/allegion/analytics/tracker/IAlEventTracker;", "config", "Lcom/allegion/analytics/config/IAlAppCenterAnalyticsConfig;", "(Lcom/allegion/analytics/config/IAlAppCenterAnalyticsConfig;)V", "event", "", "category", "", "action", "args", "", "Landroid/util/Pair;", "", "", "(II[Landroid/util/Pair;)V", "(Ljava/lang/String;Ljava/lang/String;[Landroid/util/Pair;)V", "failureEvent", "screenName", "successEvent", "Companion", "Analytics_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public class AlAppCenterEventTracker implements IAlEventTracker {

    @NotNull
    public static final String APPCENTER_CATEGORY_SCREEN = "Screen";

    @NotNull
    public static final String APPCENTER_PROPERTY_DELIMETER = " ";

    @NotNull
    public static final String APPCENTER_PROPERTY_SUCCESSFUL = "Successful";

    @NotNull
    public static final String APPCENTER_PROPERTY_SUCCESSFUL_FALSE = "False";

    @NotNull
    public static final String APPCENTER_PROPERTY_SUCCESSFUL_TRUE = "True";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final IAlAppCenterAnalyticsConfig config;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/allegion/analytics/tracker/AlAppCenterEventTracker$Companion;", "", "()V", "APPCENTER_CATEGORY_SCREEN", "", "APPCENTER_PROPERTY_DELIMETER", "APPCENTER_PROPERTY_SUCCESSFUL", "APPCENTER_PROPERTY_SUCCESSFUL_FALSE", "APPCENTER_PROPERTY_SUCCESSFUL_TRUE", "instance", "Lcom/allegion/analytics/tracker/AlAppCenterEventTracker;", "config", "Lcom/allegion/analytics/config/AlAppCenterAnalyticsConfig;", "Lcom/allegion/analytics/config/IAlAppCenterAnalyticsConfig;", "instance$Analytics_release", "Analytics_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AlAppCenterEventTracker instance(@NotNull AlAppCenterAnalyticsConfig config) {
            Intrinsics.checkParameterIsNotNull(config, "config");
            return new AlAppCenterEventTracker(config, null);
        }

        @NotNull
        public final AlAppCenterEventTracker instance$Analytics_release(@NotNull IAlAppCenterAnalyticsConfig config) {
            Intrinsics.checkParameterIsNotNull(config, "config");
            return new AlAppCenterEventTracker(config, null);
        }
    }

    private AlAppCenterEventTracker(IAlAppCenterAnalyticsConfig iAlAppCenterAnalyticsConfig) {
        this.config = iAlAppCenterAnalyticsConfig;
        if (iAlAppCenterAnalyticsConfig.getTrackCrashes()) {
            AppCenter.start(iAlAppCenterAnalyticsConfig.getApplication(), iAlAppCenterAnalyticsConfig.getAppSecretKey(), Analytics.class, Crashes.class);
        } else {
            AppCenter.start(iAlAppCenterAnalyticsConfig.getApplication(), iAlAppCenterAnalyticsConfig.getAppSecretKey(), Analytics.class);
        }
        Analytics.setEnabled(true);
    }

    public /* synthetic */ AlAppCenterEventTracker(IAlAppCenterAnalyticsConfig iAlAppCenterAnalyticsConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(iAlAppCenterAnalyticsConfig);
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void screenName(@NotNull String screenName) {
        Intrinsics.checkParameterIsNotNull(screenName, "screenName");
        Analytics.trackEvent("Screen " + screenName);
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void successEvent(int category, int action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(new Pair(APPCENTER_PROPERTY_SUCCESSFUL, APPCENTER_PROPERTY_SUCCESSFUL_TRUE));
        spreadBuilder.addSpread(args);
        event(category, action, (Pair<String, ? extends Object>[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void successEvent(@NotNull String category, @NotNull String action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(args, "args");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(new Pair(APPCENTER_PROPERTY_SUCCESSFUL, APPCENTER_PROPERTY_SUCCESSFUL_TRUE));
        spreadBuilder.addSpread(args);
        event(category, action, (Pair<String, ? extends Object>[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void failureEvent(int category, int action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(new Pair(APPCENTER_PROPERTY_SUCCESSFUL, APPCENTER_PROPERTY_SUCCESSFUL_FALSE));
        spreadBuilder.addSpread(args);
        event(category, action, (Pair<String, ? extends Object>[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void failureEvent(@NotNull String category, @NotNull String action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(args, "args");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(new Pair(APPCENTER_PROPERTY_SUCCESSFUL, APPCENTER_PROPERTY_SUCCESSFUL_FALSE));
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
        String str = category + ' ' + action;
        HashMap map = new HashMap();
        for (Pair<String, ? extends Object> pair : args) {
            map.put(pair.first, String.valueOf(pair.second));
        }
        Analytics.trackEvent(str, map);
    }
}
