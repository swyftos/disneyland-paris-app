package androidx.test.uiautomator;

import android.util.Log;
import android.util.Xml;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TableLayout;
import androidx.autofill.HintConstants;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.IOException;
import java.io.OutputStream;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes2.dex */
abstract class AccessibilityNodeInfoDumper {
    private static final String LOGTAG = "AccessibilityNodeInfoDumper";
    private static final String[] NAF_EXCLUDED_CLASSES = {GridView.class.getName(), GridLayout.class.getName(), ListView.class.getName(), TableLayout.class.getName()};

    public static void dumpWindowHierarchy(UiDevice uiDevice, OutputStream outputStream) {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        xmlSerializerNewSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        xmlSerializerNewSerializer.setOutput(outputStream, "UTF-8");
        xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
        xmlSerializerNewSerializer.startTag("", "hierarchy");
        xmlSerializerNewSerializer.attribute("", "rotation", Integer.toString(uiDevice.getDisplayRotation()));
        for (AccessibilityNodeInfo accessibilityNodeInfo : uiDevice.getWindowRoots()) {
            dumpNodeRec(accessibilityNodeInfo, xmlSerializerNewSerializer, 0, uiDevice.getDisplayWidth(), uiDevice.getDisplayHeight());
        }
        xmlSerializerNewSerializer.endTag("", "hierarchy");
        xmlSerializerNewSerializer.endDocument();
    }

    private static void dumpNodeRec(AccessibilityNodeInfo accessibilityNodeInfo, XmlSerializer xmlSerializer, int i, int i2, int i3) throws IllegalStateException, IOException, IllegalArgumentException {
        xmlSerializer.startTag("", "node");
        if (!nafExcludedClass(accessibilityNodeInfo) && !nafCheck(accessibilityNodeInfo)) {
            xmlSerializer.attribute("", "NAF", Boolean.toString(true));
        }
        xmlSerializer.attribute("", "index", Integer.toString(i));
        xmlSerializer.attribute("", "text", safeCharSeqToString(accessibilityNodeInfo.getText()));
        xmlSerializer.attribute("", "resource-id", safeCharSeqToString(accessibilityNodeInfo.getViewIdResourceName()));
        xmlSerializer.attribute("", "class", safeCharSeqToString(accessibilityNodeInfo.getClassName()));
        xmlSerializer.attribute("", "package", safeCharSeqToString(accessibilityNodeInfo.getPackageName()));
        xmlSerializer.attribute("", "content-desc", safeCharSeqToString(accessibilityNodeInfo.getContentDescription()));
        xmlSerializer.attribute("", "checkable", Boolean.toString(accessibilityNodeInfo.isCheckable()));
        xmlSerializer.attribute("", "checked", Boolean.toString(accessibilityNodeInfo.isChecked()));
        xmlSerializer.attribute("", "clickable", Boolean.toString(accessibilityNodeInfo.isClickable()));
        xmlSerializer.attribute("", "enabled", Boolean.toString(accessibilityNodeInfo.isEnabled()));
        xmlSerializer.attribute("", "focusable", Boolean.toString(accessibilityNodeInfo.isFocusable()));
        xmlSerializer.attribute("", "focused", Boolean.toString(accessibilityNodeInfo.isFocused()));
        xmlSerializer.attribute("", "scrollable", Boolean.toString(accessibilityNodeInfo.isScrollable()));
        xmlSerializer.attribute("", "long-clickable", Boolean.toString(accessibilityNodeInfo.isLongClickable()));
        xmlSerializer.attribute("", HintConstants.AUTOFILL_HINT_PASSWORD, Boolean.toString(accessibilityNodeInfo.isPassword()));
        xmlSerializer.attribute("", "selected", Boolean.toString(accessibilityNodeInfo.isSelected()));
        xmlSerializer.attribute("", "visible-to-user", Boolean.toString(accessibilityNodeInfo.isVisibleToUser()));
        xmlSerializer.attribute("", "bounds", AccessibilityNodeInfoHelper.getVisibleBoundsInScreen(accessibilityNodeInfo, i2, i3).toShortString());
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
            if (child != null) {
                if (child.isVisibleToUser()) {
                    dumpNodeRec(child, xmlSerializer, i4, i2, i3);
                    child.recycle();
                } else {
                    Log.i(LOGTAG, String.format("Skipping invisible child: %s", child.toString()));
                }
            } else {
                Log.i(LOGTAG, String.format("Null child %d/%d, parent: %s", Integer.valueOf(i4), Integer.valueOf(childCount), accessibilityNodeInfo.toString()));
            }
        }
        xmlSerializer.endTag("", "node");
    }

    private static boolean nafExcludedClass(AccessibilityNodeInfo accessibilityNodeInfo) {
        String strSafeCharSeqToString = safeCharSeqToString(accessibilityNodeInfo.getClassName());
        for (String str : NAF_EXCLUDED_CLASSES) {
            if (strSafeCharSeqToString.endsWith(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean nafCheck(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.isEnabled() && safeCharSeqToString(accessibilityNodeInfo.getContentDescription()).isEmpty() && safeCharSeqToString(accessibilityNodeInfo.getText()).isEmpty()) {
            return childNafCheck(accessibilityNodeInfo);
        }
        return true;
    }

    private static boolean childNafCheck(AccessibilityNodeInfo accessibilityNodeInfo) {
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            if (!safeCharSeqToString(child.getContentDescription()).isEmpty() || !safeCharSeqToString(child.getText()).isEmpty() || childNafCheck(child)) {
                return true;
            }
        }
        return false;
    }

    private static String safeCharSeqToString(CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        return stripInvalidXMLChars(charSequence);
    }

    private static String stripInvalidXMLChars(CharSequence charSequence) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < charSequence.length(); i++) {
            char cCharAt = charSequence.charAt(i);
            if ((cCharAt >= 1 && cCharAt <= '\b') || ((cCharAt >= 11 && cCharAt <= '\f') || ((cCharAt >= 14 && cCharAt <= 31) || ((cCharAt >= 127 && cCharAt <= 132) || ((cCharAt >= 134 && cCharAt <= 159) || ((cCharAt >= 64976 && cCharAt <= 64991) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || ((cCharAt >= 65534 && cCharAt <= 65535) || (cCharAt >= 65534 && cCharAt <= 65535)))))))))))))))))))))) {
                stringBuffer.append(InstructionFileId.DOT);
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        return stringBuffer.toString();
    }
}
