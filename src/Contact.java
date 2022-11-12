import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private String name;
    private String surName;
    private String patronymic;
    private String birthDate;
    private String phoneNumber;
    private String sex;
    private Scanner in;
    String[] allInfo;

    public Contact() {

    }

    public Contact(String surName, String name, String patronymic, String birthDate, String phoneNumber, String sex) {
        this.surName = surName;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getInfo() {
        System.out.println("Введите данные через пробел: Фамилия Имя Отчество ДатаРождения(dd.mm.yyyy) Телефон(11 цифр без пробелов) Пол(одной буквой: f или m)");
        in = new Scanner(System.in);
        return in.nextLine();
    }

    public void rightQuantity(String s) {
        String[] ss = s.split(" ");
        if (ss.length == 6) {
            System.out.println("Количество введённых данных верно");
        } else if (ss.length > 6) {
            System.out.println("Введено больше данных чем требуется");
        } else {
            System.out.println("Введено меньше данных чем требуется");
        }
    }

    public void setInfo(String s) {
        allInfo = s.split(" ");
        boolean b = true;
        while (b) {
            int mistakes = 0;
            this.surName = allInfo[0];
            if (isContain(allInfo[0], "[0-9]+")) {
                System.out.println("Фамилия должна состоять только из букв");
                mistakes++;
            }
            this.name = allInfo[1];
            if (isContain(allInfo[1], "\\d+")) {
                System.out.println("Имя должно состоять только из букв");
                mistakes++;
            }
            this.patronymic = allInfo[2];
            if (isContain(allInfo[2], "\\d+")) {
                System.out.println("Отчество должно состоять только из букв");
                mistakes++;
            }
            this.birthDate = allInfo[3];
            if (!isContain(allInfo[3], "(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d")) {
                System.out.println("Неверный формат даты");
                mistakes++;
            }
            this.phoneNumber = allInfo[4];
            if (!isContain(allInfo[4], "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
                System.out.println("Неверный формат телефонного номера");
                mistakes++;
            }
            this.sex = allInfo[5];
            if (!isContain(allInfo[5], "^(m|f)$")) {
                System.out.println("Неверно введён формат пола");
                mistakes++;
            }
            if(mistakes > 0){
                System.out.printf("Вы допустили %d ошибку(и)\n", mistakes);
                setInfo(this.getInfo());
            }
            else {
                System.out.println("Данные введены верно");
                b = false;
            }
        }
    }


    public boolean isContain(String s, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        return m.find();
    }
}
