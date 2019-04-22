//////////////////////////////////////////////////////////////
write yourself a pizza store!~
//////////////////////////////////////////////////////////////

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



//加盟店 子类实现 2
//不需要orderPizza（），已被继承，无需知道是哪个具体类调用
public class NYPizzaStore2 extends PizzaStore
{
    protected Pizza createPizza(String item)
    {
        Pizza pizza = null;
        PizzaIngredientFactory i`   qa2w3eactory();
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



//////////////////////////////////////////////////////////////

# OLD VERSION #  write yourself a pizza!~
//////////////////////////////////////////////////////////////

//风味pizza 子类实现 2
public class NYStyleCheesePizza extends Pizza
{
    public NYStyleCheesePizza()
    {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }

    //覆盖Cut，将pizza切成正方形
    void cut()
    {   System.out.println("Cutting the pizza into square slices"); }
}


//////////////////////////////////////////////////////////////
place yourself a pizza order!~
//////////////////////////////////////////////////////////////
//客户下单
PizzaStore nyPizzaStore = new NYPizzaStore;
nyPizzaStore.orderPizza("cheese");
Pizza pizza = createPizza("cheese");


//////////////////////////////////////////////////////////////
eat yourself a pizza!~
//////////////////////////////////////////////////////////////
public class PizzaTestDrive
{
    public static void main(String[] args)
    {
        PizzaStore nyStore = new NYPizzaStore;
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("DING yue ordered a" + pizza.getName() + "\n");
    }
}

//////////////////////////////////////////////////////////////
write yourself a NYPizzaIngredientFactory!~
//////////////////////////////////////////////////////////////
pubilc class NYPizzaIngredientFactory implements PizzaIngredientFactory
{
    public Dough createDough()
    {
        return new ThinCrustDough();
    }
    
    public Sauce createSauce()
    {
        return new MarinaraSauce();
    }

    public Cheese createCheese()
    {
        return new ReggianoCheese();
    }

    public Veggies[] createVeggies();
    {
        Veggies veggies[] = {   new Garlic(), new Mushroom(), new RedPepper()    };
        return veggies;
    }

    public Pepperoni createPepperoni()
    {
        return new SlicedPepperoni();
    }

    public Clams createClam()
    {
        return new FreshClams();
    }
}

//////////////////////////////////////////////////////////////
eat yourself a Pizza from fresh ingredients!~
//////////////////////////////////////////////////////////////

public class CheesePizza extends Pizza
{
    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory)
    {
        this.ingredientFactory = ingredientFactory;
    }

    void prepare()
    {
         System.out.println("preparing" + name);
         dough = ingredientFactory.createDough();
         sauce = ingredientFactory.createSauce();
         cheese = ingredientFactory.createCheese();         
    }
}