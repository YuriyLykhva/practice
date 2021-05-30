package model;


import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;


public class Main {
//    public static void main(String[] args) {
//        List<UserDTO> users = new CsvToBeanBuilder(new FileReader("src/main/resources/File.csv"))
//                .withType(UserDTO.class).build().parse();
//        users.forEach(System.out::println);
//    }

    static Logger logger;
    static {
        try(FileInputStream ins = new FileInputStream(
                "C:/Users/Yurii_Lykhva/IdeaProjects/Automationpractice" +
                        "/src/main/resources/log.config")){

            LogManager.getLogManager().readConfiguration(ins);
//            LOGGER.                     getLogger(Main.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            logger.info("Начало main, создаем лист с типизацией Integers");
            List<Integer> ints = new ArrayList<Integer>();
            logger.info("присваиваем лист Integers листу без типипзации");
            List empty = ints;
            logger.info("присваиваем лист без типипзации листу строк");
            List<String> string = empty;
            logger.info("добавляем строку \"бла бла\" в наш переприсвоенный лист, возможна ошибка");
            string.add("бла бла");
            logger.info("добавляем строку \"бла 23\" в наш переприсвоенный лист, возможна ошибка");
            string.add("бла 23");
            logger.info("добавляем строку \"бла 34\" в наш переприсвоенный лист, возможна ошибка");
            string.add("бла 34");


            logger.info("выводим все элементы листа с типизацией Integers в консоль");
            for (Object anInt : ints) {
                System.out.println(anInt);
            }

            logger.info("Размер равен " + ints.size());
            logger.info("Получим первый элемент");
            Integer integer = ints.get(0);
            logger.info("выведем его в консоль");
            System.out.println(integer);

        }catch (Exception e){
            logger.info("что-то пошло не так" , e);
        }
    }
}
