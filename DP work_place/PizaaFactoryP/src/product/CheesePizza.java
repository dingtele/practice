package product;

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
