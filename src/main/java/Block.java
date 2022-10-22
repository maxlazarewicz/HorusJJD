import java.util.stream.Stream;

public interface Block {
    String getColor();
    String getMaterial();

    Stream<Block> toStream();
}
