package com.appdynamics.eumagent.runtime.p000private;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p000private.am;
import com.contentsquare.android.api.Currencies;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes2.dex */
public final class bg implements am.b {
    final am a;
    final Handler b;
    final q c;
    f d;
    volatile boolean e;

    public bg(am amVar, q qVar, f fVar) {
        this(amVar, new Handler(Looper.getMainLooper()), qVar, fVar);
    }

    private bg(am amVar, Handler handler, q qVar, f fVar) {
        this.e = false;
        this.a = amVar;
        this.b = handler;
        this.c = qVar;
        this.d = fVar;
        amVar.a.a(a.class, this);
    }

    @Override // com.appdynamics.eumagent.runtime.private.am.b
    public final void a(Object obj) {
        int iMin;
        int i;
        if (obj instanceof a) {
            ADLog.logVerbose("Constructing tiles from capturedDrawingCache");
            a aVar = (a) obj;
            int width = aVar.a.getWidth();
            int height = aVar.a.getHeight();
            if (height > width) {
                iMin = Math.min(width, Currencies.GTQ);
                i = (int) (height * (iMin / width));
            } else {
                int iMin2 = Math.min(height, Currencies.GTQ);
                iMin = (int) (width * (iMin2 / height));
                i = iMin2;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(aVar.a, iMin, i, true);
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
                strArr[i12] = a(bitmapArr[i12]);
            }
            this.a.a(new bf(bitmapArr, strArr, iMin, i));
        }
    }

    private static String a(Bitmap bitmap) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((bitmap.getWidth() * bitmap.getHeight()) << 2);
            bitmap.copyPixelsToBuffer(byteBufferAllocate);
            byteBufferAllocate.rewind();
            messageDigest.update(byteBufferAllocate);
            return ct.a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Cannot hash tiles", e);
        }
    }

    protected static class a {
        final Bitmap a;

        a(Bitmap bitmap) {
            this.a = bitmap;
        }
    }

    class b implements Runnable {
        private final View a;

        b(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                bg.this.e = false;
                if (bg.this.c.a()) {
                    if (bg.this.c.a.b.booleanValue() || !bg.this.d.b()) {
                        ADLog.logVerbose("Taking screenshot");
                        final bg bgVar = bg.this;
                        View view = this.a;
                        ADLog.logAgentError("rootView " + view.getClass());
                        if (view instanceof SurfaceView) {
                            final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                            PixelCopy.request((SurfaceView) view, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.appdynamics.eumagent.runtime.private.bg.1
                                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                                public final void onPixelCopyFinished(int i) {
                                    if (i != 0) {
                                        ADLog.logAgentError("Failed to take screenshot, with pixel copy");
                                    } else {
                                        bg.this.a.a(new a(bitmapCreateBitmap));
                                    }
                                }
                            }, new Handler());
                        } else if (view instanceof TextureView) {
                            bgVar.a.a(new a(((TextureView) view).getBitmap().copy(Bitmap.Config.ARGB_8888, true)));
                        } else {
                            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                            view.draw(new Canvas(bitmapCreateBitmap2));
                            bgVar.a.a(new a(bitmapCreateBitmap2));
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
