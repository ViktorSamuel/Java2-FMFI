package FDS;

public class FL {
    private final Integer head;
    private final FL tail;

    public FL(Integer head, FL tail) {
        this.head = head;
        this.tail = tail;
    }

    public Integer head() {return head;}
    public FL tail() {return tail;}
}
