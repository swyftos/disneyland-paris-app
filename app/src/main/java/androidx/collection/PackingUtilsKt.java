package androidx.collection;

import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes.dex */
@Metadata(m1835d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b\u001a\u0019\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0006H\u0080\b¨\u0006\u0007"}, m1836d2 = {"packFloats", "", "val1", "", "val2", "packInts", "", "collection"}, m1837k = 2, m1838mv = {1, 8, 0}, m1840xi = 48)
public final class PackingUtilsKt {
    public static final long packInts(int i, int i2) {
        return (((long) i2) & BodyPartID.bodyIdMax) | (((long) i) << 32);
    }

    public static final long packFloats(float f, float f2) {
        return (((long) Float.floatToRawIntBits(f2)) & BodyPartID.bodyIdMax) | (Float.floatToRawIntBits(f) << 32);
    }
}
