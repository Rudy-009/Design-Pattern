public class MainCoffee {
	public static void main(String[] args) {
		
        // CoffeeFactory를 사용하여 에스프레소 생성
        CoffeeFactory factory = new CoffeeFactory();
        Coffee espresso = factory.createCoffee("Espresso");

        // 데코레이터 체인을 통해 여러 옵션 추가
        Coffee milkEspresso = new MilkDecorator(espresso);
        Coffee syrupMilkEspresso = new SyrupDecorator(milkEspresso);
        Coffee whipCreamSyrupMilkEspresso = new WhipCreamDecorator(syrupMilkEspresso);

        // 출력 형식 개선
        System.out.println("주문: 에스프레소 + 우유 + 시럽 + 휘핑크림");
        System.out.println("설명: " + whipCreamSyrupMilkEspresso.getDescription());
        System.out.println("최종 가격: " + whipCreamSyrupMilkEspresso.getCost() + "원");
    }
}

abstract class Coffee {
	private String name;
	private double basePrice;
	
	public Coffee(String name, double basePrice) {
		this.name = name;
		this.basePrice = basePrice;
	}
	
	public String getDescription(){
		return this.name;
	}
	
	public double getCost() {
		return this.basePrice;
	}
}

class Espresso extends Coffee {
	
	public Espresso() {
		super("Espresso", 3000);
	}
}

class Americano extends Coffee {
	
	public Americano() {
		super("Americano", 3500);
	}
}

class Latte extends Coffee {
	
	public Latte() {
		super("Latte", 3500);
	}
}

abstract class CoffeeDecorator extends Coffee {
	protected Coffee decoratedCoffee;
	
	public CoffeeDecorator(Coffee coffee) {
		super(coffee.getDescription(), coffee.getCost());
        this.decoratedCoffee = coffee;   
    }
	
}

class MilkDecorator extends CoffeeDecorator {
	
	public MilkDecorator(Coffee coffee) {
		super(coffee);
	}
	
	@Override
	public String getDescription(){
		return this.decoratedCoffee.getDescription() + ", Milk";
	}
	
	@Override
	public double getCost() {
		return this.decoratedCoffee.getCost() + 500;
	}
	
}

class SyrupDecorator extends CoffeeDecorator {
	
	public SyrupDecorator(Coffee coffee) {
		super(coffee);
	}
	
	@Override
	public String getDescription(){
		return this.decoratedCoffee.getDescription() + ", Syrup";
	}
	
	@Override
	public double getCost() {
		return this.decoratedCoffee.getCost() + 300;
	}
}

class WhipCreamDecorator extends CoffeeDecorator {
	
	public WhipCreamDecorator(Coffee coffee) {
		super(coffee);
	}
	
	@Override
	public String getDescription(){
		return this.decoratedCoffee.getDescription() + ", Whip Cream";
	}
	
	@Override
	public double getCost() {
		return this.decoratedCoffee.getCost() + 400;
	}
}