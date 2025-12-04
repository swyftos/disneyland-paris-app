package io.cucumber.stepexpression;

import io.cucumber.cucumberexpressions.Expression;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class StepExpression {
    private final DocStringTransformer docStringType;
    private final Expression expression;
    private final RawTableTransformer tableType;

    StepExpression(Expression expression, DocStringTransformer docStringTransformer, RawTableTransformer rawTableTransformer) {
        this.expression = expression;
        this.docStringType = docStringTransformer;
        this.tableType = rawTableTransformer;
    }

    public List<Argument> match(String str, Type... typeArr) {
        List<io.cucumber.cucumberexpressions.Argument<?>> listMatch = this.expression.match(str, typeArr);
        if (listMatch == null) {
            return null;
        }
        return wrapPlusOne(listMatch);
    }

    public String getSource() {
        return this.expression.getSource();
    }

    public List<Argument> match(String str, List<List<String>> list, Type... typeArr) {
        List<Argument> listMatch = match(str, typeArr);
        if (listMatch == null) {
            return null;
        }
        listMatch.add(new DataTableArgument(this.tableType, list));
        return listMatch;
    }

    public List<Argument> match(String str, String str2, Type... typeArr) {
        List<Argument> listMatch = match(str, typeArr);
        if (listMatch == null) {
            return null;
        }
        listMatch.add(new DocStringArgument(this.docStringType, str2));
        return listMatch;
    }

    private static List wrapPlusOne(List list) {
        ArrayList arrayList = new ArrayList(list.size() + 1);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new ExpressionArgument((io.cucumber.cucumberexpressions.Argument) it.next()));
        }
        return arrayList;
    }
}
