package di;

public class DeptDaoImpl implements DeptDao {
    @Override
    public void save(String name) {
        System.out.println("Dao 姓名是：" + name);
    }
}
