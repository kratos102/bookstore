package group2it81.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Collection;


@Entity
@Table (name = "role")
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;


    @Column (name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Collection<NhanVien> nhanViens;

    public Collection<NhanVien> getNhanViens() {
        return this.nhanViens;
    }

    public void setNhanViens(Collection<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }

    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
}
