package lwq.pojo;

public class Sort {
    Integer sort_id;
    String sort_name;

    public Integer getSort_id() {
        return sort_id;
    }

    public void setSort_id(Integer sort_id) {
        this.sort_id = sort_id;
    }

    public String getSort_name() {
        return sort_name;
    }

    public void setSort_name(String sort_name) {
        this.sort_name = sort_name;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sort_id=" + sort_id +
                ", sort_name='" + sort_name + '\'' +
                '}';
    }
}
