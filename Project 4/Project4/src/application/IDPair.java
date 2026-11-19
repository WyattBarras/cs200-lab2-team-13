package application;

import java.util.Objects;

/*
 * Pair class to implement  id/password checking 
 * equals() not strictly necessary, but included for robustness
 * hashCode() main method of comparing IDPair objects for equality
 * */

public class IDPair<T1, T2> {
    private final T1 id;
    private final T2 password;

    public IDPair(T1 id, T2 password) {
        this.id = id;
        this.password = password;
    }

    public T1 getID() { return id; }
    public T2 getPassword() { return password; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IDPair<?, ?> pair)) return false;
        return Objects.equals(id, pair.id) && Objects.equals(password, pair.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password);
    }

	@Override
	public String toString() {
		return "IDPair [id=" + id + ", password=" + password + "]";
	}
}
