public class Student {

  private String Name;
  private int Age;
  private String Surname;
  private String Data;
 
  public Student(String name,String surname ,int age,String data) 
  {
    Name = name;
    Surname = surname;
    Age = age;
    Data=data;
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}
public String GetSurname() {return Surname;}
  public String GetData() {return Data;}

  
  public String ToString()
  {
    return Name + " "+ Surname +" "+ Integer.toString(Age)+" "+Data;
    
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 4) 
      return new Student("Parse Error","Parse Error", -1,"Parse Error");
    return new Student(data[0],data[1], Integer.parseInt(data[2]),data[3]);
    
  }
  public static boolean isValiDate(String data)
  {
    if(!data.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}"))
    {return false;}
 String[] parts = data.split("\\.");
    int dzien = Integer.parseInt(parts[0]);
    int mies = Integer.parseInt(parts[1]);
    int rok = Integer.parseInt(parts[2]);
  if(rok<1900 || rok>2024)
  {return false;}
    if(mies<1 || mies>12)
    {return false;}
    if(dzien<1 || dzien>31)
    {return false;}
  
  return true;
  
}
}