import com.google.gson.annotations.SerializedName;

public class crypto {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return this.name +" | " +this.value;
    }
    private String name;
    private double value;


}
