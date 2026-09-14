package com.appdynamics.eumagent.runtime.p192private;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.contentsquare.android.api.Currencies;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bg */
/* JADX INFO: loaded from: classes2.dex */
public final class C2084bg implements C2063am.b {

    /* JADX INFO: renamed from: a */
    final C2063am f652a;

    /* JADX INFO: renamed from: b */
    final Handler f653b;

    /* JADX INFO: renamed from: c */
    final C2138q f654c;

    /* JADX INFO: renamed from: d */
    C2127f f655d;

    /* JADX INFO: renamed from: e */
    volatile boolean f656e;

    public C2084bg(C2063am c2063am, C2138q c2138q, C2127f c2127f) {
        this(c2063am, new Handler(Looper.getMainLooper()), c2138q, c2127f);
    }

    private C2084bg(C2063am c2063am, Handler handler, C2138q c2138q, C2127f c2127f) {
        this.f656e = false;
        this.f652a = c2063am;
        this.f653b = handler;
        this.f654c = c2138q;
        this.f655d = c2127f;
        c2063am.f535a.m656a(a.class, this);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.C2063am.b
    /* JADX INFO: renamed from: a */
    public final void mo484a(Object obj) {
        int iMin;
        int i;
        if (obj instanceof a) {
            ADLog.logVerbose("Constructing tiles from capturedDrawingCache");
            a aVar = (a) obj;
            int width = aVar.f659a.getWidth();
            int height = aVar.f659a.getHeight();
            if (height > width) {
                iMin = Math.min(width, Currencies.GTQ);
                i = (int) (((double) height) * (((double) iMin) / ((double) width)));
            } else {
                int iMin2 = Math.min(height, Currencies.GTQ);
                iMin = (int) (((double) width) * (((double) iMin2) / ((double) height)));
                i = iMin2;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(aVar.f659a, iMin, i, true);
            Bitmap[] bitmapArr = new Bitmap[16];
            int width2 = bitmapCreateScaledBitmap.getWidth();
            int height2 = bitmapCreateScaledBitmap.getHeight();
            int i2 = width2 / 4;
            int i3 = height2 / 4;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = 4;
                if (i4 >= 4) {
                    break;
                }
                int i7 = i4 * i3;
                int i8 = 3;
                int i9 = i4 < 3 ? i3 : height2 - i7;
                int i10 = 0;
                while (i10 < i6) {
                    int i11 = i10 * i2;
                    bitmapArr[i5] = Bitmap.createBitmap(bitmapCreateScaledBitmap, i11, i7, i10 < i8 ? i2 : width2 - i11, i9);
                    i10++;
                    i5++;
                    i6 = 4;
                    i8 = 3;
                }
                i4++;
            }
            String[] strArr = new String[16];
            for (int i12 = 0; i12 < 16; i12++) {
                strArr[i12] = m594a(bitmapArr[i12]);
            }
            this.f652a.m562a(new C2083bf(bitmapArr, strArr, iMin, i));
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m594a(Bitmap bitmap) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((bitmap.getWidth() * bitmap.getHeight()) << 2);
            bitmap.copyPixelsToBuffer(byteBufferAllocate);
            byteBufferAllocate.rewind();
            messageDigest.update(byteBufferAllocate);
            return C2124ct.m659a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Cannot hash tiles", e);
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bg$a */
    protected static class a {

        /* JADX INFO: renamed from: a */
        final Bitmap f659a;

        a(Bitmap bitmap) {
            this.f659a = bitmap;
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bg$b */
    class b implements Runnable {

        /* JADX INFO: renamed from: a */
        private final View f660a;

        b(View view) {
            this.f660a = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                C2084bg.this.f656e = false;
                if (C2084bg.this.f654c.m708a()) {
                    if (C2084bg.this.f654c.f902a.f907b.booleanValue() || !C2084bg.this.f655d.m690b()) {
                        ADLog.logVerbose("Taking screenshot");
                        final C2084bg c2084bg = C2084bg.this;
                        View view = this.f660a;
                        ADLog.logAgentError("rootView " + view.getClass());
                        if (view instanceof SurfaceView) {
                            final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                            PixelCopy.request((SurfaceView) view, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.appdynamics.eumagent.runtime.private.bg.1
                                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                                public final void onPixelCopyFinished(int i) {
                                    if (i != 0) {
                                        ADLog.logAgentError("Failed to take screenshot, with pixel copy");
                                    } else {
                                        C2084bg.this.f652a.m562a(new a(bitmapCreateBitmap));
                                    }
                                }
                            }, new Handler());
                        } else if (view instanceof TextureView) {
                            c2084bg.f652a.m562a(new a(((TextureView) view).getBitmap().copy(Bitmap.Config.ARGB_8888, true)));
                        } else {
                            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                            view.draw(new Canvas(bitmapCreateBitmap2));
                            c2084bg.f652a.m562a(new a(bitmapCreateBitmap2));
                        }
                    }
                }
            } catch (RuntimeException e) {
                if ("Only the original thread that created a view hierarchy can touch its views.".equals(e.getMessage())) {
                    ADLog.logVerbose("Screenshot capture ignoring runtime exception because the view was accessed from a non-UI thread.");
                } else {
                    ADLog.logAgentError("Failed to take screenshot", e);
                }
            }
        }
    }
}
