interface Entity {
  public void buy(int cost);
}

public class Market
{
  public int transaction_count;  // 交易次数

  // 假设市场当中的交易行为必须在市场的主持下进行
  public void transaction(Entity entity, int cost)
  {
    entity.buy(cost);
    this.transaction_count += 1;
  }

  public static void main(String[] args)
  {
    Person person = new Person("pmst", 18);
    Company company = new Company("company", 20.0, 0.02);

    Market market = new Market();
    market.transaction((Entity) person, 10);
    market.transaction((Entity) company, 10);

    System.out.printf("进行了%d次交易 \n", market.transaction_count);
    System.out.printf("Person %s 目前的余额: %s \n", person.getName(), person.getBalance());
    System.out.printf("Company %s 目前的余额: %s \n", company.getName(), company.getBalance());
  }
}

class Company implements Entity
{
  private String name;
  private double balance;
  private double commission;

  public Company(String name, double balance, double commission)
  {
    this.name = name;
    this.balance = balance;
    this.commission = commission;
  }

  public void buy(int cost)
  {
    // 假设公司购买行为需要额外交手续非
    this.balance -= (double)cost * (1 + this.commission);
  }

  public String getName()
  {
    return this.name;
  }

  public double getBalance()
  {
    return this.balance;
  }
}

class Person implements Entity
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

}
