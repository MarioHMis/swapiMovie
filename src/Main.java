import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieQuery query = new MovieQuery();
        System.out.println("Enter a Star Wars number movie title: ");

        try {
            var movieNumber = Integer.valueOf(sc.nextLine());
            Movie movie = query.searchMovie(movieNumber);
            System.out.println(movie);
            FileGenerator generator = new FileGenerator();
            generator.saveJson(movie);
        } catch (NumberFormatException e) {
            System.out.println("Invalid movie title "+ e.getMessage());
        }
        catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizing the application");
        }

    }
}
