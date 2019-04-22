package creator;

public abstract class PizzaStore    // abstractï¼šå�„ä¸ªå•†åº—ç»§æ‰¿æ­¤ç±»
{
    
    // è®¢å�•å¤„ç�†ä¸€è‡´,å�¯ä»¥å£°æ˜Žæˆ� finalé˜²æ­¢å­�ç±»è¦†ç›–
    //è§£è€¦ï¼šå¯¹æŠ½è±¡Pizzaè¿›è¡Œæ“�ä½œï¼Œä¸�çŸ¥é�“å…·ä½“ç±»çš„æƒ…å†µ
    public Pizza orderPizza(String TYPE)    
    {
        Pizza pizza;
        pizza = new createPizza(TYPE);
.
        Pizza.prepare();
        Pizza.bake();
        Pizza.cut();
        Pizza.box();

        return pizza;
    }
    
    // åˆ›å»ºä¸�å�Œç§�ç±»çš„pizzaï¼›abstract å­�ç±»å¿…é¡»ç»§æ‰¿å®žçŽ°
    abstract Pizza createPizza(String TYPE);   
}