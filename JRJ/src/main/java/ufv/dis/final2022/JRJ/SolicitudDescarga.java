package ufv.dis.final2022.JRJ;

public class SolicitudDescarga {

    private String entity;
    private int id;

    public SolicitudDescarga() {
    }

    public SolicitudDescarga(String entity, int id) {
        this.entity = entity;
        this.id = id;

    }

    public String getEntity() {
        return entity;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SolicitudDescarga{" +
                "entity='" + entity + '\'' +
                ", id=" + id +
                '}';
    }
}
