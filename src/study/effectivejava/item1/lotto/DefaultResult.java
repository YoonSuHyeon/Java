package study.effectivejava.item1.lotto;

public class DefaultResult implements Result {
    private String result;

    public DefaultResult(String result) {
        this.result = result;
    }

    @Override
    public String toText() {
        return "수동으로" + result;
    }
}
