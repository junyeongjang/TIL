import javax.xml.crypto.Data;
import java.util.Date;

class HospitalAppointment{
    HospitalAppointment ap[];
    HospitalAppointment(String ID, String name){
        Patient p = new Patient(name);
        Doctor d = new Doctor(ID, name);
    }

}

class Doctor{
    private String name;
    private String ID;
    Doctor(String ID, String name){
        this.name = name;
        this.ID = ID;
    }
    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}

class Patient{
    private String name;
    private String ID;
    Patient(String name){
        this.name = name;
        this.ID = createID(name);
    }
    public String createID(String name){
        Date d = new Date();
        long t = d.getTime();
        this.ID = name+t;
        return (name+t);
    }
    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        HospitalAppointment[] ap = new HospitalAppointment[5];
        ap[0] = new HospitalAppointment("123","hi");
    }
}
