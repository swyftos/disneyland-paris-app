package org.bouncycastle.math.field;

/* loaded from: classes6.dex */
public interface ExtensionField extends FiniteField {
    int getDegree();

    FiniteField getSubfield();
}
