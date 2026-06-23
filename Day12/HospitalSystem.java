public class HospitalSystem {
    public static void fetchPatient(String id) {
        try {
            if (id == null) throw new NullPointerException("Patient ID is null");
            int numId = Integer.parseInt(id);  // May throw NumberFormatException
            if (numId < 0) throw new IllegalArgumentException("ID cannot be negative");
            System.out.println("Fetching patient: " + numId);
        } catch (NullPointerException e) {
            System.out.println("No ID provided: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Business rule error: " + e.getMessage());
        } finally {
            System.out.println("-- Audit log: access attempt recorded --");
        }
    }

    public static void main(String[] args) {
        fetchPatient("P102");   // NumberFormatException
        fetchPatient(null);      // NullPointerException
        fetchPatient("-5");     // IllegalArgumentException
    }
}

