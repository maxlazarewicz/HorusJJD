import java.util.List;
import java.util.Optional;

public interface Structure {
    Optional findBlockByColor(String color);
    List findBlocksByMaterial(String material);
    int count(); //domyslnie publiczna metoda
}

