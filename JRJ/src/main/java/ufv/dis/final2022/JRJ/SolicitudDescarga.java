package ufv.dis.final2022.JRJ;

public class SolicitudDescarga {

    private String planets;
    private int id;

    public SolicitudDescarga() {
    }

    public SolicitudDescarga(String planet, int id) {
        this.planets = planet;
        this.id = id;

    }

    public String getPlanets() {
        return planets;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SolicitudDescarga{" +
                "planets='" + planets + '\'' +
                ", id=" + id +
                '}';
    }
}
