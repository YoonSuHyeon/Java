package study.effectivejava.item1.lotto;

public class AutoResult implements Result {
    private String result;

    public AutoResult(String result) {
        this.result = result;
    }

    @Override
    public String toText() {
        return "μλμΌλ‘" + result;
    }
}
