package androidx.autofill.inline.p004v1;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.autofill.R;
import androidx.autofill.inline.UiVersions;
import androidx.autofill.inline.common.BundledStyle;
import androidx.autofill.inline.common.ImageViewStyle;
import androidx.autofill.inline.common.SlicedContent;
import androidx.autofill.inline.common.TextViewStyle;
import androidx.autofill.inline.common.ViewStyle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 30)
public final class InlineSuggestionUi {
    @NonNull
    public static Content.Builder newContentBuilder(@NonNull PendingIntent pendingIntent) {
        return new Content.Builder(pendingIntent);
    }

    @NonNull
    public static Style.Builder newStyleBuilder() {
        return new Style.Builder();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Content fromSlice(@NonNull Slice slice) {
        Content content = new Content(slice);
        if (content.isValid()) {
            return content;
        }
        Log.w("InlineSuggestionUi", "Invalid content for androidx.autofill.inline.ui.version:v1");
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Style fromBundle(@NonNull Bundle bundle) {
        Style style = new Style(bundle);
        if (style.isValid()) {
            return style;
        }
        Log.w("InlineSuggestionUi", "Invalid style for androidx.autofill.inline.ui.version:v1");
        return null;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static View render(@NonNull Context context, @NonNull Content content, @NonNull Style style) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getDefaultContextThemeWrapper(context)).inflate(R.layout.autofill_inline_suggestion, (ViewGroup) null);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.autofill_inline_suggestion_start_icon);
        TextView textView = (TextView) viewGroup.findViewById(R.id.autofill_inline_suggestion_title);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.autofill_inline_suggestion_subtitle);
        ImageView imageView2 = (ImageView) viewGroup.findViewById(R.id.autofill_inline_suggestion_end_icon);
        CharSequence title = content.getTitle();
        if (title != null) {
            textView.setText(title);
            textView.setVisibility(0);
        }
        CharSequence subtitle = content.getSubtitle();
        if (subtitle != null) {
            textView2.setText(subtitle);
            textView2.setVisibility(0);
        }
        Icon startIcon = content.getStartIcon();
        if (startIcon != null) {
            imageView.setImageIcon(startIcon);
            imageView.setVisibility(0);
        }
        Icon endIcon = content.getEndIcon();
        if (endIcon != null) {
            imageView2.setImageIcon(endIcon);
            imageView2.setVisibility(0);
        }
        CharSequence contentDescription = content.getContentDescription();
        if (!TextUtils.isEmpty(contentDescription)) {
            viewGroup.setContentDescription(contentDescription);
        }
        if (style.isValid()) {
            if (content.isSingleIconOnly()) {
                style.applyStyle(viewGroup, imageView);
            } else {
                style.applyStyle(viewGroup, imageView, textView, textView2, imageView2);
            }
        }
        return viewGroup;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static PendingIntent getAttributionIntent(@NonNull Content content) {
        return content.getAttributionIntent();
    }

    private static Context getDefaultContextThemeWrapper(Context context) {
        Resources.Theme themeNewTheme = context.getResources().newTheme();
        themeNewTheme.applyStyle(R.style.Theme_AutofillInlineSuggestion, true);
        return new ContextThemeWrapper(context, themeNewTheme);
    }

    public static final class Style extends BundledStyle implements UiVersions.Style {
        Style(Bundle bundle) {
            super(bundle);
        }

