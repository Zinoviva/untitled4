public class PersonBuilder {
    private String name; //Каждый человек обязан иметь имя, причём с момента создания объекта изменить его нельзя.
    private String surname; //Каждый человек обязан иметь фамилию, причём с момента создания объекта изменить её нельзя.
    private int age = -1; //возраст
    private String city; //Текущий город жительства


    public String getName() {
        return name;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getAge() {
        return age;
    }

    public PersonBuilder setAge(int age) { //выкинуть ошибку IllegalArgumentException недопустимого значения
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Ошибка! Возраст должен быть от 0 до 100, а введено: " + age);
        }
        this.age = age;
        return this;
    }

    public String getCity() {
        return city;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public Person build() {  //выкинуть ошибку IllegalStateException недопустимого состояния
        if (name == null) {
            throw new IllegalStateException("Ошибка! Имя является обязательным");
        }
        if (surname == null) {
            throw new IllegalStateException("Ошибка! Фамилия является обязательным");
        }
        //если возраст равен -1,то создаем человека с именем и фамилией, иначе: с именем,фамилией,возрастом
        Person person = age == -1 ? new Person(name,surname) : new Person(name,surname,age);
        if (city != null){  //если город у нас был, выставляем город
            person.setCity(city);
        }
        return person;
    }
}

