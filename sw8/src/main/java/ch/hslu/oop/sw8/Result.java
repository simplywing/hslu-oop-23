package ch.hslu.oop.sw8;

public interface Result<T, E> {

    public void of(T obj);

    public void Ok(T obj);

    public void Err(E obj);

    public boolean isErr();

    public boolean isOk();

    public T unwrap();

    public T expect(String message);



    
}