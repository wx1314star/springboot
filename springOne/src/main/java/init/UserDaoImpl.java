package init;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(String name) {
        System.out.println("name: " + name);
    }
}
