package com.urbanairship.messagecenter.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.widget.TextViewCompat;
import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.R;
import com.urbanairship.UAirship;
import com.urbanairship.images.ImageLoader;
import com.urbanairship.images.ImageRequestOptions;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.util.ViewExtensionsKt;
import com.urbanairship.util.AccessibilityUtils;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 C2\u00020\u0001:\u0003BCDB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0007H\u0014J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u000e\u0010,\u001a\u00020$2\u0006\u0010 \u001a\u00020\u0019J\u0010\u0010-\u001a\u00020$2\b\b\u0001\u0010\u001f\u001a\u00020\u0007J\u0010\u0010.\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013H\u0002J\u0012\u0010/\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u000101H\u0002J&\u00102\u001a\u00020$2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u0019H\u0002J&\u00103\u001a\u00020$2\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0002J\u001f\u00104\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u00105\u001a\u00020\u0019H\u0000¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u0019H\u0000¢\u0006\u0002\b9J\u0010\u0010:\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\u0015\u0010;\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u0019H\u0000¢\u0006\u0002\b<J$\u0010=\u001a\u00020$*\u00020>2\b\b\u0001\u0010?\u001a\u00020\u00072\f\u0010@\u001a\b\u0012\u0004\u0012\u00020$0AH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/MessageListItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "accessibilityActionIds", "", "accessibilityActionListener", "Lcom/urbanairship/messagecenter/ui/widget/MessageListItem$AccessibilityActionListener;", "getAccessibilityActionListener", "()Lcom/urbanairship/messagecenter/ui/widget/MessageListItem$AccessibilityActionListener;", "setAccessibilityActionListener", "(Lcom/urbanairship/messagecenter/ui/widget/MessageListItem$AccessibilityActionListener;)V", "boundMessage", "Lcom/urbanairship/messagecenter/Message;", "imageLoader", "Lcom/urbanairship/images/ImageLoader;", "getImageLoader", "()Lcom/urbanairship/images/ImageLoader;", "isEditing", "", "isHighlighted", "isRead", "isSelected", "messageListItemAnimator", "Lcom/urbanairship/messagecenter/ui/widget/MessageListItemAnimator;", "placeholderRes", "showThumbnails", "views", "Lcom/urbanairship/messagecenter/ui/widget/MessageListItem$Views;", "bind", "", "item", "onCreateDrawableState", "", "extraSpace", "onInitializeAccessibilityNodeInfo", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Landroid/view/accessibility/AccessibilityNodeInfo;", "setIconsEnabled", "setPlaceholderIcon", "setText", "setThumbnail", "url", "", "updateAccessibilityActions", "updateContentDescription", "updateEditing", "animate", "updateEditing$urbanairship_message_center_release", "updateHighlighted", "highlighted", "updateHighlighted$urbanairship_message_center_release", "updateReadState", "updateSelected", "updateSelected$urbanairship_message_center_release", "addAccessibilityAction", "Landroid/view/View;", "labelRes", "block", "Lkotlin/Function0;", "AccessibilityActionListener", "Companion", "Views", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageListItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageListItem.kt\ncom/urbanairship/messagecenter/ui/widget/MessageListItem\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,369:1\n59#2,2:370\n256#3,2:372\n298#3,2:374\n298#3,2:376\n256#3,2:378\n1#4:380\n*S KotlinDebug\n*F\n+ 1 MessageListItem.kt\ncom/urbanairship/messagecenter/ui/widget/MessageListItem\n*L\n79#1:370,2\n165#1:372,2\n208#1:374,2\n222#1:376,2\n224#1:378,2\n*E\n"})
/* loaded from: classes5.dex */
public final class MessageListItem extends FrameLayout {
    private final List accessibilityActionIds;
    private AccessibilityActionListener accessibilityActionListener;
    private Message boundMessage;
    private boolean isEditing;
    private boolean isHighlighted;
    private boolean isRead;
    private boolean isSelected;
    private final MessageListItemAnimator messageListItemAnimator;
    private int placeholderRes;
    private boolean showThumbnails;
    private final Views views;
    private static final Companion Companion = new Companion(null);
    private static final DateFormat dateFormatter = DateFormat.getDateInstance(1);
    private static final int[] STATE_HIGHLIGHTED = {R.attr.ua_state_highlighted};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/MessageListItem$AccessibilityActionListener;", "", "onDelete", "", "message", "Lcom/urbanairship/messagecenter/Message;", "onMarkRead", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AccessibilityActionListener {
        void onDelete(@NotNull Message message);

