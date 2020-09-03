package di;

public class DeptServiceImpl implements DeptService {

    //需要DAO组件对象 依赖DAO组件
    private DeptDao deptDao;

    //公开的setter方法
    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public void save(String name) {
        deptDao.save(name);
        System.out.println("deptService: " + name);
    }
}
