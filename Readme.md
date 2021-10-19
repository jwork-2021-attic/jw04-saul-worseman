# JW04

## 主要内容

+ 可视化冒泡排序。依据RGB值排列，具有一定渐变效果。

  ![](https://i.loli.net/2021/10/19/Pg8en2YiEqWpywd.png)



## 后续改进

**因为需要可视化排序，所以lambda表达式无法直接套用与排序，在`KeyListener`上做文章。**

+ `InnerClass Version`
+ `Lambda version 1`
+ `Lambda version 2`， 重写一个函数适配`addKeyListener`,从而实现直接传一个lambda表达式

觉得`innerClass` 方法最自然，因为这里的`keyListener`接口严格来说不是只有一个method的函数接口。

```java
//       inner class
//        addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                screen = screen.respondToUserInput(e);
//                repaint();
//            }
//        });

//      lambda 1
//        MyInterface myInterface = e->{
//            screen = screen.respondToUserInput(e);
//            repaint();
//        };
//        addKeyListener(myInterface);

        addMyInterface(e -> {
            screen = screen.respondToUserInput(e);
            repaint();
        });
        repaint();
    }

    public synchronized void addMyInterface(MyInterface l){
        addKeyListener(l);
    }
```



