### 测试逻辑合理性

不同的动物有不同的排泄方式，此系统支持cat, chicken, sheep三种动物的排泄。如果不使用Facade模式，我们处理各种动物的排泄时会显式地调用CatPoo, ChickenPoo和SheepPoo这三各类的成员函数。这样既不方便也容易出错。

而该组同学运用Facade设计模式，将以上三各类封装在animalPooMaker中。在这种情况下，处理不同动物的排泄时只需调用该类的不同成员函数就行了。从该组同学的测试代码中可以看出，处理动物排泄时，客户端确实只在和animalPooMaker这一个外观类打交道，而并不知道底层细节，故该组同学的测试代码反映了逻辑的合理性。

### 测试用例正确性

animalPooMaker在执行其成员函数时，需要指定poo的数量，而通过控制台可以看出，各个poo确实在按计划被处理，故其正确性良好。但缺点在于poo数量和poo种类被写死在了测试代码中，如果能在控制台中人为地指定就更好了。

### 重写测试（逻辑说明+代码）

系统已初始化了一个animalPoomaker，然后循环地询问客户端需要进行以下哪种操作：[1]pooForCat [2]pooForChicken [3]pooForSheep [else]exit。如果选择了前三种（即不选择退出），控制台会接着让客户端输入quantity，输入完毕后将本次处理排泄的结果打印出来。

```java
public class FacadeTest {
    public static void main(String[] args) {
        System.out.println("\n\n-------------Facade Test-------------");
        AnimalPooMaker animalPooMaker = new AnimalPooMaker();
        int option;
        int quantity;
        while(true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("choose an option: [1]pooForCat [2]pooForChicken [3]pooForSheep [else]exit");
                option = scanner.nextInt();
                if(option<=3 && option>=1){
                    System.out.println("Please enter an integer representing the quantity:" );
                    quantity = scanner.nextInt();
                    if(option == 1)
                        animalPooMaker.pooForCat(quantity);
                    else if(option == 2)
                        animalPooMaker.pooForChicken(quantity);
                    else
                        animalPooMaker.pooForSheep(quantity);
                }
                else
                    break;
            } catch (Exception e) {
                System.out.println("Please input an integer!");
            }
        }
    }
}

```



### 测试结果（截图）

![Facade](C:\Users\stone\Desktop\软件架构\测试作业\Facade.png)

### 评分

| 设计模式 | Class/Interface API | framework完成分（70） | Sample program完成度（30） | 备注说明 |
| -------- | ------------------- | --------------------- | -------------------------- | -------- |
| Facade   | AnimalPooMaker      | 70                    | 30                         |          |

