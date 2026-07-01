class Movie{
    private int availableSeats=5;
    public void bookSeat(){
        if(availableSeats>0){
            availableSeats--;
            System.out.println("Seat booked. Remaining: "+availableSeats);
        }else{
            System.out.println("No seats available.");
        }
    }
}
public class MovieTicketBooking{
    public static void main(String[] args){
        Movie m=new Movie();
        m.bookSeat();
        m.bookSeat();
    }
}
