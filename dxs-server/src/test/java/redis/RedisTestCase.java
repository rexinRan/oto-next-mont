package redis;

import com.buss.common.redis.RedisClient;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RedisTestCase extends TestCase {

  private AbstractApplicationContext ctx;

  @Before
  public void setUp() throws Exception {
    ctx = new ClassPathXmlApplicationContext(new String[] {"spring/spring-redis.xml"});
    System.out.println("####start");
  }
  @After
  public void tearDown() throws Exception {
    ctx = null;
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testRedis1() {
    RedisClient<String, Object> client = (RedisClient<String, Object>) ctx.getBean("redisClient");
    // 其中key采取了StringRedisSerializer
    // 其中value采取JdkSerializationRedisSerializer
    User user = new User("jerry.king", 30);
    client.put("userInfo1", user);
    User user2 = (User) client.get("userInfo1");
    System.out.println(user2.getName() + ":" + user2.getAge());

    Person person = new Person();
    person.setId("1");
    person.setName("lingmincc");
    person.setAge(30);

    Address address = new Address();
    address.setTown("闲林山水");
    address.setStreet("紫薇苑");
    address.setNumber("13989485725");
    address.setPostcode("310012");

    Address address2 = new Address();
    address2.setTown("闲林山水2");
    address2.setStreet("紫薇苑2");
    address2.setNumber("13989485726");
    address2.setPostcode("310013");

    List<Address> addressList = new ArrayList<Address>();
    addressList.add(address);
    addressList.add(address2);
    person.setAddress(addressList);

    String pKey = "person_" + Math.random();
    System.out.println("Person Key ========>>>> " + pKey);
    client.put(pKey, person);
    Person p = (Person) client.get(pKey);
    System.out.println("Person:" + p);
/*
    String lKey = "listKey" + Math.random();

    client.putList(lKey, addressList);
    List<Address> adLst = (List<Address>) client.getList(lKey);
    System.out.println(adLst);

    System.out.println("contains key [stringKey]:" + client.containsKey(lKey));
    System.out.println("expiredTimes[stringKey]:" + client.getExpire(lKey));
*/
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testRedisRestore() {
    RedisClient<String, Object> client = (RedisClient<String, Object>) ctx.getBean("redisClient");

    String key = "list";
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    User user = new User("jerry.king", 30);
    client.put("userInfo1", user);
    User user2 = (User) client.get("userInfo1");
    System.out.println(user2.getName() + ":" + user2.getAge());

    Person person = new Person();
    person.setId("1");
    person.setName("lingmincc");
    person.setAge(30);

    Address address = new Address();
    address.setTown("闲林山水");
    address.setStreet("紫薇苑");
    address.setNumber("13989485725");
    address.setPostcode("310012");

    Address address2 = new Address();
    address2.setTown("闲林山水2");
    address2.setStreet("紫薇苑2");
    address2.setNumber("13989485726");
    address2.setPostcode("310013");

    List<Address> addressList = new ArrayList<Address>();
    addressList.add(address);
    addressList.add(address2);
    person.setAddress(addressList);

    client.put(key, addressList);

    System.out.println(client.get(key));
    System.out.println("contains key [stringKey]:" + client.containsKey(key));
    System.out.println("expiredTimes[stringKey]:" + client.getExpire(key));

  }

  @SuppressWarnings("unchecked")
  @Test
  public void testExpireDate1() {
    RedisClient<String, Object> client = (RedisClient<String, Object>) ctx.getBean("redisClient");
    String key = "list";

    if (client.containsKey(key)) {
      System.out.println("expiredTimes[stringKey]:" + client.getExpire(key));
      System.out.println(client.get(key));
      return;
    }

    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    client.put(key, list);
    System.out.println(client.get(key));
  }

  @SuppressWarnings({ "unchecked", "deprecation" })
  @Test
  public void testExpireDate2() {
    RedisClient<String, Object> client = (RedisClient<String, Object>) ctx.getBean("redisClient");
    String key = "EXPIRE_TEST_KEY";
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    Date expiredDate = new Date(2014 - 1900, 3, 16);
    if (!client.containsKey(key)) {
      System.out.println(expiredDate);
      client.put(key, list, expiredDate);
    }
    System.out.println(client.get(key));

    for (;;) {
      if (client.containsKey(key)) {
        System.out.println("expiredTimes[stringKey]:" + client.getExpire(key));
        try {
          Thread.sleep(1000);
          System.out.println(key + " /\\_/|_/_\\=- alive -=/\\_/|_/_\\");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } else {
        System.out.println(key + " already dead !");
        return;
      }
    }
  }

  /**
   * 
   * 如果使用jdk序列化方式，bean必须实现Serializable，且提供getter/setter方法
   * 
   */
  static class User implements Serializable {

    private static final long serialVersionUID = -3766780183428993793L;
    private String            name;
    private Date              created;
    private int               age;

    public User() {
    }
    public User(String name, int age) {
      this.name = name;
      this.age = age;
      this.created = new Date();
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public Date getCreated() {
      return created;
    }
    public void setCreated(Date created) {
      this.created = created;
    }
    public int getAge() {
      return age;
    }
    public void setAge(int age) {
      this.age = age;
    }

  }
}
