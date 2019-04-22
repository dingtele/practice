package product;

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

