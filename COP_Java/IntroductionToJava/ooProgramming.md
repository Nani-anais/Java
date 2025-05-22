# Java OOP Recap
An object oriented language that organizes programs as objects and classes.
Its a platform independent language that can run on any device that has a JVM  (Java Virtual Machine).
Object oriented programming (OOP), is a methodology or paradigm to design programs using entities such as objects and classes.
This design simplifies development and maintenance by these concepts:

## The main concepts are,
- Objects 
- Methods
- Classes
- Constructs
- Entity relationships
### The four principals are,
- Abstraction
- Encapsulation
- Inheritance
- Polymorphism

## Objects
Are **entities** that have behavior and can have physical or logical states 
They can be defined as an **instance** of a class.
    _Similar to pointers, an *instance* is a *reference* (constains the address) and takes up space in memory. 
For objects to communicate, they require these simple specifications:
- The **type** of message expected to recive.
- And the **type** of response to return.
Syntax to instantiate a new object:
```java []
ClassName ObjectName = new ClassName();
```

## Classes
Are templates that are used to create objects, define the object types, and methods.
A class can be defined as a *blueprint* where you can create individual objects.
Syntax:
```java []
public /*<-access modifier*/ class ClassName {...}
```

## Constructor
Are blocks of code similar to methods. However, they must abide a few different rules. These blocks of code contain **attributes** or **object characteristics**.
They are called when an instance of the objects is intantiated, and memory is allocated for the object.
    _It is a special type of method used for object **initialization**. It is called "construct" because this special method *establishes, or contrives the values* at the time of object creation.

When an object is intantiated, the compiler makes sure that constructors and all other inherited objects (sub-objects) are called. 
Synatx: 
```java []
public ConstructNameSameAsClassName() {
    this/*initialization keyword*/.variableName = attributeName; //defined variable
}
```
Example:
```java []
class Plant{//define the class name
    //define the attributes as variables
    String name;
    public Plant() { //construct
        this.name = name;//attributes
    }
}
```
There are two kinds of constructs:
- **default**, called automatically if none are provided and parameterless. The compiler inserts a default constructor on your befalf.
Example:
```java []
class Plant{//define the class name
    //variables
    public Plant(/*no parameters*/) {
        //default constructor made by compiler if none where provided
        super(); //default call with default behavior
    } 
}
Plant yourPlant = new Plant(/*no arguments*/); //intantiated as 'yourPlant'
```
- **parameterized**, called by an initializer (unique parameters) list. Used to provide *unique vales* to the *distinct object*.
Example:
```java []
class Plant{//define the class name
    //attributes
    Bool air;
    int light;
    double conditions;
    String classification;
    public Plant(int light, bool air, double conditions, String classification)
    //paramter list^^^ 
    {...}
}
```
_Regardless of the category, constructs are specified by these protocols:
- *must be the same name as the class.*
- must not have an explicit return type.
- cannot be abstract, static, final, or synchronized.
### Constructor VS Method 
Methods are simply functions that operate within a class. 
They contain blocks of functions that define different behaviors linked to objects. 
Similar to individual functions, methods:
- exposes behavior of an object
- *must have a return type*
- invoked explicitly
- not provided by the compiler 
- *name must be unique*
Example:
```java []
class Plant{//define the class name
    //attributes
    int light, temp;
    String name;
    public Plant(int light, int temp, String  name) { //constructor
        //attributes
        this.light = sun;
        this.temp = temp;
        this.name = name;
    }
    void display(){ //method, that does something
        System.out.println(name + ", requires this much sunlight: " + sun " hours" 
        "\nAnd thrives under in conditions within " + temp + " temperatures.");
    }
    public static void main (String arg[]){
        //instantiate a new Plant object
        Plant coconut_tree = new Plant(24, true, 90.00, "Coconut Tree");
        //invoke the diplay method attatched to the specified object
        coconut_tree.display();
    }
}
```

## Inheritance
Is which one object *aquires* or *obtain* all the properties and behaviors of the parent object. This represents a parent-child relationship.
You can create new classes that are built from exisiting classes.
_When you inherit from exisiting classes, you can resuse methods and feilds from the parent class.
*Terms*
- class: a group of objects with common properties
- subclass: a child class that inherits from parent class
    _- Other names: extended class, child class, derived class
