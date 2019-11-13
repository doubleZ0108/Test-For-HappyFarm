### 测试逻辑合理性

Abstract Factory设计模式指的是当创建一整族相关的对象时，不需要点名对戏那个真正所属的具体类，而是为访问者提供一个创建一族对象的接口。也就是应该有基类的抽象工厂，再派生出具体的抽象工厂生产产品，而生产的产品也应该是多种的，并且也是以族刻画的对象。在该小组的抽象工厂设计模式的设计中，具有基类的抽象工厂接口，并派生出了FarmProcessingFactory和PatureProcessingFactory，他们各自生产个子的产品，但是每个具体的通常生产的东西应该也是继承自同一抽象类的对象，也就是说生产的也是一族的对象。

只有这样设计的抽象工厂模式才符合OCP原则，当我有一个新的具体抽象工厂，它生产的产品虽然有变化，但也属于产品的一族产品，这样才能体现出抽象工厂模式的优越性。

### 测试用例正确性

在该小组抽象工厂模式的测试用例中，farmProcessingFactory和pastureProcessingFactory作为从抽象工厂中派生出的子类创建的对象，这样很好，因为他们都用共同的方法addMachine()，因为这个方法定义在基类中，所以可以不需要考虑生产东西的差异性。

但是这两个工厂既然是继承自基类的工厂，在这里应该用基类的对象动态指向两个具体的工厂，也就是Strategy设计模式（原因在于将AbstractProcessingFactory做成接口，无法实现多态）；除此之外，每个工厂生产的东西都完全不相干，这不能很好的体现出抽象工厂模式的优越性所在

### 重写测试（逻辑说明+代码）

重新整理的抽象工厂模式测试主要是对该小组提供的接口farmProcessingFactory和pastureProcessingFactory，首先添加不同的machines，之后获取不同抽象工厂生产的不同machines，之后设置不同抽象工厂的环境变量，查看抽象工厂模式的使用情况。

```java
public class AbstractFactoryTest {
    public static void main(String[] args) {
        System.out.println("—————————————-------------------------------------———— Test[Abstract Factory]Pattern —————————————-------------------------------------————");
        System.out.println("FarmProcessingFactory : addMachine() :  Add a machine for farm processing factory which inherit from abstract processing factory.");
        System.out.println("FarmProcessingFactory : getMachinesState() :  Output state of all machines from processing factory.");
        System.out.println("FarmProcessingFactory : setEnvironment() :  Set environment for farm processing factory.");
        System.out.println("PastureProcessingFactory : addMachine() :  Add a machine for pasture processing factory which inherit from abstract processing factory.");
        System.out.println("PastureProcessingFactory : getMachinesState() :  Output state of all machines pasture processing factory..");
        System.out.println("PastureProcessingFactory : setEnvironment() :  Set environment for pasture processing factory.");
        System.out.println("");

        System.out.println("=== Create a farm processing factory:");
        FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
        System.out.println("=== Create a pasture processing factory:");
        PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
        System.out.println("");
        System.out.println("=== Add machines for each processing factory:");
        for(int i = 0;i<15;i++) {
            farmProcessingFactory.addMachine();
            pastureProcessingFactory.addMachine();
        }

        System.out.println("");
        System.out.println("=== Get machines state from farm processing factory:");
        farmProcessingFactory.getMachinesState();
        System.out.println("=== Get machines state from pasture processing factory:");
        pastureProcessingFactory.getMachinesState();

        System.out.println("");
        System.out.println("=== Set environment for farm processing factory:");
        farmProcessingFactory.setEnvironment(new InitialEnvironment(15, 15));
        farmProcessingFactory.handle();
        System.out.println("=== Set environment for pasture processing factory:");
        pastureProcessingFactory.setEnvironment(new InitialEnvironment(15, 15));
        pastureProcessingFactory.handle();
    }
}
```



### 测试结果（截图）

![AbstractFactoryTest.jpg](https://upload-images.jianshu.io/upload_images/12014150-45864fcee2fd3780.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



### 评分

| 设计模式         | Class/Interface API                             | framework完成分（70） | Sample program完成度（30） | 备注说明                                                     |
| ---------------- | ----------------------------------------------- | --------------------- | -------------------------- | ------------------------------------------------------------ |
| Abstract Factory | FarmProcessingFactory, PastureProcessingFactory | 60                    | 20                         | 1. 每个具体的抽象工厂生产的东西应该也是继承自同一抽象类的对象，也就是说生产的也是一族的对象，这样才符合OCP原则<br />2. 不应该将抽象工厂类做成接口，应该作为基类，这样可以使用基类的引用指向不同的工厂，甚至可以考虑动态切换 |

