# Spring path

> Данный репозиторий используется для изучения фреймворка Spring

## Определения

### [Глава 2](src/main/java/chapter2/context/beans)

* Контекст - окружение, в котором работает Spring.
  Позволяет следить за объектами, добавленными в него.
  > Spring может управлять только теми объектами, которые
  являются частью фреймворка (контекста).


* Класс конфигурации - специальный класс в приложении Spring, посредством которого можно настроить фреймворк на
  выполнение определенных дейтсвий, таких как создание бинов или активация определенного функционала.


* @Bean позволяет добавлять экземпляры классов, определенных вами в проекте,
  а также классов, которые вы не создавали сами, но используете в приложении.
  > @Bean сообщает Spring о том, что при инициализации контекста нужно вызвать данный метод,
  а возвращаемое значение поместить в контекст.


* Чтобы добавить бин в контест Spring посредством аннотации @Bean, нужно выполнить следующие действия:
    - Определить в проекте класс конфигурации (с аннотацией @Configuration). Этот класс используется для описания
      конфигурации контекста Spring.
    - Добавить в класс конфигурации метод, возвращающий экземпляр объекта, который мы хотим добавить в контекст, и
      снабдить этот метод аннотацией @Bean.
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
  > в листинге 2 8 бин получает имя parrot). По соглашению, здесь можно использовать имена существительные, которые
  обычно
  > совпадают с именем класса


* @Component (и другие стереотипные аннотации) размещаются над классом.
  Когда приложение создает контест, фреймворк создает экземпляр и помещает их в контекст.
  > В данном варианте требуется класс конфигурациии для указания Spring где искать классы со стереотипными аннотациями.


* Чтобы добавить стереотипную аннотацию, нужно сделать следующее:
    - Отметить аннотацией @Component те классы, экземпляры которых вы хотите
      поместить в контекст Spring
    - Используя аннотацию @ComponentScan в классе конфигурации, сообщить
      Spring, где находятся классы, отмеченные аннотацией @Component


* @ComponentScan по умолчанию производит сканирование текущего пакета и всех его подпакетов.
    - Для указания определенного пакета следует полностью указать путь ```org.example```


* Используя Spring в реальных приложениях, вы скоро заметите, что применяете стереотипные аннотации везде, где только
  можно (ведь они требуют меньше кода), а @Bean — лишь когда нет других вариантов (например, когда вы создаете бин для
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

### Глава 3