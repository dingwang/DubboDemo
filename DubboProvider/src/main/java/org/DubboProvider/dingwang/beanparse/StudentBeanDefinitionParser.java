package org.DubboProvider.dingwang.beanparse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * 类StudentBeanDefinitionParser.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年3月11日 上午11:26:23
 */
public class StudentBeanDefinitionParser implements BeanDefinitionParser {

    private static final Logger logger = LoggerFactory.getLogger(StudentBeanDefinitionParser.class);

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.beans.factory.xml.BeanDefinitionParser#parse(org.w3c.
     * dom.Element, org.springframework.beans.factory.xml.ParserContext)
     */
    public BeanDefinition parse(Element element, ParserContext parserContext) {

        RootBeanDefinition beanDefinition = new RootBeanDefinition();

        String className = element.getAttribute("class");
        try {
            beanDefinition.setBeanClass(Class.forName(className));
        } catch (ClassNotFoundException e) {
            logger.error("cannot find the class:" + className);
            return null;
        }
        String id = element.getAttribute("id");
        if (id == null) {
            id = className;
        }

        if (id == null) {
            throw new IllegalArgumentException("bean id is null");
        } else {
            if (parserContext.getRegistry().containsBeanDefinition(id)) {
                logger.error("Duplicate bean definition id=" + id);
                throw new IllegalStateException("Duplicate bean definition id=" + id);
            }
        }
        //将bean注入beanDefinitionMap
        parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);
        //        beanDefinition.getPropertyValues().addPropertyValue("id", id);

        String name = element.getAttribute("name");
        String age = element.getAttribute("age");

        if (StringUtils.isNotBlank(age)) {
            beanDefinition.getPropertyValues().addPropertyValue("age", Integer.valueOf(age));
        }

        if (StringUtils.isNotBlank(name)) {
            beanDefinition.getPropertyValues().addPropertyValue("name", name);
        }

        return beanDefinition;
    }

}