        @Override // androidx.autofill.inline.common.BundledStyle
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        protected String getStyleKey() {
            return "style_v1";
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void applyStyle(@NonNull View view, @NonNull ImageView imageView) {
            if (isValid()) {
                view.setLayoutDirection(getLayoutDirection());
                if (imageView.getVisibility() != 8) {
                    ImageViewStyle singleIconChipIconStyle = getSingleIconChipIconStyle();
                    if (singleIconChipIconStyle == null) {
                        singleIconChipIconStyle = getStartIconStyle();
                    }
                    if (singleIconChipIconStyle != null) {
                        singleIconChipIconStyle.applyStyleOnImageViewIfValid(imageView);
                    }
                }
                ViewStyle singleIconChipStyle = getSingleIconChipStyle();
                if (singleIconChipStyle == null) {
                    singleIconChipStyle = getChipStyle();
                }
                if (singleIconChipStyle != null) {
                    singleIconChipStyle.applyStyleOnViewIfValid(view);
                }
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void applyStyle(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView2) {
            ImageViewStyle endIconStyle;
            TextViewStyle subtitleStyle;
            TextViewStyle titleStyle;
            ImageViewStyle startIconStyle;
            if (isValid()) {
                view.setLayoutDirection(getLayoutDirection());
                if (imageView.getVisibility() != 8 && (startIconStyle = getStartIconStyle()) != null) {
                    startIconStyle.applyStyleOnImageViewIfValid(imageView);
                }
                if (textView.getVisibility() != 8 && (titleStyle = getTitleStyle()) != null) {
                    titleStyle.applyStyleOnTextViewIfValid(textView);
                }
                if (textView2.getVisibility() != 8 && (subtitleStyle = getSubtitleStyle()) != null) {
                    subtitleStyle.applyStyleOnTextViewIfValid(textView2);
                }
                if (imageView2.getVisibility() != 8 && (endIconStyle = getEndIconStyle()) != null) {
                    endIconStyle.applyStyleOnImageViewIfValid(imageView2);
                }
                ViewStyle chipStyle = getChipStyle();
                if (chipStyle != null) {
                    chipStyle.applyStyleOnViewIfValid(view);
                }
            }
        }

        @Override // androidx.autofill.inline.UiVersions.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public String getVersion() {
            return UiVersions.INLINE_UI_VERSION_1;
        }

        public int getLayoutDirection() {
            int i = this.mBundle.getInt("layout_direction", 0);
            if (i == 0 || i == 1) {
                return i;
            }
            return 0;
        }

        @Nullable
        public ViewStyle getChipStyle() {
            Bundle bundle = this.mBundle.getBundle("chip_style");
            if (bundle == null) {
                return null;
            }
            return new ViewStyle(bundle);
        }

        @Nullable
        public TextViewStyle getTitleStyle() {
            Bundle bundle = this.mBundle.getBundle("title_style");
            if (bundle == null) {
                return null;
            }
            return new TextViewStyle(bundle);
        }

        @Nullable
        public TextViewStyle getSubtitleStyle() {
            Bundle bundle = this.mBundle.getBundle("subtitle_style");
            if (bundle == null) {
                return null;
            }
            return new TextViewStyle(bundle);
        }

        @Nullable
        public ImageViewStyle getStartIconStyle() {
            Bundle bundle = this.mBundle.getBundle("start_icon_style");
            if (bundle == null) {
                return null;
            }
            return new ImageViewStyle(bundle);
        }

        @Nullable
        public ImageViewStyle getEndIconStyle() {
            Bundle bundle = this.mBundle.getBundle("end_icon_style");
            if (bundle == null) {
                return null;
            }
            return new ImageViewStyle(bundle);
        }

        @Nullable
        public ViewStyle getSingleIconChipStyle() {
            Bundle bundle = this.mBundle.getBundle("single_icon_chip_style");
            if (bundle == null) {
                return null;
            }
            return new ViewStyle(bundle);
        }

        @Nullable
        public ImageViewStyle getSingleIconChipIconStyle() {
            Bundle bundle = this.mBundle.getBundle("single_icon_chip_icon_style");
            if (bundle == null) {
                return null;
            }
            return new ImageViewStyle(bundle);
        }

        public static final class Builder extends BundledStyle.Builder<Style> {
            Builder() {
                super("style_v1");
            }

            @NonNull
            public Builder setLayoutDirection(int i) {
                this.mBundle.putInt("layout_direction", i);
                return this;
            }

            @NonNull
            public Builder setChipStyle(@NonNull ViewStyle viewStyle) {
                viewStyle.assertIsValid();
                this.mBundle.putBundle("chip_style", viewStyle.getBundle());
                return this;
            }

            @NonNull
            public Builder setTitleStyle(@NonNull TextViewStyle textViewStyle) {
                textViewStyle.assertIsValid();
                this.mBundle.putBundle("title_style", textViewStyle.getBundle());
                return this;
            }

            @NonNull
            public Builder setSubtitleStyle(@NonNull TextViewStyle textViewStyle) {
                textViewStyle.assertIsValid();
                this.mBundle.putBundle("subtitle_style", textViewStyle.getBundle());
                return this;
            }

            @NonNull
            public Builder setStartIconStyle(@NonNull ImageViewStyle imageViewStyle) {
                imageViewStyle.assertIsValid();
                this.mBundle.putBundle("start_icon_style", imageViewStyle.getBundle());
                return this;
            }

            @NonNull
            public Builder setEndIconStyle(@NonNull ImageViewStyle imageViewStyle) {
                imageViewStyle.assertIsValid();
                this.mBundle.putBundle("end_icon_style", imageViewStyle.getBundle());
                return this;
            }

            @NonNull
            public Builder setSingleIconChipStyle(@NonNull ViewStyle viewStyle) {
                viewStyle.assertIsValid();
                this.mBundle.putBundle("single_icon_chip_style", viewStyle.getBundle());
                return this;
            }

            @NonNull
            public Builder setSingleIconChipIconStyle(@NonNull ImageViewStyle imageViewStyle) {
                imageViewStyle.assertIsValid();
                this.mBundle.putBundle("single_icon_chip_icon_style", imageViewStyle.getBundle());
                return this;
            }

            @Override // androidx.autofill.inline.common.BundledStyle.Builder
            @NonNull
            public Style build() {
                return new Style(this.mBundle);
            }
        }
    }

    public static final class Content extends SlicedContent {
        private PendingIntent mAttributionIntent;
        private CharSequence mContentDescription;
        private Icon mEndIcon;
        private Icon mStartIcon;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        Content(Slice slice) {
            super(slice);
            for (SliceItem sliceItem : slice.getItems()) {
                String strItemType = itemType(sliceItem);
                if (strItemType != null) {
                    switch (strItemType) {
                        case "inline_subtitle":
                            this.mSubtitle = sliceItem.getText().toString();
                            break;
                        case "inline_content_description":
                            this.mContentDescription = sliceItem.getText();
                            break;
                        case "inline_start_icon":
                            this.mStartIcon = sliceItem.getIcon();
                            break;
                        case "inline_title":
                            this.mTitle = sliceItem.getText().toString();
                            break;
                        case "inline_attribution":
                            this.mAttributionIntent = sliceItem.getAction();
                            break;
                        case "inline_end_icon":
                            this.mEndIcon = sliceItem.getIcon();
                            break;
                    }
                }
            }
        }

        boolean isSingleIconOnly() {
            return this.mStartIcon != null && this.mTitle == null && this.mSubtitle == null && this.mEndIcon == null;
        }

        @Nullable
        public CharSequence getTitle() {
            return this.mTitle;
        }

        @Nullable
        public CharSequence getSubtitle() {
            return this.mSubtitle;
        }

        @Nullable
        public Icon getStartIcon() {
            return this.mStartIcon;
        }

        @Nullable
        public Icon getEndIcon() {
            return this.mEndIcon;
        }

        @Nullable
        public CharSequence getContentDescription() {
            return this.mContentDescription;
        }

        @Override // androidx.autofill.inline.common.SlicedContent
        @Nullable
        public PendingIntent getAttributionIntent() {
            return this.mAttributionIntent;
        }

        @Override // androidx.autofill.inline.common.SlicedContent
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public boolean isValid() {
            return UiVersions.INLINE_UI_VERSION_1.equals(SlicedContent.getVersion(this.mSlice));
        }

        /* JADX WARN: Code duplicated, block: B:45:0x009b A[RETURN] */
        private static String itemType(SliceItem sliceItem) {
            String format = sliceItem.getFormat();
            format.hashCode();
            switch (format) {
                case "action":
                    if (sliceItem.getAction() == null || !sliceItem.getHints().contains("inline_attribution")) {
                        return null;
                    }
                    return "inline_attribution";
                case "text":
                    if (TextUtils.isEmpty(sliceItem.getText())) {
                        return null;
                    }
                    if (sliceItem.getHints().contains("inline_title")) {
                        return "inline_title";
                    }
                    if (sliceItem.getHints().contains("inline_subtitle")) {
                        return "inline_subtitle";
                    }
                    if (sliceItem.getHints().contains("inline_content_description")) {
                        return "inline_content_description";
                    }
                    return null;
                case "image":
                    if (sliceItem.getIcon() == null) {
                        return null;
                    }
                    if (sliceItem.getHints().contains("inline_start_icon")) {
                        return "inline_start_icon";
                    }
                    if (sliceItem.getHints().contains("inline_end_icon")) {
                        return "inline_end_icon";
                    }
                    return null;
                default:
                    return null;
            }
        }

        public static final class Builder extends SlicedContent.Builder<Content> {
            private final PendingIntent mAttributionIntent;
            private CharSequence mContentDescription;
            private Icon mEndIcon;
            private List mHints;
            private Icon mStartIcon;
            private CharSequence mSubtitle;
            private CharSequence mTitle;

            Builder(PendingIntent pendingIntent) {
                super(UiVersions.INLINE_UI_VERSION_1);
                this.mAttributionIntent = pendingIntent;
            }

            @NonNull
            public Builder setTitle(@NonNull CharSequence charSequence) {
                this.mTitle = charSequence;
                return this;
            }

            @NonNull
            public Builder setSubtitle(@NonNull CharSequence charSequence) {
                this.mSubtitle = charSequence;
                return this;
            }

            @NonNull
            public Builder setStartIcon(@NonNull Icon icon) {
                this.mStartIcon = icon;
                return this;
            }

            @NonNull
            public Builder setEndIcon(@NonNull Icon icon) {
                this.mEndIcon = icon;
                return this;
            }

            @NonNull
            public Builder setContentDescription(@NonNull CharSequence charSequence) {
                this.mContentDescription = charSequence;
                return this;
            }

            @NonNull
            public Builder setHints(@NonNull List<String> list) {
                this.mHints = list;
                return this;
            }

            @Override // androidx.autofill.inline.common.SlicedContent.Builder
            @NonNull
            public Content build() {
                CharSequence charSequence = this.mTitle;
                if (charSequence == null && this.mStartIcon == null && this.mEndIcon == null && this.mSubtitle == null) {
                    throw new IllegalStateException("Title, subtitle, start icon, end icon are all null. Please set value for at least one of them");
                }
                if (charSequence == null && this.mSubtitle != null) {
                    throw new IllegalStateException("Cannot set the subtitle without setting the title.");
                }
                if (this.mAttributionIntent == null) {
                    throw new IllegalStateException("Attribution intent cannot be null.");
                }
                Icon icon = this.mStartIcon;
                if (icon != null) {
                    this.mSliceBuilder.addIcon(icon, null, Collections.singletonList("inline_start_icon"));
                }
                CharSequence charSequence2 = this.mTitle;
                if (charSequence2 != null) {
                    this.mSliceBuilder.addText(charSequence2, null, Collections.singletonList("inline_title"));
                }
                CharSequence charSequence3 = this.mSubtitle;
                if (charSequence3 != null) {
                    this.mSliceBuilder.addText(charSequence3, null, Collections.singletonList("inline_subtitle"));
                }
                Icon icon2 = this.mEndIcon;
                if (icon2 != null) {
                    this.mSliceBuilder.addIcon(icon2, null, Collections.singletonList("inline_end_icon"));
                }
                PendingIntent pendingIntent = this.mAttributionIntent;
                if (pendingIntent != null) {
                    this.mSliceBuilder.addAction(pendingIntent, new Slice.Builder(this.mSliceBuilder).addHints(Collections.singletonList("inline_attribution")).build(), null);
                }
                CharSequence charSequence4 = this.mContentDescription;
                if (charSequence4 != null) {
                    this.mSliceBuilder.addText(charSequence4, null, Collections.singletonList("inline_content_description"));
                }
                List<String> list = this.mHints;
                if (list != null) {
                    this.mSliceBuilder.addHints(list);
                }
                return new Content(this.mSliceBuilder.build());
            }
        }
    }
}