- Superclass: parent class where a subclass inherits from
    _-Other names: base class, parent class
Syntax:
```java []
class SubclassName extends SuperClassName{...}
```
Theres several categories of inheritance:
### singleton
Inheritance from only one superclass.
    class B
       ^
    class A
Example:
```java []
class ClassA{...}
class ClassB extends ClassA{...}
public static void main(String args[]){
    ClassA ObjectNameA = new ClassA(); //in class A
    ClassB ObjectNameB = new ClassB(); //in class B
}
```
### multilevel
A chain of inheritance.
    class C
       ^
    class B
       ^
    class A
Example:
```java []
class ClassA{...}
class ClassB extends ClassA{...}
class ClassC extends ClassB{...}
public ststic void main(String args[]){
    ClassA ObjectNameA = new ClassA(); //in class A
    ClassB ObjectNameB = new ClassB(); //in class B
    ClassC ObjectNameC = new ClassC(); //in class C
}
```
### hierarchal
Many classes inherit from a single superclass.
        class A
        /     \
    class B class C
Example:
```java []
class ClassA{...}
class ClassB extends ClassA{...}
class ClassC extends ClassA{...}
```
### multiple
A class inherits from multiple superclasses. Not supported by java, but possible by using interfaces.
    class A class B
       \   /    \
    class C - class D
### Interface
An **interface** is an *abstract* type used to carry a group of related methods.
It is similar to a class, however:
- must include the interface keyword
- contains static mothods (empty bodies) and variables 
- does not contain constructors and cannot instantiate objects 
Syntax:
```java []
class SuperClassName implements InterfaceName{...}
```
Example:
```java []
interface Interface_A{...}
class ClassA implements Interface_A{...}
```
### Super();
A keyword to access a superclass (parent class) member from a subclass (child class). 
This keyword is primarily used to invoke the *default* constructor of the parent class, using `super()` ensures that:
- the parent class initialization logic is executed on the behalf of a class constructor not being present.
- overriding the parent class method 
- passing constructors to the subclass
- accessing superclass feilds from the subclass 
Example:
```java []
class ClassA{
    int thing;
    ClassA(int thing){
        this.thing = thing;
    }
    void methodA(int thing){
        thing = 1;
    }
}
class ClassB extends ClassA{
    ClassB(int thing){
        //calling classA constructor
        super(thing); //notice there is no data type!
    }
    void methodA(int thing){ //override 
        thing += thing;
    }
    void print(){
        System.out.println(thing); //1
        System.out.println(super.thing)//2
    }
}
```

## Polymorphism
The ability of an object to take on many forms. This usually occurs by overriding, when a parent class is used to refer to a child class object. Or overloading, by changing the paramter list.  
### Overloading
Achived by changing the number of arguments and/or data types the method accepts. 
Example:
```java []
//notice the method name is the exact same
public void myMethod(int a, int b){...};
public void myMethod(int a, int b, int c){...};
public void myMethod(int a, int b, double c, double d){...}; 
```
### Overriding
When a subclass has the *same method* declared in the parent class.
Rules:
- method must be the same name
- must have the same parameters 
- must be inherited
Example:
```java []
class ClassA{
    public void method1(){
        System.out.println("Method from class A.");
    }
}
class ClassB extends ClassA{
    public void method1(){
        System.out.println("Overriding ClassA's operation.");
    }
    public void method2(){//new method
        System.outprintln("This is a method from class B."); 
    }
}
public static void main(String args[]){
    ClassA Object_A = new ClassA();
    Object_A.method1(); 

    ClassA Object_B = new ClassB();
    Object_B.method1();
    Object_B.method2();
}
```
### Differences 
Overloading
- perforemed within a class
- paramater list must be unique 
- compile time polymorphasim 
Overriding
- only occures in a parent-child relationship
- paramter list must be exactly the same
- run time polymorphism

