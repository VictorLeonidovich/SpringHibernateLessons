package configuration.lesson21p195

import org.springframework.context.support.GenericApplicationContext
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader

def ctx = new GenericApplicationContext()
def reader = new GroovyBeanDefinitionReader(ctx)
reader.beans{
	contact(Contact, firstName: 'Vic', lastName: 'K', age: 32)
}

ctx.refresh()

println ctx.getBean("contact")