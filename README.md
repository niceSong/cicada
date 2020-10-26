```python
   ___ _               _       
  / __(_) ___ __ _  __| | __ _ 
 / /  | |/ __/ _` |/ _` |/ _` |
/ /___| | (_| (_| | (_| | (_| |
\____/|_|\___\__,_|\__,_|\__,_|
```
                               
# 简介
一款简单易用的异常处理框架。
# gradle添加依赖
```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies{
    implementation 'com.github.niceSong.cicada:cicada-web:v1.0.0'
    implementation 'com.github.niceSong.cicada:cicada-exception:v1.0.0'
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
## 定义异常
```java
@CicadaBean(namespace = "test")
public interface TestException {
    @ExceptionInfo(errCode = 1000, errMessage = "Fuck you")
    CicadaException fuckException();
}
```
只需定义接口，框架会使用动态代理注入spring。
## 抛出异常
```java
@Autowired
TestException testException;

@GetMapping(value = "/test")
public void test(){
    throw testException.fuckException();
}
```