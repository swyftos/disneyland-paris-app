package com.dlp;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'SWID' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0012"}, m1836d2 = {"Lcom/dlp/AppDynamicsMaskRule;", "", "regex", "Lkotlin/text/Regex;", "replacement", "", "<init>", "(Ljava/lang/String;ILkotlin/text/Regex;Ljava/lang/String;)V", "SWID", "BOOKING", "BOOKINGS", "PACKAGE", "PACKAGES", "RESERVATION", "RESERVATIONS", "apply", "input", "Companion", "1017160256_prod_fr.disneylandparis.android_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class AppDynamicsMaskRule {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AppDynamicsMaskRule[] $VALUES;
    public static final AppDynamicsMaskRule BOOKING;
    public static final AppDynamicsMaskRule BOOKINGS;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final AppDynamicsMaskRule PACKAGE;
    public static final AppDynamicsMaskRule PACKAGES;
    public static final AppDynamicsMaskRule RESERVATION;
    public static final AppDynamicsMaskRule RESERVATIONS;
    public static final AppDynamicsMaskRule SWID;
    private static final List defaultRules;
    private final Regex regex;
    private final String replacement;

    private static final /* synthetic */ AppDynamicsMaskRule[] $values() {
        return new AppDynamicsMaskRule[]{SWID, BOOKING, BOOKINGS, PACKAGE, PACKAGES, RESERVATION, RESERVATIONS};
    }

    @NotNull
    public static EnumEntries<AppDynamicsMaskRule> getEntries() {
        return $ENTRIES;
    }

    private AppDynamicsMaskRule(String str, int i, Regex regex, String str2) {
        super(str, i);
        this.regex = regex;
        this.replacement = str2;
    }

    static {
        RegexOption regexOption = RegexOption.IGNORE_CASE;
        AppDynamicsMaskRule appDynamicsMaskRule = new AppDynamicsMaskRule("SWID", 0, new Regex("%7B[A-F0-9]{8}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{12}%7D", regexOption), "********************");
        SWID = appDynamicsMaskRule;
        AppDynamicsMaskRule appDynamicsMaskRule2 = new AppDynamicsMaskRule("BOOKING", 1, new Regex("(?:^|/)booking/(?:\\d{8}|\\d{20,40})(?:/|$)", regexOption), "/booking/********/");
        BOOKING = appDynamicsMaskRule2;
        AppDynamicsMaskRule appDynamicsMaskRule3 = new AppDynamicsMaskRule("BOOKINGS", 2, new Regex("(?:^|/)bookings/(?:\\d{8}|\\d{20,40})(?:/|$)", regexOption), "/bookings/********/");
        BOOKINGS = appDynamicsMaskRule3;
        AppDynamicsMaskRule appDynamicsMaskRule4 = new AppDynamicsMaskRule("PACKAGE", 3, new Regex("(?:^|/)package/(?:\\d{8}|\\d{20,40})(?:/|$)", regexOption), "/package/********/");
        PACKAGE = appDynamicsMaskRule4;
        AppDynamicsMaskRule appDynamicsMaskRule5 = new AppDynamicsMaskRule("PACKAGES", 4, new Regex("(?:^|/)packages/(?:\\d{8}|\\d{20,40})(?:/|$)", regexOption), "/packages/********/");
        PACKAGES = appDynamicsMaskRule5;
        AppDynamicsMaskRule appDynamicsMaskRule6 = new AppDynamicsMaskRule("RESERVATION", 5, new Regex("(?:^|/)reservation/(?:\\d{8}|\\d{20,40})(?:/|$)", regexOption), "/reservation/********/");
        RESERVATION = appDynamicsMaskRule6;
        AppDynamicsMaskRule appDynamicsMaskRule7 = new AppDynamicsMaskRule("RESERVATIONS", 6, new Regex("(?:^|/)reservations/(?:\\d{8}|\\d{20,40})(?:/|$)", regexOption), "/reservations/********/");
        RESERVATIONS = appDynamicsMaskRule7;
        AppDynamicsMaskRule[] appDynamicsMaskRuleArr$values = $values();
        $VALUES = appDynamicsMaskRuleArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(appDynamicsMaskRuleArr$values);
        INSTANCE = new Companion(null);
        defaultRules = CollectionsKt.listOf((Object[]) new AppDynamicsMaskRule[]{appDynamicsMaskRule, appDynamicsMaskRule2, appDynamicsMaskRule3, appDynamicsMaskRule4, appDynamicsMaskRule5, appDynamicsMaskRule6, appDynamicsMaskRule7});
    }

    @NotNull
    public final String apply(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.regex.replace(input, this.replacement);
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1836d2 = {"Lcom/dlp/AppDynamicsMaskRule$Companion;", "", "<init>", "()V", "defaultRules", "", "Lcom/dlp/AppDynamicsMaskRule;", "getDefaultRules", "()Ljava/util/List;", "1017160256_prod_fr.disneylandparis.android_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final List<AppDynamicsMaskRule> getDefaultRules() {
            return AppDynamicsMaskRule.defaultRules;
        }
    }

    public static AppDynamicsMaskRule valueOf(String str) {
        return (AppDynamicsMaskRule) Enum.valueOf(AppDynamicsMaskRule.class, str);
    }

    public static AppDynamicsMaskRule[] values() {
        return (AppDynamicsMaskRule[]) $VALUES.clone();
    }
}
