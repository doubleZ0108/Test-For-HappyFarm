## Observer

### 测试逻辑合理性

该小组使用了三次Observer设计模式。

Observer设计模式指多个对象间存在一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它 的对象都得到通知并被自动更新。这种模式有时又称作发布-订阅模式、模型-视图模式，它是对象行为 型模式。

第一次：该小组通过调用加工厂的getMachinesState()方法来获取当前工厂内所有 机器的状态(0代表正常，1代表异常)。

第二次：作者在这里先建了一个observer接口。之后三个操作继承了该接口，分别是Telegraph, Telephone, WarningLight. 这三个操作的构造函数做了两件事，一是绑定他们的monitor，二是将他们添加到monitor的触发列表中。update函数代表他们被触发到会执行的命令。

第三次：商店类对仓库代理类形成观察者模式。商店对仓库容量进行观察，每当仓库的容量变化时，仓库会通知 观察它的商店类。 我们使用attach()方法将仓库加入仓库代理类的观察池，每当仓库容量发生变化时，都会调用notifyAll()方法来调用所有它观察池中的对象的update()方法。

### 测试用例正确性

逻辑无误，用例正确。

### 测试结果（截图）

![Observer](C:\Users\ahtly\Desktop\测试文档\Observer.JPG)



### 评分

| 设计模式 | Class/Interface API          | framework完成分（70） | Sample program完成度（30） | 备注说明                                 |
| -------- | ---------------------------- | --------------------- | -------------------------- | ---------------------------------------- |
| Mediator | AnimalFactory，AnimalMonitor | 70                    | 27                         | Observer设计模式实现得较为充分，且合理。 |
