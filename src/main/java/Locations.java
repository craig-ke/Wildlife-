import org.sql2o.Connection;

import java.util.List;

public class Locations {
    private int id;
    private  String name;

    public Locations(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static List<Locations> all(){
        try (Connection con=DB.sql2o.open()){
            String sql="SELECT * FROM locations";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Locations.class);
        }
    }

    public void save(){
        try (Connection con=DB.sql2o.open()){
            String sql="INSERT INTO locations (name) VALUES (:name)";
            if(name.equals("")){
                throw new IllegalArgumentException("All fields must be filled");
            }
            this.id=(int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void delete(){
        try (Connection con=DB.sql2o.open()){
            String sql="DELETE FROM locations WHERE id=:id";
            con.createQuery(sql)
                    .addParameter("id",this.id)
                    .executeUpdate();
        }
    }

    public static Locations find(int id){
        try (Connection con=DB.sql2o.open()){
            String sql="SELECT * FROM locations WHERE id=:id";
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Locations.class);
        }

    }
}
