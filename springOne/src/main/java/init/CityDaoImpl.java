package init;

public class CityDaoImpl implements CityDao {
    @Override
    public void delete(String id) {
        System.out.println("删除的id是: " + id);
    }
}
