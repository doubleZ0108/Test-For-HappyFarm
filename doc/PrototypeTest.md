## Prototype模式测试

### 测试逻辑合理性

`Prototype`模式用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。 

在测试用例中，在用户调用`Observer`的`getMachinesState()`方法来获 取机器状态时，如果检测到机器损坏，就将机器从加工厂的List中移除，然后通过`Machine`类的`clone()` 方法克隆一个新的机器加入列表中。

### 测试用例正确性

经过我们的测试，该小组所设置的`Prototype`模式表现良好，以`FarmProcessingFactory`和`PastureProcessingFactory`为例，通过`FarmProcessingFactory`与`PastureProcessingFactory`的`clone()`方法来进行复制操作，并且得到了较好的实现。

### 重写测试（逻辑说明+代码）

首先，声明两个`FarmProcessingFactory`类和`PastureProcessingFactory`类的对象，之后调用两个对象的`addMachine()`方法生产十台机器，检测到损坏的机器后，调用`clone()`方法进行复制操作。

```java
public class PrototypeTest {
    public static void main(String[] args) {
        FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
        PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
        for(int i = 0;i<10;i++) {
            farmProcessingFactory.addMachine();
            pastureProcessingFactory.addMachine();
        }
        System.out.println("\n\n-------------Observer/Prototype Test-------------");
        System.out.println("Check the State of FarmProcessingFactory's Machines:");
        farmProcessingFactory.getMachinesState();
        System.out.println("Check the State of PastureProcessingFactory's Machines:");
        pastureProcessingFactory.getMachinesState();
    }
}
```

### 测试结果（截图）

```
-------------Observer/Prototype Test-------------
Check the State of FarmProcessingFactory's Machines:
check machines' state̬
NO.0machine's state:0
NO.1machine's state:0
NO.2machine's state:0
NO.3machine's state:0
NO.4machine's state:0
NO.5machine's state:0
NO.6machine's state:0
NO.7machine's state:1
remove NO.7machine
successfully cloned machine
successfully added machine
NO.8machine's state:0
NO.9machine's state:0
Check the State of PastureProcessingFactory's Machines:
check machines' state̬
NO.0machine's state:1
remove NO.0machine
successfully cloned machine
successfully added machine
NO.1machine's state:0
NO.2machine's state:0
NO.3machine's state:0
NO.4machine's state:0
NO.5machine's state:0
NO.6machine's state:0
NO.7machine's state:0
NO.8machine's state:0
NO.9machine's state:0
```

### 评分

| 设计模式  | Class/Interface API                             | framework完成分（70） | Sample program完成度（30） | 备注说明                                                     |
| --------- | ----------------------------------------------- | --------------------- | -------------------------- | ------------------------------------------------------------ |
| Prototype | FarmProcessingFactory, PastureProcessingFactory | 70                    | 30                         | 用例情节合理，设计模式实现良好。`clone()`方法得到了较好的实现 |
