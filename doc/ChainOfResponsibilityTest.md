##5 Chain of Responsibility

### 测试逻辑合理性

在责任链模式中，由很多个会对请求进行处理的对象拼接在一起形成一条责任链，请求在这条链上传递，责任链根据对象的顺序依次让对象对请求进行处理，直到到达链的尾端。这使得系统可以对客户端传来的各种请求动态地组织和分配责任。

在test中，Chain of Responsibility的测试创造出了一个由factory组成的链条，链条的每个节点对应一种factory，并根据用户的需求，也就是需要生产的东西来决定所需的factory相应的方法。通过给出一个或多个待处理的需求，就能通过生产工厂的回应确定责任链的运作是否合理。

在测试中，对责任链结构添加节点，顺序判断是否响应的特性给予了功能的测试；同时对责任链模型中的抽象处理者和具体处理者也给予了功能测试。在责任链模式测试里，多个对象Factory（此处为两个）连接起来形成一条链FactoryChain。请求在这个链上传递，直到链上的某一个对象决定处理此请求。发出这个请求的客户端并不知道链上的哪一个对象最终处理这个请求，这使得系统可以在不影响客户端的情况下动态地重新组织链和分配责任。测试逻辑合理。

### 测试用例正确性

测试用例如下：

1. 新建一个责任链，将农作物加工厂和肉类加工厂放进去。
2. 要求生产各种产品。
3. 责任链开始传递生产需求，两个加工厂寻找合适的需求进行响应，各自对自己负责的产品进行加工。
4. 加工完成或者原材料不足则会放出通知。

经检验，测试用例能够成功运行。

### 重写测试（逻辑说明+代码）

重写测试用例的逻辑如下：

1. 用户添加基本的库存物品信息以供之后的生产需求
2. 新建责任链，添加农作物工厂和肉类工厂
3. 用户提出产品种类和数目需求，交给责任链
4. 责任链传递生产需求，两个加工厂寻找合适的需求进行响应，各自对自己负责的产品进行加工。为了便于测试的简单性，能目前目录中能生产的产品直接提供给用户；如果用户一定选择不能加工的产品，则提示用户无法生产。

```java
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        System.out.println("\n\n-------------Chain of Responsibility Test-------------");
        System.out.println("Please first choice the stack of...");
        int stack = 0;
        RepositoryProxy.Instance();
        Scanner sc = new Scanner(System.in);

        System.out.println("Chicken: ");
        while(true) {
            if(sc.hasNextInt()) {
                stack = sc.nextInt();
                if(stack > 0) {
                    RepositoryProxy.Instance().add(Chicken.class, stack);
                    break;
                }
                else {
                    System.out.println("The stack must more than 0.");
                    continue;
                }
            }
            Scanner temp = new Scanner(System.in);
            temp.next();
            System.out.println("The stack must be a int number.");
        }
        System.out.println("Wheat: ");
        while(true) {
            if(sc.hasNextInt()) {
                stack = sc.nextInt();
                if(stack > 0) {
                    RepositoryProxy.Instance().add(Wheat.class, stack);
                    break;
                }
                else {
                    System.out.println("The stack must more than 0.");
                    continue;
                }
            }
            Scanner temp = new Scanner(System.in);
            temp.next();
            System.out.println("The stack must be a int number.");
        }
        System.out.println("Egg: ");
        while(true) {
            if(sc.hasNextInt()) {
                stack = sc.nextInt();
                if(stack > 0) {
                    RepositoryProxy.Instance().add(Egg.class, stack);
                    break;
                }
                else {
                    System.out.println("The stack must more than 0.");
                    continue;
                }
            }
            Scanner temp = new Scanner(System.in);
            temp.next();
            System.out.println("The stack must be a int number.");
        }
        System.out.println("Flour: ");
        while(true) {
            if(sc.hasNextInt()) {
                stack = sc.nextInt();
                if(stack > 0) {
                    RepositoryProxy.Instance().add(Flour.class, stack);
                    break;
                }
                else {
                    System.out.println("The stack must more than 0.");
                    continue;
                }
            }
            Scanner temp = new Scanner(System.in);
            temp.next();
            System.out.println("The stack must be a int number.");
        }


        System.out.println("Now add the FarmProcessingFactory and PastureProccessingFactory in the chain.");
        FactoryChain factoryChain = new FactoryChain();
        FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
        PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
        factoryChain.addFactory(farmProcessingFactory);
        factoryChain.addFactory(pastureProcessingFactory);

        while(true) {
            System.out.println("Now make request of certain product and its number (\"q\" to quit).");
            System.out.println("The product name: [Eggcake | ChickenKebabs]");
            Scanner name = new Scanner(System.in);
            String requestName = name.next();
            if (requestName.equals("q")) {
                break;
            }
            if (requestName.equals("Eggcake") || requestName.equals("ChickenKebabs")) {
                Request request = new Request();
                request.setRequest(requestName);
                int amount = 0;
                while (true) {
                    Scanner temp = new Scanner(System.in);
                    System.out.println("The amount:");
                    if (temp.hasNextInt()) {
                        amount = temp.nextInt();
                        if (amount > 0) {
                            request.setNum(amount);
                            request.setRepositoryProxy(RepositoryProxy.Instance());
                            break;
                        } else {
                            System.out.println("The amount must more than 0.");
                        }
                    }
                }
                Response response = new Response();
                factoryChain.setIndex(0);
                factoryChain.doProcess(request, response, factoryChain);
            }
            else {
                System.out.println("We cannot make this.");
            }
        }

    }
}
```



### 测试结果（截图）

![](/Users/sTern/Downloads/EE_Study/3.0/软件架构设计/test/5+7testPic/5-01.png)

![](/Users/sTern/Downloads/EE_Study/3.0/软件架构设计/test/5+7testPic/5-02.png)

![](/Users/sTern/Downloads/EE_Study/3.0/软件架构设计/test/5+7testPic/5-03.png)



### 评分

| 设计模式                | Class/Interface API                                          | framework完成分（70） | Sample program完成度（30） | 备注说明 |
| ----------------------- | ------------------------------------------------------------ | --------------------- | -------------------------- | -------- |
| Chain of Responsibility | AbstractProcessingFactory, FarmProcessingFactory, PastureProcessingFactory, FactoryChain, Process | 70                    | 30                         | 无       |


