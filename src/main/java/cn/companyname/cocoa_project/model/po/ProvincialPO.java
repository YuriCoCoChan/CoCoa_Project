package cn.companyname.cocoa_project.model.po;

/**
 * @author CoCo
 */
public class ProvincialPO {
    private Integer provincialId;
    private String provincialName;

    public ProvincialPO() {
    }

    public ProvincialPO(Integer provincialId, String provincialName) {
        this.provincialId = provincialId;
        this.provincialName = provincialName;
    }

    public Integer getProvincialId() {
        return provincialId;
    }

    public void setProvincialId(Integer provincialId) {
        this.provincialId = provincialId;
    }

    public String getProvincialName() {
        return provincialName;
    }

    public void setProvincialName(String provincialName) {
        this.provincialName = provincialName;
    }

    @Override
    public String toString() {
        return "ProvincialPO{" +
                "provincialId=" + provincialId +
                ", provincialName='" + provincialName + '\'' +
                '}';
    }
}