## Abstarction
The process of hiding implementation and only showing functionality.
It focuses on *what* an object does rather than *how*.
Abstract classes can be instantiated directly by defining a class with the *abstract* keyword and with interfaces.
Syntax:
```java []
abstract class ClassName{
    abstract void MethodName();
}
```
Example:
```java []
abstract class Plant{
    int air;
    int light;
    int energy;
    public Plant(int light, int air, int energy){
        this.light = light;
        this.air = air;
        this.energy = energy;
    }
    public int photosynthesize(int sunlight, int carbon_dioxide){//method
        carbon_dioxide + sunlight = energy;
        return energy;
    }
    abstract int produce();//absract methods
    abstract int pollinate();
}
```
**Generalization** is the process of extracting *shared characteristics* from two or more classes, and combining them into a *generalized* ***suberclass***
    _Shared characteristics may be methods, attributes, or associations.
Example:
```java []
class Plant{//Parent class
    int air;//variables
    int light;
    int energy;
    public Plant(int light, int air, int energy){//constructor
        this.light = light;//attributes
        this.air = air;
        this.energy = energy;
    }
    public int photosynthesize(int light, int air){//method
        air + light = energy;
        return energy;
    }
}
class F_Plant extends Plant{//child class
    int offspring;//variables
    public F_Plant(int light, int air, int offspring){//constructor
        super(light, air, energy);// call parent class constructor
        this.offspring = offspring;//attributes
    }
    public int produce(int energy, int pollen){//method
        if(energy > 60 && pollen > 40){
            for(int i = 0; i <= 7; i++){
                offspring += 3;
            }
        }
        return offspring;
    }
}
class M_Plant extends Plant{//another child class
    int pollen;//variables
    boolean pollinators;
    public M_Plant(int light, int air, int pollen){//constructor
        super(light, air, energy); //call parent constructor
        this.pollen = pollen;//attributes
        this.pollinators = pollinators;
    }
    public int pollinate(int energy, int pollen, Bool bees){//method
        if(bees){
            if(energy > 50){
                for(int i = 0; i < energy; i++){
                    pollen += 1;
                }
            }
        }
        return pollen;
    }
}
```
**Specialization** is the process of creating subclasses from existing classes. Especially if certain characteristics only apply to some objects.
Example:
```java []
class F_Plant extends Plant{//child female class of parent class Plant
    int offspring;//variables
    public F_Plant(int light, int air, int offspring){//constructor
        super(light, air, energy); //call parent constructor
        this.offspring = offspring;//attibutes
    }
    public int produce(int energy, int pollen){//method
        if(energy > 60 && pollen > 40){
            for(int i = 0; i <= 7; i++){
                offspring += 3;
            }
        }
        return offspring;
    }
}
class SeedBearing extends F_Plant{//a more specilized object of female plant
    int seeds;
    public SeedBearing(int offspring, int seeds){
        super(light, air, energy, offspring);//call parent constructor
        this.seeds = seeds;
    }
    public int produce(int energy, int pollen){//override the method
        if(energy > 60 && pollen > 40){
            for(int i = 0; i <= 7; i++){
                seeds += 3;
            }
        }
        return seeds;
    }
}
class SporeBearing extends F_Plant{//a more specialized object of female plant
    int spores;
    public SporeBearing(int offspring, int spores){
        super(light, air, energy, offspring);//call parent constructor
        this.spores = spores;
    }
    public int produce(int energy, int pollen){//override the method
        if(energy > 60 && pollen > 40){
            for(int i = 0; i <= 7; i++){
                spores += 3;
            }
        }
        return spores;
    }
}
```

## Encapsulation:
A process of wrapping code together into a single unit.
We do this by making a class *private* and employ **getter** and **setter** methods to modify it. This hides and gives us control over the data.
    _Access modifieres specifies the *scope* of a data member, method, constructor, or class.
Categories and thier access:
- private
    _Within the class
- default
    _Within the class
    _within the package/file
- protected
    _Within the class
    _Within the package/file
    _Outside the package/file by a subclass only
- public
    _Within the class
    _Within the package/file
    _Outside the package/file by subclass
    _Outside the package/file
Example:
```java []
public class Person{
    private /*access modifier*/ String name;
    public String getName(){ //getter (read only)
        return name;
    }
    public void setName(){ //setter (write only)
        this.name = name;
    }
}
class TestPerson{
    public static void main(String main args[]){
        Person personA = new Person(); //intantiate a new person object
        personA.setName("Steve"); //give them a name
        System.out.println(personA.getName()); //invoke getName method linked to personA
    }
}
```