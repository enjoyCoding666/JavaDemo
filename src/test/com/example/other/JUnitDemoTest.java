package test.com.example.other; 

import com.example.other.JUnitDemo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;

/** 
* JUnitDemo Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 15, 2017</pre> 
* @version 1.0 
*/ 
public class JUnitDemoTest { 
  private JUnitDemo jud;
@Before
public void before() throws Exception {
    System.out.println("���Կ�ʼ ");
    jud=new JUnitDemo();
} 

@After
public void after() throws Exception {
    System.out.println("���Խ��� ");
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here...
    System.out.println("main����");
} 

/** 
* 
* Method: addNumber(int number1, int number2) 
* 
*/ 
@Test
public void testAddNumber() throws Exception { 
//TODO: Test goes here...

    Assert.assertEquals(7,jud.addNumber(5,2));
    System.out.println("�ӷ�����");
} 

/** 
* 
* Method: subtractNumber(int number1, int number2) 
* 
*/ 
@Test
public void testSubtractNumber() throws Exception { 
//TODO: Test goes here...
    Assert.assertEquals(3,jud.subtractNumber(5,2));
    System.out.println("��������");
} 


} 
