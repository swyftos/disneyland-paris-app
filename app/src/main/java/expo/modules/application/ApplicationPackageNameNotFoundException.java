package expo.modules.application;

import android.content.pm.PackageManager;
import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1836d2 = {"Lexpo/modules/application/ApplicationPackageNameNotFoundException;", "Lexpo/modules/kotlin/exception/CodedException;", "cause", "Landroid/content/pm/PackageManager$NameNotFoundException;", "<init>", "(Landroid/content/pm/PackageManager$NameNotFoundException;)V", "expo-application_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ApplicationPackageNameNotFoundException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationPackageNameNotFoundException(@NotNull PackageManager.NameNotFoundException cause) {
        super("Unable to get install time of this application. Could not get package info or package name.", cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
