## Interpreter

### 测试逻辑合理性

Interpreter，顾名思义，就是提供一个类似可解释的语句给解释器，让它“解释”出这个语句的意思。 

那么在这里，作者用来判断一些动物是否属于牲畜。

该小组通过使用TerminalExpression继承Expression来实现interpreter模式。并且在Interpreter中实现了and和or两种表达句式。但是美中不足的地方在于两种方式都是static方法，因此想要添加更多的解释语句会相对复杂一些。

### 测试用例正确性

逻辑无误，用例正确。



### 测试结果（截图）

![Interpreter](C:\Users\ahtly\Desktop\测试文档\Interpreter.JPG)

### 评分

| 设计模式    | Class/Interface API             | framework完成分（70） | Sample program完成度（30） | 备注说明                                                     |
| ----------- | ------------------------------- | --------------------- | -------------------------- | ------------------------------------------------------------ |
| Interpreter | Interpreter，TerminalExpression | 65                    | 27                         | 对设计模式的理解和实现无误，但and和or两种解释模式都是static方法，并且没有足够的构造方法，只能使用限定好的两种动物。 |

