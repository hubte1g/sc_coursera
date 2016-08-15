package progscala2.basicoop;

/**
 * Created by Kizmet4 on 8/8/2016.
 * p.246
 */
public class JPerson {
    private String name;
    private int    age;

    public JPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void   setName(String name) { this.name = name; }
    public String getName()            { return this.name; }

    public void setAge(int age) { this.age = age;  }
    public int  getAge()        { return this.age; }
}

// scala equivalent  // 'var' is also called an instance variable or attribute in OO languages
class Person(var name: String, var age: Int)

// using 'case' infers 'val' and makes it immutable
case class ImmutablePerson(name: String, age: Int)


