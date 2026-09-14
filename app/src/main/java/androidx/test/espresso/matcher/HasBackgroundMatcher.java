package androidx.test.espresso.matcher;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.test.annotation.Beta;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/* JADX INFO: loaded from: classes2.dex */
@Beta
public final class HasBackgroundMatcher extends TypeSafeMatcher<View> {
    private final int drawableId;

    public HasBackgroundMatcher(int i) {
        this.drawableId = i;
    }

    private static boolean assertDrawable(Drawable drawable, int i, View view) {
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return false;
        }
        Bitmap bitmapDecodeResource = null;
        try {
            bitmapDecodeResource = BitmapFactory.decodeResource(view.getContext().getResources(), i);
            return ((BitmapDrawable) drawable).getBitmap().sameAs(bitmapDecodeResource);
        } catch (OutOfMemoryError e) {
            Log.e("HasBackgroundMatcher", e.getMessage(), e.getCause());
            return false;
        } finally {
            if (bitmapDecodeResource != null) {
                bitmapDecodeResource.recycle();
            }
        }
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        int i = this.drawableId;
        StringBuilder sb = new StringBuilder(44);
        sb.append("has background with drawable ID: ");
        sb.append(i);
        description.appendText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.TypeSafeMatcher
    public boolean matchesSafely(View view) {
        return assertDrawable(view.getBackground(), this.drawableId, view);
    }
}