        void onMarkRead(@NotNull Message message);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageListItem(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageListItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageListItem(@NotNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MessageListItem(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? com.urbanairship.messagecenter.R.style.UrbanAirship_MessageCenter_Item : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageListItem(@NotNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.placeholderRes = com.urbanairship.messagecenter.R.drawable.ua_message_item_thumbnail_placeholder;
        this.accessibilityActionIds = new ArrayList();
        View.inflate(context, com.urbanairship.messagecenter.R.layout.ua_view_message_list_item_content, this);
        int[] UrbanAirship_MessageCenter = com.urbanairship.messagecenter.R.styleable.UrbanAirship_MessageCenter;
        Intrinsics.checkNotNullExpressionValue(UrbanAirship_MessageCenter, "UrbanAirship_MessageCenter");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, UrbanAirship_MessageCenter, 0, com.urbanairship.messagecenter.R.style.UrbanAirship_MessageCenter);
        setIconsEnabled(typedArrayObtainStyledAttributes.getBoolean(com.urbanairship.messagecenter.R.styleable.UrbanAirship_MessageCenter_messageCenterIconsEnabled, false));
        setPlaceholderIcon(typedArrayObtainStyledAttributes.getResourceId(com.urbanairship.messagecenter.R.styleable.UrbanAirship_MessageCenter_messageCenterPlaceholderIcon, com.urbanairship.messagecenter.R.drawable.ua_message_item_thumbnail_placeholder));
        typedArrayObtainStyledAttributes.recycle();
        Views views = new Views(this, null, null, null, null, null, null, null, null, TypedValues.PositionType.TYPE_POSITION_TYPE, null);
        this.views = views;
        this.messageListItemAnimator = new MessageListItemAnimator(context, views.getUnreadContainer(), views.getCheckable());
    }

    @Nullable
    public final AccessibilityActionListener getAccessibilityActionListener() {
        return this.accessibilityActionListener;
    }

    public final void setAccessibilityActionListener(@Nullable AccessibilityActionListener accessibilityActionListener) {
        this.accessibilityActionListener = accessibilityActionListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    @NotNull
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(extraSpace + 1);
        if (this.isHighlighted) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, STATE_HIGHLIGHTED);
        }
        Intrinsics.checkNotNull(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NotNull AccessibilityNodeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        if (this.isEditing) {
            info.setClassName(CheckBox.class.getName());
        }
    }

    private final ImageLoader getImageLoader() {
        ImageLoader imageLoader = UAirship.shared().getImageLoader();
        Intrinsics.checkNotNullExpressionValue(imageLoader, "getImageLoader(...)");
        return imageLoader;
    }

    public final void bind(@NotNull Message item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.boundMessage = item;
        setText(item);
        setThumbnail(item.getListIconUrl());
        updateReadState(item.getIsRead());
        updateContentDescription$default(this, false, false, this.views.getCheckable().isChecked(), 3, null);
        updateAccessibilityActions$default(this, false, false, false, 7, null);
    }

    private final void setText(Message item) {
        Views views = this.views;
        views.getPrimaryText().setText(item.getTitle());
        ViewExtensionsKt.setTextOrHide(views.getSecondaryText(), item.getSubtitle());
        views.getTertiaryText().setText(dateFormatter.format(item.getSentDate()));
    }

    private final void setThumbnail(String url) {
        if (!this.showThumbnails || this.views.getThumbnail() == null) {
            return;
        }
        if (url != null && !StringsKt.isBlank(url)) {
            getImageLoader().load(getContext(), this.views.getThumbnail(), ImageRequestOptions.newBuilder(url).setPlaceHolder(this.placeholderRes).build());
        } else {
            this.views.getThumbnail().setImageResource(this.placeholderRes);
        }
        this.views.getUnreadContainer().setVisibility(0);
    }

    public final void updateHighlighted$urbanairship_message_center_release(boolean highlighted) {
        this.isHighlighted = highlighted;
        refreshDrawableState();
    }

    private final void updateReadState(boolean isRead) {
        int i;
        int i2;
        int i3;
        this.isRead = isRead;
        TextView primaryText = this.views.getPrimaryText();
        if (isRead) {
            i = com.urbanairship.messagecenter.R.style.UrbanAirship_MessageCenter_TextAppearance_MessageTitle_Read;
        } else {
            i = com.urbanairship.messagecenter.R.style.UrbanAirship_MessageCenter_TextAppearance_MessageTitle_Unread;
        }
        TextViewCompat.setTextAppearance(primaryText, i);
        TextView secondaryText = this.views.getSecondaryText();
        if (isRead) {
            i2 = com.urbanairship.messagecenter.R.style.UrbanAirship_MessageCenter_TextAppearance_MessageSubtitle_Read;
        } else {
            i2 = com.urbanairship.messagecenter.R.style.UrbanAirship_MessageCenter_TextAppearance_MessageSubtitle_Unread;
        }
        TextViewCompat.setTextAppearance(secondaryText, i2);
        TextView tertiaryText = this.views.getTertiaryText();
        if (isRead) {
            i3 = com.urbanairship.messagecenter.R.style.UrbanAirship_MessageCenter_TextAppearance_MessageSentDate_Read;
        } else {
            i3 = com.urbanairship.messagecenter.R.style.UrbanAirship_MessageCenter_TextAppearance_MessageSentDate_Unread;
        }
        TextViewCompat.setTextAppearance(tertiaryText, i3);
        this.views.getUnreadIndicator().setVisibility(isRead ? 8 : 0);
        updateContentDescription$default(this, isRead, false, false, 6, null);
        updateAccessibilityActions$default(this, false, false, isRead, 3, null);
    }

    public static /* synthetic */ void updateEditing$urbanairship_message_center_release$default(MessageListItem messageListItem, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        messageListItem.updateEditing$urbanairship_message_center_release(z, z2);
    }

    public final void updateEditing$urbanairship_message_center_release(boolean isEditing, boolean animate) {
        this.isEditing = isEditing;
        if (animate) {
            this.messageListItemAnimator.animateEditMode(isEditing);
        } else {
            this.views.getUnreadContainer().setVisibility(isEditing ? 8 : 0);
            this.views.getCheckable().setAlpha(isEditing ? 1.0f : BitmapDescriptorFactory.HUE_RED);
            this.views.getCheckable().setVisibility(isEditing ? 0 : 8);
        }
        updateContentDescription$default(this, false, isEditing, false, 5, null);
        updateAccessibilityActions$default(this, isEditing, false, false, 6, null);
    }

    public final void updateSelected$urbanairship_message_center_release(boolean isSelected) {
        this.isSelected = isSelected;
        this.views.getCheckable().setChecked(isSelected);
        updateContentDescription$default(this, false, false, isSelected, 3, null);
        updateAccessibilityActions$default(this, false, isSelected, false, 5, null);
    }

    static /* synthetic */ void updateContentDescription$default(MessageListItem messageListItem, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = messageListItem.isRead;
        }
        if ((i & 2) != 0) {
            z2 = messageListItem.isEditing;
        }
        if ((i & 4) != 0) {
            z3 = messageListItem.isSelected;
        }
        messageListItem.updateContentDescription(z, z2, z3);
    }

