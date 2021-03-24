import java.util.List;

/**
 * @author CuiJunJie
 * @create 2021/3/23-10:02
 */
public class NestedIntegerImpl implements NestedInteger {
    private List<NestedInteger> list;
    private Integer value;

    public NestedIntegerImpl(List<NestedInteger> list, Integer value) {
        this.list = list;
        this.value = value;
    }

    @Override
    public boolean isInteger() {
        return list == null;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
