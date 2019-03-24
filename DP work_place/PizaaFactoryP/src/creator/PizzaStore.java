package creator;

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