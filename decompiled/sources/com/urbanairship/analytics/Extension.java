package com.urbanairship.analytics;

import com.dlp.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/analytics/Extension;", "", "extensionName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getExtensionName$urbanairship_core_release", "()Ljava/lang/String;", "CORDOVA", "FLUTTER", "REACT_NATIVE", BuildConfig.BUILD_LABEL, "XAMARIN", "DOT_NET", "TITANIUM", "CAPACITOR", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Extension {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Extension[] $VALUES;
    private final String extensionName;
    public static final Extension CORDOVA = new Extension("CORDOVA", 0, "cordova");
    public static final Extension FLUTTER = new Extension("FLUTTER", 1, "flutter");
    public static final Extension REACT_NATIVE = new Extension("REACT_NATIVE", 2, "react-native");
    public static final Extension UNITY = new Extension(BuildConfig.BUILD_LABEL, 3, "unity");
    public static final Extension XAMARIN = new Extension("XAMARIN", 4, "xamarin");
    public static final Extension DOT_NET = new Extension("DOT_NET", 5, "dot-net");
    public static final Extension TITANIUM = new Extension("TITANIUM", 6, "titanium");
    public static final Extension CAPACITOR = new Extension("CAPACITOR", 7, "capacitor");

    private static final /* synthetic */ Extension[] $values() {
        return new Extension[]{CORDOVA, FLUTTER, REACT_NATIVE, UNITY, XAMARIN, DOT_NET, TITANIUM, CAPACITOR};
    }

    @NotNull
    public static EnumEntries<Extension> getEntries() {
        return $ENTRIES;
    }

    public static Extension valueOf(String str) {
        return (Extension) Enum.valueOf(Extension.class, str);
    }

    public static Extension[] values() {
        return (Extension[]) $VALUES.clone();
    }

    private Extension(String str, int i, String str2) {
        this.extensionName = str2;
    }

    @NotNull
    /* renamed from: getExtensionName$urbanairship_core_release, reason: from getter */
    public final String getExtensionName() {
        return this.extensionName;
    }

    static {
        Extension[] extensionArr$values = $values();
        $VALUES = extensionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(extensionArr$values);
    }
}
