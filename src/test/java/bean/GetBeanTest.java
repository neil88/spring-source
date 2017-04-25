package bean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml"})  
public class GetBeanTest {
	
	@Autowired
	Person person;
	
	@Test
	public void testGetBean(){
		System.out.println(person.getName() + ":" + person.getAge());
	}
	
	public static void main(String[] args) {
		ClassPathResource res = new ClassPathResource("spring/applicationContext.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(factory);
		xbdr.loadBeanDefinitions(res);
		Object bean = factory.getBean("person");
		System.out.println(bean);
	}
}
