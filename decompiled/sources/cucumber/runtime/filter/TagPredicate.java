package cucumber.runtime.filter;

import gherkin.events.PickleEvent;
import gherkin.pickles.PickleTag;
import io.cucumber.tagexpressions.Expression;
import io.cucumber.tagexpressions.TagExpressionParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class TagPredicate implements PicklePredicate {
    private final List expressions = new ArrayList();
    private final List oldStyleExpressions = new ArrayList();

    public TagPredicate(List<String> list) {
        if (list == null) {
            return;
        }
        TagExpressionParser tagExpressionParser = new TagExpressionParser();
        for (String str : list) {
            if (TagExpressionOld.isOldTagExpression(str)) {
                this.oldStyleExpressions.add(new TagExpressionOld(Arrays.asList(str)));
            } else {
                this.expressions.add(tagExpressionParser.parse(str));
            }
        }
    }

    @Override // cucumber.runtime.filter.PicklePredicate
    public boolean apply(PickleEvent pickleEvent) {
        return apply(pickleEvent.pickle.getTags());
    }

    public boolean apply(Collection<PickleTag> collection) {
        Iterator it = this.oldStyleExpressions.iterator();
        while (it.hasNext()) {
            if (!((TagExpressionOld) it.next()).evaluate(collection)) {
                return false;
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PickleTag> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getName());
        }
        Iterator it3 = this.expressions.iterator();
        while (it3.hasNext()) {
            if (!((Expression) it3.next()).evaluate(arrayList)) {
                return false;
            }
        }
        return true;
    }
}
