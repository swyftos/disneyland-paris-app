package androidx.test.espresso.action;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
final class TranslatedCoordinatesProvider implements CoordinatesProvider {
    final CoordinatesProvider coordinatesProvider;

    /* JADX INFO: renamed from: dx */
    final float f160dx;

    /* JADX INFO: renamed from: dy */
    final float f161dy;

    public TranslatedCoordinatesProvider(CoordinatesProvider coordinatesProvider, float f, float f2) {
        this.coordinatesProvider = coordinatesProvider;
        this.f160dx = f;
        this.f161dy = f2;
    }

    @Override // androidx.test.espresso.action.CoordinatesProvider
    public float[] calculateCoordinates(View view) {
        float[] fArrCalculateCoordinates = this.coordinatesProvider.calculateCoordinates(view);
        fArrCalculateCoordinates[0] = fArrCalculateCoordinates[0] + (this.f160dx * view.getWidth());
        fArrCalculateCoordinates[1] = fArrCalculateCoordinates[1] + (this.f161dy * view.getHeight());
        return fArrCalculateCoordinates;
    }
}
