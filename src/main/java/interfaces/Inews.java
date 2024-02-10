package interfaces;

import java.util.List;

public interface Inews <T>{
    void addnews(T t);
    void updatenews(T t);
    void deletenews(T t);
    List<T> getAlldata();
}
