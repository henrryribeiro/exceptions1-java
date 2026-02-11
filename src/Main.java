// testando um jeito muito ruim de criar exceções.

import model.entities.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException {
        //Scanne para ler os dados do usuario...
        Scanner sc = new Scanner(System.in);
        //ler datas...
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.println("Check-in date: (dd/MM/yyyy): ");
        Date chekIn = sdf.parse(sc.next());
        System.out.println("Check-out date: (dd/MM/yyyy): ");
        Date chekOut = sdf.parse(sc.next());

        //if (se) checkOut for depois de checkin imprima erro.
        if (!chekOut.after(chekIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date ");
        }//else (se não) imprima a reserva.
        else {
            Reservation reservetion = new Reservation(number, chekIn, chekOut);
            System.out.println("Reservation: " + reservetion);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            chekIn = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            chekOut = sdf.parse(sc.next());

            Date now = new Date();
            if (chekIn.before(now) || chekOut.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates ");
            }
            else if (!chekOut.after(chekIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date ");
            }
            else
                // metodo responsavel por atualizar a reserva.
                reservetion.updateDates(chekIn, chekOut);
            System.out.println("Reservation: " + reservetion);
        }
        sc.close();

    }
}



