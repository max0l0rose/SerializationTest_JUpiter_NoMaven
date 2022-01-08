import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;
//import org.junit.Assert;
//import org.junit.Test;

public class Main {

    @SneakyThrows
    public static void main(String[] args)
    {
        Person person = new Person();
        person.setAge(20);
        person.setName("Joe");

        Address a = new Address();
        a.setHouseNumber(1);

        Employee employee = new Employee();
        employee.setPerson(person);
        employee.setAddress(a);

        //person.setAddress(a);

        User user = new User("qqq");

        FileOutputStream fileOutputStream = new FileOutputStream("yourfile2.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(employee);
        objectOutputStream.writeObject(user);

        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("yourfile2.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Employee e2 = (Employee) objectInputStream.readObject();
        User user2 = (User) objectInputStream.readObject();
        objectInputStream.close();

        Assertions.assertTrue(e2.getPerson().getAge() == employee.getPerson().getAge());
        Assertions.assertTrue(e2.getAddress().getHouseNumber() == employee.getAddress().getHouseNumber());

        Assertions.assertTrue(Objects.equals(user.getName(), user2.getName()));
    }
}

