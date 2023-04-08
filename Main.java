import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //initializing all films
        FilmManager filmManager = new FilmManager();

        //creating users
        UserManager userManager = new UserManager(createUsers(scanner));

        //removing users
        System.out.println("Çıkarmak istediğiniz kullanıcının numarasını girin:");
        Long userNoToRemove = scanner.nextLong();
        scanner.nextLine();
        userManager.removeUser(userNoToRemove);

        //search users
        System.out.println("Aramak istediğiniz kullanıcının numarasını girin:");
        Long userNoToSearch = scanner.nextLong();
        scanner.nextLine();
        userManager.searchUser(userNoToSearch);

        //login
        User user = login(scanner, userManager);

        //list all films
        System.out.println("Tüm filmler listeleniyor...");
        System.out.println(filmManager.getAllFilms());

        //query all films
        System.out.println("Aramak istediğiniz filmin numarasını girin:");
        Long filmNo = scanner.nextLong();
        scanner.nextLine();
        filmManager.searchAllFilms(filmNo);

        //add film to user film list
        addFilm(scanner, user, filmManager);
        System.out.println("Mevcut filmleriniz:");
        System.out.println(user.getFilms());

        //remove film from user film list
        removeFilm(scanner, user);
        System.out.println("Mevcut filmleriniz:");
        System.out.println(user.getFilms());

        //logout
        System.out.println("Çıkmak için e yazıp Enter'a basın:");
        String answer = scanner.nextLine();
        while (!answer.equalsIgnoreCase("e")) {
            System.out.println("Geçersiz bir harf girdiniz. Lütfen tekrar giriniz!");
            answer = scanner.nextLine();
        }
        if (answer.equalsIgnoreCase("e")) {
            System.out.println("Başarıyla çıkış yaptınız.");
        }

        scanner.close();

    }

    private static void addFilm(Scanner scanner, User user, FilmManager filmManager) {
        while(true){
            System.out.println("Lütfen eklemek istediğiniz filmin numarasını girin:");
            for (Film film : filmManager.getAllFilms()) {
                System.out.println(film.getId() + ". film: " + film.getTitle());
            }
            Long filmNo = scanner.nextLong();
            scanner.nextLine();

            while (!filmManager.getAllFilms().contains(new Film(filmNo))){
                System.out.println("Yanlış bir film numarası girdiniz, lütfen tekrar girin:");
                filmNo = scanner.nextLong();
                scanner.nextLine();
            }

            for (Film film : filmManager.getAllFilms()) {
                if(film.getId().equals(filmNo)){
                    System.out.println(film.getTitle() + " eklendi.");
                    user.getFilms().add(film);
                    break;
                }
            }

            System.out.println("Listenize başka bir film eklemek ister misiniz?");
            System.out.println("Evet için e yazıp Enter'a basın. Hayır için h yazıp Enter'a basın.");
            String answer = scanner.nextLine();
            while (!answer.equalsIgnoreCase("e") && !answer.equalsIgnoreCase("h")) {
                System.out.println("Geçersiz bir harf girdiniz. Lütfen tekrar bir harf giriniz! ");
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("e")) {
                continue;
            }
            if (answer.equalsIgnoreCase("h")) {
                break;
            }
        }
    }

    private static void removeFilm(Scanner scanner, User user) {
        while(true){
            System.out.println("Lütfen çıkarmak istediğiniz filmin numarasını girin:");
            for (Film film : user.getFilms()) {
                System.out.println(film.getId() + ". film: " + film.getTitle());
            }

            Long filmNo = scanner.nextLong();
            scanner.nextLine();

            while (!user.getFilms().contains(new Film(filmNo))){
                System.out.println("Yanlış bir film numarası girdiniz, lütfen tekrar girin");
                filmNo = scanner.nextLong();
                scanner.nextLine();
            }

            for (Film film : user.getFilms()) {
                if(film.getId().equals(filmNo)){
                    user.getFilms().remove(film);
                    break;
                }
            }
            System.out.println("Listenizden çıkarmak istediğiniz başka bir film var mı?");
            System.out.println("Evet için e yazıp Enter'a basın. Hayır için h yazıp Enter'a basın.");
            String answer = scanner.nextLine();
            while (!answer.equalsIgnoreCase("e") && !answer.equalsIgnoreCase("h")) {
                System.out.println("Geçersiz bir harf girdiniz. Lütfen tekrar bir harf giriniz! ");
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("e")) {
                continue;
            }
            if (answer.equalsIgnoreCase("h")) {
                break;
            }
        }
    }

    private static User login(Scanner scanner, UserManager userManager) {
        System.out.println("Lütfen mevcut bir kullanıcıyla giriş yapınız:");
        System.out.println("E-mail:");
        String eMail = scanner.nextLine();
        System.out.println("Şifre:");
        String password = scanner.nextLine();
        for(User user : userManager.findUsers()){
            if(user.getEMail().equals(eMail) && user.getPassword().equals(password)){
                System.out.println(user.getName() + " başarıyla giriş yaptın.");
                return user;
            }
        }
        throw new RuntimeException("Böyle bir kullanıcı bulunmadı.");
    }

    private static List<User> createUsers(Scanner scanner) {
        List<User> users = new ArrayList<>();
        while (true) {
            System.out.println("Lütfen kullanıcı oluşturmak için kullanıcı bilgilerini giriniz:");
            System.out.println("Id: ");
            Long id = scanner.nextLong();
            scanner.nextLine();
            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("E-mail: ");
            String eMail = scanner.nextLine();
            System.out.println("Şifre: ");
            String password = scanner.nextLine();
            User user = new User(id, name, password, eMail, new ArrayList<>());
            users.add(user);
            System.out.println("Başka bir kullanıcı oluşturmak ister misiniz?");
            System.out.println("Evet için e yazıp Enter'a basın. Hayır için h yazıp Enter'a basın.");
            String answer = scanner.nextLine();
            while (!answer.equalsIgnoreCase("e") && !answer.equalsIgnoreCase("h")) {
                System.out.println("Geçersiz bir harf girdiniz. Lütfen tekrar bir harf giriniz!");
                answer = scanner.nextLine();

            }
            if (answer.equalsIgnoreCase("e")) {
                continue;
            }
            if (answer.equalsIgnoreCase("h")) {
                break;
            }
        }
        return users;
    }
}
