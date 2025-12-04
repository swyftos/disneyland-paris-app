package com.urbanairship.actions;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.urbanairship.UALog;
import com.urbanairship.actions.ActionRegistry;
import com.urbanairship.util.UAStringUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
abstract class ActionEntryParser {
    public static List fromXml(Context context, int i) throws Resources.NotFoundException {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            return parseEntries(xml);
        } catch (Resources.NotFoundException | IOException | NullPointerException | XmlPullParserException e) {
            UALog.e(e, "Failed to parse action entries.", new Object[0]);
            return new ArrayList();
        } finally {
            xml.close();
        }
    }

    private static List parseEntries(XmlResourceParser xmlResourceParser) throws XmlPullParserException {
        ActionRegistry.Entry entry;
        ArrayList arrayList = new ArrayList();
        while (xmlResourceParser.next() != 1) {
            int eventType = xmlResourceParser.getEventType();
            String name = xmlResourceParser.getName();
            if (eventType == 2 && "ActionEntry".equals(name) && (entry = parseEntry(xmlResourceParser)) != null) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    private static ActionRegistry.Entry parseEntry(XmlResourceParser xmlResourceParser) throws XmlPullParserException {
        String name;
        String attributeValue = xmlResourceParser.getAttributeValue(null, "class");
        String attributeValue2 = xmlResourceParser.getAttributeValue(null, "predicate");
        ArrayList arrayList = new ArrayList();
        while (xmlResourceParser.next() != 1) {
            int eventType = xmlResourceParser.getEventType();
            String name2 = xmlResourceParser.getName();
            if (eventType == 2 && "name".equals(name2) && (name = parseName(xmlResourceParser)) != null) {
                arrayList.add(name);
            }
            if (eventType == 3 && "ActionEntry".equals(name2)) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            UALog.e("Action names not found.", new Object[0]);
            return null;
        }
        try {
            ActionRegistry.Entry entry = new ActionRegistry.Entry(Class.forName(attributeValue).asSubclass(Action.class), arrayList);
            if (!UAStringUtil.isEmpty(attributeValue2)) {
                try {
                    entry.setPredicate((ActionRegistry.Predicate) Class.forName(attributeValue2).asSubclass(ActionRegistry.Predicate.class).newInstance());
                } catch (Exception unused) {
                    UALog.e("Predicate class %s not found. Skipping predicate.", attributeValue2);
                }
            }
            return entry;
        } catch (ClassNotFoundException unused2) {
            UALog.e("Action class %s not found.", attributeValue);
            return null;
        }
    }

    private static String parseName(XmlResourceParser xmlResourceParser) throws XmlPullParserException {
        while (xmlResourceParser.next() != 1) {
            int eventType = xmlResourceParser.getEventType();
            String name = xmlResourceParser.getName();
            if (eventType == 4) {
                return xmlResourceParser.getText();
            }
            if (eventType == 3 && "name".equals(name)) {
                return null;
            }
        }
        return null;
    }
}
