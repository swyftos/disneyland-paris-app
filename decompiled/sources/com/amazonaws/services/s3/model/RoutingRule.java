package com.amazonaws.services.s3.model;

/* loaded from: classes2.dex */
public class RoutingRule {
    RoutingRuleCondition condition;
    RedirectRule redirect;

    public void setCondition(RoutingRuleCondition routingRuleCondition) {
        this.condition = routingRuleCondition;
    }

    public RoutingRuleCondition getCondition() {
        return this.condition;
    }

    public RoutingRule withCondition(RoutingRuleCondition routingRuleCondition) {
        setCondition(routingRuleCondition);
        return this;
    }

    public void setRedirect(RedirectRule redirectRule) {
        this.redirect = redirectRule;
    }

    public RedirectRule getRedirect() {
        return this.redirect;
    }

    public RoutingRule withRedirect(RedirectRule redirectRule) {
        setRedirect(redirectRule);
        return this;
    }
}
