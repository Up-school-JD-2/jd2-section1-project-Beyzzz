import java.util.List;

public class UserManager {
    List<User> users;

    public UserManager(List<User> users) {
        this.users = users;
    }

    public List<User> findUsers() {
        return users;
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public void searchUser(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                System.out.println("Aradığınız kullanıcı :" + user.getName());
                return;
            }
        }
        throw new RuntimeException("Kullanıcı bulunmadı.");
    }

    public void removeUser(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                System.out.println("Silinen kullanıcı:" + user.getName());
                return;
            }
        }
        throw new RuntimeException("Bu numaraya sahip bir kullanıcı bulunamadı.");
    }
}
