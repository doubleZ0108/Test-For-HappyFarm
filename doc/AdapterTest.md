# Adapter 模式测试

### 测试逻辑合理性

适配器模式用于两个对象因接口不兼容而不能一起工作的场景。

草食动物与其他动物因食物属性不同，其吃的功能也无法兼容。

这里的草食动物 `GrassEat`提供了一个`NormalEat`的适配器, 使得其他动物也可以通过`GrassEat`调用`NormalEat`的方法.



### 测试用例正确性

经过我们的测试，该小组所设置的Adapter  模式表现良好，能够充分的体现出 Adapter 模式在构造对象这种操作上的优越性。



### 重写测试

我们首先邀请用户来输入每一种具体的商品要多少，然后根据用户的输入来构造响应的订单。

```java
public class AdapterTest {
  public static void main(String[] args){
    
    System.out.println("----------  Adapter Test----------");
    Animal cat = animalFactory.run("Cat");
	Animal sheep = animalFactory.run("Sheep");
	Animal chicken = animalFactory.run("Chicken");
	GrassEat grassEat = new GrassEat();
	grassEat.eat("Grass", sheep);
	grassEat.eat("Normal", cat);
	grassEat.eat("Normal", chicken);
```



### 测试结果

![AdapterTest](C:/Users/DELL/Desktop/designpattern/dp/Test-For-HappyFarm/doc/img/Adapter.png)



### 评分

| 设计模式 | Class/Interface API | framework完成分（70） | Sample program完成度（30） | 备注说明                       |
| -------- | ------------------- | --------------------- | -------------------------- | ------------------------------ |
| Adapter  | EatingAdapter       | 70                    | 30                         | 用例情节合理，设计模式实现良好 |