    private final void updateContentDescription(boolean isRead, boolean isEditing, boolean isSelected) {
        Message message = this.boundMessage;
        if (message == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (isEditing && isSelected) {
            sb.append(getContext().getString(com.urbanairship.messagecenter.R.string.ua_mc_description_state_selected));
        }
        if (!isRead) {
            sb.append(getContext().getString(com.urbanairship.messagecenter.R.string.ua_mc_description_state_unread));
        }
        sb.append(getContext().getString(com.urbanairship.messagecenter.R.string.ua_mc_description_title_and_date, message.getTitle(), dateFormatter.format(message.getSentDate())));
        setContentDescription(sb.toString());
    }

    static /* synthetic */ void updateAccessibilityActions$default(MessageListItem messageListItem, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = messageListItem.isEditing;
        }
        if ((i & 2) != 0) {
            z2 = messageListItem.isActivated();
        }
        if ((i & 4) != 0) {
            z3 = messageListItem.isRead;
        }
        messageListItem.updateAccessibilityActions(z, z2, z3);
    }

    private final void updateAccessibilityActions(boolean isEditing, boolean isSelected, boolean isRead) {
        int i;
        Iterator it = this.accessibilityActionIds.iterator();
        while (it.hasNext()) {
            ViewCompat.removeAccessibilityAction(this, ((Number) it.next()).intValue());
        }
        final Message message = this.boundMessage;
        if (message == null) {
            return;
        }
        AccessibilityUtils.setClickActionLabel(this, com.urbanairship.messagecenter.R.string.ua_mc_action_click);
        addAccessibilityAction(this, R.string.ua_delete, new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.MessageListItem.updateAccessibilityActions.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2922invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2922invoke() {
                AccessibilityActionListener accessibilityActionListener = MessageListItem.this.getAccessibilityActionListener();
                if (accessibilityActionListener != null) {
                    accessibilityActionListener.onDelete(message);
                }
            }
        });
        if (!isRead) {
            addAccessibilityAction(this, com.urbanairship.messagecenter.R.string.ua_description_mark_read, new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.MessageListItem.updateAccessibilityActions.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2923invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2923invoke() {
                    AccessibilityActionListener accessibilityActionListener = MessageListItem.this.getAccessibilityActionListener();
                    if (accessibilityActionListener != null) {
                        accessibilityActionListener.onMarkRead(message);
                    }
                }
            });
        }
        if (isEditing) {
            if (isSelected) {
                i = com.urbanairship.messagecenter.R.string.ua_mc_action_unselect;
            } else {
                i = com.urbanairship.messagecenter.R.string.ua_mc_action_select;
            }
            AccessibilityUtils.setClickActionLabel(this, i);
        }
    }

    public final void setIconsEnabled(boolean showThumbnails) {
        int i;
        this.showThumbnails = showThumbnails;
        if (showThumbnails) {
            i = com.urbanairship.messagecenter.R.layout.ua_view_message_list_item_checkable_thumbnail;
        } else {
            i = com.urbanairship.messagecenter.R.layout.ua_view_message_list_item_checkable_no_thumbnail;
        }
        View viewFindViewById = findViewById(com.urbanairship.messagecenter.R.id.checkable_thumbnail_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        LayoutInflater.from(getContext()).inflate(i, (ViewGroup) viewFindViewById, true);
    }

    public final void setPlaceholderIcon(@DrawableRes int placeholderRes) {
        this.placeholderRes = placeholderRes;
    }

    private final void addAccessibilityAction(View view, int i, final Function0 function0) {
        String string = view.getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.accessibilityActionIds.add(Integer.valueOf(ViewCompat.addAccessibilityAction(view, string, new AccessibilityViewCommand() { // from class: com.urbanairship.messagecenter.ui.widget.MessageListItem$$ExternalSyntheticLambda0
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean perform(View view2, AccessibilityViewCommand.CommandArguments commandArguments) {
                return MessageListItem.addAccessibilityAction$lambda$2(function0, view2, commandArguments);
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addAccessibilityAction$lambda$2(Function0 block, View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
        return true;
    }

    private static final class Views {
        private final CheckBox checkable;
        private final ViewGroup checkableThumbnailContainer;
        private final TextView primaryText;
        private final View root;
        private final TextView secondaryText;
        private final TextView tertiaryText;
        private final ImageView thumbnail;
        private final ViewGroup unreadContainer;
        private final View unreadIndicator;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Views)) {
                return false;
            }
            Views views = (Views) obj;
            return Intrinsics.areEqual(this.root, views.root) && Intrinsics.areEqual(this.checkableThumbnailContainer, views.checkableThumbnailContainer) && Intrinsics.areEqual(this.unreadContainer, views.unreadContainer) && Intrinsics.areEqual(this.unreadIndicator, views.unreadIndicator) && Intrinsics.areEqual(this.thumbnail, views.thumbnail) && Intrinsics.areEqual(this.checkable, views.checkable) && Intrinsics.areEqual(this.primaryText, views.primaryText) && Intrinsics.areEqual(this.secondaryText, views.secondaryText) && Intrinsics.areEqual(this.tertiaryText, views.tertiaryText);
        }

        public int hashCode() {
            int iHashCode = ((((((this.root.hashCode() * 31) + this.checkableThumbnailContainer.hashCode()) * 31) + this.unreadContainer.hashCode()) * 31) + this.unreadIndicator.hashCode()) * 31;
            ImageView imageView = this.thumbnail;
            return ((((((((iHashCode + (imageView == null ? 0 : imageView.hashCode())) * 31) + this.checkable.hashCode()) * 31) + this.primaryText.hashCode()) * 31) + this.secondaryText.hashCode()) * 31) + this.tertiaryText.hashCode();
        }

        public String toString() {
            return "Views(root=" + this.root + ", checkableThumbnailContainer=" + this.checkableThumbnailContainer + ", unreadContainer=" + this.unreadContainer + ", unreadIndicator=" + this.unreadIndicator + ", thumbnail=" + this.thumbnail + ", checkable=" + this.checkable + ", primaryText=" + this.primaryText + ", secondaryText=" + this.secondaryText + ", tertiaryText=" + this.tertiaryText + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Views(View root, ViewGroup checkableThumbnailContainer, ViewGroup unreadContainer, View unreadIndicator, ImageView imageView, CheckBox checkable, TextView primaryText, TextView secondaryText, TextView tertiaryText) {
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(checkableThumbnailContainer, "checkableThumbnailContainer");
            Intrinsics.checkNotNullParameter(unreadContainer, "unreadContainer");
            Intrinsics.checkNotNullParameter(unreadIndicator, "unreadIndicator");
            Intrinsics.checkNotNullParameter(checkable, "checkable");
            Intrinsics.checkNotNullParameter(primaryText, "primaryText");
            Intrinsics.checkNotNullParameter(secondaryText, "secondaryText");
            Intrinsics.checkNotNullParameter(tertiaryText, "tertiaryText");
            this.root = root;
            this.checkableThumbnailContainer = checkableThumbnailContainer;
            this.unreadContainer = unreadContainer;
            this.unreadIndicator = unreadIndicator;
            this.thumbnail = imageView;
            this.checkable = checkable;
            this.primaryText = primaryText;
            this.secondaryText = secondaryText;
            this.tertiaryText = tertiaryText;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Views(View view, ViewGroup viewGroup, ViewGroup viewGroup2, View view2, ImageView imageView, CheckBox checkBox, TextView textView, TextView textView2, TextView textView3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            ViewGroup viewGroup3;
            ViewGroup viewGroup4;
            View viewFindViewById;
            CheckBox checkBox2;
            TextView textView4;
            TextView textView5;
            TextView textView6;
            if ((i & 2) != 0) {
                View viewFindViewById2 = view.findViewById(com.urbanairship.messagecenter.R.id.checkable_thumbnail_container);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                viewGroup3 = (ViewGroup) viewFindViewById2;
            } else {
                viewGroup3 = viewGroup;
            }
            if ((i & 4) != 0) {
                View viewFindViewById3 = view.findViewById(com.urbanairship.messagecenter.R.id.unread_container);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                viewGroup4 = (ViewGroup) viewFindViewById3;
            } else {
                viewGroup4 = viewGroup2;
            }
            if ((i & 8) != 0) {
                viewFindViewById = view.findViewById(com.urbanairship.messagecenter.R.id.unread_indicator);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            } else {
                viewFindViewById = view2;
            }
            ImageView imageView2 = (i & 16) != 0 ? (ImageView) view.findViewById(com.urbanairship.messagecenter.R.id.thumbnail) : imageView;
            if ((i & 32) != 0) {
                View viewFindViewById4 = view.findViewById(com.urbanairship.messagecenter.R.id.checkable);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                checkBox2 = (CheckBox) viewFindViewById4;
            } else {
                checkBox2 = checkBox;
            }
            if ((i & 64) != 0) {
                View viewFindViewById5 = view.findViewById(com.urbanairship.messagecenter.R.id.primaryText);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
                textView4 = (TextView) viewFindViewById5;
            } else {
                textView4 = textView;
            }
            if ((i & 128) != 0) {
                View viewFindViewById6 = view.findViewById(com.urbanairship.messagecenter.R.id.secondaryText);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
                textView5 = (TextView) viewFindViewById6;
            } else {
                textView5 = textView2;
            }
            if ((i & 256) != 0) {
                View viewFindViewById7 = view.findViewById(com.urbanairship.messagecenter.R.id.tertiaryText);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
                textView6 = (TextView) viewFindViewById7;
            } else {
                textView6 = textView3;
            }
            this(view, viewGroup3, viewGroup4, viewFindViewById, imageView2, checkBox2, textView4, textView5, textView6);
        }

        public final ViewGroup getUnreadContainer() {
            return this.unreadContainer;
        }

        public final View getUnreadIndicator() {
            return this.unreadIndicator;
        }

        public final ImageView getThumbnail() {
            return this.thumbnail;
        }

        public final CheckBox getCheckable() {
            return this.checkable;
        }

        public final TextView getPrimaryText() {
            return this.primaryText;
        }

        public final TextView getSecondaryText() {
            return this.secondaryText;
        }

        public final TextView getTertiaryText() {
            return this.tertiaryText;
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
