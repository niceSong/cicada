```python
   ___ _               _       
  / __(_) ___ __ _  __| | __ _ 
 / /  | |/ __/ _` |/ _` |/ _` |
/ /___| | (_| (_| | (_| | (_| |
\____/|_|\___\__,_|\__,_|\__,_|
```
                               
# 简介
**一款非常简单易用的异常处理框架。只需简单使用注解，即可抛出优美的异常被客户端接收。**
# gradle添加依赖
```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies{
    implementation 'com.github.niceSong.cicada:cicada-web:v1.0.3'
    implementation 'com.github.niceSong.cicada:cicada-exception:v1.0.1'
}
```
# 如何使用
## 添加扫描注解
```java
@CicadaScan
@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
```
`@CicadaScan`用于扫描`@CicadaBean`注解的接口。
## 定义异常
```java
@CicadaBean(namespace = "test")
public interface TestException {
    @ExceptionInfo(errCode = 1000)
    CicadaException fuckException();
}
```
只需定义接口，框架会动态代理生成`Bean`注入`spring`。
## 抛出异常
```java
@Autowired
TestException testException;

@GetMapping(value = "/test")
public void test(){
    throw testException.fuckException("You throw cicada exception successfully");
}
```
`Autowired`依赖注入，即可调用接口方法抛出异常。

客户端收到异常格式如下：
```json
{
    "errCode": 1000,
    "nameSpace": "test",
    "errMessage": "You throw cicada exception successfully",
    "stackTrace": "..."
}
```
使用愉快，有问题欢迎随时`issues`。