# Spring path

> Данный репозиторий используется для изучения фреймворка Spring

### Главы

* [Глава 2 (Контекст. Бины.)](#глава-2--контекстбины-)
* [Глава 3 (Монтаж. Автомонтаж. Внедрение зависимостей)](#глава-3--wiringautowiringdi-)
* [Глава 4 (Абстракции)](#глава-4--абстракции-)
* [Глава 5 (Область видимости и жизненный цикл бинов)](#глава-5--область-видимости-и-жизненный-цикл-бинов-)

## Определения

### [Глава 2 (Контекст;Бины)](src/main/java/chapter2/context/beans)

* Контекст - окружение, в котором работает Spring.
  Позволяет следить за объектами, добавленными в него.
  > Spring может управлять только теми объектами, которые
  являются частью фреймворка (контекста).


* Класс конфигурации - специальный класс в приложении Spring, посредством которого можно настроить фреймворк на
  выполнение определенных дейтсвий, таких как создание бинов или активация определенного функционала.


* ```@Bean``` позволяет добавлять экземпляры классов, определенных вами в проекте,
  а также классов, которые вы не создавали сами, но используете в приложении.
  > ```@Bean``` сообщает Spring о том, что при инициализации контекста нужно вызвать данный метод,
  а возвращаемое значение поместить в контекст.


* Чтобы добавить бин в контест Spring посредством аннотации ```@Bean```, нужно выполнить следующие действия:
    - Определить в проекте класс конфигурации (с аннотацией ```@Configuration```). Этот класс используется для описания
      конфигурации контекста Spring.
    - Добавить в класс конфигурации метод, возвращающий экземпляр объекта, который мы хотим добавить в контекст, и
      снабдить этот метод аннотацией ```@Bean```.
    - Настроить Spring на использование класса конфигурации.

    ``` java
    @Configuration
    public class ProjectConfiguration {
        @Bean
        public Parrot parrot() {
            return new Parrot();
        }
    }
  
    public class chapter2.context.beans.Program {
      public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
      }
    }
    ```

  > Обратите внимание на то, что имя, которое я присвоил методу, — это не глагол. Как вы, вероятно, знаете, хорошим
  тоном
  > программирования на Java является использование имен в форме глагола, так как методы обычно описывают некие
  действия.
  > Однако для методов, добавляющих бины в контекст Spring, мы сделаем исключение. Эти методы описывают экземпляры
  > возвращаемых ими объектов, которые затем становятся частью контекста Spring. Имя метода становится именем бина (
  > например,
  > в листинге 2 8 бин получает имя ```parrot```). По соглашению, здесь можно использовать имена существительные,
  которые
  обычно
  > совпадают с именем класса


* ```@Component``` (и другие стереотипные аннотации) размещаются над классом.
  Когда приложение создает контест, фреймворк создает экземпляр и помещает их в контекст.
  > В данном варианте требуется класс конфигурациии для указания Spring где искать классы со стереотипными аннотациями.


* Чтобы добавить стереотипную аннотацию, нужно сделать следующее:
    - Отметить аннотацией ```@Component``` те классы, экземпляры которых вы хотите
      поместить в контекст Spring
    - Используя аннотацию ```@ComponentScan``` в классе конфигурации, сообщить
      Spring, где находятся классы, отмеченные аннотацией ```@Component```


* ```@ComponentScan``` по умолчанию производит сканирование текущего пакета и всех его подпакетов.
    - Для указания определенного пакета следует полностью указать путь ```org.example```


* Используя Spring в реальных приложениях, вы скоро заметите, что применяете стереотипные аннотации везде, где только
  можно (ведь они требуют меньше кода), а ```@Bean``` — лишь когда нет других вариантов (например, когда вы создаете бин
  для
  класса, являющегося частью библиотеки, и не можете изменить этот класс, чтобы добавить в него стереотипную аннотацию)

  ``` java
  
  @Component
  public class SomeComponents {
    @Getter @Setter private String data;
  }
  
  @Configuration
  @ComponentScan // == @ComponentScan(basePackages = "chapter2.context.beans")
  public class ProjectConfiguration { } 
  
  ```

| @Bean                                                                           | Стереотипные анотации                                                                                                     |
|---------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| Полный контроль создаваемого экземпляр                                          | Контроль над экземпляром только после его создания                                                                        |
| Можно добавлять в контекст несколько экземпляров одного типа                    | Можно добавить в контекст только один экземлпяр класса                                                                    |
| Можно добавить в контекст экземляр любого объекта                               | Можно добавить в контекст только классы приложения                                                                        |
| Для каждого бина нужно писать отдельный метод, что увеличивает шаблонность кода | При добавлении бинов в контекст Spring посредством стереотипных аннотаций в приложении не появляется новый шаблонный код. |

### [Глава 3 (Wiring;Autowiring;DI)](src/main/java/chapter3/wiring/autowiring/di)

#### Wiring (монтаж;связывание)

```java

@Configuration
public class ProjectConfiguration {
    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("Some name");
        person.setParrot(parrot());

        return person;
    }

    @Bean
    public Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Some parrot");

        return parrot;
    }
}
```

* В приложении существует только один экземлпяр типа ```Parrot```
  На первый взгляд это может показаться странным, но Spring достаточно «умен», чтобы понять, что вы, вызывая метод
  ```parrot()```, хотите сослаться на размещенный в контексте бин ```parrot``` Если для определения бина в контексте
  Spring была использована аннотация ```@Bean```, то Spring отслеживает вызываемые методы и в конкретной ситуации может
  применить ту или иную логику
* Если в контесте уже есть бин parrot, то вместо того, чтобы вызвать метод ```parrot()```, Spring сразу извлекает из
  этот экземпляр из контекста.
    - Из метода ```person()``` с аннотацией ```@Bean``` вызывается метод ```parrot()``` с аннотацией ```@Bean```.
      Если такой бин уже сущетсвует, Spring возвращает его, не передавая вызов методу с ```@Bean```. Если же такого
      бина еще нет, то Spring создает его и возвращает на него ссылку.

  > Данное утверждение можно проверить, добавив в класс ```Parrot``` конструктор без параметров, выводящий сообщение
  о создании экземпляра.

* Также имеется еще один способ монтажа бинов, путем передачи параметров. Данный способ полезен, например, когда
  используется аннотацию ```@Component``` для добавления бина в контекст.

  ``` java  
  @Configuration
  public class ProjectConfiguration {
    @Bean
    public Person person(Parrot parrot) {
        Person person = new Person();
        person.setName("Some name");
        person.setParrot(parrot);
  
        return person;
    }

    @Bean
    public Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Some parrot");
  
        return parrot;
    }
  }
  ```

    - Передавая параметр методу, мы сообщаем Spring о необходимости вернуть бин из контекста.

#### Autowiring (автомонтаж)

* Аннотация ```@Autowired``` позволяет пометить свойство объекта, в которое мы хотим значение из контекста
  Spring.

    - Есть три способа примении аннотации ```@Autowired```:
        1. Внедрение значения в поле класса.
            - несмотря на всю простоту, у данного способа есть свои недостатки — именно поэтому мы избегаем его при
              написании кода для промышленных программных продуктов.

            ``` java
            @Component
            public class Person {
              @Getter @Setter private String name;
          
              @Autowired
              @Getter @Setter private Parrot parrot;
            }
           
            @Component
            public class Parrot {
                @Getter @Setter private String name;
            }

            ```

            - Применяя аннотацию ```@Autowired``` к полю класса, мы даем Spring команду присвоить этому полю значение
              бина, полученного из контекста. Spring создает два бина, ```person``` и ```parrot```, и внедряет
              объект ```parrot``` в поле бина типа ```Person```.

            - Недостатки:
                1. Нельзя применить модификатор ```final```
                2. при инициализации приходится самостоятельно управлять значением, а это сложнее

        2. Внедрение значения через конструктор.

            ```java
            @Component
            public class Person {
            @Getter @Setter private String name = "default name";
            
                @Getter private final Parrot parrot;
            
                public Person(Parrot parrot) {
                    this.parrot = parrot;
                }
            }
            ```

           > Аннотация ```@Autowired``` требуется только тогда, когда в классе более одного конструктора.

        3. Внедрение значения через сеттер.

           ``` java
           @Component
           public class Person {
               private Parrot parrot;
           
               @Autowired
               public void setParrot(Parrot parrot) {
                   this.parrot = parrot;
               }
           }
           ```

#### Выбор из нескольких бинов в контексте Spring

* Рассмотрим ситуацию, когда Spring должен внедрить значение в параметр или поле класса, но в контексте существует
  несколько бинов одного типа и нужно выбратьодинизних Предположим,вконтекстеSpringестьтрибинатипаParrot Согласно
  конфигурации фреймворк должен включить значение типа Parrot в параметр Что будет делать Spring в этом случае? Какой из
  нескольких бинов данного типа фреймворк выберет для внедрения?
  В зависимости от конкретной реализации возможны следующие варианты:
    1. Идентификатор параметра совпадает с именем одного из бинов, добавленных в контекст (которое, напомню, в свою
       очередь, идентично имени метода, снабженного аннотацией @Bean и возвращающего значение этого бина) В подобном
       случае Spring выберет бин с таким же именем, как и у параметра
    2. Идентификатор параметра не совпадает ни с одним из имен бинов, имеющихся в контексте Тогда можно поступить
       следующим образом:
        - отметить один из бинов как первичный (с помощью аннотации @Primary). В этом случае Spring выберет для
          внедрения первичный бин;
            - выбрать некий бин и отметить его аннотацией @Qualifier, как будет описано далее;
            - не делать ничего из выше перечисленного — однако в подобном случае приложение завершится ошибкой и выдаст
              исключение, сообщающее о том, что в контексте есть несколько бинов одного типа и Spring не может выбрать
              один из них.

### [Глава 4 (Абстракции)](src/main/java/chapter4)

### [Глава 5 (Область видимости и жизненный цикл бинов)](src/main/java/chapter5)

``` java
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {
    @Autowired
    private CommentRepository commentRepository;
    // остальной код
}
```

Теперь мы можем получить из контекста Spring экземпляр CommentProcessor Но будьте внимательны! Данный экземпляр будет
вам нужен при каждом вызове метода sendComment(), поэтому запрос бина должен находиться внутри этого метода Чтобы
получить такой результат, нужно внедрить контекст Spring (ApplicationContext) непосредственно в бин CommentService,
используя аннотацию @Autowired В методе sendComment() мы получаем экземпляр CommentProcessor, вызывая getBean() для
контекста приложения

``` java
@Service
public class CommentService {
    @Autowired
    private ApplicationContext context;
    public void sendComment(Comment c) {
        CommentProcessor p =
            context.getBean(CommentProcessor.class);
        p.setComment(c);
        p.processComment(c);
        p.validateComment(c);
        c = p.getComment();
        // сделать что-нибудь еще
    }
}
```

Не следует внедрять CommentProcessor непосредственно в бин CommentService — это было бы ошибкой Бин CommentService
является одиночным, а следовательно, Spring создает только один экземпляр этого класса Таким образом, при создании
бина CommentService Spring сразу внедрит и все зависимости класса В итоге получим единственный экземпляр
CommentProcessor И этот уникальный экземпляр будет использоваться при каждом вызове метода sendComment(), поэтому при
наличии нескольких потоков возникнет такое же состояние гонки, как и в случае одиночного бина.

* Бины с прототипной областью видимости стоит использовать, например, когда объект изменяемый и следует избежать
  состояния гонки.

### [Глава 6 (Аспекты и АОП в Spring)](src/main/java/chapter6/aspects/aop)

