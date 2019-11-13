# Bridge 模式测试

### 测试逻辑合理性

桥接模式将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。

该组设计的动物的yell动作有两个维度：次数和类型。通过桥接模式分离这两个维度，既将抽象与实现分离，增强其扩展能力，又使得实现细节对客户透明。

### 测试用例正确性

经过我们的测试，该小组所设置的 Bridge模式表现良好，能够充分的体现出 Bridge 模式在构造对象这种操作上的优越性。

### 重写测试

```java
public class BridgeTest {
  public static void main(String[] args){
     System.out.println("----------  Bridge Test----------");
        System.out.println("Let the cat to yell 3 times..");
        AnimalYell catYell = new CatYell();
        YellTimes yellThreeTimes = new YellThreeTimes();
        catYell.setYellTimes(yellThreeTimes);
        catYell.yell();

        System.out.println("Let the sheep to yell 2 times..");
        AnimalYell sheepYell = new SheepYell();
        YellTimes yellTwiceTimes = new YellTwiceTimes();
        sheepYell.setYellTimes(yellTwiceTimes);
        sheepYell.yell();
  }
}
```



### 测试结果

<img src="C:/Users/DELL/Desktop/designpattern/dp/Test-For-HappyFarm/doc/img/Bridge.png" alt="BridgeTest" style="zoom:150%;" />



### 评分

| 设计模式 | Class/Interface API | framework完成分（70） | Sample program完成度（30） | 备注说明                       |
| -------- | ------------------- | --------------------- | -------------------------- | ------------------------------ |
| Bridge   | AnimalYell          | 70                    | 30                         | 用例情节合理，设计模式实现良好 |

