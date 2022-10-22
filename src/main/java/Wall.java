import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private final List<Block> blocks = new LinkedList<>();

    public Wall(Block... blocks) {
        Arrays.stream(blocks).forEach(this::addBlock);
    }

    private void checkForNullParam(String param) {
        if(param == null) {
            throw new IllegalArgumentException(param + " is null!");
        }
    }

    @Override
    public Optional findBlockByColor(String color) {
        checkForNullParam(color);

        return Optional.of(findBlock(b -> color.equals(b.getColor())));
    }

    @Override
    public List findBlocksByMaterial(String material) {
        checkForNullParam(material);

        return findBlock(b -> material.equals(b.getMaterial())).toStream().collect(Collectors.toList());
    }

    @Override
    public int count() {
        return 0;
    }

    private Block findBlock(Predicate<Block> blockPredicate) {
        return blocks.stream()
                .flatMap(Block::toStream)
                .filter(blockPredicate)
                .findFirst()
                .orElse(null);
    }

    private void addBlock(Block block) {
        blocks.add(block);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return Objects.equals(blocks, wall.blocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blocks);
    }
}
