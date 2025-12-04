package com.urbanairship.android.layout.property;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.android.layout.R;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.widget.ShapeDrawableWrapper;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.reactnative.ReactMessageView;
import java.util.Locale;

/* loaded from: classes5.dex */
public abstract class Image {
    private final Type type;

    /* synthetic */ Image(Type type, AnonymousClass1 anonymousClass1) {
        this(type);
    }

    private Image(Type type) {
        this.type = type;
    }

    /* renamed from: com.urbanairship.android.layout.property.Image$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$android$layout$property$Image$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$urbanairship$android$layout$property$Image$Type = iArr;
            try {
                iArr[Type.URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$Image$Type[Type.ICON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @NonNull
    public static Image fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        String strOptString = jsonMap.opt("type").optString();
        int i = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$Image$Type[Type.from(strOptString).ordinal()];
        if (i == 1) {
            return Url.fromJson(jsonMap);
        }
        if (i == 2) {
            return Icon.fromJson(jsonMap);
        }
        throw new JsonException("Failed to parse image! Unknown button image type value: " + strOptString);
    }

    public enum Type {
        URL("url"),
        ICON("icon");

        private final String value;

        Type(String str) {
            this.value = str;
        }

        @NonNull
        public static Type from(@NonNull String str) throws JsonException {
            for (Type type : values()) {
                if (type.value.equals(str.toLowerCase(Locale.ROOT))) {
                    return type;
                }
            }
            throw new JsonException("Unknown button image type value: " + str);
        }
    }

    @NonNull
    public Type getType() {
        return this.type;
    }

    public static final class Url extends Image {
        private final MediaFit mediaFit;
        private final Position position;
        private final String url;

        public Url(@NonNull String str, @Nullable MediaFit mediaFit, @Nullable Position position) {
            super(Type.URL, null);
            this.url = str;
            this.mediaFit = mediaFit;
            this.position = position;
        }

        @NonNull
        public static Url fromJson(@NonNull JsonMap jsonMap) {
            MediaFit mediaFitFrom;
            String strOptString = jsonMap.opt("url").optString();
            String string = jsonMap.opt("media_fit").getString();
            Position positionFromJson = null;
            if (string != null) {
                try {
                    mediaFitFrom = MediaFit.from(string);
                } catch (JsonException unused) {
                }
            } else {
                mediaFitFrom = null;
            }
            JsonMap map = jsonMap.opt(ViewProps.POSITION).getMap();
            if (map != null) {
                try {
                    positionFromJson = Position.fromJson(map);
                } catch (JsonException unused2) {
                }
            }
            return new Url(strOptString, mediaFitFrom, positionFromJson);
        }

        @NonNull
        public String getUrl() {
            return this.url;
        }

        @Nullable
        public MediaFit getMediaFit() {
            return this.mediaFit;
        }

        @Nullable
        public Position getPosition() {
            return this.position;
        }
    }

    public static final class Icon extends Image {
        private final DrawableResource drawable;
        private final float scale;
        private final Color tint;

        public Icon(@NonNull DrawableResource drawableResource, @NonNull Color color, float f) {
            super(Type.ICON, null);
            this.drawable = drawableResource;
            this.tint = color;
            this.scale = f;
        }

        @NonNull
        public static Icon fromJson(@NonNull JsonMap jsonMap) throws JsonException {
            DrawableResource drawableResourceFrom = DrawableResource.from(jsonMap.opt("icon").optString());
            Color colorFromJsonField = Color.fromJsonField(jsonMap, "color");
            if (colorFromJsonField == null) {
                throw new JsonException("Failed to parse icon! Field 'color' is required.");
            }
            return new Icon(drawableResourceFrom, colorFromJsonField, jsonMap.opt("scale").getFloat(1.0f));
        }

        @DrawableRes
        public int getDrawableRes() {
            return this.drawable.resId;
        }

        @Nullable
        public Drawable getDrawable(@NonNull Context context, boolean z) {
            return getDrawable(context, z, null);
        }

        @Nullable
        public Drawable getDrawable(@NonNull Context context, boolean z, HorizontalPosition horizontalPosition) {
            Drawable drawable = ContextCompat.getDrawable(context, getDrawableRes());
            if (drawable == null) {
                return null;
            }
            DrawableCompat.setTint(drawable, z ? this.tint.resolve(context) : LayoutUtils.generateDisabledColor(this.tint.resolve(context)));
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).start();
            }
            return new ShapeDrawableWrapper(drawable, 1.0f, this.scale, horizontalPosition);
        }

        @NonNull
        public Color getTint() {
            return this.tint;
        }

        public float getScale() {
            return this.scale;
        }

        private enum DrawableResource {
            CLOSE(ReactMessageView.EVENT_CLOSE, R.drawable.ua_layout_ic_close),
            CHECKMARK("checkmark", R.drawable.ua_layout_ic_check),
            ARROW_FORWARD("forward_arrow", R.drawable.ua_layout_ic_arrow_forward),
            ARROW_BACK("back_arrow", R.drawable.ua_layout_ic_arrow_back),
            ERROR_CIRCLE("exclamationmark_circle_fill", R.drawable.ua_layout_ic_error_circle_filled),
            ASTERISK("asterisk", R.drawable.ua_layout_ic_asterisk),
            ASTERISK_CIRCLE("asterisk_circle_fill", R.drawable.ua_layout_ic_asterisk_circle_filled),
            STAR("star", R.drawable.ua_layout_ic_star),
            STAR_FILL("star_fill", R.drawable.ua_layout_ic_star_fill),
            HEART("heart", R.drawable.ua_layout_ic_heart),
            HEART_FILL("heart_fill", R.drawable.ua_layout_ic_heart_fill),
            PROGRESS_SPINNER("progress_spinner", R.drawable.ua_layout_animated_progress_spinner);

            private final int resId;
            private final String value;

            DrawableResource(String str, int i) {
                this.value = str;
                this.resId = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static DrawableResource from(String str) throws JsonException {
                for (DrawableResource drawableResource : values()) {
                    if (drawableResource.value.equals(str.toLowerCase(Locale.ROOT))) {
                        return drawableResource;
                    }
                }
                throw new JsonException("Unknown icon drawable resource: " + str);
            }
        }
    }

    public static final class CenteredImageSpan extends ImageSpan {
        public CenteredImageSpan(Drawable drawable) {
            super(drawable);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            canvas.save();
            Drawable drawable = getDrawable();
            canvas.translate(f, (i5 - drawable.getBounds().bottom) - (paint.getFontMetricsInt().descent / 2));
            drawable.draw(canvas);
            canvas.restore();
        }
    }
}
