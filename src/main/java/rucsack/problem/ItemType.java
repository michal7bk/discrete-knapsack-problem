package rucsack.problem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemType implements Cloneable {

    protected String name;
    protected int n;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
