import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        Contact man1 = new Contact();
        Storage storage = new Storage();
//      String s = "Lymarev Mikle Pavlovich 07.09.1988 89534276207 m";

        String s = man1.getInfo(); // запрашиваем данне у пользователя
        man1.rightQuantity(s);     // проверяем, верно ли количество введённых данных
        man1.setInfo(s);           // проверяем правильность введённых данных, если не верно, вводим заново, пока не получится
        storage.myExport(s);       // записываем данные в файл

    }


}

