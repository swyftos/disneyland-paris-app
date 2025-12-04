package androidx.test.espresso.action;

import android.view.View;

/* loaded from: classes2.dex */
final class TranslatedCoordinatesProvider implements CoordinatesProvider {
    final CoordinatesProvider coordinatesProvider;
    final float dx;
    final float dy;

    public TranslatedCoordinatesProvider(CoordinatesProvider coordinatesProvider, float f, float f2) {
        this.coordinatesProvider = coordinatesProvider;
        this.dx = f;
        this.dy = f2;
    }

    @Override // androidx.test.espresso.action.CoordinatesProvider
    public float[] calculateCoordinates(View view) {
        float[] fArrCalculateCoordinates = this.coordinatesProvider.calculateCoordinates(view);
        fArrCalculateCoordinates[0] = fArrCalculateCoordinates[0] + (this.dx * view.getWidth());
        fArrCalculateCoordinates[1] = fArrCalculateCoordinates[1] + (this.dy * view.getHeight());
        return fArrCalculateCoordinates;
    }
}
