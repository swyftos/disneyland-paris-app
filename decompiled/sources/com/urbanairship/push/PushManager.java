package com.urbanairship.push;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.annotation.XmlRes;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.AirshipComponent;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.AirshipExecutors;
import com.urbanairship.Predicate;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.PushProviders;
import com.urbanairship.R;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.app.SimpleApplicationListener;
import com.urbanairship.base.Supplier;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.channel.ChannelRegistrationPayload;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.job.JobDispatcher;
import com.urbanairship.job.JobInfo;
import com.urbanairship.job.JobResult;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonValue;
import com.urbanairship.permission.OnPermissionStatusChangedListener;
import com.urbanairship.permission.Permission;
import com.urbanairship.permission.PermissionPromptFallback;
import com.urbanairship.permission.PermissionRequestResult;
import com.urbanairship.permission.PermissionStatus;
import com.urbanairship.permission.PermissionsManager;
import com.urbanairship.push.IncomingPushRunnable;
import com.urbanairship.push.PushProvider;
import com.urbanairship.push.notifications.AirshipNotificationProvider;
import com.urbanairship.push.notifications.NotificationActionButtonGroup;
import com.urbanairship.push.notifications.NotificationChannelRegistry;
import com.urbanairship.push.notifications.NotificationProvider;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¸\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 Â\u00012\u00020\u0001:\u0002Â\u0001BO\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013Bg\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020*H\u0007J\u0013\u0010\u0084\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020,H\u0007J\u001a\u0010\u0085\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u001d2\u0007\u0010\u0087\u0001\u001a\u00020\u001eJ\u001c\u0010\u0088\u0001\u001a\u00030\u0082\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0089\u0001\u001a\u00030\u008a\u0001J\u0012\u0010\u008b\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u008c\u0001J\u0011\u0010\u008d\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020,J\u0011\u0010\u008e\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020pJ\u0007\u0010\u008f\u0001\u001a\u00020.J\u0018\u0010\u0090\u0001\u001a\u00030\u0082\u00012\f\b\u0002\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001H\u0002J\n\u0010\u0093\u0001\u001a\u00030\u0082\u0001H\u0002J\u0018\u0010\u0094\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0095\u0001H\u0002J\n\u0010\u0096\u0001\u001a\u00030\u0082\u0001H\u0002J\u001a\u0010\u0097\u0001\u001a\u00030\u0082\u00012\u0010\u0010\u0098\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010.0\u0099\u0001J$\u0010\u0097\u0001\u001a\u00030\u0082\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0010\u0010\u0098\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010.0\u0099\u0001J\n\u0010\u009c\u0001\u001a\u00030\u008a\u0001H\u0017J\u0010\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020*0\u009e\u0001H\u0007J\u0014\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u001e2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001dJ\n\u0010 \u0001\u001a\u00030\u0082\u0001H\u0014J\u0012\u0010¡\u0001\u001a\u00020.2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u001dJ\u0014\u0010£\u0001\u001a\u00030\u0082\u00012\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0014J(\u0010¦\u0001\u001a\u00030\u0082\u00012\u0007\u0010§\u0001\u001a\u00020#2\b\u0010¨\u0001\u001a\u00030\u008a\u00012\t\u0010©\u0001\u001a\u0004\u0018\u00010\u001dH\u0007J\u001e\u0010ª\u0001\u001a\u00030«\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0017J\u001c\u0010®\u0001\u001a\u00030\u0082\u00012\u0007\u0010§\u0001\u001a\u00020#2\u0007\u0010¯\u0001\u001a\u00020.H\u0007J)\u0010°\u0001\u001a\u00030\u0082\u00012\u0014\u0010±\u0001\u001a\u000f\u0012\b\b\u0001\u0012\u0004\u0018\u00010e\u0018\u00010²\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u001dJ\u0011\u0010´\u0001\u001a\u00030«\u00012\u0007\u0010µ\u0001\u001a\u00020.J\u0013\u0010¶\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020*H\u0007J\u0011\u0010·\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u001dJ\u0012\u0010¸\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u008c\u0001J\u0011\u0010¹\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020,J\u0011\u0010º\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020pJ\u000b\u0010»\u0001\u001a\u0004\u0018\u00010eH\u0002J\u001c\u0010¼\u0001\u001a\u00030\u0082\u00012\u0007\u0010½\u0001\u001a\u00020s2\u0007\u0010¾\u0001\u001a\u00020sH\u0007J\t\u0010¿\u0001\u001a\u00020.H\u0002J\n\u0010À\u0001\u001a\u00030\u0082\u0001H\u0002J\b\u0010Á\u0001\u001a\u00030\u0082\u0001R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020.8FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b/\u00102R\u0011\u00103\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b3\u00102R\u0011\u00104\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b4\u00102R\u0011\u00105\u001a\u00020.8G¢\u0006\u0006\u001a\u0004\b5\u00102R\u0012\u00106\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0004\n\u0002\u00107R*\u00109\u001a\u00020.2\u0006\u00108\u001a\u00020.8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b:\u00101\u001a\u0004\b9\u00102\"\u0004\b;\u0010<R*\u0010=\u001a\u00020.2\u0006\u00108\u001a\u00020.8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b>\u00101\u001a\u0004\b=\u00102\"\u0004\b?\u0010<R*\u0010@\u001a\u00020.2\u0006\u00108\u001a\u00020.8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\bA\u00101\u001a\u0004\b@\u00102\"\u0004\bB\u0010<R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010D\u001a\u0004\u0018\u00010\u001d2\b\u0010C\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010O\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010U\u001a\u0004\u0018\u00010VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0014\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020,0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010`\u001a\u00020a8F¢\u0006\u0006\u001a\u0004\bb\u0010cR$\u0010f\u001a\u0004\u0018\u00010e2\b\u0010d\u001a\u0004\u0018\u00010e8G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0011\u0010i\u001a\u00020j8F¢\u0006\u0006\u001a\u0004\bk\u0010lR\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010m\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\bn\u0010FR\u0014\u0010o\u001a\b\u0012\u0004\u0012\u00020p0)X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010q\u001a\n\u0012\u0004\u0012\u00020s\u0018\u00010r8FX\u0087\u0004¢\u0006\f\u0012\u0004\bt\u00101\u001a\u0004\bu\u0010vR\u000e\u0010w\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010x\u001a\u00020yX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u000e\u0010|\u001a\u00020}X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010~\u001a\u00020.2\u0006\u00108\u001a\u00020.8F@FX\u0086\u000e¢\u0006\r\u001a\u0004\b\u007f\u00102\"\u0005\b\u0080\u0001\u0010<¨\u0006Ã\u0001"}, d2 = {"Lcom/urbanairship/push/PushManager;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "preferenceDataStore", "Lcom/urbanairship/PreferenceDataStore;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "pushProvidersSupplier", "Lcom/urbanairship/base/Supplier;", "Lcom/urbanairship/PushProviders;", "airshipChannel", "Lcom/urbanairship/channel/AirshipChannel;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/analytics/Analytics;", "permissionsManager", "Lcom/urbanairship/permission/PermissionsManager;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/base/Supplier;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/analytics/Analytics;Lcom/urbanairship/permission/PermissionsManager;)V", "jobDispatcher", "Lcom/urbanairship/job/JobDispatcher;", "notificationManager", "Lcom/urbanairship/push/AirshipNotificationManager;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/base/Supplier;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/analytics/Analytics;Lcom/urbanairship/permission/PermissionsManager;Lcom/urbanairship/job/JobDispatcher;Lcom/urbanairship/push/AirshipNotificationManager;Lcom/urbanairship/app/ActivityMonitor;)V", "actionGroupMap", "", "", "Lcom/urbanairship/push/notifications/NotificationActionButtonGroup;", "channelExtender", "Lcom/urbanairship/channel/AirshipChannel$Extender;", "foregroundNotificationDisplayPredicate", "Lcom/urbanairship/Predicate;", "Lcom/urbanairship/push/PushMessage;", "getForegroundNotificationDisplayPredicate", "()Lcom/urbanairship/Predicate;", "setForegroundNotificationDisplayPredicate", "(Lcom/urbanairship/Predicate;)V", "internalNotificationListeners", "", "Lcom/urbanairship/push/InternalNotificationListener;", "internalPushListeners", "Lcom/urbanairship/push/PushListener;", "isAirshipReady", "", "isInQuietTime", "isInQuietTime$annotations", "()V", "()Z", "isOptIn", "isPushAvailable", "isPushEnabled", "isPushManagerEnabled", "Ljava/lang/Boolean;", "enabled", "isQuietTimeEnabled", "isQuietTimeEnabled$annotations", "setQuietTimeEnabled", "(Z)V", "isSoundEnabled", "isSoundEnabled$annotations", "setSoundEnabled", "isVibrateEnabled", "isVibrateEnabled$annotations", "setVibrateEnabled", "sendMetadata", "lastReceivedMetadata", "getLastReceivedMetadata", "()Ljava/lang/String;", "setLastReceivedMetadata", "(Ljava/lang/String;)V", "notificationChannelRegistry", "Lcom/urbanairship/push/notifications/NotificationChannelRegistry;", "getNotificationChannelRegistry", "()Lcom/urbanairship/push/notifications/NotificationChannelRegistry;", "setNotificationChannelRegistry", "(Lcom/urbanairship/push/notifications/NotificationChannelRegistry;)V", "notificationListener", "Lcom/urbanairship/push/NotificationListener;", "getNotificationListener", "()Lcom/urbanairship/push/NotificationListener;", "setNotificationListener", "(Lcom/urbanairship/push/NotificationListener;)V", "notificationProvider", "Lcom/urbanairship/push/notifications/NotificationProvider;", "getNotificationProvider", "()Lcom/urbanairship/push/notifications/NotificationProvider;", "setNotificationProvider", "(Lcom/urbanairship/push/notifications/NotificationProvider;)V", "getPermissionsManager$urbanairship_core_release", "()Lcom/urbanairship/permission/PermissionsManager;", "getPreferenceDataStore$urbanairship_core_release", "()Lcom/urbanairship/PreferenceDataStore;", "pushListeners", "pushNotificationStatus", "Lcom/urbanairship/push/PushNotificationStatus;", "getPushNotificationStatus", "()Lcom/urbanairship/push/PushNotificationStatus;", "<set-?>", "Lcom/urbanairship/push/PushProvider;", "pushProvider", "getPushProvider", "()Lcom/urbanairship/push/PushProvider;", "pushProviderType", "Lcom/urbanairship/push/PushProviderType;", "getPushProviderType", "()Lcom/urbanairship/push/PushProviderType;", "pushToken", "getPushToken", "pushTokenListeners", "Lcom/urbanairship/push/PushTokenListener;", "quietTimeInterval", "", "Ljava/util/Date;", "getQuietTimeInterval$annotations", "getQuietTimeInterval", "()[Ljava/util/Date;", "shouldDispatchUpdateTokenJob", "statusObserver", "Lcom/urbanairship/push/PushNotificationStatusObserver;", "getStatusObserver$urbanairship_core_release", "()Lcom/urbanairship/push/PushNotificationStatusObserver;", "uniqueIdLock", "", "userNotificationsEnabled", "getUserNotificationsEnabled", "setUserNotificationsEnabled", "addInternalNotificationListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addInternalPushListener", "addNotificationActionButtonGroup", "id", "group", "addNotificationActionButtonGroups", "resId", "", "addNotificationStatusListener", "Lcom/urbanairship/push/PushNotificationStatusListener;", "addPushListener", "addPushTokenListener", "areNotificationsOptedIn", "checkPermission", "onCheckComplete", "Ljava/lang/Runnable;", "clearPushToken", "createAnalyticsHeaders", "", "dispatchUpdateJob", "enableUserNotifications", "consumer", "Landroidx/core/util/Consumer;", "promptFallback", "Lcom/urbanairship/permission/PermissionPromptFallback;", "getComponentGroup", "getInternalNotificationListeners", "", "getNotificationActionGroup", "init", "isUniqueCanonicalId", "canonicalId", "onAirshipReady", "airship", "Lcom/urbanairship/UAirship;", "onNotificationPosted", "message", "notificationId", "notificationTag", "onPerformJob", "Lcom/urbanairship/job/JobResult;", "jobInfo", "Lcom/urbanairship/job/JobInfo;", "onPushReceived", "notificationPosted", "onTokenChanged", "pushProviderClass", "Ljava/lang/Class;", "token", "performPushRegistration", "updateChannelOnChange", "removeInternalNotificationListener", "removeNotificationActionButtonGroup", "removeNotificationStatusListener", "removePushListener", "removePushTokenListener", "resolvePushProvider", "setQuietTimeInterval", "startTime", "endTime", "shouldRequestNotificationPermission", "updateManagerEnablement", "updateStatusObserver", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class PushManager extends AirshipComponent {

    @NotNull
    public static final String ACTION_DISPLAY_NOTIFICATION = "ACTION_DISPLAY_NOTIFICATION";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final String ACTION_NOTIFICATION_DISMISSED = "com.urbanairship.push.ACTION_NOTIFICATION_DISMISSED";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final String ACTION_NOTIFICATION_RESPONSE = "com.urbanairship.push.ACTION_NOTIFICATION_RESPONSE";

    @NotNull
    public static final String ACTION_UPDATE_PUSH_REGISTRATION = "ACTION_UPDATE_PUSH_REGISTRATION";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final String EXTRA_NOTIFICATION_ACTION_BUTTON_DESCRIPTION = "com.urbanairship.push.EXTRA_NOTIFICATION_ACTION_BUTTON_DESCRIPTION";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final String EXTRA_NOTIFICATION_BUTTON_ACTIONS_PAYLOAD = "com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ACTIONS_PAYLOAD";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final String EXTRA_NOTIFICATION_BUTTON_FOREGROUND = "com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_FOREGROUND";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final String EXTRA_NOTIFICATION_BUTTON_ID = "com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ID";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final String EXTRA_NOTIFICATION_CONTENT_INTENT = "com.urbanairship.push.EXTRA_NOTIFICATION_CONTENT_INTENT";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final String EXTRA_NOTIFICATION_DELETE_INTENT = "com.urbanairship.push.EXTRA_NOTIFICATION_DELETE_INTENT";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final String EXTRA_NOTIFICATION_ID = "com.urbanairship.push.NOTIFICATION_ID";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final String EXTRA_NOTIFICATION_TAG = "com.urbanairship.push.NOTIFICATION_TAG";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final String EXTRA_PUSH_MESSAGE_BUNDLE = "com.urbanairship.push.EXTRA_PUSH_MESSAGE_BUNDLE";

    @NotNull
    public static final String PROVIDER_CLASS_KEY = "com.urbanairship.application.device.PUSH_PROVIDER";

    @NotNull
    public static final String PUSH_DELIVERY_TYPE = "com.urbanairship.push.PUSH_DELIVERY_TYPE";

    @NotNull
    public static final String PUSH_TOKEN_KEY = "com.urbanairship.push.REGISTRATION_TOKEN_KEY";

    @NotNull
    public static final String QUIET_TIME_ENABLED = "com.urbanairship.push.QUIET_TIME_ENABLED";

    @NotNull
    public static final String QUIET_TIME_INTERVAL = "com.urbanairship.push.QUIET_TIME_INTERVAL";

    @NotNull
    public static final String REQUEST_PERMISSION_KEY = "com.urbanairship.push.REQUEST_PERMISSION_KEY";

    @NotNull
    public static final String SOUND_ENABLED_KEY = "com.urbanairship.push.SOUND_ENABLED";

    @NotNull
    public static final String USER_NOTIFICATIONS_ENABLED_KEY = "com.urbanairship.push.USER_NOTIFICATIONS_ENABLED";

    @NotNull
    public static final String VIBRATE_ENABLED_KEY = "com.urbanairship.push.VIBRATE_ENABLED";
    private final Map actionGroupMap;
    private final ActivityMonitor activityMonitor;
    private final AirshipChannel airshipChannel;
    private final Analytics analytics;
    private final AirshipChannel.Extender channelExtender;
    private final AirshipRuntimeConfig config;
    private final Context context;
    private volatile Predicate foregroundNotificationDisplayPredicate;
    private final List internalNotificationListeners;
    private final List internalPushListeners;
    private volatile boolean isAirshipReady;
    private Boolean isPushManagerEnabled;
    private final JobDispatcher jobDispatcher;
    private NotificationChannelRegistry notificationChannelRegistry;
    private NotificationListener notificationListener;
    private final AirshipNotificationManager notificationManager;
    private NotificationProvider notificationProvider;
    private final PermissionsManager permissionsManager;
    private final PreferenceDataStore preferenceDataStore;
    private final PrivacyManager privacyManager;
    private final List pushListeners;
    private PushProvider pushProvider;
    private final Supplier pushProvidersSupplier;
    private final List pushTokenListeners;
    private volatile boolean shouldDispatchUpdateTokenJob;
    private final PushNotificationStatusObserver statusObserver;
    private final Object uniqueIdLock;

    @JvmField
    @NotNull
    public static final ExecutorService PUSH_EXECUTOR = AirshipExecutors.threadPoolExecutor();

    @Deprecated(message = "This setting does not work on Android O+. Applications are encouraged to\n      use `com.urbanairship.push.notifications.NotificationChannelCompat` instead.")
    public static /* synthetic */ void getQuietTimeInterval$annotations() {
    }

    @Deprecated(message = "This setting does not work on Android O+. Applications are encouraged to\n      use `com.urbanairship.push.notifications.NotificationChannelCompat` instead.")
    public static /* synthetic */ void isInQuietTime$annotations() {
    }

    @Deprecated(message = "This setting does not work on Android O+. Applications are encouraged to\n      use `com.urbanairship.push.notifications.NotificationChannelCompat` instead.")
    public static /* synthetic */ void isQuietTimeEnabled$annotations() {
    }

    @Deprecated(message = "This setting does not work on Android O+. Applications are encouraged to\n      use `com.urbanairship.push.notifications.NotificationChannelCompat` instead.")
    public static /* synthetic */ void isSoundEnabled$annotations() {
    }

    @Deprecated(message = "This setting does not work on Android O+. Applications are encouraged to\n      use `com.urbanairship.push.notifications.NotificationChannelCompat` instead.")
    public static /* synthetic */ void isVibrateEnabled$annotations() {
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getComponentGroup() {
        return 0;
    }

    @NotNull
    /* renamed from: getPreferenceDataStore$urbanairship_core_release, reason: from getter */
    public final PreferenceDataStore getPreferenceDataStore() {
        return this.preferenceDataStore;
    }

    @NotNull
    /* renamed from: getPermissionsManager$urbanairship_core_release, reason: from getter */
    public final PermissionsManager getPermissionsManager() {
        return this.permissionsManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public PushManager(@NotNull Context context, @NotNull PreferenceDataStore preferenceDataStore, @NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull Supplier<PushProviders> pushProvidersSupplier, @NotNull AirshipChannel airshipChannel, @NotNull Analytics analytics, @NotNull PermissionsManager permissionsManager, @NotNull JobDispatcher jobDispatcher, @NotNull AirshipNotificationManager notificationManager, @NotNull ActivityMonitor activityMonitor) {
        super(context, preferenceDataStore);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preferenceDataStore, "preferenceDataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(pushProvidersSupplier, "pushProvidersSupplier");
        Intrinsics.checkNotNullParameter(airshipChannel, "airshipChannel");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(permissionsManager, "permissionsManager");
        Intrinsics.checkNotNullParameter(jobDispatcher, "jobDispatcher");
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        this.context = context;
        this.preferenceDataStore = preferenceDataStore;
        this.config = config;
        this.privacyManager = privacyManager;
        this.pushProvidersSupplier = pushProvidersSupplier;
        this.airshipChannel = airshipChannel;
        this.analytics = analytics;
        this.permissionsManager = permissionsManager;
        this.jobDispatcher = jobDispatcher;
        this.notificationManager = notificationManager;
        this.activityMonitor = activityMonitor;
        this.notificationProvider = new AirshipNotificationProvider(context, config.getConfigOptions());
        HashMap map = new HashMap();
        this.actionGroupMap = map;
        this.notificationChannelRegistry = new NotificationChannelRegistry(context, config.getConfigOptions());
        this.pushTokenListeners = new CopyOnWriteArrayList();
        this.pushListeners = new CopyOnWriteArrayList();
        this.internalPushListeners = new CopyOnWriteArrayList();
        this.internalNotificationListeners = new CopyOnWriteArrayList();
        this.uniqueIdLock = new Object();
        this.shouldDispatchUpdateTokenJob = true;
        Map mapFromXml = ActionButtonGroupsParser.fromXml(context, R.xml.ua_notification_buttons);
        Intrinsics.checkNotNullExpressionValue(mapFromXml, "fromXml(...)");
        map.putAll(mapFromXml);
        Map mapFromXml2 = ActionButtonGroupsParser.fromXml(context, R.xml.ua_notification_button_overrides);
        Intrinsics.checkNotNullExpressionValue(mapFromXml2, "fromXml(...)");
        map.putAll(mapFromXml2);
        this.statusObserver = new PushNotificationStatusObserver(getPushNotificationStatus(), null, 2, 0 == true ? 1 : 0);
        this.channelExtender = new AirshipChannel.Extender.Blocking() { // from class: com.urbanairship.push.PushManager$channelExtender$1
            @Override // com.urbanairship.channel.AirshipChannel.Extender.Blocking
            @NotNull
            public ChannelRegistrationPayload.Builder extend(@NotNull ChannelRegistrationPayload.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                if (!this.this$0.privacyManager.isEnabled(PrivacyManager.Feature.PUSH)) {
                    return builder;
                }
                if (this.this$0.getPushToken() == null) {
                    this.this$0.performPushRegistration(false);
                }
                String pushToken = this.this$0.getPushToken();
                builder.setPushAddress(pushToken);
                PushProvider pushProvider = this.this$0.getPushProvider();
                if (pushToken != null && pushProvider != null && pushProvider.getPlatform() == 2) {
                    builder.setDeliveryType(pushProvider.getDeliveryType());
                }
                ChannelRegistrationPayload.Builder backgroundEnabled = builder.setOptIn(this.this$0.isOptIn()).setBackgroundEnabled(this.this$0.isPushAvailable());
                Intrinsics.checkNotNullExpressionValue(backgroundEnabled, "setBackgroundEnabled(...)");
                return backgroundEnabled;
            }
        };
    }

    @Nullable
    public final NotificationProvider getNotificationProvider() {
        return this.notificationProvider;
    }

    public final void setNotificationProvider(@Nullable NotificationProvider notificationProvider) {
        this.notificationProvider = notificationProvider;
    }

    @NotNull
    public final NotificationChannelRegistry getNotificationChannelRegistry() {
        return this.notificationChannelRegistry;
    }

    public final void setNotificationChannelRegistry(@NotNull NotificationChannelRegistry notificationChannelRegistry) {
        Intrinsics.checkNotNullParameter(notificationChannelRegistry, "<set-?>");
        this.notificationChannelRegistry = notificationChannelRegistry;
    }

    @Nullable
    public final NotificationListener getNotificationListener() {
        return this.notificationListener;
    }

    public final void setNotificationListener(@Nullable NotificationListener notificationListener) {
        this.notificationListener = notificationListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public final PushProvider getPushProvider() {
        return this.pushProvider;
    }

    @Nullable
    public final Predicate<PushMessage> getForegroundNotificationDisplayPredicate() {
        return this.foregroundNotificationDisplayPredicate;
    }

    public final void setForegroundNotificationDisplayPredicate(@Nullable Predicate<PushMessage> predicate) {
        this.foregroundNotificationDisplayPredicate = predicate;
    }

    @NotNull
    /* renamed from: getStatusObserver$urbanairship_core_release, reason: from getter */
    public final PushNotificationStatusObserver getStatusObserver() {
        return this.statusObserver;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PushManager(@NotNull Context context, @NotNull PreferenceDataStore preferenceDataStore, @NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull Supplier<PushProviders> pushProvidersSupplier, @NotNull AirshipChannel airshipChannel, @NotNull Analytics analytics, @NotNull PermissionsManager permissionsManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preferenceDataStore, "preferenceDataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(pushProvidersSupplier, "pushProvidersSupplier");
        Intrinsics.checkNotNullParameter(airshipChannel, "airshipChannel");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(permissionsManager, "permissionsManager");
        JobDispatcher jobDispatcherShared = JobDispatcher.shared(context);
        Intrinsics.checkNotNullExpressionValue(jobDispatcherShared, "shared(...)");
        AirshipNotificationManager airshipNotificationManagerFrom = AirshipNotificationManager.from(context);
        Intrinsics.checkNotNullExpressionValue(airshipNotificationManagerFrom, "from(...)");
        this(context, preferenceDataStore, config, privacyManager, pushProvidersSupplier, airshipChannel, analytics, permissionsManager, jobDispatcherShared, airshipNotificationManagerFrom, GlobalActivityMonitor.INSTANCE.shared(context));
    }

    @Override // com.urbanairship.AirshipComponent
    protected void init() {
        super.init();
        this.airshipChannel.addChannelRegistrationPayloadExtender(this.channelExtender);
        final Map mapCreateAnalyticsHeaders = createAnalyticsHeaders();
        this.analytics.addHeaderDelegate(new Analytics.AnalyticsHeaderDelegate() { // from class: com.urbanairship.push.PushManager.init.1
            @Override // com.urbanairship.analytics.Analytics.AnalyticsHeaderDelegate
            @NotNull
            public Map<String, String> onCreateAnalyticsHeaders() {
                return mapCreateAnalyticsHeaders;
            }
        });
        this.privacyManager.addListener(new PrivacyManager.Listener() { // from class: com.urbanairship.push.PushManager$$ExternalSyntheticLambda1
            @Override // com.urbanairship.PrivacyManager.Listener
            public final void onEnabledFeaturesChanged() {
                PushManager.init$lambda$0(this.f$0);
            }
        });
        this.permissionsManager.addAirshipEnabler(new Consumer() { // from class: com.urbanairship.push.PushManager$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                PushManager.init$lambda$1(this.f$0, (Permission) obj);
            }
        });
        this.permissionsManager.addOnPermissionStatusChangedListener(new OnPermissionStatusChangedListener() { // from class: com.urbanairship.push.PushManager$$ExternalSyntheticLambda3
            @Override // com.urbanairship.permission.OnPermissionStatusChangedListener
            public final void onPermissionStatusChanged(Permission permission, PermissionStatus permissionStatus) {
                PushManager.init$lambda$2(this.f$0, permission, permissionStatus);
            }
        });
        String str = this.config.getConfigOptions().notificationChannel;
        if (str == null) {
            str = NotificationProvider.DEFAULT_NOTIFICATION_CHANNEL;
        }
        this.permissionsManager.setPermissionDelegate(Permission.DISPLAY_NOTIFICATIONS, new NotificationsPermissionDelegate(str, this.preferenceDataStore, this.notificationManager, this.notificationChannelRegistry, this.activityMonitor));
        updateManagerEnablement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(PushManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateManagerEnablement();
        this$0.updateStatusObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(PushManager this$0, Permission permission) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (permission == Permission.DISPLAY_NOTIFICATIONS) {
            this$0.privacyManager.enable(PrivacyManager.Feature.PUSH);
            this$0.preferenceDataStore.put(USER_NOTIFICATIONS_ENABLED_KEY, true);
            this$0.airshipChannel.updateRegistration();
            this$0.updateStatusObserver();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(PushManager this$0, Permission permission, PermissionStatus permissionStatus) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (permission == Permission.DISPLAY_NOTIFICATIONS) {
            this$0.airshipChannel.updateRegistration();
            this$0.updateStatusObserver();
        }
    }

    @Override // com.urbanairship.AirshipComponent
    protected void onAirshipReady(@NotNull UAirship airship) {
        Intrinsics.checkNotNullParameter(airship, "airship");
        super.onAirshipReady(airship);
        this.isAirshipReady = true;
        this.privacyManager.addListener(new PrivacyManager.Listener() { // from class: com.urbanairship.push.PushManager$$ExternalSyntheticLambda4
            @Override // com.urbanairship.PrivacyManager.Listener
            public final void onEnabledFeaturesChanged() {
                PushManager.onAirshipReady$lambda$3(this.f$0);
            }
        });
        this.activityMonitor.addApplicationListener(new SimpleApplicationListener() { // from class: com.urbanairship.push.PushManager.onAirshipReady.2
            @Override // com.urbanairship.app.SimpleApplicationListener, com.urbanairship.app.ApplicationListener
            public void onForeground(long time) {
                PushManager.checkPermission$default(PushManager.this, null, 1, null);
            }
        });
        checkPermission$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAirshipReady$lambda$3(PushManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        checkPermission$default(this$0, null, 1, null);
    }

    static /* synthetic */ void checkPermission$default(PushManager pushManager, Runnable runnable, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkPermission");
        }
        if ((i & 1) != 0) {
            runnable = null;
        }
        pushManager.checkPermission(runnable);
    }

    private final void checkPermission(final Runnable onCheckComplete) {
        if (this.privacyManager.isEnabled(PrivacyManager.Feature.PUSH)) {
            this.permissionsManager.checkPermissionStatus(Permission.DISPLAY_NOTIFICATIONS, new Consumer() { // from class: com.urbanairship.push.PushManager$$ExternalSyntheticLambda0
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    PushManager.checkPermission$lambda$5(this.f$0, onCheckComplete, (PermissionStatus) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkPermission$lambda$5(PushManager this$0, final Runnable runnable, PermissionStatus permissionStatus) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (permissionStatus == PermissionStatus.GRANTED) {
            this$0.preferenceDataStore.put(REQUEST_PERMISSION_KEY, false);
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (this$0.shouldRequestNotificationPermission()) {
            PermissionsManager.requestPermission$default(this$0.permissionsManager, Permission.DISPLAY_NOTIFICATIONS, false, null, new Consumer() { // from class: com.urbanairship.push.PushManager$$ExternalSyntheticLambda7
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    PushManager.checkPermission$lambda$5$lambda$4(runnable, (PermissionRequestResult) obj);
                }
            }, 6, null);
            this$0.preferenceDataStore.put(REQUEST_PERMISSION_KEY, false);
        } else if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkPermission$lambda$5$lambda$4(Runnable runnable, PermissionRequestResult permissionRequestResult) {
        if (runnable != null) {
            runnable.run();
        }
    }

    private final boolean shouldRequestNotificationPermission() {
        return this.privacyManager.isEnabled(PrivacyManager.Feature.PUSH) && this.activityMonitor.getIsAppForegrounded() && this.isAirshipReady && getUserNotificationsEnabled() && this.preferenceDataStore.getBoolean(REQUEST_PERMISSION_KEY, true) && this.config.getConfigOptions().isPromptForPermissionOnUserNotificationsEnabled;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void updateManagerEnablement() {
        /*
            r3 = this;
            com.urbanairship.PrivacyManager r0 = r3.privacyManager
            com.urbanairship.PrivacyManager$Feature r1 = com.urbanairship.PrivacyManager.Feature.PUSH
            com.urbanairship.PrivacyManager$Feature[] r1 = new com.urbanairship.PrivacyManager.Feature[]{r1}
            boolean r0 = r0.isEnabled(r1)
            java.lang.String r1 = "com.urbanairship.push.PUSH_DELIVERY_TYPE"
            if (r0 == 0) goto L4d
            java.lang.Boolean r0 = r3.isPushManagerEnabled
            if (r0 == 0) goto L1d
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 == 0) goto L1d
            return
        L1d:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r3.isPushManagerEnabled = r0
            com.urbanairship.push.PushProvider r0 = r3.pushProvider
            if (r0 != 0) goto L45
            com.urbanairship.push.PushProvider r0 = r3.resolvePushProvider()
            r3.pushProvider = r0
            com.urbanairship.PreferenceDataStore r0 = r3.preferenceDataStore
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)
            com.urbanairship.push.PushProvider r1 = r3.pushProvider
            if (r1 == 0) goto L42
            if (r1 == 0) goto L3c
            java.lang.String r2 = r1.getDeliveryType()
        L3c:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
            if (r0 != 0) goto L45
        L42:
            r3.clearPushToken()
        L45:
            boolean r0 = r3.shouldDispatchUpdateTokenJob
            if (r0 == 0) goto L69
            r3.dispatchUpdateJob()
            goto L69
        L4d:
            java.lang.Boolean r0 = r3.isPushManagerEnabled
            if (r0 == 0) goto L56
            boolean r0 = r3.shouldDispatchUpdateTokenJob
            if (r0 != 0) goto L56
            return
        L56:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r3.isPushManagerEnabled = r0
            com.urbanairship.PreferenceDataStore r0 = r3.preferenceDataStore
            r0.remove(r1)
            com.urbanairship.PreferenceDataStore r0 = r3.preferenceDataStore
            java.lang.String r1 = "com.urbanairship.push.REGISTRATION_TOKEN_KEY"
            r0.remove(r1)
            r0 = 1
            r3.shouldDispatchUpdateTokenJob = r0
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.push.PushManager.updateManagerEnablement():void");
    }

    private final void dispatchUpdateJob() {
        JobInfo jobInfoBuild = JobInfo.newBuilder().setAction(ACTION_UPDATE_PUSH_REGISTRATION).setAirshipComponent(PushManager.class).setConflictStrategy(0).build();
        Intrinsics.checkNotNullExpressionValue(jobInfoBuild, "build(...)");
        this.jobDispatcher.dispatch(jobInfoBuild);
    }

    private final PushProvider resolvePushProvider() {
        String string = this.preferenceDataStore.getString(PROVIDER_CLASS_KEY, null);
        Object objRequireNonNull = ObjectsCompat.requireNonNull(this.pushProvidersSupplier.get());
        Intrinsics.checkNotNullExpressionValue(objRequireNonNull, "requireNonNull(...)");
        PushProviders pushProviders = (PushProviders) objRequireNonNull;
        if (!UAStringUtil.isEmpty(string)) {
            int platform = this.config.getPlatform();
            Intrinsics.checkNotNull(string);
            PushProvider provider = pushProviders.getProvider(platform, string);
            if (provider != null) {
                return provider;
            }
        }
        PushProvider bestProvider = pushProviders.getBestProvider(this.config.getPlatform());
        if (bestProvider != null) {
            this.preferenceDataStore.put(PROVIDER_CLASS_KEY, bestProvider.getClass().toString());
        }
        return bestProvider;
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @WorkerThread
    @NotNull
    public JobResult onPerformJob(@NotNull UAirship airship, @NotNull JobInfo jobInfo) {
        Intrinsics.checkNotNullParameter(airship, "airship");
        Intrinsics.checkNotNullParameter(jobInfo, "jobInfo");
        if (!this.privacyManager.isEnabled(PrivacyManager.Feature.PUSH)) {
            return JobResult.SUCCESS;
        }
        String action = jobInfo.getAction();
        int iHashCode = action.hashCode();
        if (iHashCode != -1340461647) {
            if (iHashCode == 1876792273 && action.equals(ACTION_DISPLAY_NOTIFICATION)) {
                PushMessage pushMessageFromJsonValue = PushMessage.fromJsonValue(jobInfo.getExtras().opt("EXTRA_PUSH"));
                Intrinsics.checkNotNullExpressionValue(pushMessageFromJsonValue, "fromJsonValue(...)");
                String string = jobInfo.getExtras().opt("EXTRA_PROVIDER_CLASS").getString();
                if (string == null) {
                    return JobResult.SUCCESS;
                }
                IncomingPushRunnable incomingPushRunnableBuild = new IncomingPushRunnable.Builder(this.context).setLongRunning(true).setProcessed(true).setMessage(pushMessageFromJsonValue).setProviderClass(string).build();
                Intrinsics.checkNotNullExpressionValue(incomingPushRunnableBuild, "build(...)");
                incomingPushRunnableBuild.run();
                return JobResult.SUCCESS;
            }
        } else if (action.equals(ACTION_UPDATE_PUSH_REGISTRATION)) {
            return performPushRegistration(true);
        }
        return JobResult.SUCCESS;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isPushEnabled() {
        return this.privacyManager.isEnabled(PrivacyManager.Feature.PUSH);
    }

    public final void enableUserNotifications(@NotNull Consumer<Boolean> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        enableUserNotifications(PermissionPromptFallback.None.INSTANCE, consumer);
    }

    public final boolean getUserNotificationsEnabled() {
        return this.preferenceDataStore.getBoolean(USER_NOTIFICATIONS_ENABLED_KEY, false);
    }

    public final void setUserNotificationsEnabled(boolean z) {
        if (getUserNotificationsEnabled() != z) {
            this.preferenceDataStore.put(USER_NOTIFICATIONS_ENABLED_KEY, z);
            if (z) {
                this.preferenceDataStore.put(REQUEST_PERMISSION_KEY, true);
                checkPermission(new Runnable() { // from class: com.urbanairship.push.PushManager$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        PushManager._set_userNotificationsEnabled_$lambda$7(this.f$0);
                    }
                });
            } else {
                this.airshipChannel.updateRegistration();
            }
            updateStatusObserver();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _set_userNotificationsEnabled_$lambda$7(PushManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.airshipChannel.updateRegistration();
    }

    public final void enableUserNotifications(@NotNull PermissionPromptFallback promptFallback, @NotNull final Consumer<Boolean> consumer) {
        Intrinsics.checkNotNullParameter(promptFallback, "promptFallback");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.preferenceDataStore.put(USER_NOTIFICATIONS_ENABLED_KEY, true);
        this.permissionsManager.requestPermission(Permission.DISPLAY_NOTIFICATIONS, false, promptFallback, new Consumer() { // from class: com.urbanairship.push.PushManager$$ExternalSyntheticLambda6
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                PushManager.enableUserNotifications$lambda$8(consumer, this, (PermissionRequestResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enableUserNotifications$lambda$8(Consumer consumer, PushManager this$0, PermissionRequestResult permissionRequestResult) {
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(permissionRequestResult);
        consumer.accept(Boolean.valueOf(permissionRequestResult.getPermissionStatus() == PermissionStatus.GRANTED));
        this$0.updateStatusObserver();
    }

    public final boolean isSoundEnabled() {
        return this.preferenceDataStore.getBoolean(SOUND_ENABLED_KEY, true);
    }

    public final void setSoundEnabled(boolean z) {
        this.preferenceDataStore.put(SOUND_ENABLED_KEY, z);
    }

    public final boolean isVibrateEnabled() {
        return this.preferenceDataStore.getBoolean(VIBRATE_ENABLED_KEY, true);
    }

    public final void setVibrateEnabled(boolean z) {
        this.preferenceDataStore.put(VIBRATE_ENABLED_KEY, z);
    }

    public final boolean isQuietTimeEnabled() {
        return this.preferenceDataStore.getBoolean(QUIET_TIME_ENABLED, false);
    }

    public final void setQuietTimeEnabled(boolean z) {
        this.preferenceDataStore.put(QUIET_TIME_ENABLED, z);
    }

    public final boolean isInQuietTime() {
        if (!isQuietTimeEnabled()) {
            return false;
        }
        try {
            QuietTimeInterval quietTimeIntervalFromJson = QuietTimeInterval.fromJson(this.preferenceDataStore.getJsonValue(QUIET_TIME_INTERVAL));
            Intrinsics.checkNotNullExpressionValue(quietTimeIntervalFromJson, "fromJson(...)");
            return quietTimeIntervalFromJson.isInQuietTime(Calendar.getInstance());
        } catch (JsonException e) {
            UALog.e(e, "Failed to parse quiet time interval", new Object[0]);
            return false;
        }
    }

    @Nullable
    public final Date[] getQuietTimeInterval() {
        try {
            QuietTimeInterval quietTimeIntervalFromJson = QuietTimeInterval.fromJson(this.preferenceDataStore.getJsonValue(QUIET_TIME_INTERVAL));
            Intrinsics.checkNotNullExpressionValue(quietTimeIntervalFromJson, "fromJson(...)");
            return quietTimeIntervalFromJson.getQuietTimeIntervalDateArray();
        } catch (JsonException e) {
            UALog.e(e, "Failed to parse quiet time interval", new Object[0]);
            return null;
        }
    }

    @Deprecated(message = "This setting does not work on Android O+. Applications are encouraged to\n      use `com.urbanairship.push.notifications.NotificationChannelCompat` instead.")
    public final void setQuietTimeInterval(@NotNull Date startTime, @NotNull Date endTime) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        QuietTimeInterval quietTimeIntervalBuild = QuietTimeInterval.newBuilder().setQuietTimeInterval(startTime, endTime).build();
        Intrinsics.checkNotNullExpressionValue(quietTimeIntervalBuild, "build(...)");
        this.preferenceDataStore.put(QUIET_TIME_INTERVAL, quietTimeIntervalBuild.getJsonValue());
    }

    public final boolean isPushAvailable() {
        return this.privacyManager.isEnabled(PrivacyManager.Feature.PUSH) && !UAStringUtil.isEmpty(getPushToken());
    }

    public final boolean isOptIn() {
        return isPushAvailable() && areNotificationsOptedIn();
    }

    public final boolean areNotificationsOptedIn() {
        return getUserNotificationsEnabled() && this.notificationManager.areNotificationsEnabled();
    }

    @Nullable
    public final String getLastReceivedMetadata() {
        return this.analytics.getLastReceivedMetadata();
    }

    public final void setLastReceivedMetadata(@Nullable String str) {
        this.analytics.setLastReceivedMetadata(str);
    }

    public final void addPushListener(@NotNull PushListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.pushListeners.add(listener);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void addInternalPushListener(@NotNull PushListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.internalPushListeners.add(listener);
    }

    public final void removePushListener(@NotNull PushListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.pushListeners.remove(listener);
        this.internalPushListeners.remove(listener);
    }

    public final void addNotificationStatusListener(@NotNull PushNotificationStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.statusObserver.getChangeListeners().add(listener);
    }

    public final void removeNotificationStatusListener(@NotNull PushNotificationStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.statusObserver.getChangeListeners().remove(listener);
    }

    public final void addPushTokenListener(@NotNull PushTokenListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.pushTokenListeners.add(listener);
    }

    public final void removePushTokenListener(@NotNull PushTokenListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.pushTokenListeners.remove(listener);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void addInternalNotificationListener(@NotNull InternalNotificationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.internalNotificationListeners.add(listener);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void removeInternalNotificationListener(@NotNull InternalNotificationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.internalNotificationListeners.remove(listener);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void onPushReceived(@NotNull PushMessage message, boolean notificationPosted) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.privacyManager.isEnabled(PrivacyManager.Feature.PUSH)) {
            Iterator it = this.internalPushListeners.iterator();
            while (it.hasNext()) {
                ((PushListener) it.next()).onPushReceived(message, notificationPosted);
            }
            if (message.isRemoteDataUpdate() || message.isPing()) {
                return;
            }
            Iterator it2 = this.pushListeners.iterator();
            while (it2.hasNext()) {
                ((PushListener) it2.next()).onPushReceived(message, notificationPosted);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void onNotificationPosted(@NotNull PushMessage message, int notificationId, @Nullable String notificationTag) {
        NotificationListener notificationListener;
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.privacyManager.isEnabled(PrivacyManager.Feature.PUSH) && (notificationListener = this.notificationListener) != null) {
            notificationListener.onNotificationPosted(new NotificationInfo(message, notificationId, notificationTag));
        }
    }

    public final void addNotificationActionButtonGroup(@NotNull String id, @NotNull NotificationActionButtonGroup group) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(group, "group");
        if (StringsKt.startsWith$default(id, "ua_", false, 2, (Object) null)) {
            UALog.e("Unable to add any notification button groups that starts with the reserved Airship prefix %s", "ua_");
        } else {
            this.actionGroupMap.put(id, group);
        }
    }

    public final void addNotificationActionButtonGroups(@NotNull Context context, @XmlRes int resId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Map mapFromXml = ActionButtonGroupsParser.fromXml(context, resId);
        Intrinsics.checkNotNullExpressionValue(mapFromXml, "fromXml(...)");
        for (Map.Entry entry : mapFromXml.entrySet()) {
            addNotificationActionButtonGroup((String) entry.getKey(), (NotificationActionButtonGroup) entry.getValue());
        }
    }

    public final void removeNotificationActionButtonGroup(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (StringsKt.startsWith$default(id, "ua_", false, 2, (Object) null)) {
            UALog.e("Unable to remove any reserved Airship actions groups that begin with %s", "ua_");
        } else {
            this.actionGroupMap.remove(id);
        }
    }

    @Nullable
    public final NotificationActionButtonGroup getNotificationActionGroup(@Nullable String id) {
        if (id == null) {
            return null;
        }
        return (NotificationActionButtonGroup) this.actionGroupMap.get(id);
    }

    @Nullable
    public final String getPushToken() {
        return this.preferenceDataStore.getString(PUSH_TOKEN_KEY, null);
    }

    private final void clearPushToken() {
        this.preferenceDataStore.remove(PUSH_TOKEN_KEY);
        this.preferenceDataStore.remove(PUSH_DELIVERY_TYPE);
        updateStatusObserver();
    }

    @NotNull
    public final PushProviderType getPushProviderType() {
        return PushProviderType.INSTANCE.from(this.pushProvider);
    }

    public final boolean isUniqueCanonicalId(@Nullable String canonicalId) {
        JsonList list;
        if (UAStringUtil.isEmpty(canonicalId)) {
            return true;
        }
        synchronized (this.uniqueIdLock) {
            try {
                list = JsonValue.parseString(this.preferenceDataStore.getString("com.urbanairship.push.LAST_CANONICAL_IDS", null)).getList();
            } catch (JsonException e) {
                UALog.d(e, "Unable to parse canonical Ids.", new Object[0]);
                list = null;
            }
            List<JsonValue> list2 = list != null ? list.getList() : null;
            if (list2 == null) {
                list2 = new ArrayList<>();
            } else {
                Intrinsics.checkNotNull(list2);
            }
            JsonValue jsonValueWrap = JsonValue.wrap(canonicalId);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            if (list2.contains(jsonValueWrap)) {
                return false;
            }
            list2.add(jsonValueWrap);
            if (list2.size() > 10) {
                list2 = list2.subList(list2.size() - 10, list2.size());
            }
            this.preferenceDataStore.put("com.urbanairship.push.LAST_CANONICAL_IDS", JsonValue.wrapOpt(list2).toString());
            return true;
        }
    }

    @NotNull
    public final JobResult performPushRegistration(boolean updateChannelOnChange) {
        this.shouldDispatchUpdateTokenJob = false;
        String pushToken = getPushToken();
        PushProvider pushProvider = this.pushProvider;
        if (pushProvider == null) {
            UALog.i("PushManager - Push registration failed. Missing push provider.", new Object[0]);
            return JobResult.SUCCESS;
        }
        if (!pushProvider.isAvailable(this.context)) {
            UALog.w("PushManager - Push registration failed. Push provider unavailable: %s", pushProvider);
            return JobResult.RETRY;
        }
        try {
            String registrationToken = pushProvider.getRegistrationToken(this.context);
            if (registrationToken != null && !UAStringUtil.equals(registrationToken, pushToken)) {
                UALog.i("PushManager - Push registration updated.", new Object[0]);
                this.preferenceDataStore.put(PUSH_DELIVERY_TYPE, pushProvider.getDeliveryType());
                this.preferenceDataStore.put(PUSH_TOKEN_KEY, registrationToken);
                updateStatusObserver();
                Iterator it = this.pushTokenListeners.iterator();
                while (it.hasNext()) {
                    ((PushTokenListener) it.next()).onPushTokenUpdated(registrationToken);
                }
                if (updateChannelOnChange) {
                    this.airshipChannel.updateRegistration();
                }
            }
            return JobResult.SUCCESS;
        } catch (PushProvider.PushProviderUnavailableException e) {
            UALog.d("Push registration failed, provider unavailable. Error: %s. Will retry.", e.getMessage(), e);
            return JobResult.RETRY;
        } catch (PushProvider.RegistrationException e2) {
            UALog.d("Push registration failed. Error: %S, Recoverable %s.", Boolean.valueOf(e2.isRecoverable()), e2.getMessage(), e2);
            clearPushToken();
            if (e2.isRecoverable()) {
                return JobResult.RETRY;
            }
            return JobResult.SUCCESS;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final List<InternalNotificationListener> getInternalNotificationListeners() {
        return this.internalNotificationListeners;
    }

    private final Map createAnalyticsHeaders() {
        if (this.privacyManager.isEnabled(PrivacyManager.Feature.PUSH)) {
            HashMap map = new HashMap();
            map.put("X-UA-Channel-Opted-In", String.valueOf(isOptIn()));
            map.put("X-UA-Channel-Background-Enabled", String.valueOf(isPushAvailable()));
            return map;
        }
        return MapsKt.emptyMap();
    }

    public final void onTokenChanged(@Nullable Class<? extends PushProvider> pushProviderClass, @Nullable String token) {
        PushProvider pushProvider;
        if (!this.privacyManager.isEnabled(PrivacyManager.Feature.PUSH) || (pushProvider = this.pushProvider) == null) {
            return;
        }
        if (pushProviderClass != null) {
            if (Intrinsics.areEqual(pushProvider != null ? pushProvider.getClass() : null, pushProviderClass)) {
                String string = this.preferenceDataStore.getString(PUSH_TOKEN_KEY, null);
                if (token != null && !Intrinsics.areEqual(token, string)) {
                    clearPushToken();
                }
            }
        }
        dispatchUpdateJob();
    }

    @NotNull
    public final PushNotificationStatus getPushNotificationStatus() {
        return new PushNotificationStatus(getUserNotificationsEnabled(), this.notificationManager.areNotificationsEnabled(), this.privacyManager.isEnabled(PrivacyManager.Feature.PUSH), !UAStringUtil.isEmpty(getPushToken()));
    }

    public final void updateStatusObserver() {
        this.statusObserver.update(getPushNotificationStatus());
    }
}
