package test;

import entity.Emp;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteXmlDemo {
    /**
     * 生成xml大致步骤：
     * <p>
     * 1: 创建一个Document对象，表示一个空的xml文档；
     * <p>
     * 2: 向Document中添加根元素；
     * <p>
     * 3: 按照目标xml文档的结构顺序向根元素中添加子元素来组建该结构；
     * <p>
     * 4: 创建XMLWriter；
     * <p>
     * 5: 设置低级流；
     * <p>
     * 6: 使用XMLWriter将Document写出来生成 该文档 。
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            List<Emp> list = new ArrayList<Emp>();
            list.add(new Emp(1, "鸣人", 25, "男", 4000));
            list.add(new Emp(2, "小樱", 27, "女", 6000));
            list.add(new Emp(3, "佐助", 28, "男", 7000));
            list.add(new Emp(4, "雏田", 22, "女", 8000));
            list.add(new Emp(5, "卡卡西", 26, "男", 90001));
            Document doc = DocumentHelper.createDocument();
            //生成根元素
            Element root = doc.addElement("list");
            for (Emp emp : list) {
                //根标签下添加子标签
                Element empEle = root.addElement("emp");
                //向emp标签中添加子标签name
                Element nameEle = empEle.addElement("name");
                //标签赋值
                nameEle.addText(emp.getName());
                Element ageEle = empEle.addElement("age");
                ageEle.addText(emp.getAge() + "");
                Element genderEle = empEle.addElement("gender");
                genderEle.addText(emp.getGender());
                Element salaryEle = empEle.addElement("salary");
                salaryEle.addText(emp.getSalary() + "");
                //添加属性
                empEle.addAttribute("id", emp.getId() + "");
            }
            //org.dom4j.XMLWriter
            XMLWriter writer = new XMLWriter(
                    OutputFormat.createPrettyPrint());

            /*
             * 向文件myemp.xml中写出数据
             */
            FileOutputStream fos = new FileOutputStream("/Users/wx/Documents/GitHub/springboot/springOne/src/main/resources/myemp.xml");
            writer.setOutputStream(fos);
            writer.write(doc);
            System.out.println("生成xml文件成功!");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
