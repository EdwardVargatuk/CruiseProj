# CruiseProj

Система Круизная Компания. У Компании имеется несколько
Кораблей. У Кораблей есть пассажиро-вместимость, маршрут, количество
посещаемых портов, длительность одного круиза, персонал. Клиент
выбирает и оплачивает круиз. Выбирает Экскурсии по прибытии в порт за
дополнительную плату. Администратор Корабля указывает бонусы для
пассажиров, учитывая класс билета (бассейн, спорт зал, кинозал,
косметические салоны...).

1. Install MySql
2. Use pom.xml for dependencies
3. Install and configure Tomcat 9.0.14, choose CruiseProj_Web_exploded artifact and ports
4. Run it on a local server
5. Run createSchemaWithData.sql from resourses folder
6. To login use passwords from cruisedb.user

P.S.
 public static void main(String[] args) {

        String s = "My name is Yaroslav";
        List<String> list = Arrays.asList(s.split(" "));
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        String[] strings = s.split(" ");
        System.out.println("second variant is better");
        for (int i = strings.length - 1; i >= 0; i--) {
            System.out.println(strings[i]);

        }
    }
