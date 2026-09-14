package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.SparseIntArray;
import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.u4 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nRecyclableViewAppearance.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecyclableViewAppearance.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/viewappearance/RecyclableViewAppearance\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,190:1\n117#2:191\n*S KotlinDebug\n*F\n+ 1 RecyclableViewAppearance.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/viewappearance/RecyclableViewAppearance\n*L\n133#1:191\n*E\n"})
public final class C2895u4 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2875s4 f3142a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2570N3 f3143b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2701b0 f3144c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final C2654W f3145d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final C2731e0.a f3146e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final C2663X f3147f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final C2681Z f3148g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final C2849p8 f3149h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final C2885t4 f3150i;

    public C2895u4() {
        C2875s4 recyclableBitmapScale = new C2875s4();
        C2570N3 perceptualHashGenerator = new C2570N3();
        C2701b0 bitmapHashCache = new C2701b0();
        C2654W bitmapChangeDetector = new C2654W(0);
        C2731e0.a bitmapPixelFactory = new C2731e0.a();
        C2663X bitmapColorAnalyzer = new C2663X();
        C2681Z bitmapCompressor = new C2681Z();
        C2849p8 viewMasker = new C2849p8();
        C2885t4 reduceBorderBetweenViews = new C2885t4();
        Intrinsics.checkNotNullParameter(recyclableBitmapScale, "recyclableBitmapScale");
        Intrinsics.checkNotNullParameter(perceptualHashGenerator, "perceptualHashGenerator");
        Intrinsics.checkNotNullParameter(bitmapHashCache, "bitmapHashCache");
        Intrinsics.checkNotNullParameter(bitmapChangeDetector, "bitmapChangeDetector");
        Intrinsics.checkNotNullParameter(bitmapPixelFactory, "bitmapPixelFactory");
        Intrinsics.checkNotNullParameter(bitmapColorAnalyzer, "bitmapColorAnalyzer");
        Intrinsics.checkNotNullParameter(bitmapCompressor, "bitmapCompressor");
        Intrinsics.checkNotNullParameter(viewMasker, "viewMasker");
        Intrinsics.checkNotNullParameter(reduceBorderBetweenViews, "reduceBorderBetweenViews");
        this.f3142a = recyclableBitmapScale;
        this.f3143b = perceptualHashGenerator;
        this.f3144c = bitmapHashCache;
        this.f3145d = bitmapChangeDetector;
        this.f3146e = bitmapPixelFactory;
        this.f3147f = bitmapColorAnalyzer;
        this.f3148g = bitmapCompressor;
        this.f3149h = viewMasker;
        this.f3150i = reduceBorderBetweenViews;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x03d2  */
    /* JADX INFO: renamed from: a */
    public final void m1207a(ViewLight viewLight, C2630T4.d dVar) {
        C2531J4 c2531j4;
        byte[] byteArray;
        int i;
        int i2;
        int i3;
        C2531J4 c2531j5;
        ViewLight view = viewLight;
        int i4 = 0;
        if (viewLight.getIsTransparent()) {
            view.setBackgroundColor(0);
            view.setViewBitmapHash(null);
            view.setEncodedBitmap(null);
            return;
        }
        dVar.getClass();
        Intrinsics.checkNotNullParameter(view, "view");
        int iRoundToInt = MathKt.roundToInt(viewLight.getPosX() / dVar.f2151c);
        int iRoundToInt2 = MathKt.roundToInt(viewLight.getPosY() / dVar.f2151c);
        int iRoundToInt3 = MathKt.roundToInt(viewLight.getWidth() / dVar.f2151c);
        int iRoundToInt4 = MathKt.roundToInt(viewLight.getHeight() / dVar.f2151c);
        C2531J4 c2531j6 = dVar.f2150b;
        Bitmap bitmapSource = dVar.f2149a.f1746c;
        c2531j6.getClass();
        Intrinsics.checkNotNullParameter(bitmapSource, "bitmapSource");
        c2531j6.m956a(iRoundToInt3, iRoundToInt4);
        int i5 = iRoundToInt + iRoundToInt3;
        int i6 = iRoundToInt2 + iRoundToInt4;
        c2531j6.f1749f.set(iRoundToInt, iRoundToInt2, i5, i6);
        c2531j6.f1750g.set(0, 0, iRoundToInt3, iRoundToInt4);
        c2531j6.f1745b.drawBitmap(bitmapSource, c2531j6.f1749f, c2531j6.f1750g, c2531j6.f1747d);
        C2531J4 c2531j7 = dVar.f2149a;
        c2531j7.f1745b.drawRect(iRoundToInt, iRoundToInt2, i5, i6, c2531j7.f1748e);
        Bitmap viewBitmap = dVar.f2150b.f1746c;
        CharSequence text = viewLight.getText();
        char c = 3;
        int i7 = 1;
        boolean z = text != null && text.length() <= 3;
        int i8 = z ? 4 : 8;
        int i9 = z ? 4 : 8;
        C2875s4 c2875s4 = this.f3142a;
        int iMin = Math.min(i8, viewBitmap.getWidth());
        int iMin2 = Math.min(i9, viewBitmap.getHeight());
        c2875s4.getClass();
        Intrinsics.checkNotNullParameter(viewBitmap, "bitmapSource");
        int width = viewBitmap.getWidth();
        int height = viewBitmap.getHeight();
        c2875s4.f3100c = 0;
        if (width > iMin || height > iMin2) {
            while (true) {
                if (width == iMin && height == iMin2) {
                    break;
                }
                ViewLight viewLight2 = view;
                char c2 = c;
                width = Math.max(width / 2, iMin);
                height = Math.max(height / 2, iMin2);
                int i10 = c2875s4.f3100c;
                if (c2875s4.f3099b.size() > i10) {
                    c2531j4 = (C2531J4) c2875s4.f3099b.get(i10);
                    c2531j4.m956a(width, height);
                } else {
                    c2875s4.f3098a.getClass();
                    c2531j4 = new C2531J4(width, height);
                }
                int i11 = c2875s4.f3100c;
                Bitmap bitmapSource2 = i11 == 0 ? viewBitmap : ((C2531J4) c2875s4.f3099b.get(i11 - 1)).f1746c;
                Paint paint = c2875s4.f3101d;
                Intrinsics.checkNotNullParameter(bitmapSource2, "bitmapSource");
                Intrinsics.checkNotNullParameter(paint, "paint");
                c2531j4.m956a(width, height);
                c2531j4.f1750g.set(0, 0, width, height);
                c2531j4.f1745b.drawBitmap(bitmapSource2, (Rect) null, c2531j4.f1750g, paint);
                int size = c2875s4.f3099b.size();
                int i12 = c2875s4.f3100c;
                if (size > i12) {
                    c2875s4.f3099b.set(i12, c2531j4);
                } else {
                    c2875s4.f3099b.add(c2531j4);
                }
                c2875s4.f3100c++;
                view = viewLight2;
                c = c2;
                i4 = 0;
                i7 = 1;
            }
        } else {
            if (c2875s4.f3099b.size() > 0) {
                c2531j5 = (C2531J4) c2875s4.f3099b.get(0);
                c2531j5.m956a(iMin, iMin2);
            } else {
                c2875s4.f3098a.getClass();
                c2531j5 = new C2531J4(iMin, iMin2);
            }
            Intrinsics.checkNotNullParameter(viewBitmap, "bitmapSource");
            Paint paint2 = c2531j5.f1747d;
            Intrinsics.checkNotNullParameter(viewBitmap, "bitmapSource");
            Intrinsics.checkNotNullParameter(paint2, "paint");
            c2531j5.m956a(iMin, iMin2);
            c2531j5.f1750g.set(0, 0, iMin, iMin2);
            c2531j5.f1745b.drawBitmap(viewBitmap, (Rect) null, c2531j5.f1750g, paint2);
            int size2 = c2875s4.f3099b.size();
            int i13 = c2875s4.f3100c;
            if (size2 > i13) {
                c2875s4.f3099b.set(i13, c2531j5);
            } else {
                c2875s4.f3099b.add(c2531j5);
            }
            c2875s4.f3100c++;
        }
        C2731e0.a aVar = this.f3146e;
        C2875s4 c2875s5 = this.f3142a;
        Bitmap bitmap = ((C2531J4) c2875s5.f3099b.get(c2875s5.f3100c - i7)).f1746c;
        C2663X bitmapColorAnalyzer = this.f3147f;
        aVar.getClass();
        String str = "bitmap";
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(bitmapColorAnalyzer, "bitmapColorAnalyzer");
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        int i14 = width2 * height2;
        int[] pixels = new int[i14];
        bitmap.getPixels(pixels, 0, width2, 0, 0, width2, height2);
        bitmapColorAnalyzer.getClass();
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        bitmapColorAnalyzer.f2230a.clear();
        float f = BitmapDescriptorFactory.HUE_RED;
        int i15 = i4;
        int i16 = i15;
        int i17 = i16;
        int i18 = i17;
        int i19 = i18;
        int i20 = i19;
        while (i16 < i14) {
            int i21 = pixels[i16];
            int i22 = i21 >>> 24;
            String str2 = str;
            i20 = (((i21 >> 16) & 255) * i22) + i20;
            i19 = (((i21 >> 8) & 255) * i22) + i19;
            i18 += (i21 & 255) * i22;
            i17 += i22;
            i15 += i22;
            if (i22 == 0) {
                f += 1.0f;
            }
            if (i22 == 255) {
                SparseIntArray sparseIntArray = bitmapColorAnalyzer.f2230a;
                i3 = 1;
                sparseIntArray.put(i21, sparseIntArray.get(i21) + 1);
            } else {
                i3 = 1;
            }
            i16++;
            i7 = i3;
            str = str2;
        }
        String str3 = str;
        int i23 = i7;
        int iMax = Math.max(i15, i23);
        int iMax2 = Math.max(i14, i23);
        int i24 = ((i17 / iMax2) << 24) | ((i20 / iMax) << 16) | ((i19 / iMax) << 8) | (i18 / iMax);
        bitmapColorAnalyzer.f2231b = f / iMax2;
        C2731e0 bitmapPixel = new C2731e0(pixels, i24, bitmapColorAnalyzer.f2230a.size(), bitmapColorAnalyzer.f2231b);
        C2885t4 c2885t4 = this.f3150i;
        c2885t4.getClass();
        Intrinsics.checkNotNullParameter(viewBitmap, "viewBitmap");
        Intrinsics.checkNotNullParameter(bitmapPixel, "bitmapPixel");
        int i25 = i24 | (-16777216);
        int i26 = (i24 >> 24) & 255;
        if (i26 != 0 && i26 != 255) {
            C2531J4 c2531j8 = c2885t4.f3110a;
            int width3 = viewBitmap.getWidth();
            int height3 = viewBitmap.getHeight();
            c2531j8.getClass();
            Intrinsics.checkNotNullParameter(viewBitmap, "bitmapSource");
            c2531j8.m956a(width3, height3);
            c2531j8.f1746c.eraseColor(i25);
            c2531j8.f1750g.set(0, 0, width3, height3);
            c2531j8.f1745b.drawBitmap(viewBitmap, (Rect) null, c2531j8.f1750g, c2531j8.f1747d);
            viewBitmap = c2885t4.f3110a.f1746c;
        }
        C2849p8 c2849p8 = this.f3149h;
        C2875s4 recyclableBitmapScale = this.f3142a;
        c2849p8.getClass();
        Intrinsics.checkNotNullParameter(viewBitmap, "viewBitmap");
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        Intrinsics.checkNotNullParameter(recyclableBitmapScale, "recyclableBitmapScale");
        if (viewLight.getIsMasked()) {
            viewBitmap = ((C2531J4) recyclableBitmapScale.f3099b.get(Math.min(viewLight.getText() == null ? 4 : 2, recyclableBitmapScale.f3100c - 1))).f1746c;
        }
        this.f3143b.getClass();
        Intrinsics.checkNotNullParameter(bitmapPixel, "bitmapPixel");
        int i27 = 255;
        int i28 = ((((i24 >> 16) & 255) + ((i24 >> 8) & 255)) + (i24 & 255)) / 3;
        int i29 = 0;
        long jM5337constructorimpl = 0;
        long jM5337constructorimpl2 = 0;
        while (i29 < i14) {
            int i30 = pixels[i29];
            int i31 = ((((i30 >> 16) & i27) + ((i30 >> 8) & i27)) + (i30 & 255)) / 3;
            jM5337constructorimpl = ULong.m5337constructorimpl(jM5337constructorimpl + (((i30 >> 24) & i27) > i26 ? ULong.m5337constructorimpl(1 << i29) : 0L));
            jM5337constructorimpl2 = ULong.m5337constructorimpl(jM5337constructorimpl2 + (i31 > i28 ? ULong.m5337constructorimpl(1 << i29) : 0L));
            i29++;
            i27 = 255;
        }
        int i32 = bitmapPixel.f2567a;
        C2691a0 bitmapHash = new C2691a0(new C2560M3(jM5337constructorimpl, jM5337constructorimpl2, i32), viewLight, viewBitmap);
        viewLight.setViewBitmapHash(bitmapHash.f2356g);
        C2654W c2654w = this.f3145d;
        c2654w.getClass();
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        Intrinsics.checkNotNullParameter(bitmapHash, "currentBitmapHash");
        C2691a0 c2691a0 = c2654w.f2196a.get(viewLight.getRecordingId());
        if (c2691a0 != null) {
            Intrinsics.checkNotNullParameter(bitmapHash, "otherBitmapHash");
            boolean z2 = bitmapHash.f2353d == c2691a0.f2353d;
            if (c2691a0.f2351b != bitmapHash.f2351b || c2691a0.f2352c != bitmapHash.f2352c) {
                z2 = false;
            }
            int i33 = c2691a0.f2350a.f1859c;
            if (Math.abs(((i33 >> 24) & 255) - ((i32 >> 24) & 255)) > 8 || Math.abs(((i33 >> 16) & 255) - ((i32 >> 16) & 255)) > 8 || Math.abs(((i33 >> 8) & 255) - ((i32 >> 8) & 255)) > 8 || Math.abs((i33 & 255) - (i32 & 255)) > 8) {
                z2 = false;
            }
            if (!Intrinsics.areEqual(c2691a0.f2355f, bitmapHash.f2355f) || !Intrinsics.areEqual(c2691a0.f2354e, bitmapHash.f2354e)) {
                z2 = false;
            }
            long j = c2691a0.f2350a.f1857a;
            int i34 = 0;
            int iM5337constructorimpl = 0;
            while (true) {
                if (i34 >= 64) {
                    break;
                }
                iM5337constructorimpl += (int) ULong.m5337constructorimpl(ULong.m5337constructorimpl(ULong.m5337constructorimpl(j >>> i34) & 1) ^ ULong.m5337constructorimpl(ULong.m5337constructorimpl(jM5337constructorimpl >>> i34) & 1));
                i34++;
            }
            if (iM5337constructorimpl <= 16) {
                long j2 = c2691a0.f2350a.f1858b;
                int i35 = 0;
                int iM5337constructorimpl2 = 0;
                for (i2 = 64; i35 < i2; i2 = 64) {
                    iM5337constructorimpl2 += (int) ULong.m5337constructorimpl(ULong.m5337constructorimpl(ULong.m5337constructorimpl(j2 >>> i35) & 1) ^ ULong.m5337constructorimpl(ULong.m5337constructorimpl(jM5337constructorimpl2 >>> i35) & 1));
                    i35++;
                }
                if (iM5337constructorimpl2 > 16) {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                bitmapHash = c2691a0;
            } else {
                viewLight.setBitmapHashChanged(true);
            }
        }
        viewLight.setViewBitmapHash(bitmapHash.f2356g);
        long recordingId = viewLight.getRecordingId();
        Intrinsics.checkNotNullParameter(bitmapHash, "bitmapHash");
        c2654w.f2197b.put(recordingId, bitmapHash);
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        Intrinsics.checkNotNullParameter(bitmapPixel, "bitmapPixel");
        viewLight.setVisibilityPercentage((1.0f - bitmapPixel.f2569c) * (1.0f - viewLight.getClippedPercentage()));
        if (bitmapPixel.f2568b == 1) {
            viewLight.setBackgroundColor(bitmapPixel.f2567a | (-16777216));
            viewLight.setViewBitmapHash(null);
            viewLight.setEncodedBitmap(null);
            return;
        }
        if (((bitmapPixel.f2567a >> 24) & 255) == 0) {
            viewLight.setBackgroundColor(0);
            viewLight.setViewBitmapHash(null);
            viewLight.setEncodedBitmap(null);
            return;
        }
        String bitmapHash2 = viewLight.getViewBitmapHash();
        if (bitmapHash2 != null) {
            C2701b0 c2701b0 = this.f3144c;
            c2701b0.getClass();
            Intrinsics.checkNotNullParameter(bitmapHash2, "bitmapHash");
            if (c2701b0.f2398a.get(bitmapHash2) != null) {
                viewLight.setEncodedBitmap(null);
                return;
            }
            C2681Z c2681z = this.f3148g;
            c2681z.getClass();
            Intrinsics.checkNotNullParameter(viewLight, "viewLight");
            Intrinsics.checkNotNullParameter(viewBitmap, str3);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int iM1254a = C2949z8.m1254a(viewLight.getVisibilityPercentage() == 1.0f ? 1 : 2);
            try {
                if (iM1254a != 0) {
                    i = iM1254a == 1 ? 0 : 10;
                    byteArrayOutputStream.flush();
                    byteArray = byteArrayOutputStream.toByteArray();
                    viewLight.setEncodedBitmap(byteArray);
                    C2701b0 c2701b1 = this.f3144c;
                    c2701b1.getClass();
                    Intrinsics.checkNotNullParameter(bitmapHash2, "bitmapHash");
                    c2701b1.f2398a.put(bitmapHash2, Boolean.TRUE);
                }
                byteArrayOutputStream.flush();
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                C2599Q2.m1011a(c2681z.f2312a, "Cannot encode bitmap", e);
                byteArray = null;
            }
            C2681Z.m1075a(viewBitmap, i, byteArrayOutputStream);
            viewLight.setEncodedBitmap(byteArray);
            C2701b0 c2701b2 = this.f3144c;
            c2701b2.getClass();
            Intrinsics.checkNotNullParameter(bitmapHash2, "bitmapHash");
            c2701b2.f2398a.put(bitmapHash2, Boolean.TRUE);
        }
    }
}
