package com.cgling.tms.config.jdbc;

import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author houguangqiang
 * @date 2017-12-19
 * @since 1.0
 */
@Configuration
public class TransactionalConfig {

    @Bean
    public PointcutAdvisor pointcutAdvisor(PlatformTransactionManager transactionManager){
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        String expression = "execution (* com.cgling.tms..service.*.*(..))";
        pointcut.setExpression(expression);
        return new DefaultPointcutAdvisor(pointcut, new TransactionInterceptor(transactionManager, transactionAttributeSource()));
    }

    private TransactionAttributeSource transactionAttributeSource(){
        NameMatchTransactionAttributeSource transactionAttributeSource = new NameMatchTransactionAttributeSource();
        RuleBasedTransactionAttribute requiredReadOnlyRule = requiredReadOnlyRule();
        RuleBasedTransactionAttribute supportsReadOnlyRule = supportsReadOnlyRule();
        RuleBasedTransactionAttribute requiredRule = requiredRule();
        for (String methodName : getRequiredMethodNames()) {
            transactionAttributeSource.addTransactionalMethod(methodName, requiredRule);
        }
        for (String methodName : getSupportsReadOnlyMethodNames()) {
            transactionAttributeSource.addTransactionalMethod(methodName, supportsReadOnlyRule);
        }
        for (String methodName : getRequiredReadOnlyMethodNames()) {
            transactionAttributeSource.addTransactionalMethod(methodName, requiredReadOnlyRule);
        }
        return transactionAttributeSource;
    }

    private List<String> getRequiredMethodNames(){
        List<String> methodNames = new ArrayList<>();
        methodNames.add("add*");
        methodNames.add("save*");
        methodNames.add("create*");
        methodNames.add("delete*");
        methodNames.add("remove*");
        methodNames.add("update*");
        methodNames.add("batch*");
        methodNames.add("mass*");
        methodNames.add("submit*");
        return methodNames;
    }

    private List<String> getRequiredReadOnlyMethodNames(){
        List<String> methodNames = new ArrayList<>();
        methodNames.add("*");
        return methodNames;
    }

    private List<String> getSupportsReadOnlyMethodNames(){
        List<String> methodNames = new ArrayList<>();
        methodNames.add("query*");
        methodNames.add("get*");
        return methodNames;
    }

    /**
     * REQUIRED事务
     * {@link org.springframework.transaction.annotation.Propagation#REQUIRED}
     */
    private RuleBasedTransactionAttribute requiredRule() {
        RuleBasedTransactionAttribute required = new RuleBasedTransactionAttribute();
        required.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        return required;
    }

    /**
     * Supports且ReadOnly只读事务
     * {@link org.springframework.transaction.annotation.Propagation#SUPPORTS}
     */
    private RuleBasedTransactionAttribute supportsReadOnlyRule() {
        RuleBasedTransactionAttribute notSupported = new RuleBasedTransactionAttribute();
        notSupported.setReadOnly(true);
        notSupported.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);
        return notSupported;
    }

    /**
     * Required且ReadOnly事务
     * {@link org.springframework.transaction.annotation.Propagation#REQUIRED}
     */
    private RuleBasedTransactionAttribute requiredReadOnlyRule() {
        RuleBasedTransactionAttribute readOnly = new RuleBasedTransactionAttribute();
        readOnly.setReadOnly(true);
        readOnly.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        return readOnly;
    }
}
