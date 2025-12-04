package cucumber.runtime.filter;

import gherkin.GherkinLanguageConstants;
import gherkin.pickles.PickleTag;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
class TagExpressionOld {
    private static final Logger logger = LoggerFactory.getLogger(TagExpressionOld.class);
    private final Map limits = new HashMap();
    private And and = new And();

    private interface Expression {
        boolean eval(Collection collection);
    }

    static boolean isOldTagExpression(String str) {
        if (str == null) {
            return false;
        }
        if (str.contains(",")) {
            logger.warn("Found tags option '" + str + "'. Support for '@tag1,@tag2' will be removed from the next release of Cucumber-JVM. Please use '@tag or @tag2' instead");
        }
        if (str.contains("~")) {
            logger.warn("Found tags option '" + str + "'. Support for '~@tag' will be removed from the next release of Cucumber-JVM. Please use 'not @tag' instead.");
        }
        return str.contains(",") || str.contains("~");
    }

    TagExpressionOld(List list) throws NumberFormatException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            add(((String) it.next()).split("\\s*,\\s*"));
        }
    }

    boolean evaluate(Collection collection) {
        return this.and.isEmpty() || this.and.eval(collection);
    }

    private void add(String[] strArr) throws NumberFormatException {
        boolean z;
        Or or = new Or();
        for (String str : strArr) {
            String strTrim = str.trim();
            if (strTrim.startsWith("~")) {
                strTrim = strTrim.substring(1);
                z = true;
            } else {
                z = false;
            }
            String[] strArrSplit = strTrim.split(":");
            if (strArrSplit.length == 2) {
                strTrim = strArrSplit[0];
                int i = Integer.parseInt(strArrSplit[1]);
                if (this.limits.containsKey(strTrim) && ((Integer) this.limits.get(strTrim)).intValue() != i) {
                    throw new BadTagLimitException(strTrim, ((Integer) this.limits.get(strTrim)).intValue(), i);
                }
                this.limits.put(strTrim, Integer.valueOf(i));
            }
            if (z) {
                or.add(new Not(new TagExp(strTrim)));
            } else {
                or.add(new TagExp(strTrim));
            }
        }
        this.and.add(or);
    }

    private class Not implements Expression {
        private final Expression expression;

        Not(Expression expression) {
            this.expression = expression;
        }

        @Override // cucumber.runtime.filter.TagExpressionOld.Expression
        public boolean eval(Collection collection) {
            return !this.expression.eval(collection);
        }
    }

    private class And implements Expression {
        private List expressions;

        private And() {
            this.expressions = new ArrayList();
        }

        public void add(Expression expression) {
            this.expressions.add(expression);
        }

        @Override // cucumber.runtime.filter.TagExpressionOld.Expression
        public boolean eval(Collection collection) {
            Iterator it = this.expressions.iterator();
            boolean zEval = true;
            while (it.hasNext() && (zEval = ((Expression) it.next()).eval(collection))) {
            }
            return zEval;
        }

        public boolean isEmpty() {
            return this.expressions.isEmpty();
        }
    }

    private class Or implements Expression {
        private List expressions;

        private Or() {
            this.expressions = new ArrayList();
        }

        public void add(Expression expression) {
            this.expressions.add(expression);
        }

        @Override // cucumber.runtime.filter.TagExpressionOld.Expression
        public boolean eval(Collection collection) {
            Iterator it = this.expressions.iterator();
            boolean zEval = false;
            while (it.hasNext() && !(zEval = ((Expression) it.next()).eval(collection))) {
            }
            return zEval;
        }
    }

    private class TagExp implements Expression {
        private final String tagName;

        TagExp(String str) {
            if (!str.startsWith(GherkinLanguageConstants.TAG_PREFIX)) {
                throw TagExpressionOld.this.new BadTagException(str);
            }
            this.tagName = str;
        }

        @Override // cucumber.runtime.filter.TagExpressionOld.Expression
        public boolean eval(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (this.tagName.equals(((PickleTag) it.next()).getName())) {
                    return true;
                }
            }
            return false;
        }
    }

    private class BadTagException extends RuntimeException {
        BadTagException(String str) {
            super("Bad tag: \"" + str + "\"");
        }
    }

    private class BadTagLimitException extends RuntimeException {
        BadTagLimitException(String str, int i, int i2) {
            super("Inconsistent tag limits for " + str + ": " + i + " and " + i2);
        }
    }
}
