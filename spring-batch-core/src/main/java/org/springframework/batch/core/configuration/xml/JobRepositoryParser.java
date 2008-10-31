/*
 * Copyright 2006-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.batch.core.configuration.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * Parser for the lt;job-repository/gt; element in the Batch namespace. Sets up and returns
 * a JobRepositoryFactoryBean.
 * 
 * @author Thomas Risberg
 * @since 2.0
 * 
 */
public class JobRepositoryParser extends AbstractSingleBeanDefinitionParser {

	private final Log logger = LogFactory.getLog(getClass());

    protected String getBeanClassName(Element element) {
        return "org.springframework.batch.core.repository.support.JobRepositoryFactoryBean";
    }

	/**
	 * Parse and create a bean definition for a 
	 * {@link org.springframework.batch.core.repository.support.JobRepositoryFactoryBean}. 
	 */
    protected void doParse(Element element, BeanDefinitionBuilder builder) {

        String dataSource = element.getAttribute("data-source");

        String transactionManager = element.getAttribute("transaction-manager");

        if (logger.isDebugEnabled()) {
            logger.debug("Using data-source: " + dataSource);
            logger.debug("Using transaction-manager: " + transactionManager);
        }

        RuntimeBeanReference ds = new RuntimeBeanReference(dataSource);
        builder.addPropertyValue("dataSource", ds);
        RuntimeBeanReference tx = new RuntimeBeanReference(transactionManager);
        builder.addPropertyValue("transactionManager", tx);

        builder.setRole(BeanDefinition.ROLE_SUPPORT);

    }

}