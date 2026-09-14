package expo.modules.constants;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.media3.common.C0740C;
import com.disney.p026id.android.OneIDRecoveryContext;
import com.urbanairship.deferred.DeferredApiClient;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.interfaces.constants.ConstantsInterface;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p163io.CloseableKt;
import org.apache.commons.p168io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0016\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010H\u0016J\u0016\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, m1836d2 = {"Lexpo/modules/constants/ConstantsService;", "Lexpo/modules/core/interfaces/InternalModule;", "Lexpo/modules/interfaces/constants/ConstantsInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "statusBarHeightInternal", "", "getStatusBarHeightInternal", "()I", "setStatusBarHeightInternal", "(I)V", OneIDRecoveryContext.SESSION_ID, "", "getExportedInterfaces", "", "Ljava/lang/Class;", "getConstants", "", "", "getAppScopeKey", "getDeviceName", "getStatusBarHeight", "getSystemVersion", "getSystemFonts", "appConfig", "getAppConfig", "()Ljava/lang/String;", "ExecutionEnvironment", "Companion", "expo-constants_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nConstantsService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConstantsService.kt\nexpo/modules/constants/ConstantsService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,97:1\n1#2:98\n*E\n"})
public class ConstantsService implements InternalModule, ConstantsInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private final String sessionId;
    private int statusBarHeightInternal;

    public ConstantsService(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Integer numValueOf = Integer.valueOf(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        numValueOf = numValueOf.intValue() <= 0 ? null : numValueOf;
        this.statusBarHeightInternal = numValueOf != null ? INSTANCE.convertPixelsToDp(context.getResources().getDimensionPixelSize(numValueOf.intValue()), context) : 0;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.sessionId = string;
    }

    public final int getStatusBarHeightInternal() {
        return this.statusBarHeightInternal;
    }

    public final void setStatusBarHeightInternal(int i) {
        this.statusBarHeightInternal = i;
    }

    @Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m1836d2 = {"Lexpo/modules/constants/ConstantsService$ExecutionEnvironment;", "", "string", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getString", "()Ljava/lang/String;", "BARE", "STANDALONE", "STORE_CLIENT", "expo-constants_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public enum ExecutionEnvironment {
        BARE("bare"),
        STANDALONE("standalone"),
        STORE_CLIENT("storeClient");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String string;

        @NotNull
        public static EnumEntries<ExecutionEnvironment> getEntries() {
            return $ENTRIES;
        }

        ExecutionEnvironment(String str) {
            this.string = str;
        }

        @NotNull
        public final String getString() {
            return this.string;
        }
    }

    @Override // expo.modules.core.interfaces.InternalModule
    @NotNull
    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(ConstantsInterface.class);
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    @NotNull
    public Map<String, Object> getConstants() {
        return MapsKt.mutableMapOf(TuplesKt.m1842to(OneIDRecoveryContext.SESSION_ID, this.sessionId), TuplesKt.m1842to("executionEnvironment", ExecutionEnvironment.BARE.getString()), TuplesKt.m1842to("statusBarHeight", Integer.valueOf(this.statusBarHeightInternal)), TuplesKt.m1842to("deviceName", getDeviceName()), TuplesKt.m1842to("systemFonts", getSystemFonts()), TuplesKt.m1842to("systemVersion", getSystemVersion()), TuplesKt.m1842to("manifest", getAppConfig()), TuplesKt.m1842to(DeferredApiClient.KEY_PLATFORM, MapsKt.mapOf(TuplesKt.m1842to("android", MapsKt.emptyMap()))));
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    @Nullable
    public String getAppScopeKey() {
        return this.context.getPackageName();
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    @NotNull
    public String getDeviceName() {
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        return MODEL;
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    /* JADX INFO: renamed from: getStatusBarHeight, reason: from getter */
    public int getStatusBarHeightInternal() {
        return this.statusBarHeightInternal;
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    @NotNull
    public String getSystemVersion() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        return RELEASE;
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    @NotNull
    public List<String> getSystemFonts() {
        return CollectionsKt.listOf((Object[]) new String[]{"normal", "notoserif", C0740C.SANS_SERIF_NAME, "sans-serif-light", "sans-serif-thin", "sans-serif-condensed", "sans-serif-medium", C0740C.SERIF_NAME, "Roboto", "monospace"});
    }

    private final String getAppConfig() {
        try {
            InputStream inputStreamOpen = this.context.getAssets().open("app.config");
            try {
                String string = IOUtils.toString(inputStreamOpen, StandardCharsets.UTF_8);
                CloseableKt.closeFinally(inputStreamOpen, null);
                return string;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpen, th);
                    throw th2;
                }
            }
        } catch (FileNotFoundException unused) {
            return null;
        } catch (Exception e) {
            Log.e(ConstantsServiceKt.TAG, "Error reading embedded app config", e);
            return null;
        }
    }

    @Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, m1836d2 = {"Lexpo/modules/constants/ConstantsService$Companion;", "", "<init>", "()V", "convertPixelsToDp", "", "px", "", "context", "Landroid/content/Context;", "expo-constants_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int convertPixelsToDp(float px, Context context) {
            return (int) (px / (context.getResources().getDisplayMetrics().densityDpi / 160.0f));
        }
    }
}
