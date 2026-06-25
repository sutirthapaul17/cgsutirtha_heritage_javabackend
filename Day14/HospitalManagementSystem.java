import java.util.ArrayList;

class Patient {
    private int patientId;
    private String patientName;
    private ArrayList<String> history;

    public Patient(int patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.history = new ArrayList<>();
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void addHistory(String record) {
        history.add(record);
    }

    public void displayHistory() {
        System.out.println("\nPatient History of " + patientName);

        if (history.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (String record : history) {
            System.out.println(record);
        }
    }
}

class Doctor {
    private int doctorId;
    private String doctorName;
    private String specialization;

    public Doctor(int doctorId, String doctorName, String specialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + doctorId +
                ", Name: " + doctorName +
                ", Specialization: " + specialization;
    }
}

class Appointment {

    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;

    public Appointment(Patient patient,
                       Doctor doctor,
                       String appointmentDate) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    @Override
    public String toString() {
        return "Patient: " + patient.getPatientName()
                + ", Doctor: " + doctor.getDoctorName()
                + ", Date: " + appointmentDate;
    }
}

class Hospital {
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;

    public Hospital() {
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void searchDoctor(String name) {

        for (Doctor doctor : doctors) {

            if (doctor.getDoctorName()
                    .equalsIgnoreCase(name)) {

                System.out.println("Doctor Found:");
                System.out.println(doctor);
                return;
            }
        }

        System.out.println("Doctor not found.");
    }
    public void bookAppointment(Patient patient,
                                Doctor doctor,
                                String date) {

        Appointment appointment =
                new Appointment(patient, doctor, date);

        appointments.add(appointment);

        patient.addHistory(
                "Appointment booked with Dr. "
                        + doctor.getDoctorName()
                        + " on "
                        + date
        );

        System.out.println("Appointment booked successfully.");
    }
    public void cancelAppointment(Patient patient,
                                  Doctor doctor) {

        for (int i = 0; i < appointments.size(); i++) {

            Appointment appointment = appointments.get(i);

            if (appointment.getPatient() == patient
                    && appointment.getDoctor() == doctor) {

                appointments.remove(i);

                patient.addHistory(
                        "Appointment cancelled with Dr. "
                                + doctor.getDoctorName()
                );

                System.out.println(
                        "Appointment cancelled successfully."
                );
                return;
            }
        }

        System.out.println("Appointment not found.");
    }
    public void displayAppointments() {

        System.out.println("\nAppointments:");

        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }
}

public class HospitalManagementSystem {

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Doctor d1 = new Doctor(
                101,
                "Sharma",
                "Cardiologist"
        );
        Doctor d2 = new Doctor(
                102,
                "Roy",
                "Dermatologist"
        );
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        Patient p1 = new Patient(
                1,
                "Rahul"
        );
        hospital.searchDoctor("Roy");
        hospital.bookAppointment(
                p1,
                d1,
                "10-07-2026"
        );
        hospital.displayAppointments();
        hospital.cancelAppointment(
                p1,
                d1
        );
        p1.displayHistory();
    }
}