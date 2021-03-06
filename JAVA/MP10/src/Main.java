import javax.xml.crypto.Data;
import java.util.Date;
import java.time.LocalDateTime;

class HospitalAppointment{
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime dt;

    public HospitalAppointment(Doctor d, Patient p, LocalDateTime dt) {
        doctor = d;
        patient = p;
        this.dt = dt;
    }

    public String toString() {
        return dt.toString() + "\n"
                + doctor.toString() + "\n"
                + patient.toString();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getDateTime() {
        return dt;
    }

}

class Doctor{
    private String name;
    private String ID;
    Doctor(String ID, String name){
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    public String getID(){
        return ID;
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
    public String getName() {
        return name;
    }
    public String getID(){
        return ID;
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
        Doctor d = new Doctor("10", "Dr. Lim");
        Patient p = new Patient("cho");
        LocalDateTime d1 = LocalDateTime.of(2020, 5, 20, 13, 30, 0);
        LocalDateTime d2 = LocalDateTime.of(2020, 6, 20, 13, 30, 0);
        LocalDateTime d3 = LocalDateTime.of(2020, 7, 20, 13, 30, 0);
        // HospitalAppointment형 배열 생성
        HospitalAppointment[] has = new HospitalAppointment[3];
        // 병원 약속 생성 후 저장(같은 의사, 환자,
        // 날짜와 시간만 다름)
        has[0] = new HospitalAppointment(d, p, d1);
        has[1] = new HospitalAppointment(d, p, d2);
        has[2] = new HospitalAppointment(d, p, d3);
        // 화면에 출력
        for (HospitalAppointment apnt : has) {
            System.out.println(apnt);
        }
    }
}
