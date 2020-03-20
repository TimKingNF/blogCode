interface Entity {
  public void buy(int cost);
}

public class Person implements Entity
{
  private String name;
  private int balance;

  // 构造方法
  public Person(String name, int balance)
  {
    this.name = name;
    this.balance = balance;
  }

  public void buy(int cost)
  {
    this.balance -= cost;
  }

  public String getName()
  {
    return this.name;
  }

  public int getBalance()
  {
    return this.balance;
  }

  public static void main(String[] args)
  {
    Person person = new Person("pmst", 18);  // 初始化对象
    person.buy(10);  // 调用对象的buy method
    System.out.printf("%s balance: %d \n", person.getName(), person.getBalance());

    // 抽象性
    Entity entity = new Person("entity", 20);
    entity.buy(10);
    if (entity instanceof Person) {
      Person p = (Person) entity;
      System.out.printf("%s balance: %d \n", p.getName(), p.getBalance());
    }
  }
}
