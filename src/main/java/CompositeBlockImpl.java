import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class CompositeBlockImpl extends BlockImpl implements CompositeBlock {
    private List<Block> blocks = new LinkedList<>();

    public CompositeBlockImpl(String color, String material) {
        super(color, material);
    }
    @Override
    public List<Block> getBlocks() {
        return Collections.unmodifiableList(blocks);
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    @Override
    public Stream<Block> toStream() {
        return Stream.concat(
                super.toStream(),
                blocks.stream().flatMap(Block::toStream)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompositeBlockImpl that = (CompositeBlockImpl) o;
        return Objects.equals(blocks, that.blocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), blocks);
    }
}
