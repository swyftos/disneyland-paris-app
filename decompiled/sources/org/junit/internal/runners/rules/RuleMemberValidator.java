package org.junit.internal.runners.rules;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.TestClass;

/* loaded from: classes6.dex */
public class RuleMemberValidator {
    public static final RuleMemberValidator CLASS_RULE_METHOD_VALIDATOR;
    public static final RuleMemberValidator CLASS_RULE_VALIDATOR;
    public static final RuleMemberValidator RULE_METHOD_VALIDATOR;
    public static final RuleMemberValidator RULE_VALIDATOR;
    private final Class annotation;
    private final boolean methods;
    private final List validatorStrategies;

    interface RuleValidator {
        void validate(FrameworkMember frameworkMember, Class cls, List list);
    }

    static {
        CLASS_RULE_VALIDATOR = classRuleValidatorBuilder().withValidator(new DeclaringClassMustBePublic()).withValidator(new MemberMustBeStatic()).withValidator(new MemberMustBePublic()).withValidator(new FieldMustBeATestRule()).build();
        RULE_VALIDATOR = testRuleValidatorBuilder().withValidator(new MemberMustBeNonStaticOrAlsoClassRule()).withValidator(new MemberMustBePublic()).withValidator(new FieldMustBeARule()).build();
        CLASS_RULE_METHOD_VALIDATOR = classRuleValidatorBuilder().forMethods().withValidator(new DeclaringClassMustBePublic()).withValidator(new MemberMustBeStatic()).withValidator(new MemberMustBePublic()).withValidator(new MethodMustBeATestRule()).build();
        RULE_METHOD_VALIDATOR = testRuleValidatorBuilder().forMethods().withValidator(new MemberMustBeNonStaticOrAlsoClassRule()).withValidator(new MemberMustBePublic()).withValidator(new MethodMustBeARule()).build();
    }

    RuleMemberValidator(Builder builder) {
        this.annotation = builder.annotation;
        this.methods = builder.methods;
        this.validatorStrategies = builder.validators;
    }

    public void validate(TestClass testClass, List<Throwable> list) {
        Iterator it = (this.methods ? testClass.getAnnotatedMethods(this.annotation) : testClass.getAnnotatedFields(this.annotation)).iterator();
        while (it.hasNext()) {
            validateMember((FrameworkMember) it.next(), list);
        }
    }

    private void validateMember(FrameworkMember frameworkMember, List list) {
        Iterator it = this.validatorStrategies.iterator();
        while (it.hasNext()) {
            ((RuleValidator) it.next()).validate(frameworkMember, this.annotation, list);
        }
    }

    private static Builder classRuleValidatorBuilder() {
        return new Builder(ClassRule.class);
    }

    private static Builder testRuleValidatorBuilder() {
        return new Builder(Rule.class);
    }

    private static class Builder {
        private final Class annotation;
        private boolean methods;
        private final List validators;

        private Builder(Class cls) {
            this.annotation = cls;
            this.methods = false;
            this.validators = new ArrayList();
        }

        Builder forMethods() {
            this.methods = true;
            return this;
        }

        Builder withValidator(RuleValidator ruleValidator) {
            this.validators.add(ruleValidator);
            return this;
        }

        RuleMemberValidator build() {
            return new RuleMemberValidator(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isRuleType(FrameworkMember frameworkMember) {
        return isMethodRule(frameworkMember) || isTestRule(frameworkMember);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTestRule(FrameworkMember frameworkMember) {
        return TestRule.class.isAssignableFrom(frameworkMember.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMethodRule(FrameworkMember frameworkMember) {
        return MethodRule.class.isAssignableFrom(frameworkMember.getType());
    }

    private static final class MemberMustBeNonStaticOrAlsoClassRule implements RuleValidator {
        private MemberMustBeNonStaticOrAlsoClassRule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember frameworkMember, Class cls, List list) {
            String str;
            boolean zIsMethodRule = RuleMemberValidator.isMethodRule(frameworkMember);
            boolean z = frameworkMember.getAnnotation(ClassRule.class) != null;
            if (frameworkMember.isStatic()) {
                if (zIsMethodRule || !z) {
                    if (RuleMemberValidator.isMethodRule(frameworkMember)) {
                        str = "must not be static.";
                    } else {
                        str = "must not be static or it must be annotated with @ClassRule.";
                    }
                    list.add(new ValidationError(frameworkMember, cls, str));
                }
            }
        }
    }

    private static final class MemberMustBeStatic implements RuleValidator {
        private MemberMustBeStatic() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember frameworkMember, Class cls, List list) {
            if (frameworkMember.isStatic()) {
                return;
            }
            list.add(new ValidationError(frameworkMember, cls, "must be static."));
        }
    }

    private static final class DeclaringClassMustBePublic implements RuleValidator {
        private DeclaringClassMustBePublic() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember frameworkMember, Class cls, List list) {
            if (isDeclaringClassPublic(frameworkMember)) {
                return;
            }
            list.add(new ValidationError(frameworkMember, cls, "must be declared in a public class."));
        }

        private boolean isDeclaringClassPublic(FrameworkMember frameworkMember) {
            return Modifier.isPublic(frameworkMember.getDeclaringClass().getModifiers());
        }
    }

    private static final class MemberMustBePublic implements RuleValidator {
        private MemberMustBePublic() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember frameworkMember, Class cls, List list) {
            if (frameworkMember.isPublic()) {
                return;
            }
            list.add(new ValidationError(frameworkMember, cls, "must be public."));
        }
    }

    private static final class FieldMustBeARule implements RuleValidator {
        private FieldMustBeARule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember frameworkMember, Class cls, List list) {
            if (RuleMemberValidator.isRuleType(frameworkMember)) {
                return;
            }
            list.add(new ValidationError(frameworkMember, cls, "must implement MethodRule or TestRule."));
        }
    }

    private static final class MethodMustBeARule implements RuleValidator {
        private MethodMustBeARule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember frameworkMember, Class cls, List list) {
            if (RuleMemberValidator.isRuleType(frameworkMember)) {
                return;
            }
            list.add(new ValidationError(frameworkMember, cls, "must return an implementation of MethodRule or TestRule."));
        }
    }

    private static final class MethodMustBeATestRule implements RuleValidator {
        private MethodMustBeATestRule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember frameworkMember, Class cls, List list) {
            if (RuleMemberValidator.isTestRule(frameworkMember)) {
                return;
            }
            list.add(new ValidationError(frameworkMember, cls, "must return an implementation of TestRule."));
        }
    }

    private static final class FieldMustBeATestRule implements RuleValidator {
        private FieldMustBeATestRule() {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
        public void validate(FrameworkMember frameworkMember, Class cls, List list) {
            if (RuleMemberValidator.isTestRule(frameworkMember)) {
                return;
            }
            list.add(new ValidationError(frameworkMember, cls, "must implement TestRule."));
        }
    }
}
