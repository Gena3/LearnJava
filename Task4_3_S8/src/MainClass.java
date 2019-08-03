/*
В этой задаче вам нужно реализовать метод, настраивающий параметры логирования. Конфигурирование в коде позволяет
выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.

Требуется выставить такие настройки, чтобы:

    Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
    Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
    Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности
    сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях
    "org.stepic", "org" и "".

Не упомянутые здесь настройки изменяться не должны.

(*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл. Но проверяющая система не разрешает создавать файлы на диске, поэтому придется так.

Подсказки:

    Level есть не только у Logger, но и у Handler.
    Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.
 */

import java.util.logging.*;

public class MainClass {
    private static void configureLogging() {
        Logger logger0 = Logger.getLogger("org.stepic.java.logging.ClassA");
        logger0.setLevel(Level.ALL);

        Logger logger1 = Logger.getLogger("org.stepic.java.logging.ClassB");
        logger1.setLevel(Level.WARNING);

        Logger logger2 = Logger.getLogger("org.stepic.java");
        logger2.setUseParentHandlers(false);
        logger2.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        ch.setFormatter(new XMLFormatter());
        logger2.addHandler(ch);
    }
    public static void main(String[] args){
        // Эти классы сделаны не в рамках задачи
        // просто хотел посмотреть как оно.
        ClassA.SomeFunction();
        ClassB.SomeFunction();

        configureLogging();
    }
}
