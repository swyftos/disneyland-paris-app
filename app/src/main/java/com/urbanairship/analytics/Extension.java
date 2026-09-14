package com.urbanairship.analytics;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, m1836d2 = {"Lcom/urbanairship/analytics/Extension;", "", "extensionName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getExtensionName$urbanairship_core_release", "()Ljava/lang/String;", "CORDOVA", "FLUTTER", "REACT_NATIVE", "UNITY", "XAMARIN", "DOT_NET", "TITANIUM", "CAPACITOR", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum Extension {
    CORDOVA("cordova"),
    FLUTTER("flutter"),
    REACT_NATIVE("react-native"),
    UNITY("unity"),
    XAMARIN("xamarin"),
    DOT_NET("dot-net"),
    TITANIUM("titanium"),
    CAPACITOR("capacitor");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String extensionName;

    @NotNull
    public static EnumEntries<Extension> getEntries() {
        return $ENTRIES;
    }

    Extension(String str) {
        this.extensionName = str;
    }

    @NotNull
    /* JADX INFO: renamed from: getExtensionName$urbanairship_core_release, reason: from getter */
    public final String getExtensionName() {
        return this.extensionName;
    }
}
