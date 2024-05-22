/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
  public static void main(String[] args) {

    try {

      Service s = new Service();
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


      while(true) {
        System.out.println("Podaj opcje: ");
        System.out.println("1-dodaj studenta, 2-zakoncz, 3-wypisz wszystkich studentow" );
        int numer = Integer.parseInt(reader.readLine());

        switch(numer) {
          case 1: {
            System.out.println("Podaj imie studenta: ");
            String name = reader.readLine();
            System.out.println("Podaj nazwisko studenta: ");
            String surname = reader.readLine();
            System.out.println("Podaj wiek studenta: ");
            int age = Integer.parseInt(reader.readLine());
            System.out.println("Podaj date urodzenia studenta: ");
            String data = reader.readLine();
            if(!Student.isValiDate(data)) {
              System.out.println("Niepoprawna data");
              break;
            }
            s.addStudent(new Student(name, surname, age, data));
            break;
          }
          case 2: {
            System.out.println("zły wybór");
            return;
          }
          case 3: {
            var students = s.getStudents();
            for(Student current : students) {
              System.out.println(current.ToString());
            }
            break;
          }  
        }
      }
    } catch (IOException e) {
      System.out.println("I/O ERROR: "+ e.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("INVALID TYPE ERROR");
    }
  }
}