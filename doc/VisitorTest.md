### 测试逻辑合理性

在访问者模式中，元素的执行算法可以随着访问者改变而改变。根据模式，元素对象已接受访问者对象，这样访问者对象就可以处理元素对象上的操作。
在测试中，我们让维修人员作为访问者访问被损坏的机器，被损坏的机器在接受维修人员的访问后得到修复，重新恢复为正常工作的状态。

### 测试用例正确性

1. 实例化一个代表维修人员的访问者类。
2. 将一台机器的状态设置为损坏状态。
3. 通过访问者访问被损坏的机器，将机器修复为正常工作状态。

### 重写测试（逻辑说明+代码）

```java
public class VisitorTest {
    static public void main(String[] args){
        System.out.println("\n\n-------------Visitor Test-------------");

        FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
        PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
        System.out.println("No.0 Machine in FarmProcessingFactory is damaged");
        farmProcessingFactory.machines.get(0).setState(1);
        farmProcessingFactory.machines.get(0).accept(new MachineDisplayVisitor());
        System.out.println("No.13 Machine in PastureProcessingFactory is damaged");
        pastureProcessingFactory.machines.get(13).setState(1);
        pastureProcessingFactory.machines.get(13).accept(new MachineDisplayVisitor());
    }
}
```



### 测试结果（截图）

![visitor](img\visitor.png)



### 评分

| 设计模式 | Class/Interface API                             | framework完成分（70） | Sample program完成度（30） | 备注说明                                               |
| -------- | ----------------------------------------------- | --------------------- | -------------------------- | ------------------------------------------------------ |
| Visitor  | FarmProcessingFactory, PastureProcessingFactory | 67                    | 27                         | （说明缺点、扣分原因，满分写无）例：XX中的XX它没有用到 |

