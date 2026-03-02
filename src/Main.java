import com.veterinaria.dao.MascotaDAO;
import com.veterinaria.model.Mascota;

public class Main {
    public static void main(String[] args) {

        MascotaDAO dao = new MascotaDAO();

        Mascota m1 = new Mascota("Max", "Perro", "Pastor Alemán", 5, "Maria Clara");
        Mascota m2 = new Mascota("Luna", "Gato", "persa", 2, "Alejandro");
        Mascota m3 = new Mascota("Doky", "Perro", "Crillo", 4, "Andrea");
        Mascota m4 = new Mascota("Nala", "Gato", "Persa", 3, "Luis");

        dao.insertar(m1);
        dao.insertar(m2);
        dao.insertar(m3);
        dao.insertar(m4);
    }
}
