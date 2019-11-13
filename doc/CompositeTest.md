## 7 Composite

### 测试逻辑合理性

Composite模式属于结构型模式的一种，该模式将对象组合成树形结构，以此来表示对象的“部分-整体”的层次结构。优点是提升了代码的复用性；在逻辑上将树结构中的根节点和叶子节点做同化处理，使高层模块的调用更加简单。Composite能让clients得以一致方式对待“个别物”和“复合物”。

关于Composite的描述，最重要的逻辑体现有两点，一是树型结构，二是“部分-整体”层次。

在该模式的实现中，类图如下：

![](/Users/sTern/Downloads/EE_Study/3.0/软件架构设计/test/5+7testPic/7-00.png)



可以看出，整个Composite模型的构建并没有体现出树型结构，更没有“整体-部分”的层次。没有作为一个统一模版让用户得以将整体和个体统一处理的父类，也没有实现同一方法不同实现的“个别物”和“复合物”的子类。设计逻辑不合理。

### 测试用例正确性

测试中描述"The FarmManager is the composited by FieldManager and StockManager, while the list of objects of Field class form the FieldManager and Plant class forms the Field class."并没有体现出Composite设计模式的特点，测试用例正确性不强。

### 改进思路

Composite模式首先需要找准一个能够实现树型结构，能够体现“整体-部分”层次的物件（对象），通过另一个对象作为client或者用户作为client来调用一个抽象父类。

在此处，FarmManager, FieldManager, StockManager等类作为管理者的角色，并不适合作为Composite树型结构中的根节点或叶子结点，反而可以用来充当client的角色，用来对自己管辖范围内的对象进行一系列操作。

举个例子来说，暂时不考虑其他类的交互和影响，可以把Field和Plant作为Composite主要的实现对象，Field类作为“复合物”，Plant作为“个别物”——一个Field中可以包含多个Plant让FieldManager进行操作。将Field和Plant抽象出一个基本的父类Farmland，Farmland下可以包含Field和Plant，提供一个诸如water()等函数的抽象接口。FieldManager可以调用Farmland的接口实现Field和Plant的不同操作，以此达到一致方式对待“个别物”和“复合物”的目的。

改进思路的类图草图如下：

（注：没有考虑项目中其他任何类的交互情况，仅仅对Composite模式提出的改进类图思路。）

![](/Users/sTern/Downloads/EE_Study/3.0/软件架构设计/test/5+7testPic/7-1.png)

### 评分

| 设计模式                | Class/Interface API                            | framework完成分（70） | Sample program完成度（30） | 备注说明                                                     |
| ----------------------- | ---------------------------------------------- | --------------------- | -------------------------- | ------------------------------------------------------------ |
| Chain of Responsibility | FarmManager, FieldManager, StockManager, Field | 50                    | 10                         | 组合模式将对象组合成树形结构，以此来表示对象的“部分-整体“结构，使得用户能够以同样的方式来使用不同的子类。但在该组的设计模式中，没有体现出“部分-整体”的树型结构，FarmManager作为父类，其两个子类FieldManager, StockManager不构成部分和整体的关系，也没有表现出通过同样的接口调用不同子类不同方法的特性。 |