package Students;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

import static Students.Serial.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


 /*
        1)Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
        2)Обеспечьте поддержку сериализации для этого класса.
        3)Создайте объект класса Student и инициализируйте его данными.
        4)Сериализуйте этот объект в файл.
        5)Десериализуйте объект обратно в программу из файла.
        6)Выведите все поля объекта, включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.
        7) Выполнить задачу 1 используя другие типы сериализаторов: (в xml и json документы)
               - xml
               - json документ
         */

        System.out.println("Hello Serializeble");

        Student student = new Student("Name", 346, 4.1);

//GPA  - transient. По этому не учавствует в сериализации, то есть не попадает в файл "SerialfileName.bin" и не выгружается из него соответственно

        serializeToBinFile("SerialfileName.bin", student);
        serializeToJson("SerialfileJSON.json", student);
        serializeToXML("SerialfileXML.xml", student);

        System.out.println(deserializeFromFile("SerialfileName.bin").toString() + "  Тут не могу разобраться");
        System.out.println(loadStudentJsonFile("SerialfileJSON.json").toString());
        System.out.println(loadStudentXMLFile("SerialfileXML.xml").toString());


    }
}
