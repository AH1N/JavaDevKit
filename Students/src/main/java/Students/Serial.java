package Students;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serial {

    private static final XmlMapper xmlMapper = new XmlMapper();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void serializeToBinFile(String fileName, Object object) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
            System.out.println("Сериализация в Файл");
        }
    }


    public static Student deserializeFromFile(String fileName) throws IOException, ClassNotFoundException {
        Student student;
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            student = (Student) objectInputStream.readObject();
            System.out.println("Сериализация в Файл Наоборот");
        }
        return student;
    }


    public static void serializeToJson(String fileName, Student student) {
        try {
            objectMapper.writeValue(new File(fileName), student);
            System.out.println("Сериализация в JSON");
            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializeToXML(String fileName, Student student) {
        try {
            xmlMapper.writeValue(new File(fileName), student);
            System.out.println("Сериализация в XML");
        } catch (IOException e) {
                e.printStackTrace();
        }
    }



    public static Student loadStudentJsonFile(String fileName) throws IOException, ClassNotFoundException {
        Student student = null;
        File file = new File(fileName);
        if (file.exists()) {
            student = objectMapper.readValue(file, Student.class);
        }
        return student;
    }

    public static Student loadStudentXMLFile(String fileName) {
        Student student = null;

        File file = new File(fileName);
        if (file.exists()) {
            try {
                student = xmlMapper.readValue(file, Student.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return student;
    }
}
