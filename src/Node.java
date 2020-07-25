import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Node {

    private File folder;
    private List<Node> children;
    private long size;
    private long sizeLimit;
    private int level;

    public Node(File folder) {
        this.folder = folder;
        children = new ArrayList<>();
    }

    public Node(File folder, long sizeLimit) {
        this(folder);
        this.sizeLimit = sizeLimit;
    }

    public void setLimit(long sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    public File getFolder() {
        return folder;
    }

    public List<Node> getChildren() {
        return children;
    }


    public void addChild(Node node) {
        node.setLevel(level + 1);
        node.setLimit(sizeLimit);
        children.add(node);
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());
        builder.append(folder.getName()).append(" - ").append(size).append("\n");
        for (Node child : children) {
            if (child.getSize() < sizeLimit){
                continue;
            }
            builder.append("  ".repeat(level + 1)).append(child.toString());
        }
        return builder.toString();
    }
}
