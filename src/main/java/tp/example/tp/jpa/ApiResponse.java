package tp.example.tp.jpa;
// Je met T, pour que sa fonctionne avec touts types de données.
public class ApiResponse<T> {
    public int code;
    public T data;
    public String message;

    public ApiResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

}


