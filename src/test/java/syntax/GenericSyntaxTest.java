package syntax;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenericSyntaxTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void t1(){
	}

	public <T> void t2(){
	}

	public <T> T t3(){
		return null;
	}

	public <T> T t4(T o){
		return null;
	}

	public <T> T t5(T o,Class<T> requriedType){
		return null;
	}

	public <T> List<T> t6(T o,Class<T> requriedType){
		return new ArrayList<T>();
	}

	
	private boolean isEmpty(List<? extends Object> list) { 
//                               - 받는 타입 Generic을 확장하고 싶을 경우 		                        
		return true;
	}
	
	private <C> List<C> process(C o, Class<C> requiredType) {
//		     - Generic의 클래스 타입을 메서드 인터페이스에서 사용하겠다고 선언
//		             - 리턴타입으로 사용
//                              - 전달받는 인자를 한정 할 수도 있다.
//                                         - Generic의 클래스 타입을 지정하여 받을 수 있다.
		
		List<C> ll = new ArrayList<C>();
		ll.add((C)o);
		return ll;
	}
	
	
	@Test
	public void _01()  {
		
		
	}

	@Test
	public void _02() {
		
		
		
	}


	
	
}
