package creator;

//加盟店 子类实现 1
//不需要orderPizza（），已被继承，无需知道是哪个具体类调用
public class NYPizzaStore extends PizzaStore
(
  Pizza createPizza(String item)
  {
      if(item.equals("cheese"))
      {
          return new NYStyleCheesePizza();
      }else 
      if(item.equals("veggie"))
      {
          return new NYStyleVeggiePizza();
      }else 
      if(item.equals("clam"))
      {
          return new NYStyleClamPizza();
      }else 
      if(item.equals("pepperoni"))
      {
          return new NYStylePepperoniPizza();
      }else retun null;
  }
)   