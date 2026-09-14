package coil3.content;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.common.MimeTypes;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: coil3.util.ContextsKt, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\n\u001a\u00020\t*\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0018\u00010\rR\u00020\fH\u0000¢\u0006\u0004\b\n\u0010\u000f\u001a%\u0010\u0011\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\"\u0018\u0010\u0018\u001a\u00020\u0000*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, m1836d2 = {"Landroid/content/Context;", "", "defaultMemoryCacheSizePercent", "(Landroid/content/Context;)D", "", "totalAvailableMemoryBytes", "(Landroid/content/Context;)J", "", "resId", "Landroid/graphics/drawable/Drawable;", "getDrawableCompat", "(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;", "Landroid/content/res/Resources;", "Landroid/content/res/Resources$Theme;", "theme", "(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;", "resources", "getXmlDrawableCompat", "(Landroid/content/Context;Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "(Landroid/content/Context;)Landroidx/lifecycle/Lifecycle;", "getApplication", "(Landroid/content/Context;)Landroid/content/Context;", MimeTypes.BASE_TYPE_APPLICATION, "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\ncontexts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 contexts.kt\ncoil3/util/ContextsKt\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n31#2:106\n31#2:107\n1#3:108\n*S KotlinDebug\n*F\n+ 1 contexts.kt\ncoil3/util/ContextsKt\n*L\n32#1:106\n43#1:107\n*E\n"})
public final class Context {
    @NotNull
    public static final android.content.Context getApplication(@NotNull android.content.Context context) {
        return context.getApplicationContext();
    }

    public static final double defaultMemoryCacheSizePercent(@NotNull android.content.Context context) {
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            Intrinsics.checkNotNull(systemService);
            return ((ActivityManager) systemService).isLowRamDevice() ? 0.15d : 0.2d;
        } catch (Exception unused) {
            return 0.2d;
        }
    }

    public static final long totalAvailableMemoryBytes(@NotNull android.content.Context context) {
        int largeMemoryClass;
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            Intrinsics.checkNotNull(systemService);
            ActivityManager activityManager = (ActivityManager) systemService;
            largeMemoryClass = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
        } catch (Exception unused) {
            largeMemoryClass = 256;
        }
        return ((long) largeMemoryClass) * 1048576;
    }

    @NotNull
    public static final Drawable getDrawableCompat(@NotNull android.content.Context context, @DrawableRes int i) {
        Drawable drawable = AppCompatResources.getDrawable(context, i);
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalStateException(("Invalid resource ID: " + i).toString());
    }

    @NotNull
    public static final Drawable getDrawableCompat(@NotNull Resources resources, @DrawableRes int i, @Nullable Resources.Theme theme) {
        Drawable drawable = ResourcesCompat.getDrawable(resources, i, theme);
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalStateException(("Invalid resource ID: " + i).toString());
    }

    @SuppressLint({"ResourceType"})
    @NotNull
    public static final Drawable getXmlDrawableCompat(@NotNull android.content.Context context, @NotNull Resources resources, @XmlRes @DrawableRes int i) throws XmlPullParserException, IOException {
        XmlResourceParser xml = resources.getXml(i);
        int next = xml.next();
        while (next != 2 && next != 1) {
            next = xml.next();
        }
        if (next != 2) {
            throw new XmlPullParserException("No start tag found.");
        }
        return getDrawableCompat(resources, i, context.getTheme());
    }

    @Nullable
    public static final Lifecycle getLifecycle(@Nullable android.content.Context context) {
        Object baseContext = context;
        while (!(baseContext instanceof LifecycleOwner)) {
            if (!(baseContext instanceof ContextWrapper)) {
                return null;
            }
            baseContext = ((ContextWrapper) baseContext).getBaseContext();
        }
        return ((LifecycleOwner) baseContext).getLifecycle();
    }
}
