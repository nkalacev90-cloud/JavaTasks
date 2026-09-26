package JavaTask;

public class User {
    private String name;
    private String email;
    private int age;

    public void setName(String name){
        if (name == null){
            this.name = "Не указано";
        }
        else{
            this.name = name;
        }

    }
    public String getName(){
        return this.name;
    }

    public void setEmail(String email){
        if (email == null){
            this.email = "Не указано";
        }
        else{
            this.email = email;
        }

    }
    public String getEmail(){
        return this.email;
    }

    public void setAge(int age){
        if (age < 1){
            this.age = 0;
        }
        else{
            this.age = age;
        }

    }
    public int getAge(){
        return this.age;
    }
}
