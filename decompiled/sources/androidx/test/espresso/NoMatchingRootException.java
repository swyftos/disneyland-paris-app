package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.internal.platform.util.TestOutputEmitter;
import java.util.List;
import java.util.Locale;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
public final class NoMatchingRootException extends RuntimeException implements EspressoException {
    private NoMatchingRootException(String str) {
        super(str);
        TestOutputEmitter.dumpThreadStates("ThreadState-NoMatchingRootException.txt");
    }

    public static NoMatchingRootException create(Matcher<Root> matcher, List<Root> list) {
        Preconditions.checkNotNull(matcher);
        Preconditions.checkNotNull(list);
        return new NoMatchingRootException(String.format(Locale.ROOT, "Matcher '%s' did not match any of the following roots: %s", matcher, list));
    }
}
