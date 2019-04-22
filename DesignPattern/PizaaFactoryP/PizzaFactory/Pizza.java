import sun.security.jca.GetInstance;

"abstract product factoryMethod()"
"a creator"-"creators"
"a product class"-"products"


//////////////////////////////////////////////////////////////
PizzaStore!~
//////////////////////////////////////////////////////////////

public abstract class PizzaStore    // abstract：各个商店继承此类
{
    
    // 订单处理一致,可以声明成 final防止子类覆盖
    //解耦：对抽象Pizza进行操作，不知道具体类的情况
    public Pizza orderPizza(String TYPE)    
    {
        Pizza pizza;
        pizza = new createPizza(TYPE);

        Pizza.prepare();
        Pizza.bake();
        Pizza.cut();
        Pizza.box();

        return pizza;
    }
    
    // 创建不同种类的pizza；abstract 子类必须继承实现
    abstract Pizza createPizza(String TYPE);   
}


//////////////////////////////////////////////////////////////
Pizza!~
//////////////////////////////////////////////////////////////

public abstract class Pizza
{
    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;

    ArrayList toppings = new ArrayList();
    
    abstract void prepare();

    void bake()
    {   System.out.println("Bake for 25 minutes at 350");   }

    void cut()
    {   System.out.println("Cutting th e pizza into diagonal slices");   }

    void box()
    {
        System.out.println("Place pizza in official PizzaStore box");    }

    void setName(String name)
    {   this.name = name;    }
    
    String getName()
    {   return name;    }

    public String toString()
    {   //print here the pizza number.   }
}


//////////////////////////////////////////////////////////////
PizzaIngredientFactory!~
//////////////////////////////////////////////////////////////

public interface PizzaIngredientFactory
{
    public Dough createDough();
    
    public Sauce createSauce();

    public Cheese createCheese();

    public Veggies[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClam();
}

