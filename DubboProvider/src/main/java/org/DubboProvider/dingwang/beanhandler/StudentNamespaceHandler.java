package org.DubboProvider.dingwang.beanhandler;

import org.DubboProvider.dingwang.beanparse.StudentBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 类StudentNamespaceHandler.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年3月11日 上午11:45:09
 */
public class StudentNamespaceHandler extends NamespaceHandlerSupport {

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.xml.NamespaceHandler#init()
     */
    public void init() {
        registerBeanDefinitionParser("student", new StudentBeanDefinitionParser());
    }

}
