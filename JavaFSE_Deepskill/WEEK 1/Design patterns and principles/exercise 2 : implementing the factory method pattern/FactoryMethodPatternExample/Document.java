public interface Document {

    void open();
    void save();
    void close();

    default void process(){
        open();
        save();
        close();
    }
}