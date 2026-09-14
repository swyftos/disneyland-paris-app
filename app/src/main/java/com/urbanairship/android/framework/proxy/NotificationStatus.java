package com.urbanairship.android.framework.proxy;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.push.PushNotificationStatus;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB?\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0011J\t\u0010\u0016\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\b\u0010#\u001a\u00020\u0003H\u0016J\t\u0010$\u001a\u00020\bHÖ\u0001R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/NotificationStatus;", "Lcom/urbanairship/json/JsonSerializable;", "value", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "status", "Lcom/urbanairship/push/PushNotificationStatus;", "notificationPermissionStatus", "", "(Lcom/urbanairship/push/PushNotificationStatus;Ljava/lang/String;)V", "isUserNotificationsEnabled", "", "areNotificationsAllowed", "isPushPrivacyFeatureEnabled", "isPushTokenRegistered", "isUserOptedIn", "isOptedIn", "(ZZZZZZLjava/lang/String;)V", "getAreNotificationsAllowed", "()Z", "getNotificationPermissionStatus", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nNotificationStatus.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationStatus.kt\ncom/urbanairship/android/framework/proxy/NotificationStatus\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,50:1\n44#2,15:51\n44#2,15:66\n44#2,15:81\n44#2,15:96\n44#2,15:111\n44#2,15:126\n79#2,16:141\n*S KotlinDebug\n*F\n+ 1 NotificationStatus.kt\ncom/urbanairship/android/framework/proxy/NotificationStatus\n*L\n21#1:51,15\n22#1:66,15\n23#1:81,15\n24#1:96,15\n25#1:111,15\n26#1:126,15\n27#1:141,16\n*E\n"})
public final /* data */ class NotificationStatus implements JsonSerializable {
    private final boolean areNotificationsAllowed;
    private final boolean isOptedIn;
    private final boolean isPushPrivacyFeatureEnabled;
    private final boolean isPushTokenRegistered;
    private final boolean isUserNotificationsEnabled;
    private final boolean isUserOptedIn;
    private final String notificationPermissionStatus;

    public static /* synthetic */ NotificationStatus copy$default(NotificationStatus notificationStatus, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = notificationStatus.isUserNotificationsEnabled;
        }
        if ((i & 2) != 0) {
            z2 = notificationStatus.areNotificationsAllowed;
        }
        boolean z7 = z2;
        if ((i & 4) != 0) {
            z3 = notificationStatus.isPushPrivacyFeatureEnabled;
        }
        boolean z8 = z3;
        if ((i & 8) != 0) {
            z4 = notificationStatus.isPushTokenRegistered;
        }
        boolean z9 = z4;
        if ((i & 16) != 0) {
            z5 = notificationStatus.isUserOptedIn;
        }
        boolean z10 = z5;
        if ((i & 32) != 0) {
            z6 = notificationStatus.isOptedIn;
        }
        boolean z11 = z6;
        if ((i & 64) != 0) {
            str = notificationStatus.notificationPermissionStatus;
        }
        return notificationStatus.copy(z, z7, z8, z9, z10, z11, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsUserNotificationsEnabled() {
        return this.isUserNotificationsEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAreNotificationsAllowed() {
        return this.areNotificationsAllowed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsPushPrivacyFeatureEnabled() {
        return this.isPushPrivacyFeatureEnabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsPushTokenRegistered() {
        return this.isPushTokenRegistered;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsUserOptedIn() {
        return this.isUserOptedIn;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsOptedIn() {
        return this.isOptedIn;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getNotificationPermissionStatus() {
        return this.notificationPermissionStatus;
    }

    @NotNull
    public final NotificationStatus copy(boolean isUserNotificationsEnabled, boolean areNotificationsAllowed, boolean isPushPrivacyFeatureEnabled, boolean isPushTokenRegistered, boolean isUserOptedIn, boolean isOptedIn, @Nullable String notificationPermissionStatus) {
        return new NotificationStatus(isUserNotificationsEnabled, areNotificationsAllowed, isPushPrivacyFeatureEnabled, isPushTokenRegistered, isUserOptedIn, isOptedIn, notificationPermissionStatus);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationStatus)) {
            return false;
        }
        NotificationStatus notificationStatus = (NotificationStatus) other;
        return this.isUserNotificationsEnabled == notificationStatus.isUserNotificationsEnabled && this.areNotificationsAllowed == notificationStatus.areNotificationsAllowed && this.isPushPrivacyFeatureEnabled == notificationStatus.isPushPrivacyFeatureEnabled && this.isPushTokenRegistered == notificationStatus.isPushTokenRegistered && this.isUserOptedIn == notificationStatus.isUserOptedIn && this.isOptedIn == notificationStatus.isOptedIn && Intrinsics.areEqual(this.notificationPermissionStatus, notificationStatus.notificationPermissionStatus);
    }

    public int hashCode() {
        int iHashCode = ((((((((((Boolean.hashCode(this.isUserNotificationsEnabled) * 31) + Boolean.hashCode(this.areNotificationsAllowed)) * 31) + Boolean.hashCode(this.isPushPrivacyFeatureEnabled)) * 31) + Boolean.hashCode(this.isPushTokenRegistered)) * 31) + Boolean.hashCode(this.isUserOptedIn)) * 31) + Boolean.hashCode(this.isOptedIn)) * 31;
        String str = this.notificationPermissionStatus;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "NotificationStatus(isUserNotificationsEnabled=" + this.isUserNotificationsEnabled + ", areNotificationsAllowed=" + this.areNotificationsAllowed + ", isPushPrivacyFeatureEnabled=" + this.isPushPrivacyFeatureEnabled + ", isPushTokenRegistered=" + this.isPushTokenRegistered + ", isUserOptedIn=" + this.isUserOptedIn + ", isOptedIn=" + this.isOptedIn + ", notificationPermissionStatus=" + this.notificationPermissionStatus + ")";
    }

    public NotificationStatus(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, @Nullable String str) {
        this.isUserNotificationsEnabled = z;
        this.areNotificationsAllowed = z2;
        this.isPushPrivacyFeatureEnabled = z3;
        this.isPushTokenRegistered = z4;
        this.isUserOptedIn = z5;
        this.isOptedIn = z6;
        this.notificationPermissionStatus = str;
    }

    public final boolean isUserNotificationsEnabled() {
        return this.isUserNotificationsEnabled;
    }

    public final boolean getAreNotificationsAllowed() {
        return this.areNotificationsAllowed;
    }

    public final boolean isPushPrivacyFeatureEnabled() {
        return this.isPushPrivacyFeatureEnabled;
    }

    public final boolean isPushTokenRegistered() {
        return this.isPushTokenRegistered;
    }

    public final boolean isUserOptedIn() {
        return this.isUserOptedIn;
    }

    public final boolean isOptedIn() {
        return this.isOptedIn;
    }

    @Nullable
    public final String getNotificationPermissionStatus() {
        return this.notificationPermissionStatus;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x026c  */
    /* JADX WARN: Code duplicated, block: B:101:0x026f  */
    /* JADX WARN: Code duplicated, block: B:103:0x0275  */
    /* JADX WARN: Code duplicated, block: B:105:0x027f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0285  */
    /* JADX WARN: Code duplicated, block: B:108:0x0288  */
    /* JADX WARN: Code duplicated, block: B:110:0x028e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0298  */
    /* JADX WARN: Code duplicated, block: B:114:0x029e  */
    /* JADX WARN: Code duplicated, block: B:117:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:119:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:121:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:122:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:124:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:126:0x02db  */
    /* JADX WARN: Code duplicated, block: B:128:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:129:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:131:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:133:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:134:0x0302  */
    /* JADX WARN: Code duplicated, block: B:136:0x030e  */
    /* JADX WARN: Code duplicated, block: B:137:0x031c  */
    /* JADX WARN: Code duplicated, block: B:139:0x0326  */
    /* JADX WARN: Code duplicated, block: B:140:0x0338  */
    /* JADX WARN: Code duplicated, block: B:142:0x0344  */
    /* JADX WARN: Code duplicated, block: B:143:0x0352  */
    /* JADX WARN: Code duplicated, block: B:145:0x035e  */
    /* JADX WARN: Code duplicated, block: B:146:0x036b  */
    /* JADX WARN: Code duplicated, block: B:148:0x0375  */
    /* JADX WARN: Code duplicated, block: B:149:0x0381  */
    /* JADX WARN: Code duplicated, block: B:151:0x038c  */
    /* JADX WARN: Code duplicated, block: B:152:0x039b  */
    /* JADX WARN: Code duplicated, block: B:154:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:156:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:157:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:159:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:161:0x03be  */
    /* JADX WARN: Code duplicated, block: B:163:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:164:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:166:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:168:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:170:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:173:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:175:0x0400  */
    /* JADX WARN: Code duplicated, block: B:177:0x0406  */
    /* JADX WARN: Code duplicated, block: B:178:0x040a  */
    /* JADX WARN: Code duplicated, block: B:180:0x0410  */
    /* JADX WARN: Code duplicated, block: B:182:0x041a  */
    /* JADX WARN: Code duplicated, block: B:184:0x0420  */
    /* JADX WARN: Code duplicated, block: B:185:0x0424  */
    /* JADX WARN: Code duplicated, block: B:187:0x042a  */
    /* JADX WARN: Code duplicated, block: B:189:0x0436  */
    /* JADX WARN: Code duplicated, block: B:190:0x0441  */
    /* JADX WARN: Code duplicated, block: B:192:0x044d  */
    /* JADX WARN: Code duplicated, block: B:193:0x045b  */
    /* JADX WARN: Code duplicated, block: B:195:0x0465  */
    /* JADX WARN: Code duplicated, block: B:196:0x0477  */
    /* JADX WARN: Code duplicated, block: B:198:0x0483  */
    /* JADX WARN: Code duplicated, block: B:199:0x0491  */
    /* JADX WARN: Code duplicated, block: B:201:0x049d  */
    /* JADX WARN: Code duplicated, block: B:202:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:204:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:205:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:207:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:208:0x04da  */
    /* JADX WARN: Code duplicated, block: B:210:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:212:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:213:0x04ed  */
    /* JADX WARN: Code duplicated, block: B:215:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:217:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:219:0x0503  */
    /* JADX WARN: Code duplicated, block: B:220:0x0506  */
    /* JADX WARN: Code duplicated, block: B:222:0x050c  */
    /* JADX WARN: Code duplicated, block: B:224:0x0516  */
    /* JADX WARN: Code duplicated, block: B:226:0x051c  */
    /* JADX WARN: Code duplicated, block: B:229:0x0531  */
    /* JADX WARN: Code duplicated, block: B:231:0x053f  */
    /* JADX WARN: Code duplicated, block: B:233:0x0545  */
    /* JADX WARN: Code duplicated, block: B:234:0x0549  */
    /* JADX WARN: Code duplicated, block: B:236:0x054f  */
    /* JADX WARN: Code duplicated, block: B:238:0x0559  */
    /* JADX WARN: Code duplicated, block: B:240:0x055f  */
    /* JADX WARN: Code duplicated, block: B:241:0x0563  */
    /* JADX WARN: Code duplicated, block: B:243:0x0569  */
    /* JADX WARN: Code duplicated, block: B:245:0x0575  */
    /* JADX WARN: Code duplicated, block: B:246:0x0580  */
    /* JADX WARN: Code duplicated, block: B:248:0x058c  */
    /* JADX WARN: Code duplicated, block: B:249:0x059a  */
    /* JADX WARN: Code duplicated, block: B:251:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:252:0x05b6  */
    /* JADX WARN: Code duplicated, block: B:254:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:255:0x05d0  */
    /* JADX WARN: Code duplicated, block: B:257:0x05dc  */
    /* JADX WARN: Code duplicated, block: B:258:0x05e9  */
    /* JADX WARN: Code duplicated, block: B:260:0x05f3  */
    /* JADX WARN: Code duplicated, block: B:261:0x05ff  */
    /* JADX WARN: Code duplicated, block: B:263:0x060a  */
    /* JADX WARN: Code duplicated, block: B:264:0x0619  */
    /* JADX WARN: Code duplicated, block: B:266:0x0623  */
    /* JADX WARN: Code duplicated, block: B:268:0x0629  */
    /* JADX WARN: Code duplicated, block: B:269:0x062c  */
    /* JADX WARN: Code duplicated, block: B:271:0x0632  */
    /* JADX WARN: Code duplicated, block: B:273:0x063c  */
    /* JADX WARN: Code duplicated, block: B:275:0x0642  */
    /* JADX WARN: Code duplicated, block: B:276:0x0645  */
    /* JADX WARN: Code duplicated, block: B:278:0x064b  */
    /* JADX WARN: Code duplicated, block: B:280:0x0655  */
    /* JADX WARN: Code duplicated, block: B:282:0x065b  */
    /* JADX WARN: Code duplicated, block: B:285:0x0670  */
    /* JADX WARN: Code duplicated, block: B:287:0x067e  */
    /* JADX WARN: Code duplicated, block: B:289:0x0684  */
    /* JADX WARN: Code duplicated, block: B:290:0x0688  */
    /* JADX WARN: Code duplicated, block: B:292:0x068e  */
    /* JADX WARN: Code duplicated, block: B:294:0x0698  */
    /* JADX WARN: Code duplicated, block: B:296:0x069e  */
    /* JADX WARN: Code duplicated, block: B:297:0x06a2  */
    /* JADX WARN: Code duplicated, block: B:299:0x06a8  */
    /* JADX WARN: Code duplicated, block: B:301:0x06b4  */
    /* JADX WARN: Code duplicated, block: B:302:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:304:0x06cb  */
    /* JADX WARN: Code duplicated, block: B:305:0x06d9  */
    /* JADX WARN: Code duplicated, block: B:307:0x06e5  */
    /* JADX WARN: Code duplicated, block: B:308:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:310:0x0701  */
    /* JADX WARN: Code duplicated, block: B:311:0x070f  */
    /* JADX WARN: Code duplicated, block: B:313:0x071b  */
    /* JADX WARN: Code duplicated, block: B:314:0x0728  */
    /* JADX WARN: Code duplicated, block: B:316:0x0732  */
    /* JADX WARN: Code duplicated, block: B:317:0x073e  */
    /* JADX WARN: Code duplicated, block: B:319:0x0749  */
    /* JADX WARN: Code duplicated, block: B:320:0x0758  */
    /* JADX WARN: Code duplicated, block: B:322:0x0762  */
    /* JADX WARN: Code duplicated, block: B:324:0x0768  */
    /* JADX WARN: Code duplicated, block: B:325:0x076b  */
    /* JADX WARN: Code duplicated, block: B:327:0x0771  */
    /* JADX WARN: Code duplicated, block: B:329:0x077b  */
    /* JADX WARN: Code duplicated, block: B:331:0x0781  */
    /* JADX WARN: Code duplicated, block: B:332:0x0784  */
    /* JADX WARN: Code duplicated, block: B:334:0x078a  */
    /* JADX WARN: Code duplicated, block: B:336:0x0794  */
    /* JADX WARN: Code duplicated, block: B:338:0x079a  */
    /* JADX WARN: Code duplicated, block: B:341:0x07af  */
    /* JADX WARN: Code duplicated, block: B:343:0x07b4  */
    /* JADX WARN: Code duplicated, block: B:351:0x07e2  */
    /* JADX WARN: Code duplicated, block: B:352:0x07ee  */
    /* JADX WARN: Code duplicated, block: B:354:0x07fa  */
    /* JADX WARN: Code duplicated, block: B:355:0x0807  */
    /* JADX WARN: Code duplicated, block: B:357:0x0813  */
    /* JADX WARN: Code duplicated, block: B:358:0x0822  */
    /* JADX WARN: Code duplicated, block: B:360:0x082e  */
    /* JADX WARN: Code duplicated, block: B:361:0x083c  */
    /* JADX WARN: Code duplicated, block: B:363:0x0848  */
    /* JADX WARN: Code duplicated, block: B:364:0x0855  */
    /* JADX WARN: Code duplicated, block: B:372:0x088f  */
    /* JADX WARN: Code duplicated, block: B:373:0x089f  */
    /* JADX WARN: Code duplicated, block: B:375:0x08a9  */
    /* JADX WARN: Code duplicated, block: B:376:0x08b1  */
    /* JADX WARN: Code duplicated, block: B:378:0x08bb  */
    /* JADX WARN: Code duplicated, block: B:379:0x08c3  */
    /* JADX WARN: Code duplicated, block: B:381:0x08cd  */
    /* JADX WARN: Code duplicated, block: B:384:0x08db  */
    /* JADX WARN: Code duplicated, block: B:386:0x08ff  */
    /* JADX WARN: Code duplicated, block: B:388:0x0905  */
    /* JADX WARN: Code duplicated, block: B:390:0x0929  */
    /* JADX WARN: Code duplicated, block: B:392:0x0943  */
    /* JADX WARN: Code duplicated, block: B:394:0x0949  */
    /* JADX WARN: Code duplicated, block: B:396:0x096d  */
    /* JADX WARN: Code duplicated, block: B:398:0x0987  */
    /* JADX WARN: Code duplicated, block: B:400:0x098d  */
    /* JADX WARN: Code duplicated, block: B:402:0x09b1  */
    /* JADX WARN: Code duplicated, block: B:404:0x09cb  */
    /* JADX WARN: Code duplicated, block: B:406:0x09d1  */
    /* JADX WARN: Code duplicated, block: B:408:0x09f5  */
    /* JADX WARN: Code duplicated, block: B:410:0x0a0f  */
    /* JADX WARN: Code duplicated, block: B:412:0x0a15  */
    /* JADX WARN: Code duplicated, block: B:414:0x0a39  */
    /* JADX WARN: Code duplicated, block: B:61:0x0174  */
    /* JADX WARN: Code duplicated, block: B:63:0x0182  */
    /* JADX WARN: Code duplicated, block: B:65:0x0188  */
    /* JADX WARN: Code duplicated, block: B:66:0x018c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0192  */
    /* JADX WARN: Code duplicated, block: B:70:0x019c  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:77:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:78:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:80:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:81:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:83:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:86:0x0205  */
    /* JADX WARN: Code duplicated, block: B:87:0x0213  */
    /* JADX WARN: Code duplicated, block: B:89:0x021f  */
    /* JADX WARN: Code duplicated, block: B:90:0x022c  */
    /* JADX WARN: Code duplicated, block: B:92:0x0236  */
    /* JADX WARN: Code duplicated, block: B:93:0x0242  */
    /* JADX WARN: Code duplicated, block: B:95:0x024d  */
    /* JADX WARN: Code duplicated, block: B:96:0x025c  */
    /* JADX WARN: Code duplicated, block: B:98:0x0266  */
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Instruction removed from duplicated block: B:384:0x08db, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:388:0x0905, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:390:0x0929, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:394:0x0949, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:396:0x096d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:400:0x098d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:402:0x09b1, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:406:0x09d1, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:408:0x09f5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:412:0x0a15, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:414:0x0a39, please report this as an issue */
    public NotificationStatus(@NotNull JsonValue value) throws JsonException {
        String str;
        Boolean boolValueOf;
        boolean zBooleanValue;
        JsonValue jsonValue;
        KClass orCreateKotlinClass;
        Object jsonValue2;
        Boolean boolValueOf2;
        Object objOptMap;
        Object objOptList;
        Object objOptString;
        boolean zBooleanValue2;
        JsonValue jsonValue3;
        KClass orCreateKotlinClass2;
        Object jsonValue4;
        Boolean boolValueOf3;
        Object objOptMap2;
        Object objOptList2;
        Object objOptString2;
        boolean zBooleanValue3;
        JsonValue jsonValue5;
        KClass orCreateKotlinClass3;
        Object jsonValue6;
        Boolean boolValueOf4;
        Object objOptMap3;
        Object objOptList3;
        Object objOptString3;
        boolean zBooleanValue4;
        JsonValue jsonValue7;
        KClass orCreateKotlinClass4;
        Object jsonValue8;
        Boolean boolValueOf5;
        Object objOptMap4;
        Object objOptList4;
        Object objOptString4;
        boolean zBooleanValue5;
        JsonValue jsonValue9;
        KClass orCreateKotlinClass5;
        Object jsonValue10;
        Boolean boolValueOf6;
        Object objOptMap5;
        Object objOptList5;
        Object objOptString5;
        JsonValue jsonValue11;
        KClass orCreateKotlinClass6;
        String strOptString;
        Object objOptString6;
        Object objOptString7;
        Object objOptString8;
        Object objOptString9;
        Object objOptString10;
        Intrinsics.checkNotNullParameter(value, "value");
        JsonMap jsonMapRequireMap = value.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
        JsonValue jsonValue12 = jsonMapRequireMap.get("isUserNotificationsEnabled");
        if (jsonValue12 == null) {
            throw new JsonException("Missing required field: 'isUserNotificationsEnabled" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Boolean.class);
        if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString11 = jsonValue12.optString();
            if (objOptString11 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) objOptString11;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf = Boolean.valueOf(jsonValue12.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str = "null cannot be cast to non-null type kotlin.Boolean";
                    boolValueOf = (Boolean) Long.valueOf(jsonValue12.getLong(0L));
                } else {
                    str = "null cannot be cast to non-null type kotlin.Boolean";
                    if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue12.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        boolValueOf = (Boolean) Double.valueOf(jsonValue12.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        boolValueOf = (Boolean) Float.valueOf(jsonValue12.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        boolValueOf = (Boolean) Integer.valueOf(jsonValue12.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue12.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList6 = jsonValue12.optList();
                        if (objOptList6 == null) {
                            throw new NullPointerException(str);
                        }
                        boolValueOf = (Boolean) objOptList6;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap6 = jsonValue12.optMap();
                        if (objOptMap6 == null) {
                            throw new NullPointerException(str);
                        }
                        boolValueOf = (Boolean) objOptMap6;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'isUserNotificationsEnabled" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue13 = jsonValue12.getJsonValue();
                        if (jsonValue13 == null) {
                            throw new NullPointerException(str);
                        }
                        boolValueOf = (Boolean) jsonValue13;
                    }
                }
                zBooleanValue = boolValueOf.booleanValue();
                JsonMap jsonMapRequireMap2 = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap2, "requireMap(...)");
                jsonValue = jsonMapRequireMap2.get("areNotificationsAllowed");
                if (jsonValue != null) {
                    throw new JsonException("Missing required field: 'areNotificationsAllowed" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    objOptString10 = jsonValue.optString();
                    if (objOptString10 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf2 = (Boolean) objOptString10;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    objOptString = jsonValue.optString();
                    if (objOptString != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf2 = (Boolean) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf2 = Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    boolValueOf2 = (Boolean) Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    boolValueOf2 = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    boolValueOf2 = (Boolean) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    boolValueOf2 = (Boolean) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    boolValueOf2 = (Boolean) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    boolValueOf2 = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList = jsonValue.optList();
                    if (objOptList != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf2 = (Boolean) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap = jsonValue.optMap();
                    if (objOptMap != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf2 = (Boolean) objOptMap;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'areNotificationsAllowed" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue2 = jsonValue.getJsonValue();
                    if (jsonValue2 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf2 = (Boolean) jsonValue2;
                }
                zBooleanValue2 = boolValueOf2.booleanValue();
                JsonMap jsonMapRequireMap3 = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap3, "requireMap(...)");
                jsonValue3 = jsonMapRequireMap3.get("isPushPrivacyFeatureEnabled");
                if (jsonValue3 != null) {
                    throw new JsonException("Missing required field: 'isPushPrivacyFeatureEnabled" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    objOptString9 = jsonValue3.optString();
                    if (objOptString9 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf3 = (Boolean) objOptString9;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    objOptString2 = jsonValue3.optString();
                    if (objOptString2 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf3 = (Boolean) objOptString2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf3 = Boolean.valueOf(jsonValue3.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    boolValueOf3 = (Boolean) Long.valueOf(jsonValue3.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    boolValueOf3 = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    boolValueOf3 = (Boolean) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    boolValueOf3 = (Boolean) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    boolValueOf3 = (Boolean) Integer.valueOf(jsonValue3.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    boolValueOf3 = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList2 = jsonValue3.optList();
                    if (objOptList2 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf3 = (Boolean) objOptList2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap2 = jsonValue3.optMap();
                    if (objOptMap2 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf3 = (Boolean) objOptMap2;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'isPushPrivacyFeatureEnabled" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue4 = jsonValue3.getJsonValue();
                    if (jsonValue4 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf3 = (Boolean) jsonValue4;
                }
                zBooleanValue3 = boolValueOf3.booleanValue();
                JsonMap jsonMapRequireMap4 = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap4, "requireMap(...)");
                jsonValue5 = jsonMapRequireMap4.get("isPushTokenRegistered");
                if (jsonValue5 != null) {
                    throw new JsonException("Missing required field: 'isPushTokenRegistered" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                    objOptString8 = jsonValue5.optString();
                    if (objOptString8 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf4 = (Boolean) objOptString8;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    objOptString3 = jsonValue5.optString();
                    if (objOptString3 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf4 = (Boolean) objOptString3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf4 = Boolean.valueOf(jsonValue5.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    boolValueOf4 = (Boolean) Long.valueOf(jsonValue5.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    boolValueOf4 = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    boolValueOf4 = (Boolean) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    boolValueOf4 = (Boolean) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    boolValueOf4 = (Boolean) Integer.valueOf(jsonValue5.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    boolValueOf4 = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList3 = jsonValue5.optList();
                    if (objOptList3 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf4 = (Boolean) objOptList3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap3 = jsonValue5.optMap();
                    if (objOptMap3 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf4 = (Boolean) objOptMap3;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'isPushTokenRegistered" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue6 = jsonValue5.getJsonValue();
                    if (jsonValue6 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf4 = (Boolean) jsonValue6;
                }
                zBooleanValue4 = boolValueOf4.booleanValue();
                JsonMap jsonMapRequireMap5 = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap5, "requireMap(...)");
                jsonValue7 = jsonMapRequireMap5.get("isUserOptedIn");
                if (jsonValue7 != null) {
                    throw new JsonException("Missing required field: 'isUserOptedIn" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                    objOptString7 = jsonValue7.optString();
                    if (objOptString7 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf5 = (Boolean) objOptString7;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    objOptString4 = jsonValue7.optString();
                    if (objOptString4 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf5 = (Boolean) objOptString4;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf5 = Boolean.valueOf(jsonValue7.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    boolValueOf5 = (Boolean) Long.valueOf(jsonValue7.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    boolValueOf5 = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    boolValueOf5 = (Boolean) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    boolValueOf5 = (Boolean) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    boolValueOf5 = (Boolean) Integer.valueOf(jsonValue7.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    boolValueOf5 = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList4 = jsonValue7.optList();
                    if (objOptList4 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf5 = (Boolean) objOptList4;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap4 = jsonValue7.optMap();
                    if (objOptMap4 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf5 = (Boolean) objOptMap4;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'isUserOptedIn" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue8 = jsonValue7.getJsonValue();
                    if (jsonValue8 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf5 = (Boolean) jsonValue8;
                }
                zBooleanValue5 = boolValueOf5.booleanValue();
                JsonMap jsonMapRequireMap6 = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap6, "requireMap(...)");
                jsonValue9 = jsonMapRequireMap6.get("isOptedIn");
                if (jsonValue9 != null) {
                    throw new JsonException("Missing required field: 'isOptedIn" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                    objOptString6 = jsonValue9.optString();
                    if (objOptString6 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf6 = (Boolean) objOptString6;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    objOptString5 = jsonValue9.optString();
                    if (objOptString5 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf6 = (Boolean) objOptString5;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf6 = Boolean.valueOf(jsonValue9.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    boolValueOf6 = (Boolean) Long.valueOf(jsonValue9.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    boolValueOf6 = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue9.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    boolValueOf6 = (Boolean) Double.valueOf(jsonValue9.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    boolValueOf6 = (Boolean) Float.valueOf(jsonValue9.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    boolValueOf6 = (Boolean) Integer.valueOf(jsonValue9.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    boolValueOf6 = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue9.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList5 = jsonValue9.optList();
                    if (objOptList5 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf6 = (Boolean) objOptList5;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap5 = jsonValue9.optMap();
                    if (objOptMap5 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf6 = (Boolean) objOptMap5;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'isOptedIn" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue10 = jsonValue9.getJsonValue();
                    if (jsonValue10 != null) {
                        throw new NullPointerException(str);
                    }
                    boolValueOf6 = (Boolean) jsonValue10;
                }
                boolean zBooleanValue6 = boolValueOf6.booleanValue();
                JsonMap jsonMapRequireMap7 = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap7, "requireMap(...)");
                jsonValue11 = jsonMapRequireMap7.get("notificationPermissionStatus");
                if (jsonValue11 == null) {
                    strOptString = null;
                } else {
                    orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(String.class);
                    if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString = jsonValue11.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue11.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString = (String) Long.valueOf(jsonValue11.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue11.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue11.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue11.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString = (String) Integer.valueOf(jsonValue11.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue11.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        strOptString = (String) jsonValue11.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        strOptString = (String) jsonValue11.optMap();
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'notificationPermissionStatus" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        strOptString = (String) jsonValue11.getJsonValue();
                    }
                }
                this(zBooleanValue, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, zBooleanValue6, strOptString);
            }
            Object objOptString12 = jsonValue12.optString();
            if (objOptString12 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) objOptString12;
        }
        str = "null cannot be cast to non-null type kotlin.Boolean";
        zBooleanValue = boolValueOf.booleanValue();
        JsonMap jsonMapRequireMap8 = value.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap8, "requireMap(...)");
        jsonValue = jsonMapRequireMap8.get("areNotificationsAllowed");
        if (jsonValue != null) {
            throw new JsonException("Missing required field: 'areNotificationsAllowed" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            objOptString10 = jsonValue.optString();
            if (objOptString10 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf2 = (Boolean) objOptString10;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            objOptString = jsonValue.optString();
            if (objOptString != null) {
                throw new NullPointerException(str);
            }
            boolValueOf2 = (Boolean) objOptString;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            boolValueOf2 = Boolean.valueOf(jsonValue.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            boolValueOf2 = (Boolean) Long.valueOf(jsonValue.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            boolValueOf2 = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            boolValueOf2 = (Boolean) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            boolValueOf2 = (Boolean) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            boolValueOf2 = (Boolean) Integer.valueOf(jsonValue.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            boolValueOf2 = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            objOptList = jsonValue.optList();
            if (objOptList != null) {
                throw new NullPointerException(str);
            }
            boolValueOf2 = (Boolean) objOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            objOptMap = jsonValue.optMap();
            if (objOptMap != null) {
                throw new NullPointerException(str);
            }
            boolValueOf2 = (Boolean) objOptMap;
        } else {
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'areNotificationsAllowed" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            jsonValue2 = jsonValue.getJsonValue();
            if (jsonValue2 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf2 = (Boolean) jsonValue2;
        }
        zBooleanValue2 = boolValueOf2.booleanValue();
        JsonMap jsonMapRequireMap9 = value.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap9, "requireMap(...)");
        jsonValue3 = jsonMapRequireMap9.get("isPushPrivacyFeatureEnabled");
        if (jsonValue3 != null) {
            throw new JsonException("Missing required field: 'isPushPrivacyFeatureEnabled" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
            objOptString9 = jsonValue3.optString();
            if (objOptString9 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf3 = (Boolean) objOptString9;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            objOptString2 = jsonValue3.optString();
            if (objOptString2 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf3 = (Boolean) objOptString2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            boolValueOf3 = Boolean.valueOf(jsonValue3.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            boolValueOf3 = (Boolean) Long.valueOf(jsonValue3.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
            boolValueOf3 = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            boolValueOf3 = (Boolean) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            boolValueOf3 = (Boolean) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
            boolValueOf3 = (Boolean) Integer.valueOf(jsonValue3.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
            boolValueOf3 = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            objOptList2 = jsonValue3.optList();
            if (objOptList2 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf3 = (Boolean) objOptList2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            objOptMap2 = jsonValue3.optMap();
            if (objOptMap2 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf3 = (Boolean) objOptMap2;
        } else {
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'isPushPrivacyFeatureEnabled" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            jsonValue4 = jsonValue3.getJsonValue();
            if (jsonValue4 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf3 = (Boolean) jsonValue4;
        }
        zBooleanValue3 = boolValueOf3.booleanValue();
        JsonMap jsonMapRequireMap10 = value.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap10, "requireMap(...)");
        jsonValue5 = jsonMapRequireMap10.get("isPushTokenRegistered");
        if (jsonValue5 != null) {
            throw new JsonException("Missing required field: 'isPushTokenRegistered" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
            objOptString8 = jsonValue5.optString();
            if (objOptString8 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf4 = (Boolean) objOptString8;
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            objOptString3 = jsonValue5.optString();
            if (objOptString3 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf4 = (Boolean) objOptString3;
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            boolValueOf4 = Boolean.valueOf(jsonValue5.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            boolValueOf4 = (Boolean) Long.valueOf(jsonValue5.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
            boolValueOf4 = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            boolValueOf4 = (Boolean) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            boolValueOf4 = (Boolean) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
            boolValueOf4 = (Boolean) Integer.valueOf(jsonValue5.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
            boolValueOf4 = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            objOptList3 = jsonValue5.optList();
            if (objOptList3 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf4 = (Boolean) objOptList3;
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            objOptMap3 = jsonValue5.optMap();
            if (objOptMap3 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf4 = (Boolean) objOptMap3;
        } else {
            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'isPushTokenRegistered" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            jsonValue6 = jsonValue5.getJsonValue();
            if (jsonValue6 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf4 = (Boolean) jsonValue6;
        }
        zBooleanValue4 = boolValueOf4.booleanValue();
        JsonMap jsonMapRequireMap11 = value.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap11, "requireMap(...)");
        jsonValue7 = jsonMapRequireMap11.get("isUserOptedIn");
        if (jsonValue7 != null) {
            throw new JsonException("Missing required field: 'isUserOptedIn" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Boolean.class);
        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
            objOptString7 = jsonValue7.optString();
            if (objOptString7 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf5 = (Boolean) objOptString7;
        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            objOptString4 = jsonValue7.optString();
            if (objOptString4 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf5 = (Boolean) objOptString4;
        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            boolValueOf5 = Boolean.valueOf(jsonValue7.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            boolValueOf5 = (Boolean) Long.valueOf(jsonValue7.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
            boolValueOf5 = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            boolValueOf5 = (Boolean) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            boolValueOf5 = (Boolean) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
            boolValueOf5 = (Boolean) Integer.valueOf(jsonValue7.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
            boolValueOf5 = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            objOptList4 = jsonValue7.optList();
            if (objOptList4 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf5 = (Boolean) objOptList4;
        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            objOptMap4 = jsonValue7.optMap();
            if (objOptMap4 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf5 = (Boolean) objOptMap4;
        } else {
            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'isUserOptedIn" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            jsonValue8 = jsonValue7.getJsonValue();
            if (jsonValue8 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf5 = (Boolean) jsonValue8;
        }
        zBooleanValue5 = boolValueOf5.booleanValue();
        JsonMap jsonMapRequireMap12 = value.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap12, "requireMap(...)");
        jsonValue9 = jsonMapRequireMap12.get("isOptedIn");
        if (jsonValue9 != null) {
            throw new JsonException("Missing required field: 'isOptedIn" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Boolean.class);
        if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
            objOptString6 = jsonValue9.optString();
            if (objOptString6 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf6 = (Boolean) objOptString6;
        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            objOptString5 = jsonValue9.optString();
            if (objOptString5 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf6 = (Boolean) objOptString5;
        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            boolValueOf6 = Boolean.valueOf(jsonValue9.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            boolValueOf6 = (Boolean) Long.valueOf(jsonValue9.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
            boolValueOf6 = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue9.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            boolValueOf6 = (Boolean) Double.valueOf(jsonValue9.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            boolValueOf6 = (Boolean) Float.valueOf(jsonValue9.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class))) {
            boolValueOf6 = (Boolean) Integer.valueOf(jsonValue9.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
            boolValueOf6 = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue9.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            objOptList5 = jsonValue9.optList();
            if (objOptList5 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf6 = (Boolean) objOptList5;
        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            objOptMap5 = jsonValue9.optMap();
            if (objOptMap5 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf6 = (Boolean) objOptMap5;
        } else {
            if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'isOptedIn" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            jsonValue10 = jsonValue9.getJsonValue();
            if (jsonValue10 != null) {
                throw new NullPointerException(str);
            }
            boolValueOf6 = (Boolean) jsonValue10;
        }
        boolean zBooleanValue7 = boolValueOf6.booleanValue();
        JsonMap jsonMapRequireMap13 = value.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap13, "requireMap(...)");
        jsonValue11 = jsonMapRequireMap13.get("notificationPermissionStatus");
        if (jsonValue11 == null) {
            strOptString = null;
        } else {
            orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(String.class);
            if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue11.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue11.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue11.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue11.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue11.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue11.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue11.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue11.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                strOptString = (String) jsonValue11.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                strOptString = (String) jsonValue11.optMap();
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'notificationPermissionStatus" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                strOptString = (String) jsonValue11.getJsonValue();
            }
        }
        this(zBooleanValue, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, zBooleanValue7, strOptString);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NotificationStatus(@NotNull PushNotificationStatus status, @Nullable String str) {
        this(status.getIsUserNotificationsEnabled(), status.getIsPushPermissionGranted(), status.getIsPushPrivacyFeatureEnabled(), status.getIsPushTokenRegistered(), status.isUserOptedIn(), status.isOptIn(), str);
        Intrinsics.checkNotNullParameter(status, "status");
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* JADX INFO: renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("isUserNotificationsEnabled", Boolean.valueOf(this.isUserNotificationsEnabled)), TuplesKt.m1842to("areNotificationsAllowed", Boolean.valueOf(this.areNotificationsAllowed)), TuplesKt.m1842to("isPushPrivacyFeatureEnabled", Boolean.valueOf(this.isPushPrivacyFeatureEnabled)), TuplesKt.m1842to("isPushTokenRegistered", Boolean.valueOf(this.isPushTokenRegistered)), TuplesKt.m1842to("isUserOptedIn", Boolean.valueOf(this.isUserOptedIn)), TuplesKt.m1842to("isOptedIn", Boolean.valueOf(this.isOptedIn)), TuplesKt.m1842to("notificationPermissionStatus", this.notificationPermissionStatus)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
