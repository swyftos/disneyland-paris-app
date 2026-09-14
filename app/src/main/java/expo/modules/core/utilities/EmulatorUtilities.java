package expo.modules.core.utilities;

import android.os.Build;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m1836d2 = {"Lexpo/modules/core/utilities/EmulatorUtilities;", "", "<init>", "()V", "isRunningOnEmulator", "", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class EmulatorUtilities {

    @NotNull
    public static final EmulatorUtilities INSTANCE = new EmulatorUtilities();

    private EmulatorUtilities() {
    }

    public final boolean isRunningOnEmulator() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
            if (!StringsKt.startsWith$default(FINGERPRINT, "unknown", false, 2, (Object) null)) {
                String MODEL = Build.MODEL;
                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                    Locale ROOT = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                    String lowerCase = MODEL.toLowerCase(ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "droid4x", false, 2, (Object) null)) {
                        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                        if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Emulator", false, 2, (Object) null)) {
                            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                            if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                String MANUFACTURER = Build.MANUFACTURER;
                                Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                    String HARDWARE = Build.HARDWARE;
                                    Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
                                    if (!StringsKt.contains$default((CharSequence) HARDWARE, (CharSequence) "goldfish", false, 2, (Object) null)) {
                                        Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
                                        if (!StringsKt.contains$default((CharSequence) HARDWARE, (CharSequence) "ranchu", false, 2, (Object) null)) {
                                            Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
                                            if (!StringsKt.contains$default((CharSequence) HARDWARE, (CharSequence) "vbox86", false, 2, (Object) null)) {
                                                String PRODUCT = Build.PRODUCT;
                                                Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "sdk", false, 2, (Object) null)) {
                                                    Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                    if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                        if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "sdk_google", false, 2, (Object) null)) {
                                                            Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                            if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "sdk_x86", false, 2, (Object) null)) {
                                                                Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                                if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "vbox86p", false, 2, (Object) null)) {
                                                                    Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                                    if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "emulator", false, 2, (Object) null)) {
                                                                        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                                        if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "simulator", false, 2, (Object) null)) {
                                                                            String BOARD = Build.BOARD;
                                                                            Intrinsics.checkNotNullExpressionValue(BOARD, "BOARD");
                                                                            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                                                                            String lowerCase2 = BOARD.toLowerCase(ROOT);
                                                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                                                            if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "nox", false, 2, (Object) null)) {
                                                                                String BOOTLOADER = Build.BOOTLOADER;
                                                                                Intrinsics.checkNotNullExpressionValue(BOOTLOADER, "BOOTLOADER");
                                                                                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                                                                                String lowerCase3 = BOOTLOADER.toLowerCase(ROOT);
                                                                                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                                                                if (!StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "nox", false, 2, (Object) null)) {
                                                                                    Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
                                                                                    Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                                                                                    String lowerCase4 = HARDWARE.toLowerCase(ROOT);
                                                                                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                                                                    if (!StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) "nox", false, 2, (Object) null)) {
                                                                                        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                                                                        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                                                                                        String lowerCase5 = PRODUCT.toLowerCase(ROOT);
                                                                                        Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                                                                                        if (!StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) "nox", false, 2, (Object) null)) {
                                                                                            String BRAND = Build.BRAND;
                                                                                            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                                            if (!StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                                                return false;
                                                                                            }
                                                                                            String DEVICE = Build.DEVICE;
                                                                                            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                                            if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                                                return false;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
