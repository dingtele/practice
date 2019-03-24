package creator;

//加盟店 子类实现 2
//不需要orderPizza（），已被继承，无需知道是哪个具体类调用
public class NYPizzaStore2 extends PizzaStore
{
  protected Pizza createPizza(String item)
  {
      Pizza pizza = null;
      PizzaIngredientFactory ingredientFactory = 
          new PizzaIngredientFactory();
      if(item.equals("cheese"))
      {
      pizaa = new CheesePizza(ingredientFactory);
      pizza.setName("New York Style Cheese Pizza");
      }else if(item.equals("veggie"))
      {
      pizaa = new VeggiePizza(ingredientFactory);
      pizza.setName("New York Style Veggie Pizza");

      }else if(item.equals("clam"))
      {
      pizaa = new ClamPizza(ingredientFactory);
      pizza.setName("New York Style Clam Pizza");

      }else if(item.equals("pepperoni"))
      {
      pizaa = new PepperoniPizza(ingredientFactory);
      pizza.setName("New York Style Pepperoni Pizza");

      }
      retun pizza;
  }
} 
