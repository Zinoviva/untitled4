import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private String name; //Каждый человек обязан иметь имя, причём с момента создания объекта изменить его нельзя.
    private String surname; //Каждый человек обязан иметь фамилию, причём с момента создания объекта изменить её нельзя.
    private OptionalInt age; //возраст-создаем как коробку
    private String city; //Текущий город жительства

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();//кладем пустую коробку
    }

    public Person(String name, String surname, int age) {  //не забыть тут переменная инт у возраста
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age); //кладем коробку в которой будет лежать возраст
    }

    public boolean hasAge() {
        return age.isPresent();  //возвращаем ответ на вопрос не пуста ли коробка
    }

    public OptionalInt getAge() {
        return age; //возвращаем коробку
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean hasAddress() { //метод boolean hasAddress() должен вернуть true если адрес известен, иначе - false
        return city != null;  //если значение присутствует - вернет true
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", town=" + getCity() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)  //фамилия будет как у нас
                .setCity(city)  //город будет тот же самый как у нас
                .setAge(0);
    }  //метод для получения полузаполненного билдера для ребёнка в класс Person
    // а именно: с уже заполненными фамилией (родительской), возрастом и текущим городом жительства (родительским).
}