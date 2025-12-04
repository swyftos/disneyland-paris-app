package io.cucumber.cucumberexpressions;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.hermes.intl.Constants;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.picocontainer.Characteristics;

/* loaded from: classes5.dex */
public class GeneratedExpression {
    private static final Collator ENGLISH_COLLATOR = Collator.getInstance(Locale.ENGLISH);
    private static final String[] JAVA_KEYWORDS = {"abstract", "assert", "boolean", "break", "byte", Constants.SENSITIVITY_CASE, "catch", "char", "class", "const", "continue", "default", "do", DoubleTypedProperty.TYPE, "else", "extends", "false", "final", "finally", TypedValues.Custom.S_FLOAT, "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", LongTypedProperty.TYPE, "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", Characteristics.TRUE, "try", "void", "volatile", "while"};
    private final String expressionTemplate;
    private final List parameterTypes;

    public GeneratedExpression(String str, List<ParameterType<?>> list) {
        this.expressionTemplate = str;
        this.parameterTypes = list;
    }

    private static boolean isJavaKeyword(String str) {
        return Arrays.binarySearch(JAVA_KEYWORDS, str, ENGLISH_COLLATOR) >= 0;
    }

    public String getSource() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.parameterTypes.iterator();
        while (it.hasNext()) {
            arrayList.add(((ParameterType) it.next()).getName());
        }
        return String.format(this.expressionTemplate, arrayList.toArray());
    }

    private String getParameterName(String str, Map map) {
        Integer num = (Integer) map.get(str);
        int iIntValue = num != null ? num.intValue() + 1 : 1;
        Integer numValueOf = Integer.valueOf(iIntValue);
        map.put(str, numValueOf);
        if (iIntValue == 1 && !isJavaKeyword(str)) {
            return str;
        }
        return str + numValueOf;
    }

    public List<String> getParameterNames() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.parameterTypes.iterator();
        while (it.hasNext()) {
            arrayList.add(getParameterName(((ParameterType) it.next()).getName(), map));
        }
        return arrayList;
    }

    public List<ParameterType<?>> getParameterTypes() {
        return this.parameterTypes;
    }
}
