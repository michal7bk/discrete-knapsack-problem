package rucsack.problem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item implements Cloneable {

    protected int id;
    protected int weight;
    protected int cost;
    protected ItemType itemType;
}
