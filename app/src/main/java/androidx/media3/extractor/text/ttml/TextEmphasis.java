package androidx.media3.extractor.text.ttml;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.urbanairship.actions.PromptPermissionAction;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* JADX INFO: loaded from: classes.dex */
final class TextEmphasis {
    public final int markFill;
    public final int markShape;
    public final int position;
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
    private static final ImmutableSet SINGLE_STYLE_VALUES = ImmutableSet.m1565of("auto", "none");
    private static final ImmutableSet MARK_SHAPE_VALUES = ImmutableSet.m1566of("dot", "sesame", "circle");
    private static final ImmutableSet MARK_FILL_VALUES = ImmutableSet.m1565of("filled", AbstractCircuitBreaker.PROPERTY_NAME);
    private static final ImmutableSet POSITION_VALUES = ImmutableSet.m1566of(PromptPermissionAction.AFTER_PERMISSION_STATUS_RESULT_KEY, PromptPermissionAction.BEFORE_PERMISSION_STATUS_RESULT_KEY, "outside");

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    private TextEmphasis(int i, int i2, int i3) {
        this.markShape = i;
        this.markFill = i2;
        this.position = i3;
    }

    public static TextEmphasis parse(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = Ascii.toLowerCase(str.trim());
        if (lowerCase.isEmpty()) {
            return null;
        }
        return parseWords(ImmutableSet.copyOf(TextUtils.split(lowerCase, WHITESPACE_PATTERN)));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    /* JADX WARN: Code duplicated, block: B:55:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:68:0x0100  */
    /* JADX WARN: Code duplicated, block: B:69:0x0102  */
    /* JADX WARN: Code duplicated, block: B:71:0x0105 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0107  */
    /* JADX WARN: Code duplicated, block: B:73:0x0109  */
    private static TextEmphasis parseWords(ImmutableSet immutableSet) {
        byte b;
        int i;
        int i2;
        String str;
        int iHashCode;
        String str2 = (String) Iterables.getFirst(Sets.intersection(POSITION_VALUES, immutableSet), "outside");
        int iHashCode2 = str2.hashCode();
        int i3 = 2;
        byte b2 = 0;
        int i4 = -1;
        if (iHashCode2 != -1392885889) {
            if (iHashCode2 != -1106037339) {
                if (iHashCode2 == 92734940 && str2.equals(PromptPermissionAction.AFTER_PERMISSION_STATUS_RESULT_KEY)) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str2.equals("outside")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str2.equals(PromptPermissionAction.BEFORE_PERMISSION_STATUS_RESULT_KEY)) {
            b = 2;
        } else {
            b = -1;
        }
        if (b != 0) {
            i = b != 1 ? 1 : -2;
        } else {
            i = 2;
        }
        Sets.SetView setViewIntersection = Sets.intersection(SINGLE_STYLE_VALUES, immutableSet);
        if (!setViewIntersection.isEmpty()) {
            String str3 = (String) setViewIntersection.iterator().next();
            int iHashCode3 = str3.hashCode();
            if (iHashCode3 == 3005871) {
                str3.equals("auto");
            } else if (iHashCode3 == 3387192 && str3.equals("none")) {
                i4 = 0;
            }
            return new TextEmphasis(i4, 0, i);
        }
        Sets.SetView setViewIntersection2 = Sets.intersection(MARK_FILL_VALUES, immutableSet);
        Sets.SetView setViewIntersection3 = Sets.intersection(MARK_SHAPE_VALUES, immutableSet);
        if (setViewIntersection2.isEmpty() && setViewIntersection3.isEmpty()) {
            return new TextEmphasis(-1, 0, i);
        }
        String str4 = (String) Iterables.getFirst(setViewIntersection2, "filled");
        int iHashCode4 = str4.hashCode();
        if (iHashCode4 == -1274499742) {
            str4.equals("filled");
        } else {
            if (iHashCode4 == 3417674 && str4.equals(AbstractCircuitBreaker.PROPERTY_NAME)) {
                i2 = 2;
            }
            str = (String) Iterables.getFirst(setViewIntersection3, "circle");
            iHashCode = str.hashCode();
            if (iHashCode != -1360216880) {
                if (iHashCode != -905816648) {
                    if (iHashCode == 99657 || !str.equals("dot")) {
                        b2 = -1;
                    }
                } else if (str.equals("sesame")) {
                    b2 = 1;
                } else {
                    b2 = -1;
                }
            } else if (str.equals("circle")) {
                b2 = 2;
            } else {
                b2 = -1;
            }
            if (b2 != 0) {
                if (b2 != 1) {
                    i3 = 1;
                } else {
                    i3 = 3;
                }
            }
            return new TextEmphasis(i3, i2, i);
        }
        i2 = 1;
        str = (String) Iterables.getFirst(setViewIntersection3, "circle");
        iHashCode = str.hashCode();
        if (iHashCode != -1360216880) {
            if (iHashCode != -905816648) {
                if (iHashCode == 99657) {
                    b2 = -1;
                } else {
                    b2 = -1;
                }
            } else if (str.equals("sesame")) {
                b2 = 1;
            } else {
                b2 = -1;
            }
        } else if (str.equals("circle")) {
            b2 = 2;
        } else {
            b2 = -1;
        }
        if (b2 != 0) {
            if (b2 != 1) {
                i3 = 1;
            } else {
                i3 = 3;
            }
        }
        return new TextEmphasis(i3, i2, i);
    }
}
