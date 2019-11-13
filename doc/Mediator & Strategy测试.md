## Strategy设计模式测试

### 测试逻辑合理性

代码逻辑合理。

对于Strategy设计模式来说，代码关键在于实现同一个接口。定义一系列的算法，把它们一个个封装起来，并且使它们可相互替换。

实现上来讲，需要创建一个定义活动的Strategy接口和实现了Strategy接口的实体策略类。

该组的实现代码中，创建了Strategy接口类之后，实现了Strategy接口的实体策略类Sing、Joke、Fight。

### 测试用例正确性

测试用例正确。

创建的用例测试场景和功能上展示出了Strategy设计模式的效果。

### 重写测试（逻辑说明+代码）

应用Strategy设计模式应该对于创建的Strategy接口实现其实体策略类，并在测试中合理的调用展示。

```java
public class StrategyTest {
  System.out.println("\n\n-------------Strategy Test-------------");
        Interaction sing = new Interaction(new Sing());
        sing.executeInteraction(cat, sheep);

        Interaction joke = new Interaction(new Joke());
        joke.executeInteraction(sheep, chicken);

        Interaction fight = new Interaction(new Fight());
        fight.executeInteraction(chicken, cat);
}
```



### 测试结果（截图）

![Strategy测试](./Strategy测试.png)

### 评分

| 设计模式 | Class/Interface API                      | framework完成分（70） | Sample program完成度（30） | 备注说明 |
| -------- | ---------------------------------------- | --------------------- | -------------------------- | -------- |
| Strategy | Strategy、Sing、Joke、Fight、Interaction | 70                    | 30                         | 无       |











## Mediator设计模式测试

### 测试逻辑合理性

代码逻辑不甚合理。

对于Mediator设计模式来说，代码关键在于将对象 Colleague 之间的通信封装到一个类中单独处理。降低多个对象和类之间的通信复杂性。

该组的实现代码中，在FarmManager中使用中介者模式，作为StockManager和FieldManager类的中介者，使直接和中介者FarmManager类进行交互。

个人认为，中介者模式封装处理的对象之间的通信，降低对象和类之间的通信复杂性。该组的实现代码中，对于中介者模式的应用，处理的并不是两个普通对象之间的通信，而是另外两个Manager之间的通信，由于Manager中也包含有自己其他的通信逻辑，所以这种应用方式达不到很好的封装效果，Manager类之间的通信依然复杂。

### 测试用例正确性

测试用例正确。

创建的用例测试场景和功能上展示出了Mediator设计模式的效果。

### 重写测试（逻辑说明+代码）

该组自己的Mediator测试代码只有两个print输出和一个seeding函数的调用，代码逻辑结构较乱，无法重写。

```java
public class MediatorTest {
  System.out.println("\n\n-------------Mediator Test-------------");
  System.out.println("The FarmManager is the Mediator for others to manage the com.farm.");
  
  fm.seeding(PotatoSeed.class);
  fm.seeding(PotatoSeed.class, 0);
  fm.seeding(PotatoSeed.class);
  fm.seeding(CornSeed.class);
  
  System.out.println("\nGet the reference of the instance of FarmManager.");
}

	//对外开放的农田操作
	//输入种子成为植株
	public boolean seeding(Class cls)
	{
		int emptyField=field.getAnEmptyField();
		return seeding(cls, emptyField);
	}
	//重载，指定在第fieldIndex种
	public boolean seeding(Class seedClass, int fieldIndex)
	{
		Plant newPlant=PlantFactory.getAPlant(seedClass);

		if (newPlant==null){
			System.out.println("Fail planting");
			return false;
		}
		if(stock.exeACommand(new QueryItemCommand(),seedClass)<=0) {
			System.out.println("Fail planting seed not enough");
			return false;
		}
		if (field.addPlant(newPlant, fieldIndex)>=0){

			System.out.println("Succeeded to "+
					" plant a new " + newPlant.getName()+"on No." + fieldIndex+".");
			stock.exeACommand(new DelItemCommand(),seedClass);
			return true;
		}
		else {
			System.out.println("Fail. There is already a plant.");
		}
		return false;
	}
```



### 测试结果（截图）

![Mediator测试](./Mediator测试.png)

### 评分

| 设计模式 | Class/Interface API                     | framework完成分（70） | Sample program完成度（30） | 备注说明                                                     |
| -------- | --------------------------------------- | --------------------- | -------------------------- | ------------------------------------------------------------ |
| Mediator | FarmManager、StockManager、FieldManager | 50                    | 20                         | 代码逻辑不甚合理（具体已在上面说明），自己的测试代码看不出设计模式的应用（代码中只有printf和一个seeding函数调用） |

