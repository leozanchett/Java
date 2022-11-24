package wildcards;

public class Container<T> {
    private T data;

    public Container(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    @Override
    public String toString(){
        return "Container(data="+this.data+")";
    }
}
