package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/ioc/application-context-collection.xml"})
public class CollectionInjectTest {
	
	@Resource(name="collectionBean")
	private CollectionBean collectionBean;
	
	/**
	* Method : CollectionBeanTest
	* 작성자 : pc17
	* 변경이력 :
	* Method 설명 : 스프링 설정파일을 통해 collection 객체 주입이 
	* 		제대로 이루어졌는지 테스트
	*/
	@Test
	public void CollectionBeanTest() {
		
		/***Given***/
		
		/***When***/
		List<String> list = collectionBean.getList();
		Set<String> set = collectionBean.getSet();
		Map<String, String> map = collectionBean.getMap();
		Properties property = collectionBean.getProperty();

		/***Then***/
		assertNotNull(collectionBean); //스프링 컨테이너에서 DL을 받은 빈:정상이면 not null이어야함
		assertEquals(3, list.size());
		assertEquals("brown", list.get(0));
		
		assertEquals(3, set.size());
		assertEquals(false, set.add("brown_set"));
		
		assertEquals("brown", map.get("name"));
		assertEquals("15", map.get("age"));
		
		assertEquals("pc17", property.getProperty("db.user"));
		assertEquals("java", property.getProperty("db.password"));
	}

}
